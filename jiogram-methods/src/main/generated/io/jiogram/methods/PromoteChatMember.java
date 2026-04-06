package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

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
