package io.jiogram.codegen;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.codegen.model.*;
import org.jspecify.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Parses the Telegram Bot API schema JSON file into an {@link ApiSchema} model.
 * <p>
 * The schema format is the one produced by the
 * <a href="https://github.com/aiogram/tg-codegen">tg-codegen</a> project.
 */
public final class SchemaParser {

    // ---- Return type extraction patterns (order matters — first match wins) ----

    private static final List<Pattern> RETURN_TYPE_PATTERNS = List.of(
            // "Returns an Array of X objects" / "returns an array of X objects"
            Pattern.compile("[Rr]eturns an (Array of \\w+) objects?", Pattern.CASE_INSENSITIVE),
            // "an array of X objects that were sent is returned"
            Pattern.compile("an (array of \\w+) objects? (?:that (?:were|was) sent )?is returned", Pattern.CASE_INSENSITIVE),
            // "an array of X of the sent messages is returned"  (no "objects")
            Pattern.compile("an (array of \\w+) (?:of )?.*?is returned", Pattern.CASE_INSENSITIVE),
            // "Returns an Array of X on success"
            Pattern.compile("[Rr]eturns an (Array of \\w+) on success", Pattern.CASE_INSENSITIVE),
            // "On success, returns a X object"
            Pattern.compile("[Oo]n success, returns (?:a |an )(\\w+) object"),
            // "Returns a X object" (anywhere in text)
            Pattern.compile("[Rr]eturns (?:a |an )(\\w+) object"),
            // "Returns basic information ... in form of a X object"
            Pattern.compile("in form of (?:a |an )(\\w+) object"),
            // "Returns information about the created topic as a X object" / "as ChatInviteLink object"
            Pattern.compile("as (?:a |an )?(\\w+) object"),
            // "Returns the uploaded/new X on success" (specific adjective before type name)
            Pattern.compile("[Rr]eturns the (?:uploaded|new|revoked|edited|created) (\\w+) on success"),
            // "Returns the X as Y on success"
            Pattern.compile("[Rr]eturns the .+? as (\\w+) on success"),
            // "Returns X on success"
            Pattern.compile("[Rr]eturns (\\w+) on success"),
            // "On success, the sent X is returned"
            Pattern.compile("[Oo]n success, (?:the (?:sent|edited|stopped|uploaded|new) )?(\\w+) (?:that was sent )?is returned"),
            // "On success, a X object is returned" / "On success, a X that was sent is returned"
            Pattern.compile("[Oo]n success, (?:a |an )(\\w+) (?:object )?(?:that was sent )?is returned"),
            // "On success, if not inline, the edited X is returned, otherwise True"
            Pattern.compile("[Oo]n success, if the (?:edited )?message is not an inline message, the (?:edited )?(\\w+) is returned"),
            // "the sent/edited/stopped/new X is returned"
            Pattern.compile("the (?:sent |edited |stopped |new )?(\\w+) is returned"),
            // "Returns the MessageId of the sent message on success"
            Pattern.compile("[Rr]eturns the (\\w+) of"),
            // "Returns X"  (last resort — single word after Returns, anywhere in text)
            Pattern.compile("[Rr]eturns (\\w+)")
    );

    private static final String ARRAY_OF = "Array of ";

    /** Return types that are not schema types; "True" is normalized to Boolean. */
    private static final Set<String> SCALAR_RETURN_TYPES = Set.of("Boolean", "Integer", "Int", "String", "Float");

    private SchemaParser() {
    }

