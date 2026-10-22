package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents the rights of an administrator in a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatadministratorrights">ChatAdministratorRights in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatAdministratorRights {

    @JsonProperty("is_anonymous")
    private final boolean isAnonymous;

    @JsonProperty("can_manage_chat")
    private final boolean canManageChat;

    @JsonProperty("can_delete_messages")
    private final boolean canDeleteMessages;

    @JsonProperty("can_manage_video_chats")
    private final boolean canManageVideoChats;

    @JsonProperty("can_restrict_members")
    private final boolean canRestrictMembers;

    @JsonProperty("can_promote_members")
    private final boolean canPromoteMembers;

    @JsonProperty("can_change_info")
    private final boolean canChangeInfo;

    @JsonProperty("can_invite_users")
    private final boolean canInviteUsers;

    @JsonProperty("can_post_stories")
    private final boolean canPostStories;

    @JsonProperty("can_edit_stories")
    private final boolean canEditStories;

    @JsonProperty("can_delete_stories")
    private final boolean canDeleteStories;

    @JsonProperty("can_post_messages")
    private final @Nullable Boolean canPostMessages;

    @JsonProperty("can_edit_messages")
    private final @Nullable Boolean canEditMessages;

    @JsonProperty("can_pin_messages")
    private final @Nullable Boolean canPinMessages;

    @JsonProperty("can_manage_topics")
    private final @Nullable Boolean canManageTopics;

    @JsonProperty("can_manage_direct_messages")
    private final @Nullable Boolean canManageDirectMessages;

    @JsonProperty("can_manage_tags")
    private final @Nullable Boolean canManageTags;

    /**
     * Creates a new {@code ChatAdministratorRights} instance.
     *
     * @param isAnonymous True, if the user's presence in the chat is hidden
     * @param canManageChat True, if the administrator can access the chat event log, get boost
     *     list, see hidden supergroup and channel members, report spam messages, ignore slow mode,
     *     and send messages to the chat without paying Telegram Stars. Implied by any other
     *     administrator privilege.
     * @param canDeleteMessages True, if the administrator can delete messages of other users
     * @param canManageVideoChats True, if the administrator can manage video chats
     * @param canRestrictMembers True, if the administrator can restrict, ban or unban chat members,
     *     or access supergroup statistics
     * @param canPromoteMembers True, if the administrator can add new administrators with a subset
     *     of their own privileges or demote administrators that they have promoted, directly or
     *     indirectly (promoted by administrators that were appointed by the user)
     * @param canChangeInfo True, if the user is allowed to change the chat title, photo and other
     *     settings
     * @param canInviteUsers True, if the user is allowed to invite new users to the chat
     * @param canPostStories True, if the administrator can post stories to the chat
     * @param canEditStories True, if the administrator can edit stories posted by other users, post
     *     stories to the chat page, pin chat stories, and access the chat's story archive
     * @param canDeleteStories True, if the administrator can delete stories posted by other users
     * @param canPostMessages True, if the administrator can post messages in the channel, approve
     *     suggested posts, or access channel statistics; for channels only
     * @param canEditMessages True, if the administrator can edit messages of other users and can
     *     pin messages; for channels only
     * @param canPinMessages True, if the user is allowed to pin messages; for groups and
     *     supergroups only
     * @param canManageTopics True, if the user is allowed to create, rename, close, and reopen
     *     forum topics; for supergroups only
     * @param canManageDirectMessages True, if the administrator can manage direct messages of the
     *     channel and decline suggested posts; for channels only
     * @param canManageTags True, if the administrator can edit the tags of regular members; for
     *     groups and supergroups only. If omitted defaults to the value of can_pin_messages.
     */
    @JsonCreator
    public ChatAdministratorRights(
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
            @JsonProperty("can_manage_tags") @Nullable Boolean canManageTags) {
        this.isAnonymous = isAnonymous;
        this.canManageChat = canManageChat;
        this.canDeleteMessages = canDeleteMessages;
        this.canManageVideoChats = canManageVideoChats;
        this.canRestrictMembers = canRestrictMembers;
        this.canPromoteMembers = canPromoteMembers;
        this.canChangeInfo = canChangeInfo;
        this.canInviteUsers = canInviteUsers;
        this.canPostStories = canPostStories;
        this.canEditStories = canEditStories;
        this.canDeleteStories = canDeleteStories;
        this.canPostMessages = canPostMessages;
        this.canEditMessages = canEditMessages;
        this.canPinMessages = canPinMessages;
        this.canManageTopics = canManageTopics;
        this.canManageDirectMessages = canManageDirectMessages;
        this.canManageTags = canManageTags;
    }

    public static ChatAdministratorRights of(boolean isAnonymous, boolean canManageChat, boolean canDeleteMessages, boolean canManageVideoChats, boolean canRestrictMembers, boolean canPromoteMembers, boolean canChangeInfo, boolean canInviteUsers, boolean canPostStories, boolean canEditStories, boolean canDeleteStories) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, null, null, null, null, null, null);
    }

    /**
     * True, if the user's presence in the chat is hidden
     */
    public boolean isAnonymous() {
        return isAnonymous;
    }

    /**
     * True, if the administrator can access the chat event log, get boost list, see hidden
     * supergroup and channel members, report spam messages, ignore slow mode, and send messages to
     * the chat without paying Telegram Stars. Implied by any other administrator privilege.
     */
    public boolean canManageChat() {
        return canManageChat;
    }

    /**
     * True, if the administrator can delete messages of other users
     */
    public boolean canDeleteMessages() {
        return canDeleteMessages;
    }

    /**
     * True, if the administrator can manage video chats
     */
    public boolean canManageVideoChats() {
        return canManageVideoChats;
    }

    /**
     * True, if the administrator can restrict, ban or unban chat members, or access supergroup
     * statistics
     */
    public boolean canRestrictMembers() {
        return canRestrictMembers;
    }

    /**
     * True, if the administrator can add new administrators with a subset of their own privileges
     * or demote administrators that they have promoted, directly or indirectly (promoted by
     * administrators that were appointed by the user)
     */
    public boolean canPromoteMembers() {
        return canPromoteMembers;
    }

    /**
     * True, if the user is allowed to change the chat title, photo and other settings
     */
    public boolean canChangeInfo() {
        return canChangeInfo;
    }

    /**
     * True, if the user is allowed to invite new users to the chat
     */
    public boolean canInviteUsers() {
        return canInviteUsers;
    }

    /**
     * True, if the administrator can post stories to the chat
     */
    public boolean canPostStories() {
        return canPostStories;
    }

    /**
     * True, if the administrator can edit stories posted by other users, post stories to the chat
     * page, pin chat stories, and access the chat's story archive
     */
    public boolean canEditStories() {
        return canEditStories;
    }

    /**
     * True, if the administrator can delete stories posted by other users
     */
    public boolean canDeleteStories() {
        return canDeleteStories;
    }

    /**
     * True, if the administrator can post messages in the channel, approve suggested posts, or
     * access channel statistics; for channels only
     */
    public @Nullable Boolean canPostMessages() {
        return canPostMessages;
    }

    /**
     * True, if the administrator can edit messages of other users and can pin messages; for
     * channels only
     */
    public @Nullable Boolean canEditMessages() {
        return canEditMessages;
    }

    /**
     * True, if the user is allowed to pin messages; for groups and supergroups only
     */
    public @Nullable Boolean canPinMessages() {
        return canPinMessages;
    }

    /**
     * True, if the user is allowed to create, rename, close, and reopen forum topics; for
     * supergroups only
     */
    public @Nullable Boolean canManageTopics() {
        return canManageTopics;
    }

    /**
     * True, if the administrator can manage direct messages of the channel and decline suggested
     * posts; for channels only
     */
    public @Nullable Boolean canManageDirectMessages() {
        return canManageDirectMessages;
    }

    /**
     * True, if the administrator can edit the tags of regular members; for groups and supergroups
     * only. If omitted defaults to the value of can_pin_messages.
     */
    public @Nullable Boolean canManageTags() {
        return canManageTags;
    }

    public ChatAdministratorRights withIsAnonymous(boolean isAnonymous) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanManageChat(boolean canManageChat) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanDeleteMessages(boolean canDeleteMessages) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanManageVideoChats(boolean canManageVideoChats) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanRestrictMembers(boolean canRestrictMembers) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanPromoteMembers(boolean canPromoteMembers) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanChangeInfo(boolean canChangeInfo) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanInviteUsers(boolean canInviteUsers) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanPostStories(boolean canPostStories) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanEditStories(boolean canEditStories) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanDeleteStories(boolean canDeleteStories) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanPostMessages(@Nullable Boolean canPostMessages) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanEditMessages(@Nullable Boolean canEditMessages) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanPinMessages(@Nullable Boolean canPinMessages) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanManageTopics(@Nullable Boolean canManageTopics) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanManageDirectMessages(@Nullable Boolean canManageDirectMessages) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public ChatAdministratorRights withCanManageTags(@Nullable Boolean canManageTags) {
        return new ChatAdministratorRights(isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatAdministratorRights)) {
            return false;
        }
        ChatAdministratorRights that = (ChatAdministratorRights) o;
        return this.isAnonymous == that.isAnonymous
                && this.canManageChat == that.canManageChat
                && this.canDeleteMessages == that.canDeleteMessages
                && this.canManageVideoChats == that.canManageVideoChats
                && this.canRestrictMembers == that.canRestrictMembers
                && this.canPromoteMembers == that.canPromoteMembers
                && this.canChangeInfo == that.canChangeInfo
                && this.canInviteUsers == that.canInviteUsers
                && this.canPostStories == that.canPostStories
                && this.canEditStories == that.canEditStories
                && this.canDeleteStories == that.canDeleteStories
                && Objects.equals(this.canPostMessages, that.canPostMessages)
                && Objects.equals(this.canEditMessages, that.canEditMessages)
                && Objects.equals(this.canPinMessages, that.canPinMessages)
                && Objects.equals(this.canManageTopics, that.canManageTopics)
                && Objects.equals(this.canManageDirectMessages, that.canManageDirectMessages)
                && Objects.equals(this.canManageTags, that.canManageTags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isAnonymous, this.canManageChat, this.canDeleteMessages, this.canManageVideoChats, this.canRestrictMembers, this.canPromoteMembers, this.canChangeInfo, this.canInviteUsers, this.canPostStories, this.canEditStories, this.canDeleteStories, this.canPostMessages, this.canEditMessages, this.canPinMessages, this.canManageTopics, this.canManageDirectMessages, this.canManageTags);
    }

    @Override
    public String toString() {
        return "ChatAdministratorRights[isAnonymous=" + this.isAnonymous
                + ", canManageChat=" + this.canManageChat
                + ", canDeleteMessages=" + this.canDeleteMessages
                + ", canManageVideoChats=" + this.canManageVideoChats
                + ", canRestrictMembers=" + this.canRestrictMembers
                + ", canPromoteMembers=" + this.canPromoteMembers
                + ", canChangeInfo=" + this.canChangeInfo
                + ", canInviteUsers=" + this.canInviteUsers
                + ", canPostStories=" + this.canPostStories
                + ", canEditStories=" + this.canEditStories
                + ", canDeleteStories=" + this.canDeleteStories
                + ", canPostMessages=" + this.canPostMessages
                + ", canEditMessages=" + this.canEditMessages
                + ", canPinMessages=" + this.canPinMessages
                + ", canManageTopics=" + this.canManageTopics
                + ", canManageDirectMessages=" + this.canManageDirectMessages
                + ", canManageTags=" + this.canManageTags
                + "]";
    }
}
