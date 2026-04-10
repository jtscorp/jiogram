package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.CallbackGame;
import io.jiogram.types.CopyTextButton;
import io.jiogram.types.LoginUrl;
import io.jiogram.types.SwitchInlineQueryChosenChat;
import io.jiogram.types.WebAppInfo;
import org.jspecify.annotations.Nullable;

public class InlineKeyboardButton {
    @JsonProperty("text") private final String text;
    @JsonProperty("icon_custom_emoji_id") @Nullable private final String iconCustomEmojiId;
    @JsonProperty("style") @Nullable private final String style;
    @JsonProperty("url") @Nullable private final String url;
    @JsonProperty("callback_data") @Nullable private final String callbackData;
    @JsonProperty("web_app") @Nullable private final WebAppInfo webApp;
    @JsonProperty("login_url") @Nullable private final LoginUrl loginUrl;
    @JsonProperty("switch_inline_query") @Nullable private final String switchInlineQuery;
    @JsonProperty("switch_inline_query_current_chat") @Nullable private final String switchInlineQueryCurrentChat;
    @JsonProperty("switch_inline_query_chosen_chat") @Nullable private final SwitchInlineQueryChosenChat switchInlineQueryChosenChat;
    @JsonProperty("copy_text") @Nullable private final CopyTextButton copyText;
    @JsonProperty("callback_game") @Nullable private final CallbackGame callbackGame;
    @JsonProperty("pay") @Nullable private final Boolean pay;

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
            @JsonProperty("pay") @Nullable Boolean pay
    ) {
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

    public String text() {
        return this.text;
    }

    public String iconCustomEmojiId() {
        return this.iconCustomEmojiId;
    }

    public String style() {
        return this.style;
    }

    public String url() {
        return this.url;
    }

    public String callbackData() {
        return this.callbackData;
    }

    public WebAppInfo webApp() {
        return this.webApp;
    }

    public LoginUrl loginUrl() {
        return this.loginUrl;
    }

    public String switchInlineQuery() {
        return this.switchInlineQuery;
    }

    public String switchInlineQueryCurrentChat() {
        return this.switchInlineQueryCurrentChat;
    }

    public SwitchInlineQueryChosenChat switchInlineQueryChosenChat() {
        return this.switchInlineQueryChosenChat;
    }

    public CopyTextButton copyText() {
        return this.copyText;
    }

    public CallbackGame callbackGame() {
        return this.callbackGame;
    }

    public Boolean pay() {
        return this.pay;
    }
}
