package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
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
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class LogOut implements TelegramMethod<Boolean> {

    /**
     * Creates a new {@code LogOut} instance.
     */
    public LogOut() {
    }

    @Override
    public String apiMethod() {
        return "logOut";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof LogOut;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "LogOut[]";
    }
}
