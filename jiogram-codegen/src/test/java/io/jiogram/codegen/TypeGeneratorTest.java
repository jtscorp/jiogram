package io.jiogram.codegen;

import io.jiogram.codegen.model.FieldDefinition;
import io.jiogram.codegen.model.TypeDefinition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypeGeneratorTest {

    private static final String TYPES_PKG = "io.jiogram.types";
    private final TypeMapper typeMapper = new TypeMapper(TYPES_PKG);
    private final TypeGenerator generator = new TypeGenerator(typeMapper, TYPES_PKG);

    // ---- Simple POJO class (ChatPhoto) ----

    @Test
    void simpleRecord_generatesPojoClassWithAllRequiredFields() {
        TypeDefinition chatPhoto = new TypeDefinition("ChatPhoto", "Represents a chat photo.", List.of(
                new FieldDefinition("small_file_id", "String", true, "File identifier of small photo"),
                new FieldDefinition("small_file_unique_id", "String", true, "Unique file identifier of small photo"),
                new FieldDefinition("big_file_id", "String", true, "File identifier of big photo"),
                new FieldDefinition("big_file_unique_id", "String", true, "Unique file identifier of big photo")
        ), "Available types");

        String source = generator.generateToString(chatPhoto);

        assertTrue(source.contains("public class ChatPhoto"), "Should be a class");
        assertFalse(source.contains("record"), "Should not be a record");
        assertTrue(source.contains("@JsonProperty(\"small_file_id\") private final String smallFileId"), "field with annotation");
        assertTrue(source.contains("@JsonProperty(\"big_file_id\") private final String bigFileId"), "field with annotation");
        assertTrue(source.contains("@JsonCreator"), "Should have @JsonCreator constructor");
        assertTrue(source.contains("public String smallFileId()"), "Record-style accessor");
        assertTrue(source.contains("public String bigFileId()"), "Record-style accessor");
        assertFalse(source.contains("@Nullable"), "All fields required, no @Nullable");
    }

    // ---- POJO class with optional fields (User) ----

    @Test
    void recordWithOptionalFields_hasNullableAnnotations() {
        TypeDefinition user = new TypeDefinition("User", "Represents a Telegram user.", List.of(
                new FieldDefinition("id", "Integer", true, "Unique identifier"),
                new FieldDefinition("is_bot", "Boolean", true, "True if this user is a bot"),
                new FieldDefinition("first_name", "String", true, "User's first name"),
                new FieldDefinition("last_name", "String", false, "User's last name"),
                new FieldDefinition("username", "String", false, "User's username"),
                new FieldDefinition("language_code", "String", false, "IETF language tag")
        ), "Available types");

        String source = generator.generateToString(user);

        assertTrue(source.contains("public class User"), "Should be a class");
        // Required primitive fields use primitives
        assertTrue(source.contains("@JsonProperty(\"id\") private final long id"), "Required Integer -> long field");
        assertTrue(source.contains("@JsonProperty(\"is_bot\") private final boolean isBot"), "Required Boolean -> boolean field");
        // Required String
        assertTrue(source.contains("@JsonProperty(\"first_name\") private final String firstName"), "Required String field");
        // Optional String gets @Nullable on field
        assertTrue(source.contains("@JsonProperty(\"last_name\") @Nullable private final String lastName"), "Optional String -> @Nullable field");
        assertTrue(source.contains("@JsonProperty(\"username\") @Nullable private final String username"), "Optional String -> @Nullable field");
        // Accessors
        assertTrue(source.contains("public long id()"), "Record-style accessor");
        assertTrue(source.contains("public String firstName()"), "Record-style accessor");
        assertTrue(source.contains("public String lastName()"), "Record-style accessor for optional");
        // Imports
        assertTrue(source.contains("import org.jspecify.annotations.Nullable;"), "Should import Nullable");
        assertTrue(source.contains("import com.fasterxml.jackson.annotation.JsonProperty;"), "Should import JsonProperty");
        assertTrue(source.contains("import com.fasterxml.jackson.annotation.JsonCreator;"), "Should import JsonCreator");
    }

    // ---- Regular interface (ChatMember) — no sealed, no permits ----

    @Test
    void discriminatedUnionParent_generatesRegularInterface() {
        TypeDefinition chatMember = new TypeDefinition("ChatMember", "Represents a chat member.", List.of(), "Available types");

        String source = generator.generateToString(chatMember);

        assertTrue(source.contains("public interface ChatMember"), "Should be a regular interface");
        assertFalse(source.contains("sealed"), "Should NOT be sealed (Java 11 compat)");
        assertFalse(source.contains("permits"), "Should NOT have permits clause (Java 11 compat)");
        assertTrue(source.contains("@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = \"status\")"),
                "Should have @JsonTypeInfo with status discriminator");
        assertTrue(source.contains("@JsonSubTypes({"), "Should have @JsonSubTypes");
        assertTrue(source.contains("@JsonSubTypes.Type(value = ChatMemberOwner.class, name = \"creator\")"),
                "Should list ChatMemberOwner");
        assertTrue(source.contains("ChatMemberBanned"), "Should include ChatMemberBanned in @JsonSubTypes");
        assertFalse(source.contains("record"), "Should not be a record");
    }

    // ---- Subtype POJO class (ChatMemberOwner) implementing parent interface ----

    @Test
    void subtypeRecord_implementsParentInterface() {
        TypeDefinition chatMemberOwner = new TypeDefinition("ChatMemberOwner", "Represents a chat member that owns the chat.", List.of(
                new FieldDefinition("status", "String", true, "The member's status"),
                new FieldDefinition("user", "User", true, "Information about the user"),
                new FieldDefinition("is_anonymous", "Boolean", true, "True if presence is hidden"),
                new FieldDefinition("custom_title", "String", false, "Custom title for this user")
        ), "Available types");

        String source = generator.generateToString(chatMemberOwner);

        assertTrue(source.contains("public class ChatMemberOwner"), "Should be a class");
        assertFalse(source.contains("record"), "Should not be a record");
        assertTrue(source.contains("implements ChatMember"), "Should implement ChatMember");
        assertTrue(source.contains("@JsonProperty(\"status\") private final String status"), "Should have status field");
        assertTrue(source.contains("@JsonProperty(\"user\") private final User user"), "Should have user field");
        assertTrue(source.contains("@JsonProperty(\"is_anonymous\") private final boolean isAnonymous"), "Required boolean");
        assertTrue(source.contains("@JsonProperty(\"custom_title\") @Nullable private final String customTitle"), "Optional -> @Nullable field");
        assertTrue(source.contains("@JsonCreator"), "Should have @JsonCreator constructor");
        assertTrue(source.contains("public String status()"), "Record-style accessor");
        assertTrue(source.contains("public String customTitle()"), "Record-style accessor for optional");
    }

    // ---- Package declaration ----

    @Test
    void generatedCode_hasCorrectPackage() {
        TypeDefinition simple = new TypeDefinition("Foo", "Test type.", List.of(
                new FieldDefinition("bar", "String", true, "bar field")
        ), "Test");

        String source = generator.generateToString(simple);

        assertTrue(source.startsWith("package io.jiogram.types;\n"), "Should have correct package");
    }

    // ---- Array field types ----

    @Test
    void recordWithArrayField_usesListType() {
        TypeDefinition type = new TypeDefinition("MessageHolder", "Holds messages.", List.of(
                new FieldDefinition("messages", "Array of Message", true, "List of messages")
        ), "Test");

        String source = generator.generateToString(type);

        assertTrue(source.contains("List<Message> messages"), "Array of X -> List<X>");
        assertTrue(source.contains("import java.util.List;"), "Should import java.util.List");
    }

    // ---- Regular interface with type discriminator ----

    @Test
    void messageOrigin_generatesInterfaceWithTypeDiscriminator() {
        TypeDefinition messageOrigin = new TypeDefinition("MessageOrigin", "Describes the origin.", List.of(), "Available types");

        String source = generator.generateToString(messageOrigin);

        assertTrue(source.contains("public interface MessageOrigin"), "Should be a regular interface");
        assertFalse(source.contains("sealed"), "Should NOT be sealed (Java 11 compat)");
        assertFalse(source.contains("permits"), "Should NOT have permits clause");
        assertTrue(source.contains("property = \"type\""), "Should use 'type' discriminator");
        assertTrue(source.contains("MessageOriginUser"), "Should list subtypes in @JsonSubTypes");
    }
}
