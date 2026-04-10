package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessBotRights;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class BusinessConnection {
    @JsonProperty("id") private final String id;
    @JsonProperty("user") private final User user;
    @JsonProperty("user_chat_id") private final long userChatId;
    @JsonProperty("date") private final long date;
    @JsonProperty("rights") @Nullable private final BusinessBotRights rights;
    @JsonProperty("is_enabled") private final boolean isEnabled;

    @JsonCreator
    public BusinessConnection(
            @JsonProperty("id") String id,
            @JsonProperty("user") User user,
            @JsonProperty("user_chat_id") long userChatId,
            @JsonProperty("date") long date,
            @JsonProperty("rights") @Nullable BusinessBotRights rights,
            @JsonProperty("is_enabled") boolean isEnabled
    ) {
        this.id = id;
        this.user = user;
        this.userChatId = userChatId;
        this.date = date;
        this.rights = rights;
        this.isEnabled = isEnabled;
    }

    public String id() {
        return this.id;
    }

    public User user() {
        return this.user;
    }

    public long userChatId() {
        return this.userChatId;
    }

    public long date() {
        return this.date;
    }

    public BusinessBotRights rights() {
        return this.rights;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }
}
