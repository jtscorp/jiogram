package io.jiogram.codegen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
import io.jiogram.codegen.model.FieldDefinition;
import io.jiogram.codegen.model.TypeDefinition;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Generates Java source files from {@link TypeDefinition} objects.
 * <p>
 * Supports three generation modes:
 * <ul>
 *   <li>Regular type &rarr; Java record</li>
 *   <li>Discriminated union parent &rarr; sealed interface</li>
 *   <li>Discriminated union subtype &rarr; record implementing parent interface</li>
 * </ul>
 */
public final class TypeGenerator {

    private static final String NULLABLE_PACKAGE = "org.jspecify.annotations";
    private static final String JACKSON_ANNOTATION_PACKAGE = "com.fasterxml.jackson.annotation";

    private final TypeMapper typeMapper;
    private final String basePackage;

    /**
     * Creates a new TypeGenerator.
     *
     * @param typeMapper  resolves Telegram types to JavaPoet types
     * @param basePackage the Java package for generated types
     */
    public TypeGenerator(TypeMapper typeMapper, String basePackage) {
        this.typeMapper = Objects.requireNonNull(typeMapper, "typeMapper must not be null");
        this.basePackage = Objects.requireNonNull(basePackage, "basePackage must not be null");
    }

    /**
     * Generates a Java source file for the given type definition and writes it to the output directory.
     *
     * @param type      the type definition to generate
     * @param outputDir the root output directory for generated sources
     * @throws IOException if writing the file fails
     */
    public void generate(TypeDefinition type, File outputDir) throws IOException {
        Objects.requireNonNull(type, "type must not be null");
        Objects.requireNonNull(outputDir, "outputDir must not be null");

        String source = generateToString(type);

        Path packageDir = outputDir.toPath().resolve(basePackage.replace('.', '/'));
        Files.createDirectories(packageDir);
        Files.writeString(packageDir.resolve(type.name() + ".java"), source);
    }

    /**
     * Generates a Java source string for the given type definition.
     *
     * @param type the type definition to generate
     * @return the generated Java source code
     */
    public String generateToString(TypeDefinition type) {
        Objects.requireNonNull(type, "type must not be null");

        if (UnionRegistry.isDiscriminatedUnion(type.name())) {
            return generateSealedInterface(type);
        } else if (UnionRegistry.isSubtype(type.name())) {
            return generateSubtypeRecord(type);
        } else {
            return generateRecord(type);
        }
    }

    private String generateRecord(TypeDefinition type) {
        Set<String> imports = new TreeSet<>();
        List<String> components = buildRecordComponents(type.fields(), imports);

        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(basePackage).append(";\n\n");
        for (String imp : imports) {
            sb.append("import ").append(imp).append(";\n");
        }
        if (!imports.isEmpty()) {
            sb.append("\n");
        }
        sb.append("public record ").append(type.name()).append("(\n");
        sb.append(String.join(",\n", components));
        sb.append("\n) {}\n");

        return sb.toString();
    }

    private String generateSealedInterface(TypeDefinition type) {
        UnionRegistry.UnionInfo unionInfo = UnionRegistry.get(type.name());

        Set<String> imports = new TreeSet<>();
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonTypeInfo");

        if (!unionInfo.subtypes().isEmpty()) {
            imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonSubTypes");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(basePackage).append(";\n\n");
        for (String imp : imports) {
            sb.append("import ").append(imp).append(";\n");
        }
        sb.append("\n");

        // @JsonTypeInfo
        sb.append("@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = \"")
                .append(unionInfo.discriminator()).append("\")\n");

        // @JsonSubTypes
        if (!unionInfo.subtypes().isEmpty()) {
            sb.append("@JsonSubTypes({\n");
            List<Map.Entry<String, String>> entries = new ArrayList<>(unionInfo.subtypes().entrySet());
            for (int i = 0; i < entries.size(); i++) {
                Map.Entry<String, String> entry = entries.get(i);
                sb.append("    @JsonSubTypes.Type(value = ").append(entry.getValue()).append(".class, name = \"")
                        .append(entry.getKey()).append("\")");
                if (i < entries.size() - 1) {
                    sb.append(",");
                }
                sb.append("\n");
            }
            sb.append("})\n");
        }

        // sealed interface declaration with permits
        sb.append("public sealed interface ").append(type.name());

        if (!unionInfo.subtypes().isEmpty()) {
            String permits = unionInfo.subtypes().values().stream()
                    .collect(Collectors.joining(", "));
            sb.append(" permits ").append(permits);
        }

        sb.append(" {}\n");

        return sb.toString();
    }

    private String generateSubtypeRecord(TypeDefinition type) {
        String parentName = UnionRegistry.parentOf(type.name());

        Set<String> imports = new TreeSet<>();
        List<String> components = buildRecordComponents(type.fields(), imports);

        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(basePackage).append(";\n\n");
        for (String imp : imports) {
            sb.append("import ").append(imp).append(";\n");
        }
        if (!imports.isEmpty()) {
            sb.append("\n");
        }
        sb.append("public record ").append(type.name()).append("(\n");
        sb.append(String.join(",\n", components));
        sb.append("\n) implements ").append(parentName).append(" {}\n");

        return sb.toString();
    }

    /**
     * Builds record component strings with annotations, collecting necessary imports.
     */
    private List<String> buildRecordComponents(List<FieldDefinition> fields, Set<String> imports) {
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonProperty");

        List<String> components = new ArrayList<>();
        boolean hasOptionalRefField = false;

        for (FieldDefinition field : fields) {
            TypeName javaType = typeMapper.resolve(field.type(), field.required());
            String typeString = resolveTypeString(javaType, imports);

            StringBuilder comp = new StringBuilder();
            comp.append("    @JsonProperty(\"").append(field.name()).append("\")");

            if (!field.required() && !javaType.isPrimitive()) {
                comp.append(" @Nullable");
                hasOptionalRefField = true;
            }

            comp.append(" ").append(typeString).append(" ").append(field.javaName());
            components.add(comp.toString());
        }

        if (hasOptionalRefField) {
            imports.add(NULLABLE_PACKAGE + ".Nullable");
        }

        return components;
    }

    /**
     * Converts a JavaPoet TypeName to a simple string for use in source code,
     * collecting necessary imports along the way.
     */
    private String resolveTypeString(TypeName typeName, Set<String> imports) {
        if (typeName.isPrimitive()) {
            return typeName.toString();
        }

        if (typeName instanceof com.squareup.javapoet.ParameterizedTypeName paramType) {
            // Handle List<X>
            String rawString = resolveTypeString(paramType.rawType, imports);
            String args = paramType.typeArguments.stream()
                    .map(arg -> resolveTypeString(arg, imports))
                    .collect(Collectors.joining(", "));
            return rawString + "<" + args + ">";
        }

        if (typeName instanceof ClassName className) {
            String fullName = className.packageName() + "." + className.simpleName();
            // Don't import java.lang classes
            if (!"java.lang".equals(className.packageName())) {
                imports.add(fullName);
            }
            return className.simpleName();
        }

        // Boxed primitives
        return typeName.box().toString();
    }
}
