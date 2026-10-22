package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import io.jiogram.types.ChatId;
import java.util.Objects;

/**
 * Represents the scope of bot commands, covering all administrators of a specific group or
 * supergroup chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopechatadministrators">BotCommandScopeChatAdministrators in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotCommandScopeChatAdministrators implements BotCommandScope {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BotCommandScopeType type;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    /**
     * Creates a new {@code BotCommandScopeChatAdministrators} instance.
     *
     * @param type Scope type, must be chat_administrators
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername). Channel direct messages chats and channel chats
     *     aren't supported.
     */
    @JsonCreator
    public BotCommandScopeChatAdministrators(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type,
            @JsonProperty("chat_id") ChatId chatId) {
        this.type = type;
        this.chatId = chatId;
    }

    public static BotCommandScopeChatAdministrators of(ChatId chatId) {
        return new BotCommandScopeChatAdministrators(BotCommandScopeType.CHAT_ADMINISTRATORS, chatId);
    }

    /**
     * Scope type, must be chat_administrators
     */
    public BotCommandScopeType type() {
        return type;
    }

    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format
     * &#64;supergroupusername). Channel direct messages chats and channel chats aren't supported.
     */
    public ChatId chatId() {
        return chatId;
    }

    public BotCommandScopeChatAdministrators withChatId(ChatId chatId) {
        return new BotCommandScopeChatAdministrators(type, chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotCommandScopeChatAdministrators)) {
            return false;
        }
        BotCommandScopeChatAdministrators that = (BotCommandScopeChatAdministrators) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.chatId);
    }

    @Override
    public String toString() {
        return "BotCommandScopeChatAdministrators[type=" + this.type
                + ", chatId=" + this.chatId
                + "]";
    }
}
