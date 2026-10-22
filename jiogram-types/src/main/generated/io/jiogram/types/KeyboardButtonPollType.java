package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PollType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents type of a poll, which is allowed to be created and sent when the
 * corresponding button is pressed.
 *
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonpolltype">KeyboardButtonPollType in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class KeyboardButtonPollType {

    @JsonProperty("type")
    private final @Nullable PollType type;

    /**
     * Creates a new {@code KeyboardButtonPollType} instance.
     *
     * @param type If quiz is passed, the user will be allowed to create only polls in the quiz
     *     mode. If regular is passed, only regular polls will be allowed. Otherwise, the user will
     *     be allowed to create a poll of any type.
     */
    @JsonCreator
    public KeyboardButtonPollType(
            @JsonProperty("type") @Nullable PollType type) {
        this.type = type;
    }

    public static KeyboardButtonPollType of() {
        return new KeyboardButtonPollType(null);
    }

    /**
     * If quiz is passed, the user will be allowed to create only polls in the quiz mode. If regular
     * is passed, only regular polls will be allowed. Otherwise, the user will be allowed to create
     * a poll of any type.
     */
    public @Nullable PollType type() {
        return type;
    }

    public KeyboardButtonPollType withType(@Nullable PollType type) {
        return new KeyboardButtonPollType(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KeyboardButtonPollType)) {
            return false;
        }
        KeyboardButtonPollType that = (KeyboardButtonPollType) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "KeyboardButtonPollType[type=" + this.type
                + "]";
    }
}
