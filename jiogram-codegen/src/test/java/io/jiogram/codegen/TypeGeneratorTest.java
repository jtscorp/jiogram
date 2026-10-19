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

    // ---- Simple record (ChatPhoto) ----

    @Test
    void simpleRecord_generatesRecordWithAllRequiredFields() {
        TypeDefinition chatPhoto = new TypeDefinition("ChatPhoto", "Represents a chat photo.", List.of(
                new FieldDefinition("small_file_id", "String", true, "File identifier of small photo"),
                new FieldDefinition("small_file_unique_id", "String", true, "Unique file identifier of small photo"),
                new FieldDefinition("big_file_id", "String", true, "File identifier of big photo"),
                new FieldDefinition("big_file_unique_id", "String", true, "Unique file identifier of big photo")
        ), "Available types");

        String source = generator.generateToString(chatPhoto);

        assertTrue(source.contains("public record ChatPhoto("), "Should be a record");
        assertTrue(source.contains("@JsonProperty(\"small_file_id\") String smallFileId"), "camelCase field");
        assertTrue(source.contains("@JsonProperty(\"big_file_id\") String bigFileId"), "camelCase field");
        assertFalse(source.contains("@Nullable"), "All fields required, no @Nullable");
    }

    // ---- Record with optional fields (User) ----

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

        assertTrue(source.contains("public record User("), "Should be a record");
        // Required primitive fields use primitives
        assertTrue(source.contains("@JsonProperty(\"id\") long id"), "Required Integer -> long");
        assertTrue(source.contains("@JsonProperty(\"is_bot\") boolean isBot"), "Required Boolean -> boolean");
        // Required String
        assertTrue(source.contains("@JsonProperty(\"first_name\") String firstName"), "Required String");
        // Optional String gets @Nullable
        assertTrue(source.contains("@JsonProperty(\"last_name\") @Nullable String lastName"), "Optional String -> @Nullable");
        assertTrue(source.contains("@JsonProperty(\"username\") @Nullable String username"), "Optional String -> @Nullable");
        // Imports
        assertTrue(source.contains("import org.jspecify.annotations.Nullable;"), "Should import Nullable");
        assertTrue(source.contains("import com.fasterxml.jackson.annotation.JsonProperty;"), "Should import JsonProperty");
    }

    // ---- Sealed interface (ChatMember) ----

    @Test
    void discriminatedUnionParent_generatesSealedInterface() {
        TypeDefinition chatMember = new TypeDefinition("ChatMember", "Represents a chat member.", List.of(), "Available types");

        String source = generator.generateToString(chatMember);

        assertTrue(source.contains("public sealed interface ChatMember"), "Should be sealed interface");
        assertTrue(source.contains("@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = \"status\", "
                        + "visible = true, defaultImpl = ChatMemberUnknown.class)"),
                "Should have @JsonTypeInfo with status discriminator and Unknown fallback");
        assertTrue(source.contains("@JsonSubTypes({"), "Should have @JsonSubTypes");
        assertTrue(source.contains("@JsonSubTypes.Type(value = ChatMemberOwner.class, name = \"creator\")"),
                "Should list ChatMemberOwner");
        assertTrue(source.contains("permits"), "Should have permits clause");
        assertTrue(source.contains("ChatMemberOwner"), "Permits should include ChatMemberOwner");
        assertTrue(source.contains("ChatMemberBanned"), "Permits should include ChatMemberBanned");
        assertTrue(source.contains(", ChatMemberUnknown {}"), "Permits should end with the Unknown fallback");
        assertFalse(source.contains("record"), "Should not be a record");
    }

    @Test
    void valueBasedUnionParent_hasNoUnknownFallback() {
        TypeDefinition maybe = new TypeDefinition("MaybeInaccessibleMessage", "Message or inaccessible.", List.of(), "Available types");

        String source = generator.generateToString(maybe);

        assertTrue(source.contains("@JsonTypeIdResolver(MaybeInaccessibleMessageTypeIdResolver.class)"));
        assertFalse(source.contains("Unknown"), "Value-based union should not get an Unknown variant");
    }

    @Test
    void unknownVariant_holdsRawDiscriminatorAndData() {
        String source = generator.generateUnknownVariant("ChatMember");

        assertTrue(source.contains("@JsonSerialize(using = UnknownVariant.Serializer.class)"));
        assertTrue(source.contains("public record ChatMemberUnknown("), "Should be a record");
        assertTrue(source.contains("@JsonProperty(\"status\") @Nullable String status"), "Raw discriminator as String");
        assertTrue(source.contains("@JsonAnySetter Map<String, Object> data"), "Remaining fields in data");
        assertTrue(source.contains("implements ChatMember, UnknownVariant"));
        assertTrue(source.contains("return \"status\";"), "discriminatorName() returns the JSON name");
    }

    // ---- Subtype record (ChatMemberOwner) ----

    @Test
    void subtypeRecord_implementsParentInterface() {
        TypeDefinition chatMemberOwner = new TypeDefinition("ChatMemberOwner", "Represents a chat member that owns the chat.", List.of(
                new FieldDefinition("status", "String", true, "The member's status"),
                new FieldDefinition("user", "User", true, "Information about the user"),
                new FieldDefinition("is_anonymous", "Boolean", true, "True if presence is hidden"),
                new FieldDefinition("custom_title", "String", false, "Custom title for this user")
        ), "Available types");

        String source = generator.generateToString(chatMemberOwner);

        assertTrue(source.contains("public record ChatMemberOwner("), "Should be a record");
        assertTrue(source.contains("implements ChatMember"), "Should implement ChatMember");
        assertTrue(source.contains("@JsonProperty(value = \"status\", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status"),
                "Discriminator is a write-only enum field (Jackson writes the type id itself)");
        assertTrue(source.contains("@JsonProperty(\"user\") User user"), "Should have user field");
        assertTrue(source.contains("@JsonProperty(\"is_anonymous\") boolean isAnonymous"), "Required boolean");
        assertTrue(source.contains("@JsonProperty(\"custom_title\") @Nullable String customTitle"), "Optional -> @Nullable");
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

    // ---- Sealed interface with type discriminator ----

    @Test
    void messageOrigin_generatesSealedInterfaceWithTypeDiscriminator() {
        TypeDefinition messageOrigin = new TypeDefinition("MessageOrigin", "Describes the origin.", List.of(), "Available types");

        String source = generator.generateToString(messageOrigin);

        assertTrue(source.contains("public sealed interface MessageOrigin"), "Should be sealed interface");
        assertTrue(source.contains("property = \"type\""), "Should use 'type' discriminator");
        assertTrue(source.contains("MessageOriginUser"), "Should list subtypes");
    }
}
