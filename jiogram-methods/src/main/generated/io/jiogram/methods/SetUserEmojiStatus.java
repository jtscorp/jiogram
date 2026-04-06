package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetUserEmojiStatus(
    @JsonProperty("user_id") long userId,
    @JsonProperty("emoji_status_custom_emoji_id") @Nullable String emojiStatusCustomEmojiId,
    @JsonProperty("emoji_status_expiration_date") @Nullable Long emojiStatusExpirationDate
) implements TelegramMethod<Boolean> {

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
