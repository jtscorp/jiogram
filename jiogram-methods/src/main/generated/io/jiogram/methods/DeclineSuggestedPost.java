package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to decline a suggested post in a direct messages chat. The bot must have the
 * 'can_manage_direct_messages' administrator right in the corresponding channel chat. Returns True
 * on success.
 *
 * @param chatId Unique identifier for the target direct messages chat
 * @param messageId Identifier of a suggested post message to decline
 * @param comment Comment for the creator of the suggested post; 0-128 characters
 * @see <a href="https://core.telegram.org/bots/api#declinesuggestedpost">declineSuggestedPost in the Bot API</a>
 */
public record DeclineSuggestedPost(
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("comment") @Nullable String comment
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "declineSuggestedPost";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static DeclineSuggestedPost of(long chatId, long messageId) {
        return new DeclineSuggestedPost(chatId, messageId, null);
    }
}
