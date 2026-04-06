package io.jiogram.codegen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

import java.util.List;
import java.util.Objects;

/**
 * Resolves Telegram Bot API schema type strings to JavaPoet {@link TypeName} objects.
 * <p>
 * Mapping rules:
 * <ul>
 *   <li>{@code "Integer"} &rarr; {@code long} / {@code Long}</li>
 *   <li>{@code "String"} &rarr; {@code String}</li>
 *   <li>{@code "Boolean"} &rarr; {@code boolean} / {@code Boolean}</li>
 *   <li>{@code "Float"} / {@code "Float number"} &rarr; {@code double} / {@code Double}</li>
 *   <li>{@code "True"} &rarr; {@code boolean} / {@code Boolean}</li>
 *   <li>{@code "Array of X"} &rarr; {@code List<X>} (element always boxed)</li>
 *   <li>{@code "Integer or String"} &rarr; {@code ChatId}</li>
 *   <li>{@code "InputFile or String"} &rarr; {@code InputFileOrString}</li>
 *   <li>Multi-type unions (4+ types like reply_markup) &rarr; {@code ReplyMarkup}</li>
 *   <li>Other entity names &rarr; {@code ClassName.get(typesPackage, name)}</li>
 * </ul>
 */
public final class TypeMapper {

    private final String typesPackage;

    /**
     * Creates a new TypeMapper that resolves entity types into the given package.
     *
     * @param typesPackage the Java package for generated types, e.g. "io.jiogram.types"
     */
    public TypeMapper(String typesPackage) {
        this.typesPackage = Objects.requireNonNull(typesPackage, "typesPackage must not be null");
    }

    /**
     * Resolves a Telegram Bot API type string to a JavaPoet {@link TypeName}.
     *
     * @param telegramType the type string from the schema (e.g. "Integer", "Array of Message")
     * @param required     whether the field is required (affects primitive vs boxed for scalars)
     * @return the resolved JavaPoet type
     */
    public TypeName resolve(String telegramType, boolean required) {
        Objects.requireNonNull(telegramType, "telegramType must not be null");

        // Handle array types first (recursive)
        if (telegramType.startsWith("Array of ")) {
            String elementType = telegramType.substring("Array of ".length());
            // Element types in arrays are always boxed
            TypeName element = resolve(elementType, false);
            return ParameterizedTypeName.get(ClassName.get(List.class), element.box());
        }

        // Handle union types (contains " or ")
        if (telegramType.contains(" or ")) {
            return resolveUnion(telegramType);
        }

        // Handle scalar/primitive types
        return switch (telegramType) {
            case "Integer" -> required ? TypeName.LONG : TypeName.LONG.box();
            case "String" -> ClassName.get(String.class);
            case "Boolean" -> required ? TypeName.BOOLEAN : TypeName.BOOLEAN.box();
            case "Float", "Float number" -> required ? TypeName.DOUBLE : TypeName.DOUBLE.box();
            case "True" -> required ? TypeName.BOOLEAN : TypeName.BOOLEAN.box();
            default -> ClassName.get(typesPackage, telegramType);
        };
    }

    /**
     * Resolves a return type string. Delegates to {@link #resolve(String, boolean)} with
     * {@code required=false} so return types are always boxed.
     *
     * @param returnType the return type string from the schema
     * @return the resolved JavaPoet type
     */
    public TypeName resolveReturnType(String returnType) {
        return resolve(returnType, false);
    }

    private TypeName resolveUnion(String unionType) {
        String[] parts = unionType.split(" or ");

        // "Integer or String" -> ChatId
        if (parts.length == 2) {
            String a = parts[0].trim();
            String b = parts[1].trim();

            if (("Integer".equals(a) && "String".equals(b))
                    || ("String".equals(a) && "Integer".equals(b))) {
                return ClassName.get(typesPackage, "ChatId");
            }

            if (("InputFile".equals(a) && "String".equals(b))
                    || ("String".equals(a) && "InputFile".equals(b))) {
                return ClassName.get(typesPackage, "InputFileOrString");
            }
        }

        // Multi-type unions (4+ types, like reply_markup variants) -> ReplyMarkup
        if (parts.length >= 4) {
            return ClassName.get(typesPackage, "ReplyMarkup");
        }

        // For other 2-3 part unions, fall back to the first type
        // (this handles edge cases not explicitly specified)
        return ClassName.get(typesPackage, parts[0].trim());
    }
}
