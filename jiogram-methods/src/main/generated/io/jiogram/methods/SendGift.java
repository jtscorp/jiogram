package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Sends a gift to the given user or channel chat. The gift can't be converted to Telegram Stars by
 * the receiver. Returns True on success.
 *
 * @param userId Required if chat_id is not specified. Unique identifier of the target user who will
 *     receive the gift.
 * @param chatId Required if user_id is not specified. Unique identifier for the chat or username of
 *     the channel (in the format &#64;channelusername) that will receive the gift.
 * @param giftId Identifier of the gift; limited gifts can't be sent to channel chats
 * @param payForUpgrade Pass True to pay for the gift upgrade from the bot's balance, thereby making
 *     the upgrade free for the receiver
 * @param text Text that will be shown along with the gift; 0-128 characters
 * @param textParseMode Mode for parsing entities in the text. See formatting options for more
 *     details. Entities other than 'bold', 'italic', 'underline', 'strikethrough', 'spoiler',
 *     'custom_emoji', and 'date_time' are ignored.
 * @param textEntities A JSON-serialized list of special entities that appear in the gift text. It
 *     can be specified instead of text_parse_mode. Entities other than 'bold', 'italic',
 *     'underline', 'strikethrough', 'spoiler', 'custom_emoji', and 'date_time' are ignored.
 * @see <a href="https://core.telegram.org/bots/api#sendgift">sendGift in the Bot API</a>
 */
public record SendGift(
    @JsonProperty("user_id") @Nullable Long userId,
    @JsonProperty("chat_id") @Nullable ChatId chatId,
    @JsonProperty("gift_id") String giftId,
    @JsonProperty("pay_for_upgrade") @Nullable Boolean payForUpgrade,
    @JsonProperty("text") @Nullable String text,
    @JsonProperty("text_parse_mode") @Nullable ParseMode textParseMode,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
) implements TelegramMethod<Boolean> {

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
}
