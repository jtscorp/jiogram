package io.jiogram.codegen;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Renders "wither" methods for a generated record: {@code withCaption(caption)} returns a copy
 * with that one component replaced, so an optional value can be added without spelling out the
 * whole canonical constructor.
 */
final class Withers {

    /**
     * A record component as declared in the generated source.
     *
     * @param javaName the component name
     * @param type     its Java type as written in the source
     * @param nullable whether the component is {@code @Nullable}
     * @param withered whether it gets a wither (a subtype's fixed discriminator does not)
     */
    record Component(String javaName, String type, boolean nullable, boolean withered) {
    }

    private Withers() {
    }

    /**
     * Returns the wither methods of a record, each preceded by a blank line, or "" when no
     * component gets one. Every wither passes all components by name to the canonical
     * constructor; its parameter shadows the component it replaces.
     */
    static String render(String recordName, List<Component> components) {
        String arguments = components.stream().map(Component::javaName).collect(Collectors.joining(", "));
        StringBuilder sb = new StringBuilder();
        for (Component component : components) {
            if (!component.withered()) {
                continue;
            }
            sb.append("\n");
            sb.append("    public ").append(recordName).append(" with").append(capitalize(component.javaName()))
                    .append("(").append(component.nullable() ? "@Nullable " : "").append(component.type())
                    .append(" ").append(component.javaName()).append(") {\n");
            sb.append("        return new ").append(recordName).append("(").append(arguments).append(");\n");
            sb.append("    }\n");
        }
        return sb.toString();
    }

    private static String capitalize(String name) {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
