package io.jiogram.handler;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnCallbackQuery;
import io.jiogram.annotation.OnInlineQuery;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.StateFilter;
import io.jiogram.annotation.TelegramController;
import io.jiogram.dispatcher.Router;
import io.jiogram.filter.Filter;
import io.jiogram.filter.Filters;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.InlineQuery;
import io.jiogram.types.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;

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
            processOnCallbackQuery(bean, method);
            processOnInlineQuery(bean, method);
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
            filters.add(Filters.state(stateFilter.value()));
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
            filters.add(Filters.state(stateFilter.value()));
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
            filters.add(Filters.state(stateFilter.value()));
        }

        HandlerAdapter<InlineQuery> adapter = new HandlerAdapter<>(bean, method, InlineQuery.class);
        router.inlineQueryObserver().register(adapter, filters);

        log.debug("Registered @OnInlineQuery handler: {}.{} with {} filter(s)",
                bean.getClass().getSimpleName(), method.getName(), filters.size());
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
}
