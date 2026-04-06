package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record ForwardMessage(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
    @JsonProperty("from_chat_id") ChatId fromChatId,
    @JsonProperty("video_start_timestamp") @Nullable Long videoStartTimestamp,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent,
    @JsonProperty("message_effect_id") @Nullable String messageEffectId,
    @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
    @JsonProperty("message_id") long messageId
) implements TelegramMethod<Message> {

    @Override
    public String apiMethod() {
        return "forwardMessage";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static ForwardMessage of(ChatId chatId, ChatId fromChatId, long messageId) {
        return new ForwardMessage(chatId, null, null, fromChatId, null, null, null, null, null, messageId);
    }
}
