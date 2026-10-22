package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes paid media. Currently, it can be one of
 * <br>- PaidMediaPreview
 * <br>- PaidMediaPhoto
 * <br>- PaidMediaVideo
 *
 * @see <a href="https://core.telegram.org/bots/api#paidmedia">PaidMedia in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = PaidMediaUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = PaidMediaPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = PaidMediaPreview.class, name = "preview"),
    @JsonSubTypes.Type(value = PaidMediaVideo.class, name = "video")
})
public interface PaidMedia {}
