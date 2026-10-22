package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.PreparedInlineMessage;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Stores a message that can be sent by a user of a Mini App. Returns a PreparedInlineMessage
 * object.
 *
 * @param userId Unique identifier of the target user that can use the prepared message
 * @param result A JSON-serialized object describing the message to be sent
 * @param allowUserChats Pass True if the message can be sent to private chats with users
 * @param allowBotChats Pass True if the message can be sent to private chats with bots
 * @param allowGroupChats Pass True if the message can be sent to group and supergroup chats
 * @param allowChannelChats Pass True if the message can be sent to channel chats
 * @see <a href="https://core.telegram.org/bots/api#savepreparedinlinemessage">savePreparedInlineMessage in the Bot API</a>
 */
public record SavePreparedInlineMessage(
    @JsonProperty("user_id") long userId,
    @JsonProperty("result") InlineQueryResult result,
    @JsonProperty("allow_user_chats") @Nullable Boolean allowUserChats,
    @JsonProperty("allow_bot_chats") @Nullable Boolean allowBotChats,
    @JsonProperty("allow_group_chats") @Nullable Boolean allowGroupChats,
    @JsonProperty("allow_channel_chats") @Nullable Boolean allowChannelChats
) implements TelegramMethod<PreparedInlineMessage> {

    @Override
    public String apiMethod() {
        return "savePreparedInlineMessage";
    }

    @Override
    public String apiReturnType() {
        return "PreparedInlineMessage";
    }

    public static SavePreparedInlineMessage of(long userId, InlineQueryResult result) {
        return new SavePreparedInlineMessage(userId, result, null, null, null, null);
    }

    public SavePreparedInlineMessage withUserId(long userId) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SavePreparedInlineMessage withResult(InlineQueryResult result) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SavePreparedInlineMessage withAllowUserChats(@Nullable Boolean allowUserChats) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SavePreparedInlineMessage withAllowBotChats(@Nullable Boolean allowBotChats) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SavePreparedInlineMessage withAllowGroupChats(@Nullable Boolean allowGroupChats) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SavePreparedInlineMessage withAllowChannelChats(@Nullable Boolean allowChannelChats) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }
}
