package io.jiogram.codegen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for return type extraction from method descriptions.
 */
class ReturnTypeExtractionTest {

    @Test
    void returnsArrayOfX_objects() {
        assertEquals("Array of Update",
                SchemaParser.extractReturnType("Returns an Array of Update objects."));
    }

    @Test
    void onSuccess_sentMessage_returned() {
        assertEquals("Message",
                SchemaParser.extractReturnType("On success, the sent Message is returned."));
    }

    @Test
    void inFormOf_aUserObject() {
        assertEquals("User",
                SchemaParser.extractReturnType("Returns basic information about the bot in form of a User object."));
    }

    @Test
    void returnsTrueOnSuccess() {
        assertEquals("Boolean",
                SchemaParser.extractReturnType("Returns True on success."));
    }

    @Test
    void onSuccess_aMessage_thatWasSent_returned() {
        assertEquals("Message",
                SchemaParser.extractReturnType("On success, a Message that was sent is returned."));
    }

    @Test
    void onSuccess_returnsA_WebhookInfoObject() {
        assertEquals("WebhookInfo",
                SchemaParser.extractReturnType("On success, returns a WebhookInfo object."));
    }

    @Test
    void returnsX_onSuccess() {
        assertEquals("BotDescription",
                SchemaParser.extractReturnType("Returns BotDescription on success."));
    }

    @Test
    void asA_ForumTopicObject() {
        assertEquals("ForumTopic",
                SchemaParser.extractReturnType("Returns information about the created topic as a ForumTopic object."));
    }

    @Test
    void onSuccess_editedMessage_returned() {
        assertEquals("Message",
                SchemaParser.extractReturnType("On success, the edited Message is returned."));
    }

    @Test
    void onSuccess_ifNotInline_editedMessageReturned_otherwiseTrue() {
        assertEquals("Message",
                SchemaParser.extractReturnType(
                        "On success, if the edited message is not an inline message, the edited Message is returned, otherwise True is returned."));
    }

    @Test
    void returnsTheCreatedInviteLinkAs() {
        assertEquals("String",
                SchemaParser.extractReturnType("Returns the created invoice link as String on success."));
    }

    @Test
    void onSuccess_arrayOfMessageId_returned() {
        // "On success, an array of MessageId of the sent messages is returned"
        assertEquals("Array of MessageId",
                SchemaParser.extractReturnType("On success, an array of MessageId of the sent messages is returned."));
    }

    @Test
    void returnsTheUploadedFile() {
        assertEquals("File",
                SchemaParser.extractReturnType("Returns the uploaded File on success."));
    }

    @Test
    void returnsFileObject() {
        assertEquals("File",
                SchemaParser.extractReturnType("On success, a File object is returned. The file can then be downloaded."));
    }

    @Test
    void returnsStoppedPoll() {
        assertEquals("Poll",
                SchemaParser.extractReturnType("On success, the stopped Poll is returned."));
    }

    @Test
    void returnsMessageId() {
        assertEquals("MessageId",
                SchemaParser.extractReturnType("Returns the MessageId of the sent message on success."));
    }

    @Test
    void returnsUserProfilePhotos() {
        assertEquals("UserProfilePhotos",
                SchemaParser.extractReturnType(
                        "Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object."));
    }

    @Test
    void returnsGiftsObject() {
        // "Returns a Gifts object"
        assertEquals("Gifts",
                SchemaParser.extractReturnType("Returns a Gifts object."));
    }

    @Test
    void returnsListOfGifts() {
        // "Returns the list of gifts that can be sent by the bot to users and channel chats."
        assertEquals("Gifts",
                SchemaParser.extractReturnType("Returns the list of gifts that can be sent by the bot to users and channel chats. Returns a Gifts object."));
    }
}
