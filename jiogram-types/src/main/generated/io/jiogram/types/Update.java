package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessConnection;
import io.jiogram.types.BusinessMessagesDeleted;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.ChatBoostRemoved;
import io.jiogram.types.ChatBoostUpdated;
import io.jiogram.types.ChatJoinRequest;
import io.jiogram.types.ChatMemberUpdated;
import io.jiogram.types.ChosenInlineResult;
import io.jiogram.types.InlineQuery;
import io.jiogram.types.ManagedBotUpdated;
import io.jiogram.types.Message;
import io.jiogram.types.MessageReactionCountUpdated;
import io.jiogram.types.MessageReactionUpdated;
import io.jiogram.types.PaidMediaPurchased;
import io.jiogram.types.Poll;
import io.jiogram.types.PollAnswer;
import io.jiogram.types.PreCheckoutQuery;
import io.jiogram.types.ShippingQuery;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an incoming update.
 * <br>At most one of the optional parameters can be present in any given update.
 *
 * @param updateId The update's unique identifier. Update identifiers start from a certain positive
 *     number and increase sequentially. This identifier becomes especially handy if you're using
 *     webhooks, since it allows you to ignore repeated updates or to restore the correct update
 *     sequence, should they get out of order. If there are no new updates for at least a week, then
 *     identifier of the next update will be chosen randomly instead of sequentially.
 * @param message New incoming message of any kind - text, photo, sticker, etc.
 * @param editedMessage New version of a message that is known to the bot and was edited. This
 *     update may at times be triggered by changes to message fields that are either unavailable or
 *     not actively used by your bot.
 * @param channelPost New incoming channel post of any kind - text, photo, sticker, etc.
 * @param editedChannelPost New version of a channel post that is known to the bot and was edited.
 *     This update may at times be triggered by changes to message fields that are either
 *     unavailable or not actively used by your bot.
 * @param businessConnection The bot was connected to or disconnected from a business account, or a
 *     user edited an existing connection with the bot
 * @param businessMessage New message from a connected business account
 * @param editedBusinessMessage New version of a message from a connected business account
 * @param deletedBusinessMessages Messages were deleted from a connected business account
 * @param messageReaction A reaction to a message was changed by a user. The bot must be an
 *     administrator in the chat and must explicitly specify "message_reaction" in the list of
 *     allowed_updates to receive these updates. The update isn't received for reactions set by
 *     bots.
 * @param messageReactionCount Reactions to a message with anonymous reactions were changed. The bot
 *     must be an administrator in the chat and must explicitly specify "message_reaction_count" in
 *     the list of allowed_updates to receive these updates. The updates are grouped and can be sent
 *     with delay up to a few minutes.
 * @param inlineQuery New incoming inline query
 * @param chosenInlineResult The result of an inline query that was chosen by a user and sent to
 *     their chat partner. Please see our documentation on the feedback collecting for details on
 *     how to enable these updates for your bot.
 * @param callbackQuery New incoming callback query
 * @param shippingQuery New incoming shipping query. Only for invoices with flexible price
 * @param preCheckoutQuery New incoming pre-checkout query. Contains full information about checkout
 * @param purchasedPaidMedia A user purchased paid media with a non-empty payload sent by the bot in
 *     a non-channel chat
 * @param poll New poll state. Bots receive only updates about manually stopped polls and polls,
 *     which are sent by the bot
 * @param pollAnswer A user changed their answer in a non-anonymous poll. Bots receive new votes
 *     only in polls that were sent by the bot itself.
 * @param myChatMember The bot's chat member status was updated in a chat. For private chats, this
 *     update is received only when the bot is blocked or unblocked by the user.
 * @param chatMember A chat member's status was updated in a chat. The bot must be an administrator
 *     in the chat and must explicitly specify "chat_member" in the list of allowed_updates to
 *     receive these updates.
 * @param chatJoinRequest A request to join the chat has been sent. The bot must have the
 *     can_invite_users administrator right in the chat to receive these updates.
 * @param chatBoost A chat boost was added or changed. The bot must be an administrator in the chat
 *     to receive these updates.
 * @param removedChatBoost A boost was removed from a chat. The bot must be an administrator in the
 *     chat to receive these updates.
 * @param managedBot A new bot was created to be managed by the bot or token of a bot was changed
 * @see <a href="https://core.telegram.org/bots/api#update">Update in the Bot API</a>
 */
