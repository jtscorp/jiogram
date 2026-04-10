package io.jiogram.handler;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.types.TelegramMethod;
import reactor.core.publisher.Mono;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Adapts an annotated controller method into a {@link Handler}.
 * <p>
 * Resolves method parameters from the UpdateContext:
 * <ul>
 *   <li>Event type (Message, CallbackQuery, InlineQuery) - resolved from event parameter</li>
 *   <li>{@link Bot} - resolved from context.bot()</li>
 *   <li>{@link UpdateContext} - resolved directly</li>
 * </ul>
 * <p>
 * Handles return types:
 * <ul>
 *   <li>{@code Mono<Void>} or {@code Mono<?>} - subscribed directly</li>
 *   <li>{@code TelegramMethod<?>} - auto-executed via bot.execute()</li>
 *   <li>{@code void} or {@code null} - treated as Mono.empty()</li>
 * </ul>
 *
 * @param <E> the event type
 */
public class HandlerAdapter<E> implements Handler<E> {

    private final Object bean;
    private final Method method;
    private final Class<E> eventType;

    public HandlerAdapter(Object bean, Method method, Class<E> eventType) {
        this.bean = bean;
        this.method = method;
        this.eventType = eventType;
        this.method.setAccessible(true);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Mono<Void> handle(E event, UpdateContext context) {
        try {
            Object[] args = resolveArguments(event, context);
            Object result = method.invoke(bean, args);
            return adaptReturnValue(result, context);
        } catch (InvocationTargetException e) {
            return Mono.error(e.getCause() != null ? e.getCause() : e);
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    private Object[] resolveArguments(E event, UpdateContext context) {
        Parameter[] params = method.getParameters();
        Object[] args = new Object[params.length];

        for (int i = 0; i < params.length; i++) {
            Class<?> paramType = params[i].getType();

            if (eventType.isAssignableFrom(paramType)) {
                args[i] = event;
            } else if (Bot.class.isAssignableFrom(paramType)) {
                args[i] = context.bot();
            } else if (UpdateContext.class.isAssignableFrom(paramType)) {
                args[i] = context;
            } else {
                // Unknown parameter type, pass null
                args[i] = null;
            }
        }

        return args;
    }

    @SuppressWarnings("unchecked")
    private Mono<Void> adaptReturnValue(Object result, UpdateContext context) {
        if (result == null) {
            return Mono.empty();
        }

        if (result instanceof Mono) {
            Mono<?> mono = (Mono<?>) result;
            return mono.flatMap(value -> {
                if (value instanceof TelegramMethod) {
                    return context.bot().execute((TelegramMethod<?>) value).then();
                }
                return Mono.empty();
            }).then();
        }

        if (result instanceof TelegramMethod) {
            return context.bot().execute((TelegramMethod<?>) result).then();
        }

        return Mono.empty();
    }
}
