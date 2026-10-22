package io.jiogram.codegen;

import io.jiogram.codegen.model.ApiSchema;
import io.jiogram.codegen.model.TypeDefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Static registry of all discriminated union types in the Telegram Bot API.
 * <p>
 * Each union is identified by a parent type name and contains:
 * <ul>
 *   <li>A discriminator field name (e.g. "type", "status", "source")</li>
 *   <li>A mapping from discriminator values to concrete subtype names</li>
 * </ul>
 * <p>
 * Derived from aiogram's butcher subtype definitions and the official
 * Telegram Bot API schema.
 */
public final class UnionRegistry {

    /**
     * Describes a discriminated union: the discriminator field and the mapping
     * from discriminator values to subtype names.
     */
    public record UnionInfo(String discriminator, Map<String, String> subtypes) {

        public UnionInfo(String discriminator, Map<String, String> subtypes) {
            this.discriminator = discriminator;
            this.subtypes = Collections.unmodifiableMap(new LinkedHashMap<>(subtypes));
        }
    }

    private static final String CACHED_KEY_PREFIX = "cached_";

    /** A subtype line of a union's description, e.g. {@code " - ChatMemberOwner"}. */
    private static final Pattern SUBTYPE_LINE = Pattern.compile("(?m)^\\s*-\\s+(\\w+)\\s*$");

    private static final Map<String, UnionInfo> UNIONS = new LinkedHashMap<>();
    private static final Map<String, String> SUBTYPE_TO_PARENT = new HashMap<>();

