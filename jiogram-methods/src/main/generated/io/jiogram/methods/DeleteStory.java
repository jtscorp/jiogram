package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Deletes a story previously posted by the bot on behalf of a managed business account. Requires
 * the can_manage_stories business bot right. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletestory">deleteStory in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeleteStory implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("story_id")
    private final long storyId;

    /**
     * Creates a new {@code DeleteStory} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param storyId Unique identifier of the story to delete
     */
    @JsonCreator
    public DeleteStory(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("story_id") long storyId) {
        this.businessConnectionId = businessConnectionId;
        this.storyId = storyId;
    }

    @Override
    public String apiMethod() {
        return "deleteStory";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier of the story to delete
     */
    public long storyId() {
        return storyId;
    }

    public DeleteStory withBusinessConnectionId(String businessConnectionId) {
        return new DeleteStory(businessConnectionId, storyId);
    }

    public DeleteStory withStoryId(long storyId) {
        return new DeleteStory(businessConnectionId, storyId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeleteStory)) {
            return false;
        }
        DeleteStory that = (DeleteStory) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && this.storyId == that.storyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.storyId);
    }

    @Override
    public String toString() {
        return "DeleteStory[businessConnectionId=" + this.businessConnectionId
                + ", storyId=" + this.storyId
                + "]";
    }
}
