package io.jiogram.handler;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

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

    private enum ArgumentSource { EVENT, BOT, CONTEXT }

    private final Object bean;
    private final Method method;
    private final ArgumentSource[] argumentSources;
    private final @Nullable Scheduler scheduler;

    /**
     * Creates an adapter that invokes the method on the subscribing thread.
     *
     * @throws IllegalStateException if a parameter is not the event, {@link Bot} or {@link UpdateContext},
     *                               so a mistyped handler fails at startup instead of receiving null
     */
    public HandlerAdapter(Object bean, Method method, Class<E> eventType) {
        this(bean, method, eventType, null);
    }

    /**
     * Creates an adapter that invokes the method on the given scheduler, so handler code may
     * block (JDBC, blocking HTTP clients, {@code Mono.block()}) without stalling the event loop.
     *
     * @param scheduler where to invoke the method, or null to invoke it on the subscribing thread
     * @throws IllegalStateException if a parameter is not the event, {@link Bot} or {@link UpdateContext}
     */
    public HandlerAdapter(Object bean, Method method, Class<E> eventType, @Nullable Scheduler scheduler) {
        this.bean = bean;
        this.method = method;
        this.argumentSources = Arrays.stream(method.getParameters())
                .map(parameter -> argumentSource(method, parameter, eventType))
                .toArray(ArgumentSource[]::new);
        this.scheduler = scheduler;
        this.method.setAccessible(true);
    }

    private static ArgumentSource argumentSource(Method method, Parameter parameter, Class<?> eventType) {
        Class<?> type = parameter.getType();
        if (type.isAssignableFrom(eventType)) {
            return ArgumentSource.EVENT;
        }
        if (type.isAssignableFrom(Bot.class)) {
            return ArgumentSource.BOT;
        }
        if (type.isAssignableFrom(UpdateContext.class)) {
            return ArgumentSource.CONTEXT;
        }
        throw new IllegalStateException("Unsupported parameter '" + parameter.getType().getSimpleName() + " "
                + parameter.getName() + "' in handler " + method.getDeclaringClass().getName() + "#"
                + method.getName() + ": expected " + eventType.getSimpleName() + ", Bot or UpdateContext");
    }

    @Override
    public Mono<Void> handle(E event, UpdateContext context) {
        if (scheduler == null) {
            return invoke(event, context);
        }
        return Mono.defer(() -> invoke(event, context)).subscribeOn(scheduler);
    }

    private Mono<Void> invoke(E event, UpdateContext context) {
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
        Object[] args = new Object[argumentSources.length];
        for (int i = 0; i < argumentSources.length; i++) {
            args[i] = switch (argumentSources[i]) {
                case EVENT -> event;
                case BOT -> context.bot();
                case CONTEXT -> context;
            };
        }
        return args;
    }

    @SuppressWarnings("unchecked")
    private Mono<Void> adaptReturnValue(Object result, UpdateContext context) {
        return switch (result) {
            case null -> Mono.empty();
            case Mono<?> mono -> mono.flatMap(value -> switch (value) {
                case TelegramMethod<?> method -> context.bot().execute(method).then();
                case null, default -> Mono.empty();
            }).then();
            case TelegramMethod<?> telegramMethod -> context.bot().execute(telegramMethod).then();
            default -> Mono.empty();
        };
    }
}
