package io.jiogram.codegen;

import io.jiogram.codegen.model.FieldDefinition;
import io.jiogram.codegen.model.MethodDefinition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodGeneratorTest {

    private static final String TYPES_PKG = "io.jiogram.types";
    private static final String METHODS_PKG = "io.jiogram.methods";
    private final TypeMapper typeMapper = new TypeMapper(TYPES_PKG);
    private final MethodGenerator generator = new MethodGenerator(typeMapper, METHODS_PKG, TYPES_PKG);

    // ---- SendMessage (returns Message, has required + optional params) ----

    @Test
    void sendMessage_generatesRecordImplementingTelegramMethod() {
        MethodDefinition sendMessage = new MethodDefinition("sendMessage",
                "Use this method to send text messages.",
                List.of(
                        new FieldDefinition("chat_id", "Integer or String", true, "Unique identifier for the target chat"),
                        new FieldDefinition("text", "String", true, "Text of the message"),
                        new FieldDefinition("parse_mode", "String", false, "Mode for parsing entities"),
                        new FieldDefinition("disable_notification", "Boolean", false, "Sends the message silently")
                ),
                "Message", "Available methods");

        String source = generator.generateToString(sendMessage);

        assertTrue(source.contains("public record SendMessage("), "Should be a record named SendMessage");
        assertTrue(source.contains("implements TelegramMethod<Message>"), "Should implement TelegramMethod<Message>");
        assertTrue(source.contains("@JsonProperty(\"chat_id\") ChatId chatId"), "Required union -> ChatId");
        assertTrue(source.contains("@JsonProperty(\"text\") String text"), "Required String");
        assertTrue(source.contains("@JsonProperty(\"parse_mode\") @Nullable ParseMode parseMode"),
                "parse_mode -> @Nullable ParseMode");
        assertTrue(source.contains("@JsonProperty(\"disable_notification\") @Nullable Boolean disableNotification"),
                "Optional Boolean -> @Nullable Boolean");
    }

    @Test
    void sendMessage_hasApiMethodOverride() {
        MethodDefinition sendMessage = new MethodDefinition("sendMessage",
                "Send text messages.", List.of(
                new FieldDefinition("chat_id", "Integer or String", true, ""),
                new FieldDefinition("text", "String", true, "")
        ), "Message", "Available methods");

        String source = generator.generateToString(sendMessage);

        assertTrue(source.contains("@Override"), "Should have @Override");
        assertTrue(source.contains("public String apiMethod()"), "Should have apiMethod()");
        assertTrue(source.contains("return \"sendMessage\""), "Should return original method name");
    }

    @Test
    void sendMessage_hasApiReturnTypeOverride() {
        MethodDefinition sendMessage = new MethodDefinition("sendMessage",
                "Send text messages.", List.of(
                new FieldDefinition("chat_id", "Integer or String", true, ""),
                new FieldDefinition("text", "String", true, "")
        ), "Message", "Available methods");

        String source = generator.generateToString(sendMessage);

        assertTrue(source.contains("public String apiReturnType()"), "Should have apiReturnType()");
        assertTrue(source.contains("return \"Message\""), "Should return the return type string");
    }

    @Test
    void sendMessage_hasStaticFactory() {
        MethodDefinition sendMessage = new MethodDefinition("sendMessage",
                "Send text messages.", List.of(
                new FieldDefinition("chat_id", "Integer or String", true, ""),
                new FieldDefinition("text", "String", true, ""),
                new FieldDefinition("parse_mode", "String", false, "")
        ), "Message", "Available methods");

        String source = generator.generateToString(sendMessage);

        assertTrue(source.contains("public static SendMessage of(ChatId chatId, String text)"),
                "Factory should have only required params");
        assertTrue(source.contains("return new SendMessage(chatId, text, null)"),
                "Factory should pass null for optional params");
    }

    @Test
    void sendMessage_hasCorrectImports() {
        MethodDefinition sendMessage = new MethodDefinition("sendMessage",
                "Send text messages.", List.of(
                new FieldDefinition("chat_id", "Integer or String", true, ""),
                new FieldDefinition("text", "String", true, ""),
                new FieldDefinition("parse_mode", "String", false, "")
        ), "Message", "Available methods");

        String source = generator.generateToString(sendMessage);

        assertTrue(source.contains("package io.jiogram.methods;"), "Should have methods package");
        assertTrue(source.contains("import com.fasterxml.jackson.annotation.JsonProperty;"), "Should import JsonProperty");
        assertTrue(source.contains("import io.jiogram.types.TelegramMethod;"), "Should import TelegramMethod");
        assertTrue(source.contains("import io.jiogram.types.ChatId;"), "Should import ChatId");
        assertTrue(source.contains("import io.jiogram.types.Message;"), "Should import Message");
        assertTrue(source.contains("import org.jspecify.annotations.Nullable;"), "Should import Nullable");
    }

    // ---- GetMe (no params, returns User) ----

    @Test
    void getMe_generatesRecordWithNoParams() {
        MethodDefinition getMe = new MethodDefinition("getMe",
                "Returns basic information about the bot.",
                List.of(),
                "User", "Getting updates");

        String source = generator.generateToString(getMe);

        assertTrue(source.contains("public record GetMe("), "Should be named GetMe");
        assertTrue(source.contains("implements TelegramMethod<User>"), "Should implement TelegramMethod<User>");
        assertTrue(source.contains("return \"getMe\""), "apiMethod should return 'getMe'");
        assertTrue(source.contains("return \"User\""), "apiReturnType should return 'User'");
        // No static factory needed when there are no params at all
        assertFalse(source.contains("public static GetMe of("), "No factory needed for no-param method");
    }

    // ---- GetUpdates (returns Array of Update -> List<Update>) ----

    @Test
    void getUpdates_returnsListOfUpdate() {
        MethodDefinition getUpdates = new MethodDefinition("getUpdates",
                "Use this method to receive incoming updates.",
                List.of(
                        new FieldDefinition("offset", "Integer", false, ""),
                        new FieldDefinition("limit", "Integer", false, ""),
                        new FieldDefinition("timeout", "Integer", false, ""),
                        new FieldDefinition("allowed_updates", "Array of String", false, "")
                ),
                "Array of Update", "Getting updates");

        String source = generator.generateToString(getUpdates);

        assertTrue(source.contains("public record GetUpdates("), "Should be named GetUpdates");
        assertTrue(source.contains("implements TelegramMethod<List<Update>>"),
                "Array of Update -> TelegramMethod<List<Update>>");
        assertTrue(source.contains("return \"getUpdates\""), "apiMethod should return 'getUpdates'");
        assertTrue(source.contains("return \"Array of Update\""), "apiReturnType returns raw string");
        assertTrue(source.contains("import java.util.List;"), "Should import List");
        assertTrue(source.contains("import io.jiogram.types.Update;"), "Should import Update");
    }

    @Test
    void getUpdates_optionalIntegerFieldsAreBoxed() {
        MethodDefinition getUpdates = new MethodDefinition("getUpdates",
                "Use this method to receive incoming updates.",
                List.of(
                        new FieldDefinition("offset", "Integer", false, ""),
                        new FieldDefinition("limit", "Integer", false, "")
                ),
                "Array of Update", "Getting updates");

        String source = generator.generateToString(getUpdates);

        assertTrue(source.contains("@JsonProperty(\"offset\") @Nullable Long offset"),
                "Optional Integer -> @Nullable Long");
        assertTrue(source.contains("@JsonProperty(\"limit\") @Nullable Long limit"),
                "Optional Integer -> @Nullable Long");
    }

    @Test
    void getUpdates_hasStaticFactory_allOptional() {
        MethodDefinition getUpdates = new MethodDefinition("getUpdates",
                "Use this method to receive incoming updates.",
                List.of(
                        new FieldDefinition("offset", "Integer", false, ""),
                        new FieldDefinition("limit", "Integer", false, "")
                ),
                "Array of Update", "Getting updates");

        String source = generator.generateToString(getUpdates);

        // Factory with no required params -> of()
        assertTrue(source.contains("public static GetUpdates of()"),
                "Factory should have no params when all optional");
        assertTrue(source.contains("return new GetUpdates(null, null)"),
                "Factory should pass null for all optional params");
    }

    // ---- Boolean return type ----

    @Test
    void booleanReturnType_wrapsToBoxedBoolean() {
        MethodDefinition deleteMessage = new MethodDefinition("deleteMessage",
                "Use this method to delete a message.",
                List.of(
                        new FieldDefinition("chat_id", "Integer or String", true, ""),
                        new FieldDefinition("message_id", "Integer", true, "")
                ),
                "Boolean", "Available methods");

        String source = generator.generateToString(deleteMessage);

        assertTrue(source.contains("implements TelegramMethod<Boolean>"),
                "Boolean return type -> TelegramMethod<Boolean>");
    }
}
