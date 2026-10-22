package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to revoke the current token of a managed bot and generate a new one. Returns the
 * new token as String on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#replacemanagedbottoken">replaceManagedBotToken in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReplaceManagedBotToken implements TelegramMethod<String> {

    @JsonProperty("user_id")
    private final long userId;

    /**
     * Creates a new {@code ReplaceManagedBotToken} instance.
     *
     * @param userId User identifier of the managed bot whose token will be replaced
     */
    @JsonCreator
    public ReplaceManagedBotToken(
            @JsonProperty("user_id") long userId) {
        this.userId = userId;
    }

    @Override
    public String apiMethod() {
        return "replaceManagedBotToken";
    }

    @Override
    public String apiReturnType() {
        return "String";
    }

    /**
     * User identifier of the managed bot whose token will be replaced
     */
    public long userId() {
        return userId;
    }

    public ReplaceManagedBotToken withUserId(long userId) {
        return new ReplaceManagedBotToken(userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReplaceManagedBotToken)) {
            return false;
        }
        ReplaceManagedBotToken that = (ReplaceManagedBotToken) o;
        return this.userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId);
    }

    @Override
    public String toString() {
        return "ReplaceManagedBotToken[userId=" + this.userId
                + "]";
    }
}
