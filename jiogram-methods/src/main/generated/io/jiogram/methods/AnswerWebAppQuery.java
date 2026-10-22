package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.SentWebAppMessage;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to set the result of an interaction with a Web App and send a corresponding
 * message on behalf of the user to the chat from which the query originated. On success, a
 * SentWebAppMessage object is returned.
 *
 * @param webAppQueryId Unique identifier for the query to be answered
 * @param result A JSON-serialized object describing the message to be sent
 * @see <a href="https://core.telegram.org/bots/api#answerwebappquery">answerWebAppQuery in the Bot API</a>
 */
public record AnswerWebAppQuery(
    @JsonProperty("web_app_query_id") String webAppQueryId,
    @JsonProperty("result") InlineQueryResult result
) implements TelegramMethod<SentWebAppMessage> {

    @Override
    public String apiMethod() {
        return "answerWebAppQuery";
    }

    @Override
    public String apiReturnType() {
        return "SentWebAppMessage";
    }
}
