package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object describes the colors of the backdrop of a unique gift.
 *
 * @param centerColor The color in the center of the backdrop in RGB format
 * @param edgeColor The color on the edges of the backdrop in RGB format
 * @param symbolColor The color to be applied to the symbol in RGB format
 * @param textColor The color for the text on the backdrop in RGB format
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftbackdropcolors">UniqueGiftBackdropColors in the Bot API</a>
 */
public record UniqueGiftBackdropColors(
    @JsonProperty("center_color") long centerColor,
    @JsonProperty("edge_color") long edgeColor,
    @JsonProperty("symbol_color") long symbolColor,
    @JsonProperty("text_color") long textColor
) {}
