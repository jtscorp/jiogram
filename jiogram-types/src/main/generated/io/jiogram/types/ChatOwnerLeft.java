package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about the chat owner leaving the chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatownerleft">ChatOwnerLeft in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatOwnerLeft {

    @JsonProperty("new_owner")
    private final @Nullable User newOwner;

    /**
     * Creates a new {@code ChatOwnerLeft} instance.
     *
     * @param newOwner The user which will be the new owner of the chat if the previous owner does
     *     not return to the chat
     */
    @JsonCreator
    public ChatOwnerLeft(
            @JsonProperty("new_owner") @Nullable User newOwner) {
        this.newOwner = newOwner;
    }

    public static ChatOwnerLeft of() {
        return new ChatOwnerLeft(null);
    }

    /**
     * The user which will be the new owner of the chat if the previous owner does not return to the
     * chat
     */
    public @Nullable User newOwner() {
        return newOwner;
    }

    public ChatOwnerLeft withNewOwner(@Nullable User newOwner) {
        return new ChatOwnerLeft(newOwner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatOwnerLeft)) {
            return false;
        }
        ChatOwnerLeft that = (ChatOwnerLeft) o;
        return Objects.equals(this.newOwner, that.newOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.newOwner);
    }

    @Override
    public String toString() {
        return "ChatOwnerLeft[newOwner=" + this.newOwner
                + "]";
    }
}
