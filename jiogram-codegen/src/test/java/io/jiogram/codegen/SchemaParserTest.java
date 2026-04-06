package io.jiogram.codegen;

import io.jiogram.codegen.model.ApiSchema;
import io.jiogram.codegen.model.FieldDefinition;
import io.jiogram.codegen.model.MethodDefinition;
import io.jiogram.codegen.model.TypeDefinition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SchemaParserTest {

    private static ApiSchema schema;

    @BeforeAll
    static void parseTestSchema() throws Exception {
        File schemaFile = new File(
                Objects.requireNonNull(
                        SchemaParserTest.class.getClassLoader().getResource("test-schema.json")
                ).toURI()
        );
        schema = SchemaParser.parse(schemaFile);
    }

    @Test
    void apiVersion_isParsed() {
        assertEquals("9.6", schema.apiVersion());
    }

    @Test
    void types_areFound() {
        assertEquals(4, schema.types().size());

        var typeNames = schema.types().stream().map(TypeDefinition::name).toList();
        assertTrue(typeNames.contains("Update"));
        assertTrue(typeNames.contains("User"));
        assertTrue(typeNames.contains("Message"));
        assertTrue(typeNames.contains("ChatMember"));
    }

    @Test
    void methods_areFound() {
        assertEquals(4, schema.methods().size());

        var methodNames = schema.methods().stream().map(MethodDefinition::name).toList();
        assertTrue(methodNames.contains("getUpdates"));
        assertTrue(methodNames.contains("getMe"));
        assertTrue(methodNames.contains("sendMessage"));
        assertTrue(methodNames.contains("deleteWebhook"));
    }

    @Test
    void typeFields_areParsed() {
        TypeDefinition update = findType("Update");
        assertEquals(3, update.fields().size());

        FieldDefinition updateId = update.fields().stream()
                .filter(f -> f.name().equals("update_id"))
                .findFirst().orElseThrow();
        assertEquals("Integer", updateId.type());
        assertTrue(updateId.required());
    }

    @Test
    void methodParameters_areParsed() {
        MethodDefinition sendMessage = findMethod("sendMessage");
        assertEquals(3, sendMessage.parameters().size());

        FieldDefinition chatId = sendMessage.parameters().stream()
                .filter(f -> f.name().equals("chat_id"))
                .findFirst().orElseThrow();
        assertEquals("Integer or String", chatId.type());
        assertTrue(chatId.required());
    }

    @Test
    void returnType_arrayOfType() {
        MethodDefinition getUpdates = findMethod("getUpdates");
        assertEquals("Array of Update", getUpdates.returnType());
    }

    @Test
    void returnType_sentMessageIsReturned() {
        MethodDefinition sendMessage = findMethod("sendMessage");
        assertEquals("Message", sendMessage.returnType());
    }

    @Test
    void returnType_basicInfoInFormOf() {
        MethodDefinition getMe = findMethod("getMe");
        assertEquals("User", getMe.returnType());
    }

    @Test
    void returnType_trueOnSuccess() {
        MethodDefinition deleteWebhook = findMethod("deleteWebhook");
        assertEquals("Boolean", deleteWebhook.returnType());
    }

    @Test
    void unionField_isDetected() {
        MethodDefinition sendMessage = findMethod("sendMessage");
        FieldDefinition chatId = sendMessage.parameters().stream()
                .filter(f -> f.name().equals("chat_id"))
                .findFirst().orElseThrow();
        assertTrue(chatId.isUnion());
        assertEquals(2, chatId.unionTypes().size());

        FieldDefinition replyMarkup = sendMessage.parameters().stream()
                .filter(f -> f.name().equals("reply_markup"))
                .findFirst().orElseThrow();
        assertTrue(replyMarkup.isUnion());
        assertEquals(4, replyMarkup.unionTypes().size());
    }

    @Test
    void className_conversion() {
        MethodDefinition sendMessage = findMethod("sendMessage");
        assertEquals("SendMessage", sendMessage.className());

        MethodDefinition getMe = findMethod("getMe");
        assertEquals("GetMe", getMe.className());
    }

    @Test
    void categoryField_isParsedForTypes() {
        TypeDefinition update = findType("Update");
        assertEquals("Getting updates", update.category());

        TypeDefinition user = findType("User");
        assertEquals("Available types", user.category());
    }

    @Test
    void categoryField_isParsedForMethods() {
        MethodDefinition getUpdates = findMethod("getUpdates");
        assertEquals("Getting updates", getUpdates.category());

        MethodDefinition sendMessage = findMethod("sendMessage");
        assertEquals("Available methods", sendMessage.category());
    }

    private TypeDefinition findType(String name) {
        return schema.types().stream()
                .filter(t -> t.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Type not found: " + name));
    }

    private MethodDefinition findMethod(String name) {
        return schema.methods().stream()
                .filter(m -> m.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Method not found: " + name));
    }
}
