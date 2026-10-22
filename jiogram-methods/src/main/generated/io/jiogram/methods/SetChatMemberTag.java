package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to set a tag for a regular member in a group or a supergroup. The bot must be an
 * administrator in the chat for this to work and must have the can_manage_tags administrator right.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatmembertag">setChatMemberTag in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetChatMemberTag implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("tag")
    private final @Nullable String tag;

    /**
     * Creates a new {@code SetChatMemberTag} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     * @param userId Unique identifier of the target user
     * @param tag New tag for the member; 0-16 characters, emoji are not allowed
     */
    @JsonCreator
    public SetChatMemberTag(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId,
            @JsonProperty("tag") @Nullable String tag) {
        this.chatId = chatId;
        this.userId = userId;
        this.tag = tag;
    }

    @Override
    public String apiMethod() {
        return "setChatMemberTag";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetChatMemberTag of(ChatId chatId, long userId) {
        return new SetChatMemberTag(chatId, userId, null);
    }

    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format
     * &#64;supergroupusername)
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

    /**
     * New tag for the member; 0-16 characters, emoji are not allowed
     */
    public @Nullable String tag() {
        return tag;
    }

    public SetChatMemberTag withChatId(ChatId chatId) {
        return new SetChatMemberTag(chatId, userId, tag);
    }

    public SetChatMemberTag withUserId(long userId) {
        return new SetChatMemberTag(chatId, userId, tag);
    }

    public SetChatMemberTag withTag(@Nullable String tag) {
        return new SetChatMemberTag(chatId, userId, tag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetChatMemberTag)) {
            return false;
        }
        SetChatMemberTag that = (SetChatMemberTag) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.userId == that.userId
                && Objects.equals(this.tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.userId, this.tag);
    }

    @Override
    public String toString() {
        return "SetChatMemberTag[chatId=" + this.chatId
                + ", userId=" + this.userId
                + ", tag=" + this.tag
                + "]";
    }
}
