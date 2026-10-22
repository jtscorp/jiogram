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
 * Posts a story on behalf of a managed business account. Requires the can_manage_stories business
 * bot right. Returns Story on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#poststory">postStory in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PostStory implements TelegramMethod<Story> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("content")
    private final InputStoryContent content;

    @JsonProperty("active_period")
    private final long activePeriod;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("areas")
    private final @Nullable List<StoryArea> areas;

    @JsonProperty("post_to_chat_page")
    private final @Nullable Boolean postToChatPage;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    /**
     * Creates a new {@code PostStory} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param content Content of the story
     * @param activePeriod Period after which the story is moved to the archive, in seconds; must be
     *     one of 6 * 3600, 12 * 3600, 86400, or 2 * 86400
     * @param caption Caption of the story, 0-2048 characters after entities parsing
     * @param parseMode Mode for parsing entities in the story caption. See formatting options for
     *     more details.
     * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
     *     which can be specified instead of parse_mode
     * @param areas A JSON-serialized list of clickable areas to be shown on the story
     * @param postToChatPage Pass True to keep the story accessible after it expires
     * @param protectContent Pass True if the content of the story must be protected from forwarding
     *     and screenshotting
     */
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
            @JsonProperty("protect_content") @Nullable Boolean protectContent) {
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

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Content of the story
     */
    public InputStoryContent content() {
        return content;
    }

    /**
     * Period after which the story is moved to the archive, in seconds; must be one of 6 * 3600, 12
     * * 3600, 86400, or 2 * 86400
     */
    public long activePeriod() {
        return activePeriod;
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

    /**
     * Pass True to keep the story accessible after it expires
     */
    public @Nullable Boolean postToChatPage() {
        return postToChatPage;
    }

    /**
     * Pass True if the content of the story must be protected from forwarding and screenshotting
     */
    public @Nullable Boolean protectContent() {
        return protectContent;
    }

    public PostStory withBusinessConnectionId(String businessConnectionId) {
        return new PostStory(businessConnectionId, content, activePeriod, caption, parseMode, captionEntities, areas, postToChatPage, protectContent);
    }

    public PostStory withContent(InputStoryContent content) {
        return new PostStory(businessConnectionId, content, activePeriod, caption, parseMode, captionEntities, areas, postToChatPage, protectContent);
    }

    public PostStory withActivePeriod(long activePeriod) {
        return new PostStory(businessConnectionId, content, activePeriod, caption, parseMode, captionEntities, areas, postToChatPage, protectContent);
    }

    public PostStory withCaption(@Nullable String caption) {
        return new PostStory(businessConnectionId, content, activePeriod, caption, parseMode, captionEntities, areas, postToChatPage, protectContent);
    }

    public PostStory withParseMode(@Nullable ParseMode parseMode) {
        return new PostStory(businessConnectionId, content, activePeriod, caption, parseMode, captionEntities, areas, postToChatPage, protectContent);
    }

    public PostStory withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new PostStory(businessConnectionId, content, activePeriod, caption, parseMode, captionEntities, areas, postToChatPage, protectContent);
    }

    public PostStory withAreas(@Nullable List<StoryArea> areas) {
        return new PostStory(businessConnectionId, content, activePeriod, caption, parseMode, captionEntities, areas, postToChatPage, protectContent);
    }

    public PostStory withPostToChatPage(@Nullable Boolean postToChatPage) {
        return new PostStory(businessConnectionId, content, activePeriod, caption, parseMode, captionEntities, areas, postToChatPage, protectContent);
    }

    public PostStory withProtectContent(@Nullable Boolean protectContent) {
        return new PostStory(businessConnectionId, content, activePeriod, caption, parseMode, captionEntities, areas, postToChatPage, protectContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PostStory)) {
            return false;
        }
        PostStory that = (PostStory) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.content, that.content)
                && this.activePeriod == that.activePeriod
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.areas, that.areas)
                && Objects.equals(this.postToChatPage, that.postToChatPage)
                && Objects.equals(this.protectContent, that.protectContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.content, this.activePeriod, this.caption, this.parseMode, this.captionEntities, this.areas, this.postToChatPage, this.protectContent);
    }

    @Override
    public String toString() {
        return "PostStory[businessConnectionId=" + this.businessConnectionId
                + ", content=" + this.content
                + ", activePeriod=" + this.activePeriod
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", areas=" + this.areas
                + ", postToChatPage=" + this.postToChatPage
                + ", protectContent=" + this.protectContent
                + "]";
    }
}
