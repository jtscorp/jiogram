package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class LoginUrl {
    @JsonProperty("url") private final String url;
    @JsonProperty("forward_text") @Nullable private final String forwardText;
    @JsonProperty("bot_username") @Nullable private final String botUsername;
    @JsonProperty("request_write_access") @Nullable private final Boolean requestWriteAccess;

    @JsonCreator
    public LoginUrl(
            @JsonProperty("url") String url,
            @JsonProperty("forward_text") @Nullable String forwardText,
            @JsonProperty("bot_username") @Nullable String botUsername,
            @JsonProperty("request_write_access") @Nullable Boolean requestWriteAccess
    ) {
        this.url = url;
        this.forwardText = forwardText;
        this.botUsername = botUsername;
        this.requestWriteAccess = requestWriteAccess;
    }

    public String url() {
        return this.url;
    }

    public String forwardText() {
        return this.forwardText;
    }

    public String botUsername() {
        return this.botUsername;
    }

    public Boolean requestWriteAccess() {
        return this.requestWriteAccess;
    }
}
