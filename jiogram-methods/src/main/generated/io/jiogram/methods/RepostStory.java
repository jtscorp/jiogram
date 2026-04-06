package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Story;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record RepostStory(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("from_chat_id") long fromChatId,
    @JsonProperty("from_story_id") long fromStoryId,
    @JsonProperty("active_period") long activePeriod,
    @JsonProperty("post_to_chat_page") @Nullable Boolean postToChatPage,
    @JsonProperty("protect_content") @Nullable Boolean protectContent
) implements TelegramMethod<Story> {

    @Override
    public String apiMethod() {
        return "repostStory";
    }

    @Override
    public String apiReturnType() {
        return "Story";
    }

    public static RepostStory of(String businessConnectionId, long fromChatId, long fromStoryId, long activePeriod) {
        return new RepostStory(businessConnectionId, fromChatId, fromStoryId, activePeriod, null, null);
    }
}
