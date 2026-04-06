package io.jiogram.session;

/**
 * Exception thrown when the Telegram Bot API returns an error response (ok=false).
 */
public class TelegramApiException extends RuntimeException {

    private final int errorCode;

    public TelegramApiException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * Returns the Telegram API error code.
     */
    public int errorCode() {
        return errorCode;
    }
}
