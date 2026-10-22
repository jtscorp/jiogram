package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Changes the emoji status for a given user that previously allowed the bot to manage their emoji
 * status via the Mini App method requestEmojiStatusAccess. Returns True on success.
 *
 * @param userId Unique identifier of the target user
 * @param emojiStatusCustomEmojiId Custom emoji identifier of the emoji status to set. Pass an empty
 *     string to remove the status.
 * @param emojiStatusExpirationDate Expiration date of the emoji status, if any
 * @see <a href="https://core.telegram.org/bots/api#setuseremojistatus">setUserEmojiStatus in the Bot API</a>
 */
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

    public SetUserEmojiStatus withUserId(long userId) {
        return new SetUserEmojiStatus(userId, emojiStatusCustomEmojiId, emojiStatusExpirationDate);
    }

    public SetUserEmojiStatus withEmojiStatusCustomEmojiId(@Nullable String emojiStatusCustomEmojiId) {
        return new SetUserEmojiStatus(userId, emojiStatusCustomEmojiId, emojiStatusExpirationDate);
    }

    public SetUserEmojiStatus withEmojiStatusExpirationDate(@Nullable Long emojiStatusExpirationDate) {
        return new SetUserEmojiStatus(userId, emojiStatusCustomEmojiId, emojiStatusExpirationDate);
    }
}
