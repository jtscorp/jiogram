package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Gifts a Telegram Premium subscription to the given user. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#giftpremiumsubscription">giftPremiumSubscription in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GiftPremiumSubscription implements TelegramMethod<Boolean> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("month_count")
    private final long monthCount;

    @JsonProperty("star_count")
    private final long starCount;

    @JsonProperty("text")
    private final @Nullable String text;

    @JsonProperty("text_parse_mode")
    private final @Nullable ParseMode textParseMode;

    @JsonProperty("text_entities")
    private final @Nullable List<MessageEntity> textEntities;

    /**
     * Creates a new {@code GiftPremiumSubscription} instance.
     *
     * @param userId Unique identifier of the target user who will receive a Telegram Premium
     *     subscription
     * @param monthCount Number of months the Telegram Premium subscription will be active for the
     *     user; must be one of 3, 6, or 12
     * @param starCount Number of Telegram Stars to pay for the Telegram Premium subscription; must
     *     be 1000 for 3 months, 1500 for 6 months, and 2500 for 12 months
     * @param text Text that will be shown along with the service message about the subscription;
     *     0-128 characters
     * @param textParseMode Mode for parsing entities in the text. See formatting options for more
     *     details. Entities other than 'bold', 'italic', 'underline', 'strikethrough', 'spoiler',
     *     'custom_emoji', and 'date_time' are ignored.
     * @param textEntities A JSON-serialized list of special entities that appear in the gift text.
     *     It can be specified instead of text_parse_mode. Entities other than 'bold', 'italic',
     *     'underline', 'strikethrough', 'spoiler', 'custom_emoji', and 'date_time' are ignored.
     */
    @JsonCreator
    public GiftPremiumSubscription(
            @JsonProperty("user_id") long userId,
            @JsonProperty("month_count") long monthCount,
            @JsonProperty("star_count") long starCount,
            @JsonProperty("text") @Nullable String text,
            @JsonProperty("text_parse_mode") @Nullable ParseMode textParseMode,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities) {
        this.userId = userId;
        this.monthCount = monthCount;
        this.starCount = starCount;
        this.text = text;
        this.textParseMode = textParseMode;
        this.textEntities = textEntities;
    }

    @Override
    public String apiMethod() {
        return "giftPremiumSubscription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static GiftPremiumSubscription of(long userId, long monthCount, long starCount) {
        return new GiftPremiumSubscription(userId, monthCount, starCount, null, null, null);
    }

    /**
     * Unique identifier of the target user who will receive a Telegram Premium subscription
     */
    public long userId() {
        return userId;
    }

    /**
     * Number of months the Telegram Premium subscription will be active for the user; must be one
     * of 3, 6, or 12
     */
    public long monthCount() {
        return monthCount;
    }

    /**
     * Number of Telegram Stars to pay for the Telegram Premium subscription; must be 1000 for 3
     * months, 1500 for 6 months, and 2500 for 12 months
     */
    public long starCount() {
        return starCount;
    }

    /**
     * Text that will be shown along with the service message about the subscription; 0-128
     * characters
     */
    public @Nullable String text() {
        return text;
    }

    /**
     * Mode for parsing entities in the text. See formatting options for more details. Entities
     * other than 'bold', 'italic', 'underline', 'strikethrough', 'spoiler', 'custom_emoji', and
     * 'date_time' are ignored.
     */
    public @Nullable ParseMode textParseMode() {
        return textParseMode;
    }

    /**
     * A JSON-serialized list of special entities that appear in the gift text. It can be specified
     * instead of text_parse_mode. Entities other than 'bold', 'italic', 'underline',
     * 'strikethrough', 'spoiler', 'custom_emoji', and 'date_time' are ignored.
     */
    public @Nullable List<MessageEntity> textEntities() {
        return textEntities;
    }

    public GiftPremiumSubscription withUserId(long userId) {
        return new GiftPremiumSubscription(userId, monthCount, starCount, text, textParseMode, textEntities);
    }

    public GiftPremiumSubscription withMonthCount(long monthCount) {
        return new GiftPremiumSubscription(userId, monthCount, starCount, text, textParseMode, textEntities);
    }

    public GiftPremiumSubscription withStarCount(long starCount) {
        return new GiftPremiumSubscription(userId, monthCount, starCount, text, textParseMode, textEntities);
    }

    public GiftPremiumSubscription withText(@Nullable String text) {
        return new GiftPremiumSubscription(userId, monthCount, starCount, text, textParseMode, textEntities);
    }

    public GiftPremiumSubscription withTextParseMode(@Nullable ParseMode textParseMode) {
        return new GiftPremiumSubscription(userId, monthCount, starCount, text, textParseMode, textEntities);
    }

    public GiftPremiumSubscription withTextEntities(@Nullable List<MessageEntity> textEntities) {
        return new GiftPremiumSubscription(userId, monthCount, starCount, text, textParseMode, textEntities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GiftPremiumSubscription)) {
            return false;
        }
        GiftPremiumSubscription that = (GiftPremiumSubscription) o;
        return this.userId == that.userId
                && this.monthCount == that.monthCount
                && this.starCount == that.starCount
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.textParseMode, that.textParseMode)
                && Objects.equals(this.textEntities, that.textEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.monthCount, this.starCount, this.text, this.textParseMode, this.textEntities);
    }

    @Override
    public String toString() {
        return "GiftPremiumSubscription[userId=" + this.userId
                + ", monthCount=" + this.monthCount
                + ", starCount=" + this.starCount
                + ", text=" + this.text
                + ", textParseMode=" + this.textParseMode
                + ", textEntities=" + this.textEntities
                + "]";
    }
}
