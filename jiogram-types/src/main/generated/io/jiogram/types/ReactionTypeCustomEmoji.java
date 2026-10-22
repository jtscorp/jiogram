package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

/**
 * The reaction is based on a custom emoji.
 *
 * @param type Type of the reaction, always 'custom_emoji'
 * @param customEmojiId Custom emoji identifier
 * @see <a href="https://core.telegram.org/bots/api#reactiontypecustomemoji">ReactionTypeCustomEmoji in the Bot API</a>
 */
public record ReactionTypeCustomEmoji(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) ReactionTypeType type,
    @JsonProperty("custom_emoji_id") String customEmojiId
) implements ReactionType {

    public static ReactionTypeCustomEmoji of(String customEmojiId) {
        return new ReactionTypeCustomEmoji(ReactionTypeType.CUSTOM_EMOJI, customEmojiId);
    }

    public ReactionTypeCustomEmoji withCustomEmojiId(String customEmojiId) {
        return new ReactionTypeCustomEmoji(type, customEmojiId);
    }
}
