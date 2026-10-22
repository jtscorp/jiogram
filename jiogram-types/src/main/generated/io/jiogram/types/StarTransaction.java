package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartner;
import org.jspecify.annotations.Nullable;

/**
 * Describes a Telegram Star transaction. Note that if the buyer initiates a chargeback with the
 * payment provider from whom they acquired Stars (e.g., Apple, Google) following this transaction,
 * the refunded Stars will be deducted from the bot's balance. This is outside of Telegram's
 * control.
 *
 * @param id Unique identifier of the transaction. Coincides with the identifier of the original
 *     transaction for refund transactions. Coincides with
 *     SuccessfulPayment.telegram_payment_charge_id for successful incoming payments from users.
 * @param amount Integer amount of Telegram Stars transferred by the transaction
 * @param nanostarAmount The number of 1/1000000000 shares of Telegram Stars transferred by the
 *     transaction; from 0 to 999999999
 * @param date Date the transaction was created in Unix time
 * @param source Source of an incoming transaction (e.g., a user purchasing goods or services,
 *     Fragment refunding a failed withdrawal). Only for incoming transactions
 * @param receiver Receiver of an outgoing transaction (e.g., a user for a purchase refund, Fragment
 *     for a withdrawal). Only for outgoing transactions
 * @see <a href="https://core.telegram.org/bots/api#startransaction">StarTransaction in the Bot API</a>
 */
public record StarTransaction(
    @JsonProperty("id") String id,
    @JsonProperty("amount") long amount,
    @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount,
    @JsonProperty("date") long date,
    @JsonProperty("source") @Nullable TransactionPartner source,
    @JsonProperty("receiver") @Nullable TransactionPartner receiver
) {

    public StarTransaction withId(String id) {
        return new StarTransaction(id, amount, nanostarAmount, date, source, receiver);
    }

    public StarTransaction withAmount(long amount) {
        return new StarTransaction(id, amount, nanostarAmount, date, source, receiver);
    }

    public StarTransaction withNanostarAmount(@Nullable Long nanostarAmount) {
        return new StarTransaction(id, amount, nanostarAmount, date, source, receiver);
    }

    public StarTransaction withDate(long date) {
        return new StarTransaction(id, amount, nanostarAmount, date, source, receiver);
    }

    public StarTransaction withSource(@Nullable TransactionPartner source) {
        return new StarTransaction(id, amount, nanostarAmount, date, source, receiver);
    }

    public StarTransaction withReceiver(@Nullable TransactionPartner receiver) {
        return new StarTransaction(id, amount, nanostarAmount, date, source, receiver);
    }
}
