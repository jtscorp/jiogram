package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButtonPollType;
import io.jiogram.types.KeyboardButtonRequestChat;
import io.jiogram.types.KeyboardButtonRequestManagedBot;
import io.jiogram.types.KeyboardButtonRequestUsers;
import io.jiogram.types.WebAppInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents one button of the reply keyboard. At most one of the fields other than
 * text, icon_custom_emoji_id, and style must be used to specify the type of the button. For simple
 * text buttons, String can be used instead of this object to specify the button text.
 *
 * @see <a href="https://core.telegram.org/bots/api#keyboardbutton">KeyboardButton in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class KeyboardButton {

    @JsonProperty("text")
    private final String text;

    @JsonProperty("icon_custom_emoji_id")
    private final @Nullable String iconCustomEmojiId;

    @JsonProperty("style")
    private final @Nullable String style;

    @JsonProperty("request_users")
    private final @Nullable KeyboardButtonRequestUsers requestUsers;

    @JsonProperty("request_chat")
    private final @Nullable KeyboardButtonRequestChat requestChat;

    @JsonProperty("request_managed_bot")
    private final @Nullable KeyboardButtonRequestManagedBot requestManagedBot;

    @JsonProperty("request_contact")
    private final @Nullable Boolean requestContact;

    @JsonProperty("request_location")
    private final @Nullable Boolean requestLocation;

    @JsonProperty("request_poll")
    private final @Nullable KeyboardButtonPollType requestPoll;

    @JsonProperty("web_app")
    private final @Nullable WebAppInfo webApp;

    /**
     * Creates a new {@code KeyboardButton} instance.
     *
     * @param text Text of the button. If none of the fields other than text, icon_custom_emoji_id,
     *     and style are used, it will be sent as a message when the button is pressed
     * @param iconCustomEmojiId Unique identifier of the custom emoji shown before the text of the
     *     button. Can only be used by bots that purchased additional usernames on Fragment or in
     *     the messages directly sent by the bot to private, group and supergroup chats if the owner
     *     of the bot has a Telegram Premium subscription.
     * @param style Style of the button. Must be one of 'danger' (red), 'success' (green) or
     *     'primary' (blue). If omitted, then an app-specific style is used.
     * @param requestUsers If specified, pressing the button will open a list of suitable users.
     *     Identifiers of selected users will be sent to the bot in a 'users_shared' service
     *     message. Available in private chats only.
     * @param requestChat If specified, pressing the button will open a list of suitable chats.
     *     Tapping on a chat will send its identifier to the bot in a 'chat_shared' service message.
     *     Available in private chats only.
     * @param requestManagedBot If specified, pressing the button will ask the user to create and
     *     share a bot that will be managed by the current bot. Available for bots that enabled
     *     management of other bots in the &#64;BotFather Mini App. Available in private chats only.
     * @param requestContact If True, the user's phone number will be sent as a contact when the
     *     button is pressed. Available in private chats only.
     * @param requestLocation If True, the user's current location will be sent when the button is
     *     pressed. Available in private chats only.
     * @param requestPoll If specified, the user will be asked to create a poll and send it to the
     *     bot when the button is pressed. Available in private chats only.
     * @param webApp If specified, the described Web App will be launched when the button is
     *     pressed. The Web App will be able to send a 'web_app_data' service message. Available in
     *     private chats only.
     */
    @JsonCreator
    public KeyboardButton(
            @JsonProperty("text") String text,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId,
            @JsonProperty("style") @Nullable String style,
            @JsonProperty("request_users") @Nullable KeyboardButtonRequestUsers requestUsers,
            @JsonProperty("request_chat") @Nullable KeyboardButtonRequestChat requestChat,
            @JsonProperty("request_managed_bot") @Nullable KeyboardButtonRequestManagedBot requestManagedBot,
            @JsonProperty("request_contact") @Nullable Boolean requestContact,
            @JsonProperty("request_location") @Nullable Boolean requestLocation,
            @JsonProperty("request_poll") @Nullable KeyboardButtonPollType requestPoll,
            @JsonProperty("web_app") @Nullable WebAppInfo webApp) {
        this.text = text;
        this.iconCustomEmojiId = iconCustomEmojiId;
        this.style = style;
        this.requestUsers = requestUsers;
        this.requestChat = requestChat;
        this.requestManagedBot = requestManagedBot;
        this.requestContact = requestContact;
        this.requestLocation = requestLocation;
        this.requestPoll = requestPoll;
        this.webApp = webApp;
    }

    public static KeyboardButton of(String text) {
        return new KeyboardButton(text, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Text of the button. If none of the fields other than text, icon_custom_emoji_id, and style
     * are used, it will be sent as a message when the button is pressed
     */
    public String text() {
        return text;
    }

    /**
     * Unique identifier of the custom emoji shown before the text of the button. Can only be used
     * by bots that purchased additional usernames on Fragment or in the messages directly sent by
     * the bot to private, group and supergroup chats if the owner of the bot has a Telegram Premium
     * subscription.
     */
    public @Nullable String iconCustomEmojiId() {
        return iconCustomEmojiId;
    }

    /**
     * Style of the button. Must be one of 'danger' (red), 'success' (green) or 'primary' (blue). If
     * omitted, then an app-specific style is used.
     */
    public @Nullable String style() {
        return style;
    }

    /**
     * If specified, pressing the button will open a list of suitable users. Identifiers of selected
     * users will be sent to the bot in a 'users_shared' service message. Available in private chats
     * only.
     */
    public @Nullable KeyboardButtonRequestUsers requestUsers() {
        return requestUsers;
    }

    /**
     * If specified, pressing the button will open a list of suitable chats. Tapping on a chat will
     * send its identifier to the bot in a 'chat_shared' service message. Available in private chats
     * only.
     */
    public @Nullable KeyboardButtonRequestChat requestChat() {
        return requestChat;
    }

    /**
     * If specified, pressing the button will ask the user to create and share a bot that will be
     * managed by the current bot. Available for bots that enabled management of other bots in the
     * &#64;BotFather Mini App. Available in private chats only.
     */
    public @Nullable KeyboardButtonRequestManagedBot requestManagedBot() {
        return requestManagedBot;
    }

    /**
     * If True, the user's phone number will be sent as a contact when the button is pressed.
     * Available in private chats only.
     */
    public @Nullable Boolean requestContact() {
        return requestContact;
    }

    /**
     * If True, the user's current location will be sent when the button is pressed. Available in
     * private chats only.
     */
    public @Nullable Boolean requestLocation() {
        return requestLocation;
    }

    /**
     * If specified, the user will be asked to create a poll and send it to the bot when the button
     * is pressed. Available in private chats only.
     */
    public @Nullable KeyboardButtonPollType requestPoll() {
        return requestPoll;
    }

    /**
     * If specified, the described Web App will be launched when the button is pressed. The Web App
     * will be able to send a 'web_app_data' service message. Available in private chats only.
     */
    public @Nullable WebAppInfo webApp() {
        return webApp;
    }

    public KeyboardButton withText(String text) {
        return new KeyboardButton(text, iconCustomEmojiId, style, requestUsers, requestChat, requestManagedBot, requestContact, requestLocation, requestPoll, webApp);
    }

    public KeyboardButton withIconCustomEmojiId(@Nullable String iconCustomEmojiId) {
        return new KeyboardButton(text, iconCustomEmojiId, style, requestUsers, requestChat, requestManagedBot, requestContact, requestLocation, requestPoll, webApp);
    }

    public KeyboardButton withStyle(@Nullable String style) {
        return new KeyboardButton(text, iconCustomEmojiId, style, requestUsers, requestChat, requestManagedBot, requestContact, requestLocation, requestPoll, webApp);
    }

    public KeyboardButton withRequestUsers(@Nullable KeyboardButtonRequestUsers requestUsers) {
        return new KeyboardButton(text, iconCustomEmojiId, style, requestUsers, requestChat, requestManagedBot, requestContact, requestLocation, requestPoll, webApp);
    }

    public KeyboardButton withRequestChat(@Nullable KeyboardButtonRequestChat requestChat) {
        return new KeyboardButton(text, iconCustomEmojiId, style, requestUsers, requestChat, requestManagedBot, requestContact, requestLocation, requestPoll, webApp);
    }

    public KeyboardButton withRequestManagedBot(@Nullable KeyboardButtonRequestManagedBot requestManagedBot) {
        return new KeyboardButton(text, iconCustomEmojiId, style, requestUsers, requestChat, requestManagedBot, requestContact, requestLocation, requestPoll, webApp);
    }

    public KeyboardButton withRequestContact(@Nullable Boolean requestContact) {
        return new KeyboardButton(text, iconCustomEmojiId, style, requestUsers, requestChat, requestManagedBot, requestContact, requestLocation, requestPoll, webApp);
    }

    public KeyboardButton withRequestLocation(@Nullable Boolean requestLocation) {
        return new KeyboardButton(text, iconCustomEmojiId, style, requestUsers, requestChat, requestManagedBot, requestContact, requestLocation, requestPoll, webApp);
    }

    public KeyboardButton withRequestPoll(@Nullable KeyboardButtonPollType requestPoll) {
        return new KeyboardButton(text, iconCustomEmojiId, style, requestUsers, requestChat, requestManagedBot, requestContact, requestLocation, requestPoll, webApp);
    }

    public KeyboardButton withWebApp(@Nullable WebAppInfo webApp) {
        return new KeyboardButton(text, iconCustomEmojiId, style, requestUsers, requestChat, requestManagedBot, requestContact, requestLocation, requestPoll, webApp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KeyboardButton)) {
            return false;
        }
        KeyboardButton that = (KeyboardButton) o;
        return Objects.equals(this.text, that.text)
                && Objects.equals(this.iconCustomEmojiId, that.iconCustomEmojiId)
                && Objects.equals(this.style, that.style)
                && Objects.equals(this.requestUsers, that.requestUsers)
                && Objects.equals(this.requestChat, that.requestChat)
                && Objects.equals(this.requestManagedBot, that.requestManagedBot)
                && Objects.equals(this.requestContact, that.requestContact)
                && Objects.equals(this.requestLocation, that.requestLocation)
                && Objects.equals(this.requestPoll, that.requestPoll)
                && Objects.equals(this.webApp, that.webApp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.iconCustomEmojiId, this.style, this.requestUsers, this.requestChat, this.requestManagedBot, this.requestContact, this.requestLocation, this.requestPoll, this.webApp);
    }

    @Override
    public String toString() {
        return "KeyboardButton[text=" + this.text
                + ", iconCustomEmojiId=" + this.iconCustomEmojiId
                + ", style=" + this.style
                + ", requestUsers=" + this.requestUsers
                + ", requestChat=" + this.requestChat
                + ", requestManagedBot=" + this.requestManagedBot
                + ", requestContact=" + this.requestContact
                + ", requestLocation=" + this.requestLocation
                + ", requestPoll=" + this.requestPoll
                + ", webApp=" + this.webApp
                + "]";
    }
}
