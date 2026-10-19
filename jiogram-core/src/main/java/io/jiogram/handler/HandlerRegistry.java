package io.jiogram.handler;

import io.jiogram.annotation.*;
import io.jiogram.dispatcher.EventObserver;
import io.jiogram.dispatcher.Router;
import io.jiogram.filter.Filter;
import io.jiogram.filter.Filters;
import io.jiogram.types.BusinessConnection;
import io.jiogram.types.BusinessMessagesDeleted;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.ChatBoostRemoved;
import io.jiogram.types.ChatBoostUpdated;
import io.jiogram.types.ChatJoinRequest;
import io.jiogram.types.ChatMemberUpdated;
import io.jiogram.types.ChosenInlineResult;
import io.jiogram.types.InlineQuery;
import io.jiogram.types.ManagedBotUpdated;
import io.jiogram.types.Message;
import io.jiogram.types.MessageReactionCountUpdated;
import io.jiogram.types.MessageReactionUpdated;
import io.jiogram.types.PaidMediaPurchased;
import io.jiogram.types.Poll;
import io.jiogram.types.PollAnswer;
import io.jiogram.types.PreCheckoutQuery;
import io.jiogram.types.ShippingQuery;
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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.function.Function;

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
 *   <li>handlers with filters ({@link Command}, {@link StateFilter}, callback data) before
 *       catch-all handlers without any</li>
 *   <li>controller class name, then method name</li>
 * </ol>
 */
