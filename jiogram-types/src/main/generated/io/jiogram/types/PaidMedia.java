package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = PaidMediaPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = PaidMediaVideo.class, name = "video"),
    @JsonSubTypes.Type(value = PaidMediaPreview.class, name = "preview")
})
public sealed interface PaidMedia permits PaidMediaPhoto, PaidMediaVideo, PaidMediaPreview {}
