package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputStoryContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.Story;
import io.jiogram.types.StoryArea;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class EditStory implements TelegramMethod<Story> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("story_id") private final long storyId;
    @JsonProperty("content") private final InputStoryContent content;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final String parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("areas") @Nullable private final List<StoryArea> areas;

    @JsonCreator
    public EditStory(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("story_id") long storyId,
            @JsonProperty("content") InputStoryContent content,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable String parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("areas") @Nullable List<StoryArea> areas
    ) {
        this.businessConnectionId = businessConnectionId;
        this.storyId = storyId;
        this.content = content;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.areas = areas;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public long storyId() {
        return this.storyId;
    }

    public InputStoryContent content() {
        return this.content;
    }

    public String caption() {
        return this.caption;
    }

    public String parseMode() {
        return this.parseMode;
    }

    public List<MessageEntity> captionEntities() {
        return this.captionEntities;
    }

    public List<StoryArea> areas() {
        return this.areas;
    }

    @Override
    public String apiMethod() {
        return "editStory";
    }

    @Override
    public String apiReturnType() {
        return "Story";
    }

    public static EditStory of(String businessConnectionId, long storyId, InputStoryContent content) {
        return new EditStory(businessConnectionId, storyId, content, null, null, null, null);
    }
}
