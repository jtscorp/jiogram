package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;
import java.util.Objects;

/**
 * Describes a story area pointing to an HTTP or tg:// link. Currently, a story can have up to 3
 * link areas.
 *
 * @see <a href="https://core.telegram.org/bots/api#storyareatypelink">StoryAreaTypeLink in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StoryAreaTypeLink implements StoryAreaType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final StoryAreaTypeType type;

    @JsonProperty("url")
    private final String url;

    /**
     * Creates a new {@code StoryAreaTypeLink} instance.
     *
     * @param type Type of the area, always 'link'
     * @param url HTTP or tg:// URL to be opened when the area is clicked
     */
    @JsonCreator
    public StoryAreaTypeLink(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
            @JsonProperty("url") String url) {
        this.type = type;
        this.url = url;
    }

    public static StoryAreaTypeLink of(String url) {
        return new StoryAreaTypeLink(StoryAreaTypeType.LINK, url);
    }

    /**
     * Type of the area, always 'link'
     */
    public StoryAreaTypeType type() {
        return type;
    }

    /**
     * HTTP or tg:// URL to be opened when the area is clicked
     */
    public String url() {
        return url;
    }

    public StoryAreaTypeLink withUrl(String url) {
        return new StoryAreaTypeLink(type, url);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoryAreaTypeLink)) {
            return false;
        }
        StoryAreaTypeLink that = (StoryAreaTypeLink) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.url);
    }

    @Override
    public String toString() {
        return "StoryAreaTypeLink[type=" + this.type
                + ", url=" + this.url
                + "]";
    }
}