public record Update(
    @JsonProperty("update_id") long updateId,
    @JsonProperty("message") @Nullable Message message,
    @JsonProperty("edited_message") @Nullable Message editedMessage,
    @JsonProperty("channel_post") @Nullable Message channelPost,
    @JsonProperty("edited_channel_post") @Nullable Message editedChannelPost,
    @JsonProperty("business_connection") @Nullable BusinessConnection businessConnection,
    @JsonProperty("business_message") @Nullable Message businessMessage,
    @JsonProperty("edited_business_message") @Nullable Message editedBusinessMessage,
    @JsonProperty("deleted_business_messages") @Nullable BusinessMessagesDeleted deletedBusinessMessages,
    @JsonProperty("message_reaction") @Nullable MessageReactionUpdated messageReaction,
    @JsonProperty("message_reaction_count") @Nullable MessageReactionCountUpdated messageReactionCount,
    @JsonProperty("inline_query") @Nullable InlineQuery inlineQuery,
    @JsonProperty("chosen_inline_result") @Nullable ChosenInlineResult chosenInlineResult,
    @JsonProperty("callback_query") @Nullable CallbackQuery callbackQuery,
    @JsonProperty("shipping_query") @Nullable ShippingQuery shippingQuery,
    @JsonProperty("pre_checkout_query") @Nullable PreCheckoutQuery preCheckoutQuery,
    @JsonProperty("purchased_paid_media") @Nullable PaidMediaPurchased purchasedPaidMedia,
    @JsonProperty("poll") @Nullable Poll poll,
    @JsonProperty("poll_answer") @Nullable PollAnswer pollAnswer,
    @JsonProperty("my_chat_member") @Nullable ChatMemberUpdated myChatMember,
    @JsonProperty("chat_member") @Nullable ChatMemberUpdated chatMember,
    @JsonProperty("chat_join_request") @Nullable ChatJoinRequest chatJoinRequest,
    @JsonProperty("chat_boost") @Nullable ChatBoostUpdated chatBoost,
    @JsonProperty("removed_chat_boost") @Nullable ChatBoostRemoved removedChatBoost,
    @JsonProperty("managed_bot") @Nullable ManagedBotUpdated managedBot
) {

    public Update withUpdateId(long updateId) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withMessage(@Nullable Message message) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withEditedMessage(@Nullable Message editedMessage) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withChannelPost(@Nullable Message channelPost) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withEditedChannelPost(@Nullable Message editedChannelPost) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withBusinessConnection(@Nullable BusinessConnection businessConnection) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withBusinessMessage(@Nullable Message businessMessage) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withEditedBusinessMessage(@Nullable Message editedBusinessMessage) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withDeletedBusinessMessages(@Nullable BusinessMessagesDeleted deletedBusinessMessages) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withMessageReaction(@Nullable MessageReactionUpdated messageReaction) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withMessageReactionCount(@Nullable MessageReactionCountUpdated messageReactionCount) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withInlineQuery(@Nullable InlineQuery inlineQuery) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withChosenInlineResult(@Nullable ChosenInlineResult chosenInlineResult) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withCallbackQuery(@Nullable CallbackQuery callbackQuery) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withShippingQuery(@Nullable ShippingQuery shippingQuery) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withPreCheckoutQuery(@Nullable PreCheckoutQuery preCheckoutQuery) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withPurchasedPaidMedia(@Nullable PaidMediaPurchased purchasedPaidMedia) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withPoll(@Nullable Poll poll) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withPollAnswer(@Nullable PollAnswer pollAnswer) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withMyChatMember(@Nullable ChatMemberUpdated myChatMember) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withChatMember(@Nullable ChatMemberUpdated chatMember) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withChatJoinRequest(@Nullable ChatJoinRequest chatJoinRequest) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withChatBoost(@Nullable ChatBoostUpdated chatBoost) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withRemovedChatBoost(@Nullable ChatBoostRemoved removedChatBoost) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }

    public Update withManagedBot(@Nullable ManagedBotUpdated managedBot) {
        return new Update(updateId, message, editedMessage, channelPost, editedChannelPost, businessConnection, businessMessage, editedBusinessMessage, deletedBusinessMessages, messageReaction, messageReactionCount, inlineQuery, chosenInlineResult, callbackQuery, shippingQuery, preCheckoutQuery, purchasedPaidMedia, poll, pollAnswer, myChatMember, chatMember, chatJoinRequest, chatBoost, removedChatBoost, managedBot);
    }
}
