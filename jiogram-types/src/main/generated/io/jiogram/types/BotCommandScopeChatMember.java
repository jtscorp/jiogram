package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import io.jiogram.types.ChatId;
import java.util.Objects;

/**
 * Represents the scope of bot commands, covering a specific member of a group or supergroup chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopechatmember">BotCommandScopeChatMember in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotCommandScopeChatMember implements BotCommandScope {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BotCommandScopeType type;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("user_id")
    private final long userId;

    /**
     * Creates a new {@code BotCommandScopeChatMember} instance.
     *
     * @param type Scope type, must be chat_member
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername). Channel direct messages chats and channel chats
     *     aren't supported.
     * @param userId Unique identifier of the target user
     */
    @JsonCreator
    public BotCommandScopeChatMember(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BotCommandScopeType type,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId) {
        this.type = type;
        this.chatId = chatId;
        this.userId = userId;
    }

    public static BotCommandScopeChatMember of(ChatId chatId, long userId) {
        return new BotCommandScopeChatMember(BotCommandScopeType.CHAT_MEMBER, chatId, userId);
    }

    /**
     * Scope type, must be chat_member
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

    /**
     * Unique identifier of the target user
     */
    public long userId() {
        return userId;
    }

    public BotCommandScopeChatMember withChatId(ChatId chatId) {
        return new BotCommandScopeChatMember(type, chatId, userId);
    }

    public BotCommandScopeChatMember withUserId(long userId) {
        return new BotCommandScopeChatMember(type, chatId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotCommandScopeChatMember)) {
            return false;
        }
        BotCommandScopeChatMember that = (BotCommandScopeChatMember) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.chatId, that.chatId)
                && this.userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.chatId, this.userId);
    }

    @Override
    public String toString() {
        return "BotCommandScopeChatMember[type=" + this.type
                + ", chatId=" + this.chatId
                + ", userId=" + this.userId
                + "]";
    }
}
