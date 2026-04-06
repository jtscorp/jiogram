package io.jiogram.codegen.model;

import java.util.List;

/**
 * Represents a Telegram Bot API type (e.g. Update, Message, User).
 */
public record TypeDefinition(
        String name,
        String description,
        List<FieldDefinition> fields,
        String category
) {
}
