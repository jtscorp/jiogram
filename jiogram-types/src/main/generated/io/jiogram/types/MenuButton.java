package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = MenuButtonCommands.class, name = "commands"),
    @JsonSubTypes.Type(value = MenuButtonDefault.class, name = "default"),
    @JsonSubTypes.Type(value = MenuButtonWebApp.class, name = "web_app")
})
public sealed interface MenuButton permits MenuButtonCommands, MenuButtonDefault, MenuButtonWebApp {}
