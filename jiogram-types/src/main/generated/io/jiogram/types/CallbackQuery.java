package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaybeInaccessibleMessage;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an incoming callback query from a callback button in an inline keyboard.
 * If the button that originated the query was attached to a message sent by the bot, the field
 * message will be present. If the button was attached to a message sent via the bot (in inline
 * mode), the field inline_message_id will be present. Exactly one of the fields data or
 * game_short_name will be present.
 * <br>NOTE: After the user presses a callback button, Telegram clients will display a progress bar
 * until you call answerCallbackQuery. It is, therefore, necessary to react by calling
 * answerCallbackQuery even if no notification to the user is needed (e.g., without specifying any
 * of the optional parameters).
 *
 * @see <a href="https://core.telegram.org/bots/api#callbackquery">CallbackQuery in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class CallbackQuery {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("from")
    private final User from;

    @JsonProperty("message")
    private final @Nullable MaybeInaccessibleMessage message;

    @JsonProperty("inline_message_id")
    private final @Nullable String inlineMessageId;

    @JsonProperty("chat_instance")
    private final String chatInstance;

    @JsonProperty("data")
    private final @Nullable String data;

    @JsonProperty("game_short_name")
    private final @Nullable String gameShortName;

    /**
     * Creates a new {@code CallbackQuery} instance.
     *
     * @param id Unique identifier for this query
     * @param from Sender
     * @param message Message sent by the bot with the callback button that originated the query
     * @param inlineMessageId Identifier of the message sent via the bot in inline mode, that
     *     originated the query.
     * @param chatInstance Global identifier, uniquely corresponding to the chat to which the
     *     message with the callback button was sent. Useful for high scores in games.
     * @param data Data associated with the callback button. Be aware that the message originated
     *     the query can contain no callback buttons with this data.
     * @param gameShortName Short name of a Game to be returned, serves as the unique identifier for
     *     the game
     */
    @JsonCreator
    public CallbackQuery(
            @JsonProperty("id") String id,
            @JsonProperty("from") User from,
            @JsonProperty("message") @Nullable MaybeInaccessibleMessage message,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("chat_instance") String chatInstance,
            @JsonProperty("data") @Nullable String data,
            @JsonProperty("game_short_name") @Nullable String gameShortName) {
        this.id = id;
        this.from = from;
        this.message = message;
        this.inlineMessageId = inlineMessageId;
        this.chatInstance = chatInstance;
        this.data = data;
        this.gameShortName = gameShortName;
    }

    public static CallbackQuery of(String id, User from, String chatInstance) {
        return new CallbackQuery(id, from, null, null, chatInstance, null, null);
    }

    /**
     * Unique identifier for this query
     */
    public String id() {
        return id;
    }

    /**
     * Sender
     */
    public User from() {
        return from;
    }

    /**
     * Message sent by the bot with the callback button that originated the query
     */
    public @Nullable MaybeInaccessibleMessage message() {
        return message;
    }

    /**
     * Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    public @Nullable String inlineMessageId() {
        return inlineMessageId;
    }

    /**
     * Global identifier, uniquely corresponding to the chat to which the message with the callback
     * button was sent. Useful for high scores in games.
     */
    public String chatInstance() {
        return chatInstance;
    }

    /**
     * Data associated with the callback button. Be aware that the message originated the query can
     * contain no callback buttons with this data.
     */
    public @Nullable String data() {
        return data;
    }

    /**
     * Short name of a Game to be returned, serves as the unique identifier for the game
     */
    public @Nullable String gameShortName() {
        return gameShortName;
    }

    public CallbackQuery withId(String id) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withFrom(User from) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withMessage(@Nullable MaybeInaccessibleMessage message) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withInlineMessageId(@Nullable String inlineMessageId) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withChatInstance(String chatInstance) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withData(@Nullable String data) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withGameShortName(@Nullable String gameShortName) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CallbackQuery)) {
            return false;
        }
        CallbackQuery that = (CallbackQuery) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.from, that.from)
                && Objects.equals(this.message, that.message)
                && Objects.equals(this.inlineMessageId, that.inlineMessageId)
                && Objects.equals(this.chatInstance, that.chatInstance)
                && Objects.equals(this.data, that.data)
                && Objects.equals(this.gameShortName, that.gameShortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.from, this.message, this.inlineMessageId, this.chatInstance, this.data, this.gameShortName);
    }

    @Override
    public String toString() {
        return "CallbackQuery[id=" + this.id
                + ", from=" + this.from
                + ", message=" + this.message
                + ", inlineMessageId=" + this.inlineMessageId
                + ", chatInstance=" + this.chatInstance
                + ", data=" + this.data
                + ", gameShortName=" + this.gameShortName
                + "]";
    }
}
