package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Sends a gift to the given user or channel chat. The gift can't be converted to Telegram Stars by
 * the receiver. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendgift">sendGift in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendGift implements TelegramMethod<Boolean> {

    @JsonProperty("user_id")
    private final @Nullable Long userId;

    @JsonProperty("chat_id")
    private final @Nullable ChatId chatId;

    @JsonProperty("gift_id")
    private final String giftId;

    @JsonProperty("pay_for_upgrade")
    private final @Nullable Boolean payForUpgrade;

    @JsonProperty("text")
    private final @Nullable String text;

    @JsonProperty("text_parse_mode")
    private final @Nullable ParseMode textParseMode;

    @JsonProperty("text_entities")
    private final @Nullable List<MessageEntity> textEntities;

    /**
     * Creates a new {@code SendGift} instance.
     *
     * @param userId Required if chat_id is not specified. Unique identifier of the target user who
     *     will receive the gift.
     * @param chatId Required if user_id is not specified. Unique identifier for the chat or
     *     username of the channel (in the format &#64;channelusername) that will receive the gift.
     * @param giftId Identifier of the gift; limited gifts can't be sent to channel chats
     * @param payForUpgrade Pass True to pay for the gift upgrade from the bot's balance, thereby
     *     making the upgrade free for the receiver
     * @param text Text that will be shown along with the gift; 0-128 characters
     * @param textParseMode Mode for parsing entities in the text. See formatting options for more
     *     details. Entities other than 'bold', 'italic', 'underline', 'strikethrough', 'spoiler',
     *     'custom_emoji', and 'date_time' are ignored.
     * @param textEntities A JSON-serialized list of special entities that appear in the gift text.
     *     It can be specified instead of text_parse_mode. Entities other than 'bold', 'italic',
     *     'underline', 'strikethrough', 'spoiler', 'custom_emoji', and 'date_time' are ignored.
     */
    @JsonCreator
    public SendGift(
            @JsonProperty("user_id") @Nullable Long userId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("gift_id") String giftId,
            @JsonProperty("pay_for_upgrade") @Nullable Boolean payForUpgrade,
            @JsonProperty("text") @Nullable String text,
            @JsonProperty("text_parse_mode") @Nullable ParseMode textParseMode,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities) {
        this.userId = userId;
        this.chatId = chatId;
        this.giftId = giftId;
        this.payForUpgrade = payForUpgrade;
        this.text = text;
        this.textParseMode = textParseMode;
        this.textEntities = textEntities;
    }

    @Override
    public String apiMethod() {
        return "sendGift";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SendGift of(String giftId) {
        return new SendGift(null, null, giftId, null, null, null, null);
    }

    /**
     * Required if chat_id is not specified. Unique identifier of the target user who will receive
     * the gift.
     */
    public @Nullable Long userId() {
        return userId;
    }

    /**
     * Required if user_id is not specified. Unique identifier for the chat or username of the
     * channel (in the format &#64;channelusername) that will receive the gift.
     */
    public @Nullable ChatId chatId() {
        return chatId;
    }

    /**
     * Identifier of the gift; limited gifts can't be sent to channel chats
     */
    public String giftId() {
        return giftId;
    }

    /**
     * Pass True to pay for the gift upgrade from the bot's balance, thereby making the upgrade free
     * for the receiver
     */
    public @Nullable Boolean payForUpgrade() {
        return payForUpgrade;
    }

    /**
     * Text that will be shown along with the gift; 0-128 characters
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

    public SendGift withUserId(@Nullable Long userId) {
        return new SendGift(userId, chatId, giftId, payForUpgrade, text, textParseMode, textEntities);
    }

    public SendGift withChatId(@Nullable ChatId chatId) {
        return new SendGift(userId, chatId, giftId, payForUpgrade, text, textParseMode, textEntities);
    }

    public SendGift withGiftId(String giftId) {
        return new SendGift(userId, chatId, giftId, payForUpgrade, text, textParseMode, textEntities);
    }

    public SendGift withPayForUpgrade(@Nullable Boolean payForUpgrade) {
        return new SendGift(userId, chatId, giftId, payForUpgrade, text, textParseMode, textEntities);
    }

    public SendGift withText(@Nullable String text) {
        return new SendGift(userId, chatId, giftId, payForUpgrade, text, textParseMode, textEntities);
    }

    public SendGift withTextParseMode(@Nullable ParseMode textParseMode) {
        return new SendGift(userId, chatId, giftId, payForUpgrade, text, textParseMode, textEntities);
    }

    public SendGift withTextEntities(@Nullable List<MessageEntity> textEntities) {
        return new SendGift(userId, chatId, giftId, payForUpgrade, text, textParseMode, textEntities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendGift)) {
            return false;
        }
        SendGift that = (SendGift) o;
        return Objects.equals(this.userId, that.userId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.giftId, that.giftId)
                && Objects.equals(this.payForUpgrade, that.payForUpgrade)
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.textParseMode, that.textParseMode)
                && Objects.equals(this.textEntities, that.textEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.chatId, this.giftId, this.payForUpgrade, this.text, this.textParseMode, this.textEntities);
    }

    @Override
    public String toString() {
        return "SendGift[userId=" + this.userId
                + ", chatId=" + this.chatId
                + ", giftId=" + this.giftId
                + ", payForUpgrade=" + this.payForUpgrade
                + ", text=" + this.text
                + ", textParseMode=" + this.textParseMode
                + ", textEntities=" + this.textEntities
                + "]";
    }
}
