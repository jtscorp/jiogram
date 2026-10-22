package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SharedUser;
import java.util.List;

/**
 * This object contains information about the users whose identifiers were shared with the bot using
 * a KeyboardButtonRequestUsers button.
 *
 * @param requestId Identifier of the request
 * @param users Information about users shared with the bot.
 * @see <a href="https://core.telegram.org/bots/api#usersshared">UsersShared in the Bot API</a>
 */
public record UsersShared(
    @JsonProperty("request_id") long requestId,
    @JsonProperty("users") List<SharedUser> users
) {}
