package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to get the token of a managed bot. Returns the token as String on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getmanagedbottoken">getManagedBotToken in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetManagedBotToken implements TelegramMethod<String> {

    @JsonProperty("user_id")
    private final long userId;

    /**
     * Creates a new {@code GetManagedBotToken} instance.
     *
     * @param userId User identifier of the managed bot whose token will be returned
     */
    @JsonCreator
    public GetManagedBotToken(
            @JsonProperty("user_id") long userId) {
        this.userId = userId;
    }

    @Override
    public String apiMethod() {
        return "getManagedBotToken";
    }

    @Override
    public String apiReturnType() {
        return "String";
    }

    /**
     * User identifier of the managed bot whose token will be returned
     */
    public long userId() {
        return userId;
    }

    public GetManagedBotToken withUserId(long userId) {
        return new GetManagedBotToken(userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetManagedBotToken)) {
            return false;
        }
        GetManagedBotToken that = (GetManagedBotToken) o;
        return this.userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId);
    }

    @Override
    public String toString() {
        return "GetManagedBotToken[userId=" + this.userId
                + "]";
    }
}
