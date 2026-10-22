package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to set a custom title for an administrator in a supergroup promoted by the bot.
 * Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @param userId Unique identifier of the target user
 * @param customTitle New custom title for the administrator; 0-16 characters, emoji are not allowed
 * @see <a href="https://core.telegram.org/bots/api#setchatadministratorcustomtitle">setChatAdministratorCustomTitle in the Bot API</a>
 */
public record SetChatAdministratorCustomTitle(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("custom_title") String customTitle
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatAdministratorCustomTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
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
}
