package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.InlineQueryResultsButton;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class AnswerInlineQuery implements TelegramMethod<Boolean> {
    @JsonProperty("inline_query_id") private final String inlineQueryId;
    @JsonProperty("results") private final List<InlineQueryResult> results;
    @JsonProperty("cache_time") @Nullable private final Long cacheTime;
    @JsonProperty("is_personal") @Nullable private final Boolean isPersonal;
    @JsonProperty("next_offset") @Nullable private final String nextOffset;
    @JsonProperty("button") @Nullable private final InlineQueryResultsButton button;

    @JsonCreator
    public AnswerInlineQuery(
            @JsonProperty("inline_query_id") String inlineQueryId,
            @JsonProperty("results") List<InlineQueryResult> results,
            @JsonProperty("cache_time") @Nullable Long cacheTime,
            @JsonProperty("is_personal") @Nullable Boolean isPersonal,
            @JsonProperty("next_offset") @Nullable String nextOffset,
            @JsonProperty("button") @Nullable InlineQueryResultsButton button
    ) {
        this.inlineQueryId = inlineQueryId;
        this.results = results;
        this.cacheTime = cacheTime;
        this.isPersonal = isPersonal;
        this.nextOffset = nextOffset;
        this.button = button;
    }

    public String inlineQueryId() {
        return this.inlineQueryId;
    }

    public List<InlineQueryResult> results() {
        return this.results;
    }

    public Long cacheTime() {
        return this.cacheTime;
    }

    public Boolean isPersonal() {
        return this.isPersonal;
    }

    public String nextOffset() {
        return this.nextOffset;
    }

    public InlineQueryResultsButton button() {
        return this.button;
    }

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
