package io.jiogram.dispatcher;

import io.jiogram.types.CallbackQuery;
import io.jiogram.types.BusinessConnection;
import io.jiogram.types.BusinessMessagesDeleted;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Hierarchical event routing. Maintains event observers for various Telegram event types,
 * and supports sub-routers for composable routing structures.
 */
public class Router {

    private final String name;
    private Router parent;
    private final List<Router> subRouters;
    private final Map<String, EventObserver<?>> observers;

    public Router() {
        this("default");
    }

    public Router(String name) {
        this.name = name;
        this.subRouters = new CopyOnWriteArrayList<>();
        this.observers = new ConcurrentHashMap<>();

        for (EventType type : EventType.values()) {
            observers.put(type.apiName(), new EventObserver<>(type.apiName()));
        }
    }

    /**
     * Includes a child router. Events not handled by this router will propagate to sub-routers.
     */
    public void includeRouter(Router child) {
        child.parent = this;
        subRouters.add(child);
    }

    /**
     * Includes multiple child routers.
     */
    public void includeRouters(Router... routers) {
        for (Router r : routers) {
            includeRouter(r);
        }
    }

    // -- Fluent builder access --

    public HandlerBuilder<Message> onMessage() {
        return new HandlerBuilder<>(messageObserver());
    }

    public HandlerBuilder<CallbackQuery> onCallbackQuery() {
        return new HandlerBuilder<>(callbackQueryObserver());
    }

    public HandlerBuilder<InlineQuery> onInlineQuery() {
        return new HandlerBuilder<>(inlineQueryObserver());
    }

    public HandlerBuilder<Message> onEditedMessage() {
        return new HandlerBuilder<>(editedMessageObserver());
    }

    public HandlerBuilder<Message> onChannelPost() {
        return new HandlerBuilder<>(channelPostObserver());
    }

    public HandlerBuilder<Message> onEditedChannelPost() {
        return new HandlerBuilder<>(editedChannelPostObserver());
    }

    public HandlerBuilder<BusinessConnection> onBusinessConnection() {
        return new HandlerBuilder<>(businessConnectionObserver());
    }

    public HandlerBuilder<Message> onBusinessMessage() {
        return new HandlerBuilder<>(businessMessageObserver());
    }

    public HandlerBuilder<Message> onEditedBusinessMessage() {
        return new HandlerBuilder<>(editedBusinessMessageObserver());
    }

    public HandlerBuilder<BusinessMessagesDeleted> onDeletedBusinessMessages() {
        return new HandlerBuilder<>(deletedBusinessMessagesObserver());
    }

    public HandlerBuilder<MessageReactionUpdated> onMessageReaction() {
        return new HandlerBuilder<>(messageReactionObserver());
    }

    public HandlerBuilder<MessageReactionCountUpdated> onMessageReactionCount() {
        return new HandlerBuilder<>(messageReactionCountObserver());
    }

    public HandlerBuilder<ChosenInlineResult> onChosenInlineResult() {
        return new HandlerBuilder<>(chosenInlineResultObserver());
    }

    public HandlerBuilder<ShippingQuery> onShippingQuery() {
        return new HandlerBuilder<>(shippingQueryObserver());
    }

    public HandlerBuilder<PreCheckoutQuery> onPreCheckoutQuery() {
        return new HandlerBuilder<>(preCheckoutQueryObserver());
    }

    public HandlerBuilder<PaidMediaPurchased> onPurchasedPaidMedia() {
        return new HandlerBuilder<>(purchasedPaidMediaObserver());
    }

    public HandlerBuilder<Poll> onPoll() {
        return new HandlerBuilder<>(pollObserver());
    }

    public HandlerBuilder<PollAnswer> onPollAnswer() {
        return new HandlerBuilder<>(pollAnswerObserver());
    }

    public HandlerBuilder<ChatMemberUpdated> onMyChatMember() {
        return new HandlerBuilder<>(myChatMemberObserver());
    }

    public HandlerBuilder<ChatMemberUpdated> onChatMember() {
        return new HandlerBuilder<>(chatMemberObserver());
    }

    public HandlerBuilder<ChatJoinRequest> onChatJoinRequest() {
        return new HandlerBuilder<>(chatJoinRequestObserver());
    }

    public HandlerBuilder<ChatBoostUpdated> onChatBoost() {
        return new HandlerBuilder<>(chatBoostObserver());
    }

    public HandlerBuilder<ChatBoostRemoved> onRemovedChatBoost() {
        return new HandlerBuilder<>(removedChatBoostObserver());
    }

    public HandlerBuilder<ManagedBotUpdated> onManagedBot() {
        return new HandlerBuilder<>(managedBotObserver());
    }

    // -- Direct observer access --

