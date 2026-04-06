package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButtonPollType;
import io.jiogram.types.KeyboardButtonRequestChat;
import io.jiogram.types.KeyboardButtonRequestManagedBot;
import io.jiogram.types.KeyboardButtonRequestUsers;
import io.jiogram.types.WebAppInfo;
import org.jspecify.annotations.Nullable;

public record KeyboardButton(
    @JsonProperty("text") String text,
    @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId,
    @JsonProperty("style") @Nullable String style,
    @JsonProperty("request_users") @Nullable KeyboardButtonRequestUsers requestUsers,
    @JsonProperty("request_chat") @Nullable KeyboardButtonRequestChat requestChat,
    @JsonProperty("request_managed_bot") @Nullable KeyboardButtonRequestManagedBot requestManagedBot,
    @JsonProperty("request_contact") @Nullable Boolean requestContact,
    @JsonProperty("request_location") @Nullable Boolean requestLocation,
    @JsonProperty("request_poll") @Nullable KeyboardButtonPollType requestPoll,
    @JsonProperty("web_app") @Nullable WebAppInfo webApp
) {}
