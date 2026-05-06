package io.jiogram.fsm;

/**
 * Optional legacy marker interface for FSM state enums.
 * New code can use plain enums annotated with {@link FSMStates}; this interface
 * remains for existing code that calls {@link #fullName()} directly or stores
 * states through {@link FSMContext#setBotState(BotState)}.
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
        Enum<?> state = (Enum<?>) this;
        return state.getDeclaringClass().getSimpleName() + "." + state.name();
    }
}
