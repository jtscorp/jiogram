package io.jiogram.fsm;

/**
 * Defines how the FSM storage key is resolved from an update.
 * Determines the granularity of state isolation.
 * <p>
 * Strategies that need a user skip FSM for updates without one (channel posts, reaction
 * counts, boosts); strategies that need a chat fall back to the user's private chat for
 * updates without a chat (inline queries, payments). Updates sent through a business
 * connection are additionally scoped to that connection.
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
     * State is isolated per user within a forum topic: each user has their own state in each
     * topic. Outside forum topics this behaves like {@link #USER_IN_CHAT}.
     */
    USER_IN_TOPIC,

    /**
     * State is isolated per forum topic: all users in the same topic share the same state.
     * Outside forum topics this behaves like {@link #CHAT}.
     */
    CHAT_TOPIC
}
