package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSourceType;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * The boost was obtained by subscribing to Telegram Premium or by gifting a Telegram Premium
 * subscription to another user.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatboostsourcepremium">ChatBoostSourcePremium in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatBoostSourcePremium implements ChatBoostSource {

    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY)
    private final ChatBoostSourceType source;

    @JsonProperty("user")
    private final User user;

    /**
     * Creates a new {@code ChatBoostSourcePremium} instance.
     *
     * @param source Source of the boost, always 'premium'
     * @param user User that boosted the chat
     */
    @JsonCreator
    public ChatBoostSourcePremium(
            @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) ChatBoostSourceType source,
            @JsonProperty("user") User user) {
        this.source = source;
        this.user = user;
    }

    public static ChatBoostSourcePremium of(User user) {
        return new ChatBoostSourcePremium(ChatBoostSourceType.PREMIUM, user);
    }

    /**
     * Source of the boost, always 'premium'
     */
    public ChatBoostSourceType source() {
        return source;
    }

    /**
     * User that boosted the chat
     */
    public User user() {
        return user;
    }

    public ChatBoostSourcePremium withUser(User user) {
        return new ChatBoostSourcePremium(source, user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatBoostSourcePremium)) {
            return false;
        }
        ChatBoostSourcePremium that = (ChatBoostSourcePremium) o;
        return Objects.equals(this.source, that.source)
                && Objects.equals(this.user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.source, this.user);
    }

    @Override
    public String toString() {
        return "ChatBoostSourcePremium[source=" + this.source
                + ", user=" + this.user
                + "]";
    }
}
