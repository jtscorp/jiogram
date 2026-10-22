package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Describes the type of a clickable area on a story. Currently, it can be one of
 * <br>- StoryAreaTypeLocation
 * <br>- StoryAreaTypeSuggestedReaction
 * <br>- StoryAreaTypeLink
 * <br>- StoryAreaTypeWeather
 * <br>- StoryAreaTypeUniqueGift
 *
 * @see <a href="https://core.telegram.org/bots/api#storyareatype">StoryAreaType in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = StoryAreaTypeUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = StoryAreaTypeLink.class, name = "link"),
    @JsonSubTypes.Type(value = StoryAreaTypeLocation.class, name = "location"),
    @JsonSubTypes.Type(value = StoryAreaTypeSuggestedReaction.class, name = "suggested_reaction"),
    @JsonSubTypes.Type(value = StoryAreaTypeUniqueGift.class, name = "unique_gift"),
    @JsonSubTypes.Type(value = StoryAreaTypeWeather.class, name = "weather")
})
public interface StoryAreaType {}