    static {
        // 1. ChatMember — discriminator: "status"
        register("ChatMember", "status", Map.of(
                "creator", "ChatMemberOwner",
                "administrator", "ChatMemberAdministrator",
                "member", "ChatMemberMember",
                "restricted", "ChatMemberRestricted",
                "left", "ChatMemberLeft",
                "kicked", "ChatMemberBanned"
        ));

        // 2. MessageOrigin — discriminator: "type"
        register("MessageOrigin", "type", Map.of(
                "user", "MessageOriginUser",
                "hidden_user", "MessageOriginHiddenUser",
                "chat", "MessageOriginChat",
                "channel", "MessageOriginChannel"
        ));

        // 3. MenuButton — discriminator: "type"
        register("MenuButton", "type", Map.of(
                "commands", "MenuButtonCommands",
                "web_app", "MenuButtonWebApp",
                "default", "MenuButtonDefault"
        ));

        // 4. BotCommandScope — discriminator: "type"
        register("BotCommandScope", "type", Map.of(
                "default", "BotCommandScopeDefault",
                "all_private_chats", "BotCommandScopeAllPrivateChats",
                "all_group_chats", "BotCommandScopeAllGroupChats",
                "all_chat_administrators", "BotCommandScopeAllChatAdministrators",
                "chat", "BotCommandScopeChat",
                "chat_administrators", "BotCommandScopeChatAdministrators",
                "chat_member", "BotCommandScopeChatMember"
        ));

        // 5. ReactionType — discriminator: "type"
        register("ReactionType", "type", Map.of(
                "emoji", "ReactionTypeEmoji",
                "custom_emoji", "ReactionTypeCustomEmoji",
                "paid", "ReactionTypePaid"
        ));

        // 6. ChatBoostSource — discriminator: "source"
        register("ChatBoostSource", "source", Map.of(
                "premium", "ChatBoostSourcePremium",
                "gift_code", "ChatBoostSourceGiftCode",
                "giveaway", "ChatBoostSourceGiveaway"
        ));

        // 7. BackgroundFill — discriminator: "type"
        register("BackgroundFill", "type", Map.of(
                "solid", "BackgroundFillSolid",
                "gradient", "BackgroundFillGradient",
                "freeform_gradient", "BackgroundFillFreeformGradient"
        ));

        // 8. BackgroundType — discriminator: "type"
        register("BackgroundType", "type", Map.of(
                "fill", "BackgroundTypeFill",
                "wallpaper", "BackgroundTypeWallpaper",
                "pattern", "BackgroundTypePattern",
                "chat_theme", "BackgroundTypeChatTheme"
        ));

        // 9. InputMedia — discriminator: "type"
        register("InputMedia", "type", Map.of(
                "photo", "InputMediaPhoto",
                "video", "InputMediaVideo",
                "animation", "InputMediaAnimation",
                "audio", "InputMediaAudio",
                "document", "InputMediaDocument"
        ));

        // 10. InputPaidMedia — discriminator: "type"
        register("InputPaidMedia", "type", Map.of(
                "photo", "InputPaidMediaPhoto",
                "video", "InputPaidMediaVideo"
        ));

        // 11. InlineQueryResult — discriminator: "type"
        // Note: Some discriminator values (photo, gif, etc.) map to multiple subtypes
        // (regular and cached variants). Cached variants are keyed "cached_<type>" to keep
        // the keys unique; wireName() maps them back to the value sent to Telegram.
        Map<String, String> inlineQueryResultSubtypes = new LinkedHashMap<>();
        inlineQueryResultSubtypes.put("article", "InlineQueryResultArticle");
        inlineQueryResultSubtypes.put("photo", "InlineQueryResultPhoto");
        inlineQueryResultSubtypes.put("gif", "InlineQueryResultGif");
        inlineQueryResultSubtypes.put("mpeg4_gif", "InlineQueryResultMpeg4Gif");
        inlineQueryResultSubtypes.put("video", "InlineQueryResultVideo");
        inlineQueryResultSubtypes.put("audio", "InlineQueryResultAudio");
        inlineQueryResultSubtypes.put("voice", "InlineQueryResultVoice");
        inlineQueryResultSubtypes.put("document", "InlineQueryResultDocument");
        inlineQueryResultSubtypes.put("location", "InlineQueryResultLocation");
        inlineQueryResultSubtypes.put("venue", "InlineQueryResultVenue");
        inlineQueryResultSubtypes.put("contact", "InlineQueryResultContact");
        inlineQueryResultSubtypes.put("game", "InlineQueryResultGame");
        inlineQueryResultSubtypes.put("sticker", "InlineQueryResultCachedSticker");
        // Cached variants keyed with "cached_" prefix to avoid key collisions (see wireName)
        inlineQueryResultSubtypes.put("cached_photo", "InlineQueryResultCachedPhoto");
        inlineQueryResultSubtypes.put("cached_gif", "InlineQueryResultCachedGif");
        inlineQueryResultSubtypes.put("cached_mpeg4_gif", "InlineQueryResultCachedMpeg4Gif");
        inlineQueryResultSubtypes.put("cached_video", "InlineQueryResultCachedVideo");
        inlineQueryResultSubtypes.put("cached_audio", "InlineQueryResultCachedAudio");
        inlineQueryResultSubtypes.put("cached_voice", "InlineQueryResultCachedVoice");
        inlineQueryResultSubtypes.put("cached_document", "InlineQueryResultCachedDocument");
        register("InlineQueryResult", "type", inlineQueryResultSubtypes);

        // 12. PassportElementError — discriminator: "source"
        register("PassportElementError", "source", Map.of(
                "data", "PassportElementErrorDataField",
                "front_side", "PassportElementErrorFrontSide",
                "reverse_side", "PassportElementErrorReverseSide",
                "selfie", "PassportElementErrorSelfie",
                "file", "PassportElementErrorFile",
                "files", "PassportElementErrorFiles",
                "translation_file", "PassportElementErrorTranslationFile",
                "translation_files", "PassportElementErrorTranslationFiles",
                "unspecified", "PassportElementErrorUnspecified"
        ));

        // 13. TransactionPartner — discriminator: "type"
        register("TransactionPartner", "type", Map.of(
                "user", "TransactionPartnerUser",
                "chat", "TransactionPartnerChat",
                "affiliate_program", "TransactionPartnerAffiliateProgram",
                "fragment", "TransactionPartnerFragment",
                "telegram_ads", "TransactionPartnerTelegramAds",
                "telegram_api", "TransactionPartnerTelegramApi",
                "other", "TransactionPartnerOther"
        ));

        // 14. RevenueWithdrawalState — discriminator: "type"
        register("RevenueWithdrawalState", "type", Map.of(
                "pending", "RevenueWithdrawalStatePending",
                "succeeded", "RevenueWithdrawalStateSucceeded",
                "failed", "RevenueWithdrawalStateFailed"
        ));

        // 15. PaidMedia — discriminator: "type"
        register("PaidMedia", "type", Map.of(
                "preview", "PaidMediaPreview",
                "photo", "PaidMediaPhoto",
                "video", "PaidMediaVideo"
        ));

        // 16. OwnedGift — discriminator: "type"
        register("OwnedGift", "type", Map.of(
                "regular", "OwnedGiftRegular",
                "unique", "OwnedGiftUnique"
        ));

        // 17. InputProfilePhoto — discriminator: "type"
        register("InputProfilePhoto", "type", Map.of(
                "static", "InputProfilePhotoStatic",
                "animated", "InputProfilePhotoAnimated"
        ));

        // 18. InputStoryContent — discriminator: "type"
        register("InputStoryContent", "type", Map.of(
                "photo", "InputStoryContentPhoto",
                "video", "InputStoryContentVideo"
        ));

        // 19. StoryAreaType — discriminator: "type"
        register("StoryAreaType", "type", Map.of(
                "location", "StoryAreaTypeLocation",
                "suggested_reaction", "StoryAreaTypeSuggestedReaction",
                "link", "StoryAreaTypeLink",
                "weather", "StoryAreaTypeWeather",
                "unique_gift", "StoryAreaTypeUniqueGift"
        ));

        // 20. MaybeInaccessibleMessage — discriminator: "date"
        // Special case: date=0 means InaccessibleMessage, nonzero means Message
        register("MaybeInaccessibleMessage", "date", Map.of(
                "0", "InaccessibleMessage",
                "nonzero", "Message"
        ));

        // 21. InputMessageContent — empty subtypes (special case)
        register("InputMessageContent", "type", Map.of());
    }

