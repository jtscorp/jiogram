package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.Gift;
import io.jiogram.types.TransactionPartnerType;
import org.jspecify.annotations.Nullable;

/**
 * Describes a transaction with a chat.
 *
 * @param type Type of the transaction partner, always 'chat'
 * @param chat Information about the chat
 * @param gift The gift sent to the chat by the bot
 * @see <a href="https://core.telegram.org/bots/api#transactionpartnerchat">TransactionPartnerChat in the Bot API</a>
 */
public record TransactionPartnerChat(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
    @JsonProperty("chat") Chat chat,
    @JsonProperty("gift") @Nullable Gift gift
) implements TransactionPartner {}
