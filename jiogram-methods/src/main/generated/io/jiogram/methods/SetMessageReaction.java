package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ReactionType;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class SetMessageReaction implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("reaction") @Nullable private final List<ReactionType> reaction;
    @JsonProperty("is_big") @Nullable private final Boolean isBig;

    @JsonCreator
    public SetMessageReaction(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("reaction") @Nullable List<ReactionType> reaction,
            @JsonProperty("is_big") @Nullable Boolean isBig
    ) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.reaction = reaction;
        this.isBig = isBig;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long messageId() {
        return this.messageId;
    }

    public List<ReactionType> reaction() {
        return this.reaction;
    }

    public Boolean isBig() {
        return this.isBig;
    }

    @Override
    public String apiMethod() {
        return "setMessageReaction";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMessageReaction of(ChatId chatId, long messageId) {
        return new SetMessageReaction(chatId, messageId, null, null);
    }
}
