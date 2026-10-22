package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about the chat owner leaving the chat.
 *
 * @param newOwner The user which will be the new owner of the chat if the previous owner does not
 *     return to the chat
 * @see <a href="https://core.telegram.org/bots/api#chatownerleft">ChatOwnerLeft in the Bot API</a>
 */
public record ChatOwnerLeft(
    @JsonProperty("new_owner") @Nullable User newOwner
) {}
