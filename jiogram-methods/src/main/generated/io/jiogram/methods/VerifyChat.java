package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Verifies a chat on behalf of the organization which is represented by the bot. Returns True on
 * success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername). Channel direct messages chats can't be verified.
 * @param customDescription Custom description for the verification; 0-70 characters. Must be empty
 *     if the organization isn't allowed to provide a custom verification description.
 * @see <a href="https://core.telegram.org/bots/api#verifychat">verifyChat in the Bot API</a>
 */
public record VerifyChat(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("custom_description") @Nullable String customDescription
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "verifyChat";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static VerifyChat of(ChatId chatId) {
        return new VerifyChat(chatId, null);
    }
}
