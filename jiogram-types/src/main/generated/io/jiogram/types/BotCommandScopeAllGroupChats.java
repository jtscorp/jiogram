package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import java.util.Objects;

/**
 * Represents the scope of bot commands, covering all group and supergroup chats.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopeallgroupchats">BotCommandScopeAllGroupChats in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotCommandScopeAllGroupChats implements BotCommandScope {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BotCommandScopeType type;

    /**
     * Creates a new {@code BotCommandScopeAllGroupChats} instance.
     *
     * @param type Scope type, must be all_group_chats
     */
    @JsonCreator
    public BotCommandScopeAllGroupChats(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type) {
        this.type = type;
    }

    public static BotCommandScopeAllGroupChats of() {
        return new BotCommandScopeAllGroupChats(BotCommandScopeType.ALL_GROUP_CHATS);
    }

    /**
     * Scope type, must be all_group_chats
     */
    public BotCommandScopeType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotCommandScopeAllGroupChats)) {
            return false;
        }
        BotCommandScopeAllGroupChats that = (BotCommandScopeAllGroupChats) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "BotCommandScopeAllGroupChats[type=" + this.type
                + "]";
    }
}
