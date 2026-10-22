package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageOriginType;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * The message was originally sent by a known user.
 *
 * @see <a href="https://core.telegram.org/bots/api#messageoriginuser">MessageOriginUser in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MessageOriginUser implements MessageOrigin {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final MessageOriginType type;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("sender_user")
    private final User senderUser;

    /**
     * Creates a new {@code MessageOriginUser} instance.
     *
     * @param type Type of the message origin, always 'user'
     * @param date Date the message was sent originally in Unix time
     * @param senderUser User that sent the message originally
     */
    @JsonCreator
    public MessageOriginUser(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MessageOriginType type,
            @JsonProperty("date") long date,
            @JsonProperty("sender_user") User senderUser) {
        this.type = type;
        this.date = date;
        this.senderUser = senderUser;
    }

    public static MessageOriginUser of(long date, User senderUser) {
        return new MessageOriginUser(MessageOriginType.USER, date, senderUser);
    }

    /**
     * Type of the message origin, always 'user'
     */
    public MessageOriginType type() {
        return type;
    }

    /**
     * Date the message was sent originally in Unix time
     */
    public long date() {
        return date;
    }

    /**
     * User that sent the message originally
     */
    public User senderUser() {
        return senderUser;
    }

    public MessageOriginUser withDate(long date) {
        return new MessageOriginUser(type, date, senderUser);
    }

    public MessageOriginUser withSenderUser(User senderUser) {
        return new MessageOriginUser(type, date, senderUser);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageOriginUser)) {
            return false;
        }
        MessageOriginUser that = (MessageOriginUser) o;
        return Objects.equals(this.type, that.type)
                && this.date == that.date
                && Objects.equals(this.senderUser, that.senderUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.date, this.senderUser);
    }

    @Override
    public String toString() {
        return "MessageOriginUser[type=" + this.type
                + ", date=" + this.date
                + ", senderUser=" + this.senderUser
                + "]";
    }
}
