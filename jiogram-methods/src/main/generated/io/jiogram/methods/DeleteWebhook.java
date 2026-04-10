package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class DeleteWebhook implements TelegramMethod<Boolean> {
    @JsonProperty("drop_pending_updates") @Nullable private final Boolean dropPendingUpdates;

    @JsonCreator
    public DeleteWebhook(
            @JsonProperty("drop_pending_updates") @Nullable Boolean dropPendingUpdates
    ) {
        this.dropPendingUpdates = dropPendingUpdates;
    }

    public Boolean dropPendingUpdates() {
        return this.dropPendingUpdates;
    }

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
