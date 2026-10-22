package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;
import java.util.Objects;

/**
 * Describes a story area pointing to a unique gift. Currently, a story can have at most 1 unique
 * gift area.
 *
 * @see <a href="https://core.telegram.org/bots/api#storyareatypeuniquegift">StoryAreaTypeUniqueGift in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StoryAreaTypeUniqueGift implements StoryAreaType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final StoryAreaTypeType type;

    @JsonProperty("name")
    private final String name;

    /**
     * Creates a new {@code StoryAreaTypeUniqueGift} instance.
     *
     * @param type Type of the area, always 'unique_gift'
     * @param name Unique name of the gift
     */
    @JsonCreator
    public StoryAreaTypeUniqueGift(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
            @JsonProperty("name") String name) {
        this.type = type;
        this.name = name;
    }

    public static StoryAreaTypeUniqueGift of(String name) {
        return new StoryAreaTypeUniqueGift(StoryAreaTypeType.UNIQUE_GIFT, name);
    }

    /**
     * Type of the area, always 'unique_gift'
     */
    public StoryAreaTypeType type() {
        return type;
    }

    /**
     * Unique name of the gift
     */
    public String name() {
        return name;
    }

    public StoryAreaTypeUniqueGift withName(String name) {
        return new StoryAreaTypeUniqueGift(type, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoryAreaTypeUniqueGift)) {
            return false;
        }
        StoryAreaTypeUniqueGift that = (StoryAreaTypeUniqueGift) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.name);
    }

    @Override
    public String toString() {
        return "StoryAreaTypeUniqueGift[type=" + this.type
                + ", name=" + this.name
                + "]";
    }
}
