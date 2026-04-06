package io.jiogram.middleware;

import io.jiogram.dispatcher.UpdateContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

/**
 * Middleware that catches exceptions from downstream handlers and middlewares,
 * logs them, and swallows them so that other updates keep processing.
 * <p>
 * Should typically be added as the outermost middleware in the dispatcher.
 */
public class ErrorMiddleware implements Middleware {

    private static final Logger log = LoggerFactory.getLogger(ErrorMiddleware.class);

    @Override
    public Mono<Void> process(Object event, UpdateContext context, MiddlewareChain chain) {
        return chain.next(event, context)
                .onErrorResume(throwable -> {
                    log.error("Error processing update: {}", throwable.getMessage(), throwable);
                    return Mono.empty();
                });
    }
}
