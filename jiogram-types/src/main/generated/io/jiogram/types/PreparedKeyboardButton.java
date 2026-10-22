package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a keyboard button to be used by a user of a Mini App.
 *
 * @param id Unique identifier of the keyboard button
 * @see <a href="https://core.telegram.org/bots/api#preparedkeyboardbutton">PreparedKeyboardButton in the Bot API</a>
 */
public record PreparedKeyboardButton(
    @JsonProperty("id") String id
) {}
