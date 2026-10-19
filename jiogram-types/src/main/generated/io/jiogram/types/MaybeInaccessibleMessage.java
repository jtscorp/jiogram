package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, property = "date", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonTypeIdResolver(MaybeInaccessibleMessageTypeIdResolver.class)
public sealed interface MaybeInaccessibleMessage permits InaccessibleMessage, Message {}
