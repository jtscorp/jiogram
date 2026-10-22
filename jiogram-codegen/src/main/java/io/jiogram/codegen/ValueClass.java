package io.jiogram.codegen;

import io.jiogram.codegen.model.FieldDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Renders a generated value class: the Java 11 stand-in for a record. It has a private final
 * field per schema field, a {@code @JsonCreator} constructor taking all of them in schema order
 * (the record's canonical constructor), accessors named like the fields ({@code text()}, as a
 * record's), and {@code equals}, {@code hashCode} and {@code toString} with a record's semantics.
 */
final class ValueClass {

    static final String JACKSON_ANNOTATION_PACKAGE = "com.fasterxml.jackson.annotation";
    static final String NULLABLE_PACKAGE = "org.jspecify.annotations";

    /**
     * A field of a generated class.
     *
     * @param definition the schema field: JSON name, Java name and description
     * @param type       its Java type as written in the source
     * @param nullable   whether it is {@code @Nullable}
     * @param writeOnly  whether Jackson only reads it ({@code access = WRITE_ONLY}): a union
     *                   subtype's discriminator, written by Jackson as the type id instead
     */
    record Field(FieldDefinition definition, String type, boolean nullable, boolean writeOnly) {

        String javaName() {
            return definition.javaName();
        }

        /** {@code @JsonProperty(...)} with the JSON name, and the access when write-only. */
        String jsonProperty() {
            return writeOnly
                    ? "@JsonProperty(value = \"" + definition.name() + "\", access = JsonProperty.Access.WRITE_ONLY)"
                    : "@JsonProperty(\"" + definition.name() + "\")";
        }

        /** The type with its {@code @Nullable}, as declared on fields, parameters and accessors. */
        String declaredType() {
            return nullable ? "@Nullable " + type : type;
        }

        /** A subtype's fixed discriminator gets no wither: changing it would make no sense. */
        Withers.Component witherComponent() {
            return new Withers.Component(javaName(), type, nullable, !writeOnly);
        }
    }

    private ValueClass() {
    }

    /** Adds the imports the class body rendered by {@link #render} needs. */
    static void addImports(List<Field> fields, Set<String> imports) {
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonAutoDetect");
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonAutoDetect.Visibility");
        if (fields.isEmpty()) {
            return;
        }
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonCreator");
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonProperty");
        imports.add("java.util.Objects");
        if (fields.stream().anyMatch(Field::nullable)) {
            imports.add(NULLABLE_PACKAGE + ".Nullable");
        }
    }

    /**
     * Renders the class declaration, from its annotations to the closing brace. The class
     * comment goes before it.
     *
     * @param className    the simple class name
     * @param interfaces   the interfaces it implements, in order
     * @param fields       its fields, in schema order
     * @param extraMembers members placed after the constructor (factories, overrides), each
     *                     preceded by a blank line; or ""
     */
    static String render(String className, List<String> interfaces, List<Field> fields, String extraMembers) {
        StringBuilder sb = new StringBuilder();
        // Jackson binds the annotated fields and the creator only. Without this it would also
        // take an accessor such as isBot() for a bean getter and write an extra "bot" property.
        // Being a Jackson annotation, it also lets a class without fields serialize as {}
        // (instead of failing with FAIL_ON_EMPTY_BEANS), as a record without components does.
        sb.append("@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)\n");
        sb.append("public final class ").append(className);
        if (!interfaces.isEmpty()) {
            sb.append(" implements ").append(String.join(", ", interfaces));
        }
        sb.append(" {\n");

        for (Field field : fields) {
            sb.append("\n");
            sb.append("    ").append(field.jsonProperty()).append("\n");
            sb.append("    private final ").append(field.declaredType()).append(" ").append(field.javaName())
                    .append(";\n");
        }

        sb.append("\n");
        sb.append(constructor(className, fields));
        sb.append(extraMembers);

        for (Field field : fields) {
            sb.append("\n");
            sb.append(Javadoc.member(field.definition().description()));
            sb.append("    public ").append(field.declaredType()).append(" ").append(field.javaName())
                    .append("() {\n");
            sb.append("        return ").append(field.javaName()).append(";\n");
            sb.append("    }\n");
        }

        sb.append(Withers.render(className, fields.stream().map(Field::witherComponent).toList()));
        sb.append(equalsHashCodeToString(className, fields));
        sb.append("}\n");
        return sb.toString();
    }

    private static String constructor(String className, List<Field> fields) {
        StringBuilder sb = new StringBuilder();
        sb.append(Javadoc.constructor(className, fields.stream().map(Field::definition).toList()));
        if (fields.isEmpty()) {
            sb.append("    public ").append(className).append("() {\n");
            sb.append("    }\n");
            return sb.toString();
        }
        sb.append("    @JsonCreator\n");
        sb.append("    public ").append(className).append("(\n");
        List<String> parameters = new ArrayList<>();
        for (Field field : fields) {
            parameters.add("            " + field.jsonProperty() + " " + field.declaredType() + " " + field.javaName());
        }
        sb.append(String.join(",\n", parameters)).append(") {\n");
        for (Field field : fields) {
            sb.append("        this.").append(field.javaName()).append(" = ").append(field.javaName()).append(";\n");
        }
        sb.append("    }\n");
        return sb.toString();
    }

    /**
     * {@code equals}, {@code hashCode} and {@code toString} as a record has them: equal when of
     * the same class with equal fields (doubles compared with {@link Double#compare}), and
     * printed as {@code Name[field=value, ...]}. Fields are read through {@code this.} and
     * {@code that.}, so a field named like a local variable cannot shadow anything.
     */
    static String equalsHashCodeToString(String className, List<Field> fields) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("    @Override\n");
        sb.append("    public boolean equals(Object o) {\n");
        if (fields.isEmpty()) {
            sb.append("        return o instanceof ").append(className).append(";\n");
        } else {
            sb.append("        if (this == o) {\n");
            sb.append("            return true;\n");
            sb.append("        }\n");
            sb.append("        if (!(o instanceof ").append(className).append(")) {\n");
            sb.append("            return false;\n");
            sb.append("        }\n");
            sb.append("        ").append(className).append(" that = (").append(className).append(") o;\n");
            List<String> comparisons = new ArrayList<>();
            for (Field field : fields) {
                comparisons.add(fieldEquals(field));
            }
            sb.append("        return ").append(String.join("\n                && ", comparisons)).append(";\n");
        }
        sb.append("    }\n");

        sb.append("\n");
        sb.append("    @Override\n");
        sb.append("    public int hashCode() {\n");
        if (fields.isEmpty()) {
            sb.append("        return 0;\n");
        } else {
            List<String> values = new ArrayList<>();
            for (Field field : fields) {
                values.add("this." + field.javaName());
            }
            sb.append("        return Objects.hash(").append(String.join(", ", values)).append(");\n");
        }
        sb.append("    }\n");

        sb.append("\n");
        sb.append("    @Override\n");
        sb.append("    public String toString() {\n");
        if (fields.isEmpty()) {
            sb.append("        return \"").append(className).append("[]\";\n");
        } else {
            List<String> parts = new ArrayList<>();
            for (int i = 0; i < fields.size(); i++) {
                String name = fields.get(i).javaName();
                parts.add("\"" + (i == 0 ? className + "[" : ", ") + name + "=\" + this." + name);
            }
            sb.append("        return ").append(String.join("\n                + ", parts))
                    .append("\n                + \"]\";\n");
        }
        sb.append("    }\n");
        return sb.toString();
    }

    private static String fieldEquals(Field field) {
        String name = field.javaName();
        return switch (field.type()) {
            case "double" -> "Double.compare(this." + name + ", that." + name + ") == 0";
            case "float" -> "Float.compare(this." + name + ", that." + name + ") == 0";
            case "long", "int", "short", "byte", "char", "boolean" -> "this." + name + " == that." + name;
            default -> "Objects.equals(this." + name + ", that." + name + ")";
        };
    }
}
