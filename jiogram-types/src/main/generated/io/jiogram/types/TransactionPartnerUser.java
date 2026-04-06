package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.AffiliateInfo;
import io.jiogram.types.Gift;
import io.jiogram.types.PaidMedia;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record TransactionPartnerUser(
    @JsonProperty("type") String type,
    @JsonProperty("transaction_type") String transactionType,
    @JsonProperty("user") User user,
    @JsonProperty("affiliate") @Nullable AffiliateInfo affiliate,
    @JsonProperty("invoice_payload") @Nullable String invoicePayload,
    @JsonProperty("subscription_period") @Nullable Long subscriptionPeriod,
    @JsonProperty("paid_media") @Nullable List<PaidMedia> paidMedia,
    @JsonProperty("paid_media_payload") @Nullable String paidMediaPayload,
    @JsonProperty("gift") @Nullable Gift gift,
    @JsonProperty("premium_subscription_duration") @Nullable Long premiumSubscriptionDuration
) implements TransactionPartner {}
