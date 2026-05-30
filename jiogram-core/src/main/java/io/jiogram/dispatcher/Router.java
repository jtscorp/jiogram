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

        // Register all standard Telegram event type observers
        observers.put("message", new EventObserver<Message>("message"));
        observers.put("edited_message", new EventObserver<Message>("edited_message"));
        observers.put("channel_post", new EventObserver<Message>("channel_post"));
        observers.put("edited_channel_post", new EventObserver<Message>("edited_channel_post"));
        observers.put("business_connection", new EventObserver<BusinessConnection>("business_connection"));
        observers.put("business_message", new EventObserver<Message>("business_message"));
        observers.put("edited_business_message", new EventObserver<Message>("edited_business_message"));
        observers.put("deleted_business_messages", new EventObserver<BusinessMessagesDeleted>("deleted_business_messages"));
        observers.put("message_reaction", new EventObserver<MessageReactionUpdated>("message_reaction"));
        observers.put("message_reaction_count", new EventObserver<MessageReactionCountUpdated>("message_reaction_count"));
        observers.put("callback_query", new EventObserver<CallbackQuery>("callback_query"));
        observers.put("inline_query", new EventObserver<InlineQuery>("inline_query"));
        observers.put("chosen_inline_result", new EventObserver<ChosenInlineResult>("chosen_inline_result"));
        observers.put("shipping_query", new EventObserver<ShippingQuery>("shipping_query"));
        observers.put("pre_checkout_query", new EventObserver<PreCheckoutQuery>("pre_checkout_query"));
        observers.put("purchased_paid_media", new EventObserver<PaidMediaPurchased>("purchased_paid_media"));
        observers.put("poll", new EventObserver<Poll>("poll"));
        observers.put("poll_answer", new EventObserver<PollAnswer>("poll_answer"));
        observers.put("my_chat_member", new EventObserver<ChatMemberUpdated>("my_chat_member"));
        observers.put("chat_member", new EventObserver<ChatMemberUpdated>("chat_member"));
        observers.put("chat_join_request", new EventObserver<ChatJoinRequest>("chat_join_request"));
        observers.put("chat_boost", new EventObserver<ChatBoostUpdated>("chat_boost"));
        observers.put("removed_chat_boost", new EventObserver<ChatBoostRemoved>("removed_chat_boost"));
        observers.put("managed_bot", new EventObserver<ManagedBotUpdated>("managed_bot"));
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
        return (EventObserver<Message>) observers.get("message");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Message> editedMessageObserver() {
        return (EventObserver<Message>) observers.get("edited_message");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Message> channelPostObserver() {
        return (EventObserver<Message>) observers.get("channel_post");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Message> editedChannelPostObserver() {
        return (EventObserver<Message>) observers.get("edited_channel_post");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<BusinessConnection> businessConnectionObserver() {
        return (EventObserver<BusinessConnection>) observers.get("business_connection");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Message> businessMessageObserver() {
        return (EventObserver<Message>) observers.get("business_message");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Message> editedBusinessMessageObserver() {
        return (EventObserver<Message>) observers.get("edited_business_message");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<BusinessMessagesDeleted> deletedBusinessMessagesObserver() {
        return (EventObserver<BusinessMessagesDeleted>) observers.get("deleted_business_messages");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<MessageReactionUpdated> messageReactionObserver() {
        return (EventObserver<MessageReactionUpdated>) observers.get("message_reaction");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<MessageReactionCountUpdated> messageReactionCountObserver() {
        return (EventObserver<MessageReactionCountUpdated>) observers.get("message_reaction_count");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<CallbackQuery> callbackQueryObserver() {
        return (EventObserver<CallbackQuery>) observers.get("callback_query");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<InlineQuery> inlineQueryObserver() {
        return (EventObserver<InlineQuery>) observers.get("inline_query");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChosenInlineResult> chosenInlineResultObserver() {
        return (EventObserver<ChosenInlineResult>) observers.get("chosen_inline_result");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ShippingQuery> shippingQueryObserver() {
        return (EventObserver<ShippingQuery>) observers.get("shipping_query");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<PreCheckoutQuery> preCheckoutQueryObserver() {
        return (EventObserver<PreCheckoutQuery>) observers.get("pre_checkout_query");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<PaidMediaPurchased> purchasedPaidMediaObserver() {
        return (EventObserver<PaidMediaPurchased>) observers.get("purchased_paid_media");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<Poll> pollObserver() {
        return (EventObserver<Poll>) observers.get("poll");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<PollAnswer> pollAnswerObserver() {
        return (EventObserver<PollAnswer>) observers.get("poll_answer");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChatMemberUpdated> myChatMemberObserver() {
        return (EventObserver<ChatMemberUpdated>) observers.get("my_chat_member");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChatMemberUpdated> chatMemberObserver() {
        return (EventObserver<ChatMemberUpdated>) observers.get("chat_member");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChatJoinRequest> chatJoinRequestObserver() {
        return (EventObserver<ChatJoinRequest>) observers.get("chat_join_request");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChatBoostUpdated> chatBoostObserver() {
        return (EventObserver<ChatBoostUpdated>) observers.get("chat_boost");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ChatBoostRemoved> removedChatBoostObserver() {
        return (EventObserver<ChatBoostRemoved>) observers.get("removed_chat_boost");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<ManagedBotUpdated> managedBotObserver() {
        return (EventObserver<ManagedBotUpdated>) observers.get("managed_bot");
    }

    /**
     * Generic access to any observer by event type name.
     */
    public EventObserver<?> observer(String eventType) {
        return observers.get(eventType);
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
