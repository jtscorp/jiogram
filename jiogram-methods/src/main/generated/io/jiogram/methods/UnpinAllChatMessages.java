package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to clear the list of pinned messages in a chat. In private chats and channel
 * direct messages chats, no additional rights are required to unpin all pinned messages.
 * Conversely, the bot must be an administrator with the 'can_pin_messages' right or the
 * 'can_edit_messages' right to unpin all pinned messages in groups and channels respectively.
 * Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @see <a href="https://core.telegram.org/bots/api#unpinallchatmessages">unpinAllChatMessages in the Bot API</a>
 */
public record UnpinAllChatMessages(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "unpinAllChatMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public UnpinAllChatMessages withChatId(ChatId chatId) {
        return new UnpinAllChatMessages(chatId);
    }
}
