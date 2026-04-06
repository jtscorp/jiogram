package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputStoryContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.Story;
import io.jiogram.types.StoryArea;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record EditStory(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("story_id") long storyId,
    @JsonProperty("content") InputStoryContent content,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable String parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("areas") @Nullable List<StoryArea> areas
) implements TelegramMethod<Story> {

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
