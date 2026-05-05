package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.AffiliateInfo;
import io.jiogram.types.Gift;
import io.jiogram.types.PaidMedia;
import io.jiogram.types.TransactionPartnerType;
import io.jiogram.types.TransactionType;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class TransactionPartnerUser implements TransactionPartner {
    @JsonProperty("type") private final TransactionPartnerType type;
    @JsonProperty("transaction_type") private final TransactionType transactionType;
    @JsonProperty("user") private final User user;
    @JsonProperty("affiliate") @Nullable private final AffiliateInfo affiliate;
    @JsonProperty("invoice_payload") @Nullable private final String invoicePayload;
    @JsonProperty("subscription_period") @Nullable private final Long subscriptionPeriod;
    @JsonProperty("paid_media") @Nullable private final List<PaidMedia> paidMedia;
    @JsonProperty("paid_media_payload") @Nullable private final String paidMediaPayload;
    @JsonProperty("gift") @Nullable private final Gift gift;
    @JsonProperty("premium_subscription_duration") @Nullable private final Long premiumSubscriptionDuration;

    @JsonCreator
    public TransactionPartnerUser(
            @JsonProperty("type") TransactionPartnerType type,
            @JsonProperty("transaction_type") TransactionType transactionType,
            @JsonProperty("user") User user,
            @JsonProperty("affiliate") @Nullable AffiliateInfo affiliate,
            @JsonProperty("invoice_payload") @Nullable String invoicePayload,
            @JsonProperty("subscription_period") @Nullable Long subscriptionPeriod,
            @JsonProperty("paid_media") @Nullable List<PaidMedia> paidMedia,
            @JsonProperty("paid_media_payload") @Nullable String paidMediaPayload,
            @JsonProperty("gift") @Nullable Gift gift,
            @JsonProperty("premium_subscription_duration") @Nullable Long premiumSubscriptionDuration
    ) {
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

    public TransactionPartnerType type() {
        return this.type;
    }

    public TransactionType transactionType() {
        return this.transactionType;
    }

    public User user() {
        return this.user;
    }

    public AffiliateInfo affiliate() {
        return this.affiliate;
    }

    public String invoicePayload() {
        return this.invoicePayload;
    }

    public Long subscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public List<PaidMedia> paidMedia() {
        return this.paidMedia;
    }

    public String paidMediaPayload() {
        return this.paidMediaPayload;
    }

    public Gift gift() {
        return this.gift;
    }

    public Long premiumSubscriptionDuration() {
        return this.premiumSubscriptionDuration;
    }
}
