package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButtonType;
import java.util.Objects;

/**
 * Represents a menu button, which opens the bot's list of commands.
 *
 * @see <a href="https://core.telegram.org/bots/api#menubuttoncommands">MenuButtonCommands in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MenuButtonCommands implements MenuButton {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final MenuButtonType type;

    /**
     * Creates a new {@code MenuButtonCommands} instance.
     *
     * @param type Type of the button, must be commands
     */
    @JsonCreator
    public MenuButtonCommands(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MenuButtonType type) {
        this.type = type;
    }

    public static MenuButtonCommands of() {
        return new MenuButtonCommands(MenuButtonType.COMMANDS);
    }

    /**
     * Type of the button, must be commands
     */
    public MenuButtonType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MenuButtonCommands)) {
            return false;
        }
        MenuButtonCommands that = (MenuButtonCommands) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "MenuButtonCommands[type=" + this.type
                + "]";
    }
}
