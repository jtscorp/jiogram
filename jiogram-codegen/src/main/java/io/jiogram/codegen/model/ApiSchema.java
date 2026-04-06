package io.jiogram.codegen.model;

import java.util.List;

/**
 * Root model representing the entire parsed Telegram Bot API schema.
 */
public record ApiSchema(
        String apiVersion,
        List<TypeDefinition> types,
        List<MethodDefinition> methods,
        List<EnumDefinition> enums
) {
}
