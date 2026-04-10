package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class DirectMessagePriceChanged {
    @JsonProperty("are_direct_messages_enabled") private final boolean areDirectMessagesEnabled;
    @JsonProperty("direct_message_star_count") @Nullable private final Long directMessageStarCount;

    @JsonCreator
    public DirectMessagePriceChanged(
            @JsonProperty("are_direct_messages_enabled") boolean areDirectMessagesEnabled,
            @JsonProperty("direct_message_star_count") @Nullable Long directMessageStarCount
    ) {
        this.areDirectMessagesEnabled = areDirectMessagesEnabled;
        this.directMessageStarCount = directMessageStarCount;
    }

    public boolean areDirectMessagesEnabled() {
        return this.areDirectMessagesEnabled;
    }

    public Long directMessageStarCount() {
        return this.directMessageStarCount;
    }
}
