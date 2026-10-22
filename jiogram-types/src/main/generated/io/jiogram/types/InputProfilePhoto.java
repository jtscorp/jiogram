package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes a profile photo to set. Currently, it can be one of
 * <br>- InputProfilePhotoStatic
 * <br>- InputProfilePhotoAnimated
 *
 * @see <a href="https://core.telegram.org/bots/api#inputprofilephoto">InputProfilePhoto in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = InputProfilePhotoUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputProfilePhotoAnimated.class, name = "animated"),
    @JsonSubTypes.Type(value = InputProfilePhotoStatic.class, name = "static")
})
public interface InputProfilePhoto {}
