package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.InlineQueryResultsButton;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send answers to an inline query. On success, True is returned.
 * <br>No more than 50 results per query are allowed.
 *
 * @param inlineQueryId Unique identifier for the answered query
 * @param results A JSON-serialized array of results for the inline query
 * @param cacheTime The maximum amount of time in seconds that the result of the inline query may be
 *     cached on the server. Defaults to 300.
 * @param isPersonal Pass True if results may be cached on the server side only for the user that
 *     sent the query. By default, results may be returned to any user who sends the same query.
 * @param nextOffset Pass the offset that a client should send in the next query with the same text
 *     to receive more results. Pass an empty string if there are no more results or if you don't
 *     support pagination. Offset length can't exceed 64 bytes.
 * @param button A JSON-serialized object describing a button to be shown above inline query results
 * @see <a href="https://core.telegram.org/bots/api#answerinlinequery">answerInlineQuery in the Bot API</a>
 */
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
