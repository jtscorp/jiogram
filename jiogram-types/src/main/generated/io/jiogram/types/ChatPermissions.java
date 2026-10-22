package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Describes actions that a non-administrator user is allowed to take in a chat.
 *
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
 *     settings. Ignored in public supergroups
 * @param canInviteUsers True, if the user is allowed to invite new users to the chat
 * @param canPinMessages True, if the user is allowed to pin messages. Ignored in public supergroups
 * @param canManageTopics True, if the user is allowed to create forum topics. If omitted defaults
 *     to the value of can_pin_messages
 * @see <a href="https://core.telegram.org/bots/api#chatpermissions">ChatPermissions in the Bot API</a>
 */
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
