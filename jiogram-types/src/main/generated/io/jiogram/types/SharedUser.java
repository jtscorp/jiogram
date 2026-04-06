package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record SharedUser(
    @JsonProperty("user_id") long userId,
    @JsonProperty("first_name") @Nullable String firstName,
    @JsonProperty("last_name") @Nullable String lastName,
    @JsonProperty("username") @Nullable String username,
    @JsonProperty("photo") @Nullable List<PhotoSize> photo
) {}
