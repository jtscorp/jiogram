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

    // ---- Simple class (ChatPhoto) ----

    @Test
    void simpleType_generatesFinalClassWithAllRequiredFields() {
        TypeDefinition chatPhoto = new TypeDefinition("ChatPhoto", "Represents a chat photo.", List.of(
                new FieldDefinition("small_file_id", "String", true, "File identifier of small photo"),
                new FieldDefinition("small_file_unique_id", "String", true, "Unique file identifier of small photo"),
                new FieldDefinition("big_file_id", "String", true, "File identifier of big photo"),
                new FieldDefinition("big_file_unique_id", "String", true, "Unique file identifier of big photo")
        ), "Available types");

        String source = generator.generateToString(chatPhoto);

        assertTrue(source.contains("public final class ChatPhoto {"), "Should be a final class");
        assertFalse(source.contains("record"), "Java 11 output has no records");
        assertTrue(source.contains("    @JsonProperty(\"small_file_id\")\n    private final String smallFileId;"),
                "Annotated private final field");
        assertTrue(source.contains("            @JsonProperty(\"small_file_id\") String smallFileId,"),
                "camelCase constructor parameter");
        assertTrue(source.contains("@JsonProperty(\"big_file_id\") String bigFileId"), "camelCase field");
        assertFalse(source.contains("@Nullable"), "All fields required, no @Nullable");
    }

    // ---- Class with optional fields (User) ----

    @Test
    void classWithOptionalFields_hasNullableAnnotations() {
        TypeDefinition user = new TypeDefinition("User", "Represents a Telegram user.", List.of(
                new FieldDefinition("id", "Integer", true, "Unique identifier"),
                new FieldDefinition("is_bot", "Boolean", true, "True if this user is a bot"),
                new FieldDefinition("first_name", "String", true, "User's first name"),
                new FieldDefinition("last_name", "String", false, "User's last name"),
                new FieldDefinition("username", "String", false, "User's username"),
                new FieldDefinition("language_code", "String", false, "IETF language tag")
        ), "Available types");

        String source = generator.generateToString(user);

        assertTrue(source.contains("public final class User {"), "Should be a final class");
        // Required primitive fields use primitives
        assertTrue(source.contains("@JsonProperty(\"id\") long id"), "Required Integer -> long");
        assertTrue(source.contains("@JsonProperty(\"is_bot\") boolean isBot"), "Required Boolean -> boolean");
        // Required String
        assertTrue(source.contains("@JsonProperty(\"first_name\") String firstName"), "Required String");
        // Optional String gets @Nullable
        assertTrue(source.contains("@JsonProperty(\"last_name\") @Nullable String lastName"), "Optional String -> @Nullable");
        assertTrue(source.contains("@JsonProperty(\"username\") @Nullable String username"), "Optional String -> @Nullable");
        // ... on the field and the accessor too
        assertTrue(source.contains("    private final @Nullable String lastName;"), "Nullable field");
        assertTrue(source.contains("    public @Nullable String lastName() {"), "Nullable accessor");
        assertTrue(source.contains("    public boolean isBot() {"), "Accessor named like the field");
        // Imports
        assertTrue(source.contains("import org.jspecify.annotations.Nullable;"), "Should import Nullable");
        assertTrue(source.contains("import com.fasterxml.jackson.annotation.JsonProperty;"), "Should import JsonProperty");
    }

    // ---- Union interface (ChatMember) ----

    @Test
    void discriminatedUnionParent_generatesPlainInterface() {
        TypeDefinition chatMember = new TypeDefinition("ChatMember", "Represents a chat member.", List.of(), "Available types");

        String source = generator.generateToString(chatMember);

        assertTrue(source.contains("public interface ChatMember {}"), "Should be a plain interface");
        assertFalse(source.contains("sealed"), "Java 11 output has no sealed types");
        assertFalse(source.contains("permits"), "Java 11 output has no permits clause");
        assertTrue(source.contains("@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = \"status\", "
                        + "visible = true, defaultImpl = ChatMemberUnknown.class)"),
                "Should have @JsonTypeInfo with status discriminator and Unknown fallback");
        assertTrue(source.contains("@JsonSubTypes({"), "Should have @JsonSubTypes");
        assertTrue(source.contains("@JsonSubTypes.Type(value = ChatMemberOwner.class, name = \"creator\")"),
                "Should list ChatMemberOwner");
        assertTrue(source.contains("@JsonSubTypes.Type(value = ChatMemberBanned.class, name = \"kicked\")"),
                "Should list ChatMemberBanned");
        assertFalse(source.contains("record"), "Should not be a record");
        assertFalse(source.contains("final class"), "Should not be a class");
    }

    @Test
    void valueBasedUnionParent_hasNoUnknownFallback() {
        TypeDefinition maybe = new TypeDefinition("MaybeInaccessibleMessage", "Message or inaccessible.", List.of(), "Available types");

        String source = generator.generateToString(maybe);

        assertTrue(source.contains("@JsonTypeIdResolver(MaybeInaccessibleMessageTypeIdResolver.class)"));
        assertTrue(source.contains("public interface MaybeInaccessibleMessage {}"), source);
        assertFalse(source.contains("Unknown"), "Value-based union should not get an Unknown variant");
    }

    @Test
    void unknownVariant_holdsRawDiscriminatorAndData() {
        String source = generator.generateUnknownVariant("ChatMember");

        assertTrue(source.contains("@JsonSerialize(using = UnknownVariant.Serializer.class)"));
        assertTrue(source.contains("public final class ChatMemberUnknown implements ChatMember, UnknownVariant {"),
                "Should be a final class implementing the union");
        assertTrue(source.contains("    private final @Nullable String status;"), "Raw discriminator as String");
        assertTrue(source.contains("    private final Map<String, Object> data;"), "Remaining fields in data");
        // Public constructor shaped like the record's canonical one
        assertTrue(source.contains("    public ChatMemberUnknown(@Nullable String status, @Nullable Map<String, Object> data) {"));
        // Jackson 2.13 has no @JsonAnySetter on creator parameters: a private creator and any-setter
        assertTrue(source.contains("    @JsonCreator\n    private ChatMemberUnknown(@JsonProperty(\"status\") @Nullable String status) {"));
        assertTrue(source.contains("    @JsonAnySetter\n    private void addField(String name, Object value) {"));
        assertTrue(source.contains("        return Collections.unmodifiableMap(data);"), "data() is read-only");
        assertTrue(source.contains("    public @Nullable String status() {"), "Accessor named like the field");
        assertTrue(source.contains("return \"status\";"), "discriminatorName() returns the JSON name");
        assertTrue(source.contains("        return \"ChatMemberUnknown[status=\" + this.status + \", data=\" + this.data + \"]\";"),
                "Record-style toString");
        assertTrue(source.contains("        return Objects.hash(this.status, this.data);"), "hashCode over both fields");
    }

    // ---- Subtype class (ChatMemberOwner) ----

    @Test
    void subtypeClass_implementsParentInterface() {
        TypeDefinition chatMemberOwner = new TypeDefinition("ChatMemberOwner", "Represents a chat member that owns the chat.", List.of(
                new FieldDefinition("status", "String", true, "The member's status"),
                new FieldDefinition("user", "User", true, "Information about the user"),
                new FieldDefinition("is_anonymous", "Boolean", true, "True if presence is hidden"),
                new FieldDefinition("custom_title", "String", false, "Custom title for this user")
        ), "Available types");

        String source = generator.generateToString(chatMemberOwner);

        assertTrue(source.contains("public final class ChatMemberOwner implements ChatMember {"),
                "Should be a final class implementing ChatMember");
        assertTrue(source.contains("@JsonProperty(value = \"status\", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status"),
                "Discriminator is a write-only enum field (Jackson writes the type id itself)");
        assertTrue(source.contains("    @JsonProperty(value = \"status\", access = JsonProperty.Access.WRITE_ONLY)\n"
                        + "    private final ChatMemberType status;"),
                "The field carries the same write-only annotation");
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
    void classWithArrayField_usesListType() {
        TypeDefinition type = new TypeDefinition("MessageHolder", "Holds messages.", List.of(
                new FieldDefinition("messages", "Array of Message", true, "List of messages")
        ), "Test");

        String source = generator.generateToString(type);

        assertTrue(source.contains("List<Message> messages"), "Array of X -> List<X>");
        assertTrue(source.contains("import java.util.List;"), "Should import java.util.List");
    }

    // ---- Union interface with type discriminator ----

    @Test
    void messageOrigin_generatesInterfaceWithTypeDiscriminator() {
        TypeDefinition messageOrigin = new TypeDefinition("MessageOrigin", "Describes the origin.", List.of(), "Available types");

        String source = generator.generateToString(messageOrigin);

        assertTrue(source.contains("public interface MessageOrigin {}"), "Should be a plain interface");
        assertTrue(source.contains("property = \"type\""), "Should use 'type' discriminator");
        assertTrue(source.contains("MessageOriginUser"), "Should list subtypes");
    }

    // ---- Value semantics: equals, hashCode, toString ----

    @Test
    void valueClass_hasRecordLikeEqualsHashCodeAndToString() {
        TypeDefinition location = new TypeDefinition("Location", "A point.", List.of(
                new FieldDefinition("latitude", "Float", true, "Latitude"),
                new FieldDefinition("live_period", "Integer", true, "Period"),
                new FieldDefinition("is_live", "Boolean", true, "Live"),
                new FieldDefinition("title", "String", false, "Title")
        ), "Test");

        String source = generator.generateToString(location);

        assertTrue(source.contains("""
                    @Override
                    public boolean equals(Object o) {
                        if (this == o) {
                            return true;
                        }
                        if (!(o instanceof Location)) {
                            return false;
                        }
                        Location that = (Location) o;
                        return Double.compare(this.latitude, that.latitude) == 0
                                && this.livePeriod == that.livePeriod
                                && this.isLive == that.isLive
                                && Objects.equals(this.title, that.title);
                    }

                    @Override
                    public int hashCode() {
                        return Objects.hash(this.latitude, this.livePeriod, this.isLive, this.title);
                    }

                    @Override
                    public String toString() {
                        return "Location[latitude=" + this.latitude
                                + ", livePeriod=" + this.livePeriod
                                + ", isLive=" + this.isLive
                                + ", title=" + this.title
                                + "]";
                    }
                }
                """), source);
        assertTrue(source.contains("import java.util.Objects;"), source);
    }

    @Test
    void classWithoutFields_isEqualToEveryInstanceOfItself() {
        TypeDefinition empty = new TypeDefinition("CallbackGame", "A placeholder.", List.of(), "Test");

        String source = generator.generateToString(empty);

        assertTrue(source.contains("""
                    @Override
                    public boolean equals(Object o) {
                        return o instanceof CallbackGame;
                    }

                    @Override
                    public int hashCode() {
                        return 0;
                    }

                    @Override
                    public String toString() {
                        return "CallbackGame[]";
                    }
                """), source);
        assertFalse(source.contains("import java.util.Objects;"), source);
        assertFalse(source.contains("JsonProperty"), source);
    }

    // ---- Constructor, accessors and their documentation ----

    @Test
    void valueClass_hasJsonCreatorConstructorAndDocumentedAccessors() {
        TypeDefinition dice = new TypeDefinition("Dice", "Represents an animated emoji.", List.of(
                new FieldDefinition("emoji", "String", true, "Emoji on which the dice throw animation is based"),
                new FieldDefinition("value", "Integer", true, "")
        ), "Test");

        String source = generator.generateToString(dice);

        assertTrue(source.contains("""
                /**
                 * Represents an animated emoji.
                 *
                 * @see <a href="https://core.telegram.org/bots/api#dice">Dice in the Bot API</a>
                 */
                @JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
                public final class Dice {
                """), "A class comment cannot take @param tags\n" + source);
        assertTrue(source.contains("""
                    /**
                     * Creates a new {@code Dice} instance.
                     *
                     * @param emoji Emoji on which the dice throw animation is based
                     */
                    @JsonCreator
                    public Dice(
                            @JsonProperty("emoji") String emoji,
                            @JsonProperty("value") long value) {
                        this.emoji = emoji;
                        this.value = value;
                    }
                """), source);
        assertTrue(source.contains("""
                    /**
                     * Emoji on which the dice throw animation is based
                     */
                    public String emoji() {
                        return emoji;
                    }

                    public long value() {
                        return value;
                    }
                """), source);
        assertTrue(source.contains("import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;"), source);
    }

    // ---- Java 11 output ----

    @Test
    void generatedSources_useNoSyntaxNewerThanJava11() {
        List<String> sources = List.of(
                generator.generateToString(new TypeDefinition("ReactionType", "", List.of(), "Test")),
                generator.generateToString(new TypeDefinition("ReactionTypeEmoji", "", List.of(
                        new FieldDefinition("type", "String", true, ""),
                        new FieldDefinition("emoji", "String", true, "")), "Test")),
                generator.generateUnknownVariant("ReactionType"),
                generator.generateToString(new TypeDefinition("MaybeInaccessibleMessage", "", List.of(), "Test")));

        for (String source : sources) {
            assertFalse(source.matches("(?s).*\\b(record|sealed|permits)\\b.*"), source);
            assertFalse(source.contains("->"), source);
            assertFalse(source.matches("(?s).*instanceof [A-Za-z.]+ [a-z].*"), source);
        }
    }
}
