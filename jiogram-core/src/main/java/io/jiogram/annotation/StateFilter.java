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
     * <p>
     * When {@link #enumClass()} is set, this value is interpreted as the enum
     * constant name. Otherwise it is interpreted as the full state name.
     */
    String value() default "";

    /**
     * Optional enum class that owns the FSM state constant.
     */
    Class<? extends Enum<?>> enumClass() default NoState.class;

    /**
     * Sentinel used as the default for {@link #enumClass()}.
     */
    enum NoState {
        NONE
    }
}