public class HandlerRegistry implements BeanPostProcessor, SmartInitializingSingleton, DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(HandlerRegistry.class);

    private static final Comparator<Registration<?>> MATCHING_ORDER = Comparator
            .comparingInt((Registration<?> r) -> r.order())
            .thenComparing(r -> r.filters().isEmpty())
            .thenComparing(Registration::sortKey);

    /**
     * Handler annotations and the observer each one registers on. Message-like events also
     * honour {@link Command}.
     */
    private static final List<Binding<?>> BINDINGS = List.of(
            new Binding<>(OnMessage.class, Message.class, Router::messageObserver, true),
            new Binding<>(OnEditedMessage.class, Message.class, Router::editedMessageObserver, true),
            new Binding<>(OnChannelPost.class, Message.class, Router::channelPostObserver, true),
            new Binding<>(OnEditedChannelPost.class, Message.class, Router::editedChannelPostObserver, true),
            new Binding<>(OnBusinessMessage.class, Message.class, Router::businessMessageObserver, true),
            new Binding<>(OnEditedBusinessMessage.class, Message.class, Router::editedBusinessMessageObserver, true),
            new Binding<>(OnCallbackQuery.class, CallbackQuery.class, Router::callbackQueryObserver, false),
            new Binding<>(OnInlineQuery.class, InlineQuery.class, Router::inlineQueryObserver, false),
            new Binding<>(OnChosenInlineResult.class, ChosenInlineResult.class, Router::chosenInlineResultObserver, false),
            new Binding<>(OnShippingQuery.class, ShippingQuery.class, Router::shippingQueryObserver, false),
            new Binding<>(OnPreCheckoutQuery.class, PreCheckoutQuery.class, Router::preCheckoutQueryObserver, false),
            new Binding<>(OnPurchasedPaidMedia.class, PaidMediaPurchased.class, Router::purchasedPaidMediaObserver, false),
            new Binding<>(OnPoll.class, Poll.class, Router::pollObserver, false),
            new Binding<>(OnPollAnswer.class, PollAnswer.class, Router::pollAnswerObserver, false),
            new Binding<>(OnMyChatMember.class, ChatMemberUpdated.class, Router::myChatMemberObserver, false),
            new Binding<>(OnChatMember.class, ChatMemberUpdated.class, Router::chatMemberObserver, false),
            new Binding<>(OnChatJoinRequest.class, ChatJoinRequest.class, Router::chatJoinRequestObserver, false),
            new Binding<>(OnBusinessConnection.class, BusinessConnection.class, Router::businessConnectionObserver, false),
            new Binding<>(OnDeletedBusinessMessages.class, BusinessMessagesDeleted.class, Router::deletedBusinessMessagesObserver, false),
            new Binding<>(OnMessageReaction.class, MessageReactionUpdated.class, Router::messageReactionObserver, false),
            new Binding<>(OnMessageReactionCount.class, MessageReactionCountUpdated.class, Router::messageReactionCountObserver, false),
            new Binding<>(OnChatBoost.class, ChatBoostUpdated.class, Router::chatBoostObserver, false),
            new Binding<>(OnRemovedChatBoost.class, ChatBoostRemoved.class, Router::removedChatBoostObserver, false),
            new Binding<>(OnManagedBot.class, ManagedBotUpdated.class, Router::managedBotObserver, false)
    );

    private final Router router;
    private final @Nullable Scheduler handlerScheduler;
    private final boolean ownsScheduler;
    private final List<Registration<?>> pending = new ArrayList<>();
    private boolean singletonsInstantiated;

    /**
     * Creates a registry whose handler methods run on the thread that delivers the update.
     * Handler code must then not block.
     */
    public HandlerRegistry(Router router) {
        this(router, null, false);
    }

    /**
     * Creates a registry whose handler methods run on the given scheduler. The caller keeps
     * ownership of the scheduler and disposes it.
     */
    public HandlerRegistry(Router router, Scheduler handlerScheduler) {
        this(router, Objects.requireNonNull(handlerScheduler, "handlerScheduler must not be null"), false);
    }

    private HandlerRegistry(Router router, @Nullable Scheduler handlerScheduler, boolean ownsScheduler) {
        this.router = router;
        this.handlerScheduler = handlerScheduler;
        this.ownsScheduler = ownsScheduler;
    }

    /**
     * Creates a registry whose handler methods each run on a new virtual thread, so they may
     * block freely. The registry disposes its scheduler when the container destroys it.
     */
    public static HandlerRegistry withVirtualThreads(Router router) {
        Scheduler scheduler = Schedulers.fromExecutorService(
                Executors.newVirtualThreadPerTaskExecutor(), "jiogram-handler");
        return new HandlerRegistry(router, scheduler, true);
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

        Map<Method, List<Binding<?>>> handlerMethods = MethodIntrospector.selectMethods(targetClass,
                (MethodIntrospector.MetadataLookup<List<Binding<?>>>) method -> {
                    List<Binding<?>> bindings = BINDINGS.stream()
                            .filter(binding -> AnnotatedElementUtils.hasAnnotation(method, binding.annotation()))
                            .toList();
                    return bindings.isEmpty() ? null : bindings;
                });

        List<Registration<?>> found = new ArrayList<>();
        handlerMethods.forEach((method, bindings) -> bindings.forEach(binding ->
                found.add(binding.registration(router, bean, targetClass, method, classOrder, handlerScheduler))));

        synchronized (pending) {
            if (singletonsInstantiated) {
                // A lazily created controller: everything else is registered already.
                found.stream().sorted(MATCHING_ORDER).forEach(Registration::register);
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
            pending.stream().sorted(MATCHING_ORDER).forEach(Registration::register);
            pending.clear();
            singletonsInstantiated = true;
        }
    }

    private record Binding<E>(
            Class<? extends Annotation> annotation,
            Class<E> eventType,
            Function<Router, EventObserver<E>> observer,
            boolean supportsCommand) {

        Registration<E> registration(Router router, Object bean, Class<?> targetClass, Method method, int classOrder,
                                     @Nullable Scheduler scheduler) {
            List<Filter<E>> filters = new ArrayList<>();
            if (supportsCommand) {
                Command command = AnnotatedElementUtils.findMergedAnnotation(method, Command.class);
                if (command != null) {
                    filters.add(castFilter(Filters.command(command.value())));
                }
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

            return new Registration<>(
                    observer.apply(router),
                    new HandlerAdapter<>(bean, invocable, eventType, scheduler),
                    List.copyOf(filters),
                    methodOrder != null ? methodOrder.value() : classOrder,
                    sortKey,
                    annotation.getSimpleName());
        }

        /**
         * Message and callback filters are only built for bindings whose event type matches them.
         */
        @SuppressWarnings("unchecked")
        private Filter<E> castFilter(Filter<?> filter) {
            return (Filter<E>) filter;
        }
    }

    private record Registration<E>(
            EventObserver<E> observer,
            Handler<E> handler,
            List<Filter<E>> filters,
            int order,
            String sortKey,
            String annotationName) {

        void register() {
            observer.register(handler, filters);
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
        return state.getDeclaringClass().getSimpleName() + "." + state.name();
    }
}
