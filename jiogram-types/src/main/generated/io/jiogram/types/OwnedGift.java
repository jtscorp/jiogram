package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = OwnedGiftUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = OwnedGiftRegular.class, name = "regular"),
    @JsonSubTypes.Type(value = OwnedGiftUnique.class, name = "unique")
})
public sealed interface OwnedGift permits OwnedGiftRegular, OwnedGiftUnique, OwnedGiftUnknown {}
