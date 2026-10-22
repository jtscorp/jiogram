package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object defines the criteria used to request suitable users. Information about the selected
 * users will be shared with the bot when the corresponding button is pressed.
 *
 * @param requestId Signed 32-bit identifier of the request that will be received back in the
 *     UsersShared object. Must be unique within the message
 * @param userIsBot Pass True to request bots, pass False to request regular users. If not
 *     specified, no additional restrictions are applied.
 * @param userIsPremium Pass True to request premium users, pass False to request non-premium users.
 *     If not specified, no additional restrictions are applied.
 * @param maxQuantity The maximum number of users to be selected; 1-10. Defaults to 1.
 * @param requestName Pass True to request the users' first and last names
 * @param requestUsername Pass True to request the users' usernames
 * @param requestPhoto Pass True to request the users' photos
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestusers">KeyboardButtonRequestUsers in the Bot API</a>
 */
public record KeyboardButtonRequestUsers(
    @JsonProperty("request_id") long requestId,
    @JsonProperty("user_is_bot") @Nullable Boolean userIsBot,
    @JsonProperty("user_is_premium") @Nullable Boolean userIsPremium,
    @JsonProperty("max_quantity") @Nullable Long maxQuantity,
    @JsonProperty("request_name") @Nullable Boolean requestName,
    @JsonProperty("request_username") @Nullable Boolean requestUsername,
    @JsonProperty("request_photo") @Nullable Boolean requestPhoto
) {

    public static KeyboardButtonRequestUsers of(long requestId) {
        return new KeyboardButtonRequestUsers(requestId, null, null, null, null, null, null);
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
}
