package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarTransaction;
import java.util.List;

/**
 * Contains a list of Telegram Star transactions.
 *
 * @param transactions The list of transactions
 * @see <a href="https://core.telegram.org/bots/api#startransactions">StarTransactions in the Bot API</a>
 */
public record StarTransactions(
    @JsonProperty("transactions") List<StarTransaction> transactions
) {}
