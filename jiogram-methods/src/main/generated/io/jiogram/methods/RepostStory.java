package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Story;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Reposts a story on behalf of a business account from another business account. Both business
 * accounts must be managed by the same bot, and the story on the source account must have been
 * posted (or reposted) by the bot. Requires the can_manage_stories business bot right for both
 * business accounts. Returns Story on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#repoststory">repostStory in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RepostStory implements TelegramMethod<Story> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("from_chat_id")
    private final long fromChatId;

    @JsonProperty("from_story_id")
    private final long fromStoryId;

    @JsonProperty("active_period")
    private final long activePeriod;

    @JsonProperty("post_to_chat_page")
    private final @Nullable Boolean postToChatPage;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    /**
     * Creates a new {@code RepostStory} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param fromChatId Unique identifier of the chat which posted the story that should be
     *     reposted
     * @param fromStoryId Unique identifier of the story that should be reposted
     * @param activePeriod Period after which the story is moved to the archive, in seconds; must be
     *     one of 6 * 3600, 12 * 3600, 86400, or 2 * 86400
     * @param postToChatPage Pass True to keep the story accessible after it expires
     * @param protectContent Pass True if the content of the story must be protected from forwarding
     *     and screenshotting
     */
    @JsonCreator
    public RepostStory(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("from_chat_id") long fromChatId,
            @JsonProperty("from_story_id") long fromStoryId,
            @JsonProperty("active_period") long activePeriod,
            @JsonProperty("post_to_chat_page") @Nullable Boolean postToChatPage,
            @JsonProperty("protect_content") @Nullable Boolean protectContent) {
        this.businessConnectionId = businessConnectionId;
        this.fromChatId = fromChatId;
        this.fromStoryId = fromStoryId;
        this.activePeriod = activePeriod;
        this.postToChatPage = postToChatPage;
        this.protectContent = protectContent;
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

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier of the chat which posted the story that should be reposted
     */
    public long fromChatId() {
        return fromChatId;
    }

    /**
     * Unique identifier of the story that should be reposted
     */
    public long fromStoryId() {
        return fromStoryId;
    }

    /**
     * Period after which the story is moved to the archive, in seconds; must be one of 6 * 3600, 12
     * * 3600, 86400, or 2 * 86400
     */
    public long activePeriod() {
        return activePeriod;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RepostStory)) {
            return false;
        }
        RepostStory that = (RepostStory) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && this.fromChatId == that.fromChatId
                && this.fromStoryId == that.fromStoryId
                && this.activePeriod == that.activePeriod
                && Objects.equals(this.postToChatPage, that.postToChatPage)
                && Objects.equals(this.protectContent, that.protectContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.fromChatId, this.fromStoryId, this.activePeriod, this.postToChatPage, this.protectContent);
    }

    @Override
    public String toString() {
        return "RepostStory[businessConnectionId=" + this.businessConnectionId
                + ", fromChatId=" + this.fromChatId
                + ", fromStoryId=" + this.fromStoryId
                + ", activePeriod=" + this.activePeriod
                + ", postToChatPage=" + this.postToChatPage
                + ", protectContent=" + this.protectContent
                + "]";
    }
}
