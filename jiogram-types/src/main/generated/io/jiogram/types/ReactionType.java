package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ReactionTypeCustomEmoji.class, name = "custom_emoji"),
    @JsonSubTypes.Type(value = ReactionTypeEmoji.class, name = "emoji"),
    @JsonSubTypes.Type(value = ReactionTypePaid.class, name = "paid")
})
public interface ReactionType {}
