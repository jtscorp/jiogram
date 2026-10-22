package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.SuggestedPostPrice;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about the approval of a suggested post.
 *
 * @param suggestedPostMessage Message containing the suggested post. Note that the Message object
 *     in this field will not contain the reply_to_message field even if it itself is a reply.
 * @param price Amount paid for the post
 * @param sendDate Date when the post will be published
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostapproved">SuggestedPostApproved in the Bot API</a>
 */
public record SuggestedPostApproved(
    @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
    @JsonProperty("price") @Nullable SuggestedPostPrice price,
    @JsonProperty("send_date") long sendDate
) {

    public static SuggestedPostApproved of(long sendDate) {
        return new SuggestedPostApproved(null, null, sendDate);
    }

    public SuggestedPostApproved withSuggestedPostMessage(@Nullable Message suggestedPostMessage) {
        return new SuggestedPostApproved(suggestedPostMessage, price, sendDate);
    }

    public SuggestedPostApproved withPrice(@Nullable SuggestedPostPrice price) {
        return new SuggestedPostApproved(suggestedPostMessage, price, sendDate);
    }

    public SuggestedPostApproved withSendDate(long sendDate) {
        return new SuggestedPostApproved(suggestedPostMessage, price, sendDate);
    }
}
