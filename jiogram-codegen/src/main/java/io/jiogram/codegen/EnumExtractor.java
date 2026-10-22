package io.jiogram.codegen;

import io.jiogram.codegen.model.ApiSchema;
import io.jiogram.codegen.model.EnumDefinition;
import io.jiogram.codegen.model.FieldDefinition;
import io.jiogram.codegen.model.MethodDefinition;
import io.jiogram.codegen.model.TypeDefinition;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Extracts enum definitions from the Telegram Bot API schema.
 * <p>
 * Three sources of enum values:
 * <ol>
 *   <li>Well-known hardcoded enums (ParseMode, UpdateType, ContentType)</li>
 *   <li>Schema field descriptions (ChatType, MessageEntityType, ChatAction)</li>
 *   <li>Discriminated union subtypes from {@link UnionRegistry}</li>
 * </ol>
 */
public final class EnumExtractor {

    private static final Pattern QUOTED_VALUE = Pattern.compile("[\"']([a-z_]+)[\"']");

    private EnumExtractor() {
    }

    /**
     * Extracts all enum definitions from the given API schema.
     *
     * @param schema the parsed API schema
     * @return a list of enum definitions
     */
    public static List<EnumDefinition> extract(ApiSchema schema) {
        Objects.requireNonNull(schema, "schema must not be null");

        List<EnumDefinition> enums = new ArrayList<>();

        // 1. Well-known hardcoded enums
        enums.addAll(wellKnownEnums(schema));

        // 2. Enums from schema field descriptions
        enums.addAll(descriptionEnums(schema));

        // 3. Enums from discriminated union subtypes
        enums.addAll(unionDiscriminatorEnums());

        return enums;
    }

    private static List<EnumDefinition> wellKnownEnums(ApiSchema schema) {
        List<EnumDefinition> enums = new ArrayList<>();

        // ParseMode
        enums.add(new EnumDefinition("ParseMode", "Formatting options for messages.",
                List.of("HTML", "Markdown", "MarkdownV2")));

        // UpdateType — field names from the Update type
        schema.types().stream()
                .filter(t -> "Update".equals(t.name()))
                .findFirst()
                .ifPresent(updateType -> {
                    List<String> updateFields = updateType.fields().stream()
                            .map(FieldDefinition::name)
                            .filter(name -> !"update_id".equals(name))
                            .toList();
                    enums.add(new EnumDefinition("UpdateType", "Types of updates.", updateFields));
                });

        // ContentType — common message content types
        enums.add(new EnumDefinition("ContentType", "Common message content types.", List.of(
                "text", "animation", "audio", "document", "photo", "sticker",
                "story", "video", "video_note", "voice", "contact", "dice",
                "game", "poll", "venue", "location", "invoice",
                "successful_payment", "new_chat_members", "left_chat_member",
                "new_chat_title", "new_chat_photo", "delete_chat_photo",
                "group_chat_created", "supergroup_chat_created", "channel_chat_created",
                "pinned_message", "web_app_data"
        )));

        // ChatAction — hardcoded because the schema description uses italics, not quotes
        enums.add(new EnumDefinition("ChatAction", "Type of action to broadcast.", List.of(
                "typing", "upload_photo", "record_video", "upload_video",
                "record_voice", "upload_voice", "upload_document",
                "choose_sticker", "find_location", "record_video_note", "upload_video_note"
        )));

        enums.add(new EnumDefinition("PollType", "Type of poll.", List.of(
                "regular", "quiz"
        )));

        enums.add(new EnumDefinition("StickerType", "Type of sticker.", List.of(
                "regular", "mask", "custom_emoji"
        )));

        enums.add(new EnumDefinition("InlineQueryChatType", "Type of chat where an inline query was sent.", List.of(
                "sender", "private", "group", "supergroup", "channel"
        )));

        enums.add(new EnumDefinition("TransactionType", "Type of transaction with a user.", List.of(
                "invoice_payment", "paid_media_payment", "gift_purchase",
                "premium_purchase", "business_account_transfer"
        )));

        enums.add(new EnumDefinition("ThumbnailMimeType", "Supported thumbnail MIME type.", List.of(
                "image/jpeg", "image/gif", "video/mp4"
        )));

        enums.add(new EnumDefinition("VideoMimeType", "Supported video MIME type.", List.of(
                "text/html", "video/mp4"
        )));

        enums.add(new EnumDefinition("DocumentMimeType", "Supported document MIME type.", List.of(
                "application/pdf", "application/zip"
        )));

        enums.add(new EnumDefinition("PassportElementType", "Telegram Passport element type.", List.of(
                "personal_details", "passport", "driver_license", "identity_card",
                "internal_passport", "address", "utility_bill", "bank_statement",
                "rental_agreement", "passport_registration", "temporary_registration",
                "phone_number", "email"
        )));

        return enums;
    }

    private static List<EnumDefinition> descriptionEnums(ApiSchema schema) {
        List<EnumDefinition> enums = new ArrayList<>();

        // ChatType — from Chat.type description
        extractFromTypeField(schema, "Chat", "type")
                .ifPresent(values -> enums.add(new EnumDefinition(
                        "ChatType", "Type of chat.", values)));

        // MessageEntityType — from MessageEntity.type description
        extractFromTypeField(schema, "MessageEntity", "type")
                .ifPresent(values -> enums.add(new EnumDefinition(
                        "MessageEntityType", "Type of the entity.", values)));

        return enums;
    }

    private static List<EnumDefinition> unionDiscriminatorEnums() {
        List<EnumDefinition> enums = new ArrayList<>();

        for (Map.Entry<String, UnionRegistry.UnionInfo> entry : UnionRegistry.all().entrySet()) {
            String parentName = entry.getKey();
            UnionRegistry.UnionInfo info = entry.getValue();

            if (info.subtypes().isEmpty()) {
                continue;
            }

            // Create enum name: e.g. ChatMember -> ChatMemberType
            String enumName = parentName + "Type";

            // Sort discriminator values alphabetically so the generated enum
            // is deterministic across JVM runs (UnionRegistry's Map.of(...)
            // input has unspecified iteration order).
            List<String> values = info.subtypes().keySet().stream()
                    .map(key -> UnionRegistry.wireName(parentName, key))
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            enums.add(new EnumDefinition(enumName,
                    "Discriminator values for " + parentName + ".",
                    values));
        }

        return enums;
    }

    /**
     * Extracts quoted values from a type field's description.
     */
    private static Optional<List<String>> extractFromTypeField(ApiSchema schema, String typeName, String fieldName) {
        return schema.types().stream()
                .filter(t -> typeName.equals(t.name()))
                .findFirst()
                .flatMap(type -> type.fields().stream()
                        .filter(f -> fieldName.equals(f.name()))
                        .findFirst()
                        .map(field -> extractQuotedValues(field.description())));
    }

    /**
     * Extracts quoted values from a method parameter's description.
     */
    private static Optional<List<String>> extractFromMethodParameter(ApiSchema schema, String methodName, String paramName) {
        return schema.methods().stream()
                .filter(m -> methodName.equals(m.name()))
                .findFirst()
                .flatMap(method -> method.parameters().stream()
                        .filter(p -> paramName.equals(p.name()))
                        .findFirst()
                        .map(param -> extractQuotedValues(param.description())));
    }

    /**
     * Extracts all quoted lowercase/underscore values from a description string.
     */
    static List<String> extractQuotedValues(String description) {
        List<String> values = new ArrayList<>();
        Matcher matcher = QUOTED_VALUE.matcher(description);
        while (matcher.find()) {
            values.add(matcher.group(1));
        }
        return values;
    }
}
