package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to log out from the cloud Bot API server before launching the bot locally. You
 * must log out the bot before running it locally, otherwise there is no guarantee that the bot will
 * receive updates. After a successful call, you can immediately log in on a local server, but will
 * not be able to log in back to the cloud Bot API server for 10 minutes. Returns True on success.
 * Requires no parameters.
 *
 * @see <a href="https://core.telegram.org/bots/api#logout">logOut in the Bot API</a>
 */
public record LogOut(

) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "logOut";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
