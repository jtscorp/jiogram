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
 * Use this method to restrict a user in a supergroup. The bot must be an administrator in the
 * supergroup for this to work and must have the appropriate administrator rights. Pass True for all
 * permissions to lift restrictions from a user. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#restrictchatmember">restrictChatMember in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RestrictChatMember implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("permissions")
    private final ChatPermissions permissions;

    @JsonProperty("use_independent_chat_permissions")
    private final @Nullable Boolean useIndependentChatPermissions;

    @JsonProperty("until_date")
    private final @Nullable Long untilDate;

    /**
     * Creates a new {@code RestrictChatMember} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     * @param userId Unique identifier of the target user
     * @param permissions A JSON-serialized object for new user permissions
     * @param useIndependentChatPermissions Pass True if chat permissions are set independently.
     *     Otherwise, the can_send_other_messages and can_add_web_page_previews permissions will
     *     imply the can_send_messages, can_send_audios, can_send_documents, can_send_photos,
     *     can_send_videos, can_send_video_notes, and can_send_voice_notes permissions; the
     *     can_send_polls permission will imply the can_send_messages permission.
     * @param untilDate Date when restrictions will be lifted for the user; Unix time. If user is
     *     restricted for more than 366 days or less than 30 seconds from the current time, they are
     *     considered to be restricted forever
     */
    @JsonCreator
    public RestrictChatMember(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId,
            @JsonProperty("permissions") ChatPermissions permissions,
            @JsonProperty("use_independent_chat_permissions") @Nullable Boolean useIndependentChatPermissions,
            @JsonProperty("until_date") @Nullable Long untilDate) {
        this.chatId = chatId;
        this.userId = userId;
        this.permissions = permissions;
        this.useIndependentChatPermissions = useIndependentChatPermissions;
        this.untilDate = untilDate;
    }

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

    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format
     * &#64;supergroupusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Unique identifier of the target user
     */
    public long userId() {
        return userId;
    }

    /**
     * A JSON-serialized object for new user permissions
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

    /**
     * Date when restrictions will be lifted for the user; Unix time. If user is restricted for more
     * than 366 days or less than 30 seconds from the current time, they are considered to be
     * restricted forever
     */
    public @Nullable Long untilDate() {
        return untilDate;
    }

    public RestrictChatMember withChatId(ChatId chatId) {
        return new RestrictChatMember(chatId, userId, permissions, useIndependentChatPermissions, untilDate);
    }

    public RestrictChatMember withUserId(long userId) {
        return new RestrictChatMember(chatId, userId, permissions, useIndependentChatPermissions, untilDate);
    }

    public RestrictChatMember withPermissions(ChatPermissions permissions) {
        return new RestrictChatMember(chatId, userId, permissions, useIndependentChatPermissions, untilDate);
    }

    public RestrictChatMember withUseIndependentChatPermissions(@Nullable Boolean useIndependentChatPermissions) {
        return new RestrictChatMember(chatId, userId, permissions, useIndependentChatPermissions, untilDate);
    }

    public RestrictChatMember withUntilDate(@Nullable Long untilDate) {
        return new RestrictChatMember(chatId, userId, permissions, useIndependentChatPermissions, untilDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestrictChatMember)) {
            return false;
        }
        RestrictChatMember that = (RestrictChatMember) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.userId == that.userId
                && Objects.equals(this.permissions, that.permissions)
                && Objects.equals(this.useIndependentChatPermissions, that.useIndependentChatPermissions)
                && Objects.equals(this.untilDate, that.untilDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.userId, this.permissions, this.useIndependentChatPermissions, this.untilDate);
    }

    @Override
    public String toString() {
        return "RestrictChatMember[chatId=" + this.chatId
                + ", userId=" + this.userId
                + ", permissions=" + this.permissions
                + ", useIndependentChatPermissions=" + this.useIndependentChatPermissions
                + ", untilDate=" + this.untilDate
                + "]";
    }
}
