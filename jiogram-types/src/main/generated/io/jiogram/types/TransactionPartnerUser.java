package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.AffiliateInfo;
import io.jiogram.types.Gift;
import io.jiogram.types.PaidMedia;
import io.jiogram.types.TransactionPartnerType;
import io.jiogram.types.TransactionType;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a transaction with a user.
 *
 * @param type Type of the transaction partner, always 'user'
 * @param transactionType Type of the transaction, currently one of 'invoice_payment' for payments
 *     via invoices, 'paid_media_payment' for payments for paid media, 'gift_purchase' for gifts
 *     sent by the bot, 'premium_purchase' for Telegram Premium subscriptions gifted by the bot,
 *     'business_account_transfer' for direct transfers from managed business accounts
 * @param user Information about the user
 * @param affiliate Information about the affiliate that received a commission via this transaction.
 *     Can be available only for 'invoice_payment' and 'paid_media_payment' transactions.
 * @param invoicePayload Bot-specified invoice payload. Can be available only for 'invoice_payment'
 *     transactions.
 * @param subscriptionPeriod The duration of the paid subscription. Can be available only for
 *     'invoice_payment' transactions.
 * @param paidMedia Information about the paid media bought by the user; for 'paid_media_payment'
 *     transactions only
 * @param paidMediaPayload Bot-specified paid media payload. Can be available only for
 *     'paid_media_payment' transactions.
 * @param gift The gift sent to the user by the bot; for 'gift_purchase' transactions only
 * @param premiumSubscriptionDuration Number of months the gifted Telegram Premium subscription will
 *     be active for; for 'premium_purchase' transactions only
 * @see <a href="https://core.telegram.org/bots/api#transactionpartneruser">TransactionPartnerUser in the Bot API</a>
 */
public record TransactionPartnerUser(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
    @JsonProperty("transaction_type") TransactionType transactionType,
    @JsonProperty("user") User user,
    @JsonProperty("affiliate") @Nullable AffiliateInfo affiliate,
    @JsonProperty("invoice_payload") @Nullable String invoicePayload,
    @JsonProperty("subscription_period") @Nullable Long subscriptionPeriod,
    @JsonProperty("paid_media") @Nullable List<PaidMedia> paidMedia,
    @JsonProperty("paid_media_payload") @Nullable String paidMediaPayload,
    @JsonProperty("gift") @Nullable Gift gift,
    @JsonProperty("premium_subscription_duration") @Nullable Long premiumSubscriptionDuration
) implements TransactionPartner {

    public static TransactionPartnerUser of(TransactionType transactionType, User user) {
        return new TransactionPartnerUser(TransactionPartnerType.USER, transactionType, user, null, null, null, null, null, null, null);
    }

    public TransactionPartnerUser withTransactionType(TransactionType transactionType) {
        return new TransactionPartnerUser(type, transactionType, user, affiliate, invoicePayload, subscriptionPeriod, paidMedia, paidMediaPayload, gift, premiumSubscriptionDuration);
    }

    public TransactionPartnerUser withUser(User user) {
        return new TransactionPartnerUser(type, transactionType, user, affiliate, invoicePayload, subscriptionPeriod, paidMedia, paidMediaPayload, gift, premiumSubscriptionDuration);
    }

    public TransactionPartnerUser withAffiliate(@Nullable AffiliateInfo affiliate) {
        return new TransactionPartnerUser(type, transactionType, user, affiliate, invoicePayload, subscriptionPeriod, paidMedia, paidMediaPayload, gift, premiumSubscriptionDuration);
    }

    public TransactionPartnerUser withInvoicePayload(@Nullable String invoicePayload) {
        return new TransactionPartnerUser(type, transactionType, user, affiliate, invoicePayload, subscriptionPeriod, paidMedia, paidMediaPayload, gift, premiumSubscriptionDuration);
    }

    public TransactionPartnerUser withSubscriptionPeriod(@Nullable Long subscriptionPeriod) {
        return new TransactionPartnerUser(type, transactionType, user, affiliate, invoicePayload, subscriptionPeriod, paidMedia, paidMediaPayload, gift, premiumSubscriptionDuration);
    }

    public TransactionPartnerUser withPaidMedia(@Nullable List<PaidMedia> paidMedia) {
        return new TransactionPartnerUser(type, transactionType, user, affiliate, invoicePayload, subscriptionPeriod, paidMedia, paidMediaPayload, gift, premiumSubscriptionDuration);
    }

    public TransactionPartnerUser withPaidMediaPayload(@Nullable String paidMediaPayload) {
        return new TransactionPartnerUser(type, transactionType, user, affiliate, invoicePayload, subscriptionPeriod, paidMedia, paidMediaPayload, gift, premiumSubscriptionDuration);
    }

    public TransactionPartnerUser withGift(@Nullable Gift gift) {
        return new TransactionPartnerUser(type, transactionType, user, affiliate, invoicePayload, subscriptionPeriod, paidMedia, paidMediaPayload, gift, premiumSubscriptionDuration);
    }

    public TransactionPartnerUser withPremiumSubscriptionDuration(@Nullable Long premiumSubscriptionDuration) {
        return new TransactionPartnerUser(type, transactionType, user, affiliate, invoicePayload, subscriptionPeriod, paidMedia, paidMediaPayload, gift, premiumSubscriptionDuration);
    }
}
