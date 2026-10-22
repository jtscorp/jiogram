package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes actions that a non-administrator user is allowed to take in a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatpermissions">ChatPermissions in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatPermissions {

    @JsonProperty("can_send_messages")
    private final @Nullable Boolean canSendMessages;

    @JsonProperty("can_send_audios")
    private final @Nullable Boolean canSendAudios;

    @JsonProperty("can_send_documents")
    private final @Nullable Boolean canSendDocuments;

    @JsonProperty("can_send_photos")
    private final @Nullable Boolean canSendPhotos;

    @JsonProperty("can_send_videos")
    private final @Nullable Boolean canSendVideos;

    @JsonProperty("can_send_video_notes")
    private final @Nullable Boolean canSendVideoNotes;

    @JsonProperty("can_send_voice_notes")
    private final @Nullable Boolean canSendVoiceNotes;

    @JsonProperty("can_send_polls")
    private final @Nullable Boolean canSendPolls;

    @JsonProperty("can_send_other_messages")
    private final @Nullable Boolean canSendOtherMessages;

    @JsonProperty("can_add_web_page_previews")
    private final @Nullable Boolean canAddWebPagePreviews;

    @JsonProperty("can_edit_tag")
    private final @Nullable Boolean canEditTag;

    @JsonProperty("can_change_info")
    private final @Nullable Boolean canChangeInfo;

    @JsonProperty("can_invite_users")
    private final @Nullable Boolean canInviteUsers;

    @JsonProperty("can_pin_messages")
    private final @Nullable Boolean canPinMessages;

    @JsonProperty("can_manage_topics")
    private final @Nullable Boolean canManageTopics;

    /**
     * Creates a new {@code ChatPermissions} instance.
     *
     * @param canSendMessages True, if the user is allowed to send text messages, contacts,
     *     giveaways, giveaway winners, invoices, locations and venues
     * @param canSendAudios True, if the user is allowed to send audios
     * @param canSendDocuments True, if the user is allowed to send documents
     * @param canSendPhotos True, if the user is allowed to send photos
     * @param canSendVideos True, if the user is allowed to send videos
     * @param canSendVideoNotes True, if the user is allowed to send video notes
     * @param canSendVoiceNotes True, if the user is allowed to send voice notes
     * @param canSendPolls True, if the user is allowed to send polls and checklists
     * @param canSendOtherMessages True, if the user is allowed to send animations, games, stickers
     *     and use inline bots
     * @param canAddWebPagePreviews True, if the user is allowed to add web page previews to their
     *     messages
     * @param canEditTag True, if the user is allowed to edit their own tag
     * @param canChangeInfo True, if the user is allowed to change the chat title, photo and other
     *     settings. Ignored in public supergroups
     * @param canInviteUsers True, if the user is allowed to invite new users to the chat
     * @param canPinMessages True, if the user is allowed to pin messages. Ignored in public
     *     supergroups
     * @param canManageTopics True, if the user is allowed to create forum topics. If omitted
     *     defaults to the value of can_pin_messages
     */
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
            @JsonProperty("can_manage_topics") @Nullable Boolean canManageTopics) {
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

    public static ChatPermissions of() {
        return new ChatPermissions(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * True, if the user is allowed to send text messages, contacts, giveaways, giveaway winners,
     * invoices, locations and venues
     */
    public @Nullable Boolean canSendMessages() {
        return canSendMessages;
    }

    /**
     * True, if the user is allowed to send audios
     */
    public @Nullable Boolean canSendAudios() {
        return canSendAudios;
    }

    /**
     * True, if the user is allowed to send documents
     */
    public @Nullable Boolean canSendDocuments() {
        return canSendDocuments;
    }

    /**
     * True, if the user is allowed to send photos
     */
    public @Nullable Boolean canSendPhotos() {
        return canSendPhotos;
    }

    /**
     * True, if the user is allowed to send videos
     */
    public @Nullable Boolean canSendVideos() {
        return canSendVideos;
    }

    /**
     * True, if the user is allowed to send video notes
     */
    public @Nullable Boolean canSendVideoNotes() {
        return canSendVideoNotes;
    }

    /**
     * True, if the user is allowed to send voice notes
     */
    public @Nullable Boolean canSendVoiceNotes() {
        return canSendVoiceNotes;
    }

    /**
     * True, if the user is allowed to send polls and checklists
     */
    public @Nullable Boolean canSendPolls() {
        return canSendPolls;
    }

    /**
     * True, if the user is allowed to send animations, games, stickers and use inline bots
     */
    public @Nullable Boolean canSendOtherMessages() {
        return canSendOtherMessages;
    }

    /**
     * True, if the user is allowed to add web page previews to their messages
     */
    public @Nullable Boolean canAddWebPagePreviews() {
        return canAddWebPagePreviews;
    }

    /**
     * True, if the user is allowed to edit their own tag
     */
    public @Nullable Boolean canEditTag() {
        return canEditTag;
    }

    /**
     * True, if the user is allowed to change the chat title, photo and other settings. Ignored in
     * public supergroups
     */
    public @Nullable Boolean canChangeInfo() {
        return canChangeInfo;
    }

    /**
     * True, if the user is allowed to invite new users to the chat
     */
    public @Nullable Boolean canInviteUsers() {
        return canInviteUsers;
    }

    /**
     * True, if the user is allowed to pin messages. Ignored in public supergroups
     */
    public @Nullable Boolean canPinMessages() {
        return canPinMessages;
    }

    /**
     * True, if the user is allowed to create forum topics. If omitted defaults to the value of
     * can_pin_messages
     */
    public @Nullable Boolean canManageTopics() {
        return canManageTopics;
    }

    public ChatPermissions withCanSendMessages(@Nullable Boolean canSendMessages) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanSendAudios(@Nullable Boolean canSendAudios) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanSendDocuments(@Nullable Boolean canSendDocuments) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanSendPhotos(@Nullable Boolean canSendPhotos) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanSendVideos(@Nullable Boolean canSendVideos) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanSendVideoNotes(@Nullable Boolean canSendVideoNotes) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanSendVoiceNotes(@Nullable Boolean canSendVoiceNotes) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanSendPolls(@Nullable Boolean canSendPolls) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanSendOtherMessages(@Nullable Boolean canSendOtherMessages) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanAddWebPagePreviews(@Nullable Boolean canAddWebPagePreviews) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanEditTag(@Nullable Boolean canEditTag) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanChangeInfo(@Nullable Boolean canChangeInfo) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanInviteUsers(@Nullable Boolean canInviteUsers) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanPinMessages(@Nullable Boolean canPinMessages) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    public ChatPermissions withCanManageTopics(@Nullable Boolean canManageTopics) {
        return new ChatPermissions(canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatPermissions)) {
            return false;
        }
        ChatPermissions that = (ChatPermissions) o;
        return Objects.equals(this.canSendMessages, that.canSendMessages)
                && Objects.equals(this.canSendAudios, that.canSendAudios)
                && Objects.equals(this.canSendDocuments, that.canSendDocuments)
                && Objects.equals(this.canSendPhotos, that.canSendPhotos)
                && Objects.equals(this.canSendVideos, that.canSendVideos)
                && Objects.equals(this.canSendVideoNotes, that.canSendVideoNotes)
                && Objects.equals(this.canSendVoiceNotes, that.canSendVoiceNotes)
                && Objects.equals(this.canSendPolls, that.canSendPolls)
                && Objects.equals(this.canSendOtherMessages, that.canSendOtherMessages)
                && Objects.equals(this.canAddWebPagePreviews, that.canAddWebPagePreviews)
                && Objects.equals(this.canEditTag, that.canEditTag)
                && Objects.equals(this.canChangeInfo, that.canChangeInfo)
                && Objects.equals(this.canInviteUsers, that.canInviteUsers)
                && Objects.equals(this.canPinMessages, that.canPinMessages)
                && Objects.equals(this.canManageTopics, that.canManageTopics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.canSendMessages, this.canSendAudios, this.canSendDocuments, this.canSendPhotos, this.canSendVideos, this.canSendVideoNotes, this.canSendVoiceNotes, this.canSendPolls, this.canSendOtherMessages, this.canAddWebPagePreviews, this.canEditTag, this.canChangeInfo, this.canInviteUsers, this.canPinMessages, this.canManageTopics);
    }

    @Override
    public String toString() {
        return "ChatPermissions[canSendMessages=" + this.canSendMessages
                + ", canSendAudios=" + this.canSendAudios
                + ", canSendDocuments=" + this.canSendDocuments
                + ", canSendPhotos=" + this.canSendPhotos
                + ", canSendVideos=" + this.canSendVideos
                + ", canSendVideoNotes=" + this.canSendVideoNotes
                + ", canSendVoiceNotes=" + this.canSendVoiceNotes
                + ", canSendPolls=" + this.canSendPolls
                + ", canSendOtherMessages=" + this.canSendOtherMessages
                + ", canAddWebPagePreviews=" + this.canAddWebPagePreviews
                + ", canEditTag=" + this.canEditTag
                + ", canChangeInfo=" + this.canChangeInfo
                + ", canInviteUsers=" + this.canInviteUsers
                + ", canPinMessages=" + this.canPinMessages
                + ", canManageTopics=" + this.canManageTopics
                + "]";
    }
}
