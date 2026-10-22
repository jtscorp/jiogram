package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputStoryContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.Story;
import io.jiogram.types.StoryArea;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Edits a story previously posted by the bot on behalf of a managed business account. Requires the
 * can_manage_stories business bot right. Returns Story on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#editstory">editStory in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditStory implements TelegramMethod<Story> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("story_id")
    private final long storyId;

    @JsonProperty("content")
    private final InputStoryContent content;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("areas")
    private final @Nullable List<StoryArea> areas;

    /**
     * Creates a new {@code EditStory} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param storyId Unique identifier of the story to edit
     * @param content Content of the story
     * @param caption Caption of the story, 0-2048 characters after entities parsing
     * @param parseMode Mode for parsing entities in the story caption. See formatting options for
     *     more details.
     * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
     *     which can be specified instead of parse_mode
     * @param areas A JSON-serialized list of clickable areas to be shown on the story
     */
    @JsonCreator
    public EditStory(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("story_id") long storyId,
            @JsonProperty("content") InputStoryContent content,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("areas") @Nullable List<StoryArea> areas) {
        this.businessConnectionId = businessConnectionId;
        this.storyId = storyId;
        this.content = content;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.areas = areas;
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

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier of the story to edit
     */
    public long storyId() {
        return storyId;
    }

    /**
     * Content of the story
     */
    public InputStoryContent content() {
        return content;
    }

    /**
     * Caption of the story, 0-2048 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the story caption. See formatting options for more details.
     */
    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    /**
     * A JSON-serialized list of special entities that appear in the caption, which can be specified
     * instead of parse_mode
     */
    public @Nullable List<MessageEntity> captionEntities() {
        return captionEntities;
    }

    /**
     * A JSON-serialized list of clickable areas to be shown on the story
     */
    public @Nullable List<StoryArea> areas() {
        return areas;
    }

    public EditStory withBusinessConnectionId(String businessConnectionId) {
        return new EditStory(businessConnectionId, storyId, content, caption, parseMode, captionEntities, areas);
    }

    public EditStory withStoryId(long storyId) {
        return new EditStory(businessConnectionId, storyId, content, caption, parseMode, captionEntities, areas);
    }

    public EditStory withContent(InputStoryContent content) {
        return new EditStory(businessConnectionId, storyId, content, caption, parseMode, captionEntities, areas);
    }

    public EditStory withCaption(@Nullable String caption) {
        return new EditStory(businessConnectionId, storyId, content, caption, parseMode, captionEntities, areas);
    }

    public EditStory withParseMode(@Nullable ParseMode parseMode) {
        return new EditStory(businessConnectionId, storyId, content, caption, parseMode, captionEntities, areas);
    }

    public EditStory withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new EditStory(businessConnectionId, storyId, content, caption, parseMode, captionEntities, areas);
    }

    public EditStory withAreas(@Nullable List<StoryArea> areas) {
        return new EditStory(businessConnectionId, storyId, content, caption, parseMode, captionEntities, areas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditStory)) {
            return false;
        }
        EditStory that = (EditStory) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && this.storyId == that.storyId
                && Objects.equals(this.content, that.content)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.areas, that.areas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.storyId, this.content, this.caption, this.parseMode, this.captionEntities, this.areas);
    }

    @Override
    public String toString() {
        return "EditStory[businessConnectionId=" + this.businessConnectionId
                + ", storyId=" + this.storyId
                + ", content=" + this.content
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", areas=" + this.areas
                + "]";
    }
}
