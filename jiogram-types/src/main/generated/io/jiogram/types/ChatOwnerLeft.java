package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record ChatOwnerLeft(
    @JsonProperty("new_owner") @Nullable User newOwner
) {}
