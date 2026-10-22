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
 * Supports three generation modes (the output is Java 11: no records, no sealed types):
 * <ul>
 *   <li>Regular type &rarr; final value class (see {@link ValueClass})</li>
 *   <li>Discriminated union parent &rarr; interface with Jackson's type info</li>
 *   <li>Discriminated union subtype &rarr; value class implementing the parent interface</li>
 * </ul>
 */
public final class TypeGenerator {

    private static final String NULLABLE_PACKAGE = ValueClass.NULLABLE_PACKAGE;
    private static final String JACKSON_ANNOTATION_PACKAGE = ValueClass.JACKSON_ANNOTATION_PACKAGE;
    private static final String JACKSON_DATABIND_ANNOTATION_PACKAGE = "com.fasterxml.jackson.databind.annotation";

    /** Types that should implement the ReplyMarkup marker interface. */
    private static final Set<String> REPLY_MARKUP_TYPES = Set.of(
            "InlineKeyboardMarkup", "ReplyKeyboardMarkup", "ReplyKeyboardRemove", "ForceReply"
    );

    /**
     * Types that should implement a marker interface (not in UnionRegistry subtypes).
     * Map from interface name to the set of implementing type names.
     */
    private static final Map<String, Set<String>> INTERFACE_IMPLEMENTATIONS = Map.of(
            "InputMessageContent", Set.of(
                    "InputTextMessageContent", "InputLocationMessageContent",
                    "InputVenueMessageContent", "InputContactMessageContent",
                    "InputInvoiceMessageContent"
            )
    );

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

