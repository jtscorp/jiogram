package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to remove webhook integration if you decide to switch back to getUpdates. Returns
 * True on success.
 *
 * @param dropPendingUpdates Pass True to drop all pending updates
 * @see <a href="https://core.telegram.org/bots/api#deletewebhook">deleteWebhook in the Bot API</a>
 */
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

    public DeleteWebhook withDropPendingUpdates(@Nullable Boolean dropPendingUpdates) {
        return new DeleteWebhook(dropPendingUpdates);
    }
}
