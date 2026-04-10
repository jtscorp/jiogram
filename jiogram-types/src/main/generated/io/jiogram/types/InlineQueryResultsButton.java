package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.WebAppInfo;
import org.jspecify.annotations.Nullable;

public class InlineQueryResultsButton {
    @JsonProperty("text") private final String text;
    @JsonProperty("web_app") @Nullable private final WebAppInfo webApp;
    @JsonProperty("start_parameter") @Nullable private final String startParameter;

    @JsonCreator
    public InlineQueryResultsButton(
            @JsonProperty("text") String text,
            @JsonProperty("web_app") @Nullable WebAppInfo webApp,
            @JsonProperty("start_parameter") @Nullable String startParameter
    ) {
        this.text = text;
        this.webApp = webApp;
        this.startParameter = startParameter;
    }

    public String text() {
        return this.text;
    }

    public WebAppInfo webApp() {
        return this.webApp;
    }

    public String startParameter() {
        return this.startParameter;
    }
}
