package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Removes verification from a user who is currently verified on behalf of the organization
 * represented by the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#removeuserverification">removeUserVerification in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RemoveUserVerification implements TelegramMethod<Boolean> {

    @JsonProperty("user_id")
    private final long userId;

    /**
     * Creates a new {@code RemoveUserVerification} instance.
     *
     * @param userId Unique identifier of the target user
     */
    @JsonCreator
    public RemoveUserVerification(
            @JsonProperty("user_id") long userId) {
        this.userId = userId;
    }

    @Override
    public String apiMethod() {
        return "removeUserVerification";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier of the target user
     */
    public long userId() {
        return userId;
    }

    public RemoveUserVerification withUserId(long userId) {
        return new RemoveUserVerification(userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RemoveUserVerification)) {
            return false;
        }
        RemoveUserVerification that = (RemoveUserVerification) o;
        return this.userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId);
    }

    @Override
    public String toString() {
        return "RemoveUserVerification[userId=" + this.userId
                + "]";
    }
}
