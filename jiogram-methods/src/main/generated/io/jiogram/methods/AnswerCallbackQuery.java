package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record AnswerCallbackQuery(
    @JsonProperty("callback_query_id") String callbackQueryId,
    @JsonProperty("text") @Nullable String text,
    @JsonProperty("show_alert") @Nullable Boolean showAlert,
    @JsonProperty("url") @Nullable String url,
    @JsonProperty("cache_time") @Nullable Long cacheTime
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "answerCallbackQuery";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static AnswerCallbackQuery of(String callbackQueryId) {
        return new AnswerCallbackQuery(callbackQueryId, null, null, null, null);
    }
}
