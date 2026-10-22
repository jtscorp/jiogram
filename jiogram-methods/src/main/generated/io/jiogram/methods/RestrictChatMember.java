package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatPermissions;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to restrict a user in a supergroup. The bot must be an administrator in the
 * supergroup for this to work and must have the appropriate administrator rights. Pass True for all
 * permissions to lift restrictions from a user. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @param userId Unique identifier of the target user
 * @param permissions A JSON-serialized object for new user permissions
 * @param useIndependentChatPermissions Pass True if chat permissions are set independently.
 *     Otherwise, the can_send_other_messages and can_add_web_page_previews permissions will imply
 *     the can_send_messages, can_send_audios, can_send_documents, can_send_photos, can_send_videos,
 *     can_send_video_notes, and can_send_voice_notes permissions; the can_send_polls permission
 *     will imply the can_send_messages permission.
 * @param untilDate Date when restrictions will be lifted for the user; Unix time. If user is
 *     restricted for more than 366 days or less than 30 seconds from the current time, they are
 *     considered to be restricted forever
 * @see <a href="https://core.telegram.org/bots/api#restrictchatmember">restrictChatMember in the Bot API</a>
 */
public record RestrictChatMember(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("permissions") ChatPermissions permissions,
    @JsonProperty("use_independent_chat_permissions") @Nullable Boolean useIndependentChatPermissions,
    @JsonProperty("until_date") @Nullable Long untilDate
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "restrictChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static RestrictChatMember of(ChatId chatId, long userId, ChatPermissions permissions) {
        return new RestrictChatMember(chatId, userId, permissions, null, null);
    }
}
