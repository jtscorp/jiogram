package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * A placeholder, currently holds no information. Use BotFather to set up your game.
 *
 * @see <a href="https://core.telegram.org/bots/api#callbackgame">CallbackGame in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class CallbackGame {

    /**
     * Creates a new {@code CallbackGame} instance.
     */
    public CallbackGame() {
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CallbackGame;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "CallbackGame[]";
    }
}
