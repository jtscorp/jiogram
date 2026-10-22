package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * This object contains information about the creation or token update of a bot that is managed by
 * the current bot.
 *
 * @see <a href="https://core.telegram.org/bots/api#managedbotupdated">ManagedBotUpdated in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ManagedBotUpdated {

    @JsonProperty("user")
    private final User user;

    @JsonProperty("bot")
    private final User bot;

    /**
     * Creates a new {@code ManagedBotUpdated} instance.
     *
     * @param user User that created the bot
     * @param bot Information about the bot. Token of the bot can be fetched using the method
     *     getManagedBotToken.
     */
    @JsonCreator
    public ManagedBotUpdated(
            @JsonProperty("user") User user,
            @JsonProperty("bot") User bot) {
        this.user = user;
        this.bot = bot;
    }

    /**
     * User that created the bot
     */
    public User user() {
        return user;
    }

    /**
     * Information about the bot. Token of the bot can be fetched using the method
     * getManagedBotToken.
     */
    public User bot() {
        return bot;
    }

    public ManagedBotUpdated withUser(User user) {
        return new ManagedBotUpdated(user, bot);
    }

    public ManagedBotUpdated withBot(User bot) {
        return new ManagedBotUpdated(user, bot);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ManagedBotUpdated)) {
            return false;
        }
        ManagedBotUpdated that = (ManagedBotUpdated) o;
        return Objects.equals(this.user, that.user)
                && Objects.equals(this.bot, that.bot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.user, this.bot);
    }

    @Override
    public String toString() {
        return "ManagedBotUpdated[user=" + this.user
                + ", bot=" + this.bot
                + "]";
    }
}
