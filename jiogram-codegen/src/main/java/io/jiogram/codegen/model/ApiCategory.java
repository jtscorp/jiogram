package io.jiogram.codegen.model;

import java.util.List;

/**
 * Represents a top-level category grouping in the Telegram Bot API
 * (e.g. "Getting updates", "Available types", "Available methods").
 */
public record ApiCategory(
        String title,
        List<TypeDefinition> types,
        List<MethodDefinition> methods
) {
}
