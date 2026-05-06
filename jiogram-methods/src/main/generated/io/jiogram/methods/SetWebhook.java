package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UpdateType;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record SetWebhook(
    @JsonProperty("url") String url,
    @JsonProperty("certificate") @Nullable InputFile certificate,
    @JsonProperty("ip_address") @Nullable String ipAddress,
    @JsonProperty("max_connections") @Nullable Long maxConnections,
    @JsonProperty("allowed_updates") @Nullable List<UpdateType> allowedUpdates,
    @JsonProperty("drop_pending_updates") @Nullable Boolean dropPendingUpdates,
    @JsonProperty("secret_token") @Nullable String secretToken
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setWebhook";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetWebhook of(String url) {
        return new SetWebhook(url, null, null, null, null, null, null);
    }
}
