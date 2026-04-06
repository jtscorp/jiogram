package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record AnswerPreCheckoutQuery(
    @JsonProperty("pre_checkout_query_id") String preCheckoutQueryId,
    @JsonProperty("ok") boolean ok,
    @JsonProperty("error_message") @Nullable String errorMessage
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "answerPreCheckoutQuery";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static AnswerPreCheckoutQuery of(String preCheckoutQueryId, boolean ok) {
        return new AnswerPreCheckoutQuery(preCheckoutQueryId, ok, null);
    }
}