    /**
     * CLI entry point: parses a schema file and prints statistics.
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: SchemaParser <schema.json>");
            System.exit(1);
        }
        ApiSchema schema = parse(new File(args[0]));
        System.out.println("=== Schema Stats ===");
        System.out.println("API Version: " + schema.apiVersion());
        System.out.println("Types:       " + schema.types().size());
        System.out.println("Methods:     " + schema.methods().size());
        System.out.println("Enums:       " + schema.enums().size());

        long totalFields = schema.types().stream().mapToLong(t -> t.fields().size()).sum();
        long totalParams = schema.methods().stream().mapToLong(m -> m.parameters().size()).sum();
        System.out.println("Total type fields:   " + totalFields);
        System.out.println("Total method params: " + totalParams);

        long unionFields = schema.types().stream()
                .flatMap(t -> t.fields().stream()).filter(FieldDefinition::isUnion).count();
        long unionParams = schema.methods().stream()
                .flatMap(m -> m.parameters().stream()).filter(FieldDefinition::isUnion).count();
        System.out.println("Union type fields:   " + unionFields);
        System.out.println("Union method params: " + unionParams);

        long arrayFields = schema.types().stream()
                .flatMap(t -> t.fields().stream()).filter(FieldDefinition::isArray).count();
        System.out.println("Array type fields:   " + arrayFields);

        System.out.println("\nReturn type distribution:");
        schema.methods().stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        MethodDefinition::returnType, java.util.stream.Collectors.counting()))
                .entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach(e -> System.out.println("  " + e.getKey() + ": " + e.getValue()));
        System.out.println("====================");
    }

    /**
     * Parses the given schema JSON file and returns a fully populated {@link ApiSchema}.
     *
     * @param schemaFile path to the schema.json file
     * @return the parsed API schema
     * @throws IOException if the file cannot be read or parsed
     */
    public static ApiSchema parse(File schemaFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(schemaFile);

        String apiVersion = root.path("api").path("version").asText("");

        List<TypeDefinition> allTypes = new ArrayList<>();
        List<MethodDefinition> allMethods = new ArrayList<>();
        List<EnumDefinition> allEnums = new ArrayList<>();

        JsonNode items = root.path("items");
        for (JsonNode section : items) {
            String sectionTitle = section.path("title").asText("");
            JsonNode children = section.path("children");

            for (JsonNode child : children) {
                String category = child.path("category").asText("");
                String name = child.path("name").asText("");
                String description = child.path("description").asText("");

                List<FieldDefinition> fields = parseAnnotations(child.path("annotations"));

                if ("types".equals(category)) {
                    allTypes.add(new TypeDefinition(name, description, fields, sectionTitle));
                } else if ("methods".equals(category)) {
                    String returnType = extractReturnType(description);
                    allMethods.add(new MethodDefinition(name, description, fields, returnType, sectionTitle));
                }
            }
        }

        requireKnownReturnTypes(allMethods,
                allTypes.stream().map(TypeDefinition::name).collect(Collectors.toSet()));
        return new ApiSchema(apiVersion, allTypes, allMethods, allEnums);
    }

    /**
     * Fails when a method's return type could not be read from its description or names a type
     * the schema does not define. Guessing (e.g. falling back to Boolean) would generate a method
     * whose responses cannot be read.
     */
    static void requireKnownReturnTypes(List<MethodDefinition> methods, Set<String> typeNames) {
        List<String> problems = methods.stream()
                .filter(method -> !isKnownType(method.returnType(), typeNames))
                .map(method -> method.name() + " -> "
                        + (method.returnType() == null ? "<not found>" : "'" + method.returnType() + "'"))
                .toList();
        if (!problems.isEmpty()) {
            throw new IllegalStateException("Cannot determine the return type of " + problems.size()
                    + " method(s) from the schema description; extend SchemaParser.RETURN_TYPE_PATTERNS: "
                    + problems);
        }
    }

    private static boolean isKnownType(@Nullable String type, Set<String> typeNames) {
        if (type == null) {
            return false;
        }
        if (type.startsWith(ARRAY_OF)) {
            return isKnownType(type.substring(ARRAY_OF.length()), typeNames);
        }
        return SCALAR_RETURN_TYPES.contains(type) || typeNames.contains(type);
    }

    private static List<FieldDefinition> parseAnnotations(JsonNode annotations) {
        List<FieldDefinition> fields = new ArrayList<>();
        if (annotations == null || annotations.isMissingNode()) {
            return fields;
        }
        for (JsonNode ann : annotations) {
            fields.add(new FieldDefinition(
                    ann.path("name").asText(""),
                    ann.path("type").asText(""),
                    ann.path("required").asBoolean(false),
                    ann.path("description").asText("")
            ));
        }
        return fields;
    }

    /**
     * Extracts the return type from a method description using regex patterns.
     * <p>
     * Examples:
     * <ul>
     *   <li>"Returns an Array of Update objects" &rarr; "Array of Update"</li>
     *   <li>"On success, the sent Message is returned" &rarr; "Message"</li>
     *   <li>"Returns basic information about the bot in form of a User object" &rarr; "User"</li>
     *   <li>"Returns True on success" &rarr; "Boolean"</li>
     *   <li>"Returns Int on success" &rarr; "Int"</li>
     * </ul>
     *
     * @param description the method description text
     * @return the extracted return type, or {@code null} if no pattern matches
     */
    static @Nullable String extractReturnType(String description) {
        for (Pattern pattern : RETURN_TYPE_PATTERNS) {
            Matcher matcher = pattern.matcher(description);
            if (matcher.find()) {
                String result = matcher.group(1);
                // Normalize "True" to "Boolean"
                if ("True".equals(result)) {
                    return "Boolean";
                }
                // Normalize case for "Array of X"
                if (result.toLowerCase().startsWith("array of ")) {
                    return "Array of " + Character.toUpperCase(result.charAt(9)) + result.substring(10);
                }
                return result;
            }
        }
        return null;
    }
}
