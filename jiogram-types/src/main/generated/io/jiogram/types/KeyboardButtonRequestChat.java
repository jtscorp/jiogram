package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object defines the criteria used to request a suitable chat. Information about the selected
 * chat will be shared with the bot when the corresponding button is pressed. The bot will be
 * granted requested rights in the chat if appropriate..
 *
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestchat">KeyboardButtonRequestChat in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class KeyboardButtonRequestChat {

    @JsonProperty("request_id")
    private final long requestId;

    @JsonProperty("chat_is_channel")
    private final boolean chatIsChannel;

    @JsonProperty("chat_is_forum")
    private final @Nullable Boolean chatIsForum;

    @JsonProperty("chat_has_username")
    private final @Nullable Boolean chatHasUsername;

    @JsonProperty("chat_is_created")
    private final @Nullable Boolean chatIsCreated;

    @JsonProperty("user_administrator_rights")
    private final @Nullable ChatAdministratorRights userAdministratorRights;

    @JsonProperty("bot_administrator_rights")
    private final @Nullable ChatAdministratorRights botAdministratorRights;

    @JsonProperty("bot_is_member")
    private final @Nullable Boolean botIsMember;

    @JsonProperty("request_title")
    private final @Nullable Boolean requestTitle;

    @JsonProperty("request_username")
    private final @Nullable Boolean requestUsername;

    @JsonProperty("request_photo")
    private final @Nullable Boolean requestPhoto;

    /**
     * Creates a new {@code KeyboardButtonRequestChat} instance.
     *
     * @param requestId Signed 32-bit identifier of the request, which will be received back in the
     *     ChatShared object. Must be unique within the message
     * @param chatIsChannel Pass True to request a channel chat, pass False to request a group or a
     *     supergroup chat.
     * @param chatIsForum Pass True to request a forum supergroup, pass False to request a non-forum
     *     chat. If not specified, no additional restrictions are applied.
     * @param chatHasUsername Pass True to request a supergroup or a channel with a username, pass
     *     False to request a chat without a username. If not specified, no additional restrictions
     *     are applied.
     * @param chatIsCreated Pass True to request a chat owned by the user. Otherwise, no additional
     *     restrictions are applied.
     * @param userAdministratorRights A JSON-serialized object listing the required administrator
     *     rights of the user in the chat. The rights must be a superset of
     *     bot_administrator_rights. If not specified, no additional restrictions are applied.
     * @param botAdministratorRights A JSON-serialized object listing the required administrator
     *     rights of the bot in the chat. The rights must be a subset of user_administrator_rights.
     *     If not specified, no additional restrictions are applied.
     * @param botIsMember Pass True to request a chat with the bot as a member. Otherwise, no
     *     additional restrictions are applied.
     * @param requestTitle Pass True to request the chat's title
     * @param requestUsername Pass True to request the chat's username
     * @param requestPhoto Pass True to request the chat's photo
     */
    @JsonCreator
    public KeyboardButtonRequestChat(
            @JsonProperty("request_id") long requestId,
            @JsonProperty("chat_is_channel") boolean chatIsChannel,
            @JsonProperty("chat_is_forum") @Nullable Boolean chatIsForum,
            @JsonProperty("chat_has_username") @Nullable Boolean chatHasUsername,
            @JsonProperty("chat_is_created") @Nullable Boolean chatIsCreated,
            @JsonProperty("user_administrator_rights") @Nullable ChatAdministratorRights userAdministratorRights,
            @JsonProperty("bot_administrator_rights") @Nullable ChatAdministratorRights botAdministratorRights,
            @JsonProperty("bot_is_member") @Nullable Boolean botIsMember,
            @JsonProperty("request_title") @Nullable Boolean requestTitle,
            @JsonProperty("request_username") @Nullable Boolean requestUsername,
            @JsonProperty("request_photo") @Nullable Boolean requestPhoto) {
        this.requestId = requestId;
        this.chatIsChannel = chatIsChannel;
        this.chatIsForum = chatIsForum;
        this.chatHasUsername = chatHasUsername;
        this.chatIsCreated = chatIsCreated;
        this.userAdministratorRights = userAdministratorRights;
        this.botAdministratorRights = botAdministratorRights;
        this.botIsMember = botIsMember;
        this.requestTitle = requestTitle;
        this.requestUsername = requestUsername;
        this.requestPhoto = requestPhoto;
    }

    public static KeyboardButtonRequestChat of(long requestId, boolean chatIsChannel) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Signed 32-bit identifier of the request, which will be received back in the ChatShared
     * object. Must be unique within the message
     */
    public long requestId() {
        return requestId;
    }

    /**
     * Pass True to request a channel chat, pass False to request a group or a supergroup chat.
     */
    public boolean chatIsChannel() {
        return chatIsChannel;
    }

    /**
     * Pass True to request a forum supergroup, pass False to request a non-forum chat. If not
     * specified, no additional restrictions are applied.
     */
    public @Nullable Boolean chatIsForum() {
        return chatIsForum;
    }

    /**
     * Pass True to request a supergroup or a channel with a username, pass False to request a chat
     * without a username. If not specified, no additional restrictions are applied.
     */
    public @Nullable Boolean chatHasUsername() {
        return chatHasUsername;
    }

    /**
     * Pass True to request a chat owned by the user. Otherwise, no additional restrictions are
     * applied.
     */
    public @Nullable Boolean chatIsCreated() {
        return chatIsCreated;
    }

    /**
     * A JSON-serialized object listing the required administrator rights of the user in the chat.
     * The rights must be a superset of bot_administrator_rights. If not specified, no additional
     * restrictions are applied.
     */
    public @Nullable ChatAdministratorRights userAdministratorRights() {
        return userAdministratorRights;
    }

    /**
     * A JSON-serialized object listing the required administrator rights of the bot in the chat.
     * The rights must be a subset of user_administrator_rights. If not specified, no additional
     * restrictions are applied.
     */
    public @Nullable ChatAdministratorRights botAdministratorRights() {
        return botAdministratorRights;
    }

    /**
     * Pass True to request a chat with the bot as a member. Otherwise, no additional restrictions
     * are applied.
     */
    public @Nullable Boolean botIsMember() {
        return botIsMember;
    }

    /**
     * Pass True to request the chat's title
     */
    public @Nullable Boolean requestTitle() {
        return requestTitle;
    }

    /**
     * Pass True to request the chat's username
     */
    public @Nullable Boolean requestUsername() {
        return requestUsername;
    }

    /**
     * Pass True to request the chat's photo
     */
    public @Nullable Boolean requestPhoto() {
        return requestPhoto;
    }

    public KeyboardButtonRequestChat withRequestId(long requestId) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestChat withChatIsChannel(boolean chatIsChannel) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestChat withChatIsForum(@Nullable Boolean chatIsForum) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestChat withChatHasUsername(@Nullable Boolean chatHasUsername) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestChat withChatIsCreated(@Nullable Boolean chatIsCreated) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestChat withUserAdministratorRights(@Nullable ChatAdministratorRights userAdministratorRights) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestChat withBotAdministratorRights(@Nullable ChatAdministratorRights botAdministratorRights) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestChat withBotIsMember(@Nullable Boolean botIsMember) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestChat withRequestTitle(@Nullable Boolean requestTitle) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestChat withRequestUsername(@Nullable Boolean requestUsername) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    public KeyboardButtonRequestChat withRequestPhoto(@Nullable Boolean requestPhoto) {
        return new KeyboardButtonRequestChat(requestId, chatIsChannel, chatIsForum, chatHasUsername, chatIsCreated, userAdministratorRights, botAdministratorRights, botIsMember, requestTitle, requestUsername, requestPhoto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KeyboardButtonRequestChat)) {
            return false;
        }
        KeyboardButtonRequestChat that = (KeyboardButtonRequestChat) o;
        return this.requestId == that.requestId
                && this.chatIsChannel == that.chatIsChannel
                && Objects.equals(this.chatIsForum, that.chatIsForum)
                && Objects.equals(this.chatHasUsername, that.chatHasUsername)
                && Objects.equals(this.chatIsCreated, that.chatIsCreated)
                && Objects.equals(this.userAdministratorRights, that.userAdministratorRights)
                && Objects.equals(this.botAdministratorRights, that.botAdministratorRights)
                && Objects.equals(this.botIsMember, that.botIsMember)
                && Objects.equals(this.requestTitle, that.requestTitle)
                && Objects.equals(this.requestUsername, that.requestUsername)
                && Objects.equals(this.requestPhoto, that.requestPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requestId, this.chatIsChannel, this.chatIsForum, this.chatHasUsername, this.chatIsCreated, this.userAdministratorRights, this.botAdministratorRights, this.botIsMember, this.requestTitle, this.requestUsername, this.requestPhoto);
    }

    @Override
    public String toString() {
        return "KeyboardButtonRequestChat[requestId=" + this.requestId
                + ", chatIsChannel=" + this.chatIsChannel
                + ", chatIsForum=" + this.chatIsForum
                + ", chatHasUsername=" + this.chatHasUsername
                + ", chatIsCreated=" + this.chatIsCreated
                + ", userAdministratorRights=" + this.userAdministratorRights
                + ", botAdministratorRights=" + this.botAdministratorRights
                + ", botIsMember=" + this.botIsMember
                + ", requestTitle=" + this.requestTitle
                + ", requestUsername=" + this.requestUsername
                + ", requestPhoto=" + this.requestPhoto
                + "]";
    }
}
