package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.WebhookInfo;

/**
 * Use this method to get current webhook status. Requires no parameters. On success, returns a
 * WebhookInfo object. If the bot is using getUpdates, will return an object with the url field
 * empty.
 *
 * @see <a href="https://core.telegram.org/bots/api#getwebhookinfo">getWebhookInfo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetWebhookInfo implements TelegramMethod<WebhookInfo> {

    /**
     * Creates a new {@code GetWebhookInfo} instance.
     */
    public GetWebhookInfo() {
    }

    @Override
    public String apiMethod() {
        return "getWebhookInfo";
    }

    @Override
    public String apiReturnType() {
        return "WebhookInfo";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof GetWebhookInfo;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "GetWebhookInfo[]";
    }
}
