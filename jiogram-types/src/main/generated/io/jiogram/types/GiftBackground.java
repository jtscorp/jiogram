package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object describes the background of a gift.
 *
 * @param centerColor Center color of the background in RGB format
 * @param edgeColor Edge color of the background in RGB format
 * @param textColor Text color of the background in RGB format
 * @see <a href="https://core.telegram.org/bots/api#giftbackground">GiftBackground in the Bot API</a>
 */
public record GiftBackground(
    @JsonProperty("center_color") long centerColor,
    @JsonProperty("edge_color") long edgeColor,
    @JsonProperty("text_color") long textColor
) {}
