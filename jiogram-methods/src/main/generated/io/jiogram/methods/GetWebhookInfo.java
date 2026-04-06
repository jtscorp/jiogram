package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.WebhookInfo;

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
