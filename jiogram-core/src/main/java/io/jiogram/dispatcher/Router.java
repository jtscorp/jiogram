package io.jiogram.dispatcher;

import io.jiogram.types.CallbackQuery;
import io.jiogram.types.ChatJoinRequest;
import io.jiogram.types.ChatMemberUpdated;
import io.jiogram.types.InlineQuery;
import io.jiogram.types.Message;
import io.jiogram.types.Poll;
import io.jiogram.types.PollAnswer;
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
        observers.put("callback_query", new EventObserver<CallbackQuery>("callback_query"));
        observers.put("inline_query", new EventObserver<InlineQuery>("inline_query"));
        observers.put("poll", new EventObserver<Poll>("poll"));
        observers.put("poll_answer", new EventObserver<PollAnswer>("poll_answer"));
        observers.put("my_chat_member", new EventObserver<ChatMemberUpdated>("my_chat_member"));
        observers.put("chat_member", new EventObserver<ChatMemberUpdated>("chat_member"));
        observers.put("chat_join_request", new EventObserver<ChatJoinRequest>("chat_join_request"));
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
    public EventObserver<CallbackQuery> callbackQueryObserver() {
        return (EventObserver<CallbackQuery>) observers.get("callback_query");
    }

    @SuppressWarnings("unchecked")
    public EventObserver<InlineQuery> inlineQueryObserver() {
        return (EventObserver<InlineQuery>) observers.get("inline_query");
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
