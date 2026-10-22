package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * This object represents a service message about a forum topic closed in the chat. Currently holds
 * no information.
 *
 * @see <a href="https://core.telegram.org/bots/api#forumtopicclosed">ForumTopicClosed in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ForumTopicClosed {

    /**
     * Creates a new {@code ForumTopicClosed} instance.
     */
    public ForumTopicClosed() {
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ForumTopicClosed;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "ForumTopicClosed[]";
    }
}
