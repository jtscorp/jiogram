package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SharedUser;
import java.util.List;

public record UsersShared(
    @JsonProperty("request_id") long requestId,
    @JsonProperty("users") List<SharedUser> users
) {}
