package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaPosition;
import io.jiogram.types.StoryAreaType;
import java.util.Objects;

/**
 * Describes a clickable area on a story media.
 *
 * @see <a href="https://core.telegram.org/bots/api#storyarea">StoryArea in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StoryArea {

    @JsonProperty("position")
    private final StoryAreaPosition position;

    @JsonProperty("type")
    private final StoryAreaType type;

    /**
     * Creates a new {@code StoryArea} instance.
     *
     * @param position Position of the area
     * @param type Type of the area
     */
    @JsonCreator
    public StoryArea(
            @JsonProperty("position") StoryAreaPosition position,
            @JsonProperty("type") StoryAreaType type) {
        this.position = position;
        this.type = type;
    }

    /**
     * Position of the area
     */
    public StoryAreaPosition position() {
        return position;
    }

    /**
     * Type of the area
     */
    public StoryAreaType type() {
        return type;
    }

    public StoryArea withPosition(StoryAreaPosition position) {
        return new StoryArea(position, type);
    }

    public StoryArea withType(StoryAreaType type) {
        return new StoryArea(position, type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoryArea)) {
            return false;
        }
        StoryArea that = (StoryArea) o;
        return Objects.equals(this.position, that.position)
                && Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position, this.type);
    }

    @Override
    public String toString() {
        return "StoryArea[position=" + this.position
                + ", type=" + this.type
                + "]";
    }
}
