package io.jiogram.fsm.middleware;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.EventType;
import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.fsm.FSMContext;
import io.jiogram.fsm.FSMStrategy;
import io.jiogram.fsm.StorageKey;
import io.jiogram.fsm.storage.StateStorage;
import io.jiogram.middleware.Middleware;
import io.jiogram.middleware.MiddlewareChain;
import io.jiogram.types.BusinessConnection;
import io.jiogram.types.BusinessMessagesDeleted;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.ChatBoostRemoved;
import io.jiogram.types.ChatBoostUpdated;
import io.jiogram.types.ChatJoinRequest;
import io.jiogram.types.ChatMemberUpdated;
import io.jiogram.types.ChosenInlineResult;
import io.jiogram.types.InaccessibleMessage;
import io.jiogram.types.InlineQuery;
import io.jiogram.types.ManagedBotUpdated;
import io.jiogram.types.Message;
import io.jiogram.types.MessageReactionCountUpdated;
import io.jiogram.types.MessageReactionUpdated;
import io.jiogram.types.PaidMediaPurchased;
import io.jiogram.types.PollAnswer;
import io.jiogram.types.PreCheckoutQuery;
import io.jiogram.types.ShippingQuery;
import io.jiogram.types.Update;
import org.jspecify.annotations.Nullable;
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
    private static final String DESTINY = "default";

    private final StateStorage storage;
    private final FSMStrategy strategy;

    public FSMMiddleware(StateStorage storage) {
        this(storage, FSMStrategy.USER_IN_CHAT);
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
            log.debug("Update {} has no chat/user for FSM strategy {}, skipping FSM", update.updateId(), strategy);
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
     * Resolves a {@link StorageKey} from the update according to the configured {@link FSMStrategy}.
     *
     * @param botId  the bot's numeric ID
     * @param update the incoming update
     * @return the storage key, or null when the update lacks what the strategy needs: a user for
     *         the per-user strategies (e.g. channel posts, reaction counts), a chat or user for the
     *         per-chat ones. FSM is then skipped for that update.
     */
    private @Nullable StorageKey resolveStorageKey(long botId, Update update) {
        Scope scope = resolveScope(update);
        if (scope == null) {
            return null;
        }
        // Updates without a chat (inline queries, payments, ...) are scoped to the user's private chat.
        Long chatId = scope.chatId() != null ? scope.chatId() : scope.userId();
        Long userId = scope.userId();
        String business = scope.businessConnectionId();

        // Must list every FSMStrategy; the default only catches a constant added later.
        switch (strategy) {
            case USER_IN_CHAT:
                return userId == null ? null
                    : new StorageKey(botId, chatId, userId, null, DESTINY, business);
            case CHAT:
                return chatId == null ? null
                    : new StorageKey(botId, chatId, 0, null, DESTINY, business);
            case USER:
                return userId == null ? null
                    : new StorageKey(botId, 0, userId, null, DESTINY, business);
            case USER_IN_TOPIC:
                return userId == null ? null
                    : new StorageKey(botId, chatId, userId, scope.threadId(), DESTINY, business);
            case CHAT_TOPIC:
                return chatId == null ? null
                    : new StorageKey(botId, chatId, 0, scope.threadId(), DESTINY, business);
            default:
                throw new IllegalStateException("Unhandled FSM strategy: " + strategy);
        }
    }

    /** Who and where an update happened; any part may be unknown. */
    private static final class Scope {

        private final @Nullable Long chatId;
        private final @Nullable Long userId;
        private final @Nullable Long threadId;
        private final @Nullable String businessConnectionId;

        Scope(
            @Nullable Long chatId,
            @Nullable Long userId,
            @Nullable Long threadId,
            @Nullable String businessConnectionId
        ) {
            this.chatId = chatId;
            this.userId = userId;
            this.threadId = threadId;
            this.businessConnectionId = businessConnectionId;
        }

        @Nullable Long chatId() {
            return chatId;
        }

        @Nullable Long userId() {
            return userId;
        }

        @Nullable Long threadId() {
            return threadId;
        }

        @Nullable String businessConnectionId() {
            return businessConnectionId;
        }

        @Override
        public String toString() {
            return "Scope[chatId=" + chatId + ", userId=" + userId + ", threadId=" + threadId
                + ", businessConnectionId=" + businessConnectionId + "]";
        }
    }

    private static @Nullable Scope resolveScope(Update update) {
        EventType type = EventType.of(update);
        if (type == null) {
            return null;
        }
        Object event = type.extract(update);
        // Must list every EventType: a new event type must decide its scope here. Java 11 cannot
        // check that at compile time, so the default throws for a constant that was added later.
        switch (type) {
            case MESSAGE:
            case EDITED_MESSAGE:
            case CHANNEL_POST:
            case EDITED_CHANNEL_POST:
            case BUSINESS_MESSAGE:
            case EDITED_BUSINESS_MESSAGE: {
                Message message = (Message) event;
                return messageScope(message, message.from() != null ? message.from().id() : null);
            }
            case CALLBACK_QUERY: {
                CallbackQuery query = (CallbackQuery) event;
                if (query.message() instanceof Message) {
                    return messageScope((Message) query.message(), query.from().id());
                }
                if (query.message() instanceof InaccessibleMessage) {
                    InaccessibleMessage m = (InaccessibleMessage) query.message();
                    return new Scope(m.chat().id(), query.from().id(), null, null);
                }
                return userScope(query.from().id()); // inline message: no chat
            }
            case INLINE_QUERY:
                return userScope(((InlineQuery) event).from().id());
            case CHOSEN_INLINE_RESULT:
                return userScope(((ChosenInlineResult) event).from().id());
            case SHIPPING_QUERY:
                return userScope(((ShippingQuery) event).from().id());
            case PRE_CHECKOUT_QUERY:
                return userScope(((PreCheckoutQuery) event).from().id());
            case PURCHASED_PAID_MEDIA:
                return userScope(((PaidMediaPurchased) event).from().id());
            case MANAGED_BOT:
                return userScope(((ManagedBotUpdated) event).user().id());
            case MY_CHAT_MEMBER:
            case CHAT_MEMBER: {
                ChatMemberUpdated updated = (ChatMemberUpdated) event;
                return new Scope(updated.chat().id(), updated.from().id(), null, null);
            }
            case CHAT_JOIN_REQUEST: {
                ChatJoinRequest request = (ChatJoinRequest) event;
                return new Scope(request.chat().id(), request.from().id(), null, null);
            }
            case POLL_ANSWER: {
                PollAnswer answer = (PollAnswer) event;
                return new Scope(answer.voterChat() != null ? answer.voterChat().id() : null,
                    answer.user() != null ? answer.user().id() : null, null, null);
            }
            case MESSAGE_REACTION: {
                MessageReactionUpdated reaction = (MessageReactionUpdated) event;
                return new Scope(reaction.chat().id(), reaction.user() != null ? reaction.user().id() : null, null, null);
            }
            case MESSAGE_REACTION_COUNT:
                return chatScope(((MessageReactionCountUpdated) event).chat().id());
            case CHAT_BOOST:
                return chatScope(((ChatBoostUpdated) event).chat().id());
            case REMOVED_CHAT_BOOST:
                return chatScope(((ChatBoostRemoved) event).chat().id());
            case BUSINESS_CONNECTION: {
                BusinessConnection connection = (BusinessConnection) event;
                return new Scope(connection.userChatId(), connection.user().id(), null, connection.id());
            }
            case DELETED_BUSINESS_MESSAGES: {
                BusinessMessagesDeleted deleted = (BusinessMessagesDeleted) event;
                return new Scope(deleted.chat().id(), null, null, deleted.businessConnectionId());
            }
            case POLL:
                return null; // no chat or user
            default:
                throw new IllegalStateException("FSM scope not defined for event type " + type);
        }
    }

    private static Scope messageScope(Message message, @Nullable Long userId) {
        // message_thread_id is also set on replies in non-forum groups; only forum topics count.
        Long threadId = Boolean.TRUE.equals(message.isTopicMessage()) ? message.messageThreadId() : null;
        return new Scope(message.chat().id(), userId, threadId, message.businessConnectionId());
    }

    private static Scope userScope(long userId) {
        return new Scope(null, userId, null, null);
    }

    private static Scope chatScope(long chatId) {
        return new Scope(chatId, null, null, null);
    }
}
