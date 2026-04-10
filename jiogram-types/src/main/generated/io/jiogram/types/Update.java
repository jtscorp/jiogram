package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
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

public class Update {
    @JsonProperty("update_id") private final long updateId;
    @JsonProperty("message") @Nullable private final Message message;
    @JsonProperty("edited_message") @Nullable private final Message editedMessage;
    @JsonProperty("channel_post") @Nullable private final Message channelPost;
    @JsonProperty("edited_channel_post") @Nullable private final Message editedChannelPost;
    @JsonProperty("business_connection") @Nullable private final BusinessConnection businessConnection;
    @JsonProperty("business_message") @Nullable private final Message businessMessage;
    @JsonProperty("edited_business_message") @Nullable private final Message editedBusinessMessage;
    @JsonProperty("deleted_business_messages") @Nullable private final BusinessMessagesDeleted deletedBusinessMessages;
    @JsonProperty("message_reaction") @Nullable private final MessageReactionUpdated messageReaction;
    @JsonProperty("message_reaction_count") @Nullable private final MessageReactionCountUpdated messageReactionCount;
    @JsonProperty("inline_query") @Nullable private final InlineQuery inlineQuery;
    @JsonProperty("chosen_inline_result") @Nullable private final ChosenInlineResult chosenInlineResult;
    @JsonProperty("callback_query") @Nullable private final CallbackQuery callbackQuery;
    @JsonProperty("shipping_query") @Nullable private final ShippingQuery shippingQuery;
    @JsonProperty("pre_checkout_query") @Nullable private final PreCheckoutQuery preCheckoutQuery;
    @JsonProperty("purchased_paid_media") @Nullable private final PaidMediaPurchased purchasedPaidMedia;
    @JsonProperty("poll") @Nullable private final Poll poll;
    @JsonProperty("poll_answer") @Nullable private final PollAnswer pollAnswer;
    @JsonProperty("my_chat_member") @Nullable private final ChatMemberUpdated myChatMember;
    @JsonProperty("chat_member") @Nullable private final ChatMemberUpdated chatMember;
    @JsonProperty("chat_join_request") @Nullable private final ChatJoinRequest chatJoinRequest;
    @JsonProperty("chat_boost") @Nullable private final ChatBoostUpdated chatBoost;
    @JsonProperty("removed_chat_boost") @Nullable private final ChatBoostRemoved removedChatBoost;
    @JsonProperty("managed_bot") @Nullable private final ManagedBotUpdated managedBot;

    @JsonCreator
    public Update(
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
        this.updateId = updateId;
        this.message = message;
        this.editedMessage = editedMessage;
        this.channelPost = channelPost;
        this.editedChannelPost = editedChannelPost;
        this.businessConnection = businessConnection;
        this.businessMessage = businessMessage;
        this.editedBusinessMessage = editedBusinessMessage;
        this.deletedBusinessMessages = deletedBusinessMessages;
        this.messageReaction = messageReaction;
        this.messageReactionCount = messageReactionCount;
        this.inlineQuery = inlineQuery;
        this.chosenInlineResult = chosenInlineResult;
        this.callbackQuery = callbackQuery;
        this.shippingQuery = shippingQuery;
        this.preCheckoutQuery = preCheckoutQuery;
        this.purchasedPaidMedia = purchasedPaidMedia;
        this.poll = poll;
        this.pollAnswer = pollAnswer;
        this.myChatMember = myChatMember;
        this.chatMember = chatMember;
        this.chatJoinRequest = chatJoinRequest;
        this.chatBoost = chatBoost;
        this.removedChatBoost = removedChatBoost;
        this.managedBot = managedBot;
    }

    public long updateId() {
        return this.updateId;
    }

    public Message message() {
        return this.message;
    }

    public Message editedMessage() {
        return this.editedMessage;
    }

    public Message channelPost() {
        return this.channelPost;
    }

    public Message editedChannelPost() {
        return this.editedChannelPost;
    }

    public BusinessConnection businessConnection() {
        return this.businessConnection;
    }

    public Message businessMessage() {
        return this.businessMessage;
    }

    public Message editedBusinessMessage() {
        return this.editedBusinessMessage;
    }

    public BusinessMessagesDeleted deletedBusinessMessages() {
        return this.deletedBusinessMessages;
    }

    public MessageReactionUpdated messageReaction() {
        return this.messageReaction;
    }

    public MessageReactionCountUpdated messageReactionCount() {
        return this.messageReactionCount;
    }

    public InlineQuery inlineQuery() {
        return this.inlineQuery;
    }

    public ChosenInlineResult chosenInlineResult() {
        return this.chosenInlineResult;
    }

    public CallbackQuery callbackQuery() {
        return this.callbackQuery;
    }

    public ShippingQuery shippingQuery() {
        return this.shippingQuery;
    }

    public PreCheckoutQuery preCheckoutQuery() {
        return this.preCheckoutQuery;
    }

    public PaidMediaPurchased purchasedPaidMedia() {
        return this.purchasedPaidMedia;
    }

    public Poll poll() {
        return this.poll;
    }

    public PollAnswer pollAnswer() {
        return this.pollAnswer;
    }

    public ChatMemberUpdated myChatMember() {
        return this.myChatMember;
    }

    public ChatMemberUpdated chatMember() {
        return this.chatMember;
    }

    public ChatJoinRequest chatJoinRequest() {
        return this.chatJoinRequest;
    }

    public ChatBoostUpdated chatBoost() {
        return this.chatBoost;
    }

    public ChatBoostRemoved removedChatBoost() {
        return this.removedChatBoost;
    }

    public ManagedBotUpdated managedBot() {
        return this.managedBot;
    }
}
