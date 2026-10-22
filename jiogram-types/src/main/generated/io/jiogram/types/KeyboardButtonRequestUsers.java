package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object defines the criteria used to request suitable users. Information about the selected
 * users will be shared with the bot when the corresponding button is pressed.
 *
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestusers">KeyboardButtonRequestUsers in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class KeyboardButtonRequestUsers {

    @JsonProperty("request_id")
    private final long requestId;

    @JsonProperty("user_is_bot")
    private final @Nullable Boolean userIsBot;

    @JsonProperty("user_is_premium")
    private final @Nullable Boolean userIsPremium;

    @JsonProperty("max_quantity")
    private final @Nullable Long maxQuantity;

    @JsonProperty("request_name")
    private final @Nullable Boolean requestName;

    @JsonProperty("request_username")
    private final @Nullable Boolean requestUsername;

    @JsonProperty("request_photo")
    private final @Nullable Boolean requestPhoto;

    /**
     * Creates a new {@code KeyboardButtonRequestUsers} instance.
     *
     * @param requestId Signed 32-bit identifier of the request that will be received back in the
     *     UsersShared object. Must be unique within the message
     * @param userIsBot Pass True to request bots, pass False to request regular users. If not
     *     specified, no additional restrictions are applied.
     * @param userIsPremium Pass True to request premium users, pass False to request non-premium
     *     users. If not specified, no additional restrictions are applied.
     * @param maxQuantity The maximum number of users to be selected; 1-10. Defaults to 1.
     * @param requestName Pass True to request the users' first and last names
     * @param requestUsername Pass True to request the users' usernames
     * @param requestPhoto Pass True to request the users' photos
     */
    @JsonCreator
    public KeyboardButtonRequestUsers(
            @JsonProperty("request_id") long requestId,
            @JsonProperty("user_is_bot") @Nullable Boolean userIsBot,
            @JsonProperty("user_is_premium") @Nullable Boolean userIsPremium,
            @JsonProperty("max_quantity") @Nullable Long maxQuantity,
            @JsonProperty("request_name") @Nullable Boolean requestName,
            @JsonProperty("request_username") @Nullable Boolean requestUsername,
            @JsonProperty("request_photo") @Nullable Boolean requestPhoto) {
        this.requestId = requestId;
        this.userIsBot = userIsBot;
        this.userIsPremium = userIsPremium;
        this.maxQuantity = maxQuantity;
        this.requestName = requestName;
        this.requestUsername = requestUsername;
        this.requestPhoto = requestPhoto;
    }

    public static KeyboardButtonRequestUsers of(long requestId) {
        return new KeyboardButtonRequestUsers(requestId, null, null, null, null, null, null);
    }

    /**
     * Signed 32-bit identifier of the request that will be received back in the UsersShared object.
     * Must be unique within the message
     */
    public long requestId() {
        return requestId;
    }

    /**
     * Pass True to request bots, pass False to request regular users. If not specified, no
     * additional restrictions are applied.
     */
    public @Nullable Boolean userIsBot() {
        return userIsBot;
    }

    /**
     * Pass True to request premium users, pass False to request non-premium users. If not
     * specified, no additional restrictions are applied.
     */
    public @Nullable Boolean userIsPremium() {
        return userIsPremium;
    }

    /**
     * The maximum number of users to be selected; 1-10. Defaults to 1.
     */
    public @Nullable Long maxQuantity() {
        return maxQuantity;
    }

    /**
     * Pass True to request the users' first and last names
     */
    public @Nullable Boolean requestName() {
        return requestName;
    }

    /**
     * Pass True to request the users' usernames
     */
    public @Nullable Boolean requestUsername() {
        return requestUsername;
    }

    /**
     * Pass True to request the users' photos
     */
    public @Nullable Boolean requestPhoto() {
        return requestPhoto;
    }

    public KeyboardButtonRequestUsers withRequestId(long requestId) {
        return new KeyboardButtonRequestUsers(requestId, userIsBot, userIsPremium, maxQuantity, requestName, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestUsers withUserIsBot(@Nullable Boolean userIsBot) {
        return new KeyboardButtonRequestUsers(requestId, userIsBot, userIsPremium, maxQuantity, requestName, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestUsers withUserIsPremium(@Nullable Boolean userIsPremium) {
        return new KeyboardButtonRequestUsers(requestId, userIsBot, userIsPremium, maxQuantity, requestName, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestUsers withMaxQuantity(@Nullable Long maxQuantity) {
        return new KeyboardButtonRequestUsers(requestId, userIsBot, userIsPremium, maxQuantity, requestName, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestUsers withRequestName(@Nullable Boolean requestName) {
        return new KeyboardButtonRequestUsers(requestId, userIsBot, userIsPremium, maxQuantity, requestName, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestUsers withRequestUsername(@Nullable Boolean requestUsername) {
        return new KeyboardButtonRequestUsers(requestId, userIsBot, userIsPremium, maxQuantity, requestName, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestUsers withRequestPhoto(@Nullable Boolean requestPhoto) {
        return new KeyboardButtonRequestUsers(requestId, userIsBot, userIsPremium, maxQuantity, requestName, requestUsername, requestPhoto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KeyboardButtonRequestUsers)) {
            return false;
        }
        KeyboardButtonRequestUsers that = (KeyboardButtonRequestUsers) o;
        return this.requestId == that.requestId
                && Objects.equals(this.userIsBot, that.userIsBot)
                && Objects.equals(this.userIsPremium, that.userIsPremium)
                && Objects.equals(this.maxQuantity, that.maxQuantity)
                && Objects.equals(this.requestName, that.requestName)
                && Objects.equals(this.requestUsername, that.requestUsername)
                && Objects.equals(this.requestPhoto, that.requestPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requestId, this.userIsBot, this.userIsPremium, this.maxQuantity, this.requestName, this.requestUsername, this.requestPhoto);
    }

    @Override
    public String toString() {
        return "KeyboardButtonRequestUsers[requestId=" + this.requestId
                + ", userIsBot=" + this.userIsBot
                + ", userIsPremium=" + this.userIsPremium
                + ", maxQuantity=" + this.maxQuantity
                + ", requestName=" + this.requestName
                + ", requestUsername=" + this.requestUsername
                + ", requestPhoto=" + this.requestPhoto
                + "]";
    }
}
