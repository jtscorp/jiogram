package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageId;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class CopyMessages implements TelegramMethod<List<MessageId>> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_thread_id") @Nullable private final Long messageThreadId;
    @JsonProperty("direct_messages_topic_id") @Nullable private final Long directMessagesTopicId;
    @JsonProperty("from_chat_id") private final ChatId fromChatId;
    @JsonProperty("message_ids") private final List<Long> messageIds;
    @JsonProperty("disable_notification") @Nullable private final Boolean disableNotification;
    @JsonProperty("protect_content") @Nullable private final Boolean protectContent;
    @JsonProperty("remove_caption") @Nullable private final Boolean removeCaption;

    @JsonCreator
    public CopyMessages(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("from_chat_id") ChatId fromChatId,
            @JsonProperty("message_ids") List<Long> messageIds,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("remove_caption") @Nullable Boolean removeCaption
    ) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.fromChatId = fromChatId;
        this.messageIds = messageIds;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.removeCaption = removeCaption;
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

    public List<Long> messageIds() {
        return this.messageIds;
    }

    public Boolean disableNotification() {
        return this.disableNotification;
    }

    public Boolean protectContent() {
        return this.protectContent;
    }

    public Boolean removeCaption() {
        return this.removeCaption;
    }

    @Override
    public String apiMethod() {
        return "copyMessages";
    }

    @Override
    public String apiReturnType() {
        return "Array of MessageId";
    }

    public static CopyMessages of(ChatId chatId, ChatId fromChatId, List<Long> messageIds) {
        return new CopyMessages(chatId, null, null, fromChatId, messageIds, null, null, null);
    }
}
