package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import org.jspecify.annotations.Nullable;

/**
 * This object defines the criteria used to request a suitable chat. Information about the selected
 * chat will be shared with the bot when the corresponding button is pressed. The bot will be
 * granted requested rights in the chat if appropriate..
 *
 * @param requestId Signed 32-bit identifier of the request, which will be received back in the
 *     ChatShared object. Must be unique within the message
 * @param chatIsChannel Pass True to request a channel chat, pass False to request a group or a
 *     supergroup chat.
 * @param chatIsForum Pass True to request a forum supergroup, pass False to request a non-forum
 *     chat. If not specified, no additional restrictions are applied.
 * @param chatHasUsername Pass True to request a supergroup or a channel with a username, pass False
 *     to request a chat without a username. If not specified, no additional restrictions are
 *     applied.
 * @param chatIsCreated Pass True to request a chat owned by the user. Otherwise, no additional
 *     restrictions are applied.
 * @param userAdministratorRights A JSON-serialized object listing the required administrator rights
 *     of the user in the chat. The rights must be a superset of bot_administrator_rights. If not
 *     specified, no additional restrictions are applied.
 * @param botAdministratorRights A JSON-serialized object listing the required administrator rights
 *     of the bot in the chat. The rights must be a subset of user_administrator_rights. If not
 *     specified, no additional restrictions are applied.
 * @param botIsMember Pass True to request a chat with the bot as a member. Otherwise, no additional
 *     restrictions are applied.
 * @param requestTitle Pass True to request the chat's title
 * @param requestUsername Pass True to request the chat's username
 * @param requestPhoto Pass True to request the chat's photo
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestchat">KeyboardButtonRequestChat in the Bot API</a>
 */
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
