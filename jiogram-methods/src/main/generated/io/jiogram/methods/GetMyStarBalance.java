package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarAmount;
import io.jiogram.types.TelegramMethod;

/**
 * A method to get the current Telegram Stars balance of the bot. Requires no parameters. On
 * success, returns a StarAmount object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getmystarbalance">getMyStarBalance in the Bot API</a>
 */
public record GetMyStarBalance(

) implements TelegramMethod<StarAmount> {

    @Override
    public String apiMethod() {
        return "getMyStarBalance";
    }

    @Override
    public String apiReturnType() {
        return "StarAmount";
    }
}
