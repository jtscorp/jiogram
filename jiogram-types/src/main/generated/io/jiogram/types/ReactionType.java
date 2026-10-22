package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes the type of a reaction. Currently, it can be one of
 * <br>- ReactionTypeEmoji
 * <br>- ReactionTypeCustomEmoji
 * <br>- ReactionTypePaid
 *
 * @see <a href="https://core.telegram.org/bots/api#reactiontype">ReactionType in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = ReactionTypeUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ReactionTypeCustomEmoji.class, name = "custom_emoji"),
    @JsonSubTypes.Type(value = ReactionTypeEmoji.class, name = "emoji"),
    @JsonSubTypes.Type(value = ReactionTypePaid.class, name = "paid")
})
public sealed interface ReactionType permits ReactionTypeCustomEmoji, ReactionTypeEmoji, ReactionTypePaid, ReactionTypeUnknown {}
