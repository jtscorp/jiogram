package io.jiogram.fsm.middleware;

import io.jiogram.bot.Bot;
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
import io.jiogram.types.ChatJoinRequest;
import io.jiogram.types.ChatMemberUpdated;
import io.jiogram.types.InaccessibleMessage;
import io.jiogram.types.Message;
import io.jiogram.types.MessageReactionUpdated;
import io.jiogram.types.PollAnswer;
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

        return switch (strategy) {
            case USER_IN_CHAT -> userId == null ? null
                : new StorageKey(botId, chatId, userId, null, DESTINY, business);
            case CHAT -> chatId == null ? null
                : new StorageKey(botId, chatId, 0, null, DESTINY, business);
            case USER -> userId == null ? null
                : new StorageKey(botId, 0, userId, null, DESTINY, business);
            case USER_IN_TOPIC -> userId == null ? null
                : new StorageKey(botId, chatId, userId, scope.threadId(), DESTINY, business);
            case CHAT_TOPIC -> chatId == null ? null
                : new StorageKey(botId, chatId, 0, scope.threadId(), DESTINY, business);
        };
    }

    /** Who and where an update happened; any part may be unknown. */
    private record Scope(
        @Nullable Long chatId,
        @Nullable Long userId,
        @Nullable Long threadId,
        @Nullable String businessConnectionId
    ) {}

    private static @Nullable Scope resolveScope(Update update) {
        Message message = firstNonNull(update.message(), update.editedMessage(), update.channelPost(),
            update.editedChannelPost(), update.businessMessage(), update.editedBusinessMessage());
        if (message != null) {
            return messageScope(message, message.from() != null ? message.from().id() : null);
        }
        if (update.callbackQuery() != null) {
            CallbackQuery query = update.callbackQuery();
            return switch (query.message()) {
                case Message m -> messageScope(m, query.from().id());
                case InaccessibleMessage m -> new Scope(m.chat().id(), query.from().id(), null, null);
                case null -> userScope(query.from().id()); // inline message: no chat
            };
        }
        if (update.inlineQuery() != null) return userScope(update.inlineQuery().from().id());
        if (update.chosenInlineResult() != null) return userScope(update.chosenInlineResult().from().id());
        if (update.shippingQuery() != null) return userScope(update.shippingQuery().from().id());
        if (update.preCheckoutQuery() != null) return userScope(update.preCheckoutQuery().from().id());
        if (update.purchasedPaidMedia() != null) return userScope(update.purchasedPaidMedia().from().id());
        if (update.managedBot() != null) return userScope(update.managedBot().user().id());
        if (update.myChatMember() != null) return memberScope(update.myChatMember());
        if (update.chatMember() != null) return memberScope(update.chatMember());
        if (update.chatJoinRequest() != null) {
            ChatJoinRequest request = update.chatJoinRequest();
            return new Scope(request.chat().id(), request.from().id(), null, null);
        }
        if (update.pollAnswer() != null) {
            PollAnswer answer = update.pollAnswer();
            return new Scope(answer.voterChat() != null ? answer.voterChat().id() : null,
                answer.user() != null ? answer.user().id() : null, null, null);
        }
        if (update.messageReaction() != null) {
            MessageReactionUpdated reaction = update.messageReaction();
            return new Scope(reaction.chat().id(), reaction.user() != null ? reaction.user().id() : null, null, null);
        }
        if (update.messageReactionCount() != null) return chatScope(update.messageReactionCount().chat().id());
        if (update.chatBoost() != null) return chatScope(update.chatBoost().chat().id());
        if (update.removedChatBoost() != null) return chatScope(update.removedChatBoost().chat().id());
        if (update.businessConnection() != null) {
            BusinessConnection connection = update.businessConnection();
            return new Scope(connection.userChatId(), connection.user().id(), null, connection.id());
        }
        if (update.deletedBusinessMessages() != null) {
            BusinessMessagesDeleted deleted = update.deletedBusinessMessages();
            return new Scope(deleted.chat().id(), null, null, deleted.businessConnectionId());
        }
        return null; // poll: no chat or user
    }

    private static Scope messageScope(Message message, @Nullable Long userId) {
        // message_thread_id is also set on replies in non-forum groups; only forum topics count.
        Long threadId = Boolean.TRUE.equals(message.isTopicMessage()) ? message.messageThreadId() : null;
        return new Scope(message.chat().id(), userId, threadId, message.businessConnectionId());
    }

    private static Scope memberScope(ChatMemberUpdated updated) {
        return new Scope(updated.chat().id(), updated.from().id(), null, null);
    }

    private static Scope userScope(long userId) {
        return new Scope(null, userId, null, null);
    }

    private static Scope chatScope(long chatId) {
        return new Scope(chatId, null, null, null);
    }

    @SafeVarargs
    private static <T> @Nullable T firstNonNull(T... values) {
        for (T value : values) {
            if (value != null) {
                return value;
            }
        }
        return null;
    }
}
