package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class AnswerCallbackQuery implements TelegramMethod<Boolean> {
    @JsonProperty("callback_query_id") private final String callbackQueryId;
    @JsonProperty("text") @Nullable private final String text;
    @JsonProperty("show_alert") @Nullable private final Boolean showAlert;
    @JsonProperty("url") @Nullable private final String url;
    @JsonProperty("cache_time") @Nullable private final Long cacheTime;

    @JsonCreator
    public AnswerCallbackQuery(
            @JsonProperty("callback_query_id") String callbackQueryId,
            @JsonProperty("text") @Nullable String text,
            @JsonProperty("show_alert") @Nullable Boolean showAlert,
            @JsonProperty("url") @Nullable String url,
            @JsonProperty("cache_time") @Nullable Long cacheTime
    ) {
        this.callbackQueryId = callbackQueryId;
        this.text = text;
        this.showAlert = showAlert;
        this.url = url;
        this.cacheTime = cacheTime;
    }

    public String callbackQueryId() {
        return this.callbackQueryId;
    }

    public String text() {
        return this.text;
    }

    public Boolean showAlert() {
        return this.showAlert;
    }

    public String url() {
        return this.url;
    }

    public Long cacheTime() {
        return this.cacheTime;
    }

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
