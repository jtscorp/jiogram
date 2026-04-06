package io.jiogram.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method as a handler for incoming callback queries.
 * Optionally filters by exact data match or data prefix.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnCallbackQuery {

    /**
     * Exact callback data to match. Empty string means no exact match filter.
     */
    String data() default "";

    /**
     * Callback data prefix to match. Empty string means no prefix filter.
     */
    String prefix() default "";
}
