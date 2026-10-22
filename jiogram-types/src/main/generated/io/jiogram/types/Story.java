package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;

/**
 * This object represents a story.
 *
 * @param chat Chat that posted the story
 * @param id Unique identifier for the story in the chat
 * @see <a href="https://core.telegram.org/bots/api#story">Story in the Bot API</a>
 */
public record Story(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("id") long id
) {

    public Story withChat(Chat chat) {
        return new Story(chat, id);
    }

    public Story withId(long id) {
        return new Story(chat, id);
    }
}
