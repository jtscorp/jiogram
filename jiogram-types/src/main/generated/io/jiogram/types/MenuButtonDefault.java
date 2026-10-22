package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButtonType;
import java.util.Objects;

/**
 * Describes that no specific value for the menu button was set.
 *
 * @see <a href="https://core.telegram.org/bots/api#menubuttondefault">MenuButtonDefault in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MenuButtonDefault implements MenuButton {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final MenuButtonType type;

    /**
     * Creates a new {@code MenuButtonDefault} instance.
     *
     * @param type Type of the button, must be default
     */
    @JsonCreator
    public MenuButtonDefault(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MenuButtonType type) {
        this.type = type;
    }

    public static MenuButtonDefault of() {
        return new MenuButtonDefault(MenuButtonType.DEFAULT);
    }

    /**
     * Type of the button, must be default
     */
    public MenuButtonType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MenuButtonDefault)) {
            return false;
        }
        MenuButtonDefault that = (MenuButtonDefault) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "MenuButtonDefault[type=" + this.type
                + "]";
    }
}
