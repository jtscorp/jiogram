package io.jiogram.bot;

import io.jiogram.session.TelegramSession;
import io.jiogram.types.TelegramMethod;
import reactor.core.publisher.Mono;

/**
 * Represents a Telegram bot with a token, session, and default properties.
 */
public class Bot {

    private final String token;
    private final long id;
    private final TelegramSession session;
    private final DefaultBotProperties defaults;

    public Bot(String token, TelegramSession session) {
        this(token, session, DefaultBotProperties.defaults());
    }

    public Bot(String token, TelegramSession session, DefaultBotProperties defaults) {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Bot token must not be null or blank");
        }
        this.token = token;
        this.id = extractBotId(token);
        this.session = session;
        this.defaults = defaults;
    }

    /**
     * Executes a Telegram API method using this bot's session and token.
     *
     * @param method the API method to invoke
     * @param <T>    the expected return type
     * @return a Mono emitting the deserialized result
     */
    public <T> Mono<T> execute(TelegramMethod<T> method) {
        return session.makeRequest(token, method);
    }

    public String token() {
        return token;
    }

    public long id() {
        return id;
    }

    public TelegramSession session() {
        return session;
    }

    public DefaultBotProperties defaults() {
        return defaults;
    }

    /**
     * Extracts the bot ID from a token in the format "123456789:ABCDEFghijklmnop".
     *
     * @param token the bot token
     * @return the numeric bot ID
     * @throws IllegalArgumentException if the token does not contain a colon or the prefix is not numeric
     */
    private static long extractBotId(String token) {
        int colonIndex = token.indexOf(':');
        if (colonIndex <= 0) {
            throw new IllegalArgumentException(
                "Invalid bot token format: expected 'id:hash' but no colon found"
            );
        }
        String idPart = token.substring(0, colonIndex);
        try {
            return Long.parseLong(idPart);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "Invalid bot token format: prefix before colon is not a valid number", e
            );
        }
    }
}
