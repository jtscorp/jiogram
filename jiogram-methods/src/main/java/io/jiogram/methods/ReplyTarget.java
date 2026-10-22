package io.jiogram.methods;

import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import org.jspecify.annotations.Nullable;

/**
 * Where an answer to a message goes, as aiogram's {@code Message.answer()} works it out: the
 * message's chat, and within it the forum topic, business connection or direct messages topic
 * the message came from. Used by the generated {@code answer(Message, ...)} and
 * {@code reply(Message, ...)} factories of the sending methods.
 */
final class ReplyTarget {

    private ReplyTarget() {
    }

    static ChatId chatId(Message message) {
        return ChatId.of(message.chat().id());
    }

    /**
     * The forum topic of the message. {@code message_thread_id} is also set on replies in groups
     * without topics, where sending it back would fail; only a topic message keeps its thread.
     */
    static @Nullable Long messageThreadId(Message message) {
        return Boolean.TRUE.equals(message.isTopicMessage()) ? message.messageThreadId() : null;
    }

    static @Nullable String businessConnectionId(Message message) {
        return message.businessConnectionId();
    }

    static @Nullable Long directMessagesTopicId(Message message) {
        return message.directMessagesTopic() != null ? message.directMessagesTopic().topicId() : null;
    }

    static ReplyParameters replyTo(Message message) {
        return new ReplyParameters(message.messageId(), null, null, null, null, null, null, null, null);
    }
}