    private UnionRegistry() {
    }

    /**
     * Returns the {@link UnionInfo} for the given parent type name, or {@code null}
     * if the type is not a registered discriminated union.
     *
     * @param typeName the parent type name (e.g. "ChatMember")
     * @return the union info, or null
     */
    public static UnionInfo get(String typeName) {
        return UNIONS.get(typeName);
    }

    /**
     * Returns true if the given type name is a registered discriminated union parent.
     *
     * @param typeName the type name to check
     * @return true if it is a union parent
     */
    public static boolean isDiscriminatedUnion(String typeName) {
        return UNIONS.containsKey(typeName);
    }

    /**
     * Returns true if the given type name is a registered subtype of any union.
     *
     * @param typeName the type name to check
     * @return true if it is a union subtype
     */
    public static boolean isSubtype(String typeName) {
        return SUBTYPE_TO_PARENT.containsKey(typeName);
    }

    /**
     * Returns the parent union type name for the given subtype, or {@code null}
     * if the type is not a registered subtype.
     *
     * @param typeName the subtype name (e.g. "ChatMemberOwner")
     * @return the parent type name (e.g. "ChatMember"), or null
     */
    public static String parentOf(String typeName) {
        return SUBTYPE_TO_PARENT.get(typeName);
    }

    /**
     * Returns an unmodifiable view of all registered unions.
     *
     * @return map from parent type name to {@link UnionInfo}
     */
    public static Map<String, UnionInfo> all() {
        return Collections.unmodifiableMap(UNIONS);
    }

    /**
     * Returns the discriminator value Telegram uses on the wire for a registry key. They differ
     * only for InlineQueryResult: a result and its cached variant share one {@code type} (e.g.
     * {@code "photo"} for both InlineQueryResultPhoto and InlineQueryResultCachedPhoto), so the
     * cached variants are keyed {@code "cached_<type>"} here to keep the keys unique.
     *
     * @param parentType the union parent type name
     * @param key        a key of that union's {@link UnionInfo#subtypes()}
     * @return the value of the discriminator field in JSON
     */
    public static String wireName(String parentType, String key) {
        if ("InlineQueryResult".equals(parentType) && key.startsWith(CACHED_KEY_PREFIX)) {
            return key.substring(CACHED_KEY_PREFIX.length());
        }
        return key;
    }

    /**
     * Compares the registry with the unions the schema declares. The schema describes a union as
     * a type without fields whose description lists its subtypes, one {@code " - SubtypeName"}
     * line each; the discriminator values are not machine-readable there, which is why this
     * registry exists. Unions registered without subtypes (InputMessageContent, resolved by its
     * fields) are not compared.
     *
     * @return one message per difference; empty when the registry matches the schema
     */
    public static List<String> differencesFrom(ApiSchema schema) {
        Set<String> typeNames = schema.types().stream().map(TypeDefinition::name).collect(Collectors.toSet());
        Map<String, Set<String>> schemaUnions = new TreeMap<>();
        for (TypeDefinition type : schema.types()) {
            if (!type.fields().isEmpty() || type.description() == null) {
                continue;
            }
            Set<String> subtypes = SUBTYPE_LINE.matcher(type.description()).results()
                    .map(match -> match.group(1))
                    .filter(typeNames::contains)
                    .collect(Collectors.toCollection(TreeSet::new));
            if (!subtypes.isEmpty()) {
                schemaUnions.put(type.name(), subtypes);
            }
        }

        List<String> differences = new ArrayList<>();
        schemaUnions.forEach((parent, schemaSubtypes) -> {
            UnionInfo info = UNIONS.get(parent);
            if (info == null) {
                differences.add(parent + " is a union in the schema but not registered; subtypes: " + schemaSubtypes);
                return;
            }
            if (info.subtypes().isEmpty()) {
                return;
            }
            Set<String> registered = new TreeSet<>(info.subtypes().values());
            Set<String> missing = new TreeSet<>(schemaSubtypes);
            missing.removeAll(registered);
            Set<String> extra = new TreeSet<>(registered);
            extra.removeAll(schemaSubtypes);
            if (!missing.isEmpty()) {
                differences.add(parent + ": subtypes missing from the registry: " + missing);
            }
            if (!extra.isEmpty()) {
                differences.add(parent + ": registered subtypes the schema does not list: " + extra);
            }
        });
        UNIONS.keySet().stream()
                .filter(parent -> !schemaUnions.containsKey(parent))
                .sorted()
                .forEach(parent -> differences.add(parent + " is registered but is not a union in the schema"));
        return differences;
    }

    private static void register(String parentType, String discriminator, Map<String, String> subtypes) {
        UNIONS.put(parentType, new UnionInfo(discriminator, subtypes));
        for (String subtype : subtypes.values()) {
            SUBTYPE_TO_PARENT.put(subtype, parentType);
        }
    }
}
