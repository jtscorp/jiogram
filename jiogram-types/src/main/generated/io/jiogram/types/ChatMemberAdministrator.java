package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Represents a chat member that has some additional privileges.
 *
 * @param status The member's status in the chat, always 'administrator'
 * @param user Information about the user
 * @param canBeEdited True, if the bot is allowed to edit administrator privileges of that user
 * @param isAnonymous True, if the user's presence in the chat is hidden
 * @param canManageChat True, if the administrator can access the chat event log, get boost list,
 *     see hidden supergroup and channel members, report spam messages, ignore slow mode, and send
 *     messages to the chat without paying Telegram Stars. Implied by any other administrator
 *     privilege.
 * @param canDeleteMessages True, if the administrator can delete messages of other users
 * @param canManageVideoChats True, if the administrator can manage video chats
 * @param canRestrictMembers True, if the administrator can restrict, ban or unban chat members, or
 *     access supergroup statistics
 * @param canPromoteMembers True, if the administrator can add new administrators with a subset of
 *     their own privileges or demote administrators that they have promoted, directly or indirectly
 *     (promoted by administrators that were appointed by the user)
 * @param canChangeInfo True, if the user is allowed to change the chat title, photo and other
 *     settings
 * @param canInviteUsers True, if the user is allowed to invite new users to the chat
 * @param canPostStories True, if the administrator can post stories to the chat
 * @param canEditStories True, if the administrator can edit stories posted by other users, post
 *     stories to the chat page, pin chat stories, and access the chat's story archive
 * @param canDeleteStories True, if the administrator can delete stories posted by other users
 * @param canPostMessages True, if the administrator can post messages in the channel, approve
 *     suggested posts, or access channel statistics; for channels only
 * @param canEditMessages True, if the administrator can edit messages of other users and can pin
 *     messages; for channels only
 * @param canPinMessages True, if the user is allowed to pin messages; for groups and supergroups
 *     only
 * @param canManageTopics True, if the user is allowed to create, rename, close, and reopen forum
 *     topics; for supergroups only
 * @param canManageDirectMessages True, if the administrator can manage direct messages of the
 *     channel and decline suggested posts; for channels only
 * @param canManageTags True, if the administrator can edit the tags of regular members; for groups
 *     and supergroups only. If omitted defaults to the value of can_pin_messages.
 * @param customTitle Custom title for this user
 * @see <a href="https://core.telegram.org/bots/api#chatmemberadministrator">ChatMemberAdministrator in the Bot API</a>
 */
public record ChatMemberAdministrator(
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
    @JsonProperty("user") User user,
    @JsonProperty("can_be_edited") boolean canBeEdited,
    @JsonProperty("is_anonymous") boolean isAnonymous,
    @JsonProperty("can_manage_chat") boolean canManageChat,
    @JsonProperty("can_delete_messages") boolean canDeleteMessages,
    @JsonProperty("can_manage_video_chats") boolean canManageVideoChats,
    @JsonProperty("can_restrict_members") boolean canRestrictMembers,
    @JsonProperty("can_promote_members") boolean canPromoteMembers,
    @JsonProperty("can_change_info") boolean canChangeInfo,
    @JsonProperty("can_invite_users") boolean canInviteUsers,
    @JsonProperty("can_post_stories") boolean canPostStories,
    @JsonProperty("can_edit_stories") boolean canEditStories,
    @JsonProperty("can_delete_stories") boolean canDeleteStories,
    @JsonProperty("can_post_messages") @Nullable Boolean canPostMessages,
    @JsonProperty("can_edit_messages") @Nullable Boolean canEditMessages,
    @JsonProperty("can_pin_messages") @Nullable Boolean canPinMessages,
    @JsonProperty("can_manage_topics") @Nullable Boolean canManageTopics,
    @JsonProperty("can_manage_direct_messages") @Nullable Boolean canManageDirectMessages,
    @JsonProperty("can_manage_tags") @Nullable Boolean canManageTags,
    @JsonProperty("custom_title") @Nullable String customTitle
) implements ChatMember {

    public static ChatMemberAdministrator of(User user, boolean canBeEdited, boolean isAnonymous, boolean canManageChat, boolean canDeleteMessages, boolean canManageVideoChats, boolean canRestrictMembers, boolean canPromoteMembers, boolean canChangeInfo, boolean canInviteUsers, boolean canPostStories, boolean canEditStories, boolean canDeleteStories) {
        return new ChatMemberAdministrator(ChatMemberType.ADMINISTRATOR, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, null, null, null, null, null, null, null);
    }

    public ChatMemberAdministrator withUser(User user) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanBeEdited(boolean canBeEdited) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withIsAnonymous(boolean isAnonymous) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanManageChat(boolean canManageChat) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanDeleteMessages(boolean canDeleteMessages) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanManageVideoChats(boolean canManageVideoChats) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanRestrictMembers(boolean canRestrictMembers) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanPromoteMembers(boolean canPromoteMembers) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanChangeInfo(boolean canChangeInfo) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanInviteUsers(boolean canInviteUsers) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanPostStories(boolean canPostStories) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanEditStories(boolean canEditStories) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanDeleteStories(boolean canDeleteStories) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanPostMessages(@Nullable Boolean canPostMessages) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanEditMessages(@Nullable Boolean canEditMessages) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanPinMessages(@Nullable Boolean canPinMessages) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanManageTopics(@Nullable Boolean canManageTopics) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanManageDirectMessages(@Nullable Boolean canManageDirectMessages) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCanManageTags(@Nullable Boolean canManageTags) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }

    public ChatMemberAdministrator withCustomTitle(@Nullable String customTitle) {
        return new ChatMemberAdministrator(status, user, canBeEdited, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags, customTitle);
    }
}
