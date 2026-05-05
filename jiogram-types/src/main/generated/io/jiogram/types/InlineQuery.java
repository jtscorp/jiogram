package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryChatType;
import io.jiogram.types.Location;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class InlineQuery {
    @JsonProperty("id") private final String id;
    @JsonProperty("from") private final User from;
    @JsonProperty("query") private final String query;
    @JsonProperty("offset") private final String offset;
    @JsonProperty("chat_type") @Nullable private final InlineQueryChatType chatType;
    @JsonProperty("location") @Nullable private final Location location;

    @JsonCreator
    public InlineQuery(
            @JsonProperty("id") String id,
            @JsonProperty("from") User from,
            @JsonProperty("query") String query,
            @JsonProperty("offset") String offset,
            @JsonProperty("chat_type") @Nullable InlineQueryChatType chatType,
            @JsonProperty("location") @Nullable Location location
    ) {
        this.id = id;
        this.from = from;
        this.query = query;
        this.offset = offset;
        this.chatType = chatType;
        this.location = location;
    }

    public String id() {
        return this.id;
    }

    public User from() {
        return this.from;
    }

    public String query() {
        return this.query;
    }

    public String offset() {
        return this.offset;
    }

    public InlineQueryChatType chatType() {
        return this.chatType;
    }

    public Location location() {
        return this.location;
    }
}
