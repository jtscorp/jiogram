package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.LabeledPrice;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class SendInvoice implements TelegramMethod<Message> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_thread_id") @Nullable private final Long messageThreadId;
    @JsonProperty("direct_messages_topic_id") @Nullable private final Long directMessagesTopicId;
    @JsonProperty("title") private final String title;
    @JsonProperty("description") private final String description;
    @JsonProperty("payload") private final String payload;
    @JsonProperty("provider_token") @Nullable private final String providerToken;
    @JsonProperty("currency") private final String currency;
    @JsonProperty("prices") private final List<LabeledPrice> prices;
    @JsonProperty("max_tip_amount") @Nullable private final Long maxTipAmount;
    @JsonProperty("suggested_tip_amounts") @Nullable private final List<Long> suggestedTipAmounts;
    @JsonProperty("start_parameter") @Nullable private final String startParameter;
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
    @JsonProperty("disable_notification") @Nullable private final Boolean disableNotification;
    @JsonProperty("protect_content") @Nullable private final Boolean protectContent;
    @JsonProperty("allow_paid_broadcast") @Nullable private final Boolean allowPaidBroadcast;
    @JsonProperty("message_effect_id") @Nullable private final String messageEffectId;
    @JsonProperty("suggested_post_parameters") @Nullable private final SuggestedPostParameters suggestedPostParameters;
    @JsonProperty("reply_parameters") @Nullable private final ReplyParameters replyParameters;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;

    @JsonCreator
    public SendInvoice(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("payload") String payload,
            @JsonProperty("provider_token") @Nullable String providerToken,
            @JsonProperty("currency") String currency,
            @JsonProperty("prices") List<LabeledPrice> prices,
            @JsonProperty("max_tip_amount") @Nullable Long maxTipAmount,
            @JsonProperty("suggested_tip_amounts") @Nullable List<Long> suggestedTipAmounts,
            @JsonProperty("start_parameter") @Nullable String startParameter,
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
            @JsonProperty("is_flexible") @Nullable Boolean isFlexible,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
    ) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.title = title;
        this.description = description;
        this.payload = payload;
        this.providerToken = providerToken;
        this.currency = currency;
        this.prices = prices;
        this.maxTipAmount = maxTipAmount;
        this.suggestedTipAmounts = suggestedTipAmounts;
        this.startParameter = startParameter;
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
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.allowPaidBroadcast = allowPaidBroadcast;
        this.messageEffectId = messageEffectId;
        this.suggestedPostParameters = suggestedPostParameters;
        this.replyParameters = replyParameters;
        this.replyMarkup = replyMarkup;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Long messageThreadId() {
        return this.messageThreadId;
    }

    public Long directMessagesTopicId() {
        return this.directMessagesTopicId;
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

    public Long maxTipAmount() {
        return this.maxTipAmount;
    }

    public List<Long> suggestedTipAmounts() {
        return this.suggestedTipAmounts;
    }

    public String startParameter() {
        return this.startParameter;
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

    public Boolean disableNotification() {
        return this.disableNotification;
    }

    public Boolean protectContent() {
        return this.protectContent;
    }

    public Boolean allowPaidBroadcast() {
        return this.allowPaidBroadcast;
    }

    public String messageEffectId() {
        return this.messageEffectId;
    }

    public SuggestedPostParameters suggestedPostParameters() {
        return this.suggestedPostParameters;
    }

    public ReplyParameters replyParameters() {
        return this.replyParameters;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "sendInvoice";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendInvoice of(ChatId chatId, String title, String description, String payload, String currency, List<LabeledPrice> prices) {
        return new SendInvoice(chatId, null, null, title, description, payload, null, currency, prices, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
