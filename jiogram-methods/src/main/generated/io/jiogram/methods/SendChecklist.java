package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputChecklist;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send a checklist on behalf of a connected business account. On success, the
 * sent Message is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendchecklist">sendChecklist in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendChecklist implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("chat_id")
    private final long chatId;

    @JsonProperty("checklist")
    private final InputChecklist checklist;

    @JsonProperty("disable_notification")
    private final @Nullable Boolean disableNotification;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    @JsonProperty("message_effect_id")
    private final @Nullable String messageEffectId;

    @JsonProperty("reply_parameters")
    private final @Nullable ReplyParameters replyParameters;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code SendChecklist} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat
     * @param checklist A JSON-serialized object for the checklist to send
     * @param disableNotification Sends the message silently. Users will receive a notification with
     *     no sound.
     * @param protectContent Protects the contents of the sent message from forwarding and saving
     * @param messageEffectId Unique identifier of the message effect to be added to the message
     * @param replyParameters A JSON-serialized object for description of the message to reply to
     * @param replyMarkup A JSON-serialized object for an inline keyboard
     */
    @JsonCreator
    public SendChecklist(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("checklist") InputChecklist checklist,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.checklist = checklist;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.messageEffectId = messageEffectId;
        this.replyParameters = replyParameters;
        this.replyMarkup = replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "sendChecklist";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendChecklist of(String businessConnectionId, long chatId, InputChecklist checklist) {
        return new SendChecklist(businessConnectionId, chatId, checklist, null, null, null, null, null);
    }

    /**
     * Unique identifier of the business connection on behalf of which the message will be sent
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier for the target chat
     */
    public long chatId() {
        return chatId;
    }

    /**
     * A JSON-serialized object for the checklist to send
     */
    public InputChecklist checklist() {
        return checklist;
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
     * Unique identifier of the message effect to be added to the message
     */
    public @Nullable String messageEffectId() {
        return messageEffectId;
    }

    /**
     * A JSON-serialized object for description of the message to reply to
     */
    public @Nullable ReplyParameters replyParameters() {
        return replyParameters;
    }

    /**
     * A JSON-serialized object for an inline keyboard
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    public SendChecklist withBusinessConnectionId(String businessConnectionId) {
        return new SendChecklist(businessConnectionId, chatId, checklist, disableNotification, protectContent, messageEffectId, replyParameters, replyMarkup);
    }

    public SendChecklist withChatId(long chatId) {
        return new SendChecklist(businessConnectionId, chatId, checklist, disableNotification, protectContent, messageEffectId, replyParameters, replyMarkup);
    }

    public SendChecklist withChecklist(InputChecklist checklist) {
        return new SendChecklist(businessConnectionId, chatId, checklist, disableNotification, protectContent, messageEffectId, replyParameters, replyMarkup);
    }

    public SendChecklist withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendChecklist(businessConnectionId, chatId, checklist, disableNotification, protectContent, messageEffectId, replyParameters, replyMarkup);
    }

    public SendChecklist withProtectContent(@Nullable Boolean protectContent) {
        return new SendChecklist(businessConnectionId, chatId, checklist, disableNotification, protectContent, messageEffectId, replyParameters, replyMarkup);
    }

    public SendChecklist withMessageEffectId(@Nullable String messageEffectId) {
        return new SendChecklist(businessConnectionId, chatId, checklist, disableNotification, protectContent, messageEffectId, replyParameters, replyMarkup);
    }

    public SendChecklist withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendChecklist(businessConnectionId, chatId, checklist, disableNotification, protectContent, messageEffectId, replyParameters, replyMarkup);
    }

    public SendChecklist withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new SendChecklist(businessConnectionId, chatId, checklist, disableNotification, protectContent, messageEffectId, replyParameters, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendChecklist)) {
            return false;
        }
        SendChecklist that = (SendChecklist) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && this.chatId == that.chatId
                && Objects.equals(this.checklist, that.checklist)
                && Objects.equals(this.disableNotification, that.disableNotification)
                && Objects.equals(this.protectContent, that.protectContent)
                && Objects.equals(this.messageEffectId, that.messageEffectId)
                && Objects.equals(this.replyParameters, that.replyParameters)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.checklist, this.disableNotification, this.protectContent, this.messageEffectId, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendChecklist[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", checklist=" + this.checklist
                + ", disableNotification=" + this.disableNotification
                + ", protectContent=" + this.protectContent
                + ", messageEffectId=" + this.messageEffectId
                + ", replyParameters=" + this.replyParameters
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
