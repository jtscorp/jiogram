package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.User;

/**
 * A simple method for testing your bot's authentication token. Requires no parameters. Returns
 * basic information about the bot in form of a User object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getme">getMe in the Bot API</a>
 */
public record GetMe(

) implements TelegramMethod<User> {

    @Override
    public String apiMethod() {
        return "getMe";
    }

    @Override
    public String apiReturnType() {
        return "User";
    }
}
