package io.jiogram.handler;

import io.jiogram.annotation.*;
import io.jiogram.dispatcher.EventObserver;
import io.jiogram.dispatcher.EventType;
import io.jiogram.dispatcher.Router;
import io.jiogram.filter.Filter;
import io.jiogram.filter.Filters;
import io.jiogram.filter.NamedState;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.MethodIntrospector;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.core.annotation.OrderUtils;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Spring {@link BeanPostProcessor} that scans beans annotated with
 * {@link TelegramController} and registers their annotated handler methods
 * on the provided {@link Router}.
 * <p>
 * Handlers are collected while beans are created and registered once all singletons exist,
 * so the matching order does not depend on bean creation order. For each event type the
 * first handler whose filters pass wins, in this order:
 * <ol>
 *   <li>{@link Order @Order} on the method, else on the controller class (lower first)</li>
 *   <li>{@link Command} handlers, then handlers with other filters ({@link StateFilter},
 *       callback data), then catch-all handlers without any. So a command still works while a
 *       state handler waits for plain text, e.g. {@code /cancel} or {@code /register} sent
 *       while a form expects a name is not swallowed as the name.</li>
 *   <li>controller class name, then method name</li>
 * </ol>
 */
public class HandlerRegistry implements BeanPostProcessor, SmartInitializingSingleton, DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(HandlerRegistry.class);

    private static final Comparator<Registration> MATCHING_ORDER = Comparator
            .comparingInt((Registration r) -> r.order())
            .thenComparingInt(Registration::specificity)
            .thenComparing(Registration::sortKey);

    /** {@link Registration#specificity()} ranks: lower is tried first within one @Order. */
    private static final int COMMAND = 0;
    private static final int FILTERED = 1;
    private static final int CATCH_ALL = 2;

    /**
     * Handler annotations and the observer each one registers on. Message-like events also
     * honour {@link Command}.
     */
    private static final List<Binding> BINDINGS = List.of(
            new Binding(OnMessage.class, EventType.MESSAGE, true),
            new Binding(OnEditedMessage.class, EventType.EDITED_MESSAGE, true),
            new Binding(OnChannelPost.class, EventType.CHANNEL_POST, true),
            new Binding(OnEditedChannelPost.class, EventType.EDITED_CHANNEL_POST, true),
            new Binding(OnBusinessMessage.class, EventType.BUSINESS_MESSAGE, true),
            new Binding(OnEditedBusinessMessage.class, EventType.EDITED_BUSINESS_MESSAGE, true),
            new Binding(OnCallbackQuery.class, EventType.CALLBACK_QUERY, false),
            new Binding(OnInlineQuery.class, EventType.INLINE_QUERY, false),
            new Binding(OnChosenInlineResult.class, EventType.CHOSEN_INLINE_RESULT, false),
            new Binding(OnShippingQuery.class, EventType.SHIPPING_QUERY, false),
            new Binding(OnPreCheckoutQuery.class, EventType.PRE_CHECKOUT_QUERY, false),
            new Binding(OnPurchasedPaidMedia.class, EventType.PURCHASED_PAID_MEDIA, false),
            new Binding(OnPoll.class, EventType.POLL, false),
            new Binding(OnPollAnswer.class, EventType.POLL_ANSWER, false),
            new Binding(OnMyChatMember.class, EventType.MY_CHAT_MEMBER, false),
            new Binding(OnChatMember.class, EventType.CHAT_MEMBER, false),
            new Binding(OnChatJoinRequest.class, EventType.CHAT_JOIN_REQUEST, false),
            new Binding(OnBusinessConnection.class, EventType.BUSINESS_CONNECTION, false),
            new Binding(OnDeletedBusinessMessages.class, EventType.DELETED_BUSINESS_MESSAGES, false),
            new Binding(OnMessageReaction.class, EventType.MESSAGE_REACTION, false),
            new Binding(OnMessageReactionCount.class, EventType.MESSAGE_REACTION_COUNT, false),
            new Binding(OnChatBoost.class, EventType.CHAT_BOOST, false),
            new Binding(OnRemovedChatBoost.class, EventType.REMOVED_CHAT_BOOST, false),
            new Binding(OnManagedBot.class, EventType.MANAGED_BOT, false)
    );

    /** The event types that have a handler annotation; tests check that every one has. */
    static Set<EventType> boundEventTypes() {
        return BINDINGS.stream()
                .map(Binding::eventType)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(EventType.class)));
    }

    private final Supplier<? extends Router> routerSupplier;
    private @Nullable Router router;
    private final @Nullable Scheduler handlerScheduler;
    private final boolean ownsScheduler;
    private final List<Registration> pending = new ArrayList<>();
    private boolean singletonsInstantiated;

    /**
     * Creates a registry whose handler methods run on the thread that delivers the update.
     * Handler code must then not block.
     */
    public HandlerRegistry(Router router) {
        this(fixed(router), null, false);
    }

    /**
     * Creates a registry that looks the router up only when it registers the collected handlers.
     * Being a {@link BeanPostProcessor}, the registry is created before ordinary beans; a supplier
     * (e.g. an {@code ObjectProvider}) keeps the router bean from being created that early, where
     * it would miss other post-processors.
     */
    public HandlerRegistry(Supplier<? extends Router> router) {
        this(Objects.requireNonNull(router, "router must not be null"), null, false);
    }

    /**
     * Creates a registry whose handler methods run on the given scheduler. The caller keeps
     * ownership of the scheduler and disposes it.
     */
    public HandlerRegistry(Router router, Scheduler handlerScheduler) {
        this(fixed(router), Objects.requireNonNull(handlerScheduler, "handlerScheduler must not be null"), false);
    }

    private HandlerRegistry(Supplier<? extends Router> routerSupplier, @Nullable Scheduler handlerScheduler,
                            boolean ownsScheduler) {
        this.routerSupplier = routerSupplier;
        this.handlerScheduler = handlerScheduler;
        this.ownsScheduler = ownsScheduler;
    }

    /**
     * Creates a registry whose handler methods may block: on Java 21 and later each runs on a new
     * virtual thread, on older Java versions on a bounded elastic pool. The registry disposes its scheduler
     * when the container destroys it.
     */
    public static HandlerRegistry withVirtualThreads(Router router) {
        return withVirtualThreads(fixed(router));
    }

    /**
     * Like {@link #withVirtualThreads(Router)}, looking the router up lazily as
     * {@link #HandlerRegistry(Supplier)} does.
     */
    public static HandlerRegistry withVirtualThreads(Supplier<? extends Router> router) {
        Objects.requireNonNull(router, "router must not be null");
        return new HandlerRegistry(router, blockingScheduler(), true);
    }

    /**
     * Virtual threads when the runtime has them (Java 21+), found reflectively since this branch
     * compiles for Java 11; a bounded elastic pool otherwise.
     */
    private static Scheduler blockingScheduler() {
        try {
            Method factory = Executors.class.getMethod("newVirtualThreadPerTaskExecutor");
            return Schedulers.fromExecutorService((ExecutorService) factory.invoke(null), "jiogram-handler");
        } catch (NoSuchMethodException e) {
            return Schedulers.newBoundedElastic(Schedulers.DEFAULT_BOUNDED_ELASTIC_SIZE,
                    Schedulers.DEFAULT_BOUNDED_ELASTIC_QUEUESIZE, "jiogram-handler");
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Cannot create the virtual thread executor", e);
        }
    }

    private static Supplier<Router> fixed(Router router) {
        Objects.requireNonNull(router, "router must not be null");
        return () -> router;
    }

    /** Called with {@code pending} locked. */
    private Router router() {
        if (router == null) {
            router = Objects.requireNonNull(routerSupplier.get(), "router supplier returned null");
        }
        return router;
    }

    @Override
    public void destroy() {
        if (ownsScheduler && handlerScheduler != null) {
            handlerScheduler.dispose();
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> targetClass = AopUtils.getTargetClass(bean);
        if (AnnotationUtils.findAnnotation(targetClass, TelegramController.class) == null) {
            return bean;
        }

        log.debug("Scanning TelegramController: {}", targetClass.getName());
        int classOrder = OrderUtils.getOrder(targetClass, Ordered.LOWEST_PRECEDENCE);

        Map<Method, List<Binding>> handlerMethods = MethodIntrospector.selectMethods(targetClass,
                (MethodIntrospector.MetadataLookup<List<Binding>>) method -> {
                    List<Binding> bindings = BINDINGS.stream()
                            .filter(binding -> AnnotatedElementUtils.hasAnnotation(method, binding.annotation()))
                            .collect(Collectors.toList());
                    return bindings.isEmpty() ? null : bindings;
                });

        List<Registration> found = new ArrayList<>();
        handlerMethods.forEach((method, bindings) -> bindings.forEach(binding ->
                found.add(binding.registration(bean, targetClass, method, classOrder, handlerScheduler))));

        synchronized (pending) {
            if (singletonsInstantiated) {
                // A lazily created controller: everything else is registered already.
                found.stream().sorted(MATCHING_ORDER).forEach(registration -> registration.register(router()));
            } else {
                pending.addAll(found);
            }
        }
        return bean;
    }

    /**
     * Registers every collected handler in {@link #MATCHING_ORDER}.
     */
    @Override
    public void afterSingletonsInstantiated() {
        synchronized (pending) {
            if (!pending.isEmpty()) {
                Router target = router();
                pending.stream().sorted(MATCHING_ORDER).forEach(registration -> registration.register(target));
            }
            pending.clear();
            singletonsInstantiated = true;
        }
    }

    private static final class Binding {

        private final Class<? extends Annotation> annotation;
        private final EventType eventType;
        private final boolean supportsCommand;

        Binding(Class<? extends Annotation> annotation, EventType eventType, boolean supportsCommand) {
            this.annotation = annotation;
            this.eventType = eventType;
            this.supportsCommand = supportsCommand;
        }

        Class<? extends Annotation> annotation() {
            return annotation;
        }

        EventType eventType() {
            return eventType;
        }

        Registration registration(Object bean, Class<?> targetClass, Method method, int classOrder,
                                  @Nullable Scheduler scheduler) {
            List<Filter<Object>> filters = new ArrayList<>();
            Command command = supportsCommand ? AnnotatedElementUtils.findMergedAnnotation(method, Command.class) : null;
            if (command != null) {
                filters.add(castFilter(Filters.command(command.value())));
            }
            if (annotation == OnCallbackQuery.class) {
                OnCallbackQuery onCallback = AnnotatedElementUtils.findMergedAnnotation(method, OnCallbackQuery.class);
                if (!onCallback.data().isEmpty()) {
                    filters.add(castFilter(Filters.callbackData(onCallback.data())));
                }
                if (!onCallback.prefix().isEmpty()) {
                    filters.add(castFilter(Filters.callbackDataPrefix(onCallback.prefix())));
                }
            }
            StateFilter stateFilter = AnnotatedElementUtils.findMergedAnnotation(method, StateFilter.class);
            if (stateFilter != null) {
                filters.add(Filters.state(resolveStateName(stateFilter)));
            }

            // Invoke through the proxy (so AOP advice applies) on a method the proxy exposes.
            Method invocable = AopUtils.selectInvocableMethod(method, bean.getClass());
            Order methodOrder = AnnotatedElementUtils.findMergedAnnotation(method, Order.class);
            String sortKey = targetClass.getName() + "#" + method.getName()
                    + Arrays.toString(method.getParameterTypes());

            return new Registration(
                    eventType,
                    new HandlerAdapter<>(bean, invocable, eventClass(), scheduler),
                    List.copyOf(filters),
                    methodOrder != null ? methodOrder.value() : classOrder,
                    command != null ? COMMAND : filters.isEmpty() ? CATCH_ALL : FILTERED,
                    sortKey,
                    annotation.getSimpleName());
        }

        /**
         * Message and callback filters are only built for bindings whose event type matches them.
         */
        @SuppressWarnings("unchecked")
        private Filter<Object> castFilter(Filter<?> filter) {
            return (Filter<Object>) filter;
        }

        @SuppressWarnings("unchecked")
        private Class<Object> eventClass() {
            return (Class<Object>) eventType.eventClass();
        }
    }

    private static final class Registration {

        private final EventType eventType;
        private final Handler<Object> handler;
        private final List<Filter<Object>> filters;
        private final int order;
        private final int specificity;
        private final String sortKey;
        private final String annotationName;

        Registration(EventType eventType, Handler<Object> handler, List<Filter<Object>> filters, int order,
                     int specificity, String sortKey, String annotationName) {
            this.eventType = eventType;
            this.handler = handler;
            this.filters = filters;
            this.order = order;
            this.specificity = specificity;
            this.sortKey = sortKey;
            this.annotationName = annotationName;
        }

        int order() {
            return order;
        }

        int specificity() {
            return specificity;
        }

        String sortKey() {
            return sortKey;
        }

        @SuppressWarnings("unchecked")
        void register(Router router) {
            ((EventObserver<Object>) router.observer(eventType)).register(handler, filters);
            log.debug("Registered @{} handler {} (order {}, {} filter(s))",
                    annotationName, sortKey, order, filters.size());
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static String resolveStateName(StateFilter stateFilter) {
        if (stateFilter.enumClass() == StateFilter.NoState.class) {
            return stateFilter.value();
        }

        if (stateFilter.value().isBlank()) {
            throw new IllegalArgumentException("@StateFilter enum value must not be blank");
        }

        Class enumClass = stateFilter.enumClass().asSubclass(Enum.class);
        Enum<?> state = Enum.valueOf(enumClass, stateFilter.value());
        return NamedState.nameOf(state);
    }
}
