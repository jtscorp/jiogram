package io.jiogram.fsm;

/**
 * Marker interface for state enums used in the FSM (Finite State Machine).
 * Implementing enums get a {@link #fullName()} method that returns a unique
 * string identifier in the format "EnumSimpleName.CONSTANT_NAME".
 *
 * <p>Example:
 * <pre>{@code
 * public enum OrderState implements BotState {
 *     WAITING_FOR_NAME,
 *     WAITING_FOR_ADDRESS,
 *     CONFIRM
 * }
 * // OrderState.WAITING_FOR_NAME.fullName() -> "OrderState.WAITING_FOR_NAME"
 * }</pre>
 */
public interface BotState {

    /**
     * Returns the fully qualified state name in the format "EnumSimpleName.CONSTANT_NAME".
     * This is used as the storage key for FSM state persistence.
     *
     * @return the full state name
     */
    default String fullName() {
        return getClass().getSimpleName() + "." + ((Enum<?>) this).name();
    }
}
