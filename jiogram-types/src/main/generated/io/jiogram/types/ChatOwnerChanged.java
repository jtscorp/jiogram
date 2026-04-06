package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public record ChatOwnerChanged(
    @JsonProperty("new_owner") User newOwner
) {}
