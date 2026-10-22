package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to remove webhook integration if you decide to switch back to getUpdates. Returns
 * True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletewebhook">deleteWebhook in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeleteWebhook implements TelegramMethod<Boolean> {

    @JsonProperty("drop_pending_updates")
    private final @Nullable Boolean dropPendingUpdates;

    /**
     * Creates a new {@code DeleteWebhook} instance.
     *
     * @param dropPendingUpdates Pass True to drop all pending updates
     */
    @JsonCreator
    public DeleteWebhook(
            @JsonProperty("drop_pending_updates") @Nullable Boolean dropPendingUpdates) {
        this.dropPendingUpdates = dropPendingUpdates;
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

    /**
     * Pass True to drop all pending updates
     */
    public @Nullable Boolean dropPendingUpdates() {
        return dropPendingUpdates;
    }

    public DeleteWebhook withDropPendingUpdates(@Nullable Boolean dropPendingUpdates) {
        return new DeleteWebhook(dropPendingUpdates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeleteWebhook)) {
            return false;
        }
        DeleteWebhook that = (DeleteWebhook) o;
        return Objects.equals(this.dropPendingUpdates, that.dropPendingUpdates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.dropPendingUpdates);
    }

    @Override
    public String toString() {
        return "DeleteWebhook[dropPendingUpdates=" + this.dropPendingUpdates
                + "]";
    }
}
