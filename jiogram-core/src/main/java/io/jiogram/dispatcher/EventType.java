package io.jiogram.dispatcher;

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
import io.jiogram.types.Update;
import io.jiogram.types.UpdateType;
import org.jspecify.annotations.Nullable;

import java.util.function.Function;

/**
 * The kinds of event an {@link Update} can carry: the single place that knows which field of
 * an update holds which event. The dispatcher, routers and handler registry are built from it,
 * and code that treats event kinds differently switches over it, so a new update type added to
 * the Bot API shows up as a missing enum constant and as non-exhaustive switches.
 */
public enum EventType {
    MESSAGE(UpdateType.MESSAGE, Message.class, Update::message),
    EDITED_MESSAGE(UpdateType.EDITED_MESSAGE, Message.class, Update::editedMessage),
    CHANNEL_POST(UpdateType.CHANNEL_POST, Message.class, Update::channelPost),
    EDITED_CHANNEL_POST(UpdateType.EDITED_CHANNEL_POST, Message.class, Update::editedChannelPost),
    BUSINESS_CONNECTION(UpdateType.BUSINESS_CONNECTION, BusinessConnection.class, Update::businessConnection),
    BUSINESS_MESSAGE(UpdateType.BUSINESS_MESSAGE, Message.class, Update::businessMessage),
    EDITED_BUSINESS_MESSAGE(UpdateType.EDITED_BUSINESS_MESSAGE, Message.class, Update::editedBusinessMessage),
    DELETED_BUSINESS_MESSAGES(UpdateType.DELETED_BUSINESS_MESSAGES, BusinessMessagesDeleted.class,
        Update::deletedBusinessMessages),
    MESSAGE_REACTION(UpdateType.MESSAGE_REACTION, MessageReactionUpdated.class, Update::messageReaction),
    MESSAGE_REACTION_COUNT(UpdateType.MESSAGE_REACTION_COUNT, MessageReactionCountUpdated.class,
        Update::messageReactionCount),
    INLINE_QUERY(UpdateType.INLINE_QUERY, InlineQuery.class, Update::inlineQuery),
    CHOSEN_INLINE_RESULT(UpdateType.CHOSEN_INLINE_RESULT, ChosenInlineResult.class, Update::chosenInlineResult),
    CALLBACK_QUERY(UpdateType.CALLBACK_QUERY, CallbackQuery.class, Update::callbackQuery),
    SHIPPING_QUERY(UpdateType.SHIPPING_QUERY, ShippingQuery.class, Update::shippingQuery),
    PRE_CHECKOUT_QUERY(UpdateType.PRE_CHECKOUT_QUERY, PreCheckoutQuery.class, Update::preCheckoutQuery),
    PURCHASED_PAID_MEDIA(UpdateType.PURCHASED_PAID_MEDIA, PaidMediaPurchased.class, Update::purchasedPaidMedia),
    POLL(UpdateType.POLL, Poll.class, Update::poll),
    POLL_ANSWER(UpdateType.POLL_ANSWER, PollAnswer.class, Update::pollAnswer),
    MY_CHAT_MEMBER(UpdateType.MY_CHAT_MEMBER, ChatMemberUpdated.class, Update::myChatMember),
    CHAT_MEMBER(UpdateType.CHAT_MEMBER, ChatMemberUpdated.class, Update::chatMember),
    CHAT_JOIN_REQUEST(UpdateType.CHAT_JOIN_REQUEST, ChatJoinRequest.class, Update::chatJoinRequest),
    CHAT_BOOST(UpdateType.CHAT_BOOST, ChatBoostUpdated.class, Update::chatBoost),
    REMOVED_CHAT_BOOST(UpdateType.REMOVED_CHAT_BOOST, ChatBoostRemoved.class, Update::removedChatBoost),
    MANAGED_BOT(UpdateType.MANAGED_BOT, ManagedBotUpdated.class, Update::managedBot);

    private final UpdateType updateType;
    private final Class<?> eventClass;
    private final Function<Update, ?> extractor;

    EventType(UpdateType updateType, Class<?> eventClass, Function<Update, ?> extractor) {
        this.updateType = updateType;
        this.eventClass = eventClass;
        this.extractor = extractor;
    }

    /**
     * The event type's name in the Bot API, e.g. {@code "message"}, also the key of its
     * observer in a {@link Router}.
     */
    public String apiName() {
        return updateType.value();
    }

    /** The matching value for {@code allowed_updates}. */
    public UpdateType updateType() {
        return updateType;
    }

    /** The class of the event object, e.g. {@link Message} for {@link #MESSAGE}. */
    public Class<?> eventClass() {
        return eventClass;
    }

    /** The event of this type carried by the update, or {@code null} when it carries another one. */
    public @Nullable Object extract(Update update) {
        return extractor.apply(update);
    }

    /**
     * The type of the event an update carries (Telegram sets exactly one event field), or
     * {@code null} for an update with none this library knows.
     */
    public static @Nullable EventType of(Update update) {
        for (EventType type : values()) {
            if (type.extract(update) != null) {
                return type;
            }
        }
        return null;
    }
}
