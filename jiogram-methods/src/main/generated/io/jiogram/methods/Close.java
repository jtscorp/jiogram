package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to close the bot instance before moving it from one local server to another. You
 * need to delete the webhook before calling this method to ensure that the bot isn't launched again
 * after server restart. The method will return error 429 in the first 10 minutes after the bot is
 * launched. Returns True on success. Requires no parameters.
 *
 * @see <a href="https://core.telegram.org/bots/api#close">close in the Bot API</a>
 */
public record Close(

) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "close";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
