package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

/**
 * The reaction is based on an emoji.
 *
 * @param type Type of the reaction, always 'emoji'
 * @param emoji Reaction emoji. Currently, it can be one of "", "", "", "", "", "", "", "", "", "",
 *     "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
 *     "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
 *     "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
 * @see <a href="https://core.telegram.org/bots/api#reactiontypeemoji">ReactionTypeEmoji in the Bot API</a>
 */
public record ReactionTypeEmoji(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) ReactionTypeType type,
    @JsonProperty("emoji") String emoji
) implements ReactionType {}
