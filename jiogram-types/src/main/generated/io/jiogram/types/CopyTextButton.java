package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents an inline keyboard button that copies specified text to the clipboard.
 *
 * @param text The text to be copied to the clipboard; 1-256 characters
 * @see <a href="https://core.telegram.org/bots/api#copytextbutton">CopyTextButton in the Bot API</a>
 */
public record CopyTextButton(
    @JsonProperty("text") String text
) {

    public CopyTextButton withText(String text) {
        return new CopyTextButton(text);
    }
}
