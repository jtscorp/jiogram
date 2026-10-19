package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = PaidMediaUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = PaidMediaPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = PaidMediaPreview.class, name = "preview"),
    @JsonSubTypes.Type(value = PaidMediaVideo.class, name = "video")
})
public sealed interface PaidMedia permits PaidMediaPhoto, PaidMediaPreview, PaidMediaVideo, PaidMediaUnknown {}
