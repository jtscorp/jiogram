package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Describes an inline message to be sent by a user of a Mini App.
 *
 * @see <a href="https://core.telegram.org/bots/api#preparedinlinemessage">PreparedInlineMessage in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PreparedInlineMessage {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("expiration_date")
    private final long expirationDate;

    /**
     * Creates a new {@code PreparedInlineMessage} instance.
     *
     * @param id Unique identifier of the prepared message
     * @param expirationDate Expiration date of the prepared message, in Unix time. Expired prepared
     *     messages can no longer be used
     */
    @JsonCreator
    public PreparedInlineMessage(
            @JsonProperty("id") String id,
            @JsonProperty("expiration_date") long expirationDate) {
        this.id = id;
        this.expirationDate = expirationDate;
    }

    /**
     * Unique identifier of the prepared message
     */
    public String id() {
        return id;
    }

    /**
     * Expiration date of the prepared message, in Unix time. Expired prepared messages can no
     * longer be used
     */
    public long expirationDate() {
        return expirationDate;
    }

    public PreparedInlineMessage withId(String id) {
        return new PreparedInlineMessage(id, expirationDate);
    }

    public PreparedInlineMessage withExpirationDate(long expirationDate) {
        return new PreparedInlineMessage(id, expirationDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PreparedInlineMessage)) {
            return false;
        }
        PreparedInlineMessage that = (PreparedInlineMessage) o;
        return Objects.equals(this.id, that.id)
                && this.expirationDate == that.expirationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.expirationDate);
    }

    @Override
    public String toString() {
        return "PreparedInlineMessage[id=" + this.id
                + ", expirationDate=" + this.expirationDate
                + "]";
    }
}
