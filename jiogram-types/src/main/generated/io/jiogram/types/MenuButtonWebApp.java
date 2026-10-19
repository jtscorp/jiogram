package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButtonType;
import io.jiogram.types.WebAppInfo;

public record MenuButtonWebApp(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MenuButtonType type,
    @JsonProperty("text") String text,
    @JsonProperty("web_app") WebAppInfo webApp
) implements MenuButton {}
