package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputStoryContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.Story;
import io.jiogram.types.StoryArea;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Edits a story previously posted by the bot on behalf of a managed business account. Requires the
 * can_manage_stories business bot right. Returns Story on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param storyId Unique identifier of the story to edit
 * @param content Content of the story
 * @param caption Caption of the story, 0-2048 characters after entities parsing
 * @param parseMode Mode for parsing entities in the story caption. See formatting options for more
 *     details.
 * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
 *     which can be specified instead of parse_mode
 * @param areas A JSON-serialized list of clickable areas to be shown on the story
 * @see <a href="https://core.telegram.org/bots/api#editstory">editStory in the Bot API</a>
 */
public record EditStory(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("story_id") long storyId,
    @JsonProperty("content") InputStoryContent content,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
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