        if (UnionRegistry.isDiscriminatedUnion(type.name()) && hasUnknownVariant(UnionRegistry.get(type.name()))) {
            Files.writeString(packageDir.resolve(unknownVariantName(type.name()) + ".java"),
                    generateUnknownVariant(type.name()));
        }
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
            return generateUnionInterface(type);
        } else if (UnionRegistry.isSubtype(type.name())) {
            return generateSubtypeClass(type);
        } else {
            return generateClass(type);
        }
    }

    private String generateClass(TypeDefinition type) {
        Set<String> imports = new TreeSet<>();
        List<ValueClass.Field> fields = buildFields(type.name(), type.fields(), null, imports);

        // Collect all interfaces this type should implement
        List<String> interfaces = new ArrayList<>();
        if (REPLY_MARKUP_TYPES.contains(type.name())) {
            interfaces.add("ReplyMarkup");
        }
        String additionalIface = getAdditionalInterface(type.name());
        if (additionalIface != null) {
            interfaces.add(additionalIface);
        }

        return classSource(type, interfaces, fields, imports, staticFactory(type.name(), fields, null, null));
    }

    /** The source file of a value class: package, imports, class comment and declaration. */
    private String classSource(TypeDefinition type, List<String> interfaces, List<ValueClass.Field> fields,
                               Set<String> imports, String extraMembers) {
        ValueClass.addImports(fields, imports);
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(basePackage).append(";\n\n");
        for (String imp : imports) {
            sb.append("import ").append(imp).append(";\n");
        }
        sb.append("\n");
        // A class cannot take @param tags: the fields are documented on the constructor and accessors.
        sb.append(Javadoc.render(type.description(), List.of(), type.name()));
        sb.append(ValueClass.render(type.name(), interfaces, fields, extraMembers));
        return sb.toString();
    }

    private String generateUnionInterface(TypeDefinition type) {
        UnionRegistry.UnionInfo unionInfo = UnionRegistry.get(type.name());
        boolean hasSubtypes = !unionInfo.subtypes().isEmpty();

        // When there are no registered subtypes, generate a plain interface
        // (e.g. InputMessageContent which has subtypes but no discriminator)
        if (!hasSubtypes) {
            return generatePlainInterface(type);
        }

        boolean isValueBasedDiscriminator = isValueBasedDiscriminator(unionInfo);

        Set<String> imports = new TreeSet<>();
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonTypeInfo");
        if (isValueBasedDiscriminator) {
            imports.add(JACKSON_DATABIND_ANNOTATION_PACKAGE + ".JsonTypeIdResolver");
        } else {
            imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonSubTypes");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(basePackage).append(";\n\n");
        for (String imp : imports) {
            sb.append("import ").append(imp).append(";\n");
        }
        sb.append("\n");
        sb.append(Javadoc.render(type.description(), List.of(), type.name()));

        if (isValueBasedDiscriminator) {
            // @JsonTypeInfo with CUSTOM resolver, reading the existing discriminator
            // property and keeping it visible so the subtype's discriminator field
            // is still populated by the default deserializer.
            sb.append("@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, property = \"")
                    .append(unionInfo.discriminator())
                    .append("\", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)\n");
            sb.append("@JsonTypeIdResolver(").append(type.name()).append("TypeIdResolver.class)\n");
        } else {
            // @JsonTypeInfo — visible so subtypes (and the Unknown fallback) receive
            // the discriminator value; unrecognised values fall back to defaultImpl
            // instead of failing the whole update.
            sb.append("@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = \"")
                    .append(unionInfo.discriminator())
                    .append("\", visible = true, defaultImpl = ")
                    .append(unknownVariantName(type.name())).append(".class)\n");

            // @JsonSubTypes — entries are sorted alphabetically by discriminator
            // value to keep generated output deterministic across JVM runs (the
            // input map is built from Map.of(...), which has unspecified iteration
            // order between processes).
            sb.append("@JsonSubTypes({\n");
            List<Map.Entry<String, String>> entries = new ArrayList<>(unionInfo.subtypes().entrySet());
            entries.sort(Map.Entry.comparingByKey());
            for (int i = 0; i < entries.size(); i++) {
                Map.Entry<String, String> entry = entries.get(i);
                sb.append("    @JsonSubTypes.Type(value = ").append(entry.getValue()).append(".class, name = \"")
                        .append(UnionRegistry.wireName(type.name(), entry.getKey())).append("\")");
                if (i < entries.size() - 1) {
                    sb.append(",");
                }
                sb.append("\n");
            }
            sb.append("})\n");
        }

        // A plain interface: Java 11 has no sealed types. Jackson knows the variants from the
        // annotations above; the Unknown fallback covers the rest.
        sb.append("public interface ").append(type.name()).append(" {}\n");

        return sb.toString();
    }

    /**
     * {@code of(...)} taking only the required fields (optional ones start as null), so a value
     * can be built from there with the withers. Generated when it is shorter than the all-fields
     * constructor: when there is an optional field or a discriminator to fill in.
     *
     * @param fixedField the subtype's discriminator field (Java name), filled in by {@code of(...)}; or null
     * @param fixedValue the Java expression of its value
     */
    private static String staticFactory(String className, List<ValueClass.Field> fields,
                                        String fixedField, String fixedValue) {
        boolean hasOptional = fields.stream().anyMatch(ValueClass.Field::nullable);
        if (!hasOptional && fixedField == null) {
            return "";
        }
        List<String> parameters = new ArrayList<>();
        List<String> arguments = new ArrayList<>();
        for (ValueClass.Field field : fields) {
            if (field.javaName().equals(fixedField)) {
                arguments.add(fixedValue);
            } else if (field.nullable()) {
                arguments.add("null");
            } else {
                parameters.add(field.type() + " " + field.javaName());
                arguments.add(field.javaName());
            }
        }
        return "\n    public static " + className + " of(" + String.join(", ", parameters) + ") {\n"
                + "        return new " + className + "(" + String.join(", ", arguments) + ");\n"
                + "    }\n";
    }

    /** The Java expression of a subtype's discriminator value, e.g. {@code InputMediaType.PHOTO}. */
    private static String discriminatorValue(String subtype, String parentName, List<ValueClass.Field> fields) {
        UnionRegistry.UnionInfo info = UnionRegistry.get(parentName);
        String key = info.subtypes().entrySet().stream()
                .filter(entry -> entry.getValue().equals(subtype))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(subtype + " is not registered under " + parentName));
        String wireValue = UnionRegistry.wireName(parentName, key);
        String type = fields.stream()
                .filter(field -> field.javaName().equals(info.discriminator()))
                .map(ValueClass.Field::type)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(subtype + " has no " + info.discriminator() + " field"));
        return type.equals("String")
                ? "\"" + wireValue + "\""
                : type + "." + EnumGenerator.toConstantName(wireValue);
    }

    private String generatePlainInterface(TypeDefinition type) {
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(basePackage).append(";\n\n");
        sb.append(Javadoc.render(type.description(), List.of(), type.name()));
        sb.append("public interface ").append(type.name()).append(" {}\n");
        return sb.toString();
    }

    /**
     * Returns the interface name this type should implement via INTERFACE_IMPLEMENTATIONS,
     * or null if none.
     */
    private static String getAdditionalInterface(String typeName) {
        for (Map.Entry<String, Set<String>> entry : INTERFACE_IMPLEMENTATIONS.entrySet()) {
            if (entry.getValue().contains(typeName)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private String generateSubtypeClass(TypeDefinition type) {
        String parentName = UnionRegistry.parentOf(type.name());
        UnionRegistry.UnionInfo parentInfo = UnionRegistry.get(parentName);

        // The discriminator is read into the field (the union is visible = true)
        // but never written from it: Jackson already writes the type id for the
        // concrete class, so serializing the field too would duplicate the key.
        String writeOnlyField = isValueBasedDiscriminator(parentInfo) ? null : parentInfo.discriminator();

        Set<String> imports = new TreeSet<>();
        List<ValueClass.Field> fields = buildFields(type.name(), type.fields(), writeOnlyField, imports);
        String factory = staticFactory(type.name(), fields, writeOnlyField,
                writeOnlyField == null ? null : discriminatorValue(type.name(), parentName, fields));

        return classSource(type, List.of(parentName), fields, imports, factory);
    }

    /**
     * Generates the fallback class for a discriminated union: it holds the raw
     * discriminator value plus every other field, and serializes back to the
     * original JSON shape via {@code UnknownVariant.Serializer}.
     * <p>
     * Jackson 2.13 (Spring Boot 2.7) cannot pass {@code @JsonAnySetter} values to a creator, so
     * deserialization goes through a private creator taking the discriminator, and a private
     * any-setter collects the other fields. Nothing else can change them afterwards.
     */
    String generateUnknownVariant(String parentName) {
        String discriminator = UnionRegistry.get(parentName).discriminator();
        String name = unknownVariantName(parentName);

        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(basePackage).append(";\n\n");
        sb.append("import ").append(JACKSON_ANNOTATION_PACKAGE).append(".JsonAnySetter;\n");
        sb.append("import ").append(JACKSON_ANNOTATION_PACKAGE).append(".JsonCreator;\n");
        sb.append("import ").append(JACKSON_ANNOTATION_PACKAGE).append(".JsonProperty;\n");
        sb.append("import ").append(JACKSON_DATABIND_ANNOTATION_PACKAGE).append(".JsonSerialize;\n");
        sb.append("import java.util.Collections;\n");
        sb.append("import java.util.LinkedHashMap;\n");
        sb.append("import java.util.Map;\n");
        sb.append("import java.util.Objects;\n");
        sb.append("import ").append(NULLABLE_PACKAGE).append(".Nullable;\n\n");
        sb.append("/**\n");
        sb.append(" * A {@link ").append(parentName).append("} variant unknown to this library version.\n");
        sb.append(" * Holds the raw {@code ").append(discriminator)
                .append("} value and all other fields as they were received.\n");
        sb.append(" */\n");
        sb.append("@JsonSerialize(using = UnknownVariant.Serializer.class)\n");
        sb.append("public final class ").append(name).append(" implements ").append(parentName)
                .append(", UnknownVariant {\n\n");
        sb.append("    private final @Nullable String ").append(discriminator).append(";\n");
        sb.append("    private final Map<String, Object> data;\n\n");
        sb.append("    /**\n");
        sb.append("     * Creates a new {@code ").append(name).append("} instance.\n");
        sb.append("     *\n");
        sb.append("     * @param ").append(discriminator).append(" the raw discriminator value, or null if missing\n");
        sb.append("     * @param data all other fields; copied, null means none\n");
        sb.append("     */\n");
        sb.append("    public ").append(name).append("(@Nullable String ").append(discriminator)
                .append(", @Nullable Map<String, Object> data) {\n");
        sb.append("        this.").append(discriminator).append(" = ").append(discriminator).append(";\n");
        sb.append("        this.data = data == null ? new LinkedHashMap<>() : new LinkedHashMap<>(data);\n");
        sb.append("    }\n\n");
        sb.append("    /** Used by Jackson, which then adds the other fields with {@code addField}. */\n");
        sb.append("    @JsonCreator\n");
        sb.append("    private ").append(name).append("(@JsonProperty(\"").append(discriminator)
                .append("\") @Nullable String ").append(discriminator).append(") {\n");
        sb.append("        this(").append(discriminator).append(", null);\n");
        sb.append("    }\n\n");
        sb.append("    @JsonAnySetter\n");
        sb.append("    private void addField(String name, Object value) {\n");
        sb.append("        data.put(name, value);\n");
        sb.append("    }\n\n");
        sb.append("    /**\n");
        sb.append("     * Returns the raw {@code ").append(discriminator).append("} value, or null if it was missing.\n");
        sb.append("     */\n");
        sb.append("    public @Nullable String ").append(discriminator).append("() {\n");
        sb.append("        return ").append(discriminator).append(";\n");
        sb.append("    }\n\n");
        sb.append("    @Override\n");
        sb.append("    public Map<String, Object> data() {\n");
        sb.append("        return Collections.unmodifiableMap(data);\n");
        sb.append("    }\n\n");
        sb.append("    @Override\n");
        sb.append("    public String discriminatorName() {\n");
        sb.append("        return \"").append(discriminator).append("\";\n");
        sb.append("    }\n\n");
        sb.append("    @Override\n");
        sb.append("    public @Nullable String discriminatorValue() {\n");
        sb.append("        return ").append(discriminator).append(";\n");
        sb.append("    }\n\n");
        sb.append("    @Override\n");
        sb.append("    public boolean equals(Object o) {\n");
        sb.append("        if (this == o) {\n");
        sb.append("            return true;\n");
        sb.append("        }\n");
        sb.append("        if (!(o instanceof ").append(name).append(")) {\n");
        sb.append("            return false;\n");
        sb.append("        }\n");
        sb.append("        ").append(name).append(" that = (").append(name).append(") o;\n");
        sb.append("        return Objects.equals(this.").append(discriminator).append(", that.").append(discriminator)
                .append(")\n");
        sb.append("                && this.data.equals(that.data);\n");
        sb.append("    }\n\n");
        sb.append("    @Override\n");
        sb.append("    public int hashCode() {\n");
        sb.append("        return Objects.hash(this.").append(discriminator).append(", this.data);\n");
        sb.append("    }\n\n");
        sb.append("    @Override\n");
        sb.append("    public String toString() {\n");
        sb.append("        return \"").append(name).append("[").append(discriminator).append("=\" + this.")
                .append(discriminator).append(" + \", data=\" + this.data + \"]\";\n");
        sb.append("    }\n");
        sb.append("}\n");

        return sb.toString();
    }

    static String unknownVariantName(String parentName) {
        return parentName + "Unknown";
    }

    private static boolean hasUnknownVariant(UnionRegistry.UnionInfo unionInfo) {
        return !unionInfo.subtypes().isEmpty() && !isValueBasedDiscriminator(unionInfo);
    }

    /**
     * Detects value-based discriminators (e.g. MaybeInaccessibleMessage's "date == 0"
     * pattern). These cannot be expressed with @JsonSubTypes because Jackson does exact
     * string matching on discriminator values; a hand-written TypeIdResolver bridges the gap.
     */
    private static boolean isValueBasedDiscriminator(UnionRegistry.UnionInfo unionInfo) {
        return unionInfo.subtypes().containsKey("nonzero");
    }

    /**
     * Resolves the type of each schema field, collecting the imports the types need.
     *
     * @param writeOnlyField JSON name of a field to mark {@code WRITE_ONLY} (the union
     *                       discriminator of a subtype), or {@code null}
     */
    private List<ValueClass.Field> buildFields(String ownerTypeName, List<FieldDefinition> fields,
                                               String writeOnlyField, Set<String> imports) {
        List<ValueClass.Field> result = new ArrayList<>();
        for (FieldDefinition field : fields) {
            TypeName javaType = typeMapper.resolveTypeField(ownerTypeName, field);
            String typeString = resolveTypeString(javaType, imports);
            boolean nullable = !field.required() && !javaType.isPrimitive();
            result.add(new ValueClass.Field(field, typeString, nullable, field.name().equals(writeOnlyField)));
        }
        return result;
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
            String rawString = resolveTypeString(paramType.rawType, imports);
            String args = paramType.typeArguments.stream()
                    .map(arg -> resolveTypeString(arg, imports))
                    .collect(Collectors.joining(", "));
            return rawString + "<" + args + ">";
        }
        if (typeName instanceof ClassName className) {
            String fullName = className.packageName() + "." + className.simpleName();
            if (!"java.lang".equals(className.packageName())) {
                imports.add(fullName);
            }
            return className.simpleName();
        }
        return typeName.box().toString();
    }
}
