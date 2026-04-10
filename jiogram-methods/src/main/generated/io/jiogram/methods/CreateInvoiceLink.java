package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LabeledPrice;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class CreateInvoiceLink implements TelegramMethod<String> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("title") private final String title;
    @JsonProperty("description") private final String description;
    @JsonProperty("payload") private final String payload;
    @JsonProperty("provider_token") @Nullable private final String providerToken;
    @JsonProperty("currency") private final String currency;
    @JsonProperty("prices") private final List<LabeledPrice> prices;
    @JsonProperty("subscription_period") @Nullable private final Long subscriptionPeriod;
    @JsonProperty("max_tip_amount") @Nullable private final Long maxTipAmount;
    @JsonProperty("suggested_tip_amounts") @Nullable private final List<Long> suggestedTipAmounts;
    @JsonProperty("provider_data") @Nullable private final String providerData;
    @JsonProperty("photo_url") @Nullable private final String photoUrl;
    @JsonProperty("photo_size") @Nullable private final Long photoSize;
    @JsonProperty("photo_width") @Nullable private final Long photoWidth;
    @JsonProperty("photo_height") @Nullable private final Long photoHeight;
    @JsonProperty("need_name") @Nullable private final Boolean needName;
    @JsonProperty("need_phone_number") @Nullable private final Boolean needPhoneNumber;
    @JsonProperty("need_email") @Nullable private final Boolean needEmail;
    @JsonProperty("need_shipping_address") @Nullable private final Boolean needShippingAddress;
    @JsonProperty("send_phone_number_to_provider") @Nullable private final Boolean sendPhoneNumberToProvider;
    @JsonProperty("send_email_to_provider") @Nullable private final Boolean sendEmailToProvider;
    @JsonProperty("is_flexible") @Nullable private final Boolean isFlexible;

    @JsonCreator
    public CreateInvoiceLink(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("payload") String payload,
            @JsonProperty("provider_token") @Nullable String providerToken,
            @JsonProperty("currency") String currency,
            @JsonProperty("prices") List<LabeledPrice> prices,
            @JsonProperty("subscription_period") @Nullable Long subscriptionPeriod,
            @JsonProperty("max_tip_amount") @Nullable Long maxTipAmount,
            @JsonProperty("suggested_tip_amounts") @Nullable List<Long> suggestedTipAmounts,
            @JsonProperty("provider_data") @Nullable String providerData,
            @JsonProperty("photo_url") @Nullable String photoUrl,
            @JsonProperty("photo_size") @Nullable Long photoSize,
            @JsonProperty("photo_width") @Nullable Long photoWidth,
            @JsonProperty("photo_height") @Nullable Long photoHeight,
            @JsonProperty("need_name") @Nullable Boolean needName,
            @JsonProperty("need_phone_number") @Nullable Boolean needPhoneNumber,
            @JsonProperty("need_email") @Nullable Boolean needEmail,
            @JsonProperty("need_shipping_address") @Nullable Boolean needShippingAddress,
            @JsonProperty("send_phone_number_to_provider") @Nullable Boolean sendPhoneNumberToProvider,
            @JsonProperty("send_email_to_provider") @Nullable Boolean sendEmailToProvider,
            @JsonProperty("is_flexible") @Nullable Boolean isFlexible
    ) {
        this.businessConnectionId = businessConnectionId;
        this.title = title;
        this.description = description;
        this.payload = payload;
        this.providerToken = providerToken;
        this.currency = currency;
        this.prices = prices;
        this.subscriptionPeriod = subscriptionPeriod;
        this.maxTipAmount = maxTipAmount;
        this.suggestedTipAmounts = suggestedTipAmounts;
        this.providerData = providerData;
        this.photoUrl = photoUrl;
        this.photoSize = photoSize;
        this.photoWidth = photoWidth;
        this.photoHeight = photoHeight;
        this.needName = needName;
        this.needPhoneNumber = needPhoneNumber;
        this.needEmail = needEmail;
        this.needShippingAddress = needShippingAddress;
        this.sendPhoneNumberToProvider = sendPhoneNumberToProvider;
        this.sendEmailToProvider = sendEmailToProvider;
        this.isFlexible = isFlexible;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public String title() {
        return this.title;
    }

    public String description() {
        return this.description;
    }

    public String payload() {
        return this.payload;
    }

    public String providerToken() {
        return this.providerToken;
    }

    public String currency() {
        return this.currency;
    }

    public List<LabeledPrice> prices() {
        return this.prices;
    }

    public Long subscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public Long maxTipAmount() {
        return this.maxTipAmount;
    }

    public List<Long> suggestedTipAmounts() {
        return this.suggestedTipAmounts;
    }

    public String providerData() {
        return this.providerData;
    }

    public String photoUrl() {
        return this.photoUrl;
    }

    public Long photoSize() {
        return this.photoSize;
    }

    public Long photoWidth() {
        return this.photoWidth;
    }

    public Long photoHeight() {
        return this.photoHeight;
    }

    public Boolean needName() {
        return this.needName;
    }

    public Boolean needPhoneNumber() {
        return this.needPhoneNumber;
    }

    public Boolean needEmail() {
        return this.needEmail;
    }

    public Boolean needShippingAddress() {
        return this.needShippingAddress;
    }

    public Boolean sendPhoneNumberToProvider() {
        return this.sendPhoneNumberToProvider;
    }

    public Boolean sendEmailToProvider() {
        return this.sendEmailToProvider;
    }

    public Boolean isFlexible() {
        return this.isFlexible;
    }

    @Override
    public String apiMethod() {
        return "createInvoiceLink";
    }

    @Override
    public String apiReturnType() {
        return "String";
    }

    public static CreateInvoiceLink of(String title, String description, String payload, String currency, List<LabeledPrice> prices) {
        return new CreateInvoiceLink(null, title, description, payload, null, currency, prices, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
