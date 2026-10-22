package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import java.util.Objects;

/**
 * Represents the scope of bot commands, covering all private chats.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopeallprivatechats">BotCommandScopeAllPrivateChats in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotCommandScopeAllPrivateChats implements BotCommandScope {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BotCommandScopeType type;

    /**
     * Creates a new {@code BotCommandScopeAllPrivateChats} instance.
     *
     * @param type Scope type, must be all_private_chats
     */
    @JsonCreator
    public BotCommandScopeAllPrivateChats(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type) {
        this.type = type;
    }

    public static BotCommandScopeAllPrivateChats of() {
        return new BotCommandScopeAllPrivateChats(BotCommandScopeType.ALL_PRIVATE_CHATS);
    }

    /**
     * Scope type, must be all_private_chats
     */
    public BotCommandScopeType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotCommandScopeAllPrivateChats)) {
            return false;
        }
        BotCommandScopeAllPrivateChats that = (BotCommandScopeAllPrivateChats) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "BotCommandScopeAllPrivateChats[type=" + this.type
                + "]";
    }
}
