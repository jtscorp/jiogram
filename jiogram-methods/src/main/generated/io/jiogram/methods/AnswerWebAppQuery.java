package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.SentWebAppMessage;
import io.jiogram.types.TelegramMethod;

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
