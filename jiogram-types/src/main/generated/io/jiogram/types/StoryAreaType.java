package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = StoryAreaTypeUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = StoryAreaTypeLink.class, name = "link"),
    @JsonSubTypes.Type(value = StoryAreaTypeLocation.class, name = "location"),
    @JsonSubTypes.Type(value = StoryAreaTypeSuggestedReaction.class, name = "suggested_reaction"),
    @JsonSubTypes.Type(value = StoryAreaTypeUniqueGift.class, name = "unique_gift"),
    @JsonSubTypes.Type(value = StoryAreaTypeWeather.class, name = "weather")
})
public sealed interface StoryAreaType permits StoryAreaTypeLink, StoryAreaTypeLocation, StoryAreaTypeSuggestedReaction, StoryAreaTypeUniqueGift, StoryAreaTypeWeather, StoryAreaTypeUnknown {}
