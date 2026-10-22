package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ReactionType;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the chosen reactions on a message. Service messages of some types can't
 * be reacted to. Automatically forwarded messages from a channel to its discussion group have the
 * same available reactions as messages in the channel. Bots can't use paid reactions. Returns True
 * on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageId Identifier of the target message. If the message belongs to a media group, the
 *     reaction is set to the first non-deleted message in the group instead.
 * @param reaction A JSON-serialized list of reaction types to set on the message. Currently, as
 *     non-premium users, bots can set up to one reaction per message. A custom emoji reaction can
 *     be used if it is either already present on the message or explicitly allowed by chat
 *     administrators. Paid reactions can't be used by bots.
 * @param isBig Pass True to set the reaction with a big animation
 * @see <a href="https://core.telegram.org/bots/api#setmessagereaction">setMessageReaction in the Bot API</a>
 */
public record SetMessageReaction(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("reaction") @Nullable List<ReactionType> reaction,
    @JsonProperty("is_big") @Nullable Boolean isBig
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMessageReaction";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMessageReaction of(ChatId chatId, long messageId) {
        return new SetMessageReaction(chatId, messageId, null, null);
    }

    public SetMessageReaction withChatId(ChatId chatId) {
        return new SetMessageReaction(chatId, messageId, reaction, isBig);
    }

    public SetMessageReaction withMessageId(long messageId) {
        return new SetMessageReaction(chatId, messageId, reaction, isBig);
    }

    public SetMessageReaction withReaction(@Nullable List<ReactionType> reaction) {
        return new SetMessageReaction(chatId, messageId, reaction, isBig);
    }

    public SetMessageReaction withIsBig(@Nullable Boolean isBig) {
        return new SetMessageReaction(chatId, messageId, reaction, isBig);
    }
}
