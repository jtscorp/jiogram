package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputMedia;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class SendMediaGroup implements TelegramMethod<List<Message>> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_thread_id") @Nullable private final Long messageThreadId;
    @JsonProperty("direct_messages_topic_id") @Nullable private final Long directMessagesTopicId;
    @JsonProperty("media") private final List<InputMedia> media;
    @JsonProperty("disable_notification") @Nullable private final Boolean disableNotification;
    @JsonProperty("protect_content") @Nullable private final Boolean protectContent;
    @JsonProperty("allow_paid_broadcast") @Nullable private final Boolean allowPaidBroadcast;
    @JsonProperty("message_effect_id") @Nullable private final String messageEffectId;
    @JsonProperty("reply_parameters") @Nullable private final ReplyParameters replyParameters;

    @JsonCreator
    public SendMediaGroup(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("media") List<InputMedia> media,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.media = media;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.allowPaidBroadcast = allowPaidBroadcast;
        this.messageEffectId = messageEffectId;
        this.replyParameters = replyParameters;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
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

    public List<InputMedia> media() {
        return this.media;
    }

    public Boolean disableNotification() {
        return this.disableNotification;
    }

    public Boolean protectContent() {
        return this.protectContent;
    }

    public Boolean allowPaidBroadcast() {
        return this.allowPaidBroadcast;
    }

    public String messageEffectId() {
        return this.messageEffectId;
    }

    public ReplyParameters replyParameters() {
        return this.replyParameters;
    }

    @Override
    public String apiMethod() {
        return "sendMediaGroup";
    }

    @Override
    public String apiReturnType() {
        return "Array of Message";
    }

    public static SendMediaGroup of(ChatId chatId, List<InputMedia> media) {
        return new SendMediaGroup(null, chatId, null, null, media, null, null, null, null, null);
    }
}
