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
 * Posts a story on behalf of a managed business account. Requires the can_manage_stories business
 * bot right. Returns Story on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param content Content of the story
 * @param activePeriod Period after which the story is moved to the archive, in seconds; must be one
 *     of 6 * 3600, 12 * 3600, 86400, or 2 * 86400
 * @param caption Caption of the story, 0-2048 characters after entities parsing
 * @param parseMode Mode for parsing entities in the story caption. See formatting options for more
 *     details.
 * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
 *     which can be specified instead of parse_mode
 * @param areas A JSON-serialized list of clickable areas to be shown on the story
 * @param postToChatPage Pass True to keep the story accessible after it expires
 * @param protectContent Pass True if the content of the story must be protected from forwarding and
 *     screenshotting
 * @see <a href="https://core.telegram.org/bots/api#poststory">postStory in the Bot API</a>
 */
public record PostStory(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("content") InputStoryContent content,
    @JsonProperty("active_period") long activePeriod,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("areas") @Nullable List<StoryArea> areas,
    @JsonProperty("post_to_chat_page") @Nullable Boolean postToChatPage,
    @JsonProperty("protect_content") @Nullable Boolean protectContent
) implements TelegramMethod<Story> {

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
}
