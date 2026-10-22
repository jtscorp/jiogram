package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessBotRights;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Describes the connection of the bot with a business account.
 *
 * @param id Unique identifier of the business connection
 * @param user Business account user that created the business connection
 * @param userChatId Identifier of a private chat with the user who created the business connection.
 *     This number may have more than 32 significant bits and some programming languages may have
 *     difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a
 *     64-bit integer or double-precision float type are safe for storing this identifier.
 * @param date Date the connection was established in Unix time
 * @param rights Rights of the business bot
 * @param isEnabled True, if the connection is active
 * @see <a href="https://core.telegram.org/bots/api#businessconnection">BusinessConnection in the Bot API</a>
 */
public record BusinessConnection(
    @JsonProperty("id") String id,
    @JsonProperty("user") User user,
    @JsonProperty("user_chat_id") long userChatId,
    @JsonProperty("date") long date,
    @JsonProperty("rights") @Nullable BusinessBotRights rights,
    @JsonProperty("is_enabled") boolean isEnabled
) {

    public BusinessConnection withId(String id) {
        return new BusinessConnection(id, user, userChatId, date, rights, isEnabled);
    }

    public BusinessConnection withUser(User user) {
        return new BusinessConnection(id, user, userChatId, date, rights, isEnabled);
    }

    public BusinessConnection withUserChatId(long userChatId) {
        return new BusinessConnection(id, user, userChatId, date, rights, isEnabled);
    }

    public BusinessConnection withDate(long date) {
        return new BusinessConnection(id, user, userChatId, date, rights, isEnabled);
    }

    public BusinessConnection withRights(@Nullable BusinessBotRights rights) {
        return new BusinessConnection(id, user, userChatId, date, rights, isEnabled);
    }

    public BusinessConnection withIsEnabled(boolean isEnabled) {
        return new BusinessConnection(id, user, userChatId, date, rights, isEnabled);
    }
}
