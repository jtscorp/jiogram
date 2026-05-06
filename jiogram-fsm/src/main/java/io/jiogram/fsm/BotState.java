package io.jiogram.fsm;

/**
 * Optional legacy helper interface for FSM enum constants.
 * New code can use a plain enum annotated with {@link FSMStates} and call
 * {@link FSMContext#setState(Enum)} directly.
 * <p>
 * Enums that still implement this interface get a {@link #fullName()} method
 * that returns a unique string identifier in the format
 * "EnumSimpleName.CONSTANT_NAME".
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
