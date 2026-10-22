package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Removes verification from a chat that is currently verified on behalf of the organization
 * represented by the bot. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @see <a href="https://core.telegram.org/bots/api#removechatverification">removeChatVerification in the Bot API</a>
 */
public record RemoveChatVerification(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "removeChatVerification";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
