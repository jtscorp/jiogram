package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class GiftPremiumSubscription implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("month_count") private final long monthCount;
    @JsonProperty("star_count") private final long starCount;
    @JsonProperty("text") @Nullable private final String text;
    @JsonProperty("text_parse_mode") @Nullable private final ParseMode textParseMode;
    @JsonProperty("text_entities") @Nullable private final List<MessageEntity> textEntities;

    @JsonCreator
    public GiftPremiumSubscription(
            @JsonProperty("user_id") long userId,
            @JsonProperty("month_count") long monthCount,
            @JsonProperty("star_count") long starCount,
            @JsonProperty("text") @Nullable String text,
            @JsonProperty("text_parse_mode") @Nullable ParseMode textParseMode,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
    ) {
        this.userId = userId;
        this.monthCount = monthCount;
        this.starCount = starCount;
        this.text = text;
        this.textParseMode = textParseMode;
        this.textEntities = textEntities;
    }

    public long userId() {
        return this.userId;
    }

    public long monthCount() {
        return this.monthCount;
    }

    public long starCount() {
        return this.starCount;
    }

    public String text() {
        return this.text;
    }

    public ParseMode textParseMode() {
        return this.textParseMode;
    }

    public List<MessageEntity> textEntities() {
        return this.textEntities;
    }

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
