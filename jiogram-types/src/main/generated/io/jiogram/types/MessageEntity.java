package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntityType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class MessageEntity {
    @JsonProperty("type") private final MessageEntityType type;
    @JsonProperty("offset") private final long offset;
    @JsonProperty("length") private final long length;
    @JsonProperty("url") @Nullable private final String url;
    @JsonProperty("user") @Nullable private final User user;
    @JsonProperty("language") @Nullable private final String language;
    @JsonProperty("custom_emoji_id") @Nullable private final String customEmojiId;
    @JsonProperty("unix_time") @Nullable private final Long unixTime;
    @JsonProperty("date_time_format") @Nullable private final String dateTimeFormat;

    @JsonCreator
    public MessageEntity(
            @JsonProperty("type") MessageEntityType type,
            @JsonProperty("offset") long offset,
            @JsonProperty("length") long length,
            @JsonProperty("url") @Nullable String url,
            @JsonProperty("user") @Nullable User user,
            @JsonProperty("language") @Nullable String language,
            @JsonProperty("custom_emoji_id") @Nullable String customEmojiId,
            @JsonProperty("unix_time") @Nullable Long unixTime,
            @JsonProperty("date_time_format") @Nullable String dateTimeFormat
    ) {
        this.type = type;
        this.offset = offset;
        this.length = length;
        this.url = url;
        this.user = user;
        this.language = language;
        this.customEmojiId = customEmojiId;
        this.unixTime = unixTime;
        this.dateTimeFormat = dateTimeFormat;
    }

    public MessageEntityType type() {
        return this.type;
    }

    public long offset() {
        return this.offset;
    }

    public long length() {
        return this.length;
    }

    public String url() {
        return this.url;
    }

    public User user() {
        return this.user;
    }

    public String language() {
        return this.language;
    }

    public String customEmojiId() {
        return this.customEmojiId;
    }

    public Long unixTime() {
        return this.unixTime;
    }

    public String dateTimeFormat() {
        return this.dateTimeFormat;
    }
}
