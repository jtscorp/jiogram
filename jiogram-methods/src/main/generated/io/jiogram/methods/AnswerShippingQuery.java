package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingOption;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record AnswerShippingQuery(
    @JsonProperty("shipping_query_id") String shippingQueryId,
    @JsonProperty("ok") boolean ok,
    @JsonProperty("shipping_options") @Nullable List<ShippingOption> shippingOptions,
    @JsonProperty("error_message") @Nullable String errorMessage
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "answerShippingQuery";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static AnswerShippingQuery of(String shippingQueryId, boolean ok) {
        return new AnswerShippingQuery(shippingQueryId, ok, null, null);
    }
}
