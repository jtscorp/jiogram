package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class ChatMemberAdministrator implements ChatMember {
    @JsonProperty("status") private final String status;
    @JsonProperty("user") private final User user;
    @JsonProperty("can_be_edited") private final boolean canBeEdited;
    @JsonProperty("is_anonymous") private final boolean isAnonymous;
    @JsonProperty("can_manage_chat") private final boolean canManageChat;
    @JsonProperty("can_delete_messages") private final boolean canDeleteMessages;
    @JsonProperty("can_manage_video_chats") private final boolean canManageVideoChats;
    @JsonProperty("can_restrict_members") private final boolean canRestrictMembers;
    @JsonProperty("can_promote_members") private final boolean canPromoteMembers;
    @JsonProperty("can_change_info") private final boolean canChangeInfo;
    @JsonProperty("can_invite_users") private final boolean canInviteUsers;
    @JsonProperty("can_post_stories") private final boolean canPostStories;
    @JsonProperty("can_edit_stories") private final boolean canEditStories;
    @JsonProperty("can_delete_stories") private final boolean canDeleteStories;
    @JsonProperty("can_post_messages") @Nullable private final Boolean canPostMessages;
    @JsonProperty("can_edit_messages") @Nullable private final Boolean canEditMessages;
    @JsonProperty("can_pin_messages") @Nullable private final Boolean canPinMessages;
    @JsonProperty("can_manage_topics") @Nullable private final Boolean canManageTopics;
    @JsonProperty("can_manage_direct_messages") @Nullable private final Boolean canManageDirectMessages;
    @JsonProperty("can_manage_tags") @Nullable private final Boolean canManageTags;
    @JsonProperty("custom_title") @Nullable private final String customTitle;

    @JsonCreator
    public ChatMemberAdministrator(
            @JsonProperty("status") String status,
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
    ) {
        this.status = status;
        this.user = user;
        this.canBeEdited = canBeEdited;
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
        this.customTitle = customTitle;
    }

    public String status() {
        return this.status;
    }

    public User user() {
        return this.user;
    }

    public boolean canBeEdited() {
        return this.canBeEdited;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean canManageChat() {
        return this.canManageChat;
    }

    public boolean canDeleteMessages() {
        return this.canDeleteMessages;
    }

    public boolean canManageVideoChats() {
        return this.canManageVideoChats;
    }

    public boolean canRestrictMembers() {
        return this.canRestrictMembers;
    }

    public boolean canPromoteMembers() {
        return this.canPromoteMembers;
    }

    public boolean canChangeInfo() {
        return this.canChangeInfo;
    }

    public boolean canInviteUsers() {
        return this.canInviteUsers;
    }

    public boolean canPostStories() {
        return this.canPostStories;
    }

    public boolean canEditStories() {
        return this.canEditStories;
    }

    public boolean canDeleteStories() {
        return this.canDeleteStories;
    }

    public Boolean canPostMessages() {
        return this.canPostMessages;
    }

    public Boolean canEditMessages() {
        return this.canEditMessages;
    }

    public Boolean canPinMessages() {
        return this.canPinMessages;
    }

    public Boolean canManageTopics() {
        return this.canManageTopics;
    }

    public Boolean canManageDirectMessages() {
        return this.canManageDirectMessages;
    }

    public Boolean canManageTags() {
        return this.canManageTags;
    }

    public String customTitle() {
        return this.customTitle;
    }
}
