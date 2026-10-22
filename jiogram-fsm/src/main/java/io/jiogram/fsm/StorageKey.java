package io.jiogram.fsm;

import org.jspecify.annotations.Nullable;

import java.util.Objects;

/**
 * Identifies a unique FSM storage entry. Combines bot, chat, and user identifiers
 * with optional thread, business connection and destiny qualifiers for fine-grained
 * state isolation.
 *
 * <p>An immutable value: equality, hash code and {@link #toString()} cover every component,
 * in the same form as a Java record ({@code StorageKey[botId=1, chatId=2, ...]}).
 */
public final class StorageKey {

    private final long botId;
    private final long chatId;
    private final long userId;
    private final @Nullable Long threadId;
    private final String destiny;
    private final @Nullable String businessConnectionId;

    /**
     * Creates a key from all of its components.
     *
     * @param botId                the bot's numeric ID
     * @param chatId               the chat ID (may be 0 for user-only strategies)
     * @param userId               the user ID (may be 0 for chat-only strategies)
     * @param threadId             optional forum thread ID for topic-based isolation
     * @param destiny              a namespace qualifier, defaults to "default"
     * @param businessConnectionId the business connection the update came through, or null; keeps a
     *                             customer's state separate per business account they write to
     */
    public StorageKey(
        long botId,
        long chatId,
        long userId,
        @Nullable Long threadId,
        String destiny,
        @Nullable String businessConnectionId
    ) {
        this.botId = botId;
        this.chatId = chatId;
        this.userId = userId;
        this.threadId = threadId;
        this.destiny = destiny;
        this.businessConnectionId = businessConnectionId;
    }

    /**
     * Constructor without a business connection.
     *
     * @param botId    the bot's numeric ID
     * @param chatId   the chat ID (may be 0 for user-only strategies)
     * @param userId   the user ID (may be 0 for chat-only strategies)
     * @param threadId optional forum thread ID for topic-based isolation
     * @param destiny  a namespace qualifier, defaults to "default"
     */
    public StorageKey(long botId, long chatId, long userId, @Nullable Long threadId, String destiny) {
        this(botId, chatId, userId, threadId, destiny, null);
    }

    /**
     * Convenience constructor with threadId=null and destiny="default".
     *
     * @param botId  the bot's numeric ID
     * @param chatId the chat ID (may be 0 for user-only strategies)
     * @param userId the user ID (may be 0 for chat-only strategies)
     */
    public StorageKey(long botId, long chatId, long userId) {
        this(botId, chatId, userId, null, "default");
    }

    /** @return the bot's numeric ID */
    public long botId() {
        return botId;
    }

    /** @return the chat ID (may be 0 for user-only strategies) */
    public long chatId() {
        return chatId;
    }

    /** @return the user ID (may be 0 for chat-only strategies) */
    public long userId() {
        return userId;
    }

    /** @return the forum thread ID for topic-based isolation, or null */
    public @Nullable Long threadId() {
        return threadId;
    }

    /** @return the namespace qualifier */
    public String destiny() {
        return destiny;
    }

    /** @return the business connection the update came through, or null */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StorageKey)) {
            return false;
        }
        StorageKey that = (StorageKey) o;
        return botId == that.botId
            && chatId == that.chatId
            && userId == that.userId
            && Objects.equals(threadId, that.threadId)
            && Objects.equals(destiny, that.destiny)
            && Objects.equals(businessConnectionId, that.businessConnectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(botId, chatId, userId, threadId, destiny, businessConnectionId);
    }

    @Override
    public String toString() {
        return "StorageKey[botId=" + botId
            + ", chatId=" + chatId
            + ", userId=" + userId
            + ", threadId=" + threadId
            + ", destiny=" + destiny
            + ", businessConnectionId=" + businessConnectionId + "]";
    }
}
