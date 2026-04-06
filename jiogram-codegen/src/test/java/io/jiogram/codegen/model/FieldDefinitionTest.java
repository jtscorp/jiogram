package io.jiogram.codegen.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FieldDefinitionTest {

    @Test
    void javaName_convertsSnakeCaseToCamelCase() {
        var field = new FieldDefinition("chat_id", "Integer", true, "Chat identifier");
        assertEquals("chatId", field.javaName());
    }

    @Test
    void javaName_handlesMultipleUnderscores() {
        var field = new FieldDefinition("message_thread_id", "Integer", false, "Thread id");
        assertEquals("messageThreadId", field.javaName());
    }

    @Test
    void javaName_noUnderscores_unchanged() {
        var field = new FieldDefinition("offset", "Integer", false, "Offset");
        assertEquals("offset", field.javaName());
    }

    @Test
    void isArray_detectsArrayType() {
        var field = new FieldDefinition("results", "Array of Update", true, "List of updates");
        assertTrue(field.isArray());
    }

    @Test
    void isArray_nonArrayType() {
        var field = new FieldDefinition("text", "String", true, "Message text");
        assertFalse(field.isArray());
    }

    @Test
    void arrayElementType_extractsElementType() {
        var field = new FieldDefinition("results", "Array of Update", true, "List of updates");
        assertEquals("Update", field.arrayElementType());
    }

    @Test
    void arrayElementType_nestedArray() {
        var field = new FieldDefinition("keyboard", "Array of Array of KeyboardButton", true, "Keyboard");
        assertEquals("Array of KeyboardButton", field.arrayElementType());
    }

    @Test
    void arrayElementType_nonArray_returnsFullType() {
        var field = new FieldDefinition("text", "String", true, "Text");
        assertEquals("String", field.arrayElementType());
    }

    @Test
    void isUnion_detectsUnionType() {
        var field = new FieldDefinition("chat_id", "Integer or String", true, "Chat id");
        assertTrue(field.isUnion());
    }

    @Test
    void isUnion_nonUnionType() {
        var field = new FieldDefinition("text", "String", true, "Text");
        assertFalse(field.isUnion());
    }

    @Test
    void unionTypes_splitsTwoTypes() {
        var field = new FieldDefinition("chat_id", "Integer or String", true, "Chat id");
        assertEquals(List.of("Integer", "String"), field.unionTypes());
    }

    @Test
    void unionTypes_splitsMultipleTypes() {
        var field = new FieldDefinition("reply_markup",
                "InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply",
                false, "Markup");
        assertEquals(
                List.of("InlineKeyboardMarkup", "ReplyKeyboardMarkup", "ReplyKeyboardRemove", "ForceReply"),
                field.unionTypes()
        );
    }

    @Test
    void unionTypes_nonUnion_returnsSingleElementList() {
        var field = new FieldDefinition("text", "String", true, "Text");
        assertEquals(List.of("String"), field.unionTypes());
    }
}
