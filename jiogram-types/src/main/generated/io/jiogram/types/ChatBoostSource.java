package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "source")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ChatBoostSourceGiftCode.class, name = "gift_code"),
    @JsonSubTypes.Type(value = ChatBoostSourcePremium.class, name = "premium"),
    @JsonSubTypes.Type(value = ChatBoostSourceGiveaway.class, name = "giveaway")
})
public sealed interface ChatBoostSource permits ChatBoostSourceGiftCode, ChatBoostSourcePremium, ChatBoostSourceGiveaway {}
