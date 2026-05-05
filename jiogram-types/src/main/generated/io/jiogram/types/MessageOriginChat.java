package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageOriginType;
import org.jspecify.annotations.Nullable;

public class MessageOriginChat implements MessageOrigin {
    @JsonProperty("type") private final MessageOriginType type;
    @JsonProperty("date") private final long date;
    @JsonProperty("sender_chat") private final Chat senderChat;
    @JsonProperty("author_signature") @Nullable private final String authorSignature;

    @JsonCreator
    public MessageOriginChat(
            @JsonProperty("type") MessageOriginType type,
            @JsonProperty("date") long date,
            @JsonProperty("sender_chat") Chat senderChat,
            @JsonProperty("author_signature") @Nullable String authorSignature
    ) {
        this.type = type;
        this.date = date;
        this.senderChat = senderChat;
        this.authorSignature = authorSignature;
    }

    public MessageOriginType type() {
        return this.type;
    }

    public long date() {
        return this.date;
    }

    public Chat senderChat() {
        return this.senderChat;
    }

    public String authorSignature() {
        return this.authorSignature;
    }
}
