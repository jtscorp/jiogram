package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarTransactions;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Returns the bot's Telegram Star transactions in chronological order. On success, returns a
 * StarTransactions object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getstartransactions">getStarTransactions in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetStarTransactions implements TelegramMethod<StarTransactions> {

    @JsonProperty("offset")
    private final @Nullable Long offset;

    @JsonProperty("limit")
    private final @Nullable Long limit;

    /**
     * Creates a new {@code GetStarTransactions} instance.
     *
     * @param offset Number of transactions to skip in the response
     * @param limit The maximum number of transactions to be retrieved. Values between 1-100 are
     *     accepted. Defaults to 100.
     */
    @JsonCreator
    public GetStarTransactions(
            @JsonProperty("offset") @Nullable Long offset,
            @JsonProperty("limit") @Nullable Long limit) {
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    public String apiMethod() {
        return "getStarTransactions";
    }

    @Override
    public String apiReturnType() {
        return "StarTransactions";
    }

    public static GetStarTransactions of() {
        return new GetStarTransactions(null, null);
    }

    /**
     * Number of transactions to skip in the response
     */
    public @Nullable Long offset() {
        return offset;
    }

    /**
     * The maximum number of transactions to be retrieved. Values between 1-100 are accepted.
     * Defaults to 100.
     */
    public @Nullable Long limit() {
        return limit;
    }

    public GetStarTransactions withOffset(@Nullable Long offset) {
        return new GetStarTransactions(offset, limit);
    }

    public GetStarTransactions withLimit(@Nullable Long limit) {
        return new GetStarTransactions(offset, limit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetStarTransactions)) {
            return false;
        }
        GetStarTransactions that = (GetStarTransactions) o;
        return Objects.equals(this.offset, that.offset)
                && Objects.equals(this.limit, that.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.offset, this.limit);
    }

    @Override
    public String toString() {
        return "GetStarTransactions[offset=" + this.offset
                + ", limit=" + this.limit
                + "]";
    }
}
