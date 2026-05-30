package com.example;

import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.methods.SendMessage;
import io.jiogram.middleware.Middleware;
import io.jiogram.middleware.MiddlewareChain;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class AntifloodMiddleware implements Middleware {

    private final Duration rateLimit;
    private final Map<String, Instant> lastSeen = new ConcurrentHashMap<>();

    public AntifloodMiddleware(@Value("${antiflood.rate-limit:5s}") Duration rateLimit) {
        this.rateLimit = rateLimit;
    }

    @Override
    public Mono<Void> process(Object event, UpdateContext context, MiddlewareChain chain) {
        if (!(event instanceof Message message)) {
            return chain.next(event, context);
        }

        long userId = message.from() == null ? 0 : message.from().id();
        String key = message.chat().id() + ":" + userId;
        Instant now = Instant.now();
        Instant previous = lastSeen.put(key, now);
        if (previous == null || Duration.between(previous, now).compareTo(rateLimit) >= 0) {
            return chain.next(event, context);
        }

        return context.bot().execute(SendMessage.of(
            ChatId.of(message.chat().id()),
            "Too many requests. Try again later."
        )).then();
    }
}
