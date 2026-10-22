package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSourceType;
import io.jiogram.types.User;

/**
 * The boost was obtained by subscribing to Telegram Premium or by gifting a Telegram Premium
 * subscription to another user.
 *
 * @param source Source of the boost, always 'premium'
 * @param user User that boosted the chat
 * @see <a href="https://core.telegram.org/bots/api#chatboostsourcepremium">ChatBoostSourcePremium in the Bot API</a>
 */
public record ChatBoostSourcePremium(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) ChatBoostSourceType source,
    @JsonProperty("user") User user
) implements ChatBoostSource {}
