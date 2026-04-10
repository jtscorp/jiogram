package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Story;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class RepostStory implements TelegramMethod<Story> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("from_chat_id") private final long fromChatId;
    @JsonProperty("from_story_id") private final long fromStoryId;
    @JsonProperty("active_period") private final long activePeriod;
    @JsonProperty("post_to_chat_page") @Nullable private final Boolean postToChatPage;
    @JsonProperty("protect_content") @Nullable private final Boolean protectContent;

    @JsonCreator
    public RepostStory(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("from_chat_id") long fromChatId,
            @JsonProperty("from_story_id") long fromStoryId,
            @JsonProperty("active_period") long activePeriod,
            @JsonProperty("post_to_chat_page") @Nullable Boolean postToChatPage,
            @JsonProperty("protect_content") @Nullable Boolean protectContent
    ) {
        this.businessConnectionId = businessConnectionId;
        this.fromChatId = fromChatId;
        this.fromStoryId = fromStoryId;
        this.activePeriod = activePeriod;
        this.postToChatPage = postToChatPage;
        this.protectContent = protectContent;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public long fromChatId() {
        return this.fromChatId;
    }

    public long fromStoryId() {
        return this.fromStoryId;
    }

    public long activePeriod() {
        return this.activePeriod;
    }

    public Boolean postToChatPage() {
        return this.postToChatPage;
    }

    public Boolean protectContent() {
        return this.protectContent;
    }

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
