package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to clear the list of pinned messages in a forum topic in a forum supergroup chat
 * or a private chat with a user. In the case of a supergroup chat the bot must be an administrator
 * in the chat for this to work and must have the can_pin_messages administrator right in the
 * supergroup. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @param messageThreadId Unique identifier for the target message thread of the forum topic
 * @see <a href="https://core.telegram.org/bots/api#unpinallforumtopicmessages">unpinAllForumTopicMessages in the Bot API</a>
 */
public record UnpinAllForumTopicMessages(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") long messageThreadId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "unpinAllForumTopicMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public UnpinAllForumTopicMessages withChatId(ChatId chatId) {
        return new UnpinAllForumTopicMessages(chatId, messageThreadId);
    }

    public UnpinAllForumTopicMessages withMessageThreadId(long messageThreadId) {
        return new UnpinAllForumTopicMessages(chatId, messageThreadId);
    }
}
