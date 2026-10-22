package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object defines the parameters for the creation of a managed bot. Information about the
 * created bot will be shared with the bot using the update managed_bot and a Message with the field
 * managed_bot_created.
 *
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestmanagedbot">KeyboardButtonRequestManagedBot in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class KeyboardButtonRequestManagedBot {

    @JsonProperty("request_id")
    private final long requestId;

    @JsonProperty("suggested_name")
    private final @Nullable String suggestedName;

    @JsonProperty("suggested_username")
    private final @Nullable String suggestedUsername;

    /**
     * Creates a new {@code KeyboardButtonRequestManagedBot} instance.
     *
     * @param requestId Signed 32-bit identifier of the request. Must be unique within the message
     * @param suggestedName Suggested name for the bot
     * @param suggestedUsername Suggested username for the bot
     */
    @JsonCreator
    public KeyboardButtonRequestManagedBot(
            @JsonProperty("request_id") long requestId,
            @JsonProperty("suggested_name") @Nullable String suggestedName,
            @JsonProperty("suggested_username") @Nullable String suggestedUsername) {
        this.requestId = requestId;
        this.suggestedName = suggestedName;
        this.suggestedUsername = suggestedUsername;
    }

    public static KeyboardButtonRequestManagedBot of(long requestId) {
        return new KeyboardButtonRequestManagedBot(requestId, null, null);
    }

    /**
     * Signed 32-bit identifier of the request. Must be unique within the message
     */
    public long requestId() {
        return requestId;
    }

    /**
     * Suggested name for the bot
     */
    public @Nullable String suggestedName() {
        return suggestedName;
    }

    /**
     * Suggested username for the bot
     */
    public @Nullable String suggestedUsername() {
        return suggestedUsername;
    }

    public KeyboardButtonRequestManagedBot withRequestId(long requestId) {
        return new KeyboardButtonRequestManagedBot(requestId, suggestedName, suggestedUsername);
    }

    public KeyboardButtonRequestManagedBot withSuggestedName(@Nullable String suggestedName) {
        return new KeyboardButtonRequestManagedBot(requestId, suggestedName, suggestedUsername);
    }

    public KeyboardButtonRequestManagedBot withSuggestedUsername(@Nullable String suggestedUsername) {
        return new KeyboardButtonRequestManagedBot(requestId, suggestedName, suggestedUsername);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KeyboardButtonRequestManagedBot)) {
            return false;
        }
        KeyboardButtonRequestManagedBot that = (KeyboardButtonRequestManagedBot) o;
        return this.requestId == that.requestId
                && Objects.equals(this.suggestedName, that.suggestedName)
                && Objects.equals(this.suggestedUsername, that.suggestedUsername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requestId, this.suggestedName, this.suggestedUsername);
    }

    @Override
    public String toString() {
        return "KeyboardButtonRequestManagedBot[requestId=" + this.requestId
                + ", suggestedName=" + this.suggestedName
                + ", suggestedUsername=" + this.suggestedUsername
                + "]";
    }
}
