package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.WebAppInfo;

public class MenuButtonWebApp implements MenuButton {
    @JsonProperty("type") private final String type;
    @JsonProperty("text") private final String text;
    @JsonProperty("web_app") private final WebAppInfo webApp;

    @JsonCreator
    public MenuButtonWebApp(
            @JsonProperty("type") String type,
            @JsonProperty("text") String text,
            @JsonProperty("web_app") WebAppInfo webApp
    ) {
        this.type = type;
        this.text = text;
        this.webApp = webApp;
    }

    public String type() {
        return this.type;
    }

    public String text() {
        return this.text;
    }

    public WebAppInfo webApp() {
        return this.webApp;
    }
}
