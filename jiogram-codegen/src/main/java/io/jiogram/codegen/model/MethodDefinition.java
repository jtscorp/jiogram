package io.jiogram.codegen.model;

import java.util.List;

/**
 * Represents a Telegram Bot API method (e.g. sendMessage, getUpdates).
 */
public record MethodDefinition(
        String name,
        String description,
        List<FieldDefinition> parameters,
        String returnType,
        String category
) {

    /**
     * Converts the camelCase method name to PascalCase class name.
     * Example: "sendMessage" -> "SendMessage", "getMe" -> "GetMe"
     */
    public String className() {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
