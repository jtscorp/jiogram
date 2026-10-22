package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import io.jiogram.types.Gifts;
import io.jiogram.types.TelegramMethod;

/**
 * Returns the list of gifts that can be sent by the bot to users and channel chats. Requires no
 * parameters. Returns a Gifts object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getavailablegifts">getAvailableGifts in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetAvailableGifts implements TelegramMethod<Gifts> {

    /**
     * Creates a new {@code GetAvailableGifts} instance.
     */
    public GetAvailableGifts() {
    }

    @Override
    public String apiMethod() {
        return "getAvailableGifts";
    }

    @Override
    public String apiReturnType() {
        return "Gifts";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof GetAvailableGifts;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "GetAvailableGifts[]";
    }
}
