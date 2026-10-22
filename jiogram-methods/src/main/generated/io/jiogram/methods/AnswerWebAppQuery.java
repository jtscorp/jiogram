package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.SentWebAppMessage;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to set the result of an interaction with a Web App and send a corresponding
 * message on behalf of the user to the chat from which the query originated. On success, a
 * SentWebAppMessage object is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#answerwebappquery">answerWebAppQuery in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class AnswerWebAppQuery implements TelegramMethod<SentWebAppMessage> {

    @JsonProperty("web_app_query_id")
    private final String webAppQueryId;

    @JsonProperty("result")
    private final InlineQueryResult result;

    /**
     * Creates a new {@code AnswerWebAppQuery} instance.
     *
     * @param webAppQueryId Unique identifier for the query to be answered
     * @param result A JSON-serialized object describing the message to be sent
     */
    @JsonCreator
    public AnswerWebAppQuery(
            @JsonProperty("web_app_query_id") String webAppQueryId,
            @JsonProperty("result") InlineQueryResult result) {
        this.webAppQueryId = webAppQueryId;
        this.result = result;
    }

    @Override
    public String apiMethod() {
        return "answerWebAppQuery";
    }

    @Override
    public String apiReturnType() {
        return "SentWebAppMessage";
    }

    /**
     * Unique identifier for the query to be answered
     */
    public String webAppQueryId() {
        return webAppQueryId;
    }

    /**
     * A JSON-serialized object describing the message to be sent
     */
    public InlineQueryResult result() {
        return result;
    }

    public AnswerWebAppQuery withWebAppQueryId(String webAppQueryId) {
        return new AnswerWebAppQuery(webAppQueryId, result);
    }

    public AnswerWebAppQuery withResult(InlineQueryResult result) {
        return new AnswerWebAppQuery(webAppQueryId, result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnswerWebAppQuery)) {
            return false;
        }
        AnswerWebAppQuery that = (AnswerWebAppQuery) o;
        return Objects.equals(this.webAppQueryId, that.webAppQueryId)
                && Objects.equals(this.result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.webAppQueryId, this.result);
    }

    @Override
    public String toString() {
        return "AnswerWebAppQuery[webAppQueryId=" + this.webAppQueryId
                + ", result=" + this.result
                + "]";
    }
}
