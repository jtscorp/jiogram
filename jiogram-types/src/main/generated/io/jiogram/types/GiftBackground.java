package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object describes the background of a gift.
 *
 * @see <a href="https://core.telegram.org/bots/api#giftbackground">GiftBackground in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GiftBackground {

    @JsonProperty("center_color")
    private final long centerColor;

    @JsonProperty("edge_color")
    private final long edgeColor;

    @JsonProperty("text_color")
    private final long textColor;

    /**
     * Creates a new {@code GiftBackground} instance.
     *
     * @param centerColor Center color of the background in RGB format
     * @param edgeColor Edge color of the background in RGB format
     * @param textColor Text color of the background in RGB format
     */
    @JsonCreator
    public GiftBackground(
            @JsonProperty("center_color") long centerColor,
            @JsonProperty("edge_color") long edgeColor,
            @JsonProperty("text_color") long textColor) {
        this.centerColor = centerColor;
        this.edgeColor = edgeColor;
        this.textColor = textColor;
    }

    /**
     * Center color of the background in RGB format
     */
    public long centerColor() {
        return centerColor;
    }

    /**
     * Edge color of the background in RGB format
     */
    public long edgeColor() {
        return edgeColor;
    }

    /**
     * Text color of the background in RGB format
     */
    public long textColor() {
        return textColor;
    }

    public GiftBackground withCenterColor(long centerColor) {
        return new GiftBackground(centerColor, edgeColor, textColor);
    }

    public GiftBackground withEdgeColor(long edgeColor) {
        return new GiftBackground(centerColor, edgeColor, textColor);
    }

    public GiftBackground withTextColor(long textColor) {
        return new GiftBackground(centerColor, edgeColor, textColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GiftBackground)) {
            return false;
        }
        GiftBackground that = (GiftBackground) o;
        return this.centerColor == that.centerColor
                && this.edgeColor == that.edgeColor
                && this.textColor == that.textColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.centerColor, this.edgeColor, this.textColor);
    }

    @Override
    public String toString() {
        return "GiftBackground[centerColor=" + this.centerColor
                + ", edgeColor=" + this.edgeColor
                + ", textColor=" + this.textColor
                + "]";
    }
}
