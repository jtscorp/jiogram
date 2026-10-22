package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a chat member that is under certain restrictions in the chat. Supergroups only.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberrestricted">ChatMemberRestricted in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatMemberRestricted implements ChatMember {

    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private final ChatMemberType status;

    @JsonProperty("tag")
    private final @Nullable String tag;

    @JsonProperty("user")
    private final User user;

    @JsonProperty("is_member")
    private final boolean isMember;

    @JsonProperty("can_send_messages")
    private final boolean canSendMessages;

    @JsonProperty("can_send_audios")
    private final boolean canSendAudios;

    @JsonProperty("can_send_documents")
    private final boolean canSendDocuments;

    @JsonProperty("can_send_photos")
    private final boolean canSendPhotos;

    @JsonProperty("can_send_videos")
    private final boolean canSendVideos;

    @JsonProperty("can_send_video_notes")
    private final boolean canSendVideoNotes;

    @JsonProperty("can_send_voice_notes")
    private final boolean canSendVoiceNotes;

    @JsonProperty("can_send_polls")
    private final boolean canSendPolls;

    @JsonProperty("can_send_other_messages")
    private final boolean canSendOtherMessages;

    @JsonProperty("can_add_web_page_previews")
    private final boolean canAddWebPagePreviews;

    @JsonProperty("can_edit_tag")
    private final boolean canEditTag;

    @JsonProperty("can_change_info")
    private final boolean canChangeInfo;

    @JsonProperty("can_invite_users")
    private final boolean canInviteUsers;

    @JsonProperty("can_pin_messages")
    private final boolean canPinMessages;

    @JsonProperty("can_manage_topics")
    private final boolean canManageTopics;

    @JsonProperty("until_date")
    private final long untilDate;

    /**
     * Creates a new {@code ChatMemberRestricted} instance.
     *
     * @param status The member's status in the chat, always 'restricted'
     * @param tag Tag of the member
     * @param user Information about the user
     * @param isMember True, if the user is a member of the chat at the moment of the request
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
     *     settings
     * @param canInviteUsers True, if the user is allowed to invite new users to the chat
     * @param canPinMessages True, if the user is allowed to pin messages
     * @param canManageTopics True, if the user is allowed to create forum topics
     * @param untilDate Date when restrictions will be lifted for this user; Unix time. If 0, then
     *     the user is restricted forever
     */
    @JsonCreator
    public ChatMemberRestricted(
            @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
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
            @JsonProperty("until_date") long untilDate) {
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

    public static ChatMemberRestricted of(User user, boolean isMember, boolean canSendMessages, boolean canSendAudios, boolean canSendDocuments, boolean canSendPhotos, boolean canSendVideos, boolean canSendVideoNotes, boolean canSendVoiceNotes, boolean canSendPolls, boolean canSendOtherMessages, boolean canAddWebPagePreviews, boolean canEditTag, boolean canChangeInfo, boolean canInviteUsers, boolean canPinMessages, boolean canManageTopics, long untilDate) {
        return new ChatMemberRestricted(ChatMemberType.RESTRICTED, null, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    /**
     * The member's status in the chat, always 'restricted'
     */
    public ChatMemberType status() {
        return status;
    }

    /**
     * Tag of the member
     */
    public @Nullable String tag() {
        return tag;
    }

    /**
     * Information about the user
     */
    public User user() {
        return user;
    }

    /**
     * True, if the user is a member of the chat at the moment of the request
     */
    public boolean isMember() {
        return isMember;
    }

    /**
     * True, if the user is allowed to send text messages, contacts, giveaways, giveaway winners,
     * invoices, locations and venues
     */
    public boolean canSendMessages() {
        return canSendMessages;
    }

    /**
     * True, if the user is allowed to send audios
     */
    public boolean canSendAudios() {
        return canSendAudios;
    }

    /**
     * True, if the user is allowed to send documents
     */
    public boolean canSendDocuments() {
        return canSendDocuments;
    }

    /**
     * True, if the user is allowed to send photos
     */
    public boolean canSendPhotos() {
        return canSendPhotos;
    }

    /**
     * True, if the user is allowed to send videos
     */
    public boolean canSendVideos() {
        return canSendVideos;
    }

    /**
     * True, if the user is allowed to send video notes
     */
    public boolean canSendVideoNotes() {
        return canSendVideoNotes;
    }

    /**
     * True, if the user is allowed to send voice notes
     */
    public boolean canSendVoiceNotes() {
        return canSendVoiceNotes;
    }

    /**
     * True, if the user is allowed to send polls and checklists
     */
    public boolean canSendPolls() {
        return canSendPolls;
    }

    /**
     * True, if the user is allowed to send animations, games, stickers and use inline bots
     */
    public boolean canSendOtherMessages() {
        return canSendOtherMessages;
    }

    /**
     * True, if the user is allowed to add web page previews to their messages
     */
    public boolean canAddWebPagePreviews() {
        return canAddWebPagePreviews;
    }

    /**
     * True, if the user is allowed to edit their own tag
     */
    public boolean canEditTag() {
        return canEditTag;
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
     * True, if the user is allowed to pin messages
     */
    public boolean canPinMessages() {
        return canPinMessages;
    }

    /**
     * True, if the user is allowed to create forum topics
     */
    public boolean canManageTopics() {
        return canManageTopics;
    }

    /**
     * Date when restrictions will be lifted for this user; Unix time. If 0, then the user is
     * restricted forever
     */
    public long untilDate() {
        return untilDate;
    }

    public ChatMemberRestricted withTag(@Nullable String tag) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withUser(User user) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withIsMember(boolean isMember) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanSendMessages(boolean canSendMessages) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanSendAudios(boolean canSendAudios) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanSendDocuments(boolean canSendDocuments) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanSendPhotos(boolean canSendPhotos) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanSendVideos(boolean canSendVideos) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanSendVideoNotes(boolean canSendVideoNotes) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanSendVoiceNotes(boolean canSendVoiceNotes) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanSendPolls(boolean canSendPolls) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanSendOtherMessages(boolean canSendOtherMessages) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanAddWebPagePreviews(boolean canAddWebPagePreviews) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanEditTag(boolean canEditTag) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanChangeInfo(boolean canChangeInfo) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanInviteUsers(boolean canInviteUsers) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanPinMessages(boolean canPinMessages) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withCanManageTopics(boolean canManageTopics) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    public ChatMemberRestricted withUntilDate(long untilDate) {
        return new ChatMemberRestricted(status, tag, user, isMember, canSendMessages, canSendAudios, canSendDocuments, canSendPhotos, canSendVideos, canSendVideoNotes, canSendVoiceNotes, canSendPolls, canSendOtherMessages, canAddWebPagePreviews, canEditTag, canChangeInfo, canInviteUsers, canPinMessages, canManageTopics, untilDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatMemberRestricted)) {
            return false;
        }
        ChatMemberRestricted that = (ChatMemberRestricted) o;
        return Objects.equals(this.status, that.status)
                && Objects.equals(this.tag, that.tag)
                && Objects.equals(this.user, that.user)
                && this.isMember == that.isMember
                && this.canSendMessages == that.canSendMessages
                && this.canSendAudios == that.canSendAudios
                && this.canSendDocuments == that.canSendDocuments
                && this.canSendPhotos == that.canSendPhotos
                && this.canSendVideos == that.canSendVideos
                && this.canSendVideoNotes == that.canSendVideoNotes
                && this.canSendVoiceNotes == that.canSendVoiceNotes
                && this.canSendPolls == that.canSendPolls
                && this.canSendOtherMessages == that.canSendOtherMessages
                && this.canAddWebPagePreviews == that.canAddWebPagePreviews
                && this.canEditTag == that.canEditTag
                && this.canChangeInfo == that.canChangeInfo
                && this.canInviteUsers == that.canInviteUsers
                && this.canPinMessages == that.canPinMessages
                && this.canManageTopics == that.canManageTopics
                && this.untilDate == that.untilDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.tag, this.user, this.isMember, this.canSendMessages, this.canSendAudios, this.canSendDocuments, this.canSendPhotos, this.canSendVideos, this.canSendVideoNotes, this.canSendVoiceNotes, this.canSendPolls, this.canSendOtherMessages, this.canAddWebPagePreviews, this.canEditTag, this.canChangeInfo, this.canInviteUsers, this.canPinMessages, this.canManageTopics, this.untilDate);
    }

    @Override
    public String toString() {
        return "ChatMemberRestricted[status=" + this.status
                + ", tag=" + this.tag
                + ", user=" + this.user
                + ", isMember=" + this.isMember
                + ", canSendMessages=" + this.canSendMessages
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
                + ", untilDate=" + this.untilDate
                + "]";
    }
}
