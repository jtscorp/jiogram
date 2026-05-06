package io.jiogram.fsm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks an enum as a group of FSM states.
 * The Jiogram FSM annotation processor generates a companion constants class
 * named {@code <EnumName>States} for use in annotations such as
 * {@code @StateFilter(FormStates.WAITING_FOR_NAME)}.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface FSMStates {
}
