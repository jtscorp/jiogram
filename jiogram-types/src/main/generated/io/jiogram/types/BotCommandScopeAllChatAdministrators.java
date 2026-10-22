package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import java.util.Objects;

/**
 * Represents the scope of bot commands, covering all group and supergroup chat administrators.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopeallchatadministrators">BotCommandScopeAllChatAdministrators in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotCommandScopeAllChatAdministrators implements BotCommandScope {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BotCommandScopeType type;

    /**
     * Creates a new {@code BotCommandScopeAllChatAdministrators} instance.
     *
     * @param type Scope type, must be all_chat_administrators
     */
    @JsonCreator
    public BotCommandScopeAllChatAdministrators(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type) {
        this.type = type;
    }

    public static BotCommandScopeAllChatAdministrators of() {
        return new BotCommandScopeAllChatAdministrators(BotCommandScopeType.ALL_CHAT_ADMINISTRATORS);
    }

    /**
     * Scope type, must be all_chat_administrators
     */
    public BotCommandScopeType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotCommandScopeAllChatAdministrators)) {
            return false;
        }
        BotCommandScopeAllChatAdministrators that = (BotCommandScopeAllChatAdministrators) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "BotCommandScopeAllChatAdministrators[type=" + this.type
                + "]";
    }
}
