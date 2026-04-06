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
) {}
