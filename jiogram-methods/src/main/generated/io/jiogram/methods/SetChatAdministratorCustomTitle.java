package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to set a custom title for an administrator in a supergroup promoted by the bot.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatadministratorcustomtitle">setChatAdministratorCustomTitle in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetChatAdministratorCustomTitle implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("custom_title")
    private final String customTitle;

    /**
     * Creates a new {@code SetChatAdministratorCustomTitle} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     * @param userId Unique identifier of the target user
     * @param customTitle New custom title for the administrator; 0-16 characters, emoji are not
     *     allowed
     */
    @JsonCreator
    public SetChatAdministratorCustomTitle(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId,
            @JsonProperty("custom_title") String customTitle) {
        this.chatId = chatId;
        this.userId = userId;
        this.customTitle = customTitle;
    }

    @Override
    public String apiMethod() {
        return "setChatAdministratorCustomTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
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
     * New custom title for the administrator; 0-16 characters, emoji are not allowed
     */
    public String customTitle() {
        return customTitle;
    }

    public SetChatAdministratorCustomTitle withChatId(ChatId chatId) {
        return new SetChatAdministratorCustomTitle(chatId, userId, customTitle);
    }

    public SetChatAdministratorCustomTitle withUserId(long userId) {
        return new SetChatAdministratorCustomTitle(chatId, userId, customTitle);
    }

    public SetChatAdministratorCustomTitle withCustomTitle(String customTitle) {
        return new SetChatAdministratorCustomTitle(chatId, userId, customTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetChatAdministratorCustomTitle)) {
            return false;
        }
        SetChatAdministratorCustomTitle that = (SetChatAdministratorCustomTitle) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.userId == that.userId
                && Objects.equals(this.customTitle, that.customTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.userId, this.customTitle);
    }

    @Override
    public String toString() {
        return "SetChatAdministratorCustomTitle[chatId=" + this.chatId
                + ", userId=" + this.userId
                + ", customTitle=" + this.customTitle
                + "]";
    }
}
