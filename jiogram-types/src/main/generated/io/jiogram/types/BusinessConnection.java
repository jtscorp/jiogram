package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessBotRights;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes the connection of the bot with a business account.
 *
 * @see <a href="https://core.telegram.org/bots/api#businessconnection">BusinessConnection in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BusinessConnection {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("user")
    private final User user;

    @JsonProperty("user_chat_id")
    private final long userChatId;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("rights")
    private final @Nullable BusinessBotRights rights;

    @JsonProperty("is_enabled")
    private final boolean isEnabled;

    /**
     * Creates a new {@code BusinessConnection} instance.
     *
     * @param id Unique identifier of the business connection
     * @param user Business account user that created the business connection
     * @param userChatId Identifier of a private chat with the user who created the business
     *     connection. This number may have more than 32 significant bits and some programming
     *     languages may have difficulty/silent defects in interpreting it. But it has at most 52
     *     significant bits, so a 64-bit integer or double-precision float type are safe for storing
     *     this identifier.
     * @param date Date the connection was established in Unix time
     * @param rights Rights of the business bot
     * @param isEnabled True, if the connection is active
     */
    @JsonCreator
    public BusinessConnection(
            @JsonProperty("id") String id,
            @JsonProperty("user") User user,
            @JsonProperty("user_chat_id") long userChatId,
            @JsonProperty("date") long date,
            @JsonProperty("rights") @Nullable BusinessBotRights rights,
            @JsonProperty("is_enabled") boolean isEnabled) {
        this.id = id;
        this.user = user;
        this.userChatId = userChatId;
        this.date = date;
        this.rights = rights;
        this.isEnabled = isEnabled;
    }

    public static BusinessConnection of(String id, User user, long userChatId, long date, boolean isEnabled) {
        return new BusinessConnection(id, user, userChatId, date, null, isEnabled);
    }

    /**
     * Unique identifier of the business connection
     */
    public String id() {
        return id;
    }

    /**
     * Business account user that created the business connection
     */
    public User user() {
        return user;
    }

    /**
     * Identifier of a private chat with the user who created the business connection. This number
     * may have more than 32 significant bits and some programming languages may have
     * difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a
     * 64-bit integer or double-precision float type are safe for storing this identifier.
     */
    public long userChatId() {
        return userChatId;
    }

    /**
     * Date the connection was established in Unix time
     */
    public long date() {
        return date;
    }

    /**
     * Rights of the business bot
     */
    public @Nullable BusinessBotRights rights() {
        return rights;
    }

    /**
     * True, if the connection is active
     */
    public boolean isEnabled() {
        return isEnabled;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BusinessConnection)) {
            return false;
        }
        BusinessConnection that = (BusinessConnection) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.user, that.user)
                && this.userChatId == that.userChatId
                && this.date == that.date
                && Objects.equals(this.rights, that.rights)
                && this.isEnabled == that.isEnabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.user, this.userChatId, this.date, this.rights, this.isEnabled);
    }

    @Override
    public String toString() {
        return "BusinessConnection[id=" + this.id
                + ", user=" + this.user
                + ", userChatId=" + this.userChatId
                + ", date=" + this.date
                + ", rights=" + this.rights
                + ", isEnabled=" + this.isEnabled
                + "]";
    }
}
