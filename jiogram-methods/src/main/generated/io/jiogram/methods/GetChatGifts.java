package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.OwnedGifts;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class GetChatGifts implements TelegramMethod<OwnedGifts> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("exclude_unsaved") @Nullable private final Boolean excludeUnsaved;
    @JsonProperty("exclude_saved") @Nullable private final Boolean excludeSaved;
    @JsonProperty("exclude_unlimited") @Nullable private final Boolean excludeUnlimited;
    @JsonProperty("exclude_limited_upgradable") @Nullable private final Boolean excludeLimitedUpgradable;
    @JsonProperty("exclude_limited_non_upgradable") @Nullable private final Boolean excludeLimitedNonUpgradable;
    @JsonProperty("exclude_from_blockchain") @Nullable private final Boolean excludeFromBlockchain;
    @JsonProperty("exclude_unique") @Nullable private final Boolean excludeUnique;
    @JsonProperty("sort_by_price") @Nullable private final Boolean sortByPrice;
    @JsonProperty("offset") @Nullable private final String offset;
    @JsonProperty("limit") @Nullable private final Long limit;

    @JsonCreator
    public GetChatGifts(
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
    ) {
        this.chatId = chatId;
        this.excludeUnsaved = excludeUnsaved;
        this.excludeSaved = excludeSaved;
        this.excludeUnlimited = excludeUnlimited;
        this.excludeLimitedUpgradable = excludeLimitedUpgradable;
        this.excludeLimitedNonUpgradable = excludeLimitedNonUpgradable;
        this.excludeFromBlockchain = excludeFromBlockchain;
        this.excludeUnique = excludeUnique;
        this.sortByPrice = sortByPrice;
        this.offset = offset;
        this.limit = limit;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Boolean excludeUnsaved() {
        return this.excludeUnsaved;
    }

    public Boolean excludeSaved() {
        return this.excludeSaved;
    }

    public Boolean excludeUnlimited() {
        return this.excludeUnlimited;
    }

    public Boolean excludeLimitedUpgradable() {
        return this.excludeLimitedUpgradable;
    }

    public Boolean excludeLimitedNonUpgradable() {
        return this.excludeLimitedNonUpgradable;
    }

    public Boolean excludeFromBlockchain() {
        return this.excludeFromBlockchain;
    }

    public Boolean excludeUnique() {
        return this.excludeUnique;
    }

    public Boolean sortByPrice() {
        return this.sortByPrice;
    }

    public String offset() {
        return this.offset;
    }

    public Long limit() {
        return this.limit;
    }

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
