package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Represents a chat member that is under certain restrictions in the chat. Supergroups only.
 *
 * @param status The member's status in the chat, always 'restricted'
 * @param tag Tag of the member
 * @param user Information about the user
 * @param isMember True, if the user is a member of the chat at the moment of the request
 * @param canSendMessages True, if the user is allowed to send text messages, contacts, giveaways,
 *     giveaway winners, invoices, locations and venues
 * @param canSendAudios True, if the user is allowed to send audios
 * @param canSendDocuments True, if the user is allowed to send documents
 * @param canSendPhotos True, if the user is allowed to send photos
 * @param canSendVideos True, if the user is allowed to send videos
 * @param canSendVideoNotes True, if the user is allowed to send video notes
 * @param canSendVoiceNotes True, if the user is allowed to send voice notes
 * @param canSendPolls True, if the user is allowed to send polls and checklists
 * @param canSendOtherMessages True, if the user is allowed to send animations, games, stickers and
 *     use inline bots
 * @param canAddWebPagePreviews True, if the user is allowed to add web page previews to their
 *     messages
 * @param canEditTag True, if the user is allowed to edit their own tag
 * @param canChangeInfo True, if the user is allowed to change the chat title, photo and other
 *     settings
 * @param canInviteUsers True, if the user is allowed to invite new users to the chat
 * @param canPinMessages True, if the user is allowed to pin messages
 * @param canManageTopics True, if the user is allowed to create forum topics
 * @param untilDate Date when restrictions will be lifted for this user; Unix time. If 0, then the
 *     user is restricted forever
 * @see <a href="https://core.telegram.org/bots/api#chatmemberrestricted">ChatMemberRestricted in the Bot API</a>
 */
public record ChatMemberRestricted(
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
    @JsonProperty("until_date") long untilDate
) implements ChatMember {}
