package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
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

public class Message implements MaybeInaccessibleMessage {
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("message_thread_id") @Nullable private final Long messageThreadId;
    @JsonProperty("direct_messages_topic") @Nullable private final DirectMessagesTopic directMessagesTopic;
    @JsonProperty("from") @Nullable private final User from;
    @JsonProperty("sender_chat") @Nullable private final Chat senderChat;
    @JsonProperty("sender_boost_count") @Nullable private final Long senderBoostCount;
    @JsonProperty("sender_business_bot") @Nullable private final User senderBusinessBot;
    @JsonProperty("sender_tag") @Nullable private final String senderTag;
    @JsonProperty("date") private final long date;
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("forward_origin") @Nullable private final MessageOrigin forwardOrigin;
    @JsonProperty("is_topic_message") @Nullable private final Boolean isTopicMessage;
    @JsonProperty("is_automatic_forward") @Nullable private final Boolean isAutomaticForward;
    @JsonProperty("reply_to_message") @Nullable private final Message replyToMessage;
    @JsonProperty("external_reply") @Nullable private final ExternalReplyInfo externalReply;
    @JsonProperty("quote") @Nullable private final TextQuote quote;
    @JsonProperty("reply_to_story") @Nullable private final Story replyToStory;
    @JsonProperty("reply_to_checklist_task_id") @Nullable private final Long replyToChecklistTaskId;
    @JsonProperty("reply_to_poll_option_id") @Nullable private final String replyToPollOptionId;
    @JsonProperty("via_bot") @Nullable private final User viaBot;
    @JsonProperty("edit_date") @Nullable private final Long editDate;
    @JsonProperty("has_protected_content") @Nullable private final Boolean hasProtectedContent;
    @JsonProperty("is_from_offline") @Nullable private final Boolean isFromOffline;
    @JsonProperty("is_paid_post") @Nullable private final Boolean isPaidPost;
    @JsonProperty("media_group_id") @Nullable private final String mediaGroupId;
    @JsonProperty("author_signature") @Nullable private final String authorSignature;
    @JsonProperty("paid_star_count") @Nullable private final Long paidStarCount;
    @JsonProperty("text") @Nullable private final String text;
    @JsonProperty("entities") @Nullable private final List<MessageEntity> entities;
    @JsonProperty("link_preview_options") @Nullable private final LinkPreviewOptions linkPreviewOptions;
    @JsonProperty("suggested_post_info") @Nullable private final SuggestedPostInfo suggestedPostInfo;
    @JsonProperty("effect_id") @Nullable private final String effectId;
    @JsonProperty("animation") @Nullable private final Animation animation;
    @JsonProperty("audio") @Nullable private final Audio audio;
    @JsonProperty("document") @Nullable private final Document document;
    @JsonProperty("paid_media") @Nullable private final PaidMediaInfo paidMedia;
    @JsonProperty("photo") @Nullable private final List<PhotoSize> photo;
    @JsonProperty("sticker") @Nullable private final Sticker sticker;
    @JsonProperty("story") @Nullable private final Story story;
    @JsonProperty("video") @Nullable private final Video video;
    @JsonProperty("video_note") @Nullable private final VideoNote videoNote;
    @JsonProperty("voice") @Nullable private final Voice voice;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("show_caption_above_media") @Nullable private final Boolean showCaptionAboveMedia;
    @JsonProperty("has_media_spoiler") @Nullable private final Boolean hasMediaSpoiler;
    @JsonProperty("checklist") @Nullable private final Checklist checklist;
    @JsonProperty("contact") @Nullable private final Contact contact;
    @JsonProperty("dice") @Nullable private final Dice dice;
    @JsonProperty("game") @Nullable private final Game game;
    @JsonProperty("poll") @Nullable private final Poll poll;
    @JsonProperty("venue") @Nullable private final Venue venue;
    @JsonProperty("location") @Nullable private final Location location;
    @JsonProperty("new_chat_members") @Nullable private final List<User> newChatMembers;
    @JsonProperty("left_chat_member") @Nullable private final User leftChatMember;
    @JsonProperty("chat_owner_left") @Nullable private final ChatOwnerLeft chatOwnerLeft;
    @JsonProperty("chat_owner_changed") @Nullable private final ChatOwnerChanged chatOwnerChanged;
    @JsonProperty("new_chat_title") @Nullable private final String newChatTitle;
    @JsonProperty("new_chat_photo") @Nullable private final List<PhotoSize> newChatPhoto;
    @JsonProperty("delete_chat_photo") @Nullable private final Boolean deleteChatPhoto;
    @JsonProperty("group_chat_created") @Nullable private final Boolean groupChatCreated;
    @JsonProperty("supergroup_chat_created") @Nullable private final Boolean supergroupChatCreated;
    @JsonProperty("channel_chat_created") @Nullable private final Boolean channelChatCreated;
    @JsonProperty("message_auto_delete_timer_changed") @Nullable private final MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged;
    @JsonProperty("migrate_to_chat_id") @Nullable private final Long migrateToChatId;
    @JsonProperty("migrate_from_chat_id") @Nullable private final Long migrateFromChatId;
    @JsonProperty("pinned_message") @Nullable private final MaybeInaccessibleMessage pinnedMessage;
    @JsonProperty("invoice") @Nullable private final Invoice invoice;
    @JsonProperty("successful_payment") @Nullable private final SuccessfulPayment successfulPayment;
    @JsonProperty("refunded_payment") @Nullable private final RefundedPayment refundedPayment;
    @JsonProperty("users_shared") @Nullable private final UsersShared usersShared;
    @JsonProperty("chat_shared") @Nullable private final ChatShared chatShared;
    @JsonProperty("gift") @Nullable private final GiftInfo gift;
    @JsonProperty("unique_gift") @Nullable private final UniqueGiftInfo uniqueGift;
    @JsonProperty("gift_upgrade_sent") @Nullable private final GiftInfo giftUpgradeSent;
    @JsonProperty("connected_website") @Nullable private final String connectedWebsite;
    @JsonProperty("write_access_allowed") @Nullable private final WriteAccessAllowed writeAccessAllowed;
    @JsonProperty("passport_data") @Nullable private final PassportData passportData;
    @JsonProperty("proximity_alert_triggered") @Nullable private final ProximityAlertTriggered proximityAlertTriggered;
    @JsonProperty("boost_added") @Nullable private final ChatBoostAdded boostAdded;
    @JsonProperty("chat_background_set") @Nullable private final ChatBackground chatBackgroundSet;
    @JsonProperty("checklist_tasks_done") @Nullable private final ChecklistTasksDone checklistTasksDone;
    @JsonProperty("checklist_tasks_added") @Nullable private final ChecklistTasksAdded checklistTasksAdded;
    @JsonProperty("direct_message_price_changed") @Nullable private final DirectMessagePriceChanged directMessagePriceChanged;
    @JsonProperty("forum_topic_created") @Nullable private final ForumTopicCreated forumTopicCreated;
    @JsonProperty("forum_topic_edited") @Nullable private final ForumTopicEdited forumTopicEdited;
    @JsonProperty("forum_topic_closed") @Nullable private final ForumTopicClosed forumTopicClosed;
    @JsonProperty("forum_topic_reopened") @Nullable private final ForumTopicReopened forumTopicReopened;
    @JsonProperty("general_forum_topic_hidden") @Nullable private final GeneralForumTopicHidden generalForumTopicHidden;
    @JsonProperty("general_forum_topic_unhidden") @Nullable private final GeneralForumTopicUnhidden generalForumTopicUnhidden;
    @JsonProperty("giveaway_created") @Nullable private final GiveawayCreated giveawayCreated;
    @JsonProperty("giveaway") @Nullable private final Giveaway giveaway;
    @JsonProperty("giveaway_winners") @Nullable private final GiveawayWinners giveawayWinners;
    @JsonProperty("giveaway_completed") @Nullable private final GiveawayCompleted giveawayCompleted;
    @JsonProperty("managed_bot_created") @Nullable private final ManagedBotCreated managedBotCreated;
    @JsonProperty("paid_message_price_changed") @Nullable private final PaidMessagePriceChanged paidMessagePriceChanged;
    @JsonProperty("poll_option_added") @Nullable private final PollOptionAdded pollOptionAdded;
    @JsonProperty("poll_option_deleted") @Nullable private final PollOptionDeleted pollOptionDeleted;
    @JsonProperty("suggested_post_approved") @Nullable private final SuggestedPostApproved suggestedPostApproved;
    @JsonProperty("suggested_post_approval_failed") @Nullable private final SuggestedPostApprovalFailed suggestedPostApprovalFailed;
    @JsonProperty("suggested_post_declined") @Nullable private final SuggestedPostDeclined suggestedPostDeclined;
    @JsonProperty("suggested_post_paid") @Nullable private final SuggestedPostPaid suggestedPostPaid;
    @JsonProperty("suggested_post_refunded") @Nullable private final SuggestedPostRefunded suggestedPostRefunded;
    @JsonProperty("video_chat_scheduled") @Nullable private final VideoChatScheduled videoChatScheduled;
    @JsonProperty("video_chat_started") @Nullable private final VideoChatStarted videoChatStarted;
    @JsonProperty("video_chat_ended") @Nullable private final VideoChatEnded videoChatEnded;
    @JsonProperty("video_chat_participants_invited") @Nullable private final VideoChatParticipantsInvited videoChatParticipantsInvited;
    @JsonProperty("web_app_data") @Nullable private final WebAppData webAppData;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;

