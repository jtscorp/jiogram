package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

/**
 * This object contains information about the creation or token update of a bot that is managed by
 * the current bot.
 *
 * @param user User that created the bot
 * @param bot Information about the bot. Token of the bot can be fetched using the method
 *     getManagedBotToken.
 * @see <a href="https://core.telegram.org/bots/api#managedbotupdated">ManagedBotUpdated in the Bot API</a>
 */
public record ManagedBotUpdated(
    @JsonProperty("user") User user,
    @JsonProperty("bot") User bot
) {}
