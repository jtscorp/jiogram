package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes the way a background is filled based on the selected colors. Currently, it
 * can be one of
 * <br>- BackgroundFillSolid
 * <br>- BackgroundFillGradient
 * <br>- BackgroundFillFreeformGradient
 *
 * @see <a href="https://core.telegram.org/bots/api#backgroundfill">BackgroundFill in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = BackgroundFillUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = BackgroundFillFreeformGradient.class, name = "freeform_gradient"),
    @JsonSubTypes.Type(value = BackgroundFillGradient.class, name = "gradient"),
    @JsonSubTypes.Type(value = BackgroundFillSolid.class, name = "solid")
})
public sealed interface BackgroundFill permits BackgroundFillFreeformGradient, BackgroundFillGradient, BackgroundFillSolid, BackgroundFillUnknown {}
