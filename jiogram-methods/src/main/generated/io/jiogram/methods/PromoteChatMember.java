package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to promote or demote a user in a supergroup or a channel. The bot must be an
 * administrator in the chat for this to work and must have the appropriate administrator rights.
 * Pass False for all boolean parameters to demote a user. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#promotechatmember">promoteChatMember in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PromoteChatMember implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("is_anonymous")
    private final @Nullable Boolean isAnonymous;

    @JsonProperty("can_manage_chat")
    private final @Nullable Boolean canManageChat;

    @JsonProperty("can_delete_messages")
    private final @Nullable Boolean canDeleteMessages;

    @JsonProperty("can_manage_video_chats")
    private final @Nullable Boolean canManageVideoChats;

    @JsonProperty("can_restrict_members")
    private final @Nullable Boolean canRestrictMembers;

    @JsonProperty("can_promote_members")
    private final @Nullable Boolean canPromoteMembers;

    @JsonProperty("can_change_info")
    private final @Nullable Boolean canChangeInfo;

    @JsonProperty("can_invite_users")
    private final @Nullable Boolean canInviteUsers;

    @JsonProperty("can_post_stories")
    private final @Nullable Boolean canPostStories;

    @JsonProperty("can_edit_stories")
    private final @Nullable Boolean canEditStories;

    @JsonProperty("can_delete_stories")
    private final @Nullable Boolean canDeleteStories;

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
     * Creates a new {@code PromoteChatMember} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param userId Unique identifier of the target user
     * @param isAnonymous Pass True if the administrator's presence in the chat is hidden
     * @param canManageChat Pass True if the administrator can access the chat event log, get boost
     *     list, see hidden supergroup and channel members, report spam messages, ignore slow mode,
     *     and send messages to the chat without paying Telegram Stars. Implied by any other
     *     administrator privilege.
     * @param canDeleteMessages Pass True if the administrator can delete messages of other users
     * @param canManageVideoChats Pass True if the administrator can manage video chats
     * @param canRestrictMembers Pass True if the administrator can restrict, ban or unban chat
     *     members, or access supergroup statistics. For backward compatibility, defaults to True
     *     for promotions of channel administrators
     * @param canPromoteMembers Pass True if the administrator can add new administrators with a
     *     subset of their own privileges or demote administrators that they have promoted, directly
     *     or indirectly (promoted by administrators that were appointed by him)
     * @param canChangeInfo Pass True if the administrator can change chat title, photo and other
     *     settings
     * @param canInviteUsers Pass True if the administrator can invite new users to the chat
     * @param canPostStories Pass True if the administrator can post stories to the chat
     * @param canEditStories Pass True if the administrator can edit stories posted by other users,
     *     post stories to the chat page, pin chat stories, and access the chat's story archive
     * @param canDeleteStories Pass True if the administrator can delete stories posted by other
     *     users
     * @param canPostMessages Pass True if the administrator can post messages in the channel,
     *     approve suggested posts, or access channel statistics; for channels only
     * @param canEditMessages Pass True if the administrator can edit messages of other users and
     *     can pin messages; for channels only
     * @param canPinMessages Pass True if the administrator can pin messages; for supergroups only
     * @param canManageTopics Pass True if the user is allowed to create, rename, close, and reopen
     *     forum topics; for supergroups only
     * @param canManageDirectMessages Pass True if the administrator can manage direct messages
     *     within the channel and decline suggested posts; for channels only
     * @param canManageTags Pass True if the administrator can edit the tags of regular members; for
     *     groups and supergroups only
     */
    @JsonCreator
    public PromoteChatMember(
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
            @JsonProperty("can_manage_tags") @Nullable Boolean canManageTags) {
        this.chatId = chatId;
        this.userId = userId;
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

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
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
     * Pass True if the administrator's presence in the chat is hidden
     */
    public @Nullable Boolean isAnonymous() {
        return isAnonymous;
    }

    /**
     * Pass True if the administrator can access the chat event log, get boost list, see hidden
     * supergroup and channel members, report spam messages, ignore slow mode, and send messages to
     * the chat without paying Telegram Stars. Implied by any other administrator privilege.
     */
    public @Nullable Boolean canManageChat() {
        return canManageChat;
    }

    /**
     * Pass True if the administrator can delete messages of other users
     */
    public @Nullable Boolean canDeleteMessages() {
        return canDeleteMessages;
    }

    /**
     * Pass True if the administrator can manage video chats
     */
    public @Nullable Boolean canManageVideoChats() {
        return canManageVideoChats;
    }

    /**
     * Pass True if the administrator can restrict, ban or unban chat members, or access supergroup
     * statistics. For backward compatibility, defaults to True for promotions of channel
     * administrators
     */
    public @Nullable Boolean canRestrictMembers() {
        return canRestrictMembers;
    }

    /**
     * Pass True if the administrator can add new administrators with a subset of their own
     * privileges or demote administrators that they have promoted, directly or indirectly (promoted
     * by administrators that were appointed by him)
     */
    public @Nullable Boolean canPromoteMembers() {
        return canPromoteMembers;
    }

    /**
     * Pass True if the administrator can change chat title, photo and other settings
     */
    public @Nullable Boolean canChangeInfo() {
        return canChangeInfo;
    }

    /**
     * Pass True if the administrator can invite new users to the chat
     */
    public @Nullable Boolean canInviteUsers() {
        return canInviteUsers;
    }

    /**
     * Pass True if the administrator can post stories to the chat
     */
    public @Nullable Boolean canPostStories() {
        return canPostStories;
    }

    /**
     * Pass True if the administrator can edit stories posted by other users, post stories to the
     * chat page, pin chat stories, and access the chat's story archive
     */
    public @Nullable Boolean canEditStories() {
        return canEditStories;
    }

    /**
     * Pass True if the administrator can delete stories posted by other users
     */
    public @Nullable Boolean canDeleteStories() {
        return canDeleteStories;
    }

    /**
     * Pass True if the administrator can post messages in the channel, approve suggested posts, or
     * access channel statistics; for channels only
     */
    public @Nullable Boolean canPostMessages() {
        return canPostMessages;
    }

    /**
     * Pass True if the administrator can edit messages of other users and can pin messages; for
     * channels only
     */
    public @Nullable Boolean canEditMessages() {
        return canEditMessages;
    }

    /**
     * Pass True if the administrator can pin messages; for supergroups only
     */
    public @Nullable Boolean canPinMessages() {
        return canPinMessages;
    }

    /**
     * Pass True if the user is allowed to create, rename, close, and reopen forum topics; for
     * supergroups only
     */
    public @Nullable Boolean canManageTopics() {
        return canManageTopics;
    }

    /**
     * Pass True if the administrator can manage direct messages within the channel and decline
     * suggested posts; for channels only
     */
    public @Nullable Boolean canManageDirectMessages() {
        return canManageDirectMessages;
    }

    /**
     * Pass True if the administrator can edit the tags of regular members; for groups and
     * supergroups only
     */
    public @Nullable Boolean canManageTags() {
        return canManageTags;
    }

    public PromoteChatMember withChatId(ChatId chatId) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withUserId(long userId) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withIsAnonymous(@Nullable Boolean isAnonymous) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanManageChat(@Nullable Boolean canManageChat) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanDeleteMessages(@Nullable Boolean canDeleteMessages) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanManageVideoChats(@Nullable Boolean canManageVideoChats) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanRestrictMembers(@Nullable Boolean canRestrictMembers) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanPromoteMembers(@Nullable Boolean canPromoteMembers) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanChangeInfo(@Nullable Boolean canChangeInfo) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanInviteUsers(@Nullable Boolean canInviteUsers) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanPostStories(@Nullable Boolean canPostStories) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanEditStories(@Nullable Boolean canEditStories) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanDeleteStories(@Nullable Boolean canDeleteStories) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanPostMessages(@Nullable Boolean canPostMessages) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanEditMessages(@Nullable Boolean canEditMessages) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanPinMessages(@Nullable Boolean canPinMessages) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanManageTopics(@Nullable Boolean canManageTopics) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanManageDirectMessages(@Nullable Boolean canManageDirectMessages) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    public PromoteChatMember withCanManageTags(@Nullable Boolean canManageTags) {
        return new PromoteChatMember(chatId, userId, isAnonymous, canManageChat, canDeleteMessages, canManageVideoChats, canRestrictMembers, canPromoteMembers, canChangeInfo, canInviteUsers, canPostStories, canEditStories, canDeleteStories, canPostMessages, canEditMessages, canPinMessages, canManageTopics, canManageDirectMessages, canManageTags);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PromoteChatMember)) {
            return false;
        }
        PromoteChatMember that = (PromoteChatMember) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.userId == that.userId
                && Objects.equals(this.isAnonymous, that.isAnonymous)
                && Objects.equals(this.canManageChat, that.canManageChat)
                && Objects.equals(this.canDeleteMessages, that.canDeleteMessages)
                && Objects.equals(this.canManageVideoChats, that.canManageVideoChats)
                && Objects.equals(this.canRestrictMembers, that.canRestrictMembers)
                && Objects.equals(this.canPromoteMembers, that.canPromoteMembers)
                && Objects.equals(this.canChangeInfo, that.canChangeInfo)
                && Objects.equals(this.canInviteUsers, that.canInviteUsers)
                && Objects.equals(this.canPostStories, that.canPostStories)
                && Objects.equals(this.canEditStories, that.canEditStories)
                && Objects.equals(this.canDeleteStories, that.canDeleteStories)
                && Objects.equals(this.canPostMessages, that.canPostMessages)
                && Objects.equals(this.canEditMessages, that.canEditMessages)
                && Objects.equals(this.canPinMessages, that.canPinMessages)
                && Objects.equals(this.canManageTopics, that.canManageTopics)
                && Objects.equals(this.canManageDirectMessages, that.canManageDirectMessages)
                && Objects.equals(this.canManageTags, that.canManageTags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.userId, this.isAnonymous, this.canManageChat, this.canDeleteMessages, this.canManageVideoChats, this.canRestrictMembers, this.canPromoteMembers, this.canChangeInfo, this.canInviteUsers, this.canPostStories, this.canEditStories, this.canDeleteStories, this.canPostMessages, this.canEditMessages, this.canPinMessages, this.canManageTopics, this.canManageDirectMessages, this.canManageTags);
    }

    @Override
    public String toString() {
        return "PromoteChatMember[chatId=" + this.chatId
                + ", userId=" + this.userId
                + ", isAnonymous=" + this.isAnonymous
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
