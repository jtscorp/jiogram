package io.jiogram.fsm;

import io.jiogram.filter.NamedState;

/**
 * Optional marker interface for state enums used in the FSM (Finite State Machine).
 * Implementing enums get a {@link #fullName()} method that returns the name the state is
 * stored under, following the {@link NamedState} rule ("EnumName.CONSTANT_NAME", with
 * enclosing types for nested enums).
 * <p>
 * New code can also use plain enums with {@link FSMStates} and
 * {@link FSMContext#setState(Enum)}. If you override {@link #fullName()}, use that same
 * string in {@code @StateFilter}: the {@link FSMStates} constants follow the default rule.
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
public interface BotState extends NamedState {
}
