package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record ChatPermissions(
    @JsonProperty("can_send_messages") @Nullable Boolean canSendMessages,
    @JsonProperty("can_send_audios") @Nullable Boolean canSendAudios,
    @JsonProperty("can_send_documents") @Nullable Boolean canSendDocuments,
    @JsonProperty("can_send_photos") @Nullable Boolean canSendPhotos,
    @JsonProperty("can_send_videos") @Nullable Boolean canSendVideos,
    @JsonProperty("can_send_video_notes") @Nullable Boolean canSendVideoNotes,
    @JsonProperty("can_send_voice_notes") @Nullable Boolean canSendVoiceNotes,
    @JsonProperty("can_send_polls") @Nullable Boolean canSendPolls,
    @JsonProperty("can_send_other_messages") @Nullable Boolean canSendOtherMessages,
    @JsonProperty("can_add_web_page_previews") @Nullable Boolean canAddWebPagePreviews,
    @JsonProperty("can_edit_tag") @Nullable Boolean canEditTag,
    @JsonProperty("can_change_info") @Nullable Boolean canChangeInfo,
    @JsonProperty("can_invite_users") @Nullable Boolean canInviteUsers,
    @JsonProperty("can_pin_messages") @Nullable Boolean canPinMessages,
    @JsonProperty("can_manage_topics") @Nullable Boolean canManageTopics
) {}
