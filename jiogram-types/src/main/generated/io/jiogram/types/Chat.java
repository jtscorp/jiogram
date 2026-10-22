package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chat">Chat in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Chat {

    @JsonProperty("id")
    private final long id;

    @JsonProperty("type")
    private final ChatType type;

    @JsonProperty("title")
    private final @Nullable String title;

    @JsonProperty("username")
    private final @Nullable String username;

    @JsonProperty("first_name")
    private final @Nullable String firstName;

    @JsonProperty("last_name")
    private final @Nullable String lastName;

    @JsonProperty("is_forum")
    private final @Nullable Boolean isForum;

    @JsonProperty("is_direct_messages")
    private final @Nullable Boolean isDirectMessages;

    /**
     * Creates a new {@code Chat} instance.
     *
     * @param id Unique identifier for this chat. This number may have more than 32 significant bits
     *     and some programming languages may have difficulty/silent defects in interpreting it. But
     *     it has at most 52 significant bits, so a signed 64-bit integer or double-precision float
     *     type are safe for storing this identifier.
     * @param type Type of the chat, can be either 'private', 'group', 'supergroup' or 'channel'
     * @param title Title, for supergroups, channels and group chats
     * @param username Username, for private chats, supergroups and channels if available
     * @param firstName First name of the other party in a private chat
     * @param lastName Last name of the other party in a private chat
     * @param isForum True, if the supergroup chat is a forum (has topics enabled)
     * @param isDirectMessages True, if the chat is the direct messages chat of a channel
     */
    @JsonCreator
    public Chat(
            @JsonProperty("id") long id,
            @JsonProperty("type") ChatType type,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("username") @Nullable String username,
            @JsonProperty("first_name") @Nullable String firstName,
            @JsonProperty("last_name") @Nullable String lastName,
            @JsonProperty("is_forum") @Nullable Boolean isForum,
            @JsonProperty("is_direct_messages") @Nullable Boolean isDirectMessages) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isForum = isForum;
        this.isDirectMessages = isDirectMessages;
    }

    public static Chat of(long id, ChatType type) {
        return new Chat(id, type, null, null, null, null, null, null);
    }

    /**
     * Unique identifier for this chat. This number may have more than 32 significant bits and some
     * programming languages may have difficulty/silent defects in interpreting it. But it has at
     * most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe
     * for storing this identifier.
     */
    public long id() {
        return id;
    }

    /**
     * Type of the chat, can be either 'private', 'group', 'supergroup' or 'channel'
     */
    public ChatType type() {
        return type;
    }

    /**
     * Title, for supergroups, channels and group chats
     */
    public @Nullable String title() {
        return title;
    }

    /**
     * Username, for private chats, supergroups and channels if available
     */
    public @Nullable String username() {
        return username;
    }

    /**
     * First name of the other party in a private chat
     */
    public @Nullable String firstName() {
        return firstName;
    }

    /**
     * Last name of the other party in a private chat
     */
    public @Nullable String lastName() {
        return lastName;
    }

    /**
     * True, if the supergroup chat is a forum (has topics enabled)
     */
    public @Nullable Boolean isForum() {
        return isForum;
    }

    /**
     * True, if the chat is the direct messages chat of a channel
     */
    public @Nullable Boolean isDirectMessages() {
        return isDirectMessages;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Chat)) {
            return false;
        }
        Chat that = (Chat) o;
        return this.id == that.id
                && Objects.equals(this.type, that.type)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.username, that.username)
                && Objects.equals(this.firstName, that.firstName)
                && Objects.equals(this.lastName, that.lastName)
                && Objects.equals(this.isForum, that.isForum)
                && Objects.equals(this.isDirectMessages, that.isDirectMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.type, this.title, this.username, this.firstName, this.lastName, this.isForum, this.isDirectMessages);
    }

    @Override
    public String toString() {
        return "Chat[id=" + this.id
                + ", type=" + this.type
                + ", title=" + this.title
                + ", username=" + this.username
                + ", firstName=" + this.firstName
                + ", lastName=" + this.lastName
                + ", isForum=" + this.isForum
                + ", isDirectMessages=" + this.isDirectMessages
                + "]";
    }
}
