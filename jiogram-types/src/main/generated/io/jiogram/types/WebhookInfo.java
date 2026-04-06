package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record WebhookInfo(
    @JsonProperty("url") String url,
    @JsonProperty("has_custom_certificate") boolean hasCustomCertificate,
    @JsonProperty("pending_update_count") long pendingUpdateCount,
    @JsonProperty("ip_address") @Nullable String ipAddress,
    @JsonProperty("last_error_date") @Nullable Long lastErrorDate,
    @JsonProperty("last_error_message") @Nullable String lastErrorMessage,
    @JsonProperty("last_synchronization_error_date") @Nullable Long lastSynchronizationErrorDate,
    @JsonProperty("max_connections") @Nullable Long maxConnections,
    @JsonProperty("allowed_updates") @Nullable List<String> allowedUpdates
) {}
