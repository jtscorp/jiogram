package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record ChatAdministratorRights(
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
    @JsonProperty("can_manage_tags") @Nullable Boolean canManageTags
) {}
