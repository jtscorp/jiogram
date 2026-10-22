package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes the source of a chat boost. It can be one of
 * <br>- ChatBoostSourcePremium
 * <br>- ChatBoostSourceGiftCode
 * <br>- ChatBoostSourceGiveaway
 *
 * @see <a href="https://core.telegram.org/bots/api#chatboostsource">ChatBoostSource in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "source", visible = true, defaultImpl = ChatBoostSourceUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ChatBoostSourceGiftCode.class, name = "gift_code"),
    @JsonSubTypes.Type(value = ChatBoostSourceGiveaway.class, name = "giveaway"),
    @JsonSubTypes.Type(value = ChatBoostSourcePremium.class, name = "premium")
})
public sealed interface ChatBoostSource permits ChatBoostSourceGiftCode, ChatBoostSourceGiveaway, ChatBoostSourcePremium, ChatBoostSourceUnknown {}
