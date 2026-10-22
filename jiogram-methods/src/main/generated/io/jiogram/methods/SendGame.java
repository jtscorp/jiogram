package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send a game. On success, the sent Message is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendgame">sendGame in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendGame implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final long chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("game_short_name")
    private final String gameShortName;

    @JsonProperty("disable_notification")
    private final @Nullable Boolean disableNotification;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    @JsonProperty("allow_paid_broadcast")
    private final @Nullable Boolean allowPaidBroadcast;

    @JsonProperty("message_effect_id")
    private final @Nullable String messageEffectId;

    @JsonProperty("reply_parameters")
    private final @Nullable ReplyParameters replyParameters;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code SendGame} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat. Games can't be sent to channel direct
     *     messages chats and channel chats.
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param gameShortName Short name of the game, serves as the unique identifier for the game.
     *     Set up your games via &#64;BotFather.
     * @param disableNotification Sends the message silently. Users will receive a notification with
     *     no sound.
     * @param protectContent Protects the contents of the sent message from forwarding and saving
     * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
     *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will
     *     be withdrawn from the bot's balance
     * @param messageEffectId Unique identifier of the message effect to be added to the message;
     *     for private chats only
     * @param replyParameters Description of the message to reply to
     * @param replyMarkup A JSON-serialized object for an inline keyboard. If empty, one 'Play
     *     game_title' button will be shown. If not empty, the first button must launch the game.
     */
    @JsonCreator
    public SendGame(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("game_short_name") String gameShortName,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.gameShortName = gameShortName;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.allowPaidBroadcast = allowPaidBroadcast;
        this.messageEffectId = messageEffectId;
        this.replyParameters = replyParameters;
        this.replyMarkup = replyMarkup;
    }

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

    /**
     * Unique identifier of the business connection on behalf of which the message will be sent
     */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier for the target chat. Games can't be sent to channel direct messages chats
     * and channel chats.
     */
    public long chatId() {
        return chatId;
    }

    /**
     * Unique identifier for the target message thread (topic) of a forum; for forum supergroups and
     * private chats of bots with forum topic mode enabled only
     */
    public @Nullable Long messageThreadId() {
        return messageThreadId;
    }

    /**
     * Short name of the game, serves as the unique identifier for the game. Set up your games via
     * &#64;BotFather.
     */
    public String gameShortName() {
        return gameShortName;
    }

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    public @Nullable Boolean disableNotification() {
        return disableNotification;
    }

    /**
     * Protects the contents of the sent message from forwarding and saving
     */
    public @Nullable Boolean protectContent() {
        return protectContent;
    }

    /**
     * Pass True to allow up to 1000 messages per second, ignoring broadcasting limits for a fee of
     * 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     */
    public @Nullable Boolean allowPaidBroadcast() {
        return allowPaidBroadcast;
    }

    /**
     * Unique identifier of the message effect to be added to the message; for private chats only
     */
    public @Nullable String messageEffectId() {
        return messageEffectId;
    }

    /**
     * Description of the message to reply to
     */
    public @Nullable ReplyParameters replyParameters() {
        return replyParameters;
    }

    /**
     * A JSON-serialized object for an inline keyboard. If empty, one 'Play game_title' button will
     * be shown. If not empty, the first button must launch the game.
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendGame)) {
            return false;
        }
        SendGame that = (SendGame) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && this.chatId == that.chatId
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.gameShortName, that.gameShortName)
                && Objects.equals(this.disableNotification, that.disableNotification)
                && Objects.equals(this.protectContent, that.protectContent)
                && Objects.equals(this.allowPaidBroadcast, that.allowPaidBroadcast)
                && Objects.equals(this.messageEffectId, that.messageEffectId)
                && Objects.equals(this.replyParameters, that.replyParameters)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageThreadId, this.gameShortName, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.messageEffectId, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendGame[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", gameShortName=" + this.gameShortName
                + ", disableNotification=" + this.disableNotification
                + ", protectContent=" + this.protectContent
                + ", allowPaidBroadcast=" + this.allowPaidBroadcast
                + ", messageEffectId=" + this.messageEffectId
                + ", replyParameters=" + this.replyParameters
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
