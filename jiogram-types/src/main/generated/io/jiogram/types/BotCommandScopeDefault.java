package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import java.util.Objects;

/**
 * Represents the default scope of bot commands. Default commands are used if no commands with a
 * narrower scope are specified for the user.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopedefault">BotCommandScopeDefault in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotCommandScopeDefault implements BotCommandScope {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BotCommandScopeType type;

    /**
     * Creates a new {@code BotCommandScopeDefault} instance.
     *
     * @param type Scope type, must be default
     */
    @JsonCreator
    public BotCommandScopeDefault(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type) {
        this.type = type;
    }

    public static BotCommandScopeDefault of() {
        return new BotCommandScopeDefault(BotCommandScopeType.DEFAULT);
    }

    /**
     * Scope type, must be default
     */
    public BotCommandScopeType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotCommandScopeDefault)) {
            return false;
        }
        BotCommandScopeDefault that = (BotCommandScopeDefault) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "BotCommandScopeDefault[type=" + this.type
                + "]";
    }
}
