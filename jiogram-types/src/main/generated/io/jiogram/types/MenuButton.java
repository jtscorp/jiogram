package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes the bot's menu button in a private chat. It should be one of
 * <br>- MenuButtonCommands
 * <br>- MenuButtonWebApp
 * <br>- MenuButtonDefault
 * <br>If a menu button other than MenuButtonDefault is set for a private chat, then it is applied
 * in the chat. Otherwise the default menu button is applied. By default, the menu button opens the
 * list of bot commands.
 *
 * @see <a href="https://core.telegram.org/bots/api#menubutton">MenuButton in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = MenuButtonUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MenuButtonCommands.class, name = "commands"),
    @JsonSubTypes.Type(value = MenuButtonDefault.class, name = "default"),
    @JsonSubTypes.Type(value = MenuButtonWebApp.class, name = "web_app")
})
public interface MenuButton {}
