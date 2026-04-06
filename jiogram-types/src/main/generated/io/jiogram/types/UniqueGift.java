package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.UniqueGiftBackdrop;
import io.jiogram.types.UniqueGiftColors;
import io.jiogram.types.UniqueGiftModel;
import io.jiogram.types.UniqueGiftSymbol;
import org.jspecify.annotations.Nullable;

public record UniqueGift(
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
) {}
