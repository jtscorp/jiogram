package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Once the user has confirmed their payment and shipping details, the Bot API sends the final
 * confirmation in the form of an Update with the field pre_checkout_query. Use this method to
 * respond to such pre-checkout queries. On success, True is returned. Note: The Bot API must
 * receive an answer within 10 seconds after the pre-checkout query was sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#answerprecheckoutquery">answerPreCheckoutQuery in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class AnswerPreCheckoutQuery implements TelegramMethod<Boolean> {

    @JsonProperty("pre_checkout_query_id")
    private final String preCheckoutQueryId;

    @JsonProperty("ok")
    private final boolean ok;

    @JsonProperty("error_message")
    private final @Nullable String errorMessage;

    /**
     * Creates a new {@code AnswerPreCheckoutQuery} instance.
     *
     * @param preCheckoutQueryId Unique identifier for the query to be answered
     * @param ok Specify True if everything is alright (goods are available, etc.) and the bot is
     *     ready to proceed with the order. Use False if there are any problems.
     * @param errorMessage Required if ok is False. Error message in human readable form that
     *     explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just
     *     bought the last of our amazing black T-shirts while you were busy filling out your
     *     payment details. Please choose a different color or garment!"). Telegram will display
     *     this message to the user.
     */
    @JsonCreator
    public AnswerPreCheckoutQuery(
            @JsonProperty("pre_checkout_query_id") String preCheckoutQueryId,
            @JsonProperty("ok") boolean ok,
            @JsonProperty("error_message") @Nullable String errorMessage) {
        this.preCheckoutQueryId = preCheckoutQueryId;
        this.ok = ok;
        this.errorMessage = errorMessage;
    }

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

    /**
     * Unique identifier for the query to be answered
     */
    public String preCheckoutQueryId() {
        return preCheckoutQueryId;
    }

    /**
     * Specify True if everything is alright (goods are available, etc.) and the bot is ready to
     * proceed with the order. Use False if there are any problems.
     */
    public boolean ok() {
        return ok;
    }

    /**
     * Required if ok is False. Error message in human readable form that explains the reason for
     * failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our
     * amazing black T-shirts while you were busy filling out your payment details. Please choose a
     * different color or garment!"). Telegram will display this message to the user.
     */
    public @Nullable String errorMessage() {
        return errorMessage;
    }

    public AnswerPreCheckoutQuery withPreCheckoutQueryId(String preCheckoutQueryId) {
        return new AnswerPreCheckoutQuery(preCheckoutQueryId, ok, errorMessage);
    }

    public AnswerPreCheckoutQuery withOk(boolean ok) {
        return new AnswerPreCheckoutQuery(preCheckoutQueryId, ok, errorMessage);
    }

    public AnswerPreCheckoutQuery withErrorMessage(@Nullable String errorMessage) {
        return new AnswerPreCheckoutQuery(preCheckoutQueryId, ok, errorMessage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnswerPreCheckoutQuery)) {
            return false;
        }
        AnswerPreCheckoutQuery that = (AnswerPreCheckoutQuery) o;
        return Objects.equals(this.preCheckoutQueryId, that.preCheckoutQueryId)
                && this.ok == that.ok
                && Objects.equals(this.errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.preCheckoutQueryId, this.ok, this.errorMessage);
    }

    @Override
    public String toString() {
        return "AnswerPreCheckoutQuery[preCheckoutQueryId=" + this.preCheckoutQueryId
                + ", ok=" + this.ok
                + ", errorMessage=" + this.errorMessage
                + "]";
    }
}
