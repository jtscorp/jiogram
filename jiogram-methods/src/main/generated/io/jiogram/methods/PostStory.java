package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputStoryContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.Story;
import io.jiogram.types.StoryArea;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class PostStory implements TelegramMethod<Story> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("content") private final InputStoryContent content;
    @JsonProperty("active_period") private final long activePeriod;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final ParseMode parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("areas") @Nullable private final List<StoryArea> areas;
    @JsonProperty("post_to_chat_page") @Nullable private final Boolean postToChatPage;
    @JsonProperty("protect_content") @Nullable private final Boolean protectContent;

    @JsonCreator
    public PostStory(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("content") InputStoryContent content,
            @JsonProperty("active_period") long activePeriod,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("areas") @Nullable List<StoryArea> areas,
            @JsonProperty("post_to_chat_page") @Nullable Boolean postToChatPage,
            @JsonProperty("protect_content") @Nullable Boolean protectContent
    ) {
        this.businessConnectionId = businessConnectionId;
        this.content = content;
        this.activePeriod = activePeriod;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.areas = areas;
        this.postToChatPage = postToChatPage;
        this.protectContent = protectContent;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public InputStoryContent content() {
        return this.content;
    }

    public long activePeriod() {
        return this.activePeriod;
    }

    public String caption() {
        return this.caption;
    }

    public ParseMode parseMode() {
        return this.parseMode;
    }

    public List<MessageEntity> captionEntities() {
        return this.captionEntities;
    }

    public List<StoryArea> areas() {
        return this.areas;
    }

    public Boolean postToChatPage() {
        return this.postToChatPage;
    }

    public Boolean protectContent() {
        return this.protectContent;
    }

    @Override
    public String apiMethod() {
        return "postStory";
    }

    @Override
    public String apiReturnType() {
        return "Story";
    }

    public static PostStory of(String businessConnectionId, InputStoryContent content, long activePeriod) {
        return new PostStory(businessConnectionId, content, activePeriod, null, null, null, null, null, null);
    }
}
