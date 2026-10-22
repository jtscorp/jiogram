package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * This object contains information about the bot that was created to be managed by the current bot.
 *
 * @see <a href="https://core.telegram.org/bots/api#managedbotcreated">ManagedBotCreated in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ManagedBotCreated {

    @JsonProperty("bot")
    private final User bot;

    /**
     * Creates a new {@code ManagedBotCreated} instance.
     *
     * @param bot Information about the bot. The bot's token can be fetched using the method
     *     getManagedBotToken.
     */
    @JsonCreator
    public ManagedBotCreated(
            @JsonProperty("bot") User bot) {
        this.bot = bot;
    }

    /**
     * Information about the bot. The bot's token can be fetched using the method
     * getManagedBotToken.
     */
    public User bot() {
        return bot;
    }

    public ManagedBotCreated withBot(User bot) {
        return new ManagedBotCreated(bot);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ManagedBotCreated)) {
            return false;
        }
        ManagedBotCreated that = (ManagedBotCreated) o;
        return Objects.equals(this.bot, that.bot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.bot);
    }

    @Override
    public String toString() {
        return "ManagedBotCreated[bot=" + this.bot
                + "]";
    }
}
