package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.WebAppInfo;

public record MenuButtonWebApp(
    @JsonProperty("type") String type,
    @JsonProperty("text") String text,
    @JsonProperty("web_app") WebAppInfo webApp
) implements MenuButton {}
