package io.jiogram.types;

/**
 * Marker interface for all Telegram Bot API method records.
 *
 * @param <T> the return type of the API method
 */
public interface TelegramMethod<T> {

    /**
     * Returns the Telegram Bot API method name (e.g. "sendMessage").
     */
    String apiMethod();

    /**
     * Returns the return type string from the schema (e.g. "Message", "Array of Update").
     */
    String apiReturnType();
}
