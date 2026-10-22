package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingOption;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * If you sent an invoice requesting a shipping address and the parameter is_flexible was specified,
 * the Bot API will send an Update with a shipping_query field to the bot. Use this method to reply
 * to shipping queries. On success, True is returned.
 *
 * @param shippingQueryId Unique identifier for the query to be answered
 * @param ok Pass True if delivery to the specified address is possible and False if there are any
 *     problems (for example, if delivery to the specified address is not possible)
 * @param shippingOptions Required if ok is True. A JSON-serialized array of available shipping
 *     options.
 * @param errorMessage Required if ok is False. Error message in human readable form that explains
 *     why it is impossible to complete the order (e.g. 'Sorry, delivery to your desired address is
 *     unavailable'). Telegram will display this message to the user.
 * @see <a href="https://core.telegram.org/bots/api#answershippingquery">answerShippingQuery in the Bot API</a>
 */
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
