package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class Chat {
    @JsonProperty("id") private final long id;
    @JsonProperty("type") private final String type;
    @JsonProperty("title") @Nullable private final String title;
    @JsonProperty("username") @Nullable private final String username;
    @JsonProperty("first_name") @Nullable private final String firstName;
    @JsonProperty("last_name") @Nullable private final String lastName;
    @JsonProperty("is_forum") @Nullable private final Boolean isForum;
    @JsonProperty("is_direct_messages") @Nullable private final Boolean isDirectMessages;

    @JsonCreator
    public Chat(
            @JsonProperty("id") long id,
            @JsonProperty("type") String type,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("username") @Nullable String username,
            @JsonProperty("first_name") @Nullable String firstName,
            @JsonProperty("last_name") @Nullable String lastName,
            @JsonProperty("is_forum") @Nullable Boolean isForum,
            @JsonProperty("is_direct_messages") @Nullable Boolean isDirectMessages
    ) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isForum = isForum;
        this.isDirectMessages = isDirectMessages;
    }

    public long id() {
        return this.id;
    }

    public String type() {
        return this.type;
    }

    public String title() {
        return this.title;
    }

    public String username() {
        return this.username;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public Boolean isForum() {
        return this.isForum;
    }

    public Boolean isDirectMessages() {
        return this.isDirectMessages;
    }
}
