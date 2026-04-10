package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingOption;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class AnswerShippingQuery implements TelegramMethod<Boolean> {
    @JsonProperty("shipping_query_id") private final String shippingQueryId;
    @JsonProperty("ok") private final boolean ok;
    @JsonProperty("shipping_options") @Nullable private final List<ShippingOption> shippingOptions;
    @JsonProperty("error_message") @Nullable private final String errorMessage;

    @JsonCreator
    public AnswerShippingQuery(
            @JsonProperty("shipping_query_id") String shippingQueryId,
            @JsonProperty("ok") boolean ok,
            @JsonProperty("shipping_options") @Nullable List<ShippingOption> shippingOptions,
            @JsonProperty("error_message") @Nullable String errorMessage
    ) {
        this.shippingQueryId = shippingQueryId;
        this.ok = ok;
        this.shippingOptions = shippingOptions;
        this.errorMessage = errorMessage;
    }

    public String shippingQueryId() {
        return this.shippingQueryId;
    }

    public boolean ok() {
        return this.ok;
    }

    public List<ShippingOption> shippingOptions() {
        return this.shippingOptions;
    }

    public String errorMessage() {
        return this.errorMessage;
    }

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
