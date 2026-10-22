package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PollType;
import org.jspecify.annotations.Nullable;

/**
 * This object represents type of a poll, which is allowed to be created and sent when the
 * corresponding button is pressed.
 *
 * @param type If quiz is passed, the user will be allowed to create only polls in the quiz mode. If
 *     regular is passed, only regular polls will be allowed. Otherwise, the user will be allowed to
 *     create a poll of any type.
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonpolltype">KeyboardButtonPollType in the Bot API</a>
 */
public record KeyboardButtonPollType(
    @JsonProperty("type") @Nullable PollType type
) {}
