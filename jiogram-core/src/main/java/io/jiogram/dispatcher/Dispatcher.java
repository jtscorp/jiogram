package io.jiogram.dispatcher;

import io.jiogram.bot.Bot;
import io.jiogram.middleware.Middleware;
import io.jiogram.middleware.MiddlewareChain;
import io.jiogram.types.Update;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The main dispatcher that extends Router and adds middleware support.
 * Receives raw Update objects, resolves the event type and event,
 * then processes them through the middleware chain and router hierarchy.
 */
public class Dispatcher extends Router {

    private final List<Middleware> outerMiddlewares;

    public Dispatcher() {
        super("dispatcher");
        this.outerMiddlewares = new CopyOnWriteArrayList<>();
    }

    /**
     * Adds an outer middleware that wraps the entire event processing pipeline.
     */
    public void addOuterMiddleware(Middleware middleware) {
        outerMiddlewares.add(middleware);
    }

    /**
     * Feeds a raw Update to the dispatcher for processing.
     *
     * @param bot    the bot that received the update
     * @param update the update to process
     * @return a Mono that completes when the update has been processed
     */
    public Mono<Void> feedUpdate(Bot bot, Update update) {
        String eventType = resolveEventType(update);
        if (eventType == null) {
            return Mono.empty();
        }

        Object event = resolveEvent(update);
        if (event == null) {
            return Mono.empty();
        }

        var context = new UpdateContext(bot, update);
        context.put("event_type", eventType);

        Mono<Void> finalHandler = propagateEvent(eventType, event, context).then();

        var chain = new MiddlewareChain(outerMiddlewares, finalHandler);
        return chain.next(event, context);
    }

    /**
     * Resolves the event type name from an Update by checking which field is non-null.
     * Returns the first non-null event type found, or null if the update is empty.
     */
    public String resolveEventType(Update update) {
        if (update.message() != null) return "message";
        if (update.editedMessage() != null) return "edited_message";
        if (update.channelPost() != null) return "channel_post";
        if (update.editedChannelPost() != null) return "edited_channel_post";
        if (update.callbackQuery() != null) return "callback_query";
        if (update.inlineQuery() != null) return "inline_query";
        if (update.poll() != null) return "poll";
        if (update.pollAnswer() != null) return "poll_answer";
        if (update.myChatMember() != null) return "my_chat_member";
        if (update.chatMember() != null) return "chat_member";
        if (update.chatJoinRequest() != null) return "chat_join_request";
        if (update.shippingQuery() != null) return "shipping_query";
        if (update.preCheckoutQuery() != null) return "pre_checkout_query";
        if (update.chosenInlineResult() != null) return "chosen_inline_result";
        if (update.businessConnection() != null) return "business_connection";
        if (update.businessMessage() != null) return "business_message";
        if (update.editedBusinessMessage() != null) return "edited_business_message";
        if (update.deletedBusinessMessages() != null) return "deleted_business_messages";
        if (update.messageReaction() != null) return "message_reaction";
        if (update.messageReactionCount() != null) return "message_reaction_count";
        if (update.chatBoost() != null) return "chat_boost";
        if (update.removedChatBoost() != null) return "removed_chat_boost";
        if (update.purchasedPaidMedia() != null) return "purchased_paid_media";
        if (update.managedBot() != null) return "managed_bot";
        return null;
    }

    /**
     * Resolves the actual event object from an Update by checking which field is non-null.
     */
    public Object resolveEvent(Update update) {
        if (update.message() != null) return update.message();
        if (update.editedMessage() != null) return update.editedMessage();
        if (update.channelPost() != null) return update.channelPost();
        if (update.editedChannelPost() != null) return update.editedChannelPost();
        if (update.callbackQuery() != null) return update.callbackQuery();
        if (update.inlineQuery() != null) return update.inlineQuery();
        if (update.poll() != null) return update.poll();
        if (update.pollAnswer() != null) return update.pollAnswer();
        if (update.myChatMember() != null) return update.myChatMember();
        if (update.chatMember() != null) return update.chatMember();
        if (update.chatJoinRequest() != null) return update.chatJoinRequest();
        if (update.shippingQuery() != null) return update.shippingQuery();
        if (update.preCheckoutQuery() != null) return update.preCheckoutQuery();
        if (update.chosenInlineResult() != null) return update.chosenInlineResult();
        if (update.businessConnection() != null) return update.businessConnection();
        if (update.businessMessage() != null) return update.businessMessage();
        if (update.editedBusinessMessage() != null) return update.editedBusinessMessage();
        if (update.deletedBusinessMessages() != null) return update.deletedBusinessMessages();
        if (update.messageReaction() != null) return update.messageReaction();
        if (update.messageReactionCount() != null) return update.messageReactionCount();
        if (update.chatBoost() != null) return update.chatBoost();
        if (update.removedChatBoost() != null) return update.removedChatBoost();
        if (update.purchasedPaidMedia() != null) return update.purchasedPaidMedia();
        if (update.managedBot() != null) return update.managedBot();
        return null;
    }
}
