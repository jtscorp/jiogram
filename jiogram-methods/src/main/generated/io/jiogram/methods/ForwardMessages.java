package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageId;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record ForwardMessages(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
    @JsonProperty("from_chat_id") ChatId fromChatId,
    @JsonProperty("message_ids") List<Long> messageIds,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent
) implements TelegramMethod<List<MessageId>> {

    @Override
    public String apiMethod() {
        return "forwardMessages";
    }

    @Override
    public String apiReturnType() {
        return "Array of MessageId";
    }

    public static ForwardMessages of(ChatId chatId, ChatId fromChatId, List<Long> messageIds) {
        return new ForwardMessages(chatId, null, null, fromChatId, messageIds, null, null);
    }
}
