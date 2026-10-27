package io.jiogram.session;

/**
 * Exception thrown when a request does not reach the Telegram Bot API or its response is cut
 * off: DNS failure, refused or reset connection, TLS error.
 * <p>
 * It deliberately carries no cause: the HTTP client's exception refers to the request URL,
 * which contains the bot token, and would put it into logged stack traces.
 */
public class TelegramTransportException extends RuntimeException {

    private final String apiMethod;

    public TelegramTransportException(String apiMethod, String message) {
        super("Request to the Telegram Bot API (" + apiMethod + ") failed: " + message);
        this.apiMethod = apiMethod;
    }

    /**
     * Returns the Bot API method of the failed request, e.g. {@code sendMessage}.
     */
    public String apiMethod() {
        return apiMethod;
    }
}
