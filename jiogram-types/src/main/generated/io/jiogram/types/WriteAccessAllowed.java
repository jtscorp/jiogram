package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record WriteAccessAllowed(
    @JsonProperty("from_request") @Nullable Boolean fromRequest,
    @JsonProperty("web_app_name") @Nullable String webAppName,
    @JsonProperty("from_attachment_menu") @Nullable Boolean fromAttachmentMenu
) {}
