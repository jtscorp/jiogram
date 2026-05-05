package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class ChatMemberOwner implements ChatMember {
    @JsonProperty("status") private final ChatMemberType status;
    @JsonProperty("user") private final User user;
    @JsonProperty("is_anonymous") private final boolean isAnonymous;
    @JsonProperty("custom_title") @Nullable private final String customTitle;

    @JsonCreator
    public ChatMemberOwner(
            @JsonProperty("status") ChatMemberType status,
            @JsonProperty("user") User user,
            @JsonProperty("is_anonymous") boolean isAnonymous,
            @JsonProperty("custom_title") @Nullable String customTitle
    ) {
        this.status = status;
        this.user = user;
        this.isAnonymous = isAnonymous;
        this.customTitle = customTitle;
    }

    public ChatMemberType status() {
        return this.status;
    }

    public User user() {
        return this.user;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public String customTitle() {
        return this.customTitle;
    }
}
