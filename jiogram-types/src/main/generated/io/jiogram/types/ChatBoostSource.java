package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "source")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ChatBoostSourceGiftCode.class, name = "gift_code"),
    @JsonSubTypes.Type(value = ChatBoostSourceGiveaway.class, name = "giveaway"),
    @JsonSubTypes.Type(value = ChatBoostSourcePremium.class, name = "premium")
})
public interface ChatBoostSource {}