    @JsonCreator
    public Message(
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
    ) {
        this.messageId = messageId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopic = directMessagesTopic;
        this.from = from;
        this.senderChat = senderChat;
        this.senderBoostCount = senderBoostCount;
        this.senderBusinessBot = senderBusinessBot;
        this.senderTag = senderTag;
        this.date = date;
        this.businessConnectionId = businessConnectionId;
        this.chat = chat;
        this.forwardOrigin = forwardOrigin;
        this.isTopicMessage = isTopicMessage;
        this.isAutomaticForward = isAutomaticForward;
        this.replyToMessage = replyToMessage;
        this.externalReply = externalReply;
        this.quote = quote;
        this.replyToStory = replyToStory;
        this.replyToChecklistTaskId = replyToChecklistTaskId;
        this.replyToPollOptionId = replyToPollOptionId;
        this.viaBot = viaBot;
        this.editDate = editDate;
        this.hasProtectedContent = hasProtectedContent;
        this.isFromOffline = isFromOffline;
        this.isPaidPost = isPaidPost;
        this.mediaGroupId = mediaGroupId;
        this.authorSignature = authorSignature;
        this.paidStarCount = paidStarCount;
        this.text = text;
        this.entities = entities;
        this.linkPreviewOptions = linkPreviewOptions;
        this.suggestedPostInfo = suggestedPostInfo;
        this.effectId = effectId;
        this.animation = animation;
        this.audio = audio;
        this.document = document;
        this.paidMedia = paidMedia;
        this.photo = photo;
        this.sticker = sticker;
        this.story = story;
        this.video = video;
        this.videoNote = videoNote;
        this.voice = voice;
        this.caption = caption;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.hasMediaSpoiler = hasMediaSpoiler;
        this.checklist = checklist;
        this.contact = contact;
        this.dice = dice;
        this.game = game;
        this.poll = poll;
        this.venue = venue;
        this.location = location;
        this.newChatMembers = newChatMembers;
        this.leftChatMember = leftChatMember;
        this.chatOwnerLeft = chatOwnerLeft;
        this.chatOwnerChanged = chatOwnerChanged;
        this.newChatTitle = newChatTitle;
        this.newChatPhoto = newChatPhoto;
        this.deleteChatPhoto = deleteChatPhoto;
        this.groupChatCreated = groupChatCreated;
        this.supergroupChatCreated = supergroupChatCreated;
        this.channelChatCreated = channelChatCreated;
        this.messageAutoDeleteTimerChanged = messageAutoDeleteTimerChanged;
        this.migrateToChatId = migrateToChatId;
        this.migrateFromChatId = migrateFromChatId;
        this.pinnedMessage = pinnedMessage;
        this.invoice = invoice;
        this.successfulPayment = successfulPayment;
        this.refundedPayment = refundedPayment;
        this.usersShared = usersShared;
        this.chatShared = chatShared;
        this.gift = gift;
        this.uniqueGift = uniqueGift;
        this.giftUpgradeSent = giftUpgradeSent;
        this.connectedWebsite = connectedWebsite;
        this.writeAccessAllowed = writeAccessAllowed;
        this.passportData = passportData;
        this.proximityAlertTriggered = proximityAlertTriggered;
        this.boostAdded = boostAdded;
        this.chatBackgroundSet = chatBackgroundSet;
        this.checklistTasksDone = checklistTasksDone;
        this.checklistTasksAdded = checklistTasksAdded;
        this.directMessagePriceChanged = directMessagePriceChanged;
        this.forumTopicCreated = forumTopicCreated;
        this.forumTopicEdited = forumTopicEdited;
        this.forumTopicClosed = forumTopicClosed;
        this.forumTopicReopened = forumTopicReopened;
        this.generalForumTopicHidden = generalForumTopicHidden;
        this.generalForumTopicUnhidden = generalForumTopicUnhidden;
        this.giveawayCreated = giveawayCreated;
        this.giveaway = giveaway;
        this.giveawayWinners = giveawayWinners;
        this.giveawayCompleted = giveawayCompleted;
        this.managedBotCreated = managedBotCreated;
        this.paidMessagePriceChanged = paidMessagePriceChanged;
        this.pollOptionAdded = pollOptionAdded;
        this.pollOptionDeleted = pollOptionDeleted;
        this.suggestedPostApproved = suggestedPostApproved;
        this.suggestedPostApprovalFailed = suggestedPostApprovalFailed;
        this.suggestedPostDeclined = suggestedPostDeclined;
        this.suggestedPostPaid = suggestedPostPaid;
        this.suggestedPostRefunded = suggestedPostRefunded;
        this.videoChatScheduled = videoChatScheduled;
        this.videoChatStarted = videoChatStarted;
        this.videoChatEnded = videoChatEnded;
        this.videoChatParticipantsInvited = videoChatParticipantsInvited;
        this.webAppData = webAppData;
        this.replyMarkup = replyMarkup;
    }

