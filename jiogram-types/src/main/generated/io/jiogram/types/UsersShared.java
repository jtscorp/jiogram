package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SharedUser;
import java.util.List;

public class UsersShared {
    @JsonProperty("request_id") private final long requestId;
    @JsonProperty("users") private final List<SharedUser> users;

    @JsonCreator
    public UsersShared(
            @JsonProperty("request_id") long requestId,
            @JsonProperty("users") List<SharedUser> users
    ) {
        this.requestId = requestId;
        this.users = users;
    }

    public long requestId() {
        return this.requestId;
    }

    public List<SharedUser> users() {
        return this.users;
    }
}
