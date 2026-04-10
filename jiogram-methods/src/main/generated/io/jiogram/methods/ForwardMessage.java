package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class ForwardMessage implements TelegramMethod<Message> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_thread_id") @Nullable private final Long messageThreadId;
    @JsonProperty("direct_messages_topic_id") @Nullable private final Long directMessagesTopicId;
    @JsonProperty("from_chat_id") private final ChatId fromChatId;
    @JsonProperty("video_start_timestamp") @Nullable private final Long videoStartTimestamp;
    @JsonProperty("disable_notification") @Nullable private final Boolean disableNotification;
    @JsonProperty("protect_content") @Nullable private final Boolean protectContent;
    @JsonProperty("message_effect_id") @Nullable private final String messageEffectId;
    @JsonProperty("suggested_post_parameters") @Nullable private final SuggestedPostParameters suggestedPostParameters;
    @JsonProperty("message_id") private final long messageId;

    @JsonCreator
    public ForwardMessage(
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
    ) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.fromChatId = fromChatId;
        this.videoStartTimestamp = videoStartTimestamp;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.messageEffectId = messageEffectId;
        this.suggestedPostParameters = suggestedPostParameters;
        this.messageId = messageId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Long messageThreadId() {
        return this.messageThreadId;
    }

    public Long directMessagesTopicId() {
        return this.directMessagesTopicId;
    }

    public ChatId fromChatId() {
        return this.fromChatId;
    }

    public Long videoStartTimestamp() {
        return this.videoStartTimestamp;
    }

    public Boolean disableNotification() {
        return this.disableNotification;
    }

    public Boolean protectContent() {
        return this.protectContent;
    }

    public String messageEffectId() {
        return this.messageEffectId;
    }

    public SuggestedPostParameters suggestedPostParameters() {
        return this.suggestedPostParameters;
    }

    public long messageId() {
        return this.messageId;
    }

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
