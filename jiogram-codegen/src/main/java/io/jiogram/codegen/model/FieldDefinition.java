package io.jiogram.codegen.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Represents a single field (annotation) from the Telegram Bot API schema.
 * Used for both type fields and method parameters.
 */
public record FieldDefinition(
        String name,
        String type,
        boolean required,
        String description
) {

    private static final Pattern SNAKE_SEGMENT = Pattern.compile("_([a-z])");

    /**
     * Converts the snake_case field name to camelCase Java convention.
     * Example: "chat_id" -> "chatId", "message_thread_id" -> "messageThreadId"
     */
    public String javaName() {
        return SNAKE_SEGMENT.matcher(name)
                .replaceAll(mr -> mr.group(1).toUpperCase());
    }

    /**
     * Returns true if the type represents an array, e.g. "Array of String".
     */
    public boolean isArray() {
        return type.startsWith("Array of ");
    }

    /**
     * Extracts the element type from an array type string.
     * "Array of Update" -> "Update"
     * "Array of Array of PhotoSize" -> "Array of PhotoSize"
     * Returns the full type string unchanged if this is not an array type.
     */
    public String arrayElementType() {
        if (!isArray()) {
            return type;
        }
        return type.substring("Array of ".length());
    }

    /**
     * Returns true if the type represents a union (contains " or ").
     * Example: "Integer or String", "InputFile or String"
     */
    public boolean isUnion() {
        return type.contains(" or ");
    }

    /**
     * Splits a union type into its constituent types.
     * "Integer or String" -> ["Integer", "String"]
     * "InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply"
     *   -> ["InlineKeyboardMarkup", "ReplyKeyboardMarkup", "ReplyKeyboardRemove", "ForceReply"]
     * Returns a single-element list with the full type if this is not a union.
     */
    public List<String> unionTypes() {
        if (!isUnion()) {
            return List.of(type);
        }
        return Arrays.stream(type.split(" or "))
                .map(String::trim)
                .toList();
    }
}
