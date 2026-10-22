package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Describes an inline message sent by a Web App on behalf of a user.
 *
 * @param inlineMessageId Identifier of the sent inline message. Available only if there is an
 *     inline keyboard attached to the message.
 * @see <a href="https://core.telegram.org/bots/api#sentwebappmessage">SentWebAppMessage in the Bot API</a>
 */
public record SentWebAppMessage(
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId
) {

    public SentWebAppMessage withInlineMessageId(@Nullable String inlineMessageId) {
        return new SentWebAppMessage(inlineMessageId);
    }
}
