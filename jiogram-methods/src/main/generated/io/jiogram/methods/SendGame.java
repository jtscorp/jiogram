package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send a game. On success, the sent Message is returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be sent
 * @param chatId Unique identifier for the target chat. Games can't be sent to channel direct
 *     messages chats and channel chats.
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param gameShortName Short name of the game, serves as the unique identifier for the game. Set up
 *     your games via &#64;BotFather.
 * @param disableNotification Sends the message silently. Users will receive a notification with no
 *     sound.
 * @param protectContent Protects the contents of the sent message from forwarding and saving
 * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
 *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will be
 *     withdrawn from the bot's balance
 * @param messageEffectId Unique identifier of the message effect to be added to the message; for
 *     private chats only
 * @param replyParameters Description of the message to reply to
 * @param replyMarkup A JSON-serialized object for an inline keyboard. If empty, one 'Play
 *     game_title' button will be shown. If not empty, the first button must launch the game.
 * @see <a href="https://core.telegram.org/bots/api#sendgame">sendGame in the Bot API</a>
 */
public record SendGame(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("game_short_name") String gameShortName,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent,
    @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
    @JsonProperty("message_effect_id") @Nullable String messageEffectId,
    @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Message> {

    @Override
    public String apiMethod() {
        return "sendGame";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendGame of(long chatId, String gameShortName) {
        return new SendGame(null, chatId, null, gameShortName, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendGame answer(Message message, String gameShortName) {
        return new SendGame(ReplyTarget.businessConnectionId(message), message.chat().id(), ReplyTarget.messageThreadId(message), gameShortName, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendGame reply(Message message, String gameShortName) {
        return new SendGame(ReplyTarget.businessConnectionId(message), message.chat().id(), ReplyTarget.messageThreadId(message), gameShortName, null, null, null, null, ReplyTarget.replyTo(message), null);
    }

    public SendGame withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendGame(businessConnectionId, chatId, messageThreadId, gameShortName, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendGame withChatId(long chatId) {
        return new SendGame(businessConnectionId, chatId, messageThreadId, gameShortName, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendGame withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendGame(businessConnectionId, chatId, messageThreadId, gameShortName, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendGame withGameShortName(String gameShortName) {
        return new SendGame(businessConnectionId, chatId, messageThreadId, gameShortName, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendGame withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendGame(businessConnectionId, chatId, messageThreadId, gameShortName, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendGame withProtectContent(@Nullable Boolean protectContent) {
        return new SendGame(businessConnectionId, chatId, messageThreadId, gameShortName, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendGame withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendGame(businessConnectionId, chatId, messageThreadId, gameShortName, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendGame withMessageEffectId(@Nullable String messageEffectId) {
        return new SendGame(businessConnectionId, chatId, messageThreadId, gameShortName, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendGame withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendGame(businessConnectionId, chatId, messageThreadId, gameShortName, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendGame withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new SendGame(businessConnectionId, chatId, messageThreadId, gameShortName, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }
}
