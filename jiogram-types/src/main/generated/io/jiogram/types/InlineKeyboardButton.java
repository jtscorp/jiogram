package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.CallbackGame;
import io.jiogram.types.CopyTextButton;
import io.jiogram.types.LoginUrl;
import io.jiogram.types.SwitchInlineQueryChosenChat;
import io.jiogram.types.WebAppInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents one button of an inline keyboard. Exactly one of the fields other than
 * text, icon_custom_emoji_id, and style must be used to specify the type of the button.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardbutton">InlineKeyboardButton in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineKeyboardButton {

    @JsonProperty("text")
    private final String text;

    @JsonProperty("icon_custom_emoji_id")
    private final @Nullable String iconCustomEmojiId;

    @JsonProperty("style")
    private final @Nullable String style;

    @JsonProperty("url")
    private final @Nullable String url;

    @JsonProperty("callback_data")
    private final @Nullable String callbackData;

    @JsonProperty("web_app")
    private final @Nullable WebAppInfo webApp;

    @JsonProperty("login_url")
    private final @Nullable LoginUrl loginUrl;

    @JsonProperty("switch_inline_query")
    private final @Nullable String switchInlineQuery;

    @JsonProperty("switch_inline_query_current_chat")
    private final @Nullable String switchInlineQueryCurrentChat;

    @JsonProperty("switch_inline_query_chosen_chat")
    private final @Nullable SwitchInlineQueryChosenChat switchInlineQueryChosenChat;

    @JsonProperty("copy_text")
    private final @Nullable CopyTextButton copyText;

    @JsonProperty("callback_game")
    private final @Nullable CallbackGame callbackGame;

    @JsonProperty("pay")
    private final @Nullable Boolean pay;

    /**
     * Creates a new {@code InlineKeyboardButton} instance.
     *
     * @param text Label text on the button
     * @param iconCustomEmojiId Unique identifier of the custom emoji shown before the text of the
     *     button. Can only be used by bots that purchased additional usernames on Fragment or in
     *     the messages directly sent by the bot to private, group and supergroup chats if the owner
     *     of the bot has a Telegram Premium subscription.
     * @param style Style of the button. Must be one of 'danger' (red), 'success' (green) or
     *     'primary' (blue). If omitted, then an app-specific style is used.
     * @param url HTTP or tg:// URL to be opened when the button is pressed. Links
     *     tg://user?id=&lt;user_id&gt; can be used to mention a user by their identifier without
     *     using a username, if this is allowed by their privacy settings.
     * @param callbackData Data to be sent in a callback query to the bot when the button is
     *     pressed, 1-64 bytes
     * @param webApp Description of the Web App that will be launched when the user presses the
     *     button. The Web App will be able to send an arbitrary message on behalf of the user using
     *     the method answerWebAppQuery. Available only in private chats between a user and the bot.
     *     Not supported for messages sent on behalf of a Telegram Business account.
     * @param loginUrl An HTTPS URL used to automatically authorize the user. Can be used as a
     *     replacement for the Telegram Login Widget.
     * @param switchInlineQuery If set, pressing the button will prompt the user to select one of
     *     their chats, open that chat and insert the bot's username and the specified inline query
     *     in the input field. May be empty, in which case just the bot's username will be inserted.
     *     Not supported for messages sent in channel direct messages chats and on behalf of a
     *     Telegram Business account.
     * @param switchInlineQueryCurrentChat If set, pressing the button will insert the bot's
     *     username and the specified inline query in the current chat's input field. May be empty,
     *     in which case only the bot's username will be inserted. This offers a quick way for the
     *     user to open your bot in inline mode in the same chat - good for selecting something from
     *     multiple options. Not supported in channels and for messages sent in channel direct
     *     messages chats and on behalf of a Telegram Business account.
     * @param switchInlineQueryChosenChat If set, pressing the button will prompt the user to select
     *     one of their chats of the specified type, open that chat and insert the bot's username
     *     and the specified inline query in the input field. Not supported for messages sent in
     *     channel direct messages chats and on behalf of a Telegram Business account.
     * @param copyText Description of the button that copies the specified text to the clipboard.
     * @param callbackGame Description of the game that will be launched when the user presses the
     *     button. NOTE: This type of button must always be the first button in the first row.
     * @param pay Specify True, to send a Pay button. Substrings '' and 'XTR' in the buttons's text
     *     will be replaced with a Telegram Star icon. NOTE: This type of button must always be the
     *     first button in the first row and can only be used in invoice messages.
     */
    @JsonCreator
    public InlineKeyboardButton(
            @JsonProperty("text") String text,
            @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId,
            @JsonProperty("style") @Nullable String style,
            @JsonProperty("url") @Nullable String url,
            @JsonProperty("callback_data") @Nullable String callbackData,
            @JsonProperty("web_app") @Nullable WebAppInfo webApp,
            @JsonProperty("login_url") @Nullable LoginUrl loginUrl,
            @JsonProperty("switch_inline_query") @Nullable String switchInlineQuery,
            @JsonProperty("switch_inline_query_current_chat") @Nullable String switchInlineQueryCurrentChat,
            @JsonProperty("switch_inline_query_chosen_chat") @Nullable SwitchInlineQueryChosenChat switchInlineQueryChosenChat,
            @JsonProperty("copy_text") @Nullable CopyTextButton copyText,
            @JsonProperty("callback_game") @Nullable CallbackGame callbackGame,
            @JsonProperty("pay") @Nullable Boolean pay) {
        this.text = text;
        this.iconCustomEmojiId = iconCustomEmojiId;
        this.style = style;
        this.url = url;
        this.callbackData = callbackData;
        this.webApp = webApp;
        this.loginUrl = loginUrl;
        this.switchInlineQuery = switchInlineQuery;
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
        this.switchInlineQueryChosenChat = switchInlineQueryChosenChat;
        this.copyText = copyText;
        this.callbackGame = callbackGame;
        this.pay = pay;
    }

    public static InlineKeyboardButton of(String text) {
        return new InlineKeyboardButton(text, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Label text on the button
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
     * HTTP or tg:// URL to be opened when the button is pressed. Links tg://user?id=&lt;user_id&gt;
     * can be used to mention a user by their identifier without using a username, if this is
     * allowed by their privacy settings.
     */
    public @Nullable String url() {
        return url;
    }

    /**
     * Data to be sent in a callback query to the bot when the button is pressed, 1-64 bytes
     */
    public @Nullable String callbackData() {
        return callbackData;
    }

    /**
     * Description of the Web App that will be launched when the user presses the button. The Web
     * App will be able to send an arbitrary message on behalf of the user using the method
     * answerWebAppQuery. Available only in private chats between a user and the bot. Not supported
     * for messages sent on behalf of a Telegram Business account.
     */
    public @Nullable WebAppInfo webApp() {
        return webApp;
    }

    /**
     * An HTTPS URL used to automatically authorize the user. Can be used as a replacement for the
     * Telegram Login Widget.
     */
    public @Nullable LoginUrl loginUrl() {
        return loginUrl;
    }

    /**
     * If set, pressing the button will prompt the user to select one of their chats, open that chat
     * and insert the bot's username and the specified inline query in the input field. May be
     * empty, in which case just the bot's username will be inserted. Not supported for messages
     * sent in channel direct messages chats and on behalf of a Telegram Business account.
     */
    public @Nullable String switchInlineQuery() {
        return switchInlineQuery;
    }

    /**
     * If set, pressing the button will insert the bot's username and the specified inline query in
     * the current chat's input field. May be empty, in which case only the bot's username will be
     * inserted. This offers a quick way for the user to open your bot in inline mode in the same
     * chat - good for selecting something from multiple options. Not supported in channels and for
     * messages sent in channel direct messages chats and on behalf of a Telegram Business account.
     */
    public @Nullable String switchInlineQueryCurrentChat() {
        return switchInlineQueryCurrentChat;
    }

    /**
     * If set, pressing the button will prompt the user to select one of their chats of the
     * specified type, open that chat and insert the bot's username and the specified inline query
     * in the input field. Not supported for messages sent in channel direct messages chats and on
     * behalf of a Telegram Business account.
     */
    public @Nullable SwitchInlineQueryChosenChat switchInlineQueryChosenChat() {
        return switchInlineQueryChosenChat;
    }

    /**
     * Description of the button that copies the specified text to the clipboard.
     */
    public @Nullable CopyTextButton copyText() {
        return copyText;
    }

    /**
     * Description of the game that will be launched when the user presses the button. NOTE: This
     * type of button must always be the first button in the first row.
     */
    public @Nullable CallbackGame callbackGame() {
        return callbackGame;
    }

    /**
     * Specify True, to send a Pay button. Substrings '' and 'XTR' in the buttons's text will be
     * replaced with a Telegram Star icon. NOTE: This type of button must always be the first button
     * in the first row and can only be used in invoice messages.
     */
    public @Nullable Boolean pay() {
        return pay;
    }

    public InlineKeyboardButton withText(String text) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withIconCustomEmojiId(@Nullable String iconCustomEmojiId) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withStyle(@Nullable String style) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withUrl(@Nullable String url) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withCallbackData(@Nullable String callbackData) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withWebApp(@Nullable WebAppInfo webApp) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withLoginUrl(@Nullable LoginUrl loginUrl) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withSwitchInlineQuery(@Nullable String switchInlineQuery) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withSwitchInlineQueryCurrentChat(@Nullable String switchInlineQueryCurrentChat) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withSwitchInlineQueryChosenChat(@Nullable SwitchInlineQueryChosenChat switchInlineQueryChosenChat) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withCopyText(@Nullable CopyTextButton copyText) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withCallbackGame(@Nullable CallbackGame callbackGame) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    public InlineKeyboardButton withPay(@Nullable Boolean pay) {
        return new InlineKeyboardButton(text, iconCustomEmojiId, style, url, callbackData, webApp, loginUrl, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, copyText, callbackGame, pay);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineKeyboardButton)) {
            return false;
        }
        InlineKeyboardButton that = (InlineKeyboardButton) o;
        return Objects.equals(this.text, that.text)
                && Objects.equals(this.iconCustomEmojiId, that.iconCustomEmojiId)
                && Objects.equals(this.style, that.style)
                && Objects.equals(this.url, that.url)
                && Objects.equals(this.callbackData, that.callbackData)
                && Objects.equals(this.webApp, that.webApp)
                && Objects.equals(this.loginUrl, that.loginUrl)
                && Objects.equals(this.switchInlineQuery, that.switchInlineQuery)
                && Objects.equals(this.switchInlineQueryCurrentChat, that.switchInlineQueryCurrentChat)
                && Objects.equals(this.switchInlineQueryChosenChat, that.switchInlineQueryChosenChat)
                && Objects.equals(this.copyText, that.copyText)
                && Objects.equals(this.callbackGame, that.callbackGame)
                && Objects.equals(this.pay, that.pay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.iconCustomEmojiId, this.style, this.url, this.callbackData, this.webApp, this.loginUrl, this.switchInlineQuery, this.switchInlineQueryCurrentChat, this.switchInlineQueryChosenChat, this.copyText, this.callbackGame, this.pay);
    }

    @Override
    public String toString() {
        return "InlineKeyboardButton[text=" + this.text
                + ", iconCustomEmojiId=" + this.iconCustomEmojiId
                + ", style=" + this.style
                + ", url=" + this.url
                + ", callbackData=" + this.callbackData
                + ", webApp=" + this.webApp
                + ", loginUrl=" + this.loginUrl
                + ", switchInlineQuery=" + this.switchInlineQuery
                + ", switchInlineQueryCurrentChat=" + this.switchInlineQueryCurrentChat
                + ", switchInlineQueryChosenChat=" + this.switchInlineQueryChosenChat
                + ", copyText=" + this.copyText
                + ", callbackGame=" + this.callbackGame
                + ", pay=" + this.pay
                + "]";
    }
}
