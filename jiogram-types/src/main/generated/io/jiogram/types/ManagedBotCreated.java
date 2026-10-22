package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

/**
 * This object contains information about the bot that was created to be managed by the current bot.
 *
 * @param bot Information about the bot. The bot's token can be fetched using the method
 *     getManagedBotToken.
 * @see <a href="https://core.telegram.org/bots/api#managedbotcreated">ManagedBotCreated in the Bot API</a>
 */
public record ManagedBotCreated(
    @JsonProperty("bot") User bot
) {

    public ManagedBotCreated withBot(User bot) {
        return new ManagedBotCreated(bot);
    }
}
