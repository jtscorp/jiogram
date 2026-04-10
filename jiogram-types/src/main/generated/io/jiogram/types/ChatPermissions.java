package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class ChatPermissions {
    @JsonProperty("can_send_messages") @Nullable private final Boolean canSendMessages;
    @JsonProperty("can_send_audios") @Nullable private final Boolean canSendAudios;
    @JsonProperty("can_send_documents") @Nullable private final Boolean canSendDocuments;
    @JsonProperty("can_send_photos") @Nullable private final Boolean canSendPhotos;
    @JsonProperty("can_send_videos") @Nullable private final Boolean canSendVideos;
    @JsonProperty("can_send_video_notes") @Nullable private final Boolean canSendVideoNotes;
    @JsonProperty("can_send_voice_notes") @Nullable private final Boolean canSendVoiceNotes;
    @JsonProperty("can_send_polls") @Nullable private final Boolean canSendPolls;
    @JsonProperty("can_send_other_messages") @Nullable private final Boolean canSendOtherMessages;
    @JsonProperty("can_add_web_page_previews") @Nullable private final Boolean canAddWebPagePreviews;
    @JsonProperty("can_edit_tag") @Nullable private final Boolean canEditTag;
    @JsonProperty("can_change_info") @Nullable private final Boolean canChangeInfo;
    @JsonProperty("can_invite_users") @Nullable private final Boolean canInviteUsers;
    @JsonProperty("can_pin_messages") @Nullable private final Boolean canPinMessages;
    @JsonProperty("can_manage_topics") @Nullable private final Boolean canManageTopics;

    @JsonCreator
    public ChatPermissions(
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
    ) {
        this.canSendMessages = canSendMessages;
        this.canSendAudios = canSendAudios;
        this.canSendDocuments = canSendDocuments;
        this.canSendPhotos = canSendPhotos;
        this.canSendVideos = canSendVideos;
        this.canSendVideoNotes = canSendVideoNotes;
        this.canSendVoiceNotes = canSendVoiceNotes;
        this.canSendPolls = canSendPolls;
        this.canSendOtherMessages = canSendOtherMessages;
        this.canAddWebPagePreviews = canAddWebPagePreviews;
        this.canEditTag = canEditTag;
        this.canChangeInfo = canChangeInfo;
        this.canInviteUsers = canInviteUsers;
        this.canPinMessages = canPinMessages;
        this.canManageTopics = canManageTopics;
    }

    public Boolean canSendMessages() {
        return this.canSendMessages;
    }

    public Boolean canSendAudios() {
        return this.canSendAudios;
    }

    public Boolean canSendDocuments() {
        return this.canSendDocuments;
    }

    public Boolean canSendPhotos() {
        return this.canSendPhotos;
    }

    public Boolean canSendVideos() {
        return this.canSendVideos;
    }

    public Boolean canSendVideoNotes() {
        return this.canSendVideoNotes;
    }

    public Boolean canSendVoiceNotes() {
        return this.canSendVoiceNotes;
    }

    public Boolean canSendPolls() {
        return this.canSendPolls;
    }

    public Boolean canSendOtherMessages() {
        return this.canSendOtherMessages;
    }

    public Boolean canAddWebPagePreviews() {
        return this.canAddWebPagePreviews;
    }

    public Boolean canEditTag() {
        return this.canEditTag;
    }

    public Boolean canChangeInfo() {
        return this.canChangeInfo;
    }

    public Boolean canInviteUsers() {
        return this.canInviteUsers;
    }

    public Boolean canPinMessages() {
        return this.canPinMessages;
    }

    public Boolean canManageTopics() {
        return this.canManageTopics;
    }
}
