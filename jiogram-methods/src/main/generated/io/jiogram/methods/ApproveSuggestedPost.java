package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to approve a suggested post in a direct messages chat. The bot must have the
 * 'can_post_messages' administrator right in the corresponding channel chat. Returns True on
 * success.
 *
 * @param chatId Unique identifier for the target direct messages chat
 * @param messageId Identifier of a suggested post message to approve
 * @param sendDate Point in time (Unix timestamp) when the post is expected to be published; omit if
 *     the date has already been specified when the suggested post was created. If specified, then
 *     the date must be not more than 2678400 seconds (30 days) in the future
 * @see <a href="https://core.telegram.org/bots/api#approvesuggestedpost">approveSuggestedPost in the Bot API</a>
 */
public record ApproveSuggestedPost(
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("send_date") @Nullable Long sendDate
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "approveSuggestedPost";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static ApproveSuggestedPost of(long chatId, long messageId) {
        return new ApproveSuggestedPost(chatId, messageId, null);
    }
}
