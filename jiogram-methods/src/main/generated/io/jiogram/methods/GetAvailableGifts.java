package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gifts;
import io.jiogram.types.TelegramMethod;

/**
 * Returns the list of gifts that can be sent by the bot to users and channel chats. Requires no
 * parameters. Returns a Gifts object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getavailablegifts">getAvailableGifts in the Bot API</a>
 */
public record GetAvailableGifts(

) implements TelegramMethod<Gifts> {

    @Override
    public String apiMethod() {
        return "getAvailableGifts";
    }

    @Override
    public String apiReturnType() {
        return "Gifts";
    }
}
