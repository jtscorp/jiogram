package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class SetWebhook implements TelegramMethod<Boolean> {
    @JsonProperty("url") private final String url;
    @JsonProperty("certificate") @Nullable private final InputFile certificate;
    @JsonProperty("ip_address") @Nullable private final String ipAddress;
    @JsonProperty("max_connections") @Nullable private final Long maxConnections;
    @JsonProperty("allowed_updates") @Nullable private final List<String> allowedUpdates;
    @JsonProperty("drop_pending_updates") @Nullable private final Boolean dropPendingUpdates;
    @JsonProperty("secret_token") @Nullable private final String secretToken;

    @JsonCreator
    public SetWebhook(
            @JsonProperty("url") String url,
            @JsonProperty("certificate") @Nullable InputFile certificate,
            @JsonProperty("ip_address") @Nullable String ipAddress,
            @JsonProperty("max_connections") @Nullable Long maxConnections,
            @JsonProperty("allowed_updates") @Nullable List<String> allowedUpdates,
            @JsonProperty("drop_pending_updates") @Nullable Boolean dropPendingUpdates,
            @JsonProperty("secret_token") @Nullable String secretToken
    ) {
        this.url = url;
        this.certificate = certificate;
        this.ipAddress = ipAddress;
        this.maxConnections = maxConnections;
        this.allowedUpdates = allowedUpdates;
        this.dropPendingUpdates = dropPendingUpdates;
        this.secretToken = secretToken;
    }

    public String url() {
        return this.url;
    }

    public InputFile certificate() {
        return this.certificate;
    }

    public String ipAddress() {
        return this.ipAddress;
    }

    public Long maxConnections() {
        return this.maxConnections;
    }

    public List<String> allowedUpdates() {
        return this.allowedUpdates;
    }

    public Boolean dropPendingUpdates() {
        return this.dropPendingUpdates;
    }

    public String secretToken() {
        return this.secretToken;
    }

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
