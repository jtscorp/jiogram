package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes the paid media to be sent. Currently, it can be one of
 * <br>- InputPaidMediaPhoto
 * <br>- InputPaidMediaVideo
 *
 * @see <a href="https://core.telegram.org/bots/api#inputpaidmedia">InputPaidMedia in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = InputPaidMediaUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputPaidMediaPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = InputPaidMediaVideo.class, name = "video")
})
public sealed interface InputPaidMedia permits InputPaidMediaPhoto, InputPaidMediaVideo, InputPaidMediaUnknown {}
