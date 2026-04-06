package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LabeledPrice;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record CreateInvoiceLink(
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
) implements TelegramMethod<String> {

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
