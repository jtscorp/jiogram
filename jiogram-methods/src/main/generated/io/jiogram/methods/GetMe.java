package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.User;

/**
 * A simple method for testing your bot's authentication token. Requires no parameters. Returns
 * basic information about the bot in form of a User object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getme">getMe in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetMe implements TelegramMethod<User> {

    /**
     * Creates a new {@code GetMe} instance.
     */
    public GetMe() {
    }

    @Override
    public String apiMethod() {
        return "getMe";
    }

    @Override
    public String apiReturnType() {
        return "User";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof GetMe;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "GetMe[]";
    }
}
