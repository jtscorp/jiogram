package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes data sent from a Web App to the bot.
 *
 * @param data The data. Be aware that a bad client can send arbitrary data in this field.
 * @param buttonText Text of the web_app keyboard button from which the Web App was opened. Be aware
 *     that a bad client can send arbitrary data in this field.
 * @see <a href="https://core.telegram.org/bots/api#webappdata">WebAppData in the Bot API</a>
 */
public record WebAppData(
    @JsonProperty("data") String data,
    @JsonProperty("button_text") String buttonText
) {}
