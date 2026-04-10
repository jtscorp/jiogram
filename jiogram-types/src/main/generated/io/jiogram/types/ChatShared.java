package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class ChatShared {
    @JsonProperty("request_id") private final long requestId;
    @JsonProperty("chat_id") private final long chatId;
    @JsonProperty("title") @Nullable private final String title;
    @JsonProperty("username") @Nullable private final String username;
    @JsonProperty("photo") @Nullable private final List<PhotoSize> photo;

    @JsonCreator
    public ChatShared(
            @JsonProperty("request_id") long requestId,
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("username") @Nullable String username,
            @JsonProperty("photo") @Nullable List<PhotoSize> photo
    ) {
        this.requestId = requestId;
        this.chatId = chatId;
        this.title = title;
        this.username = username;
        this.photo = photo;
    }

    public long requestId() {
        return this.requestId;
    }

    public long chatId() {
        return this.chatId;
    }

    public String title() {
        return this.title;
    }

    public String username() {
        return this.username;
    }

    public List<PhotoSize> photo() {
        return this.photo;
    }
}
