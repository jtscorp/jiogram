package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAction;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method when you need to tell the user that something is happening on the bot's side. The
 * status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear
 * its typing status). Returns True on success.
 * <br>Example: The ImageBot needs some time to process a request and upload the image. Instead of
 * sending a text message along the lines of 'Retrieving image, please wait…', the bot may use
 * sendChatAction with action = upload_photo. The user will see a 'sending photo' status for the
 * bot.
 * <br>We only recommend using this method when a response from the bot will take a noticeable
 * amount of time to arrive.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     action will be sent
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername). Channel chats and channel direct messages chats aren't
 *     supported.
 * @param messageThreadId Unique identifier for the target message thread or topic of a forum; for
 *     supergroups and private chats of bots with forum topic mode enabled only
 * @param action Type of action to broadcast. Choose one, depending on what the user is about to
 *     receive: typing for text messages, upload_photo for photos, record_video or upload_video for
 *     videos, record_voice or upload_voice for voice notes, upload_document for general files,
 *     choose_sticker for stickers, find_location for location data, record_video_note or
 *     upload_video_note for video notes.
 * @see <a href="https://core.telegram.org/bots/api#sendchataction">sendChatAction in the Bot API</a>
 */
public record SendChatAction(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("action") ChatAction action
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "sendChatAction";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SendChatAction of(ChatId chatId, ChatAction action) {
        return new SendChatAction(null, chatId, null, action);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendChatAction answer(Message message, ChatAction action) {
        return new SendChatAction(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), action);
    }

    public SendChatAction withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendChatAction(businessConnectionId, chatId, messageThreadId, action);
    }

    public SendChatAction withChatId(ChatId chatId) {
        return new SendChatAction(businessConnectionId, chatId, messageThreadId, action);
    }

    public SendChatAction withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendChatAction(businessConnectionId, chatId, messageThreadId, action);
    }

    public SendChatAction withAction(ChatAction action) {
        return new SendChatAction(businessConnectionId, chatId, messageThreadId, action);
    }
}
