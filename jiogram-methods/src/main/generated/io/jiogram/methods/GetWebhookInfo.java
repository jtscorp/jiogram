package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.WebhookInfo;

public class GetWebhookInfo implements TelegramMethod<WebhookInfo> {
    @JsonCreator
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
}
