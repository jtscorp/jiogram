package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import org.jspecify.annotations.Nullable;

public class KeyboardButtonRequestChat {
    @JsonProperty("request_id") private final long requestId;
    @JsonProperty("chat_is_channel") private final boolean chatIsChannel;
    @JsonProperty("chat_is_forum") @Nullable private final Boolean chatIsForum;
    @JsonProperty("chat_has_username") @Nullable private final Boolean chatHasUsername;
    @JsonProperty("chat_is_created") @Nullable private final Boolean chatIsCreated;
    @JsonProperty("user_administrator_rights") @Nullable private final ChatAdministratorRights userAdministratorRights;
    @JsonProperty("bot_administrator_rights") @Nullable private final ChatAdministratorRights botAdministratorRights;
    @JsonProperty("bot_is_member") @Nullable private final Boolean botIsMember;
    @JsonProperty("request_title") @Nullable private final Boolean requestTitle;
    @JsonProperty("request_username") @Nullable private final Boolean requestUsername;
    @JsonProperty("request_photo") @Nullable private final Boolean requestPhoto;

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
            @JsonProperty("request_photo") @Nullable Boolean requestPhoto
    ) {
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

    public long requestId() {
        return this.requestId;
    }

    public boolean chatIsChannel() {
        return this.chatIsChannel;
    }

    public Boolean chatIsForum() {
        return this.chatIsForum;
    }

    public Boolean chatHasUsername() {
        return this.chatHasUsername;
    }

    public Boolean chatIsCreated() {
        return this.chatIsCreated;
    }

    public ChatAdministratorRights userAdministratorRights() {
        return this.userAdministratorRights;
    }

    public ChatAdministratorRights botAdministratorRights() {
        return this.botAdministratorRights;
    }

    public Boolean botIsMember() {
        return this.botIsMember;
    }

    public Boolean requestTitle() {
        return this.requestTitle;
    }

    public Boolean requestUsername() {
        return this.requestUsername;
    }

    public Boolean requestPhoto() {
        return this.requestPhoto;
    }
}
