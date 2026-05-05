package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.Gift;
import io.jiogram.types.TransactionPartnerType;
import org.jspecify.annotations.Nullable;

public record TransactionPartnerChat(
    @JsonProperty("type") TransactionPartnerType type,
    @JsonProperty("chat") Chat chat,
    @JsonProperty("gift") @Nullable Gift gift
) implements TransactionPartner {}
