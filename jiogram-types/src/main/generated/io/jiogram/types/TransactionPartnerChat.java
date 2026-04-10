package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.Gift;
import org.jspecify.annotations.Nullable;

public class TransactionPartnerChat implements TransactionPartner {
    @JsonProperty("type") private final String type;
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("gift") @Nullable private final Gift gift;

    @JsonCreator
    public TransactionPartnerChat(
            @JsonProperty("type") String type,
            @JsonProperty("chat") Chat chat,
            @JsonProperty("gift") @Nullable Gift gift
    ) {
        this.type = type;
        this.chat = chat;
        this.gift = gift;
    }

    public String type() {
        return this.type;
    }

    public Chat chat() {
        return this.chat;
    }

    public Gift gift() {
        return this.gift;
    }
}
