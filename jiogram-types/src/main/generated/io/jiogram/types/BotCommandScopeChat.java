package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import io.jiogram.types.ChatId;
import java.util.Objects;

/**
 * Represents the scope of bot commands, covering a specific chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopechat">BotCommandScopeChat in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotCommandScopeChat implements BotCommandScope {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BotCommandScopeType type;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    /**
     * Creates a new {@code BotCommandScopeChat} instance.
     *
     * @param type Scope type, must be chat
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername). Channel direct messages chats and channel chats
     *     aren't supported.
     */
    @JsonCreator
    public BotCommandScopeChat(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type,
            @JsonProperty("chat_id") ChatId chatId) {
        this.type = type;
        this.chatId = chatId;
    }

    public static BotCommandScopeChat of(ChatId chatId) {
        return new BotCommandScopeChat(BotCommandScopeType.CHAT, chatId);
    }

    /**
     * Scope type, must be chat
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

    public BotCommandScopeChat withChatId(ChatId chatId) {
        return new BotCommandScopeChat(type, chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotCommandScopeChat)) {
            return false;
        }
        BotCommandScopeChat that = (BotCommandScopeChat) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.chatId);
    }

    @Override
    public String toString() {
        return "BotCommandScopeChat[type=" + this.type
                + ", chatId=" + this.chatId
                + "]";
    }
}
