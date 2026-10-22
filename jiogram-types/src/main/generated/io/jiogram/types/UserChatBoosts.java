package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoost;
import java.util.List;

/**
 * This object represents a list of boosts added to a chat by a user.
 *
 * @param boosts The list of boosts added to the chat by the user
 * @see <a href="https://core.telegram.org/bots/api#userchatboosts">UserChatBoosts in the Bot API</a>
 */
public record UserChatBoosts(
    @JsonProperty("boosts") List<ChatBoost> boosts
) {}
