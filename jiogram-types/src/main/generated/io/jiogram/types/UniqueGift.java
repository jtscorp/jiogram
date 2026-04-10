package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.UniqueGiftBackdrop;
import io.jiogram.types.UniqueGiftColors;
import io.jiogram.types.UniqueGiftModel;
import io.jiogram.types.UniqueGiftSymbol;
import org.jspecify.annotations.Nullable;

public class UniqueGift {
    @JsonProperty("gift_id") private final String giftId;
    @JsonProperty("base_name") private final String baseName;
    @JsonProperty("name") private final String name;
    @JsonProperty("number") private final long number;
    @JsonProperty("model") private final UniqueGiftModel model;
    @JsonProperty("symbol") private final UniqueGiftSymbol symbol;
    @JsonProperty("backdrop") private final UniqueGiftBackdrop backdrop;
    @JsonProperty("is_premium") @Nullable private final Boolean isPremium;
    @JsonProperty("is_burned") @Nullable private final Boolean isBurned;
    @JsonProperty("is_from_blockchain") @Nullable private final Boolean isFromBlockchain;
    @JsonProperty("colors") @Nullable private final UniqueGiftColors colors;
    @JsonProperty("publisher_chat") @Nullable private final Chat publisherChat;

    @JsonCreator
    public UniqueGift(
            @JsonProperty("gift_id") String giftId,
            @JsonProperty("base_name") String baseName,
            @JsonProperty("name") String name,
            @JsonProperty("number") long number,
            @JsonProperty("model") UniqueGiftModel model,
            @JsonProperty("symbol") UniqueGiftSymbol symbol,
            @JsonProperty("backdrop") UniqueGiftBackdrop backdrop,
            @JsonProperty("is_premium") @Nullable Boolean isPremium,
            @JsonProperty("is_burned") @Nullable Boolean isBurned,
            @JsonProperty("is_from_blockchain") @Nullable Boolean isFromBlockchain,
            @JsonProperty("colors") @Nullable UniqueGiftColors colors,
            @JsonProperty("publisher_chat") @Nullable Chat publisherChat
    ) {
        this.giftId = giftId;
        this.baseName = baseName;
        this.name = name;
        this.number = number;
        this.model = model;
        this.symbol = symbol;
        this.backdrop = backdrop;
        this.isPremium = isPremium;
        this.isBurned = isBurned;
        this.isFromBlockchain = isFromBlockchain;
        this.colors = colors;
        this.publisherChat = publisherChat;
    }

    public String giftId() {
        return this.giftId;
    }

    public String baseName() {
        return this.baseName;
    }

    public String name() {
        return this.name;
    }

    public long number() {
        return this.number;
    }

    public UniqueGiftModel model() {
        return this.model;
    }

    public UniqueGiftSymbol symbol() {
        return this.symbol;
    }

    public UniqueGiftBackdrop backdrop() {
        return this.backdrop;
    }

    public Boolean isPremium() {
        return this.isPremium;
    }

    public Boolean isBurned() {
        return this.isBurned;
    }

    public Boolean isFromBlockchain() {
        return this.isFromBlockchain;
    }

    public UniqueGiftColors colors() {
        return this.colors;
    }

    public Chat publisherChat() {
        return this.publisherChat;
    }
}
