package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Deletes a story previously posted by the bot on behalf of a managed business account. Requires
 * the can_manage_stories business bot right. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param storyId Unique identifier of the story to delete
 * @see <a href="https://core.telegram.org/bots/api#deletestory">deleteStory in the Bot API</a>
 */
public record DeleteStory(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("story_id") long storyId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteStory";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
