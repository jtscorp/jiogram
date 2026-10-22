package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSourceType;
import io.jiogram.types.User;

/**
 * The boost was obtained by the creation of Telegram Premium gift codes to boost a chat. Each such
 * code boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.
 *
 * @param source Source of the boost, always 'gift_code'
 * @param user User for which the gift code was created
 * @see <a href="https://core.telegram.org/bots/api#chatboostsourcegiftcode">ChatBoostSourceGiftCode in the Bot API</a>
 */
public record ChatBoostSourceGiftCode(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) ChatBoostSourceType source,
    @JsonProperty("user") User user
) implements ChatBoostSource {}
