package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Once the user has confirmed their payment and shipping details, the Bot API sends the final
 * confirmation in the form of an Update with the field pre_checkout_query. Use this method to
 * respond to such pre-checkout queries. On success, True is returned. Note: The Bot API must
 * receive an answer within 10 seconds after the pre-checkout query was sent.
 *
 * @param preCheckoutQueryId Unique identifier for the query to be answered
 * @param ok Specify True if everything is alright (goods are available, etc.) and the bot is ready
 *     to proceed with the order. Use False if there are any problems.
 * @param errorMessage Required if ok is False. Error message in human readable form that explains
 *     the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the
 *     last of our amazing black T-shirts while you were busy filling out your payment details.
 *     Please choose a different color or garment!"). Telegram will display this message to the
 *     user.
 * @see <a href="https://core.telegram.org/bots/api#answerprecheckoutquery">answerPreCheckoutQuery in the Bot API</a>
 */
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
