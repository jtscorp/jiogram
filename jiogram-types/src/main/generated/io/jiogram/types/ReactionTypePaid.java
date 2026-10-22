package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

/**
 * The reaction is paid.
 *
 * @param type Type of the reaction, always 'paid'
 * @see <a href="https://core.telegram.org/bots/api#reactiontypepaid">ReactionTypePaid in the Bot API</a>
 */
public record ReactionTypePaid(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) ReactionTypeType type
) implements ReactionType {}
