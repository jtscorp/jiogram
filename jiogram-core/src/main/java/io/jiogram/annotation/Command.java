package io.jiogram.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies command names to filter on when combined with {@link OnMessage}.
 * Commands should be provided without the leading slash (e.g., "start", "help").
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

    /**
     * The command names to match (without leading slash).
     */
    String[] value();
}
