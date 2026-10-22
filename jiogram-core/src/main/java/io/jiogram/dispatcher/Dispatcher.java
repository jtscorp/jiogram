package io.jiogram.dispatcher;

import io.jiogram.bot.Bot;
import io.jiogram.middleware.Middleware;
import io.jiogram.middleware.MiddlewareChain;
import io.jiogram.types.Update;
import org.jspecify.annotations.Nullable;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The main dispatcher that extends Router and adds middleware support.
 * Receives raw Update objects, resolves the event type and event,
 * then processes them through the middleware chain and router hierarchy.
 */
public class Dispatcher extends Router {

    private final List<Middleware> outerMiddlewares;

    public Dispatcher() {
        super("dispatcher");
        this.outerMiddlewares = new CopyOnWriteArrayList<>();
    }

    /**
     * Adds an outer middleware that wraps the entire event processing pipeline.
     */
    public void addOuterMiddleware(Middleware middleware) {
        outerMiddlewares.add(middleware);
    }

    /**
     * Feeds a raw Update to the dispatcher for processing.
     *
     * @param bot    the bot that received the update
     * @param update the update to process
     * @return a Mono that completes when the update has been processed
     */
    public Mono<Void> feedUpdate(Bot bot, Update update) {
        EventType type = EventType.of(update);
        if (type == null) {
            return Mono.empty();
        }
        Object event = type.extract(update);

        var context = new UpdateContext(bot, update);
        context.put("event_type", type.apiName());

        Mono<Void> finalHandler = propagateEvent(type.apiName(), event, context).then();

        var chain = new MiddlewareChain(outerMiddlewares, finalHandler);
        return chain.next(event, context);
    }

    /**
     * Resolves the event type name (e.g. {@code "message"}) of an update, or null if it
     * carries no known event.
     *
     * @see EventType#of(Update)
     */
    public @Nullable String resolveEventType(Update update) {
        EventType type = EventType.of(update);
        return type != null ? type.apiName() : null;
    }

    /**
     * Resolves the event object an update carries, or null if it carries no known event.
     *
     * @see EventType#of(Update)
     */
    public @Nullable Object resolveEvent(Update update) {
        EventType type = EventType.of(update);
        return type != null ? type.extract(update) : null;
    }
}
