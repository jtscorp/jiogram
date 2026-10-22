package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Changes the emoji status for a given user that previously allowed the bot to manage their emoji
 * status via the Mini App method requestEmojiStatusAccess. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setuseremojistatus">setUserEmojiStatus in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetUserEmojiStatus implements TelegramMethod<Boolean> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("emoji_status_custom_emoji_id")
    private final @Nullable String emojiStatusCustomEmojiId;

    @JsonProperty("emoji_status_expiration_date")
    private final @Nullable Long emojiStatusExpirationDate;

    /**
     * Creates a new {@code SetUserEmojiStatus} instance.
     *
     * @param userId Unique identifier of the target user
     * @param emojiStatusCustomEmojiId Custom emoji identifier of the emoji status to set. Pass an
     *     empty string to remove the status.
     * @param emojiStatusExpirationDate Expiration date of the emoji status, if any
     */
    @JsonCreator
    public SetUserEmojiStatus(
            @JsonProperty("user_id") long userId,
            @JsonProperty("emoji_status_custom_emoji_id") @Nullable String emojiStatusCustomEmojiId,
            @JsonProperty("emoji_status_expiration_date") @Nullable Long emojiStatusExpirationDate) {
        this.userId = userId;
        this.emojiStatusCustomEmojiId = emojiStatusCustomEmojiId;
        this.emojiStatusExpirationDate = emojiStatusExpirationDate;
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

    /**
     * Unique identifier of the target user
     */
    public long userId() {
        return userId;
    }

    /**
     * Custom emoji identifier of the emoji status to set. Pass an empty string to remove the
     * status.
     */
    public @Nullable String emojiStatusCustomEmojiId() {
        return emojiStatusCustomEmojiId;
    }

    /**
     * Expiration date of the emoji status, if any
     */
    public @Nullable Long emojiStatusExpirationDate() {
        return emojiStatusExpirationDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetUserEmojiStatus)) {
            return false;
        }
        SetUserEmojiStatus that = (SetUserEmojiStatus) o;
        return this.userId == that.userId
                && Objects.equals(this.emojiStatusCustomEmojiId, that.emojiStatusCustomEmojiId)
                && Objects.equals(this.emojiStatusExpirationDate, that.emojiStatusExpirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.emojiStatusCustomEmojiId, this.emojiStatusExpirationDate);
    }

    @Override
    public String toString() {
        return "SetUserEmojiStatus[userId=" + this.userId
                + ", emojiStatusCustomEmojiId=" + this.emojiStatusCustomEmojiId
                + ", emojiStatusExpirationDate=" + this.emojiStatusExpirationDate
                + "]";
    }
}