    @SuppressWarnings("unchecked")
    public EventObserver<Message> messageObserver() {
        return (EventObserver<Message>) observer(EventType.MESSAGE);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Message> editedMessageObserver() {
        return (EventObserver<Message>) observer(EventType.EDITED_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Message> channelPostObserver() {
        return (EventObserver<Message>) observer(EventType.CHANNEL_POST);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Message> editedChannelPostObserver() {
        return (EventObserver<Message>) observer(EventType.EDITED_CHANNEL_POST);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<BusinessConnection> businessConnectionObserver() {
        return (EventObserver<BusinessConnection>) observer(EventType.BUSINESS_CONNECTION);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Message> businessMessageObserver() {
        return (EventObserver<Message>) observer(EventType.BUSINESS_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Message> editedBusinessMessageObserver() {
        return (EventObserver<Message>) observer(EventType.EDITED_BUSINESS_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<BusinessMessagesDeleted> deletedBusinessMessagesObserver() {
        return (EventObserver<BusinessMessagesDeleted>) observer(EventType.DELETED_BUSINESS_MESSAGES);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<MessageReactionUpdated> messageReactionObserver() {
        return (EventObserver<MessageReactionUpdated>) observer(EventType.MESSAGE_REACTION);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<MessageReactionCountUpdated> messageReactionCountObserver() {
        return (EventObserver<MessageReactionCountUpdated>) observer(EventType.MESSAGE_REACTION_COUNT);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<CallbackQuery> callbackQueryObserver() {
        return (EventObserver<CallbackQuery>) observer(EventType.CALLBACK_QUERY);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<InlineQuery> inlineQueryObserver() {
        return (EventObserver<InlineQuery>) observer(EventType.INLINE_QUERY);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChosenInlineResult> chosenInlineResultObserver() {
        return (EventObserver<ChosenInlineResult>) observer(EventType.CHOSEN_INLINE_RESULT);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ShippingQuery> shippingQueryObserver() {
        return (EventObserver<ShippingQuery>) observer(EventType.SHIPPING_QUERY);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<PreCheckoutQuery> preCheckoutQueryObserver() {
        return (EventObserver<PreCheckoutQuery>) observer(EventType.PRE_CHECKOUT_QUERY);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<PaidMediaPurchased> purchasedPaidMediaObserver() {
        return (EventObserver<PaidMediaPurchased>) observer(EventType.PURCHASED_PAID_MEDIA);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Poll> pollObserver() {
        return (EventObserver<Poll>) observer(EventType.POLL);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<PollAnswer> pollAnswerObserver() {
        return (EventObserver<PollAnswer>) observer(EventType.POLL_ANSWER);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChatMemberUpdated> myChatMemberObserver() {
        return (EventObserver<ChatMemberUpdated>) observer(EventType.MY_CHAT_MEMBER);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChatMemberUpdated> chatMemberObserver() {
        return (EventObserver<ChatMemberUpdated>) observer(EventType.CHAT_MEMBER);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChatJoinRequest> chatJoinRequestObserver() {
        return (EventObserver<ChatJoinRequest>) observer(EventType.CHAT_JOIN_REQUEST);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChatBoostUpdated> chatBoostObserver() {
        return (EventObserver<ChatBoostUpdated>) observer(EventType.CHAT_BOOST);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChatBoostRemoved> removedChatBoostObserver() {
        return (EventObserver<ChatBoostRemoved>) observer(EventType.REMOVED_CHAT_BOOST);
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ManagedBotUpdated> managedBotObserver() {
        return (EventObserver<ManagedBotUpdated>) observer(EventType.MANAGED_BOT);
    }

    /**
     * Generic access to any observer by event type name.
     */
    public EventObserver<?> observer(String eventType) {
        return observers.get(eventType);
    }

    /**
     * The observer of the given event type.
     */
    public EventObserver<?> observer(EventType eventType) {
        return observers.get(eventType.apiName());
    }

    /**
     * Propagates an event to this router's observer first, then to sub-routers depth-first.
     * Returns true if any handler was found and invoked.
     *
     * @param eventType the event type name (e.g., "message", "callback_query")
     * @param event     the event object
     * @param context   the update context
     * @return a Mono emitting true if an event was handled, false otherwise
     */
    @SuppressWarnings("unchecked")
    public Mono<Boolean> propagateEvent(String eventType, Object event, UpdateContext context) {
        EventObserver<Object> obs = (EventObserver<Object>) observers.get(eventType);

        Mono<Boolean> ownResult;
        if (obs != null && obs.hasHandlers()) {
            ownResult = obs.trigger(event, context);
        } else {
            ownResult = Mono.just(false);
        }

        return ownResult.flatMap(handled -> {
            if (handled) {
                return Mono.just(true);
            }
            // Try sub-routers depth-first
            return Flux.fromIterable(subRouters)
                    .concatMap(sub -> sub.propagateEvent(eventType, event, context))
                    .filter(Boolean::booleanValue)
                    .next()
                    .defaultIfEmpty(false);
        });
    }

    public String name() {
        return name;
    }

    public Router parent() {
        return parent;
    }

    public List<Router> subRouters() {
        return List.copyOf(subRouters);
    }
}
