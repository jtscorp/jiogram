package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetUserEmojiStatus implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("emoji_status_custom_emoji_id") @Nullable private final String emojiStatusCustomEmojiId;
    @JsonProperty("emoji_status_expiration_date") @Nullable private final Long emojiStatusExpirationDate;

    @JsonCreator
    public SetUserEmojiStatus(
            @JsonProperty("user_id") long userId,
            @JsonProperty("emoji_status_custom_emoji_id") @Nullable String emojiStatusCustomEmojiId,
            @JsonProperty("emoji_status_expiration_date") @Nullable Long emojiStatusExpirationDate
    ) {
        this.userId = userId;
        this.emojiStatusCustomEmojiId = emojiStatusCustomEmojiId;
        this.emojiStatusExpirationDate = emojiStatusExpirationDate;
    }

    public long userId() {
        return this.userId;
    }

    public String emojiStatusCustomEmojiId() {
        return this.emojiStatusCustomEmojiId;
    }

    public Long emojiStatusExpirationDate() {
        return this.emojiStatusExpirationDate;
    }

    @Override
    public String apiMethod() {
        return "setUserEmojiStatus";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetUserEmojiStatus of(long userId) {
        return new SetUserEmojiStatus(userId, null, null);
    }
}
