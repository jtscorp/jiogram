package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Describes a keyboard button to be used by a user of a Mini App.
 *
 * @see <a href="https://core.telegram.org/bots/api#preparedkeyboardbutton">PreparedKeyboardButton in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PreparedKeyboardButton {

    @JsonProperty("id")
    private final String id;

    /**
     * Creates a new {@code PreparedKeyboardButton} instance.
     *
     * @param id Unique identifier of the keyboard button
     */
    @JsonCreator
    public PreparedKeyboardButton(
            @JsonProperty("id") String id) {
        this.id = id;
    }

    /**
     * Unique identifier of the keyboard button
     */
    public String id() {
        return id;
    }

    public PreparedKeyboardButton withId(String id) {
        return new PreparedKeyboardButton(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PreparedKeyboardButton)) {
            return false;
        }
        PreparedKeyboardButton that = (PreparedKeyboardButton) o;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "PreparedKeyboardButton[id=" + this.id
                + "]";
    }
}
