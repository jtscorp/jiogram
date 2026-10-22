package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatPermissions;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to set default chat permissions for all members. The bot must be an administrator
 * in the group or a supergroup for this to work and must have the can_restrict_members
 * administrator rights. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatpermissions">setChatPermissions in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetChatPermissions implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("permissions")
    private final ChatPermissions permissions;

    @JsonProperty("use_independent_chat_permissions")
    private final @Nullable Boolean useIndependentChatPermissions;

    /**
     * Creates a new {@code SetChatPermissions} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     * @param permissions A JSON-serialized object for new default chat permissions
     * @param useIndependentChatPermissions Pass True if chat permissions are set independently.
     *     Otherwise, the can_send_other_messages and can_add_web_page_previews permissions will
     *     imply the can_send_messages, can_send_audios, can_send_documents, can_send_photos,
     *     can_send_videos, can_send_video_notes, and can_send_voice_notes permissions; the
     *     can_send_polls permission will imply the can_send_messages permission.
     */
    @JsonCreator
    public SetChatPermissions(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("permissions") ChatPermissions permissions,
            @JsonProperty("use_independent_chat_permissions") @Nullable Boolean useIndependentChatPermissions) {
        this.chatId = chatId;
        this.permissions = permissions;
        this.useIndependentChatPermissions = useIndependentChatPermissions;
    }

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

    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format
     * &#64;supergroupusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * A JSON-serialized object for new default chat permissions
     */
    public ChatPermissions permissions() {
        return permissions;
    }

    /**
     * Pass True if chat permissions are set independently. Otherwise, the can_send_other_messages
     * and can_add_web_page_previews permissions will imply the can_send_messages, can_send_audios,
     * can_send_documents, can_send_photos, can_send_videos, can_send_video_notes, and
     * can_send_voice_notes permissions; the can_send_polls permission will imply the
     * can_send_messages permission.
     */
    public @Nullable Boolean useIndependentChatPermissions() {
        return useIndependentChatPermissions;
    }

    public SetChatPermissions withChatId(ChatId chatId) {
        return new SetChatPermissions(chatId, permissions, useIndependentChatPermissions);
    }

    public SetChatPermissions withPermissions(ChatPermissions permissions) {
        return new SetChatPermissions(chatId, permissions, useIndependentChatPermissions);
    }

    public SetChatPermissions withUseIndependentChatPermissions(@Nullable Boolean useIndependentChatPermissions) {
        return new SetChatPermissions(chatId, permissions, useIndependentChatPermissions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetChatPermissions)) {
            return false;
        }
        SetChatPermissions that = (SetChatPermissions) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.permissions, that.permissions)
                && Objects.equals(this.useIndependentChatPermissions, that.useIndependentChatPermissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.permissions, this.useIndependentChatPermissions);
    }

    @Override
    public String toString() {
        return "SetChatPermissions[chatId=" + this.chatId
                + ", permissions=" + this.permissions
                + ", useIndependentChatPermissions=" + this.useIndependentChatPermissions
                + "]";
    }
}
