package io.jiogram.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies an FSM state filter. When present, the handler only triggers
 * if the current state (from "raw_state" in the context) matches this value.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StateFilter {

    /**
     * The state name to match against the current FSM state.
     * When {@link #enumClass()} is set, this is the enum constant name.
     *
     * @return the state name or enum constant name
     */
    String value();

    /**
     * Optional enum class used to build a state name as
     * {@code EnumSimpleName.CONSTANT_NAME}.
     *
     * @return the enum class, or {@link Void} when raw string matching is used
     */
    Class<?> enumClass() default Void.class;
}
