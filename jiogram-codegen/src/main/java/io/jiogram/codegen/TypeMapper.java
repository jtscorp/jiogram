package io.jiogram.codegen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import io.jiogram.codegen.model.FieldDefinition;

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
            // Handle comma/and-separated multi-type arrays
            // e.g. "InputMediaAudio, InputMediaDocument, InputMediaPhoto and InputMediaVideo" -> InputMedia
            if (elementType.contains(",") || elementType.contains(" and ")) {
                elementType = resolveMultiTypeArrayElement(elementType);
            }
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
            case "Integer", "Int" -> required ? TypeName.LONG : TypeName.LONG.box();
            case "String" -> ClassName.get(String.class);
            case "Boolean" -> required ? TypeName.BOOLEAN : TypeName.BOOLEAN.box();
            case "Float", "Float number" -> required ? TypeName.DOUBLE : TypeName.DOUBLE.box();
            case "True" -> required ? TypeName.BOOLEAN : TypeName.BOOLEAN.box();
            default -> ClassName.get(typesPackage, telegramType);
        };
    }

    /**
     * Resolves a field type with knowledge of the owning Telegram type.
     * The raw schema models many closed value sets as {@code String}; when a
     * generated enum exists, map those fields to the enum instead.
     */
    public TypeName resolveTypeField(String ownerTypeName, FieldDefinition field) {
        TypeName enumType = resolveEnumField(ownerTypeName, field.name(), field.type());
        if (enumType != null) {
            return enumType;
        }
        return resolve(field.type(), field.required());
    }

    /**
     * Resolves a method parameter type with knowledge of the owning API method.
     */
    public TypeName resolveMethodParameter(String methodName, FieldDefinition parameter) {
        String name = parameter.name();
        if ("parse_mode".equals(name) || name.endsWith("_parse_mode")) {
            return ClassName.get(typesPackage, "ParseMode");
        }
        if ("allowed_updates".equals(name) && parameter.type().startsWith("Array of ")) {
            return ParameterizedTypeName.get(
                ClassName.get(List.class),
                ClassName.get(typesPackage, "UpdateType")
            );
        }
        if ("sendChatAction".equals(methodName) && "action".equals(name)) {
            return ClassName.get(typesPackage, "ChatAction");
        }
        if ("sendPoll".equals(methodName) && "type".equals(name)) {
            return ClassName.get(typesPackage, "PollType");
        }
        if ("createNewStickerSet".equals(methodName) && "sticker_type".equals(name)) {
            return ClassName.get(typesPackage, "StickerType");
        }
        return resolve(parameter.type(), parameter.required());
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

    private TypeName resolveEnumField(String ownerTypeName, String fieldName, String telegramType) {
        if ("WebhookInfo".equals(ownerTypeName) && "allowed_updates".equals(fieldName)
            && telegramType.startsWith("Array of ")) {
            return ParameterizedTypeName.get(
                ClassName.get(List.class),
                ClassName.get(typesPackage, "UpdateType")
            );
        }

        if (!"String".equals(telegramType)) {
            return null;
        }

        if ("parse_mode".equals(fieldName) || fieldName.endsWith("_parse_mode")) {
            return ClassName.get(typesPackage, "ParseMode");
        }
        if ("Chat".equals(ownerTypeName) && "type".equals(fieldName)) {
            return ClassName.get(typesPackage, "ChatType");
        }
        if ("ChatFullInfo".equals(ownerTypeName) && "type".equals(fieldName)) {
            return ClassName.get(typesPackage, "ChatType");
        }
        if ("MessageEntity".equals(ownerTypeName) && "type".equals(fieldName)) {
            return ClassName.get(typesPackage, "MessageEntityType");
        }
        if ("Poll".equals(ownerTypeName) && "type".equals(fieldName)) {
            return ClassName.get(typesPackage, "PollType");
        }
        if ("KeyboardButtonPollType".equals(ownerTypeName) && "type".equals(fieldName)) {
            return ClassName.get(typesPackage, "PollType");
        }
        if ("Sticker".equals(ownerTypeName) && "type".equals(fieldName)) {
            return ClassName.get(typesPackage, "StickerType");
        }
        if ("StickerSet".equals(ownerTypeName) && "sticker_type".equals(fieldName)) {
            return ClassName.get(typesPackage, "StickerType");
        }
        if ("InlineQuery".equals(ownerTypeName) && "chat_type".equals(fieldName)) {
            return ClassName.get(typesPackage, "InlineQueryChatType");
        }
        if ("TransactionPartnerUser".equals(ownerTypeName) && "transaction_type".equals(fieldName)) {
            return ClassName.get(typesPackage, "TransactionType");
        }
        if (("InlineQueryResultGif".equals(ownerTypeName) || "InlineQueryResultMpeg4Gif".equals(ownerTypeName))
            && "thumbnail_mime_type".equals(fieldName)) {
            return ClassName.get(typesPackage, "ThumbnailMimeType");
        }
        if ("InlineQueryResultVideo".equals(ownerTypeName) && "mime_type".equals(fieldName)) {
            return ClassName.get(typesPackage, "VideoMimeType");
        }
        if ("InlineQueryResultDocument".equals(ownerTypeName) && "mime_type".equals(fieldName)) {
            return ClassName.get(typesPackage, "DocumentMimeType");
        }
        if ("EncryptedPassportElement".equals(ownerTypeName) && "type".equals(fieldName)) {
            return ClassName.get(typesPackage, "PassportElementType");
        }
        if (ownerTypeName.startsWith("PassportElementError") && "type".equals(fieldName)) {
            return ClassName.get(typesPackage, "PassportElementType");
        }
        String parentName = UnionRegistry.parentOf(ownerTypeName);
        if (parentName == null || "MaybeInaccessibleMessage".equals(parentName)) {
            return null;
        }

        UnionRegistry.UnionInfo unionInfo = UnionRegistry.get(parentName);
        if (unionInfo != null && unionInfo.discriminator().equals(fieldName)) {
            return ClassName.get(typesPackage, parentName + "Type");
        }
        return null;
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

    /**
     * Resolves a comma-and-"and"-separated multi-type list to a common parent type.
     * e.g. "InputMediaAudio, InputMediaDocument, InputMediaPhoto and InputMediaVideo" -> "InputMedia"
     */
    private String resolveMultiTypeArrayElement(String elementType) {
        // Split on commas and " and "
        String[] types = elementType.split("\\s*,\\s*|\\s+and\\s+");
        if (types.length == 0) {
            return elementType;
        }

        // Find the longest common prefix of all type names
        String prefix = types[0].trim();
        for (int i = 1; i < types.length; i++) {
            String t = types[i].trim();
            int j = 0;
            while (j < prefix.length() && j < t.length() && prefix.charAt(j) == t.charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
        }

        // If we found a meaningful common prefix (at least 3 chars), check if it's a known union parent
        if (prefix.length() >= 3 && UnionRegistry.isDiscriminatedUnion(prefix)) {
            return prefix;
        }

        // Fallback: use the first type
        return types[0].trim();
    }
}
