package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents an inline keyboard button that copies specified text to the clipboard.
 *
 * @see <a href="https://core.telegram.org/bots/api#copytextbutton">CopyTextButton in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class CopyTextButton {

    @JsonProperty("text")
    private final String text;

    /**
     * Creates a new {@code CopyTextButton} instance.
     *
     * @param text The text to be copied to the clipboard; 1-256 characters
     */
    @JsonCreator
    public CopyTextButton(
            @JsonProperty("text") String text) {
        this.text = text;
    }

    /**
     * The text to be copied to the clipboard; 1-256 characters
     */
    public String text() {
        return text;
    }

    public CopyTextButton withText(String text) {
        return new CopyTextButton(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CopyTextButton)) {
            return false;
        }
        CopyTextButton that = (CopyTextButton) o;
        return Objects.equals(this.text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text);
    }

    @Override
    public String toString() {
        return "CopyTextButton[text=" + this.text
                + "]";
    }
}
