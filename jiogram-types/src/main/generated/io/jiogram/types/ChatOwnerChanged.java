package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * Describes a service message about an ownership change in the chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatownerchanged">ChatOwnerChanged in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatOwnerChanged {

    @JsonProperty("new_owner")
    private final User newOwner;

    /**
     * Creates a new {@code ChatOwnerChanged} instance.
     *
     * @param newOwner The new owner of the chat
     */
    @JsonCreator
    public ChatOwnerChanged(
            @JsonProperty("new_owner") User newOwner) {
        this.newOwner = newOwner;
    }

    /**
     * The new owner of the chat
     */
    public User newOwner() {
        return newOwner;
    }

    public ChatOwnerChanged withNewOwner(User newOwner) {
        return new ChatOwnerChanged(newOwner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatOwnerChanged)) {
            return false;
        }
        ChatOwnerChanged that = (ChatOwnerChanged) o;
        return Objects.equals(this.newOwner, that.newOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.newOwner);
    }

    @Override
    public String toString() {
        return "ChatOwnerChanged[newOwner=" + this.newOwner
                + "]";
    }
}
