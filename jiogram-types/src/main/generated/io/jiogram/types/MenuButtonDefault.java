package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButtonType;

/**
 * Describes that no specific value for the menu button was set.
 *
 * @param type Type of the button, must be default
 * @see <a href="https://core.telegram.org/bots/api#menubuttondefault">MenuButtonDefault in the Bot API</a>
 */
public record MenuButtonDefault(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MenuButtonType type
) implements MenuButton {

    public static MenuButtonDefault of() {
        return new MenuButtonDefault(MenuButtonType.DEFAULT);
    }
}
