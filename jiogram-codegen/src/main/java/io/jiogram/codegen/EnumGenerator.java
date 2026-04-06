package io.jiogram.codegen;

import io.jiogram.codegen.model.EnumDefinition;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.TreeSet;
import java.util.Set;

/**
 * Generates Java enum source files from {@link EnumDefinition} objects.
 * <p>
 * Each generated enum includes:
 * <ul>
 *   <li>Constants with the original string value</li>
 *   <li>{@code @JsonValue} on the {@code value()} method</li>
 *   <li>{@code @JsonCreator} on a static {@code fromValue()} factory method</li>
 * </ul>
 */
public final class EnumGenerator {

    private static final String JACKSON_ANNOTATION_PACKAGE = "com.fasterxml.jackson.annotation";

    private final String basePackage;

    /**
     * Creates a new EnumGenerator.
     *
     * @param basePackage the Java package for generated enums
     */
    public EnumGenerator(String basePackage) {
        this.basePackage = Objects.requireNonNull(basePackage, "basePackage must not be null");
    }

    /**
     * Generates a Java enum source file and writes it to the output directory.
     *
     * @param enumDef   the enum definition to generate
     * @param outputDir the root output directory for generated sources
     * @throws IOException if writing the file fails
     */
    public void generate(EnumDefinition enumDef, File outputDir) throws IOException {
        Objects.requireNonNull(enumDef, "enumDef must not be null");
        Objects.requireNonNull(outputDir, "outputDir must not be null");

        // Skip enums with no values — they would produce invalid Java
        if (enumDef.values().isEmpty()) {
            return;
        }

        String source = generateToString(enumDef);

        Path packageDir = outputDir.toPath().resolve(basePackage.replace('.', '/'));
        Files.createDirectories(packageDir);
        Files.writeString(packageDir.resolve(enumDef.name() + ".java"), source);
    }

    /**
     * Generates a Java enum source string for the given enum definition.
     *
     * @param enumDef the enum definition to generate
     * @return the generated Java source code
     */
    public String generateToString(EnumDefinition enumDef) {
        Objects.requireNonNull(enumDef, "enumDef must not be null");

        Set<String> imports = new TreeSet<>();
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonCreator");
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonValue");

        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(basePackage).append(";\n\n");
        for (String imp : imports) {
            sb.append("import ").append(imp).append(";\n");
        }
        sb.append("\n");

        sb.append("public enum ").append(enumDef.name()).append(" {\n");

        // Enum constants
        for (int i = 0; i < enumDef.values().size(); i++) {
            String value = enumDef.values().get(i);
            String constantName = toConstantName(value);
            sb.append("    ").append(constantName).append("(\"").append(value).append("\")");
            if (i < enumDef.values().size() - 1) {
                sb.append(",");
            } else {
                sb.append(";");
            }
            sb.append("\n");
        }

        sb.append("\n");

        // Private field and constructor
        sb.append("    private final String value;\n\n");
        sb.append("    ").append(enumDef.name()).append("(String value) {\n");
        sb.append("        this.value = value;\n");
        sb.append("    }\n\n");

        // @JsonValue getter
        sb.append("    @JsonValue\n");
        sb.append("    public String value() {\n");
        sb.append("        return value;\n");
        sb.append("    }\n\n");

        // @JsonCreator factory
        sb.append("    @JsonCreator\n");
        sb.append("    public static ").append(enumDef.name()).append(" fromValue(String value) {\n");
        sb.append("        for (").append(enumDef.name()).append(" e : values()) {\n");
        sb.append("            if (e.value.equals(value)) {\n");
        sb.append("                return e;\n");
        sb.append("            }\n");
        sb.append("        }\n");
        sb.append("        throw new IllegalArgumentException(\"Unknown ").append(enumDef.name()).append(": \" + value);\n");
        sb.append("    }\n");

        sb.append("}\n");

        return sb.toString();
    }

    /**
     * Converts a snake_case or mixed-case value to an UPPER_SNAKE_CASE constant name.
     * <p>
     * Examples:
     * <ul>
     *   <li>{@code "typing"} &rarr; {@code "TYPING"}</li>
     *   <li>{@code "upload_photo"} &rarr; {@code "UPLOAD_PHOTO"}</li>
     *   <li>{@code "HTML"} &rarr; {@code "HTML"}</li>
     *   <li>{@code "MarkdownV2"} &rarr; {@code "MARKDOWN_V2"}</li>
     * </ul>
     *
     * @param value the original string value
     * @return the UPPER_SNAKE_CASE constant name
     */
    static String toConstantName(String value) {
        // If already all uppercase/underscore, return as-is
        if (value.matches("[A-Z_0-9]+")) {
            return ensureValidIdentifier(value);
        }

        // If already snake_case (lowercase with underscores), just uppercase it
        if (value.matches("[a-z_0-9]+")) {
            return ensureValidIdentifier(value.toUpperCase());
        }

        // Handle camelCase/PascalCase: insert underscore before uppercase letters
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (Character.isUpperCase(c) && i > 0) {
                char prev = value.charAt(i - 1);
                if (Character.isLowerCase(prev) || Character.isDigit(prev)) {
                    sb.append('_');
                }
            }
            sb.append(Character.toUpperCase(c));
        }
        return ensureValidIdentifier(sb.toString());
    }

    /**
     * Ensures the constant name is a valid Java identifier.
     * Prepends underscore if it starts with a digit.
     */
    private static String ensureValidIdentifier(String name) {
        if (!name.isEmpty() && Character.isDigit(name.charAt(0))) {
            return "_" + name;
        }
        return name;
    }
}
