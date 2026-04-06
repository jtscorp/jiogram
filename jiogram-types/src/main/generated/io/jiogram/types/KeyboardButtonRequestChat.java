package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import org.jspecify.annotations.Nullable;

public record KeyboardButtonRequestChat(
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
) {}
