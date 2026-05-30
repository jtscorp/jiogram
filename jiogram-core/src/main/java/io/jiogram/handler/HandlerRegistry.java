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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring {@link BeanPostProcessor} that scans beans annotated with
 * {@link TelegramController} and registers their annotated handler methods
 * on the provided {@link Router}.
 * <p>
 * Supports {@link OnMessage}, {@link OnCallbackQuery}, and {@link OnInlineQuery}
 * annotations, with optional {@link Command} and {@link StateFilter} qualifiers.
 */
public class HandlerRegistry implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(HandlerRegistry.class);

    private final Router router;

    public HandlerRegistry(Router router) {
        this.router = router;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // Handle CGLIB proxied beans: check the original class
        Class<?> beanClass = bean.getClass();
        TelegramController annotation = AnnotationUtils.findAnnotation(beanClass, TelegramController.class);

        if (annotation == null) {
            return bean;
        }

        log.debug("Scanning TelegramController: {}", beanClass.getName());

        // Use the target class (not proxy) for method scanning
        Class<?> targetClass = getTargetClass(beanClass);

        for (Method method : targetClass.getDeclaredMethods()) {
            processOnMessage(bean, method);
            processMessageEvent(bean, method, OnEditedMessage.class, Message.class, router.editedMessageObserver());
            processMessageEvent(bean, method, OnChannelPost.class, Message.class, router.channelPostObserver());
            processMessageEvent(bean, method, OnEditedChannelPost.class, Message.class, router.editedChannelPostObserver());
            processMessageEvent(bean, method, OnBusinessMessage.class, Message.class, router.businessMessageObserver());
            processMessageEvent(bean, method, OnEditedBusinessMessage.class, Message.class, router.editedBusinessMessageObserver());
            processOnCallbackQuery(bean, method);
            processOnInlineQuery(bean, method);
            processEvent(bean, method, OnChosenInlineResult.class, ChosenInlineResult.class, router.chosenInlineResultObserver());
            processEvent(bean, method, OnShippingQuery.class, ShippingQuery.class, router.shippingQueryObserver());
            processEvent(bean, method, OnPreCheckoutQuery.class, PreCheckoutQuery.class, router.preCheckoutQueryObserver());
            processEvent(bean, method, OnPurchasedPaidMedia.class, PaidMediaPurchased.class, router.purchasedPaidMediaObserver());
            processEvent(bean, method, OnPoll.class, Poll.class, router.pollObserver());
            processEvent(bean, method, OnPollAnswer.class, PollAnswer.class, router.pollAnswerObserver());
            processEvent(bean, method, OnMyChatMember.class, ChatMemberUpdated.class, router.myChatMemberObserver());
            processEvent(bean, method, OnChatMember.class, ChatMemberUpdated.class, router.chatMemberObserver());
            processEvent(bean, method, OnChatJoinRequest.class, ChatJoinRequest.class, router.chatJoinRequestObserver());
            processEvent(bean, method, OnBusinessConnection.class, BusinessConnection.class, router.businessConnectionObserver());
            processEvent(bean, method, OnDeletedBusinessMessages.class, BusinessMessagesDeleted.class, router.deletedBusinessMessagesObserver());
            processEvent(bean, method, OnMessageReaction.class, MessageReactionUpdated.class, router.messageReactionObserver());
            processEvent(bean, method, OnMessageReactionCount.class, MessageReactionCountUpdated.class, router.messageReactionCountObserver());
            processEvent(bean, method, OnChatBoost.class, ChatBoostUpdated.class, router.chatBoostObserver());
            processEvent(bean, method, OnRemovedChatBoost.class, ChatBoostRemoved.class, router.removedChatBoostObserver());
            processEvent(bean, method, OnManagedBot.class, ManagedBotUpdated.class, router.managedBotObserver());
        }

        return bean;
    }

    private void processOnMessage(Object bean, Method method) {
        OnMessage onMessage = AnnotationUtils.findAnnotation(method, OnMessage.class);
        if (onMessage == null) {
            return;
        }

        List<Filter<Message>> filters = new ArrayList<>();

        // Check for @Command annotation
        Command command = AnnotationUtils.findAnnotation(method, Command.class);
        if (command != null) {
            filters.add(Filters.command(command.value()));
        }

        // Check for @StateFilter annotation
        StateFilter stateFilter = AnnotationUtils.findAnnotation(method, StateFilter.class);
        if (stateFilter != null) {
            filters.add(Filters.state(resolveStateName(stateFilter)));
        }

        HandlerAdapter<Message> adapter = new HandlerAdapter<>(bean, method, Message.class);
        router.messageObserver().register(adapter, filters);

        log.debug("Registered @OnMessage handler: {}.{} with {} filter(s)",
                bean.getClass().getSimpleName(), method.getName(), filters.size());
    }

    private void processOnCallbackQuery(Object bean, Method method) {
        OnCallbackQuery onCallback = AnnotationUtils.findAnnotation(method, OnCallbackQuery.class);
        if (onCallback == null) {
            return;
        }

        List<Filter<CallbackQuery>> filters = new ArrayList<>();

        if (!onCallback.data().isEmpty()) {
            filters.add(Filters.callbackData(onCallback.data()));
        }

        if (!onCallback.prefix().isEmpty()) {
            filters.add(Filters.callbackDataPrefix(onCallback.prefix()));
        }

        // Check for @StateFilter annotation
        StateFilter stateFilter = AnnotationUtils.findAnnotation(method, StateFilter.class);
        if (stateFilter != null) {
            filters.add(Filters.state(resolveStateName(stateFilter)));
        }

        HandlerAdapter<CallbackQuery> adapter = new HandlerAdapter<>(bean, method, CallbackQuery.class);
        router.callbackQueryObserver().register(adapter, filters);

        log.debug("Registered @OnCallbackQuery handler: {}.{} with {} filter(s)",
                bean.getClass().getSimpleName(), method.getName(), filters.size());
    }

    private void processOnInlineQuery(Object bean, Method method) {
        OnInlineQuery onInline = AnnotationUtils.findAnnotation(method, OnInlineQuery.class);
        if (onInline == null) {
            return;
        }

        List<Filter<InlineQuery>> filters = new ArrayList<>();

        // Check for @StateFilter annotation
        StateFilter stateFilter = AnnotationUtils.findAnnotation(method, StateFilter.class);
        if (stateFilter != null) {
            filters.add(Filters.state(resolveStateName(stateFilter)));
        }

        HandlerAdapter<InlineQuery> adapter = new HandlerAdapter<>(bean, method, InlineQuery.class);
        router.inlineQueryObserver().register(adapter, filters);

        log.debug("Registered @OnInlineQuery handler: {}.{} with {} filter(s)",
                bean.getClass().getSimpleName(), method.getName(), filters.size());
    }

    private void processMessageEvent(
            Object bean,
            Method method,
            Class<? extends Annotation> annotationType,
            Class<Message> eventType,
            EventObserver<Message> observer) {
        if (AnnotationUtils.findAnnotation(method, annotationType) == null) {
            return;
        }

        List<Filter<Message>> filters = new ArrayList<>();
        Command command = AnnotationUtils.findAnnotation(method, Command.class);
        if (command != null) {
            filters.add(Filters.command(command.value()));
        }
        StateFilter stateFilter = AnnotationUtils.findAnnotation(method, StateFilter.class);
        if (stateFilter != null) {
            filters.add(Filters.state(resolveStateName(stateFilter)));
        }

        HandlerAdapter<Message> adapter = new HandlerAdapter<>(bean, method, eventType);
        observer.register(adapter, filters);
        log.debug("Registered @{} handler: {}.{} with {} filter(s)",
                annotationType.getSimpleName(), bean.getClass().getSimpleName(), method.getName(), filters.size());
    }

    private <E> void processEvent(
            Object bean,
            Method method,
            Class<? extends Annotation> annotationType,
            Class<E> eventType,
            EventObserver<E> observer) {
        if (AnnotationUtils.findAnnotation(method, annotationType) == null) {
            return;
        }

        List<Filter<E>> filters = new ArrayList<>();
        StateFilter stateFilter = AnnotationUtils.findAnnotation(method, StateFilter.class);
        if (stateFilter != null) {
            filters.add(Filters.state(resolveStateName(stateFilter)));
        }

        HandlerAdapter<E> adapter = new HandlerAdapter<>(bean, method, eventType);
        observer.register(adapter, filters);
        log.debug("Registered @{} handler: {}.{} with {} filter(s)",
                annotationType.getSimpleName(), bean.getClass().getSimpleName(), method.getName(), filters.size());
    }

    /**
     * Resolves the target class from a potentially CGLIB-proxied class.
     * CGLIB proxies create subclasses, so we check the superclass.
     */
    private Class<?> getTargetClass(Class<?> beanClass) {
        // CGLIB proxy class names contain "$$" (e.g., MyClass$$EnhancerBySpringCGLIB$$xxx)
        if (beanClass.getName().contains("$$")) {
            return beanClass.getSuperclass();
        }
        return beanClass;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private String resolveStateName(StateFilter stateFilter) {
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
