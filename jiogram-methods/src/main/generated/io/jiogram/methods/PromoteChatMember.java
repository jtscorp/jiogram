package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class PromoteChatMember implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("is_anonymous") @Nullable private final Boolean isAnonymous;
    @JsonProperty("can_manage_chat") @Nullable private final Boolean canManageChat;
    @JsonProperty("can_delete_messages") @Nullable private final Boolean canDeleteMessages;
    @JsonProperty("can_manage_video_chats") @Nullable private final Boolean canManageVideoChats;
    @JsonProperty("can_restrict_members") @Nullable private final Boolean canRestrictMembers;
    @JsonProperty("can_promote_members") @Nullable private final Boolean canPromoteMembers;
    @JsonProperty("can_change_info") @Nullable private final Boolean canChangeInfo;
    @JsonProperty("can_invite_users") @Nullable private final Boolean canInviteUsers;
    @JsonProperty("can_post_stories") @Nullable private final Boolean canPostStories;
    @JsonProperty("can_edit_stories") @Nullable private final Boolean canEditStories;
    @JsonProperty("can_delete_stories") @Nullable private final Boolean canDeleteStories;
    @JsonProperty("can_post_messages") @Nullable private final Boolean canPostMessages;
    @JsonProperty("can_edit_messages") @Nullable private final Boolean canEditMessages;
    @JsonProperty("can_pin_messages") @Nullable private final Boolean canPinMessages;
    @JsonProperty("can_manage_topics") @Nullable private final Boolean canManageTopics;
    @JsonProperty("can_manage_direct_messages") @Nullable private final Boolean canManageDirectMessages;
    @JsonProperty("can_manage_tags") @Nullable private final Boolean canManageTags;

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
            @JsonProperty("can_manage_tags") @Nullable Boolean canManageTags
    ) {
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

    public ChatId chatId() {
        return this.chatId;
    }

    public long userId() {
        return this.userId;
    }

    public Boolean isAnonymous() {
        return this.isAnonymous;
    }

    public Boolean canManageChat() {
        return this.canManageChat;
    }

    public Boolean canDeleteMessages() {
        return this.canDeleteMessages;
    }

    public Boolean canManageVideoChats() {
        return this.canManageVideoChats;
    }

    public Boolean canRestrictMembers() {
        return this.canRestrictMembers;
    }

    public Boolean canPromoteMembers() {
        return this.canPromoteMembers;
    }

    public Boolean canChangeInfo() {
        return this.canChangeInfo;
    }

    public Boolean canInviteUsers() {
        return this.canInviteUsers;
    }

    public Boolean canPostStories() {
        return this.canPostStories;
    }

    public Boolean canEditStories() {
        return this.canEditStories;
    }

    public Boolean canDeleteStories() {
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
