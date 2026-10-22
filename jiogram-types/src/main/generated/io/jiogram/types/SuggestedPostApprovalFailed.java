package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.SuggestedPostPrice;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about the failed approval of a suggested post. Currently, only caused
 * by insufficient user funds at the time of approval.
 *
 * @param suggestedPostMessage Message containing the suggested post whose approval has failed. Note
 *     that the Message object in this field will not contain the reply_to_message field even if it
 *     itself is a reply.
 * @param price Expected price of the post
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostapprovalfailed">SuggestedPostApprovalFailed in the Bot API</a>
 */
public record SuggestedPostApprovalFailed(
    @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
    @JsonProperty("price") SuggestedPostPrice price
) {

    public static SuggestedPostApprovalFailed of(SuggestedPostPrice price) {
        return new SuggestedPostApprovalFailed(null, price);
    }

    public SuggestedPostApprovalFailed withSuggestedPostMessage(@Nullable Message suggestedPostMessage) {
        return new SuggestedPostApprovalFailed(suggestedPostMessage, price);
    }

    public SuggestedPostApprovalFailed withPrice(SuggestedPostPrice price) {
        return new SuggestedPostApprovalFailed(suggestedPostMessage, price);
    }
}
