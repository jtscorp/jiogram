package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record DirectMessagePriceChanged(
    @JsonProperty("are_direct_messages_enabled") boolean areDirectMessagesEnabled,
    @JsonProperty("direct_message_star_count") @Nullable Long directMessageStarCount
) {}
