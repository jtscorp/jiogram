package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarTransaction;
import java.util.List;
import java.util.Objects;

/**
 * Contains a list of Telegram Star transactions.
 *
 * @see <a href="https://core.telegram.org/bots/api#startransactions">StarTransactions in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StarTransactions {

    @JsonProperty("transactions")
    private final List<StarTransaction> transactions;

    /**
     * Creates a new {@code StarTransactions} instance.
     *
     * @param transactions The list of transactions
     */
    @JsonCreator
    public StarTransactions(
            @JsonProperty("transactions") List<StarTransaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * The list of transactions
     */
    public List<StarTransaction> transactions() {
        return transactions;
    }

    public StarTransactions withTransactions(List<StarTransaction> transactions) {
        return new StarTransactions(transactions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StarTransactions)) {
            return false;
        }
        StarTransactions that = (StarTransactions) o;
        return Objects.equals(this.transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.transactions);
    }

    @Override
    public String toString() {
        return "StarTransactions[transactions=" + this.transactions
                + "]";
    }
}
