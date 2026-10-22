package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to promote or demote a user in a supergroup or a channel. The bot must be an
 * administrator in the chat for this to work and must have the appropriate administrator rights.
 * Pass False for all boolean parameters to demote a user. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param userId Unique identifier of the target user
 * @param isAnonymous Pass True if the administrator's presence in the chat is hidden
 * @param canManageChat Pass True if the administrator can access the chat event log, get boost
 *     list, see hidden supergroup and channel members, report spam messages, ignore slow mode, and
 *     send messages to the chat without paying Telegram Stars. Implied by any other administrator
 *     privilege.
 * @param canDeleteMessages Pass True if the administrator can delete messages of other users
 * @param canManageVideoChats Pass True if the administrator can manage video chats
 * @param canRestrictMembers Pass True if the administrator can restrict, ban or unban chat members,
 *     or access supergroup statistics. For backward compatibility, defaults to True for promotions
 *     of channel administrators
 * @param canPromoteMembers Pass True if the administrator can add new administrators with a subset
 *     of their own privileges or demote administrators that they have promoted, directly or
 *     indirectly (promoted by administrators that were appointed by him)
 * @param canChangeInfo Pass True if the administrator can change chat title, photo and other
 *     settings
 * @param canInviteUsers Pass True if the administrator can invite new users to the chat
 * @param canPostStories Pass True if the administrator can post stories to the chat
 * @param canEditStories Pass True if the administrator can edit stories posted by other users, post
 *     stories to the chat page, pin chat stories, and access the chat's story archive
 * @param canDeleteStories Pass True if the administrator can delete stories posted by other users
 * @param canPostMessages Pass True if the administrator can post messages in the channel, approve
 *     suggested posts, or access channel statistics; for channels only
 * @param canEditMessages Pass True if the administrator can edit messages of other users and can
 *     pin messages; for channels only
 * @param canPinMessages Pass True if the administrator can pin messages; for supergroups only
 * @param canManageTopics Pass True if the user is allowed to create, rename, close, and reopen
 *     forum topics; for supergroups only
 * @param canManageDirectMessages Pass True if the administrator can manage direct messages within
 *     the channel and decline suggested posts; for channels only
 * @param canManageTags Pass True if the administrator can edit the tags of regular members; for
 *     groups and supergroups only
 * @see <a href="https://core.telegram.org/bots/api#promotechatmember">promoteChatMember in the Bot API</a>
 */
public record PromoteChatMember(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("is_anonymous") @Nullable Boolean isAnonymous,
    @JsonProperty("can_manage_chat") @Nullable Boolean canManageChat,
    @JsonProperty("can_delete_messages") @Nullable Boolean canDeleteMessages,
    @JsonProperty("can_manage_video_chats") @Nullable Boolean canManageVideoChats,
    @JsonProperty("can_restrict_members") @Nullable Boolean canRestrictMembers,
    @JsonProperty("can_promote_members") @Nullable Boolean canPromoteMembers,
    @JsonProperty("can_change_info") @Nullable Boolean canChangeInfo,
    @JsonProperty("can_invite_users") @Nullable Boolean canInviteUsers,
    @JsonProperty("can_post_stories") @Nullable Boolean canPostStories,
    @JsonProperty("can_edit_stories") @Nullable Boolean canEditStories,
    @JsonProperty("can_delete_stories") @Nullable Boolean canDeleteStories,
    @JsonProperty("can_post_messages") @Nullable Boolean canPostMessages,
    @JsonProperty("can_edit_messages") @Nullable Boolean canEditMessages,
    @JsonProperty("can_pin_messages") @Nullable Boolean canPinMessages,
    @JsonProperty("can_manage_topics") @Nullable Boolean canManageTopics,
    @JsonProperty("can_manage_direct_messages") @Nullable Boolean canManageDirectMessages,
    @JsonProperty("can_manage_tags") @Nullable Boolean canManageTags
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "promoteChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static PromoteChatMember of(ChatId chatId, long userId) {
        return new PromoteChatMember(chatId, userId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
