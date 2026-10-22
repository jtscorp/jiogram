package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Story;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Reposts a story on behalf of a business account from another business account. Both business
 * accounts must be managed by the same bot, and the story on the source account must have been
 * posted (or reposted) by the bot. Requires the can_manage_stories business bot right for both
 * business accounts. Returns Story on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param fromChatId Unique identifier of the chat which posted the story that should be reposted
 * @param fromStoryId Unique identifier of the story that should be reposted
 * @param activePeriod Period after which the story is moved to the archive, in seconds; must be one
 *     of 6 * 3600, 12 * 3600, 86400, or 2 * 86400
 * @param postToChatPage Pass True to keep the story accessible after it expires
 * @param protectContent Pass True if the content of the story must be protected from forwarding and
 *     screenshotting
 * @see <a href="https://core.telegram.org/bots/api#repoststory">repostStory in the Bot API</a>
 */
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

    public RepostStory withBusinessConnectionId(String businessConnectionId) {
        return new RepostStory(businessConnectionId, fromChatId, fromStoryId, activePeriod, postToChatPage, protectContent);
    }

    public RepostStory withFromChatId(long fromChatId) {
        return new RepostStory(businessConnectionId, fromChatId, fromStoryId, activePeriod, postToChatPage, protectContent);
    }

    public RepostStory withFromStoryId(long fromStoryId) {
        return new RepostStory(businessConnectionId, fromChatId, fromStoryId, activePeriod, postToChatPage, protectContent);
    }

    public RepostStory withActivePeriod(long activePeriod) {
        return new RepostStory(businessConnectionId, fromChatId, fromStoryId, activePeriod, postToChatPage, protectContent);
    }

    public RepostStory withPostToChatPage(@Nullable Boolean postToChatPage) {
        return new RepostStory(businessConnectionId, fromChatId, fromStoryId, activePeriod, postToChatPage, protectContent);
    }

    public RepostStory withProtectContent(@Nullable Boolean protectContent) {
        return new RepostStory(businessConnectionId, fromChatId, fromStoryId, activePeriod, postToChatPage, protectContent);
    }
}
