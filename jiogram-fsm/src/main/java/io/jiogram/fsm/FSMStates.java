package io.jiogram.fsm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks an enum as an FSM state group.
 * The annotation processor generates a companion {@code <EnumName>States}
 * class with string constants usable from {@code @StateFilter}.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface FSMStates {
}
