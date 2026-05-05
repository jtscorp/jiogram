package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record GiftPremiumSubscription(
    @JsonProperty("user_id") long userId,
    @JsonProperty("month_count") long monthCount,
    @JsonProperty("star_count") long starCount,
    @JsonProperty("text") @Nullable String text,
    @JsonProperty("text_parse_mode") @Nullable ParseMode textParseMode,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "giftPremiumSubscription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static GiftPremiumSubscription of(long userId, long monthCount, long starCount) {
        return new GiftPremiumSubscription(userId, monthCount, starCount, null, null, null);
    }
}
