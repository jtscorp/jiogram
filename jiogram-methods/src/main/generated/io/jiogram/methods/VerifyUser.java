package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Verifies a user on behalf of the organization which is represented by the bot. Returns True on
 * success.
 *
 * @see <a href="https://core.telegram.org/bots/api#verifyuser">verifyUser in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class VerifyUser implements TelegramMethod<Boolean> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("custom_description")
    private final @Nullable String customDescription;

    /**
     * Creates a new {@code VerifyUser} instance.
     *
     * @param userId Unique identifier of the target user
     * @param customDescription Custom description for the verification; 0-70 characters. Must be
     *     empty if the organization isn't allowed to provide a custom verification description.
     */
    @JsonCreator
    public VerifyUser(
            @JsonProperty("user_id") long userId,
            @JsonProperty("custom_description") @Nullable String customDescription) {
        this.userId = userId;
        this.customDescription = customDescription;
    }

    @Override
    public String apiMethod() {
        return "verifyUser";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static VerifyUser of(long userId) {
        return new VerifyUser(userId, null);
    }

    /**
     * Unique identifier of the target user
     */
    public long userId() {
        return userId;
    }

    /**
     * Custom description for the verification; 0-70 characters. Must be empty if the organization
     * isn't allowed to provide a custom verification description.
     */
    public @Nullable String customDescription() {
        return customDescription;
    }

    public VerifyUser withUserId(long userId) {
        return new VerifyUser(userId, customDescription);
    }

    public VerifyUser withCustomDescription(@Nullable String customDescription) {
        return new VerifyUser(userId, customDescription);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VerifyUser)) {
            return false;
        }
        VerifyUser that = (VerifyUser) o;
        return this.userId == that.userId
                && Objects.equals(this.customDescription, that.customDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.customDescription);
    }

    @Override
    public String toString() {
        return "VerifyUser[userId=" + this.userId
                + ", customDescription=" + this.customDescription
                + "]";
    }
}
