package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object represents the content of a media message to be sent. It should be one of
 * <br>- InputMediaAnimation
 * <br>- InputMediaDocument
 * <br>- InputMediaAudio
 * <br>- InputMediaPhoto
 * <br>- InputMediaVideo
 *
 * @see <a href="https://core.telegram.org/bots/api#inputmedia">InputMedia in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = InputMediaUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputMediaAnimation.class, name = "animation"),
    @JsonSubTypes.Type(value = InputMediaAudio.class, name = "audio"),
    @JsonSubTypes.Type(value = InputMediaDocument.class, name = "document"),
    @JsonSubTypes.Type(value = InputMediaPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = InputMediaVideo.class, name = "video")
})
public interface InputMedia {}
