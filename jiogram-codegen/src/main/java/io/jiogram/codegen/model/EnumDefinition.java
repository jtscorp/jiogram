package io.jiogram.codegen.model;

import java.util.List;

/**
 * Represents an enumeration type from the Telegram Bot API schema.
 */
public record EnumDefinition(
        String name,
        String description,
        List<String> values
) {
}
