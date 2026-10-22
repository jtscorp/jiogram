package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
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
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a message.
 *
 * @see <a href="https://core.telegram.org/bots/api#message">Message in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Message implements MaybeInaccessibleMessage {

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic")
    private final @Nullable DirectMessagesTopic directMessagesTopic;

    @JsonProperty("from")
    private final @Nullable User from;

    @JsonProperty("sender_chat")
    private final @Nullable Chat senderChat;

    @JsonProperty("sender_boost_count")
    private final @Nullable Long senderBoostCount;

    @JsonProperty("sender_business_bot")
    private final @Nullable User senderBusinessBot;

    @JsonProperty("sender_tag")
    private final @Nullable String senderTag;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("forward_origin")
    private final @Nullable MessageOrigin forwardOrigin;

    @JsonProperty("is_topic_message")
    private final @Nullable Boolean isTopicMessage;

    @JsonProperty("is_automatic_forward")
    private final @Nullable Boolean isAutomaticForward;

    @JsonProperty("reply_to_message")
    private final @Nullable Message replyToMessage;

    @JsonProperty("external_reply")
    private final @Nullable ExternalReplyInfo externalReply;

    @JsonProperty("quote")
    private final @Nullable TextQuote quote;

    @JsonProperty("reply_to_story")
    private final @Nullable Story replyToStory;

    @JsonProperty("reply_to_checklist_task_id")
    private final @Nullable Long replyToChecklistTaskId;

    @JsonProperty("reply_to_poll_option_id")
    private final @Nullable String replyToPollOptionId;

    @JsonProperty("via_bot")
    private final @Nullable User viaBot;

    @JsonProperty("edit_date")
    private final @Nullable Long editDate;

    @JsonProperty("has_protected_content")
    private final @Nullable Boolean hasProtectedContent;

    @JsonProperty("is_from_offline")
    private final @Nullable Boolean isFromOffline;

    @JsonProperty("is_paid_post")
    private final @Nullable Boolean isPaidPost;

    @JsonProperty("media_group_id")
    private final @Nullable String mediaGroupId;

    @JsonProperty("author_signature")
    private final @Nullable String authorSignature;

    @JsonProperty("paid_star_count")
    private final @Nullable Long paidStarCount;

    @JsonProperty("text")
    private final @Nullable String text;

    @JsonProperty("entities")
    private final @Nullable List<MessageEntity> entities;

    @JsonProperty("link_preview_options")
    private final @Nullable LinkPreviewOptions linkPreviewOptions;

    @JsonProperty("suggested_post_info")
    private final @Nullable SuggestedPostInfo suggestedPostInfo;

    @JsonProperty("effect_id")
    private final @Nullable String effectId;

    @JsonProperty("animation")
    private final @Nullable Animation animation;

    @JsonProperty("audio")
    private final @Nullable Audio audio;

    @JsonProperty("document")
    private final @Nullable Document document;

    @JsonProperty("paid_media")
    private final @Nullable PaidMediaInfo paidMedia;

    @JsonProperty("photo")
    private final @Nullable List<PhotoSize> photo;

    @JsonProperty("sticker")
    private final @Nullable Sticker sticker;

    @JsonProperty("story")
    private final @Nullable Story story;

    @JsonProperty("video")
    private final @Nullable Video video;

    @JsonProperty("video_note")
    private final @Nullable VideoNote videoNote;

    @JsonProperty("voice")
    private final @Nullable Voice voice;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("show_caption_above_media")
    private final @Nullable Boolean showCaptionAboveMedia;

    @JsonProperty("has_media_spoiler")
    private final @Nullable Boolean hasMediaSpoiler;

    @JsonProperty("checklist")
    private final @Nullable Checklist checklist;

    @JsonProperty("contact")
    private final @Nullable Contact contact;

    @JsonProperty("dice")
    private final @Nullable Dice dice;

    @JsonProperty("game")
    private final @Nullable Game game;

    @JsonProperty("poll")
    private final @Nullable Poll poll;

    @JsonProperty("venue")
    private final @Nullable Venue venue;

    @JsonProperty("location")
    private final @Nullable Location location;

    @JsonProperty("new_chat_members")
    private final @Nullable List<User> newChatMembers;

    @JsonProperty("left_chat_member")
    private final @Nullable User leftChatMember;

    @JsonProperty("chat_owner_left")
    private final @Nullable ChatOwnerLeft chatOwnerLeft;

    @JsonProperty("chat_owner_changed")
    private final @Nullable ChatOwnerChanged chatOwnerChanged;

    @JsonProperty("new_chat_title")
    private final @Nullable String newChatTitle;

    @JsonProperty("new_chat_photo")
    private final @Nullable List<PhotoSize> newChatPhoto;

    @JsonProperty("delete_chat_photo")
    private final @Nullable Boolean deleteChatPhoto;

    @JsonProperty("group_chat_created")
    private final @Nullable Boolean groupChatCreated;

    @JsonProperty("supergroup_chat_created")
    private final @Nullable Boolean supergroupChatCreated;

    @JsonProperty("channel_chat_created")
    private final @Nullable Boolean channelChatCreated;

    @JsonProperty("message_auto_delete_timer_changed")
    private final @Nullable MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged;

    @JsonProperty("migrate_to_chat_id")
    private final @Nullable Long migrateToChatId;

    @JsonProperty("migrate_from_chat_id")
    private final @Nullable Long migrateFromChatId;

    @JsonProperty("pinned_message")
    private final @Nullable MaybeInaccessibleMessage pinnedMessage;

    @JsonProperty("invoice")
    private final @Nullable Invoice invoice;

    @JsonProperty("successful_payment")
    private final @Nullable SuccessfulPayment successfulPayment;

    @JsonProperty("refunded_payment")
    private final @Nullable RefundedPayment refundedPayment;

    @JsonProperty("users_shared")
    private final @Nullable UsersShared usersShared;

    @JsonProperty("chat_shared")
    private final @Nullable ChatShared chatShared;

    @JsonProperty("gift")
    private final @Nullable GiftInfo gift;

    @JsonProperty("unique_gift")
    private final @Nullable UniqueGiftInfo uniqueGift;

    @JsonProperty("gift_upgrade_sent")
    private final @Nullable GiftInfo giftUpgradeSent;

    @JsonProperty("connected_website")
    private final @Nullable String connectedWebsite;

    @JsonProperty("write_access_allowed")
    private final @Nullable WriteAccessAllowed writeAccessAllowed;

    @JsonProperty("passport_data")
    private final @Nullable PassportData passportData;

    @JsonProperty("proximity_alert_triggered")
    private final @Nullable ProximityAlertTriggered proximityAlertTriggered;

    @JsonProperty("boost_added")
    private final @Nullable ChatBoostAdded boostAdded;

    @JsonProperty("chat_background_set")
    private final @Nullable ChatBackground chatBackgroundSet;

    @JsonProperty("checklist_tasks_done")
    private final @Nullable ChecklistTasksDone checklistTasksDone;

    @JsonProperty("checklist_tasks_added")
    private final @Nullable ChecklistTasksAdded checklistTasksAdded;

    @JsonProperty("direct_message_price_changed")
    private final @Nullable DirectMessagePriceChanged directMessagePriceChanged;

    @JsonProperty("forum_topic_created")
    private final @Nullable ForumTopicCreated forumTopicCreated;

    @JsonProperty("forum_topic_edited")
    private final @Nullable ForumTopicEdited forumTopicEdited;

    @JsonProperty("forum_topic_closed")
    private final @Nullable ForumTopicClosed forumTopicClosed;

    @JsonProperty("forum_topic_reopened")
    private final @Nullable ForumTopicReopened forumTopicReopened;

    @JsonProperty("general_forum_topic_hidden")
    private final @Nullable GeneralForumTopicHidden generalForumTopicHidden;

    @JsonProperty("general_forum_topic_unhidden")
    private final @Nullable GeneralForumTopicUnhidden generalForumTopicUnhidden;

    @JsonProperty("giveaway_created")
    private final @Nullable GiveawayCreated giveawayCreated;

    @JsonProperty("giveaway")
    private final @Nullable Giveaway giveaway;

    @JsonProperty("giveaway_winners")
    private final @Nullable GiveawayWinners giveawayWinners;

    @JsonProperty("giveaway_completed")
    private final @Nullable GiveawayCompleted giveawayCompleted;

    @JsonProperty("managed_bot_created")
    private final @Nullable ManagedBotCreated managedBotCreated;

    @JsonProperty("paid_message_price_changed")
    private final @Nullable PaidMessagePriceChanged paidMessagePriceChanged;

    @JsonProperty("poll_option_added")
    private final @Nullable PollOptionAdded pollOptionAdded;

    @JsonProperty("poll_option_deleted")
    private final @Nullable PollOptionDeleted pollOptionDeleted;

    @JsonProperty("suggested_post_approved")
    private final @Nullable SuggestedPostApproved suggestedPostApproved;

    @JsonProperty("suggested_post_approval_failed")
    private final @Nullable SuggestedPostApprovalFailed suggestedPostApprovalFailed;

    @JsonProperty("suggested_post_declined")
    private final @Nullable SuggestedPostDeclined suggestedPostDeclined;

    @JsonProperty("suggested_post_paid")
    private final @Nullable SuggestedPostPaid suggestedPostPaid;

    @JsonProperty("suggested_post_refunded")
    private final @Nullable SuggestedPostRefunded suggestedPostRefunded;

    @JsonProperty("video_chat_scheduled")
    private final @Nullable VideoChatScheduled videoChatScheduled;

    @JsonProperty("video_chat_started")
    private final @Nullable VideoChatStarted videoChatStarted;

    @JsonProperty("video_chat_ended")
    private final @Nullable VideoChatEnded videoChatEnded;

    @JsonProperty("video_chat_participants_invited")
    private final @Nullable VideoChatParticipantsInvited videoChatParticipantsInvited;

    @JsonProperty("web_app_data")
    private final @Nullable WebAppData webAppData;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code Message} instance.
     *
     * @param messageId Unique message identifier inside this chat. In specific instances (e.g.,
     *     message containing a video sent to a big chat), the server might automatically schedule a
     *     message instead of sending it immediately. In such cases, this field will be 0 and the
     *     relevant message will be unusable until it is actually sent
     * @param messageThreadId Unique identifier of a message thread or forum topic to which the
     *     message belongs; for supergroups and private chats only
     * @param directMessagesTopic Information about the direct messages chat topic that contains the
     *     message
     * @param from Sender of the message; may be empty for messages sent to channels. For backward
     *     compatibility, if the message was sent on behalf of a chat, the field contains a fake
     *     sender user in non-channel chats
     * @param senderChat Sender of the message when sent on behalf of a chat. For example, the
     *     supergroup itself for messages sent by its anonymous administrators or a linked channel
     *     for messages automatically forwarded to the channel's discussion group. For backward
     *     compatibility, if the message was sent on behalf of a chat, the field from contains a
     *     fake sender user in non-channel chats.
     * @param senderBoostCount If the sender of the message boosted the chat, the number of boosts
     *     added by the user
     * @param senderBusinessBot The bot that actually sent the message on behalf of the business
     *     account. Available only for outgoing messages sent on behalf of the connected business
     *     account.
     * @param senderTag Tag or custom title of the sender of the message; for supergroups only
     * @param date Date the message was sent in Unix time. It is always a positive number,
     *     representing a valid date.
     * @param businessConnectionId Unique identifier of the business connection from which the
     *     message was received. If non-empty, the message belongs to a chat of the corresponding
     *     business account that is independent from any potential bot chat which might share the
     *     same identifier.
     * @param chat Chat the message belongs to
     * @param forwardOrigin Information about the original message for forwarded messages
     * @param isTopicMessage True, if the message is sent to a topic in a forum supergroup or a
     *     private chat with the bot
     * @param isAutomaticForward True, if the message is a channel post that was automatically
     *     forwarded to the connected discussion group
     * @param replyToMessage For replies in the same chat and message thread, the original message.
     *     Note that the Message object in this field will not contain further reply_to_message
     *     fields even if it itself is a reply.
     * @param externalReply Information about the message that is being replied to, which may come
     *     from another chat or forum topic
     * @param quote For replies that quote part of the original message, the quoted part of the
     *     message
     * @param replyToStory For replies to a story, the original story
     * @param replyToChecklistTaskId Identifier of the specific checklist task that is being replied
     *     to
     * @param replyToPollOptionId Persistent identifier of the specific poll option that is being
     *     replied to
     * @param viaBot Bot through which the message was sent
     * @param editDate Date the message was last edited in Unix time
     * @param hasProtectedContent True, if the message can't be forwarded
     * @param isFromOffline True, if the message was sent by an implicit action, for example, as an
     *     away or a greeting business message, or as a scheduled message
     * @param isPaidPost True, if the message is a paid post. Note that such posts must not be
     *     deleted for 24 hours to receive the payment and can't be edited.
     * @param mediaGroupId The unique identifier inside this chat of a media message group this
     *     message belongs to
     * @param authorSignature Signature of the post author for messages in channels, or the custom
     *     title of an anonymous group administrator
     * @param paidStarCount The number of Telegram Stars that were paid by the sender of the message
     *     to send it
     * @param text For text messages, the actual UTF-8 text of the message
     * @param entities For text messages, special entities like usernames, URLs, bot commands, etc.
     *     that appear in the text
     * @param linkPreviewOptions Options used for link preview generation for the message, if it is
     *     a text message and link preview options were changed
     * @param suggestedPostInfo Information about suggested post parameters if the message is a
     *     suggested post in a channel direct messages chat. If the message is an approved or
     *     declined suggested post, then it can't be edited.
     * @param effectId Unique identifier of the message effect added to the message
     * @param animation Message is an animation, information about the animation. For backward
     *     compatibility, when this field is set, the document field will also be set
     * @param audio Message is an audio file, information about the file
     * @param document Message is a general file, information about the file
     * @param paidMedia Message contains paid media; information about the paid media
     * @param photo Message is a photo, available sizes of the photo
     * @param sticker Message is a sticker, information about the sticker
     * @param story Message is a forwarded story
     * @param video Message is a video, information about the video
     * @param videoNote Message is a video note, information about the video message
     * @param voice Message is a voice message, information about the file
     * @param caption Caption for the animation, audio, document, paid media, photo, video or voice
     * @param captionEntities For messages with a caption, special entities like usernames, URLs,
     *     bot commands, etc. that appear in the caption
     * @param showCaptionAboveMedia True, if the caption must be shown above the message media
     * @param hasMediaSpoiler True, if the message media is covered by a spoiler animation
     * @param checklist Message is a checklist
     * @param contact Message is a shared contact, information about the contact
     * @param dice Message is a dice with random value
     * @param game Message is a game, information about the game.
     * @param poll Message is a native poll, information about the poll
     * @param venue Message is a venue, information about the venue. For backward compatibility,
     *     when this field is set, the location field will also be set
     * @param location Message is a shared location, information about the location
     * @param newChatMembers New members that were added to the group or supergroup and information
     *     about them (the bot itself may be one of these members)
     * @param leftChatMember A member was removed from the group, information about them (this
     *     member may be the bot itself)
     * @param chatOwnerLeft Service message: chat owner has left
     * @param chatOwnerChanged Service message: chat owner has changed
     * @param newChatTitle A chat title was changed to this value
     * @param newChatPhoto A chat photo was change to this value
     * @param deleteChatPhoto Service message: the chat photo was deleted
     * @param groupChatCreated Service message: the group has been created
     * @param supergroupChatCreated Service message: the supergroup has been created. This field
     *     can't be received in a message coming through updates, because bot can't be a member of a
     *     supergroup when it is created. It can only be found in reply_to_message if someone
     *     replies to a very first message in a directly created supergroup.
     * @param channelChatCreated Service message: the channel has been created. This field can't be
     *     received in a message coming through updates, because bot can't be a member of a channel
     *     when it is created. It can only be found in reply_to_message if someone replies to a very
     *     first message in a channel.
     * @param messageAutoDeleteTimerChanged Service message: auto-delete timer settings changed in
     *     the chat
     * @param migrateToChatId The group has been migrated to a supergroup with the specified
     *     identifier. This number may have more than 32 significant bits and some programming
     *     languages may have difficulty/silent defects in interpreting it. But it has at most 52
     *     significant bits, so a signed 64-bit integer or double-precision float type are safe for
     *     storing this identifier.
     * @param migrateFromChatId The supergroup has been migrated from a group with the specified
     *     identifier. This number may have more than 32 significant bits and some programming
     *     languages may have difficulty/silent defects in interpreting it. But it has at most 52
     *     significant bits, so a signed 64-bit integer or double-precision float type are safe for
     *     storing this identifier.
     * @param pinnedMessage Specified message was pinned. Note that the Message object in this field
     *     will not contain further reply_to_message fields even if it itself is a reply.
     * @param invoice Message is an invoice for a payment, information about the invoice.
     * @param successfulPayment Message is a service message about a successful payment, information
     *     about the payment.
     * @param refundedPayment Message is a service message about a refunded payment, information
     *     about the payment.
     * @param usersShared Service message: users were shared with the bot
     * @param chatShared Service message: a chat was shared with the bot
     * @param gift Service message: a regular gift was sent or received
     * @param uniqueGift Service message: a unique gift was sent or received
     * @param giftUpgradeSent Service message: upgrade of a gift was purchased after the gift was
     *     sent
     * @param connectedWebsite The domain name of the website on which the user has logged in.
     * @param writeAccessAllowed Service message: the user allowed the bot to write messages after
     *     adding it to the attachment or side menu, launching a Web App from a link, or accepting
     *     an explicit request from a Web App sent by the method requestWriteAccess
     * @param passportData Telegram Passport data
     * @param proximityAlertTriggered Service message. A user in the chat triggered another user's
     *     proximity alert while sharing Live Location.
     * @param boostAdded Service message: user boosted the chat
     * @param chatBackgroundSet Service message: chat background set
     * @param checklistTasksDone Service message: some tasks in a checklist were marked as done or
     *     not done
     * @param checklistTasksAdded Service message: tasks were added to a checklist
     * @param directMessagePriceChanged Service message: the price for paid messages in the
     *     corresponding direct messages chat of a channel has changed
     * @param forumTopicCreated Service message: forum topic created
     * @param forumTopicEdited Service message: forum topic edited
     * @param forumTopicClosed Service message: forum topic closed
     * @param forumTopicReopened Service message: forum topic reopened
     * @param generalForumTopicHidden Service message: the 'General' forum topic hidden
     * @param generalForumTopicUnhidden Service message: the 'General' forum topic unhidden
     * @param giveawayCreated Service message: a scheduled giveaway was created
     * @param giveaway The message is a scheduled giveaway message
     * @param giveawayWinners A giveaway with public winners was completed
     * @param giveawayCompleted Service message: a giveaway without public winners was completed
     * @param managedBotCreated Service message: user created a bot that will be managed by the
     *     current bot
     * @param paidMessagePriceChanged Service message: the price for paid messages has changed in
     *     the chat
     * @param pollOptionAdded Service message: answer option was added to a poll
     * @param pollOptionDeleted Service message: answer option was deleted from a poll
     * @param suggestedPostApproved Service message: a suggested post was approved
     * @param suggestedPostApprovalFailed Service message: approval of a suggested post has failed
     * @param suggestedPostDeclined Service message: a suggested post was declined
     * @param suggestedPostPaid Service message: payment for a suggested post was received
     * @param suggestedPostRefunded Service message: payment for a suggested post was refunded
     * @param videoChatScheduled Service message: video chat scheduled
     * @param videoChatStarted Service message: video chat started
     * @param videoChatEnded Service message: video chat ended
     * @param videoChatParticipantsInvited Service message: new participants invited to a video chat
     * @param webAppData Service message: data sent by a Web App
     * @param replyMarkup Inline keyboard attached to the message. login_url buttons are represented
     *     as ordinary url buttons.
     */
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
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
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

    public static Message of(long messageId, long date, Chat chat) {
        return new Message(messageId, null, null, null, null, null, null, null, date, null, chat, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Unique message identifier inside this chat. In specific instances (e.g., message containing a
     * video sent to a big chat), the server might automatically schedule a message instead of
     * sending it immediately. In such cases, this field will be 0 and the relevant message will be
     * unusable until it is actually sent
     */
    public long messageId() {
        return messageId;
    }

    /**
     * Unique identifier of a message thread or forum topic to which the message belongs; for
     * supergroups and private chats only
     */
    public @Nullable Long messageThreadId() {
        return messageThreadId;
    }

    /**
     * Information about the direct messages chat topic that contains the message
     */
    public @Nullable DirectMessagesTopic directMessagesTopic() {
        return directMessagesTopic;
    }

    /**
     * Sender of the message; may be empty for messages sent to channels. For backward
     * compatibility, if the message was sent on behalf of a chat, the field contains a fake sender
     * user in non-channel chats
     */
    public @Nullable User from() {
        return from;
    }

    /**
     * Sender of the message when sent on behalf of a chat. For example, the supergroup itself for
     * messages sent by its anonymous administrators or a linked channel for messages automatically
     * forwarded to the channel's discussion group. For backward compatibility, if the message was
     * sent on behalf of a chat, the field from contains a fake sender user in non-channel chats.
     */
    public @Nullable Chat senderChat() {
        return senderChat;
    }

    /**
     * If the sender of the message boosted the chat, the number of boosts added by the user
     */
    public @Nullable Long senderBoostCount() {
        return senderBoostCount;
    }

    /**
     * The bot that actually sent the message on behalf of the business account. Available only for
     * outgoing messages sent on behalf of the connected business account.
     */
    public @Nullable User senderBusinessBot() {
        return senderBusinessBot;
    }

    /**
     * Tag or custom title of the sender of the message; for supergroups only
     */
    public @Nullable String senderTag() {
        return senderTag;
    }

    /**
     * Date the message was sent in Unix time. It is always a positive number, representing a valid
     * date.
     */
    public long date() {
        return date;
    }

    /**
     * Unique identifier of the business connection from which the message was received. If
     * non-empty, the message belongs to a chat of the corresponding business account that is
     * independent from any potential bot chat which might share the same identifier.
     */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Chat the message belongs to
     */
    public Chat chat() {
        return chat;
    }

    /**
     * Information about the original message for forwarded messages
     */
    public @Nullable MessageOrigin forwardOrigin() {
        return forwardOrigin;
    }

    /**
     * True, if the message is sent to a topic in a forum supergroup or a private chat with the bot
     */
    public @Nullable Boolean isTopicMessage() {
        return isTopicMessage;
    }

    /**
     * True, if the message is a channel post that was automatically forwarded to the connected
     * discussion group
     */
    public @Nullable Boolean isAutomaticForward() {
        return isAutomaticForward;
    }

    /**
     * For replies in the same chat and message thread, the original message. Note that the Message
     * object in this field will not contain further reply_to_message fields even if it itself is a
     * reply.
     */
    public @Nullable Message replyToMessage() {
        return replyToMessage;
    }

    /**
     * Information about the message that is being replied to, which may come from another chat or
     * forum topic
     */
    public @Nullable ExternalReplyInfo externalReply() {
        return externalReply;
    }

    /**
     * For replies that quote part of the original message, the quoted part of the message
     */
    public @Nullable TextQuote quote() {
        return quote;
    }

    /**
     * For replies to a story, the original story
     */
    public @Nullable Story replyToStory() {
        return replyToStory;
    }

    /**
     * Identifier of the specific checklist task that is being replied to
     */
    public @Nullable Long replyToChecklistTaskId() {
        return replyToChecklistTaskId;
    }

    /**
     * Persistent identifier of the specific poll option that is being replied to
     */
    public @Nullable String replyToPollOptionId() {
        return replyToPollOptionId;
    }

    /**
     * Bot through which the message was sent
     */
    public @Nullable User viaBot() {
        return viaBot;
    }

    /**
     * Date the message was last edited in Unix time
     */
    public @Nullable Long editDate() {
        return editDate;
    }

    /**
     * True, if the message can't be forwarded
     */
    public @Nullable Boolean hasProtectedContent() {
        return hasProtectedContent;
    }

    /**
     * True, if the message was sent by an implicit action, for example, as an away or a greeting
     * business message, or as a scheduled message
     */
    public @Nullable Boolean isFromOffline() {
        return isFromOffline;
    }

    /**
     * True, if the message is a paid post. Note that such posts must not be deleted for 24 hours to
     * receive the payment and can't be edited.
     */
    public @Nullable Boolean isPaidPost() {
        return isPaidPost;
    }

    /**
     * The unique identifier inside this chat of a media message group this message belongs to
     */
    public @Nullable String mediaGroupId() {
        return mediaGroupId;
    }

    /**
     * Signature of the post author for messages in channels, or the custom title of an anonymous
     * group administrator
     */
    public @Nullable String authorSignature() {
        return authorSignature;
    }

    /**
     * The number of Telegram Stars that were paid by the sender of the message to send it
     */
    public @Nullable Long paidStarCount() {
        return paidStarCount;
    }

    /**
     * For text messages, the actual UTF-8 text of the message
     */
    public @Nullable String text() {
        return text;
    }

    /**
     * For text messages, special entities like usernames, URLs, bot commands, etc. that appear in
     * the text
     */
    public @Nullable List<MessageEntity> entities() {
        return entities;
    }

    /**
     * Options used for link preview generation for the message, if it is a text message and link
     * preview options were changed
     */
    public @Nullable LinkPreviewOptions linkPreviewOptions() {
        return linkPreviewOptions;
    }

    /**
     * Information about suggested post parameters if the message is a suggested post in a channel
     * direct messages chat. If the message is an approved or declined suggested post, then it can't
     * be edited.
     */
    public @Nullable SuggestedPostInfo suggestedPostInfo() {
        return suggestedPostInfo;
    }

    /**
     * Unique identifier of the message effect added to the message
     */
    public @Nullable String effectId() {
        return effectId;
    }

    /**
     * Message is an animation, information about the animation. For backward compatibility, when
     * this field is set, the document field will also be set
     */
    public @Nullable Animation animation() {
        return animation;
    }

    /**
     * Message is an audio file, information about the file
     */
    public @Nullable Audio audio() {
        return audio;
    }

    /**
     * Message is a general file, information about the file
     */
    public @Nullable Document document() {
        return document;
    }

    /**
     * Message contains paid media; information about the paid media
     */
    public @Nullable PaidMediaInfo paidMedia() {
        return paidMedia;
    }

    /**
     * Message is a photo, available sizes of the photo
     */
    public @Nullable List<PhotoSize> photo() {
        return photo;
    }

    /**
     * Message is a sticker, information about the sticker
     */
    public @Nullable Sticker sticker() {
        return sticker;
    }

    /**
     * Message is a forwarded story
     */
    public @Nullable Story story() {
        return story;
    }

    /**
     * Message is a video, information about the video
     */
    public @Nullable Video video() {
        return video;
    }

    /**
     * Message is a video note, information about the video message
     */
    public @Nullable VideoNote videoNote() {
        return videoNote;
    }

    /**
     * Message is a voice message, information about the file
     */
    public @Nullable Voice voice() {
        return voice;
    }

    /**
     * Caption for the animation, audio, document, paid media, photo, video or voice
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * For messages with a caption, special entities like usernames, URLs, bot commands, etc. that
     * appear in the caption
     */
    public @Nullable List<MessageEntity> captionEntities() {
        return captionEntities;
    }

    /**
     * True, if the caption must be shown above the message media
     */
    public @Nullable Boolean showCaptionAboveMedia() {
        return showCaptionAboveMedia;
    }

    /**
     * True, if the message media is covered by a spoiler animation
     */
    public @Nullable Boolean hasMediaSpoiler() {
        return hasMediaSpoiler;
    }

    /**
     * Message is a checklist
     */
    public @Nullable Checklist checklist() {
        return checklist;
    }

    /**
     * Message is a shared contact, information about the contact
     */
    public @Nullable Contact contact() {
        return contact;
    }

    /**
     * Message is a dice with random value
     */
    public @Nullable Dice dice() {
        return dice;
    }

    /**
     * Message is a game, information about the game.
     */
    public @Nullable Game game() {
        return game;
    }

    /**
     * Message is a native poll, information about the poll
     */
    public @Nullable Poll poll() {
        return poll;
    }

    /**
     * Message is a venue, information about the venue. For backward compatibility, when this field
     * is set, the location field will also be set
     */
    public @Nullable Venue venue() {
        return venue;
    }

    /**
     * Message is a shared location, information about the location
     */
    public @Nullable Location location() {
        return location;
    }

    /**
     * New members that were added to the group or supergroup and information about them (the bot
     * itself may be one of these members)
     */
    public @Nullable List<User> newChatMembers() {
        return newChatMembers;
    }

    /**
     * A member was removed from the group, information about them (this member may be the bot
     * itself)
     */
    public @Nullable User leftChatMember() {
        return leftChatMember;
    }

    /**
     * Service message: chat owner has left
     */
    public @Nullable ChatOwnerLeft chatOwnerLeft() {
        return chatOwnerLeft;
    }

    /**
     * Service message: chat owner has changed
     */
    public @Nullable ChatOwnerChanged chatOwnerChanged() {
        return chatOwnerChanged;
    }

    /**
     * A chat title was changed to this value
     */
    public @Nullable String newChatTitle() {
        return newChatTitle;
    }

    /**
     * A chat photo was change to this value
     */
    public @Nullable List<PhotoSize> newChatPhoto() {
        return newChatPhoto;
    }

    /**
     * Service message: the chat photo was deleted
     */
    public @Nullable Boolean deleteChatPhoto() {
        return deleteChatPhoto;
    }

    /**
     * Service message: the group has been created
     */
    public @Nullable Boolean groupChatCreated() {
        return groupChatCreated;
    }

    /**
     * Service message: the supergroup has been created. This field can't be received in a message
     * coming through updates, because bot can't be a member of a supergroup when it is created. It
     * can only be found in reply_to_message if someone replies to a very first message in a
     * directly created supergroup.
     */
    public @Nullable Boolean supergroupChatCreated() {
        return supergroupChatCreated;
    }

    /**
     * Service message: the channel has been created. This field can't be received in a message
     * coming through updates, because bot can't be a member of a channel when it is created. It can
     * only be found in reply_to_message if someone replies to a very first message in a channel.
     */
    public @Nullable Boolean channelChatCreated() {
        return channelChatCreated;
    }

    /**
     * Service message: auto-delete timer settings changed in the chat
     */
    public @Nullable MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged() {
        return messageAutoDeleteTimerChanged;
    }

    /**
     * The group has been migrated to a supergroup with the specified identifier. This number may
     * have more than 32 significant bits and some programming languages may have difficulty/silent
     * defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit
     * integer or double-precision float type are safe for storing this identifier.
     */
    public @Nullable Long migrateToChatId() {
        return migrateToChatId;
    }

    /**
     * The supergroup has been migrated from a group with the specified identifier. This number may
     * have more than 32 significant bits and some programming languages may have difficulty/silent
     * defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit
     * integer or double-precision float type are safe for storing this identifier.
     */
    public @Nullable Long migrateFromChatId() {
        return migrateFromChatId;
    }

    /**
     * Specified message was pinned. Note that the Message object in this field will not contain
     * further reply_to_message fields even if it itself is a reply.
     */
    public @Nullable MaybeInaccessibleMessage pinnedMessage() {
        return pinnedMessage;
    }

    /**
     * Message is an invoice for a payment, information about the invoice.
     */
    public @Nullable Invoice invoice() {
        return invoice;
    }

    /**
     * Message is a service message about a successful payment, information about the payment.
     */
    public @Nullable SuccessfulPayment successfulPayment() {
        return successfulPayment;
    }

    /**
     * Message is a service message about a refunded payment, information about the payment.
     */
    public @Nullable RefundedPayment refundedPayment() {
        return refundedPayment;
    }

    /**
     * Service message: users were shared with the bot
     */
    public @Nullable UsersShared usersShared() {
        return usersShared;
    }

    /**
     * Service message: a chat was shared with the bot
     */
    public @Nullable ChatShared chatShared() {
        return chatShared;
    }

    /**
     * Service message: a regular gift was sent or received
     */
    public @Nullable GiftInfo gift() {
        return gift;
    }

    /**
     * Service message: a unique gift was sent or received
     */
    public @Nullable UniqueGiftInfo uniqueGift() {
        return uniqueGift;
    }

    /**
     * Service message: upgrade of a gift was purchased after the gift was sent
     */
    public @Nullable GiftInfo giftUpgradeSent() {
        return giftUpgradeSent;
    }

    /**
     * The domain name of the website on which the user has logged in.
     */
    public @Nullable String connectedWebsite() {
        return connectedWebsite;
    }

    /**
     * Service message: the user allowed the bot to write messages after adding it to the attachment
     * or side menu, launching a Web App from a link, or accepting an explicit request from a Web
     * App sent by the method requestWriteAccess
     */
    public @Nullable WriteAccessAllowed writeAccessAllowed() {
        return writeAccessAllowed;
    }

    /**
     * Telegram Passport data
     */
    public @Nullable PassportData passportData() {
        return passportData;
    }

    /**
     * Service message. A user in the chat triggered another user's proximity alert while sharing
     * Live Location.
     */
    public @Nullable ProximityAlertTriggered proximityAlertTriggered() {
        return proximityAlertTriggered;
    }

    /**
     * Service message: user boosted the chat
     */
    public @Nullable ChatBoostAdded boostAdded() {
        return boostAdded;
    }

    /**
     * Service message: chat background set
     */
    public @Nullable ChatBackground chatBackgroundSet() {
        return chatBackgroundSet;
    }

    /**
     * Service message: some tasks in a checklist were marked as done or not done
     */
    public @Nullable ChecklistTasksDone checklistTasksDone() {
        return checklistTasksDone;
    }

    /**
     * Service message: tasks were added to a checklist
     */
    public @Nullable ChecklistTasksAdded checklistTasksAdded() {
        return checklistTasksAdded;
    }

    /**
     * Service message: the price for paid messages in the corresponding direct messages chat of a
     * channel has changed
     */
    public @Nullable DirectMessagePriceChanged directMessagePriceChanged() {
        return directMessagePriceChanged;
    }

    /**
     * Service message: forum topic created
     */
    public @Nullable ForumTopicCreated forumTopicCreated() {
        return forumTopicCreated;
    }

    /**
     * Service message: forum topic edited
     */
    public @Nullable ForumTopicEdited forumTopicEdited() {
        return forumTopicEdited;
    }

    /**
     * Service message: forum topic closed
     */
    public @Nullable ForumTopicClosed forumTopicClosed() {
        return forumTopicClosed;
    }

    /**
     * Service message: forum topic reopened
     */
    public @Nullable ForumTopicReopened forumTopicReopened() {
        return forumTopicReopened;
    }

    /**
     * Service message: the 'General' forum topic hidden
     */
    public @Nullable GeneralForumTopicHidden generalForumTopicHidden() {
        return generalForumTopicHidden;
    }

    /**
     * Service message: the 'General' forum topic unhidden
     */
    public @Nullable GeneralForumTopicUnhidden generalForumTopicUnhidden() {
        return generalForumTopicUnhidden;
    }

    /**
     * Service message: a scheduled giveaway was created
     */
    public @Nullable GiveawayCreated giveawayCreated() {
        return giveawayCreated;
    }

    /**
     * The message is a scheduled giveaway message
     */
    public @Nullable Giveaway giveaway() {
        return giveaway;
    }

    /**
     * A giveaway with public winners was completed
     */
    public @Nullable GiveawayWinners giveawayWinners() {
        return giveawayWinners;
    }

    /**
     * Service message: a giveaway without public winners was completed
     */
    public @Nullable GiveawayCompleted giveawayCompleted() {
        return giveawayCompleted;
    }

    /**
     * Service message: user created a bot that will be managed by the current bot
     */
    public @Nullable ManagedBotCreated managedBotCreated() {
        return managedBotCreated;
    }

    /**
     * Service message: the price for paid messages has changed in the chat
     */
    public @Nullable PaidMessagePriceChanged paidMessagePriceChanged() {
        return paidMessagePriceChanged;
    }

    /**
     * Service message: answer option was added to a poll
     */
    public @Nullable PollOptionAdded pollOptionAdded() {
        return pollOptionAdded;
    }

    /**
     * Service message: answer option was deleted from a poll
     */
    public @Nullable PollOptionDeleted pollOptionDeleted() {
        return pollOptionDeleted;
    }

    /**
     * Service message: a suggested post was approved
     */
    public @Nullable SuggestedPostApproved suggestedPostApproved() {
        return suggestedPostApproved;
    }

    /**
     * Service message: approval of a suggested post has failed
     */
    public @Nullable SuggestedPostApprovalFailed suggestedPostApprovalFailed() {
        return suggestedPostApprovalFailed;
    }

    /**
     * Service message: a suggested post was declined
     */
    public @Nullable SuggestedPostDeclined suggestedPostDeclined() {
        return suggestedPostDeclined;
    }

    /**
     * Service message: payment for a suggested post was received
     */
    public @Nullable SuggestedPostPaid suggestedPostPaid() {
        return suggestedPostPaid;
    }

    /**
     * Service message: payment for a suggested post was refunded
     */
    public @Nullable SuggestedPostRefunded suggestedPostRefunded() {
        return suggestedPostRefunded;
    }

    /**
     * Service message: video chat scheduled
     */
    public @Nullable VideoChatScheduled videoChatScheduled() {
        return videoChatScheduled;
    }

    /**
     * Service message: video chat started
     */
    public @Nullable VideoChatStarted videoChatStarted() {
        return videoChatStarted;
    }

    /**
     * Service message: video chat ended
     */
    public @Nullable VideoChatEnded videoChatEnded() {
        return videoChatEnded;
    }

    /**
     * Service message: new participants invited to a video chat
     */
    public @Nullable VideoChatParticipantsInvited videoChatParticipantsInvited() {
        return videoChatParticipantsInvited;
    }

    /**
     * Service message: data sent by a Web App
     */
    public @Nullable WebAppData webAppData() {
        return webAppData;
    }

    /**
     * Inline keyboard attached to the message. login_url buttons are represented as ordinary url
     * buttons.
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    public Message withMessageId(long messageId) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withMessageThreadId(@Nullable Long messageThreadId) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withDirectMessagesTopic(@Nullable DirectMessagesTopic directMessagesTopic) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withFrom(@Nullable User from) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSenderChat(@Nullable Chat senderChat) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSenderBoostCount(@Nullable Long senderBoostCount) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSenderBusinessBot(@Nullable User senderBusinessBot) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSenderTag(@Nullable String senderTag) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withDate(long date) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withChat(Chat chat) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withForwardOrigin(@Nullable MessageOrigin forwardOrigin) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withIsTopicMessage(@Nullable Boolean isTopicMessage) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withIsAutomaticForward(@Nullable Boolean isAutomaticForward) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withReplyToMessage(@Nullable Message replyToMessage) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withExternalReply(@Nullable ExternalReplyInfo externalReply) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withQuote(@Nullable TextQuote quote) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withReplyToStory(@Nullable Story replyToStory) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withReplyToChecklistTaskId(@Nullable Long replyToChecklistTaskId) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withReplyToPollOptionId(@Nullable String replyToPollOptionId) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withViaBot(@Nullable User viaBot) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withEditDate(@Nullable Long editDate) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withHasProtectedContent(@Nullable Boolean hasProtectedContent) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withIsFromOffline(@Nullable Boolean isFromOffline) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withIsPaidPost(@Nullable Boolean isPaidPost) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withMediaGroupId(@Nullable String mediaGroupId) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withAuthorSignature(@Nullable String authorSignature) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withPaidStarCount(@Nullable Long paidStarCount) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withText(@Nullable String text) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withEntities(@Nullable List<MessageEntity> entities) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withLinkPreviewOptions(@Nullable LinkPreviewOptions linkPreviewOptions) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSuggestedPostInfo(@Nullable SuggestedPostInfo suggestedPostInfo) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withEffectId(@Nullable String effectId) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withAnimation(@Nullable Animation animation) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withAudio(@Nullable Audio audio) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withDocument(@Nullable Document document) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withPaidMedia(@Nullable PaidMediaInfo paidMedia) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withPhoto(@Nullable List<PhotoSize> photo) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSticker(@Nullable Sticker sticker) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withStory(@Nullable Story story) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withVideo(@Nullable Video video) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withVideoNote(@Nullable VideoNote videoNote) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withVoice(@Nullable Voice voice) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withCaption(@Nullable String caption) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withHasMediaSpoiler(@Nullable Boolean hasMediaSpoiler) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withChecklist(@Nullable Checklist checklist) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withContact(@Nullable Contact contact) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withDice(@Nullable Dice dice) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withGame(@Nullable Game game) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withPoll(@Nullable Poll poll) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withVenue(@Nullable Venue venue) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withLocation(@Nullable Location location) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withNewChatMembers(@Nullable List<User> newChatMembers) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withLeftChatMember(@Nullable User leftChatMember) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withChatOwnerLeft(@Nullable ChatOwnerLeft chatOwnerLeft) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withChatOwnerChanged(@Nullable ChatOwnerChanged chatOwnerChanged) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withNewChatTitle(@Nullable String newChatTitle) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withNewChatPhoto(@Nullable List<PhotoSize> newChatPhoto) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withDeleteChatPhoto(@Nullable Boolean deleteChatPhoto) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withGroupChatCreated(@Nullable Boolean groupChatCreated) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSupergroupChatCreated(@Nullable Boolean supergroupChatCreated) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withChannelChatCreated(@Nullable Boolean channelChatCreated) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withMessageAutoDeleteTimerChanged(@Nullable MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withMigrateToChatId(@Nullable Long migrateToChatId) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withMigrateFromChatId(@Nullable Long migrateFromChatId) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withPinnedMessage(@Nullable MaybeInaccessibleMessage pinnedMessage) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withInvoice(@Nullable Invoice invoice) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSuccessfulPayment(@Nullable SuccessfulPayment successfulPayment) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withRefundedPayment(@Nullable RefundedPayment refundedPayment) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withUsersShared(@Nullable UsersShared usersShared) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withChatShared(@Nullable ChatShared chatShared) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withGift(@Nullable GiftInfo gift) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withUniqueGift(@Nullable UniqueGiftInfo uniqueGift) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withGiftUpgradeSent(@Nullable GiftInfo giftUpgradeSent) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withConnectedWebsite(@Nullable String connectedWebsite) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withWriteAccessAllowed(@Nullable WriteAccessAllowed writeAccessAllowed) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withPassportData(@Nullable PassportData passportData) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withProximityAlertTriggered(@Nullable ProximityAlertTriggered proximityAlertTriggered) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withBoostAdded(@Nullable ChatBoostAdded boostAdded) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withChatBackgroundSet(@Nullable ChatBackground chatBackgroundSet) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withChecklistTasksDone(@Nullable ChecklistTasksDone checklistTasksDone) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withChecklistTasksAdded(@Nullable ChecklistTasksAdded checklistTasksAdded) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withDirectMessagePriceChanged(@Nullable DirectMessagePriceChanged directMessagePriceChanged) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withForumTopicCreated(@Nullable ForumTopicCreated forumTopicCreated) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withForumTopicEdited(@Nullable ForumTopicEdited forumTopicEdited) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withForumTopicClosed(@Nullable ForumTopicClosed forumTopicClosed) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withForumTopicReopened(@Nullable ForumTopicReopened forumTopicReopened) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withGeneralForumTopicHidden(@Nullable GeneralForumTopicHidden generalForumTopicHidden) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withGeneralForumTopicUnhidden(@Nullable GeneralForumTopicUnhidden generalForumTopicUnhidden) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withGiveawayCreated(@Nullable GiveawayCreated giveawayCreated) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withGiveaway(@Nullable Giveaway giveaway) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withGiveawayWinners(@Nullable GiveawayWinners giveawayWinners) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withGiveawayCompleted(@Nullable GiveawayCompleted giveawayCompleted) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withManagedBotCreated(@Nullable ManagedBotCreated managedBotCreated) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withPaidMessagePriceChanged(@Nullable PaidMessagePriceChanged paidMessagePriceChanged) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withPollOptionAdded(@Nullable PollOptionAdded pollOptionAdded) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withPollOptionDeleted(@Nullable PollOptionDeleted pollOptionDeleted) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSuggestedPostApproved(@Nullable SuggestedPostApproved suggestedPostApproved) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSuggestedPostApprovalFailed(@Nullable SuggestedPostApprovalFailed suggestedPostApprovalFailed) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSuggestedPostDeclined(@Nullable SuggestedPostDeclined suggestedPostDeclined) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSuggestedPostPaid(@Nullable SuggestedPostPaid suggestedPostPaid) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withSuggestedPostRefunded(@Nullable SuggestedPostRefunded suggestedPostRefunded) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withVideoChatScheduled(@Nullable VideoChatScheduled videoChatScheduled) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withVideoChatStarted(@Nullable VideoChatStarted videoChatStarted) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withVideoChatEnded(@Nullable VideoChatEnded videoChatEnded) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withVideoChatParticipantsInvited(@Nullable VideoChatParticipantsInvited videoChatParticipantsInvited) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withWebAppData(@Nullable WebAppData webAppData) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    public Message withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new Message(messageId, messageThreadId, directMessagesTopic, from, senderChat, senderBoostCount, senderBusinessBot, senderTag, date, businessConnectionId, chat, forwardOrigin, isTopicMessage, isAutomaticForward, replyToMessage, externalReply, quote, replyToStory, replyToChecklistTaskId, replyToPollOptionId, viaBot, editDate, hasProtectedContent, isFromOffline, isPaidPost, mediaGroupId, authorSignature, paidStarCount, text, entities, linkPreviewOptions, suggestedPostInfo, effectId, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, caption, captionEntities, showCaptionAboveMedia, hasMediaSpoiler, checklist, contact, dice, game, poll, venue, location, newChatMembers, leftChatMember, chatOwnerLeft, chatOwnerChanged, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated, supergroupChatCreated, channelChatCreated, messageAutoDeleteTimerChanged, migrateToChatId, migrateFromChatId, pinnedMessage, invoice, successfulPayment, refundedPayment, usersShared, chatShared, gift, uniqueGift, giftUpgradeSent, connectedWebsite, writeAccessAllowed, passportData, proximityAlertTriggered, boostAdded, chatBackgroundSet, checklistTasksDone, checklistTasksAdded, directMessagePriceChanged, forumTopicCreated, forumTopicEdited, forumTopicClosed, forumTopicReopened, generalForumTopicHidden, generalForumTopicUnhidden, giveawayCreated, giveaway, giveawayWinners, giveawayCompleted, managedBotCreated, paidMessagePriceChanged, pollOptionAdded, pollOptionDeleted, suggestedPostApproved, suggestedPostApprovalFailed, suggestedPostDeclined, suggestedPostPaid, suggestedPostRefunded, videoChatScheduled, videoChatStarted, videoChatEnded, videoChatParticipantsInvited, webAppData, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Message)) {
            return false;
        }
        Message that = (Message) o;
        return this.messageId == that.messageId
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopic, that.directMessagesTopic)
                && Objects.equals(this.from, that.from)
                && Objects.equals(this.senderChat, that.senderChat)
                && Objects.equals(this.senderBoostCount, that.senderBoostCount)
                && Objects.equals(this.senderBusinessBot, that.senderBusinessBot)
                && Objects.equals(this.senderTag, that.senderTag)
                && this.date == that.date
                && Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chat, that.chat)
                && Objects.equals(this.forwardOrigin, that.forwardOrigin)
                && Objects.equals(this.isTopicMessage, that.isTopicMessage)
                && Objects.equals(this.isAutomaticForward, that.isAutomaticForward)
                && Objects.equals(this.replyToMessage, that.replyToMessage)
                && Objects.equals(this.externalReply, that.externalReply)
                && Objects.equals(this.quote, that.quote)
                && Objects.equals(this.replyToStory, that.replyToStory)
                && Objects.equals(this.replyToChecklistTaskId, that.replyToChecklistTaskId)
                && Objects.equals(this.replyToPollOptionId, that.replyToPollOptionId)
                && Objects.equals(this.viaBot, that.viaBot)
                && Objects.equals(this.editDate, that.editDate)
                && Objects.equals(this.hasProtectedContent, that.hasProtectedContent)
                && Objects.equals(this.isFromOffline, that.isFromOffline)
                && Objects.equals(this.isPaidPost, that.isPaidPost)
                && Objects.equals(this.mediaGroupId, that.mediaGroupId)
                && Objects.equals(this.authorSignature, that.authorSignature)
                && Objects.equals(this.paidStarCount, that.paidStarCount)
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.entities, that.entities)
                && Objects.equals(this.linkPreviewOptions, that.linkPreviewOptions)
                && Objects.equals(this.suggestedPostInfo, that.suggestedPostInfo)
                && Objects.equals(this.effectId, that.effectId)
                && Objects.equals(this.animation, that.animation)
                && Objects.equals(this.audio, that.audio)
                && Objects.equals(this.document, that.document)
                && Objects.equals(this.paidMedia, that.paidMedia)
                && Objects.equals(this.photo, that.photo)
                && Objects.equals(this.sticker, that.sticker)
                && Objects.equals(this.story, that.story)
                && Objects.equals(this.video, that.video)
                && Objects.equals(this.videoNote, that.videoNote)
                && Objects.equals(this.voice, that.voice)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.hasMediaSpoiler, that.hasMediaSpoiler)
                && Objects.equals(this.checklist, that.checklist)
                && Objects.equals(this.contact, that.contact)
                && Objects.equals(this.dice, that.dice)
                && Objects.equals(this.game, that.game)
                && Objects.equals(this.poll, that.poll)
                && Objects.equals(this.venue, that.venue)
                && Objects.equals(this.location, that.location)
                && Objects.equals(this.newChatMembers, that.newChatMembers)
                && Objects.equals(this.leftChatMember, that.leftChatMember)
                && Objects.equals(this.chatOwnerLeft, that.chatOwnerLeft)
                && Objects.equals(this.chatOwnerChanged, that.chatOwnerChanged)
                && Objects.equals(this.newChatTitle, that.newChatTitle)
                && Objects.equals(this.newChatPhoto, that.newChatPhoto)
                && Objects.equals(this.deleteChatPhoto, that.deleteChatPhoto)
                && Objects.equals(this.groupChatCreated, that.groupChatCreated)
                && Objects.equals(this.supergroupChatCreated, that.supergroupChatCreated)
                && Objects.equals(this.channelChatCreated, that.channelChatCreated)
                && Objects.equals(this.messageAutoDeleteTimerChanged, that.messageAutoDeleteTimerChanged)
                && Objects.equals(this.migrateToChatId, that.migrateToChatId)
                && Objects.equals(this.migrateFromChatId, that.migrateFromChatId)
                && Objects.equals(this.pinnedMessage, that.pinnedMessage)
                && Objects.equals(this.invoice, that.invoice)
                && Objects.equals(this.successfulPayment, that.successfulPayment)
                && Objects.equals(this.refundedPayment, that.refundedPayment)
                && Objects.equals(this.usersShared, that.usersShared)
                && Objects.equals(this.chatShared, that.chatShared)
                && Objects.equals(this.gift, that.gift)
                && Objects.equals(this.uniqueGift, that.uniqueGift)
                && Objects.equals(this.giftUpgradeSent, that.giftUpgradeSent)
                && Objects.equals(this.connectedWebsite, that.connectedWebsite)
                && Objects.equals(this.writeAccessAllowed, that.writeAccessAllowed)
                && Objects.equals(this.passportData, that.passportData)
                && Objects.equals(this.proximityAlertTriggered, that.proximityAlertTriggered)
                && Objects.equals(this.boostAdded, that.boostAdded)
                && Objects.equals(this.chatBackgroundSet, that.chatBackgroundSet)
                && Objects.equals(this.checklistTasksDone, that.checklistTasksDone)
                && Objects.equals(this.checklistTasksAdded, that.checklistTasksAdded)
                && Objects.equals(this.directMessagePriceChanged, that.directMessagePriceChanged)
                && Objects.equals(this.forumTopicCreated, that.forumTopicCreated)
                && Objects.equals(this.forumTopicEdited, that.forumTopicEdited)
                && Objects.equals(this.forumTopicClosed, that.forumTopicClosed)
                && Objects.equals(this.forumTopicReopened, that.forumTopicReopened)
                && Objects.equals(this.generalForumTopicHidden, that.generalForumTopicHidden)
                && Objects.equals(this.generalForumTopicUnhidden, that.generalForumTopicUnhidden)
                && Objects.equals(this.giveawayCreated, that.giveawayCreated)
                && Objects.equals(this.giveaway, that.giveaway)
                && Objects.equals(this.giveawayWinners, that.giveawayWinners)
                && Objects.equals(this.giveawayCompleted, that.giveawayCompleted)
                && Objects.equals(this.managedBotCreated, that.managedBotCreated)
                && Objects.equals(this.paidMessagePriceChanged, that.paidMessagePriceChanged)
                && Objects.equals(this.pollOptionAdded, that.pollOptionAdded)
                && Objects.equals(this.pollOptionDeleted, that.pollOptionDeleted)
                && Objects.equals(this.suggestedPostApproved, that.suggestedPostApproved)
                && Objects.equals(this.suggestedPostApprovalFailed, that.suggestedPostApprovalFailed)
                && Objects.equals(this.suggestedPostDeclined, that.suggestedPostDeclined)
                && Objects.equals(this.suggestedPostPaid, that.suggestedPostPaid)
                && Objects.equals(this.suggestedPostRefunded, that.suggestedPostRefunded)
                && Objects.equals(this.videoChatScheduled, that.videoChatScheduled)
                && Objects.equals(this.videoChatStarted, that.videoChatStarted)
                && Objects.equals(this.videoChatEnded, that.videoChatEnded)
                && Objects.equals(this.videoChatParticipantsInvited, that.videoChatParticipantsInvited)
                && Objects.equals(this.webAppData, that.webAppData)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.messageId, this.messageThreadId, this.directMessagesTopic, this.from, this.senderChat, this.senderBoostCount, this.senderBusinessBot, this.senderTag, this.date, this.businessConnectionId, this.chat, this.forwardOrigin, this.isTopicMessage, this.isAutomaticForward, this.replyToMessage, this.externalReply, this.quote, this.replyToStory, this.replyToChecklistTaskId, this.replyToPollOptionId, this.viaBot, this.editDate, this.hasProtectedContent, this.isFromOffline, this.isPaidPost, this.mediaGroupId, this.authorSignature, this.paidStarCount, this.text, this.entities, this.linkPreviewOptions, this.suggestedPostInfo, this.effectId, this.animation, this.audio, this.document, this.paidMedia, this.photo, this.sticker, this.story, this.video, this.videoNote, this.voice, this.caption, this.captionEntities, this.showCaptionAboveMedia, this.hasMediaSpoiler, this.checklist, this.contact, this.dice, this.game, this.poll, this.venue, this.location, this.newChatMembers, this.leftChatMember, this.chatOwnerLeft, this.chatOwnerChanged, this.newChatTitle, this.newChatPhoto, this.deleteChatPhoto, this.groupChatCreated, this.supergroupChatCreated, this.channelChatCreated, this.messageAutoDeleteTimerChanged, this.migrateToChatId, this.migrateFromChatId, this.pinnedMessage, this.invoice, this.successfulPayment, this.refundedPayment, this.usersShared, this.chatShared, this.gift, this.uniqueGift, this.giftUpgradeSent, this.connectedWebsite, this.writeAccessAllowed, this.passportData, this.proximityAlertTriggered, this.boostAdded, this.chatBackgroundSet, this.checklistTasksDone, this.checklistTasksAdded, this.directMessagePriceChanged, this.forumTopicCreated, this.forumTopicEdited, this.forumTopicClosed, this.forumTopicReopened, this.generalForumTopicHidden, this.generalForumTopicUnhidden, this.giveawayCreated, this.giveaway, this.giveawayWinners, this.giveawayCompleted, this.managedBotCreated, this.paidMessagePriceChanged, this.pollOptionAdded, this.pollOptionDeleted, this.suggestedPostApproved, this.suggestedPostApprovalFailed, this.suggestedPostDeclined, this.suggestedPostPaid, this.suggestedPostRefunded, this.videoChatScheduled, this.videoChatStarted, this.videoChatEnded, this.videoChatParticipantsInvited, this.webAppData, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "Message[messageId=" + this.messageId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopic=" + this.directMessagesTopic
                + ", from=" + this.from
                + ", senderChat=" + this.senderChat
                + ", senderBoostCount=" + this.senderBoostCount
                + ", senderBusinessBot=" + this.senderBusinessBot
                + ", senderTag=" + this.senderTag
                + ", date=" + this.date
                + ", businessConnectionId=" + this.businessConnectionId
                + ", chat=" + this.chat
                + ", forwardOrigin=" + this.forwardOrigin
                + ", isTopicMessage=" + this.isTopicMessage
                + ", isAutomaticForward=" + this.isAutomaticForward
                + ", replyToMessage=" + this.replyToMessage
                + ", externalReply=" + this.externalReply
                + ", quote=" + this.quote
                + ", replyToStory=" + this.replyToStory
                + ", replyToChecklistTaskId=" + this.replyToChecklistTaskId
                + ", replyToPollOptionId=" + this.replyToPollOptionId
                + ", viaBot=" + this.viaBot
                + ", editDate=" + this.editDate
                + ", hasProtectedContent=" + this.hasProtectedContent
                + ", isFromOffline=" + this.isFromOffline
                + ", isPaidPost=" + this.isPaidPost
                + ", mediaGroupId=" + this.mediaGroupId
                + ", authorSignature=" + this.authorSignature
                + ", paidStarCount=" + this.paidStarCount
                + ", text=" + this.text
                + ", entities=" + this.entities
                + ", linkPreviewOptions=" + this.linkPreviewOptions
                + ", suggestedPostInfo=" + this.suggestedPostInfo
                + ", effectId=" + this.effectId
                + ", animation=" + this.animation
                + ", audio=" + this.audio
                + ", document=" + this.document
                + ", paidMedia=" + this.paidMedia
                + ", photo=" + this.photo
                + ", sticker=" + this.sticker
                + ", story=" + this.story
                + ", video=" + this.video
                + ", videoNote=" + this.videoNote
                + ", voice=" + this.voice
                + ", caption=" + this.caption
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", hasMediaSpoiler=" + this.hasMediaSpoiler
                + ", checklist=" + this.checklist
                + ", contact=" + this.contact
                + ", dice=" + this.dice
                + ", game=" + this.game
                + ", poll=" + this.poll
                + ", venue=" + this.venue
                + ", location=" + this.location
                + ", newChatMembers=" + this.newChatMembers
                + ", leftChatMember=" + this.leftChatMember
                + ", chatOwnerLeft=" + this.chatOwnerLeft
                + ", chatOwnerChanged=" + this.chatOwnerChanged
                + ", newChatTitle=" + this.newChatTitle
                + ", newChatPhoto=" + this.newChatPhoto
                + ", deleteChatPhoto=" + this.deleteChatPhoto
                + ", groupChatCreated=" + this.groupChatCreated
                + ", supergroupChatCreated=" + this.supergroupChatCreated
                + ", channelChatCreated=" + this.channelChatCreated
                + ", messageAutoDeleteTimerChanged=" + this.messageAutoDeleteTimerChanged
                + ", migrateToChatId=" + this.migrateToChatId
                + ", migrateFromChatId=" + this.migrateFromChatId
                + ", pinnedMessage=" + this.pinnedMessage
                + ", invoice=" + this.invoice
                + ", successfulPayment=" + this.successfulPayment
                + ", refundedPayment=" + this.refundedPayment
                + ", usersShared=" + this.usersShared
                + ", chatShared=" + this.chatShared
                + ", gift=" + this.gift
                + ", uniqueGift=" + this.uniqueGift
                + ", giftUpgradeSent=" + this.giftUpgradeSent
                + ", connectedWebsite=" + this.connectedWebsite
                + ", writeAccessAllowed=" + this.writeAccessAllowed
                + ", passportData=" + this.passportData
                + ", proximityAlertTriggered=" + this.proximityAlertTriggered
                + ", boostAdded=" + this.boostAdded
                + ", chatBackgroundSet=" + this.chatBackgroundSet
                + ", checklistTasksDone=" + this.checklistTasksDone
                + ", checklistTasksAdded=" + this.checklistTasksAdded
                + ", directMessagePriceChanged=" + this.directMessagePriceChanged
                + ", forumTopicCreated=" + this.forumTopicCreated
                + ", forumTopicEdited=" + this.forumTopicEdited
                + ", forumTopicClosed=" + this.forumTopicClosed
                + ", forumTopicReopened=" + this.forumTopicReopened
                + ", generalForumTopicHidden=" + this.generalForumTopicHidden
                + ", generalForumTopicUnhidden=" + this.generalForumTopicUnhidden
                + ", giveawayCreated=" + this.giveawayCreated
                + ", giveaway=" + this.giveaway
                + ", giveawayWinners=" + this.giveawayWinners
                + ", giveawayCompleted=" + this.giveawayCompleted
                + ", managedBotCreated=" + this.managedBotCreated
                + ", paidMessagePriceChanged=" + this.paidMessagePriceChanged
                + ", pollOptionAdded=" + this.pollOptionAdded
                + ", pollOptionDeleted=" + this.pollOptionDeleted
                + ", suggestedPostApproved=" + this.suggestedPostApproved
                + ", suggestedPostApprovalFailed=" + this.suggestedPostApprovalFailed
                + ", suggestedPostDeclined=" + this.suggestedPostDeclined
                + ", suggestedPostPaid=" + this.suggestedPostPaid
                + ", suggestedPostRefunded=" + this.suggestedPostRefunded
                + ", videoChatScheduled=" + this.videoChatScheduled
                + ", videoChatStarted=" + this.videoChatStarted
                + ", videoChatEnded=" + this.videoChatEnded
                + ", videoChatParticipantsInvited=" + this.videoChatParticipantsInvited
                + ", webAppData=" + this.webAppData
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
