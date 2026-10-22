package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import java.util.Objects;

/**
 * This object represents a story.
 *
 * @see <a href="https://core.telegram.org/bots/api#story">Story in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Story {

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("id")
    private final long id;

    /**
     * Creates a new {@code Story} instance.
     *
     * @param chat Chat that posted the story
     * @param id Unique identifier for the story in the chat
     */
    @JsonCreator
    public Story(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("id") long id) {
        this.chat = chat;
        this.id = id;
    }

    /**
     * Chat that posted the story
     */
    public Chat chat() {
        return chat;
    }

    /**
     * Unique identifier for the story in the chat
     */
    public long id() {
        return id;
    }

    public Story withChat(Chat chat) {
        return new Story(chat, id);
    }

    public Story withId(long id) {
        return new Story(chat, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Story)) {
            return false;
        }
        Story that = (Story) o;
        return Objects.equals(this.chat, that.chat)
                && this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chat, this.id);
    }

    @Override
    public String toString() {
        return "Story[chat=" + this.chat
                + ", id=" + this.id
                + "]";
    }
}
