package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class ChatMemberRestricted implements ChatMember {
    @JsonProperty("status") private final String status;
    @JsonProperty("tag") @Nullable private final String tag;
    @JsonProperty("user") private final User user;
    @JsonProperty("is_member") private final boolean isMember;
    @JsonProperty("can_send_messages") private final boolean canSendMessages;
    @JsonProperty("can_send_audios") private final boolean canSendAudios;
    @JsonProperty("can_send_documents") private final boolean canSendDocuments;
    @JsonProperty("can_send_photos") private final boolean canSendPhotos;
    @JsonProperty("can_send_videos") private final boolean canSendVideos;
    @JsonProperty("can_send_video_notes") private final boolean canSendVideoNotes;
    @JsonProperty("can_send_voice_notes") private final boolean canSendVoiceNotes;
    @JsonProperty("can_send_polls") private final boolean canSendPolls;
    @JsonProperty("can_send_other_messages") private final boolean canSendOtherMessages;
    @JsonProperty("can_add_web_page_previews") private final boolean canAddWebPagePreviews;
    @JsonProperty("can_edit_tag") private final boolean canEditTag;
    @JsonProperty("can_change_info") private final boolean canChangeInfo;
    @JsonProperty("can_invite_users") private final boolean canInviteUsers;
    @JsonProperty("can_pin_messages") private final boolean canPinMessages;
    @JsonProperty("can_manage_topics") private final boolean canManageTopics;
    @JsonProperty("until_date") private final long untilDate;

    @JsonCreator
    public ChatMemberRestricted(
            @JsonProperty("status") String status,
            @JsonProperty("tag") @Nullable String tag,
            @JsonProperty("user") User user,
            @JsonProperty("is_member") boolean isMember,
            @JsonProperty("can_send_messages") boolean canSendMessages,
            @JsonProperty("can_send_audios") boolean canSendAudios,
            @JsonProperty("can_send_documents") boolean canSendDocuments,
            @JsonProperty("can_send_photos") boolean canSendPhotos,
            @JsonProperty("can_send_videos") boolean canSendVideos,
            @JsonProperty("can_send_video_notes") boolean canSendVideoNotes,
            @JsonProperty("can_send_voice_notes") boolean canSendVoiceNotes,
            @JsonProperty("can_send_polls") boolean canSendPolls,
            @JsonProperty("can_send_other_messages") boolean canSendOtherMessages,
            @JsonProperty("can_add_web_page_previews") boolean canAddWebPagePreviews,
            @JsonProperty("can_edit_tag") boolean canEditTag,
            @JsonProperty("can_change_info") boolean canChangeInfo,
            @JsonProperty("can_invite_users") boolean canInviteUsers,
            @JsonProperty("can_pin_messages") boolean canPinMessages,
            @JsonProperty("can_manage_topics") boolean canManageTopics,
            @JsonProperty("until_date") long untilDate
    ) {
        this.status = status;
        this.tag = tag;
        this.user = user;
        this.isMember = isMember;
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
        this.untilDate = untilDate;
    }

    public String status() {
        return this.status;
    }

    public String tag() {
        return this.tag;
    }

    public User user() {
        return this.user;
    }

    public boolean isMember() {
        return this.isMember;
    }

    public boolean canSendMessages() {
        return this.canSendMessages;
    }

    public boolean canSendAudios() {
        return this.canSendAudios;
    }

    public boolean canSendDocuments() {
        return this.canSendDocuments;
    }

    public boolean canSendPhotos() {
        return this.canSendPhotos;
    }

    public boolean canSendVideos() {
        return this.canSendVideos;
    }

    public boolean canSendVideoNotes() {
        return this.canSendVideoNotes;
    }

    public boolean canSendVoiceNotes() {
        return this.canSendVoiceNotes;
    }

    public boolean canSendPolls() {
        return this.canSendPolls;
    }

    public boolean canSendOtherMessages() {
        return this.canSendOtherMessages;
    }

    public boolean canAddWebPagePreviews() {
        return this.canAddWebPagePreviews;
    }

    public boolean canEditTag() {
        return this.canEditTag;
    }

    public boolean canChangeInfo() {
        return this.canChangeInfo;
    }

    public boolean canInviteUsers() {
        return this.canInviteUsers;
    }

    public boolean canPinMessages() {
        return this.canPinMessages;
    }

    public boolean canManageTopics() {
        return this.canManageTopics;
    }

    public long untilDate() {
        return this.untilDate;
    }
}
