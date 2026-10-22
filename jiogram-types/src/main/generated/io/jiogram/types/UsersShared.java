package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SharedUser;
import java.util.List;
import java.util.Objects;

/**
 * This object contains information about the users whose identifiers were shared with the bot using
 * a KeyboardButtonRequestUsers button.
 *
 * @see <a href="https://core.telegram.org/bots/api#usersshared">UsersShared in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UsersShared {

    @JsonProperty("request_id")
    private final long requestId;

    @JsonProperty("users")
    private final List<SharedUser> users;

    /**
     * Creates a new {@code UsersShared} instance.
     *
     * @param requestId Identifier of the request
     * @param users Information about users shared with the bot.
     */
    @JsonCreator
    public UsersShared(
            @JsonProperty("request_id") long requestId,
            @JsonProperty("users") List<SharedUser> users) {
        this.requestId = requestId;
        this.users = users;
    }

    /**
     * Identifier of the request
     */
    public long requestId() {
        return requestId;
    }

    /**
     * Information about users shared with the bot.
     */
    public List<SharedUser> users() {
        return users;
    }

    public UsersShared withRequestId(long requestId) {
        return new UsersShared(requestId, users);
    }

    public UsersShared withUsers(List<SharedUser> users) {
        return new UsersShared(requestId, users);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UsersShared)) {
            return false;
        }
        UsersShared that = (UsersShared) o;
        return this.requestId == that.requestId
                && Objects.equals(this.users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requestId, this.users);
    }

    @Override
    public String toString() {
        return "UsersShared[requestId=" + this.requestId
                + ", users=" + this.users
                + "]";
    }
}
