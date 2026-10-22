package io.jiogram.codegen;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Renders "wither" methods for a generated value class: {@code withCaption(caption)} returns a
 * copy with that one field replaced, so an optional value can be added without spelling out the
 * whole all-fields constructor.
 */
final class Withers {

    /**
     * A field of a generated class as declared in the source.
     *
     * @param javaName the field name
     * @param type     its Java type as written in the source
     * @param nullable whether the field is {@code @Nullable}
     * @param withered whether it gets a wither (a subtype's fixed discriminator does not)
     */
    record Component(String javaName, String type, boolean nullable, boolean withered) {
    }

    private Withers() {
    }

    /**
     * Returns the wither methods of a class, each preceded by a blank line, or "" when no
     * field gets one. Every wither passes all fields by name to the all-fields constructor; its
     * parameter shadows the field it replaces.
     */
    static String render(String className, List<Component> components) {
        String arguments = components.stream().map(Component::javaName).collect(Collectors.joining(", "));
        StringBuilder sb = new StringBuilder();
        for (Component component : components) {
            if (!component.withered()) {
                continue;
            }
            sb.append("\n");
            sb.append("    public ").append(className).append(" with").append(capitalize(component.javaName()))
                    .append("(").append(component.nullable() ? "@Nullable " : "").append(component.type())
                    .append(" ").append(component.javaName()).append(") {\n");
            sb.append("        return new ").append(className).append("(").append(arguments).append(");\n");
            sb.append("    }\n");
        }
        return sb.toString();
    }

    private static String capitalize(String name) {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
