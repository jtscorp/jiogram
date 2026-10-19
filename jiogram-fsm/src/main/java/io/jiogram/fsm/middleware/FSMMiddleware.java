package io.jiogram.fsm.middleware;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.fsm.FSMContext;
import io.jiogram.fsm.FSMStrategy;
import io.jiogram.fsm.StorageKey;
import io.jiogram.fsm.storage.StateStorage;
import io.jiogram.middleware.Middleware;
import io.jiogram.middleware.MiddlewareChain;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.ChatJoinRequest;
import io.jiogram.types.ChatMemberUpdated;
import io.jiogram.types.InlineQuery;
import io.jiogram.types.Message;
import io.jiogram.types.PreCheckoutQuery;
import io.jiogram.types.ShippingQuery;
import io.jiogram.types.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * Middleware that resolves FSM state from the current update and injects
 * an {@link FSMContext} and the raw state string into the {@link UpdateContext}.
 *
 * <p>After this middleware runs, handlers can access:
 * <ul>
 *   <li>{@code context.get("state", FSMContext.class)} - the FSM context for state transitions</li>
 *   <li>{@code context.get("raw_state")} - the current state name as a String (or null)</li>
 * </ul>
 */
public class FSMMiddleware implements Middleware {

    private static final Logger log = LoggerFactory.getLogger(FSMMiddleware.class);

    private final StateStorage storage;
    private final FSMStrategy strategy;

    public FSMMiddleware(StateStorage storage) {
        StateStorage checkedStorage = Objects.requireNonNull(storage, "storage must not be null");
        this(checkedStorage, FSMStrategy.USER_IN_CHAT);
    }

    public FSMMiddleware(StateStorage storage, FSMStrategy strategy) {
        this.storage = Objects.requireNonNull(storage, "storage must not be null");
        this.strategy = Objects.requireNonNull(strategy, "strategy must not be null");
    }

    @Override
    public Mono<Void> process(Object event, UpdateContext context, MiddlewareChain chain) {
        Bot bot = context.bot();
        Update update = context.update();

        StorageKey key = resolveStorageKey(bot.id(), update);
        if (key == null) {
            log.debug("Could not resolve storage key from update {}, skipping FSM", update.updateId());
            return chain.next(event, context);
        }

        FSMContext fsmContext = new FSMContext(storage, key);

        return fsmContext.getState()
            .defaultIfEmpty("")
            .flatMap(rawState -> {
                context.put("state", fsmContext);
                if (!rawState.isEmpty()) {
                    context.put("raw_state", rawState);
                }
                return chain.next(event, context);
            });
    }

    /**
     * Resolves a {@link StorageKey} from the update by extracting chatId and userId
     * based on the configured {@link FSMStrategy}.
     *
     * @param botId  the bot's numeric ID
     * @param update the incoming update
     * @return the storage key, or null if the update has no identifiable chat/user
     */
    private StorageKey resolveStorageKey(long botId, Update update) {
        long chatId = 0;
        long userId = 0;
        Long threadId = null;
        String businessConnectionId = null;

        // Extract chatId and userId from different update types
        if (update.message() != null) {
            Message msg = update.message();
            chatId = msg.chat().id();
            userId = msg.from() != null ? msg.from().id() : 0;
            threadId = msg.messageThreadId();
        } else if (update.editedMessage() != null) {
            Message msg = update.editedMessage();
            chatId = msg.chat().id();
            userId = msg.from() != null ? msg.from().id() : 0;
            threadId = msg.messageThreadId();
        } else if (update.channelPost() != null) {
            Message msg = update.channelPost();
            chatId = msg.chat().id();
            userId = msg.from() != null ? msg.from().id() : 0;
        } else if (update.editedChannelPost() != null) {
            Message msg = update.editedChannelPost();
            chatId = msg.chat().id();
            userId = msg.from() != null ? msg.from().id() : 0;
        } else if (update.callbackQuery() != null) {
            CallbackQuery cq = update.callbackQuery();
            userId = cq.from().id();
            // Try to get chatId from the callback query's message
            if (cq.message() instanceof Message msg) {
                chatId = msg.chat().id();
                threadId = msg.messageThreadId();
                businessConnectionId = msg.businessConnectionId();
            } else if (cq.message() != null) {
                // InaccessibleMessage also has chat()
                chatId = ((io.jiogram.types.InaccessibleMessage) cq.message()).chat().id();
            } else {
                // Inline callback — use userId as chatId
                chatId = userId;
            }
        } else if (update.inlineQuery() != null) {
            InlineQuery iq = update.inlineQuery();
            userId = iq.from().id();
            chatId = userId; // No chat context for inline queries
        } else if (update.shippingQuery() != null) {
            ShippingQuery sq = update.shippingQuery();
            userId = sq.from().id();
            chatId = userId;
        } else if (update.preCheckoutQuery() != null) {
            PreCheckoutQuery pq = update.preCheckoutQuery();
            userId = pq.from().id();
            chatId = userId;
        } else if (update.myChatMember() != null) {
            ChatMemberUpdated cmu = update.myChatMember();
            chatId = cmu.chat().id();
            userId = cmu.from().id();
        } else if (update.chatMember() != null) {
            ChatMemberUpdated cmu = update.chatMember();
            chatId = cmu.chat().id();
            userId = cmu.from().id();
        } else if (update.chatJoinRequest() != null) {
            ChatJoinRequest cjr = update.chatJoinRequest();
            chatId = cjr.chat().id();
            userId = cjr.from().id();
        } else if (update.businessMessage() != null) {
            Message msg = update.businessMessage();
            chatId = msg.chat().id();
            userId = msg.from() != null ? msg.from().id() : 0;
            businessConnectionId = msg.businessConnectionId();
        } else if (update.editedBusinessMessage() != null) {
            Message msg = update.editedBusinessMessage();
            chatId = msg.chat().id();
            userId = msg.from() != null ? msg.from().id() : 0;
            businessConnectionId = msg.businessConnectionId();
        } else {
            return null;
        }

        // Apply strategy
        return switch (strategy) {
            case USER_IN_CHAT -> new StorageKey(botId, chatId, userId, null, "default", businessConnectionId);
            case CHAT -> new StorageKey(botId, chatId, 0, null, "default", businessConnectionId);
            case USER -> new StorageKey(botId, 0, userId, null, "default", businessConnectionId);
            case CHAT_TOPIC -> new StorageKey(botId, chatId, userId, threadId, "default", businessConnectionId);
        };
    }
}
