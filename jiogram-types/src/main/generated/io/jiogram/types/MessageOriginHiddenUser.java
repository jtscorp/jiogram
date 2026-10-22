package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageOriginType;
import java.util.Objects;

/**
 * The message was originally sent by an unknown user.
 *
 * @see <a href="https://core.telegram.org/bots/api#messageoriginhiddenuser">MessageOriginHiddenUser in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MessageOriginHiddenUser implements MessageOrigin {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final MessageOriginType type;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("sender_user_name")
    private final String senderUserName;

    /**
     * Creates a new {@code MessageOriginHiddenUser} instance.
     *
     * @param type Type of the message origin, always 'hidden_user'
     * @param date Date the message was sent originally in Unix time
     * @param senderUserName Name of the user that sent the message originally
     */
    @JsonCreator
    public MessageOriginHiddenUser(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MessageOriginType type,
            @JsonProperty("date") long date,
            @JsonProperty("sender_user_name") String senderUserName) {
        this.type = type;
        this.date = date;
        this.senderUserName = senderUserName;
    }

    public static MessageOriginHiddenUser of(long date, String senderUserName) {
        return new MessageOriginHiddenUser(MessageOriginType.HIDDEN_USER, date, senderUserName);
    }

    /**
     * Type of the message origin, always 'hidden_user'
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
     * Name of the user that sent the message originally
     */
    public String senderUserName() {
        return senderUserName;
    }

    public MessageOriginHiddenUser withDate(long date) {
        return new MessageOriginHiddenUser(type, date, senderUserName);
    }

    public MessageOriginHiddenUser withSenderUserName(String senderUserName) {
        return new MessageOriginHiddenUser(type, date, senderUserName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageOriginHiddenUser)) {
            return false;
        }
        MessageOriginHiddenUser that = (MessageOriginHiddenUser) o;
        return Objects.equals(this.type, that.type)
                && this.date == that.date
                && Objects.equals(this.senderUserName, that.senderUserName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.date, this.senderUserName);
    }

    @Override
    public String toString() {
        return "MessageOriginHiddenUser[type=" + this.type
                + ", date=" + this.date
                + ", senderUserName=" + this.senderUserName
                + "]";
    }
}
