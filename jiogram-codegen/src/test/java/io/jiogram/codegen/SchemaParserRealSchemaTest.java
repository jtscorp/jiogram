package io.jiogram.codegen;

import io.jiogram.codegen.model.ApiSchema;
import io.jiogram.codegen.model.FieldDefinition;
import io.jiogram.codegen.model.MethodDefinition;
import io.jiogram.codegen.model.TypeDefinition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import java.io.File;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test that parses the real Telegram Bot API schema.json.
 * Skipped if the file is not present.
 */
@EnabledIf("realSchemaExists")
class SchemaParserRealSchemaTest {

    private static final String REAL_SCHEMA_PATH = "schema/schema.json";
    private static ApiSchema schema;

    static boolean realSchemaExists() {
        return findSchemaFile().exists();
    }

    private static File findSchemaFile() {
        // Walk up from working dir to find the project root
        File dir = new File(System.getProperty("user.dir"));
        while (dir != null) {
            File candidate = new File(dir, REAL_SCHEMA_PATH);
            if (candidate.exists()) {
                return candidate;
            }
            dir = dir.getParentFile();
        }
        return new File(REAL_SCHEMA_PATH);
    }

    @BeforeAll
    static void parseRealSchema() throws Exception {
        schema = SchemaParser.parse(findSchemaFile());
    }

    @Test
    void printStats() {
        System.out.println("=== Real Schema Stats ===");
        System.out.println("API Version: " + schema.apiVersion());
        System.out.println("Types:       " + schema.types().size());
        System.out.println("Methods:     " + schema.methods().size());
        System.out.println("Enums:       " + schema.enums().size());

        long totalFields = schema.types().stream()
                .mapToLong(t -> t.fields().size())
                .sum();
        System.out.println("Total type fields: " + totalFields);

        long totalParams = schema.methods().stream()
                .mapToLong(m -> m.parameters().size())
                .sum();
        System.out.println("Total method params: " + totalParams);

        long unionFields = schema.types().stream()
                .flatMap(t -> t.fields().stream())
                .filter(FieldDefinition::isUnion)
                .count();
        long unionParams = schema.methods().stream()
                .flatMap(m -> m.parameters().stream())
                .filter(FieldDefinition::isUnion)
                .count();
        System.out.println("Union type fields:   " + unionFields);
        System.out.println("Union method params: " + unionParams);

        long arrayFields = schema.types().stream()
                .flatMap(t -> t.fields().stream())
                .filter(FieldDefinition::isArray)
                .count();
        System.out.println("Array type fields:   " + arrayFields);

        // Print return types distribution
        var returnTypes = schema.methods().stream()
                .collect(Collectors.groupingBy(MethodDefinition::returnType, Collectors.counting()));
        System.out.println("\nReturn type distribution:");
        returnTypes.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach(e -> System.out.println("  " + e.getKey() + ": " + e.getValue()));

        // Print categories
        var typeCategories = schema.types().stream()
                .collect(Collectors.groupingBy(TypeDefinition::category, Collectors.counting()));
        System.out.println("\nType categories:");
        typeCategories.forEach((k, v) -> System.out.println("  " + k + ": " + v));

        System.out.println("=========================");
    }

    @Test
    void hasExpectedNumberOfTypes() {
        assertTrue(schema.types().size() >= 250,
                "Expected at least 250 types, got " + schema.types().size());
    }

    @Test
    void hasExpectedNumberOfMethods() {
        assertTrue(schema.methods().size() >= 150,
                "Expected at least 150 methods, got " + schema.methods().size());
    }

    @Test
    void knownTypes_exist() {
        var names = schema.types().stream().map(TypeDefinition::name).toList();
        assertTrue(names.contains("Update"));
        assertTrue(names.contains("Message"));
        assertTrue(names.contains("User"));
        assertTrue(names.contains("Chat"));
        assertTrue(names.contains("InlineKeyboardMarkup"));
    }

    @Test
    void knownMethods_exist() {
        var names = schema.methods().stream().map(MethodDefinition::name).toList();
        assertTrue(names.contains("sendMessage"));
        assertTrue(names.contains("getUpdates"));
        assertTrue(names.contains("getMe"));
        assertTrue(names.contains("sendPhoto"));
    }

    @Test
    void returnTypes_areExtracted() {
        for (MethodDefinition method : schema.methods()) {
            assertNotNull(method.returnType(),
                    "Return type is null for method: " + method.name());
            assertFalse(method.returnType().isEmpty(),
                    "Return type is empty for method: " + method.name());
        }
    }
}
