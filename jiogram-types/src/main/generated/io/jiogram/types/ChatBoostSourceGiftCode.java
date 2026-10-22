package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSourceType;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * The boost was obtained by the creation of Telegram Premium gift codes to boost a chat. Each such
 * code boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatboostsourcegiftcode">ChatBoostSourceGiftCode in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatBoostSourceGiftCode implements ChatBoostSource {

    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY)
    private final ChatBoostSourceType source;

    @JsonProperty("user")
    private final User user;

    /**
     * Creates a new {@code ChatBoostSourceGiftCode} instance.
     *
     * @param source Source of the boost, always 'gift_code'
     * @param user User for which the gift code was created
     */
    @JsonCreator
    public ChatBoostSourceGiftCode(
            @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) ChatBoostSourceType source,
            @JsonProperty("user") User user) {
        this.source = source;
        this.user = user;
    }

    public static ChatBoostSourceGiftCode of(User user) {
        return new ChatBoostSourceGiftCode(ChatBoostSourceType.GIFT_CODE, user);
    }

    /**
     * Source of the boost, always 'gift_code'
     */
    public ChatBoostSourceType source() {
        return source;
    }

    /**
     * User for which the gift code was created
     */
    public User user() {
        return user;
    }

    public ChatBoostSourceGiftCode withUser(User user) {
        return new ChatBoostSourceGiftCode(source, user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatBoostSourceGiftCode)) {
            return false;
        }
        ChatBoostSourceGiftCode that = (ChatBoostSourceGiftCode) o;
        return Objects.equals(this.source, that.source)
                && Objects.equals(this.user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.source, this.user);
    }

    @Override
    public String toString() {
        return "ChatBoostSourceGiftCode[source=" + this.source
                + ", user=" + this.user
                + "]";
    }
}