    public long messageId() {
        return this.messageId;
    }

    public Long messageThreadId() {
        return this.messageThreadId;
    }

    public DirectMessagesTopic directMessagesTopic() {
        return this.directMessagesTopic;
    }

    public User from() {
        return this.from;
    }

    public Chat senderChat() {
        return this.senderChat;
    }

    public Long senderBoostCount() {
        return this.senderBoostCount;
    }

    public User senderBusinessBot() {
        return this.senderBusinessBot;
    }

    public String senderTag() {
        return this.senderTag;
    }

    public long date() {
        return this.date;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public Chat chat() {
        return this.chat;
    }

    public MessageOrigin forwardOrigin() {
        return this.forwardOrigin;
    }

    public Boolean isTopicMessage() {
        return this.isTopicMessage;
    }

    public Boolean isAutomaticForward() {
        return this.isAutomaticForward;
    }

    public Message replyToMessage() {
        return this.replyToMessage;
    }

    public ExternalReplyInfo externalReply() {
        return this.externalReply;
    }

    public TextQuote quote() {
        return this.quote;
    }

    public Story replyToStory() {
        return this.replyToStory;
    }

    public Long replyToChecklistTaskId() {
        return this.replyToChecklistTaskId;
    }

    public String replyToPollOptionId() {
        return this.replyToPollOptionId;
    }

    public User viaBot() {
        return this.viaBot;
    }

    public Long editDate() {
        return this.editDate;
    }

    public Boolean hasProtectedContent() {
        return this.hasProtectedContent;
    }

    public Boolean isFromOffline() {
        return this.isFromOffline;
    }

    public Boolean isPaidPost() {
        return this.isPaidPost;
    }

    public String mediaGroupId() {
        return this.mediaGroupId;
    }

    public String authorSignature() {
        return this.authorSignature;
    }

    public Long paidStarCount() {
        return this.paidStarCount;
    }

    public String text() {
        return this.text;
    }

    public List<MessageEntity> entities() {
        return this.entities;
    }

    public LinkPreviewOptions linkPreviewOptions() {
        return this.linkPreviewOptions;
    }

    public SuggestedPostInfo suggestedPostInfo() {
        return this.suggestedPostInfo;
    }

    public String effectId() {
        return this.effectId;
    }

    public Animation animation() {
        return this.animation;
    }

    public Audio audio() {
        return this.audio;
    }

    public Document document() {
        return this.document;
    }

    public PaidMediaInfo paidMedia() {
        return this.paidMedia;
    }

    public List<PhotoSize> photo() {
        return this.photo;
    }

    public Sticker sticker() {
        return this.sticker;
    }

    public Story story() {
        return this.story;
    }

    public Video video() {
        return this.video;
    }

    public VideoNote videoNote() {
        return this.videoNote;
    }

    public Voice voice() {
        return this.voice;
    }

    public String caption() {
        return this.caption;
    }

    public List<MessageEntity> captionEntities() {
        return this.captionEntities;
    }

    public Boolean showCaptionAboveMedia() {
        return this.showCaptionAboveMedia;
    }

    public Boolean hasMediaSpoiler() {
        return this.hasMediaSpoiler;
    }

    public Checklist checklist() {
        return this.checklist;
    }

    public Contact contact() {
        return this.contact;
    }

    public Dice dice() {
        return this.dice;
    }

    public Game game() {
        return this.game;
    }

    public Poll poll() {
        return this.poll;
    }

    public Venue venue() {
        return this.venue;
    }

    public Location location() {
        return this.location;
    }

    public List<User> newChatMembers() {
        return this.newChatMembers;
    }

    public User leftChatMember() {
        return this.leftChatMember;
    }

    public ChatOwnerLeft chatOwnerLeft() {
        return this.chatOwnerLeft;
    }

    public ChatOwnerChanged chatOwnerChanged() {
        return this.chatOwnerChanged;
    }

    public String newChatTitle() {
        return this.newChatTitle;
    }

    public List<PhotoSize> newChatPhoto() {
        return this.newChatPhoto;
    }

    public Boolean deleteChatPhoto() {
        return this.deleteChatPhoto;
    }

    public Boolean groupChatCreated() {
        return this.groupChatCreated;
    }

    public Boolean supergroupChatCreated() {
        return this.supergroupChatCreated;
    }

    public Boolean channelChatCreated() {
        return this.channelChatCreated;
    }

    public MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged() {
        return this.messageAutoDeleteTimerChanged;
    }

    public Long migrateToChatId() {
        return this.migrateToChatId;
    }

    public Long migrateFromChatId() {
        return this.migrateFromChatId;
    }

    public MaybeInaccessibleMessage pinnedMessage() {
        return this.pinnedMessage;
    }

    public Invoice invoice() {
        return this.invoice;
    }

    public SuccessfulPayment successfulPayment() {
        return this.successfulPayment;
    }

    public RefundedPayment refundedPayment() {
        return this.refundedPayment;
    }

    public UsersShared usersShared() {
        return this.usersShared;
    }

    public ChatShared chatShared() {
        return this.chatShared;
    }

    public GiftInfo gift() {
        return this.gift;
    }

    public UniqueGiftInfo uniqueGift() {
        return this.uniqueGift;
    }

    public GiftInfo giftUpgradeSent() {
        return this.giftUpgradeSent;
    }

    public String connectedWebsite() {
        return this.connectedWebsite;
    }

    public WriteAccessAllowed writeAccessAllowed() {
        return this.writeAccessAllowed;
    }

    public PassportData passportData() {
        return this.passportData;
    }

    public ProximityAlertTriggered proximityAlertTriggered() {
        return this.proximityAlertTriggered;
    }

    public ChatBoostAdded boostAdded() {
        return this.boostAdded;
    }

    public ChatBackground chatBackgroundSet() {
        return this.chatBackgroundSet;
    }

    public ChecklistTasksDone checklistTasksDone() {
        return this.checklistTasksDone;
    }

    public ChecklistTasksAdded checklistTasksAdded() {
        return this.checklistTasksAdded;
    }

    public DirectMessagePriceChanged directMessagePriceChanged() {
        return this.directMessagePriceChanged;
    }

    public ForumTopicCreated forumTopicCreated() {
        return this.forumTopicCreated;
    }

    public ForumTopicEdited forumTopicEdited() {
        return this.forumTopicEdited;
    }

    public ForumTopicClosed forumTopicClosed() {
        return this.forumTopicClosed;
    }

    public ForumTopicReopened forumTopicReopened() {
        return this.forumTopicReopened;
    }

    public GeneralForumTopicHidden generalForumTopicHidden() {
        return this.generalForumTopicHidden;
    }

    public GeneralForumTopicUnhidden generalForumTopicUnhidden() {
        return this.generalForumTopicUnhidden;
    }

    public GiveawayCreated giveawayCreated() {
        return this.giveawayCreated;
    }

    public Giveaway giveaway() {
        return this.giveaway;
    }

    public GiveawayWinners giveawayWinners() {
        return this.giveawayWinners;
    }

    public GiveawayCompleted giveawayCompleted() {
        return this.giveawayCompleted;
    }

    public ManagedBotCreated managedBotCreated() {
        return this.managedBotCreated;
    }

    public PaidMessagePriceChanged paidMessagePriceChanged() {
        return this.paidMessagePriceChanged;
    }

    public PollOptionAdded pollOptionAdded() {
        return this.pollOptionAdded;
    }

    public PollOptionDeleted pollOptionDeleted() {
        return this.pollOptionDeleted;
    }

    public SuggestedPostApproved suggestedPostApproved() {
        return this.suggestedPostApproved;
    }

    public SuggestedPostApprovalFailed suggestedPostApprovalFailed() {
        return this.suggestedPostApprovalFailed;
    }

    public SuggestedPostDeclined suggestedPostDeclined() {
        return this.suggestedPostDeclined;
    }

    public SuggestedPostPaid suggestedPostPaid() {
        return this.suggestedPostPaid;
    }

    public SuggestedPostRefunded suggestedPostRefunded() {
        return this.suggestedPostRefunded;
    }

    public VideoChatScheduled videoChatScheduled() {
        return this.videoChatScheduled;
    }

    public VideoChatStarted videoChatStarted() {
        return this.videoChatStarted;
    }

    public VideoChatEnded videoChatEnded() {
        return this.videoChatEnded;
    }

    public VideoChatParticipantsInvited videoChatParticipantsInvited() {
        return this.videoChatParticipantsInvited;
    }

    public WebAppData webAppData() {
        return this.webAppData;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }
}
