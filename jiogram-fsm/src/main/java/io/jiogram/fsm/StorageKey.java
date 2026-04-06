package io.jiogram.fsm;

import org.jspecify.annotations.Nullable;

/**
 * Identifies a unique FSM storage entry. Combines bot, chat, and user identifiers
 * with optional thread and destiny qualifiers for fine-grained state isolation.
 *
 * @param botId    the bot's numeric ID
 * @param chatId   the chat ID (may be 0 for user-only strategies)
 * @param userId   the user ID (may be 0 for chat-only strategies)
 * @param threadId optional forum thread ID for topic-based isolation
 * @param destiny  a namespace qualifier, defaults to "default"
 */
public record StorageKey(
    long botId,
    long chatId,
    long userId,
    @Nullable Long threadId,
    String destiny
) {

    /**
     * Convenience constructor with threadId=null and destiny="default".
     */
    public StorageKey(long botId, long chatId, long userId) {
        this(botId, chatId, userId, null, "default");
    }
}
