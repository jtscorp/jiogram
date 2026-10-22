package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about a chat that was shared with the bot using a
 * KeyboardButtonRequestChat button.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatshared">ChatShared in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatShared {

    @JsonProperty("request_id")
    private final long requestId;

    @JsonProperty("chat_id")
    private final long chatId;

    @JsonProperty("title")
    private final @Nullable String title;

    @JsonProperty("username")
    private final @Nullable String username;

    @JsonProperty("photo")
    private final @Nullable List<PhotoSize> photo;

    /**
     * Creates a new {@code ChatShared} instance.
     *
     * @param requestId Identifier of the request
     * @param chatId Identifier of the shared chat. This number may have more than 32 significant
     *     bits and some programming languages may have difficulty/silent defects in interpreting
     *     it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float
     *     type are safe for storing this identifier. The bot may not have access to the chat and
     *     could be unable to use this identifier, unless the chat is already known to the bot by
     *     some other means.
     * @param title Title of the chat, if the title was requested by the bot.
     * @param username Username of the chat, if the username was requested by the bot and available.
     * @param photo Available sizes of the chat photo, if the photo was requested by the bot
     */
    @JsonCreator
    public ChatShared(
            @JsonProperty("request_id") long requestId,
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("username") @Nullable String username,
            @JsonProperty("photo") @Nullable List<PhotoSize> photo) {
        this.requestId = requestId;
        this.chatId = chatId;
        this.title = title;
        this.username = username;
        this.photo = photo;
    }

    public static ChatShared of(long requestId, long chatId) {
        return new ChatShared(requestId, chatId, null, null, null);
    }

    /**
     * Identifier of the request
     */
    public long requestId() {
        return requestId;
    }

    /**
     * Identifier of the shared chat. This number may have more than 32 significant bits and some
     * programming languages may have difficulty/silent defects in interpreting it. But it has at
     * most 52 significant bits, so a 64-bit integer or double-precision float type are safe for
     * storing this identifier. The bot may not have access to the chat and could be unable to use
     * this identifier, unless the chat is already known to the bot by some other means.
     */
    public long chatId() {
        return chatId;
    }

    /**
     * Title of the chat, if the title was requested by the bot.
     */
    public @Nullable String title() {
        return title;
    }

    /**
     * Username of the chat, if the username was requested by the bot and available.
     */
    public @Nullable String username() {
        return username;
    }

    /**
     * Available sizes of the chat photo, if the photo was requested by the bot
     */
    public @Nullable List<PhotoSize> photo() {
        return photo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatShared)) {
            return false;
        }
        ChatShared that = (ChatShared) o;
        return this.requestId == that.requestId
                && this.chatId == that.chatId
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.username, that.username)
                && Objects.equals(this.photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requestId, this.chatId, this.title, this.username, this.photo);
    }

    @Override
    public String toString() {
        return "ChatShared[requestId=" + this.requestId
                + ", chatId=" + this.chatId
                + ", title=" + this.title
                + ", username=" + this.username
                + ", photo=" + this.photo
                + "]";
    }
}
