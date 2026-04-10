package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class WriteAccessAllowed {
    @JsonProperty("from_request") @Nullable private final Boolean fromRequest;
    @JsonProperty("web_app_name") @Nullable private final String webAppName;
    @JsonProperty("from_attachment_menu") @Nullable private final Boolean fromAttachmentMenu;

    @JsonCreator
    public WriteAccessAllowed(
            @JsonProperty("from_request") @Nullable Boolean fromRequest,
            @JsonProperty("web_app_name") @Nullable String webAppName,
            @JsonProperty("from_attachment_menu") @Nullable Boolean fromAttachmentMenu
    ) {
        this.fromRequest = fromRequest;
        this.webAppName = webAppName;
        this.fromAttachmentMenu = fromAttachmentMenu;
    }

    public Boolean fromRequest() {
        return this.fromRequest;
    }

    public String webAppName() {
        return this.webAppName;
    }

    public Boolean fromAttachmentMenu() {
        return this.fromAttachmentMenu;
    }
}
