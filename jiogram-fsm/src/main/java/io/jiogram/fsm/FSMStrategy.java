package io.jiogram.fsm;

/**
 * Defines how the FSM storage key is resolved from an update.
 * Determines the granularity of state isolation.
 */
public enum FSMStrategy {

    /**
     * State is isolated per user within a specific chat.
     * This is the most common strategy: each user has their own state in each chat.
     */
    USER_IN_CHAT,

    /**
     * State is isolated per chat only.
     * All users in the same chat share the same state.
     */
    CHAT,

    /**
     * State is isolated per user globally.
     * The user has the same state regardless of which chat the update came from.
     */
    USER,

    /**
     * State is isolated per chat topic (forum thread).
     * Uses the message_thread_id for additional isolation within forum-style chats.
     */
    CHAT_TOPIC
}
