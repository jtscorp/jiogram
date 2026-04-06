package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ReactionType;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record SetMessageReaction(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("reaction") @Nullable List<ReactionType> reaction,
    @JsonProperty("is_big") @Nullable Boolean isBig
) implements TelegramMethod<Boolean> {

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
