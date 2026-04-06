package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record AffiliateInfo(
    @JsonProperty("affiliate_user") @Nullable User affiliateUser,
    @JsonProperty("affiliate_chat") @Nullable Chat affiliateChat,
    @JsonProperty("commission_per_mille") long commissionPerMille,
    @JsonProperty("amount") long amount,
    @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount
) {}
