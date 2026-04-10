package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class ChatMemberMember implements ChatMember {
    @JsonProperty("status") private final String status;
    @JsonProperty("tag") @Nullable private final String tag;
    @JsonProperty("user") private final User user;
    @JsonProperty("until_date") @Nullable private final Long untilDate;

    @JsonCreator
    public ChatMemberMember(
            @JsonProperty("status") String status,
            @JsonProperty("tag") @Nullable String tag,
            @JsonProperty("user") User user,
            @JsonProperty("until_date") @Nullable Long untilDate
    ) {
        this.status = status;
        this.tag = tag;
        this.user = user;
        this.untilDate = untilDate;
    }

    public String status() {
        return this.status;
    }

    public String tag() {
        return this.tag;
    }

    public User user() {
        return this.user;
    }

    public Long untilDate() {
        return this.untilDate;
    }
}
