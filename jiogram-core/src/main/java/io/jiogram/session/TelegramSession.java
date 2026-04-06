package io.jiogram.session;

import io.jiogram.types.TelegramMethod;
import reactor.core.publisher.Mono;

/**
 * Abstraction for making requests to the Telegram Bot API.
 */
public interface TelegramSession {

    /**
     * Sends a request to the Telegram Bot API.
     *
     * @param token  the bot token for authentication
     * @param method the API method to invoke
     * @param <T>    the expected return type
     * @return a Mono emitting the deserialized result
     */
    <T> Mono<T> makeRequest(String token, TelegramMethod<T> method);

    /**
     * Closes the session and releases resources.
     */
    Mono<Void> close();
}
