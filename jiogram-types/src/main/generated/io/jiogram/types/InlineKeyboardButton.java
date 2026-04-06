package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.CallbackGame;
import io.jiogram.types.CopyTextButton;
import io.jiogram.types.LoginUrl;
import io.jiogram.types.SwitchInlineQueryChosenChat;
import io.jiogram.types.WebAppInfo;
import org.jspecify.annotations.Nullable;

public record InlineKeyboardButton(
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
) {}
