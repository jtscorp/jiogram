package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import io.jiogram.types.StarAmount;
import io.jiogram.types.TelegramMethod;

/**
 * A method to get the current Telegram Stars balance of the bot. Requires no parameters. On
 * success, returns a StarAmount object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getmystarbalance">getMyStarBalance in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetMyStarBalance implements TelegramMethod<StarAmount> {

    /**
     * Creates a new {@code GetMyStarBalance} instance.
     */
    public GetMyStarBalance() {
    }

    @Override
    public String apiMethod() {
        return "getMyStarBalance";
    }

    @Override
    public String apiReturnType() {
        return "StarAmount";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof GetMyStarBalance;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "GetMyStarBalance[]";
    }
}
