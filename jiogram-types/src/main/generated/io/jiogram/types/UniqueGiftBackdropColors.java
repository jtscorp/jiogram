package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object describes the colors of the backdrop of a unique gift.
 *
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftbackdropcolors">UniqueGiftBackdropColors in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UniqueGiftBackdropColors {

    @JsonProperty("center_color")
    private final long centerColor;

    @JsonProperty("edge_color")
    private final long edgeColor;

    @JsonProperty("symbol_color")
    private final long symbolColor;

    @JsonProperty("text_color")
    private final long textColor;

    /**
     * Creates a new {@code UniqueGiftBackdropColors} instance.
     *
     * @param centerColor The color in the center of the backdrop in RGB format
     * @param edgeColor The color on the edges of the backdrop in RGB format
     * @param symbolColor The color to be applied to the symbol in RGB format
     * @param textColor The color for the text on the backdrop in RGB format
     */
    @JsonCreator
    public UniqueGiftBackdropColors(
            @JsonProperty("center_color") long centerColor,
            @JsonProperty("edge_color") long edgeColor,
            @JsonProperty("symbol_color") long symbolColor,
            @JsonProperty("text_color") long textColor) {
        this.centerColor = centerColor;
        this.edgeColor = edgeColor;
        this.symbolColor = symbolColor;
        this.textColor = textColor;
    }

    /**
     * The color in the center of the backdrop in RGB format
     */
    public long centerColor() {
        return centerColor;
    }

    /**
     * The color on the edges of the backdrop in RGB format
     */
    public long edgeColor() {
        return edgeColor;
    }

    /**
     * The color to be applied to the symbol in RGB format
     */
    public long symbolColor() {
        return symbolColor;
    }

    /**
     * The color for the text on the backdrop in RGB format
     */
    public long textColor() {
        return textColor;
    }

    public UniqueGiftBackdropColors withCenterColor(long centerColor) {
        return new UniqueGiftBackdropColors(centerColor, edgeColor, symbolColor, textColor);
    }

    public UniqueGiftBackdropColors withEdgeColor(long edgeColor) {
        return new UniqueGiftBackdropColors(centerColor, edgeColor, symbolColor, textColor);
    }

    public UniqueGiftBackdropColors withSymbolColor(long symbolColor) {
        return new UniqueGiftBackdropColors(centerColor, edgeColor, symbolColor, textColor);
    }

    public UniqueGiftBackdropColors withTextColor(long textColor) {
        return new UniqueGiftBackdropColors(centerColor, edgeColor, symbolColor, textColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UniqueGiftBackdropColors)) {
            return false;
        }
        UniqueGiftBackdropColors that = (UniqueGiftBackdropColors) o;
        return this.centerColor == that.centerColor
                && this.edgeColor == that.edgeColor
                && this.symbolColor == that.symbolColor
                && this.textColor == that.textColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.centerColor, this.edgeColor, this.symbolColor, this.textColor);
    }

    @Override
    public String toString() {
        return "UniqueGiftBackdropColors[centerColor=" + this.centerColor
                + ", edgeColor=" + this.edgeColor
                + ", symbolColor=" + this.symbolColor
                + ", textColor=" + this.textColor
                + "]";
    }
}
