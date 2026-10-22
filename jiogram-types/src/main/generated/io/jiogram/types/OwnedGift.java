package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes a gift received and owned by a user or a chat. Currently, it can be one of
 * <br>- OwnedGiftRegular
 * <br>- OwnedGiftUnique
 *
 * @see <a href="https://core.telegram.org/bots/api#ownedgift">OwnedGift in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = OwnedGiftUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = OwnedGiftRegular.class, name = "regular"),
    @JsonSubTypes.Type(value = OwnedGiftUnique.class, name = "unique")
})
public sealed interface OwnedGift permits OwnedGiftRegular, OwnedGiftUnique, OwnedGiftUnknown {}
