package io.jiogram.codegen;

import io.jiogram.codegen.UnionRegistry.UnionInfo;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UnionRegistryTest {

    // ---- get() ----

    @Test
    void chatMember_hasCorrectDiscriminator() {
        UnionInfo info = UnionRegistry.get("ChatMember");
        assertNotNull(info);
        assertEquals("status", info.discriminator());
    }

    @Test
    void chatMember_hasAllSubtypes() {
        UnionInfo info = UnionRegistry.get("ChatMember");
        assertNotNull(info);
        assertEquals(6, info.subtypes().size());
        assertEquals("ChatMemberOwner", info.subtypes().get("creator"));
        assertEquals("ChatMemberAdministrator", info.subtypes().get("administrator"));
        assertEquals("ChatMemberMember", info.subtypes().get("member"));
        assertEquals("ChatMemberRestricted", info.subtypes().get("restricted"));
        assertEquals("ChatMemberLeft", info.subtypes().get("left"));
        assertEquals("ChatMemberBanned", info.subtypes().get("kicked"));
    }

    @Test
    void messageOrigin_hasCorrectDiscriminatorAndSubtypes() {
        UnionInfo info = UnionRegistry.get("MessageOrigin");
        assertNotNull(info);
        assertEquals("type", info.discriminator());
        assertEquals(4, info.subtypes().size());
        assertEquals("MessageOriginUser", info.subtypes().get("user"));
        assertEquals("MessageOriginHiddenUser", info.subtypes().get("hidden_user"));
    }

    @Test
    void unknownType_returnsNull() {
        assertNull(UnionRegistry.get("User"));
        assertNull(UnionRegistry.get("Message"));
        assertNull(UnionRegistry.get("NonExistentType"));
    }

    // ---- isDiscriminatedUnion() ----

    @Test
    void chatMember_isDiscriminatedUnion() {
        assertTrue(UnionRegistry.isDiscriminatedUnion("ChatMember"));
    }

    @Test
    void messageOrigin_isDiscriminatedUnion() {
        assertTrue(UnionRegistry.isDiscriminatedUnion("MessageOrigin"));
    }

    @Test
    void user_isNotDiscriminatedUnion() {
        assertFalse(UnionRegistry.isDiscriminatedUnion("User"));
    }

    @Test
    void message_isNotDiscriminatedUnion() {
        assertFalse(UnionRegistry.isDiscriminatedUnion("Message"));
    }

    // ---- isSubtype() ----

    @Test
    void chatMemberOwner_isSubtype() {
        assertTrue(UnionRegistry.isSubtype("ChatMemberOwner"));
    }

    @Test
    void messageOriginUser_isSubtype() {
        assertTrue(UnionRegistry.isSubtype("MessageOriginUser"));
    }

    @Test
    void chatMember_isNotSubtype() {
        // Parent types are not themselves subtypes
        assertFalse(UnionRegistry.isSubtype("ChatMember"));
    }

    @Test
    void user_isNotSubtype() {
        assertFalse(UnionRegistry.isSubtype("User"));
    }

    // ---- parentOf() ----

    @Test
    void chatMemberOwner_parentIsChatMember() {
        assertEquals("ChatMember", UnionRegistry.parentOf("ChatMemberOwner"));
    }

    @Test
    void chatMemberBanned_parentIsChatMember() {
        assertEquals("ChatMember", UnionRegistry.parentOf("ChatMemberBanned"));
    }

    @Test
    void messageOriginChannel_parentIsMessageOrigin() {
        assertEquals("MessageOrigin", UnionRegistry.parentOf("MessageOriginChannel"));
    }

    @Test
    void user_parentIsNull() {
        assertNull(UnionRegistry.parentOf("User"));
    }

    @Test
    void chatMember_parentIsNull() {
        // Parent types don't have a parent themselves
        assertNull(UnionRegistry.parentOf("ChatMember"));
    }

    // ---- all() ----

    @Test
    void all_returns21Unions() {
        Map<String, UnionInfo> allUnions = UnionRegistry.all();
        assertEquals(21, allUnions.size());
    }

    @Test
    void all_isUnmodifiable() {
        Map<String, UnionInfo> allUnions = UnionRegistry.all();
        assertThrows(UnsupportedOperationException.class, () ->
                allUnions.put("Fake", new UnionInfo("x", Map.of())));
    }

    @Test
    void subtypes_mapIsUnmodifiable() {
        UnionInfo info = UnionRegistry.get("ChatMember");
        assertNotNull(info);
        assertThrows(UnsupportedOperationException.class, () ->
                info.subtypes().put("fake", "FakeType"));
    }

    // ---- Specific unions spot checks ----

    @Test
    void chatBoostSource_usesSourceDiscriminator() {
        UnionInfo info = UnionRegistry.get("ChatBoostSource");
        assertNotNull(info);
        assertEquals("source", info.discriminator());
        assertEquals("ChatBoostSourcePremium", info.subtypes().get("premium"));
    }

    @Test
    void passportElementError_usesSourceDiscriminator() {
        UnionInfo info = UnionRegistry.get("PassportElementError");
        assertNotNull(info);
        assertEquals("source", info.discriminator());
        assertEquals(9, info.subtypes().size());
    }

    @Test
    void inlineQueryResult_hasAllSubtypes() {
        UnionInfo info = UnionRegistry.get("InlineQueryResult");
        assertNotNull(info);
        assertEquals("type", info.discriminator());
        // 12 regular + 7 cached + 1 sticker = 20 subtypes
        assertEquals(20, info.subtypes().size());
        assertEquals("InlineQueryResultArticle", info.subtypes().get("article"));
        assertEquals("InlineQueryResultCachedSticker", info.subtypes().get("sticker"));
        assertEquals("InlineQueryResultCachedPhoto", info.subtypes().get("cached_photo"));
    }

    @Test
    void wireName_mapsCachedInlineResultsToTelegramsTypeValue() {
        assertEquals("photo", UnionRegistry.wireName("InlineQueryResult", "cached_photo"));
        assertEquals("mpeg4_gif", UnionRegistry.wireName("InlineQueryResult", "cached_mpeg4_gif"));
        assertEquals("photo", UnionRegistry.wireName("InlineQueryResult", "photo"));
        assertEquals("cached_x", UnionRegistry.wireName("ChatMember", "cached_x"), "Only InlineQueryResult is remapped");
    }

    @Test
    void transactionPartner_hasAllSubtypes() {
        UnionInfo info = UnionRegistry.get("TransactionPartner");
        assertNotNull(info);
        assertEquals(7, info.subtypes().size());
        assertEquals("TransactionPartnerUser", info.subtypes().get("user"));
        assertEquals("TransactionPartnerOther", info.subtypes().get("other"));
    }

    @Test
    void storyAreaType_hasAllSubtypes() {
        UnionInfo info = UnionRegistry.get("StoryAreaType");
        assertNotNull(info);
        assertEquals(5, info.subtypes().size());
        assertEquals("StoryAreaTypeLocation", info.subtypes().get("location"));
        assertEquals("StoryAreaTypeUniqueGift", info.subtypes().get("unique_gift"));
    }

    @Test
    void maybeInaccessibleMessage_usesDateDiscriminator() {
        UnionInfo info = UnionRegistry.get("MaybeInaccessibleMessage");
        assertNotNull(info);
        assertEquals("date", info.discriminator());
        assertEquals("InaccessibleMessage", info.subtypes().get("0"));
        assertEquals("Message", info.subtypes().get("nonzero"));
    }

    @Test
    void inputMessageContent_hasEmptySubtypes() {
        UnionInfo info = UnionRegistry.get("InputMessageContent");
        assertNotNull(info);
        assertEquals("type", info.discriminator());
        assertTrue(info.subtypes().isEmpty());
    }

    @Test
    void ownedGift_hasCorrectSubtypes() {
        UnionInfo info = UnionRegistry.get("OwnedGift");
        assertNotNull(info);
        assertEquals("type", info.discriminator());
        assertEquals(2, info.subtypes().size());
        assertEquals("OwnedGiftRegular", info.subtypes().get("regular"));
        assertEquals("OwnedGiftUnique", info.subtypes().get("unique"));
    }
}
