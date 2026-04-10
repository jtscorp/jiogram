package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class EditMessageLiveLocation implements TelegramMethod<Message> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") @Nullable private final ChatId chatId;
    @JsonProperty("message_id") @Nullable private final Long messageId;
    @JsonProperty("inline_message_id") @Nullable private final String inlineMessageId;
    @JsonProperty("latitude") private final double latitude;
    @JsonProperty("longitude") private final double longitude;
    @JsonProperty("live_period") @Nullable private final Long livePeriod;
    @JsonProperty("horizontal_accuracy") @Nullable private final Double horizontalAccuracy;
    @JsonProperty("heading") @Nullable private final Long heading;
    @JsonProperty("proximity_alert_radius") @Nullable private final Long proximityAlertRadius;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;

    @JsonCreator
    public EditMessageLiveLocation(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("live_period") @Nullable Long livePeriod,
            @JsonProperty("horizontal_accuracy") @Nullable Double horizontalAccuracy,
            @JsonProperty("heading") @Nullable Long heading,
            @JsonProperty("proximity_alert_radius") @Nullable Long proximityAlertRadius,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.livePeriod = livePeriod;
        this.horizontalAccuracy = horizontalAccuracy;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
        this.replyMarkup = replyMarkup;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Long messageId() {
        return this.messageId;
    }

    public String inlineMessageId() {
        return this.inlineMessageId;
    }

    public double latitude() {
        return this.latitude;
    }

    public double longitude() {
        return this.longitude;
    }

    public Long livePeriod() {
        return this.livePeriod;
    }

    public Double horizontalAccuracy() {
        return this.horizontalAccuracy;
    }

    public Long heading() {
        return this.heading;
    }

    public Long proximityAlertRadius() {
        return this.proximityAlertRadius;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "editMessageLiveLocation";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static EditMessageLiveLocation of(double latitude, double longitude) {
        return new EditMessageLiveLocation(null, null, null, null, latitude, longitude, null, null, null, null, null);
    }
}
