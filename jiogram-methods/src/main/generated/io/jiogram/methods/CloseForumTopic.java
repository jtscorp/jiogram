package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to close an open topic in a forum supergroup chat. The bot must be an
 * administrator in the chat for this to work and must have the can_manage_topics administrator
 * rights, unless it is the creator of the topic. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @param messageThreadId Unique identifier for the target message thread of the forum topic
 * @see <a href="https://core.telegram.org/bots/api#closeforumtopic">closeForumTopic in the Bot API</a>
 */
public record CloseForumTopic(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") long messageThreadId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "closeForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public CloseForumTopic withChatId(ChatId chatId) {
        return new CloseForumTopic(chatId, messageThreadId);
    }

    public CloseForumTopic withMessageThreadId(long messageThreadId) {
        return new CloseForumTopic(chatId, messageThreadId);
    }
}
