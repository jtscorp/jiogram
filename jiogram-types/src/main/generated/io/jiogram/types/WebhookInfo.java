package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class WebhookInfo {
    @JsonProperty("url") private final String url;
    @JsonProperty("has_custom_certificate") private final boolean hasCustomCertificate;
    @JsonProperty("pending_update_count") private final long pendingUpdateCount;
    @JsonProperty("ip_address") @Nullable private final String ipAddress;
    @JsonProperty("last_error_date") @Nullable private final Long lastErrorDate;
    @JsonProperty("last_error_message") @Nullable private final String lastErrorMessage;
    @JsonProperty("last_synchronization_error_date") @Nullable private final Long lastSynchronizationErrorDate;
    @JsonProperty("max_connections") @Nullable private final Long maxConnections;
    @JsonProperty("allowed_updates") @Nullable private final List<String> allowedUpdates;

    @JsonCreator
    public WebhookInfo(
            @JsonProperty("url") String url,
            @JsonProperty("has_custom_certificate") boolean hasCustomCertificate,
            @JsonProperty("pending_update_count") long pendingUpdateCount,
            @JsonProperty("ip_address") @Nullable String ipAddress,
            @JsonProperty("last_error_date") @Nullable Long lastErrorDate,
            @JsonProperty("last_error_message") @Nullable String lastErrorMessage,
            @JsonProperty("last_synchronization_error_date") @Nullable Long lastSynchronizationErrorDate,
            @JsonProperty("max_connections") @Nullable Long maxConnections,
            @JsonProperty("allowed_updates") @Nullable List<String> allowedUpdates
    ) {
        this.url = url;
        this.hasCustomCertificate = hasCustomCertificate;
        this.pendingUpdateCount = pendingUpdateCount;
        this.ipAddress = ipAddress;
        this.lastErrorDate = lastErrorDate;
        this.lastErrorMessage = lastErrorMessage;
        this.lastSynchronizationErrorDate = lastSynchronizationErrorDate;
        this.maxConnections = maxConnections;
        this.allowedUpdates = allowedUpdates;
    }

    public String url() {
        return this.url;
    }

    public boolean hasCustomCertificate() {
        return this.hasCustomCertificate;
    }

    public long pendingUpdateCount() {
        return this.pendingUpdateCount;
    }

    public String ipAddress() {
        return this.ipAddress;
    }

    public Long lastErrorDate() {
        return this.lastErrorDate;
    }

    public String lastErrorMessage() {
        return this.lastErrorMessage;
    }

    public Long lastSynchronizationErrorDate() {
        return this.lastSynchronizationErrorDate;
    }

    public Long maxConnections() {
        return this.maxConnections;
    }

    public List<String> allowedUpdates() {
        return this.allowedUpdates;
    }
}
