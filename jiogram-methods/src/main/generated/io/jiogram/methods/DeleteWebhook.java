package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record DeleteWebhook(
    @JsonProperty("drop_pending_updates") @Nullable Boolean dropPendingUpdates
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteWebhook";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static DeleteWebhook of() {
        return new DeleteWebhook(null);
    }
}
