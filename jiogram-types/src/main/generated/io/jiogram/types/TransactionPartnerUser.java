package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.AffiliateInfo;
import io.jiogram.types.Gift;
import io.jiogram.types.PaidMedia;
import io.jiogram.types.TransactionPartnerType;
import io.jiogram.types.TransactionType;
import io.jiogram.types.User;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a transaction with a user.
 *
 * @see <a href="https://core.telegram.org/bots/api#transactionpartneruser">TransactionPartnerUser in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class TransactionPartnerUser implements TransactionPartner {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final TransactionPartnerType type;

    @JsonProperty("transaction_type")
    private final TransactionType transactionType;

    @JsonProperty("user")
    private final User user;

    @JsonProperty("affiliate")
    private final @Nullable AffiliateInfo affiliate;

    @JsonProperty("invoice_payload")
    private final @Nullable String invoicePayload;

    @JsonProperty("subscription_period")
    private final @Nullable Long subscriptionPeriod;

    @JsonProperty("paid_media")
    private final @Nullable List<PaidMedia> paidMedia;

    @JsonProperty("paid_media_payload")
    private final @Nullable String paidMediaPayload;

    @JsonProperty("gift")
    private final @Nullable Gift gift;

    @JsonProperty("premium_subscription_duration")
    private final @Nullable Long premiumSubscriptionDuration;

    /**
     * Creates a new {@code TransactionPartnerUser} instance.
     *
     * @param type Type of the transaction partner, always 'user'
     * @param transactionType Type of the transaction, currently one of 'invoice_payment' for
     *     payments via invoices, 'paid_media_payment' for payments for paid media, 'gift_purchase'
     *     for gifts sent by the bot, 'premium_purchase' for Telegram Premium subscriptions gifted
     *     by the bot, 'business_account_transfer' for direct transfers from managed business
     *     accounts
     * @param user Information about the user
     * @param affiliate Information about the affiliate that received a commission via this
     *     transaction. Can be available only for 'invoice_payment' and 'paid_media_payment'
     *     transactions.
     * @param invoicePayload Bot-specified invoice payload. Can be available only for
     *     'invoice_payment' transactions.
     * @param subscriptionPeriod The duration of the paid subscription. Can be available only for
     *     'invoice_payment' transactions.
     * @param paidMedia Information about the paid media bought by the user; for
     *     'paid_media_payment' transactions only
     * @param paidMediaPayload Bot-specified paid media payload. Can be available only for
     *     'paid_media_payment' transactions.
     * @param gift The gift sent to the user by the bot; for 'gift_purchase' transactions only
     * @param premiumSubscriptionDuration Number of months the gifted Telegram Premium subscription
     *     will be active for; for 'premium_purchase' transactions only
     */
    @JsonCreator
    public TransactionPartnerUser(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
            @JsonProperty("transaction_type") TransactionType transactionType,
            @JsonProperty("user") User user,
            @JsonProperty("affiliate") @Nullable AffiliateInfo affiliate,
            @JsonProperty("invoice_payload") @Nullable String invoicePayload,
            @JsonProperty("subscription_period") @Nullable Long subscriptionPeriod,
            @JsonProperty("paid_media") @Nullable List<PaidMedia> paidMedia,
            @JsonProperty("paid_media_payload") @Nullable String paidMediaPayload,
            @JsonProperty("gift") @Nullable Gift gift,
            @JsonProperty("premium_subscription_duration") @Nullable Long premiumSubscriptionDuration) {
        this.type = type;
        this.transactionType = transactionType;
        this.user = user;
        this.affiliate = affiliate;
        this.invoicePayload = invoicePayload;
        this.subscriptionPeriod = subscriptionPeriod;
        this.paidMedia = paidMedia;
        this.paidMediaPayload = paidMediaPayload;
        this.gift = gift;
        this.premiumSubscriptionDuration = premiumSubscriptionDuration;
    }

    public static TransactionPartnerUser of(TransactionType transactionType, User user) {
        return new TransactionPartnerUser(TransactionPartnerType.USER, transactionType, user, null, null, null, null, null, null, null);
    }

    /**
     * Type of the transaction partner, always 'user'
     */
    public TransactionPartnerType type() {
        return type;
    }

    /**
     * Type of the transaction, currently one of 'invoice_payment' for payments via invoices,
     * 'paid_media_payment' for payments for paid media, 'gift_purchase' for gifts sent by the bot,
     * 'premium_purchase' for Telegram Premium subscriptions gifted by the bot,
     * 'business_account_transfer' for direct transfers from managed business accounts
     */
    public TransactionType transactionType() {
        return transactionType;
    }

    /**
     * Information about the user
     */
    public User user() {
        return user;
    }

    /**
     * Information about the affiliate that received a commission via this transaction. Can be
     * available only for 'invoice_payment' and 'paid_media_payment' transactions.
     */
    public @Nullable AffiliateInfo affiliate() {
        return affiliate;
    }

    /**
     * Bot-specified invoice payload. Can be available only for 'invoice_payment' transactions.
     */
    public @Nullable String invoicePayload() {
        return invoicePayload;
    }

    /**
     * The duration of the paid subscription. Can be available only for 'invoice_payment'
     * transactions.
     */
    public @Nullable Long subscriptionPeriod() {
        return subscriptionPeriod;
    }

    /**
     * Information about the paid media bought by the user; for 'paid_media_payment' transactions
     * only
     */
    public @Nullable List<PaidMedia> paidMedia() {
        return paidMedia;
    }

    /**
     * Bot-specified paid media payload. Can be available only for 'paid_media_payment'
     * transactions.
     */
    public @Nullable String paidMediaPayload() {
        return paidMediaPayload;
    }

    /**
     * The gift sent to the user by the bot; for 'gift_purchase' transactions only
     */
    public @Nullable Gift gift() {
        return gift;
    }

    /**
     * Number of months the gifted Telegram Premium subscription will be active for; for
     * 'premium_purchase' transactions only
     */
    public @Nullable Long premiumSubscriptionDuration() {
        return premiumSubscriptionDuration;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransactionPartnerUser)) {
            return false;
        }
        TransactionPartnerUser that = (TransactionPartnerUser) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.transactionType, that.transactionType)
                && Objects.equals(this.user, that.user)
                && Objects.equals(this.affiliate, that.affiliate)
                && Objects.equals(this.invoicePayload, that.invoicePayload)
                && Objects.equals(this.subscriptionPeriod, that.subscriptionPeriod)
                && Objects.equals(this.paidMedia, that.paidMedia)
                && Objects.equals(this.paidMediaPayload, that.paidMediaPayload)
                && Objects.equals(this.gift, that.gift)
                && Objects.equals(this.premiumSubscriptionDuration, that.premiumSubscriptionDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.transactionType, this.user, this.affiliate, this.invoicePayload, this.subscriptionPeriod, this.paidMedia, this.paidMediaPayload, this.gift, this.premiumSubscriptionDuration);
    }

    @Override
    public String toString() {
        return "TransactionPartnerUser[type=" + this.type
                + ", transactionType=" + this.transactionType
                + ", user=" + this.user
                + ", affiliate=" + this.affiliate
                + ", invoicePayload=" + this.invoicePayload
                + ", subscriptionPeriod=" + this.subscriptionPeriod
                + ", paidMedia=" + this.paidMedia
                + ", paidMediaPayload=" + this.paidMediaPayload
                + ", gift=" + this.gift
                + ", premiumSubscriptionDuration=" + this.premiumSubscriptionDuration
                + "]";
    }
}
