package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageOriginType;
import org.jspecify.annotations.Nullable;

public class MessageOriginChannel implements MessageOrigin {
    @JsonProperty("type") private final MessageOriginType type;
    @JsonProperty("date") private final long date;
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("author_signature") @Nullable private final String authorSignature;

    @JsonCreator
    public MessageOriginChannel(
            @JsonProperty("type") MessageOriginType type,
            @JsonProperty("date") long date,
            @JsonProperty("chat") Chat chat,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("author_signature") @Nullable String authorSignature
    ) {
        this.type = type;
        this.date = date;
        this.chat = chat;
        this.messageId = messageId;
        this.authorSignature = authorSignature;
    }

    public MessageOriginType type() {
        return this.type;
    }

    public long date() {
        return this.date;
    }

    public Chat chat() {
        return this.chat;
    }

    public long messageId() {
        return this.messageId;
    }

    public String authorSignature() {
        return this.authorSignature;
    }
}
