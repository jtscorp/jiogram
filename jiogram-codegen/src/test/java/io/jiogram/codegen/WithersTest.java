package io.jiogram.codegen;

import io.jiogram.codegen.model.FieldDefinition;
import io.jiogram.codegen.model.MethodDefinition;
import io.jiogram.codegen.model.TypeDefinition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WithersTest {

    private final TypeMapper typeMapper = new TypeMapper("io.jiogram.types");

    @Test
    void eachComponentGetsAWitherPassingAllComponentsByName() {
        String withers = Withers.render("Point", List.of(
                new Withers.Component("x", "long", false, true),
                new Withers.Component("label", "String", true, true)));

        assertEquals("""

                    public Point withX(long x) {
                        return new Point(x, label);
                    }

                    public Point withLabel(@Nullable String label) {
                        return new Point(x, label);
                    }
                """, withers);
    }

    @Test
    void methodRecord_getsWithersForItsParameters() {
        MethodDefinition sendDocument = new MethodDefinition("sendDocument", "",
                List.of(
                        new FieldDefinition("chat_id", "Integer or String", true, ""),
                        new FieldDefinition("caption", "String", false, "")
                ),
                "Message", "Available methods");

        String source = new MethodGenerator(typeMapper, "io.jiogram.methods", "io.jiogram.types")
                .generateToString(sendDocument);

        assertTrue(source.contains("""
                    public SendDocument withCaption(@Nullable String caption) {
                        return new SendDocument(chatId, caption);
                    }
                """), source);
        assertTrue(source.contains("public SendDocument withChatId(ChatId chatId)"), source);
    }

    @Test
    void typeRecord_getsWithers_exceptForASubtypesDiscriminator() {
        TypeGenerator generator = new TypeGenerator(typeMapper, "io.jiogram.types");
        TypeDefinition photo = new TypeDefinition("InputMediaPhoto", "",
                List.of(
                        new FieldDefinition("type", "String", true, "Type of the result, must be photo"),
                        new FieldDefinition("media", "String", true, ""),
                        new FieldDefinition("caption", "String", false, "")
                ),
                "types");
        TypeDefinition empty = new TypeDefinition("ForumTopicClosed", "", List.of(), "types");

        String source = generator.generateToString(photo);

        assertTrue(source.contains("public InputMediaPhoto withCaption(@Nullable String caption)"), source);
        assertTrue(source.contains("public InputMediaPhoto withMedia("), source);
        assertFalse(source.contains("withType("), source);
        assertTrue(generator.generateToString(empty).contains("public record ForumTopicClosed(\n\n) {}"),
                generator.generateToString(empty));
    }
}
