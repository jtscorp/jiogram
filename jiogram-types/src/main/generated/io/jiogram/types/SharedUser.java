package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about a user that was shared with the bot using a
 * KeyboardButtonRequestUsers button.
 *
 * @param userId Identifier of the shared user. This number may have more than 32 significant bits
 *     and some programming languages may have difficulty/silent defects in interpreting it. But it
 *     has at most 52 significant bits, so 64-bit integers or double-precision float types are safe
 *     for storing these identifiers. The bot may not have access to the user and could be unable to
 *     use this identifier, unless the user is already known to the bot by some other means.
 * @param firstName First name of the user, if the name was requested by the bot
 * @param lastName Last name of the user, if the name was requested by the bot
 * @param username Username of the user, if the username was requested by the bot
 * @param photo Available sizes of the chat photo, if the photo was requested by the bot
 * @see <a href="https://core.telegram.org/bots/api#shareduser">SharedUser in the Bot API</a>
 */
public record SharedUser(
    @JsonProperty("user_id") long userId,
    @JsonProperty("first_name") @Nullable String firstName,
    @JsonProperty("last_name") @Nullable String lastName,
    @JsonProperty("username") @Nullable String username,
    @JsonProperty("photo") @Nullable List<PhotoSize> photo
) {}
