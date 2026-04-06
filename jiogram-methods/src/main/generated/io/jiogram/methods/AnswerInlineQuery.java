package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.InlineQueryResultsButton;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record AnswerInlineQuery(
    @JsonProperty("inline_query_id") String inlineQueryId,
    @JsonProperty("results") List<InlineQueryResult> results,
    @JsonProperty("cache_time") @Nullable Long cacheTime,
    @JsonProperty("is_personal") @Nullable Boolean isPersonal,
    @JsonProperty("next_offset") @Nullable String nextOffset,
    @JsonProperty("button") @Nullable InlineQueryResultsButton button
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "answerInlineQuery";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static AnswerInlineQuery of(String inlineQueryId, List<InlineQueryResult> results) {
        return new AnswerInlineQuery(inlineQueryId, results, null, null, null, null);
    }
}
