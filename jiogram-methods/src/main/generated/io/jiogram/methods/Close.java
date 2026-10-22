package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to close the bot instance before moving it from one local server to another. You
 * need to delete the webhook before calling this method to ensure that the bot isn't launched again
 * after server restart. The method will return error 429 in the first 10 minutes after the bot is
 * launched. Returns True on success. Requires no parameters.
 *
 * @see <a href="https://core.telegram.org/bots/api#close">close in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Close implements TelegramMethod<Boolean> {

    /**
     * Creates a new {@code Close} instance.
     */
    public Close() {
    }

    @Override
    public String apiMethod() {
        return "close";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Close;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Close[]";
    }
}
