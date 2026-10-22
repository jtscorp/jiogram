package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Changes the username of a managed business account. Requires the can_change_username business bot
 * right. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setbusinessaccountusername">setBusinessAccountUsername in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetBusinessAccountUsername implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("username")
    private final @Nullable String username;

    /**
     * Creates a new {@code SetBusinessAccountUsername} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param username The new value of the username for the business account; 0-32 characters
     */
    @JsonCreator
    public SetBusinessAccountUsername(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("username") @Nullable String username) {
        this.businessConnectionId = businessConnectionId;
        this.username = username;
    }

    @Override
    public String apiMethod() {
        return "setBusinessAccountUsername";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetBusinessAccountUsername of(String businessConnectionId) {
        return new SetBusinessAccountUsername(businessConnectionId, null);
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * The new value of the username for the business account; 0-32 characters
     */
    public @Nullable String username() {
        return username;
    }

    public SetBusinessAccountUsername withBusinessConnectionId(String businessConnectionId) {
        return new SetBusinessAccountUsername(businessConnectionId, username);
    }

    public SetBusinessAccountUsername withUsername(@Nullable String username) {
        return new SetBusinessAccountUsername(businessConnectionId, username);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetBusinessAccountUsername)) {
            return false;
        }
        SetBusinessAccountUsername that = (SetBusinessAccountUsername) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.username);
    }

    @Override
    public String toString() {
        return "SetBusinessAccountUsername[businessConnectionId=" + this.businessConnectionId
                + ", username=" + this.username
                + "]";
    }
}
