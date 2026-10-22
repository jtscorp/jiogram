package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatType;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a chat.
 *
 * @param id Unique identifier for this chat. This number may have more than 32 significant bits and
 *     some programming languages may have difficulty/silent defects in interpreting it. But it has
 *     at most 52 significant bits, so a signed 64-bit integer or double-precision float type are
 *     safe for storing this identifier.
 * @param type Type of the chat, can be either 'private', 'group', 'supergroup' or 'channel'
 * @param title Title, for supergroups, channels and group chats
 * @param username Username, for private chats, supergroups and channels if available
 * @param firstName First name of the other party in a private chat
 * @param lastName Last name of the other party in a private chat
 * @param isForum True, if the supergroup chat is a forum (has topics enabled)
 * @param isDirectMessages True, if the chat is the direct messages chat of a channel
 * @see <a href="https://core.telegram.org/bots/api#chat">Chat in the Bot API</a>
 */
public record Chat(
    @JsonProperty("id") long id,
    @JsonProperty("type") ChatType type,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("username") @Nullable String username,
    @JsonProperty("first_name") @Nullable String firstName,
    @JsonProperty("last_name") @Nullable String lastName,
    @JsonProperty("is_forum") @Nullable Boolean isForum,
    @JsonProperty("is_direct_messages") @Nullable Boolean isDirectMessages
) {

    public Chat withId(long id) {
        return new Chat(id, type, title, username, firstName, lastName, isForum, isDirectMessages);
    }

    public Chat withType(ChatType type) {
        return new Chat(id, type, title, username, firstName, lastName, isForum, isDirectMessages);
    }

    public Chat withTitle(@Nullable String title) {
        return new Chat(id, type, title, username, firstName, lastName, isForum, isDirectMessages);
    }

    public Chat withUsername(@Nullable String username) {
        return new Chat(id, type, title, username, firstName, lastName, isForum, isDirectMessages);
    }

    public Chat withFirstName(@Nullable String firstName) {
        return new Chat(id, type, title, username, firstName, lastName, isForum, isDirectMessages);
    }

    public Chat withLastName(@Nullable String lastName) {
        return new Chat(id, type, title, username, firstName, lastName, isForum, isDirectMessages);
    }

    public Chat withIsForum(@Nullable Boolean isForum) {
        return new Chat(id, type, title, username, firstName, lastName, isForum, isDirectMessages);
    }

    public Chat withIsDirectMessages(@Nullable Boolean isDirectMessages) {
        return new Chat(id, type, title, username, firstName, lastName, isForum, isDirectMessages);
    }
}
