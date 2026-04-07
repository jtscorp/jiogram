package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = BackgroundFillGradient.class, name = "gradient"),
    @JsonSubTypes.Type(value = BackgroundFillSolid.class, name = "solid"),
    @JsonSubTypes.Type(value = BackgroundFillFreeformGradient.class, name = "freeform_gradient")
})
public sealed interface BackgroundFill permits BackgroundFillGradient, BackgroundFillSolid, BackgroundFillFreeformGradient {}
