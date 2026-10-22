package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoost;
import java.util.List;
import java.util.Objects;

/**
 * This object represents a list of boosts added to a chat by a user.
 *
 * @see <a href="https://core.telegram.org/bots/api#userchatboosts">UserChatBoosts in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UserChatBoosts {

    @JsonProperty("boosts")
    private final List<ChatBoost> boosts;

    /**
     * Creates a new {@code UserChatBoosts} instance.
     *
     * @param boosts The list of boosts added to the chat by the user
     */
    @JsonCreator
    public UserChatBoosts(
            @JsonProperty("boosts") List<ChatBoost> boosts) {
        this.boosts = boosts;
    }

    /**
     * The list of boosts added to the chat by the user
     */
    public List<ChatBoost> boosts() {
        return boosts;
    }

    public UserChatBoosts withBoosts(List<ChatBoost> boosts) {
        return new UserChatBoosts(boosts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserChatBoosts)) {
            return false;
        }
        UserChatBoosts that = (UserChatBoosts) o;
        return Objects.equals(this.boosts, that.boosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.boosts);
    }

    @Override
    public String toString() {
        return "UserChatBoosts[boosts=" + this.boosts
                + "]";
    }
}
