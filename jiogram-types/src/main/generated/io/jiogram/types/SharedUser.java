package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about a user that was shared with the bot using a
 * KeyboardButtonRequestUsers button.
 *
 * @see <a href="https://core.telegram.org/bots/api#shareduser">SharedUser in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SharedUser {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("first_name")
    private final @Nullable String firstName;

    @JsonProperty("last_name")
    private final @Nullable String lastName;

    @JsonProperty("username")
    private final @Nullable String username;

    @JsonProperty("photo")
    private final @Nullable List<PhotoSize> photo;

    /**
     * Creates a new {@code SharedUser} instance.
     *
     * @param userId Identifier of the shared user. This number may have more than 32 significant
     *     bits and some programming languages may have difficulty/silent defects in interpreting
     *     it. But it has at most 52 significant bits, so 64-bit integers or double-precision float
     *     types are safe for storing these identifiers. The bot may not have access to the user and
     *     could be unable to use this identifier, unless the user is already known to the bot by
     *     some other means.
     * @param firstName First name of the user, if the name was requested by the bot
     * @param lastName Last name of the user, if the name was requested by the bot
     * @param username Username of the user, if the username was requested by the bot
     * @param photo Available sizes of the chat photo, if the photo was requested by the bot
     */
    @JsonCreator
    public SharedUser(
            @JsonProperty("user_id") long userId,
            @JsonProperty("first_name") @Nullable String firstName,
            @JsonProperty("last_name") @Nullable String lastName,
            @JsonProperty("username") @Nullable String username,
            @JsonProperty("photo") @Nullable List<PhotoSize> photo) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.photo = photo;
    }

    public static SharedUser of(long userId) {
        return new SharedUser(userId, null, null, null, null);
    }

    /**
     * Identifier of the shared user. This number may have more than 32 significant bits and some
     * programming languages may have difficulty/silent defects in interpreting it. But it has at
     * most 52 significant bits, so 64-bit integers or double-precision float types are safe for
     * storing these identifiers. The bot may not have access to the user and could be unable to use
     * this identifier, unless the user is already known to the bot by some other means.
     */
    public long userId() {
        return userId;
    }

    /**
     * First name of the user, if the name was requested by the bot
     */
    public @Nullable String firstName() {
        return firstName;
    }

    /**
     * Last name of the user, if the name was requested by the bot
     */
    public @Nullable String lastName() {
        return lastName;
    }

    /**
     * Username of the user, if the username was requested by the bot
     */
    public @Nullable String username() {
        return username;
    }

    /**
     * Available sizes of the chat photo, if the photo was requested by the bot
     */
    public @Nullable List<PhotoSize> photo() {
        return photo;
    }

    public SharedUser withUserId(long userId) {
        return new SharedUser(userId, firstName, lastName, username, photo);
    }

    public SharedUser withFirstName(@Nullable String firstName) {
        return new SharedUser(userId, firstName, lastName, username, photo);
    }

    public SharedUser withLastName(@Nullable String lastName) {
        return new SharedUser(userId, firstName, lastName, username, photo);
    }

    public SharedUser withUsername(@Nullable String username) {
        return new SharedUser(userId, firstName, lastName, username, photo);
    }

    public SharedUser withPhoto(@Nullable List<PhotoSize> photo) {
        return new SharedUser(userId, firstName, lastName, username, photo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SharedUser)) {
            return false;
        }
        SharedUser that = (SharedUser) o;
        return this.userId == that.userId
                && Objects.equals(this.firstName, that.firstName)
                && Objects.equals(this.lastName, that.lastName)
                && Objects.equals(this.username, that.username)
                && Objects.equals(this.photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.firstName, this.lastName, this.username, this.photo);
    }

    @Override
    public String toString() {
        return "SharedUser[userId=" + this.userId
                + ", firstName=" + this.firstName
                + ", lastName=" + this.lastName
                + ", username=" + this.username
                + ", photo=" + this.photo
                + "]";
    }
}
