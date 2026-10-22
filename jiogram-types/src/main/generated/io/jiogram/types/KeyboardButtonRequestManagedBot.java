package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object defines the parameters for the creation of a managed bot. Information about the
 * created bot will be shared with the bot using the update managed_bot and a Message with the field
 * managed_bot_created.
 *
 * @param requestId Signed 32-bit identifier of the request. Must be unique within the message
 * @param suggestedName Suggested name for the bot
 * @param suggestedUsername Suggested username for the bot
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestmanagedbot">KeyboardButtonRequestManagedBot in the Bot API</a>
 */
public record KeyboardButtonRequestManagedBot(
    @JsonProperty("request_id") long requestId,
    @JsonProperty("suggested_name") @Nullable String suggestedName,
    @JsonProperty("suggested_username") @Nullable String suggestedUsername
) {}
