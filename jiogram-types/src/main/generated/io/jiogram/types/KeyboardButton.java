package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButtonPollType;
import io.jiogram.types.KeyboardButtonRequestChat;
import io.jiogram.types.KeyboardButtonRequestManagedBot;
import io.jiogram.types.KeyboardButtonRequestUsers;
import io.jiogram.types.WebAppInfo;
import org.jspecify.annotations.Nullable;

public class KeyboardButton {
    @JsonProperty("text") private final String text;
    @JsonProperty("icon_custom_emoji_id") @Nullable private final String iconCustomEmojiId;
    @JsonProperty("style") @Nullable private final String style;
    @JsonProperty("request_users") @Nullable private final KeyboardButtonRequestUsers requestUsers;
    @JsonProperty("request_chat") @Nullable private final KeyboardButtonRequestChat requestChat;
    @JsonProperty("request_managed_bot") @Nullable private final KeyboardButtonRequestManagedBot requestManagedBot;
    @JsonProperty("request_contact") @Nullable private final Boolean requestContact;
    @JsonProperty("request_location") @Nullable private final Boolean requestLocation;
    @JsonProperty("request_poll") @Nullable private final KeyboardButtonPollType requestPoll;
    @JsonProperty("web_app") @Nullable private final WebAppInfo webApp;

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
            @JsonProperty("web_app") @Nullable WebAppInfo webApp
    ) {
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

    public String text() {
        return this.text;
    }

    public String iconCustomEmojiId() {
        return this.iconCustomEmojiId;
    }

    public String style() {
        return this.style;
    }

    public KeyboardButtonRequestUsers requestUsers() {
        return this.requestUsers;
    }

    public KeyboardButtonRequestChat requestChat() {
        return this.requestChat;
    }

    public KeyboardButtonRequestManagedBot requestManagedBot() {
        return this.requestManagedBot;
    }

    public Boolean requestContact() {
        return this.requestContact;
    }

    public Boolean requestLocation() {
        return this.requestLocation;
    }

    public KeyboardButtonPollType requestPoll() {
        return this.requestPoll;
    }

    public WebAppInfo webApp() {
        return this.webApp;
    }
}
