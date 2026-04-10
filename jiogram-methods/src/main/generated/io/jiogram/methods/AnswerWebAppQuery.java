package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.SentWebAppMessage;
import io.jiogram.types.TelegramMethod;

public class AnswerWebAppQuery implements TelegramMethod<SentWebAppMessage> {
    @JsonProperty("web_app_query_id") private final String webAppQueryId;
    @JsonProperty("result") private final InlineQueryResult result;

    @JsonCreator
    public AnswerWebAppQuery(
            @JsonProperty("web_app_query_id") String webAppQueryId,
            @JsonProperty("result") InlineQueryResult result
    ) {
        this.webAppQueryId = webAppQueryId;
        this.result = result;
    }

    public String webAppQueryId() {
        return this.webAppQueryId;
    }

    public InlineQueryResult result() {
        return this.result;
    }

    @Override
    public String apiMethod() {
        return "answerWebAppQuery";
    }

    @Override
    public String apiReturnType() {
        return "SentWebAppMessage";
    }
}
