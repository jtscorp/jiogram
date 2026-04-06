package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = MenuButtonDefault.class, name = "default"),
    @JsonSubTypes.Type(value = MenuButtonWebApp.class, name = "web_app"),
    @JsonSubTypes.Type(value = MenuButtonCommands.class, name = "commands")
})
public sealed interface MenuButton permits MenuButtonDefault, MenuButtonWebApp, MenuButtonCommands {}
