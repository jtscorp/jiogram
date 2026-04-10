package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class SendGift implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") @Nullable private final Long userId;
    @JsonProperty("chat_id") @Nullable private final ChatId chatId;
    @JsonProperty("gift_id") private final String giftId;
    @JsonProperty("pay_for_upgrade") @Nullable private final Boolean payForUpgrade;
    @JsonProperty("text") @Nullable private final String text;
    @JsonProperty("text_parse_mode") @Nullable private final String textParseMode;
    @JsonProperty("text_entities") @Nullable private final List<MessageEntity> textEntities;

    @JsonCreator
    public SendGift(
            @JsonProperty("user_id") @Nullable Long userId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("gift_id") String giftId,
            @JsonProperty("pay_for_upgrade") @Nullable Boolean payForUpgrade,
            @JsonProperty("text") @Nullable String text,
            @JsonProperty("text_parse_mode") @Nullable String textParseMode,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
    ) {
        this.userId = userId;
        this.chatId = chatId;
        this.giftId = giftId;
        this.payForUpgrade = payForUpgrade;
        this.text = text;
        this.textParseMode = textParseMode;
        this.textEntities = textEntities;
    }

    public Long userId() {
        return this.userId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String giftId() {
        return this.giftId;
    }

    public Boolean payForUpgrade() {
        return this.payForUpgrade;
    }

    public String text() {
        return this.text;
    }

    public String textParseMode() {
        return this.textParseMode;
    }

    public List<MessageEntity> textEntities() {
        return this.textEntities;
    }

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
