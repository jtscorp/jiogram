package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about a chat that was shared with the bot using a
 * KeyboardButtonRequestChat button.
 *
 * @param requestId Identifier of the request
 * @param chatId Identifier of the shared chat. This number may have more than 32 significant bits
 *     and some programming languages may have difficulty/silent defects in interpreting it. But it
 *     has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe
 *     for storing this identifier. The bot may not have access to the chat and could be unable to
 *     use this identifier, unless the chat is already known to the bot by some other means.
 * @param title Title of the chat, if the title was requested by the bot.
 * @param username Username of the chat, if the username was requested by the bot and available.
 * @param photo Available sizes of the chat photo, if the photo was requested by the bot
 * @see <a href="https://core.telegram.org/bots/api#chatshared">ChatShared in the Bot API</a>
 */
public record ChatShared(
    @JsonProperty("request_id") long requestId,
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("username") @Nullable String username,
    @JsonProperty("photo") @Nullable List<PhotoSize> photo
) {

    public static ChatShared of(long requestId, long chatId) {
        return new ChatShared(requestId, chatId, null, null, null);
    }

    public ChatShared withRequestId(long requestId) {
        return new ChatShared(requestId, chatId, title, username, photo);
    }

    public ChatShared withChatId(long chatId) {
        return new ChatShared(requestId, chatId, title, username, photo);
    }

    public ChatShared withTitle(@Nullable String title) {
        return new ChatShared(requestId, chatId, title, username, photo);
    }

    public ChatShared withUsername(@Nullable String username) {
        return new ChatShared(requestId, chatId, title, username, photo);
    }

    public ChatShared withPhoto(@Nullable List<PhotoSize> photo) {
        return new ChatShared(requestId, chatId, title, username, photo);
    }
}
