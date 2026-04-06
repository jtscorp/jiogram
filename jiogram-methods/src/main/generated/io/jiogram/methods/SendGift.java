package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record SendGift(
    @JsonProperty("user_id") @Nullable Long userId,
    @JsonProperty("chat_id") @Nullable ChatId chatId,
    @JsonProperty("gift_id") String giftId,
    @JsonProperty("pay_for_upgrade") @Nullable Boolean payForUpgrade,
    @JsonProperty("text") @Nullable String text,
    @JsonProperty("text_parse_mode") @Nullable String textParseMode,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "sendGift";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SendGift of(String giftId) {
        return new SendGift(null, null, giftId, null, null, null, null);
    }
}
