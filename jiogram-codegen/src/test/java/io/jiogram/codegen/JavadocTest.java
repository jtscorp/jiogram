package io.jiogram.codegen;

import io.jiogram.codegen.model.FieldDefinition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavadocTest {

    @Test
    void rendersDescriptionParametersAndLink() {
        String comment = Javadoc.render("Use this method to send text messages.\nOn success, the sent Message is returned.",
                List.of(new FieldDefinition("chat_id", "Integer or String", true, "Unique identifier for the target chat"),
                        new FieldDefinition("text", "String", true, "")),
                "sendMessage");

        assertEquals("""
                /**
                 * Use this method to send text messages.
                 * <br>On success, the sent Message is returned.
                 *
                 * @param chatId Unique identifier for the target chat
                 * @see <a href="https://core.telegram.org/bots/api#sendmessage">sendMessage in the Bot API</a>
                 */
                """, comment);
    }

    @Test
    void schemaTextCannotBreakTheCommentOrTheSource() {
        String comment = Javadoc.render("Mention @username, use <b>bold</b> & end */ or write \\u0041.", List.of(), null);

        assertFalse(comment.substring(3, comment.length() - 4).contains("*/"), comment);
        assertFalse(comment.contains("\\"), comment);
        assertFalse(comment.contains("@username"), comment);
        assertTrue(comment.contains("&lt;b&gt;bold&lt;/b&gt; &amp;"), comment);
    }

    @Test
    void longTextIsWrapped_andParameterContinuationLinesAreIndented() {
        String longText = "word ".repeat(60).strip();

        String comment = Javadoc.render(longText,
                List.of(new FieldDefinition("reply_markup", "String", false, longText)), null);

        for (String line : comment.split("\n")) {
            assertTrue(line.length() <= 100, line);
        }
        assertTrue(comment.contains(" * @param replyMarkup word word"), comment);
        assertTrue(comment.contains("\n *     word word"), comment);
    }

    @Test
    void constructorComment_isIndentedAndDocumentsParameters() {
        String comment = Javadoc.constructor("SendMessage",
                List.of(new FieldDefinition("chat_id", "Integer or String", true, "Unique identifier\nfor the chat"),
                        new FieldDefinition("text", "String", true, "")));

        assertEquals("""
                    /**
                     * Creates a new {@code SendMessage} instance.
                     *
                     * @param chatId Unique identifier for the chat
                     */
                """, comment);
    }

    @Test
    void memberComment_isIndentedWrappedAndEmptyWithoutDescription() {
        String longText = "word ".repeat(60).strip();

        String comment = Javadoc.member(longText);

        for (String line : comment.split("\n")) {
            assertTrue(line.length() <= 100, line);
            assertTrue(line.startsWith("    "), line);
        }
        assertTrue(comment.startsWith("    /**\n     * word word"), comment);
        assertEquals("", Javadoc.member(""));
        assertEquals("", Javadoc.member(null));
    }
}
