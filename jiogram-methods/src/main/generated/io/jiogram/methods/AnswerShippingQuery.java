package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ShippingOption;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * If you sent an invoice requesting a shipping address and the parameter is_flexible was specified,
 * the Bot API will send an Update with a shipping_query field to the bot. Use this method to reply
 * to shipping queries. On success, True is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#answershippingquery">answerShippingQuery in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class AnswerShippingQuery implements TelegramMethod<Boolean> {

    @JsonProperty("shipping_query_id")
    private final String shippingQueryId;

    @JsonProperty("ok")
    private final boolean ok;

    @JsonProperty("shipping_options")
    private final @Nullable List<ShippingOption> shippingOptions;

    @JsonProperty("error_message")
    private final @Nullable String errorMessage;

    /**
     * Creates a new {@code AnswerShippingQuery} instance.
     *
     * @param shippingQueryId Unique identifier for the query to be answered
     * @param ok Pass True if delivery to the specified address is possible and False if there are
     *     any problems (for example, if delivery to the specified address is not possible)
     * @param shippingOptions Required if ok is True. A JSON-serialized array of available shipping
     *     options.
     * @param errorMessage Required if ok is False. Error message in human readable form that
     *     explains why it is impossible to complete the order (e.g. 'Sorry, delivery to your
     *     desired address is unavailable'). Telegram will display this message to the user.
     */
    @JsonCreator
    public AnswerShippingQuery(
            @JsonProperty("shipping_query_id") String shippingQueryId,
            @JsonProperty("ok") boolean ok,
            @JsonProperty("shipping_options") @Nullable List<ShippingOption> shippingOptions,
            @JsonProperty("error_message") @Nullable String errorMessage) {
        this.shippingQueryId = shippingQueryId;
        this.ok = ok;
        this.shippingOptions = shippingOptions;
        this.errorMessage = errorMessage;
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

    /**
     * Unique identifier for the query to be answered
     */
    public String shippingQueryId() {
        return shippingQueryId;
    }

    /**
     * Pass True if delivery to the specified address is possible and False if there are any
     * problems (for example, if delivery to the specified address is not possible)
     */
    public boolean ok() {
        return ok;
    }

    /**
     * Required if ok is True. A JSON-serialized array of available shipping options.
     */
    public @Nullable List<ShippingOption> shippingOptions() {
        return shippingOptions;
    }

    /**
     * Required if ok is False. Error message in human readable form that explains why it is
     * impossible to complete the order (e.g. 'Sorry, delivery to your desired address is
     * unavailable'). Telegram will display this message to the user.
     */
    public @Nullable String errorMessage() {
        return errorMessage;
    }

    public AnswerShippingQuery withShippingQueryId(String shippingQueryId) {
        return new AnswerShippingQuery(shippingQueryId, ok, shippingOptions, errorMessage);
    }

    public AnswerShippingQuery withOk(boolean ok) {
        return new AnswerShippingQuery(shippingQueryId, ok, shippingOptions, errorMessage);
    }

    public AnswerShippingQuery withShippingOptions(@Nullable List<ShippingOption> shippingOptions) {
        return new AnswerShippingQuery(shippingQueryId, ok, shippingOptions, errorMessage);
    }

    public AnswerShippingQuery withErrorMessage(@Nullable String errorMessage) {
        return new AnswerShippingQuery(shippingQueryId, ok, shippingOptions, errorMessage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnswerShippingQuery)) {
            return false;
        }
        AnswerShippingQuery that = (AnswerShippingQuery) o;
        return Objects.equals(this.shippingQueryId, that.shippingQueryId)
                && this.ok == that.ok
                && Objects.equals(this.shippingOptions, that.shippingOptions)
                && Objects.equals(this.errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.shippingQueryId, this.ok, this.shippingOptions, this.errorMessage);
    }

    @Override
    public String toString() {
        return "AnswerShippingQuery[shippingQueryId=" + this.shippingQueryId
                + ", ok=" + this.ok
                + ", shippingOptions=" + this.shippingOptions
                + ", errorMessage=" + this.errorMessage
                + "]";
    }
}
