package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.OwnedGifts;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record GetChatGifts(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("exclude_unsaved") @Nullable Boolean excludeUnsaved,
    @JsonProperty("exclude_saved") @Nullable Boolean excludeSaved,
    @JsonProperty("exclude_unlimited") @Nullable Boolean excludeUnlimited,
    @JsonProperty("exclude_limited_upgradable") @Nullable Boolean excludeLimitedUpgradable,
    @JsonProperty("exclude_limited_non_upgradable") @Nullable Boolean excludeLimitedNonUpgradable,
    @JsonProperty("exclude_from_blockchain") @Nullable Boolean excludeFromBlockchain,
    @JsonProperty("exclude_unique") @Nullable Boolean excludeUnique,
    @JsonProperty("sort_by_price") @Nullable Boolean sortByPrice,
    @JsonProperty("offset") @Nullable String offset,
    @JsonProperty("limit") @Nullable Long limit
) implements TelegramMethod<OwnedGifts> {

    @Override
    public String apiMethod() {
        return "getChatGifts";
    }

    @Override
    public String apiReturnType() {
        return "OwnedGifts";
    }

    public static GetChatGifts of(ChatId chatId) {
        return new GetChatGifts(chatId, null, null, null, null, null, null, null, null, null, null);
    }
}
