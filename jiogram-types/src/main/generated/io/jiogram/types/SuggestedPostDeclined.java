package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about the rejection of a suggested post.
 *
 * @param suggestedPostMessage Message containing the suggested post. Note that the Message object
 *     in this field will not contain the reply_to_message field even if it itself is a reply.
 * @param comment Comment with which the post was declined
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostdeclined">SuggestedPostDeclined in the Bot API</a>
 */
public record SuggestedPostDeclined(
    @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
    @JsonProperty("comment") @Nullable String comment
) {

    public SuggestedPostDeclined withSuggestedPostMessage(@Nullable Message suggestedPostMessage) {
        return new SuggestedPostDeclined(suggestedPostMessage, comment);
    }

    public SuggestedPostDeclined withComment(@Nullable String comment) {
        return new SuggestedPostDeclined(suggestedPostMessage, comment);
    }
}
