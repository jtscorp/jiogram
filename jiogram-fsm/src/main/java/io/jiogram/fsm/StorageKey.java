package io.jiogram.fsm;

import org.jspecify.annotations.Nullable;
import java.util.Objects;

/**
 * Identifies a unique FSM storage entry. Combines bot, chat, and user identifiers
 * with optional thread and destiny qualifiers for fine-grained state isolation.
 */
public final class StorageKey {

    private final long botId;
    private final long chatId;
    private final long userId;
    private final @Nullable Long threadId;
    private final String destiny;

    public StorageKey(long botId, long chatId, long userId, @Nullable Long threadId, String destiny) {
        this.botId = botId;
        this.chatId = chatId;
        this.userId = userId;
        this.threadId = threadId;
        this.destiny = destiny;
    }

    /**
     * Convenience constructor with threadId=null and destiny="default".
     */
    public StorageKey(long botId, long chatId, long userId) {
        this(botId, chatId, userId, null, "default");
    }

    public long botId() {
        return botId;
    }

    public long chatId() {
        return chatId;
    }

    public long userId() {
        return userId;
    }

    public @Nullable Long threadId() {
        return threadId;
    }

    public String destiny() {
        return destiny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StorageKey)) return false;
        StorageKey that = (StorageKey) o;
        return botId == that.botId
            && chatId == that.chatId
            && userId == that.userId
            && Objects.equals(threadId, that.threadId)
            && Objects.equals(destiny, that.destiny);
    }

    @Override
    public int hashCode() {
        return Objects.hash(botId, chatId, userId, threadId, destiny);
    }

    @Override
    public String toString() {
        return "StorageKey[botId=" + botId
            + ", chatId=" + chatId
            + ", userId=" + userId
            + ", threadId=" + threadId
            + ", destiny=" + destiny + "]";
    }
}
