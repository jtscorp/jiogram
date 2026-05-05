package io.jiogram.codegen;

import io.jiogram.codegen.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnumGeneratorTest {

    private static final String TYPES_PKG = "io.jiogram.types";
    private final EnumGenerator generator = new EnumGenerator(TYPES_PKG);

    // ---- EnumGenerator: basic enum ----

    @Test
    void chatAction_generatesEnumWithCorrectConstants() {
        EnumDefinition chatAction = new EnumDefinition("ChatAction", "Type of action.", List.of(
                "typing", "upload_photo", "record_video", "upload_video"
        ));

        String source = generator.generateToString(chatAction);

        assertTrue(source.contains("public enum ChatAction {"), "Should be an enum");
        assertTrue(source.contains("TYPING(\"typing\")"), "snake_case -> UPPER_SNAKE_CASE");
        assertTrue(source.contains("UPLOAD_PHOTO(\"upload_photo\")"), "snake_case -> UPPER_SNAKE_CASE");
        assertTrue(source.contains("RECORD_VIDEO(\"record_video\")"), "snake_case -> UPPER_SNAKE_CASE");
        assertTrue(source.contains("UPLOAD_VIDEO(\"upload_video\")"), "snake_case -> UPPER_SNAKE_CASE");
    }

    @Test
    void enum_hasJsonValueAnnotation() {
        EnumDefinition enumDef = new EnumDefinition("TestEnum", "Test.", List.of("foo"));
        String source = generator.generateToString(enumDef);

        assertTrue(source.contains("@JsonValue"), "Should have @JsonValue");
        assertTrue(source.contains("public String value()"), "Should have value() method");
    }

    @Test
    void enum_hasJsonCreatorAnnotation() {
        EnumDefinition enumDef = new EnumDefinition("TestEnum", "Test.", List.of("foo"));
        String source = generator.generateToString(enumDef);

        assertTrue(source.contains("@JsonCreator"), "Should have @JsonCreator");
        assertTrue(source.contains("public static TestEnum fromValue(String value)"), "Should have fromValue()");
    }

    @Test
    void enum_hasCorrectImports() {
        EnumDefinition enumDef = new EnumDefinition("TestEnum", "Test.", List.of("foo"));
        String source = generator.generateToString(enumDef);

        assertTrue(source.contains("import com.fasterxml.jackson.annotation.JsonCreator;"), "Should import JsonCreator");
        assertTrue(source.contains("import com.fasterxml.jackson.annotation.JsonValue;"), "Should import JsonValue");
    }

    @Test
    void enum_hasCorrectPackage() {
        EnumDefinition enumDef = new EnumDefinition("TestEnum", "Test.", List.of("foo"));
        String source = generator.generateToString(enumDef);

        assertTrue(source.startsWith("package io.jiogram.types;\n"), "Should have correct package");
    }

    @Test
    void parseMode_handlesMixedCaseValues() {
        EnumDefinition parseMode = new EnumDefinition("ParseMode", "Formatting options.", List.of(
                "HTML", "Markdown", "MarkdownV2"
        ));

        String source = generator.generateToString(parseMode);

        assertTrue(source.contains("HTML(\"HTML\")"), "Already uppercase stays uppercase");
        assertTrue(source.contains("MARKDOWN(\"Markdown\")"), "PascalCase -> UPPER_SNAKE_CASE");
        assertTrue(source.contains("MARKDOWN_V2(\"MarkdownV2\")"), "Mixed case with number");
    }

    // ---- toConstantName ----

    @Test
    void toConstantName_snakeCase() {
        assertEquals("UPLOAD_PHOTO", EnumGenerator.toConstantName("upload_photo"));
        assertEquals("TYPING", EnumGenerator.toConstantName("typing"));
    }

    @Test
    void toConstantName_alreadyUpperCase() {
        assertEquals("HTML", EnumGenerator.toConstantName("HTML"));
    }

    @Test
    void toConstantName_pascalCase() {
        assertEquals("MARKDOWN", EnumGenerator.toConstantName("Markdown"));
        assertEquals("MARKDOWN_V2", EnumGenerator.toConstantName("MarkdownV2"));
    }

    @Test
    void toConstantName_mimeType() {
        assertEquals("IMAGE_JPEG", EnumGenerator.toConstantName("image/jpeg"));
        assertEquals("VIDEO_MP4", EnumGenerator.toConstantName("video/mp4"));
    }

    // ---- EnumExtractor ----

    @Test
    void extractor_extractsWellKnownEnums() {
        // Build a minimal schema with an Update type
        ApiSchema schema = new ApiSchema("7.0", List.of(
                new TypeDefinition("Update", "An incoming update.", List.of(
                        new FieldDefinition("update_id", "Integer", true, ""),
                        new FieldDefinition("message", "Message", false, ""),
                        new FieldDefinition("callback_query", "CallbackQuery", false, "")
                ), "Getting updates")
        ), List.of(), List.of());

        List<EnumDefinition> enums = EnumExtractor.extract(schema);

        // ParseMode
        assertTrue(enums.stream().anyMatch(e -> "ParseMode".equals(e.name())),
                "Should extract ParseMode");
        EnumDefinition parseMode = enums.stream()
                .filter(e -> "ParseMode".equals(e.name())).findFirst().orElseThrow();
        assertEquals(List.of("HTML", "Markdown", "MarkdownV2"), parseMode.values());

        // UpdateType — should have message and callback_query (not update_id)
        assertTrue(enums.stream().anyMatch(e -> "UpdateType".equals(e.name())),
                "Should extract UpdateType");
        EnumDefinition updateType = enums.stream()
                .filter(e -> "UpdateType".equals(e.name())).findFirst().orElseThrow();
        assertTrue(updateType.values().contains("message"), "UpdateType should include message");
        assertTrue(updateType.values().contains("callback_query"), "UpdateType should include callback_query");
        assertFalse(updateType.values().contains("update_id"), "UpdateType should not include update_id");

        // ContentType
        assertTrue(enums.stream().anyMatch(e -> "ContentType".equals(e.name())),
                "Should extract ContentType");
    }

    @Test
    void extractor_extractsFromDescriptions() {
        ApiSchema schema = new ApiSchema("7.0", List.of(
                new TypeDefinition("Chat", "Represents a chat.", List.of(
                        new FieldDefinition("id", "Integer", true, ""),
                        new FieldDefinition("type", "String", true,
                                "Type of the chat, can be either \"private\", \"group\", \"supergroup\" or \"channel\"")
                ), "Available types")
        ), List.of(
                new MethodDefinition("sendChatAction", "Send chat action.", List.of(
                        new FieldDefinition("chat_id", "Integer or String", true, ""),
                        new FieldDefinition("action", "String", true,
                                "Type of action: \"typing\", \"upload_photo\", \"record_video\"")
                ), "Boolean", "Available methods")
        ), List.of());

        List<EnumDefinition> enums = EnumExtractor.extract(schema);

        // ChatType
        assertTrue(enums.stream().anyMatch(e -> "ChatType".equals(e.name())),
                "Should extract ChatType from Chat.type description");
        EnumDefinition chatType = enums.stream()
                .filter(e -> "ChatType".equals(e.name())).findFirst().orElseThrow();
        assertEquals(List.of("private", "group", "supergroup", "channel"), chatType.values());

        // ChatAction
        assertTrue(enums.stream().anyMatch(e -> "ChatAction".equals(e.name())),
                "Should extract ChatAction from sendChatAction.action description");
        EnumDefinition chatAction = enums.stream()
                .filter(e -> "ChatAction".equals(e.name())).findFirst().orElseThrow();
        assertEquals(List.of(
                "typing", "upload_photo", "record_video", "upload_video",
                "record_voice", "upload_voice", "upload_document",
                "choose_sticker", "find_location", "record_video_note",
                "upload_video_note"
        ), chatAction.values());
    }

    @Test
    void extractor_extractsUnionDiscriminatorEnums() {
        ApiSchema schema = new ApiSchema("7.0", List.of(), List.of(), List.of());

        List<EnumDefinition> enums = EnumExtractor.extract(schema);

        // ChatMemberType from the ChatMember union
        assertTrue(enums.stream().anyMatch(e -> "ChatMemberType".equals(e.name())),
                "Should extract ChatMemberType from union registry");
        EnumDefinition cmType = enums.stream()
                .filter(e -> "ChatMemberType".equals(e.name())).findFirst().orElseThrow();
        assertTrue(cmType.values().contains("creator"), "Should include 'creator' discriminator value");
        assertTrue(cmType.values().contains("administrator"), "Should include 'administrator' discriminator value");
    }

    @Test
    void extractQuotedValues_extractsCorrectly() {
        List<String> values = EnumExtractor.extractQuotedValues(
                "can be either \"private\", \"group\", \"supergroup\" or \"channel\"");
        assertEquals(List.of("private", "group", "supergroup", "channel"), values);
    }

    @Test
    void extractQuotedValues_emptyString_returnsEmpty() {
        List<String> values = EnumExtractor.extractQuotedValues("No quoted values here.");
        assertTrue(values.isEmpty());
    }
}
