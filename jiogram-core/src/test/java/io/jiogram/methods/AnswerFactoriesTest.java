package io.jiogram.methods;

import io.jiogram.session.WebClientTelegramSession;
import io.jiogram.types.ChatAction;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The generated {@code answer}/{@code reply} factories send back where a message came from.
 */
class AnswerFactoriesTest {

    @Test
    void answerToATopicMessage_staysInTheTopic() throws Exception {
        Message inTopic = message(
                "\"chat\": {\"id\": -1004480401943, \"type\": \"supergroup\", \"title\": \"G\", \"is_forum\": true},\n"
                + "\"message_thread_id\": 2, \"is_topic_message\": true");

        SendMessage answer = SendMessage.answer(inTopic, "hi");

        assertEquals(ChatId.of(-1004480401943L), answer.chatId());
        assertEquals(2L, answer.messageThreadId());
        assertEquals("hi", answer.text());
        assertNull(answer.replyParameters());
        assertNull(answer.businessConnectionId());
    }

    @Test
    void replyThreadOutsideAForum_isNotSentBack() throws Exception {
        // In a group without topics, message_thread_id marks a reply thread; sending it fails.
        Message replyInGroup = message("\"chat\": {\"id\": -100123, \"type\": \"supergroup\", \"title\": \"G\"}, \"message_thread_id\": 40");

        assertNull(SendPhoto.answer(replyInGroup, null).messageThreadId());
    }

    @Test
    void reply_repliesToTheMessage() throws Exception {
        Message message = message("\"chat\": {\"id\": 7, \"type\": \"private\"}");

        SendMessage reply = SendMessage.reply(message, "hi");

        assertEquals(ChatId.of(7L), reply.chatId());
        assertEquals(10L, reply.replyParameters().messageId());
    }

    @Test
    void businessAndDirectMessagesContext_isCarriedOver() throws Exception {
        Message business = message(
                "\"chat\": {\"id\": 7, \"type\": \"private\"}, \"business_connection_id\": \"bc1\",\n"
                + "\"direct_messages_topic\": {\"topic_id\": 55}");

        SendMessage answer = SendMessage.answer(business, "hi");
        SendChatAction typing = SendChatAction.answer(business, ChatAction.TYPING);

        assertEquals("bc1", answer.businessConnectionId());
        assertEquals(55L, answer.directMessagesTopicId());
        assertEquals("bc1", typing.businessConnectionId());
    }

    @Test
    void numericChatIdMethods_takeTheChatId() throws Exception {
        Message message = message("\"chat\": {\"id\": 7, \"type\": \"private\"}");

        assertEquals(7L, SendGame.answer(message, "game").chatId());
    }

    private static Message message(String fields) throws Exception {
        return WebClientTelegramSession.defaultObjectMapper().readValue(
            "{\"message_id\": 10, \"date\": 1775538971, " + fields + "}", Message.class);
    }
}
