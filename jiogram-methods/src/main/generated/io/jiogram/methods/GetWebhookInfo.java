package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.WebhookInfo;

/**
 * Use this method to get current webhook status. Requires no parameters. On success, returns a
 * WebhookInfo object. If the bot is using getUpdates, will return an object with the url field
 * empty.
 *
 * @see <a href="https://core.telegram.org/bots/api#getwebhookinfo">getWebhookInfo in the Bot API</a>
 */
public record GetWebhookInfo(

) implements TelegramMethod<WebhookInfo> {

    @Override
    public String apiMethod() {
        return "getWebhookInfo";
    }

    @Override
    public String apiReturnType() {
        return "WebhookInfo";
    }
}
