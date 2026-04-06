package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Animation;
import io.jiogram.types.Audio;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatBackground;
import io.jiogram.types.ChatBoostAdded;
import io.jiogram.types.ChatOwnerChanged;
import io.jiogram.types.ChatOwnerLeft;
import io.jiogram.types.ChatShared;
import io.jiogram.types.Checklist;
import io.jiogram.types.ChecklistTasksAdded;
import io.jiogram.types.ChecklistTasksDone;
import io.jiogram.types.Contact;
import io.jiogram.types.Dice;
import io.jiogram.types.DirectMessagePriceChanged;
import io.jiogram.types.DirectMessagesTopic;
import io.jiogram.types.Document;
import io.jiogram.types.ExternalReplyInfo;
import io.jiogram.types.ForumTopicClosed;
import io.jiogram.types.ForumTopicCreated;
import io.jiogram.types.ForumTopicEdited;
import io.jiogram.types.ForumTopicReopened;
import io.jiogram.types.Game;
import io.jiogram.types.GeneralForumTopicHidden;
import io.jiogram.types.GeneralForumTopicUnhidden;
import io.jiogram.types.GiftInfo;
import io.jiogram.types.Giveaway;
import io.jiogram.types.GiveawayCompleted;
import io.jiogram.types.GiveawayCreated;
import io.jiogram.types.GiveawayWinners;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Invoice;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.Location;
import io.jiogram.types.ManagedBotCreated;
import io.jiogram.types.MaybeInaccessibleMessage;
import io.jiogram.types.Message;
import io.jiogram.types.MessageAutoDeleteTimerChanged;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.MessageOrigin;
import io.jiogram.types.PaidMediaInfo;
import io.jiogram.types.PaidMessagePriceChanged;
import io.jiogram.types.PassportData;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.Poll;
import io.jiogram.types.PollOptionAdded;
import io.jiogram.types.PollOptionDeleted;
import io.jiogram.types.ProximityAlertTriggered;
import io.jiogram.types.RefundedPayment;
import io.jiogram.types.Sticker;
import io.jiogram.types.Story;
import io.jiogram.types.SuccessfulPayment;
import io.jiogram.types.SuggestedPostApprovalFailed;
import io.jiogram.types.SuggestedPostApproved;
import io.jiogram.types.SuggestedPostDeclined;
import io.jiogram.types.SuggestedPostInfo;
import io.jiogram.types.SuggestedPostPaid;
import io.jiogram.types.SuggestedPostRefunded;
import io.jiogram.types.TextQuote;
import io.jiogram.types.UniqueGiftInfo;
import io.jiogram.types.User;
import io.jiogram.types.UsersShared;
import io.jiogram.types.Venue;
import io.jiogram.types.Video;
import io.jiogram.types.VideoChatEnded;
import io.jiogram.types.VideoChatParticipantsInvited;
import io.jiogram.types.VideoChatScheduled;
import io.jiogram.types.VideoChatStarted;
import io.jiogram.types.VideoNote;
import io.jiogram.types.Voice;
import io.jiogram.types.WebAppData;
import io.jiogram.types.WriteAccessAllowed;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record Message(
    @JsonProperty("message_id") long messageId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic") @Nullable DirectMessagesTopic directMessagesTopic,
    @JsonProperty("from") @Nullable User from,
    @JsonProperty("sender_chat") @Nullable Chat senderChat,
    @JsonProperty("sender_boost_count") @Nullable Long senderBoostCount,
    @JsonProperty("sender_business_bot") @Nullable User senderBusinessBot,
    @JsonProperty("sender_tag") @Nullable String senderTag,
    @JsonProperty("date") long date,
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat") Chat chat,
    @JsonProperty("forward_origin") @Nullable MessageOrigin forwardOrigin,
    @JsonProperty("is_topic_message") @Nullable Boolean isTopicMessage,
    @JsonProperty("is_automatic_forward") @Nullable Boolean isAutomaticForward,
    @JsonProperty("reply_to_message") @Nullable Message replyToMessage,
    @JsonProperty("external_reply") @Nullable ExternalReplyInfo externalReply,
    @JsonProperty("quote") @Nullable TextQuote quote,
    @JsonProperty("reply_to_story") @Nullable Story replyToStory,
    @JsonProperty("reply_to_checklist_task_id") @Nullable Long replyToChecklistTaskId,
    @JsonProperty("reply_to_poll_option_id") @Nullable String replyToPollOptionId,
    @JsonProperty("via_bot") @Nullable User viaBot,
    @JsonProperty("edit_date") @Nullable Long editDate,
    @JsonProperty("has_protected_content") @Nullable Boolean hasProtectedContent,
    @JsonProperty("is_from_offline") @Nullable Boolean isFromOffline,
    @JsonProperty("is_paid_post") @Nullable Boolean isPaidPost,
    @JsonProperty("media_group_id") @Nullable String mediaGroupId,
    @JsonProperty("author_signature") @Nullable String authorSignature,
    @JsonProperty("paid_star_count") @Nullable Long paidStarCount,
    @JsonProperty("text") @Nullable String text,
    @JsonProperty("entities") @Nullable List<MessageEntity> entities,
    @JsonProperty("link_preview_options") @Nullable LinkPreviewOptions linkPreviewOptions,
    @JsonProperty("suggested_post_info") @Nullable SuggestedPostInfo suggestedPostInfo,
    @JsonProperty("effect_id") @Nullable String effectId,
    @JsonProperty("animation") @Nullable Animation animation,
    @JsonProperty("audio") @Nullable Audio audio,
    @JsonProperty("document") @Nullable Document document,
    @JsonProperty("paid_media") @Nullable PaidMediaInfo paidMedia,
    @JsonProperty("photo") @Nullable List<PhotoSize> photo,
    @JsonProperty("sticker") @Nullable Sticker sticker,
    @JsonProperty("story") @Nullable Story story,
    @JsonProperty("video") @Nullable Video video,
    @JsonProperty("video_note") @Nullable VideoNote videoNote,
    @JsonProperty("voice") @Nullable Voice voice,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("has_media_spoiler") @Nullable Boolean hasMediaSpoiler,
    @JsonProperty("checklist") @Nullable Checklist checklist,
    @JsonProperty("contact") @Nullable Contact contact,
    @JsonProperty("dice") @Nullable Dice dice,
    @JsonProperty("game") @Nullable Game game,
    @JsonProperty("poll") @Nullable Poll poll,
    @JsonProperty("venue") @Nullable Venue venue,
    @JsonProperty("location") @Nullable Location location,
    @JsonProperty("new_chat_members") @Nullable List<User> newChatMembers,
    @JsonProperty("left_chat_member") @Nullable User leftChatMember,
    @JsonProperty("chat_owner_left") @Nullable ChatOwnerLeft chatOwnerLeft,
    @JsonProperty("chat_owner_changed") @Nullable ChatOwnerChanged chatOwnerChanged,
    @JsonProperty("new_chat_title") @Nullable String newChatTitle,
    @JsonProperty("new_chat_photo") @Nullable List<PhotoSize> newChatPhoto,
    @JsonProperty("delete_chat_photo") @Nullable Boolean deleteChatPhoto,
    @JsonProperty("group_chat_created") @Nullable Boolean groupChatCreated,
    @JsonProperty("supergroup_chat_created") @Nullable Boolean supergroupChatCreated,
    @JsonProperty("channel_chat_created") @Nullable Boolean channelChatCreated,
    @JsonProperty("message_auto_delete_timer_changed") @Nullable MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged,
    @JsonProperty("migrate_to_chat_id") @Nullable Long migrateToChatId,
    @JsonProperty("migrate_from_chat_id") @Nullable Long migrateFromChatId,
    @JsonProperty("pinned_message") @Nullable MaybeInaccessibleMessage pinnedMessage,
    @JsonProperty("invoice") @Nullable Invoice invoice,
    @JsonProperty("successful_payment") @Nullable SuccessfulPayment successfulPayment,
    @JsonProperty("refunded_payment") @Nullable RefundedPayment refundedPayment,
    @JsonProperty("users_shared") @Nullable UsersShared usersShared,
    @JsonProperty("chat_shared") @Nullable ChatShared chatShared,
    @JsonProperty("gift") @Nullable GiftInfo gift,
    @JsonProperty("unique_gift") @Nullable UniqueGiftInfo uniqueGift,
    @JsonProperty("gift_upgrade_sent") @Nullable GiftInfo giftUpgradeSent,
    @JsonProperty("connected_website") @Nullable String connectedWebsite,
    @JsonProperty("write_access_allowed") @Nullable WriteAccessAllowed writeAccessAllowed,
    @JsonProperty("passport_data") @Nullable PassportData passportData,
    @JsonProperty("proximity_alert_triggered") @Nullable ProximityAlertTriggered proximityAlertTriggered,
    @JsonProperty("boost_added") @Nullable ChatBoostAdded boostAdded,
    @JsonProperty("chat_background_set") @Nullable ChatBackground chatBackgroundSet,
    @JsonProperty("checklist_tasks_done") @Nullable ChecklistTasksDone checklistTasksDone,
    @JsonProperty("checklist_tasks_added") @Nullable ChecklistTasksAdded checklistTasksAdded,
    @JsonProperty("direct_message_price_changed") @Nullable DirectMessagePriceChanged directMessagePriceChanged,
    @JsonProperty("forum_topic_created") @Nullable ForumTopicCreated forumTopicCreated,
    @JsonProperty("forum_topic_edited") @Nullable ForumTopicEdited forumTopicEdited,
    @JsonProperty("forum_topic_closed") @Nullable ForumTopicClosed forumTopicClosed,
    @JsonProperty("forum_topic_reopened") @Nullable ForumTopicReopened forumTopicReopened,
    @JsonProperty("general_forum_topic_hidden") @Nullable GeneralForumTopicHidden generalForumTopicHidden,
    @JsonProperty("general_forum_topic_unhidden") @Nullable GeneralForumTopicUnhidden generalForumTopicUnhidden,
    @JsonProperty("giveaway_created") @Nullable GiveawayCreated giveawayCreated,
    @JsonProperty("giveaway") @Nullable Giveaway giveaway,
    @JsonProperty("giveaway_winners") @Nullable GiveawayWinners giveawayWinners,
    @JsonProperty("giveaway_completed") @Nullable GiveawayCompleted giveawayCompleted,
    @JsonProperty("managed_bot_created") @Nullable ManagedBotCreated managedBotCreated,
    @JsonProperty("paid_message_price_changed") @Nullable PaidMessagePriceChanged paidMessagePriceChanged,
    @JsonProperty("poll_option_added") @Nullable PollOptionAdded pollOptionAdded,
    @JsonProperty("poll_option_deleted") @Nullable PollOptionDeleted pollOptionDeleted,
    @JsonProperty("suggested_post_approved") @Nullable SuggestedPostApproved suggestedPostApproved,
    @JsonProperty("suggested_post_approval_failed") @Nullable SuggestedPostApprovalFailed suggestedPostApprovalFailed,
    @JsonProperty("suggested_post_declined") @Nullable SuggestedPostDeclined suggestedPostDeclined,
    @JsonProperty("suggested_post_paid") @Nullable SuggestedPostPaid suggestedPostPaid,
    @JsonProperty("suggested_post_refunded") @Nullable SuggestedPostRefunded suggestedPostRefunded,
    @JsonProperty("video_chat_scheduled") @Nullable VideoChatScheduled videoChatScheduled,
    @JsonProperty("video_chat_started") @Nullable VideoChatStarted videoChatStarted,
    @JsonProperty("video_chat_ended") @Nullable VideoChatEnded videoChatEnded,
    @JsonProperty("video_chat_participants_invited") @Nullable VideoChatParticipantsInvited videoChatParticipantsInvited,
    @JsonProperty("web_app_data") @Nullable WebAppData webAppData,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements MaybeInaccessibleMessage {}
