package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatPermissions;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to set default chat permissions for all members. The bot must be an administrator
 * in the group or a supergroup for this to work and must have the can_restrict_members
 * administrator rights. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @param permissions A JSON-serialized object for new default chat permissions
 * @param useIndependentChatPermissions Pass True if chat permissions are set independently.
 *     Otherwise, the can_send_other_messages and can_add_web_page_previews permissions will imply
 *     the can_send_messages, can_send_audios, can_send_documents, can_send_photos, can_send_videos,
 *     can_send_video_notes, and can_send_voice_notes permissions; the can_send_polls permission
 *     will imply the can_send_messages permission.
 * @see <a href="https://core.telegram.org/bots/api#setchatpermissions">setChatPermissions in the Bot API</a>
 */
public record SetChatPermissions(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("permissions") ChatPermissions permissions,
    @JsonProperty("use_independent_chat_permissions") @Nullable Boolean useIndependentChatPermissions
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatPermissions";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetChatPermissions of(ChatId chatId, ChatPermissions permissions) {
        return new SetChatPermissions(chatId, permissions, null);
    }
}
