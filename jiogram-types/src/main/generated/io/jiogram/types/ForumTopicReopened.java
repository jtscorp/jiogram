package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * This object represents a service message about a forum topic reopened in the chat. Currently
 * holds no information.
 *
 * @see <a href="https://core.telegram.org/bots/api#forumtopicreopened">ForumTopicReopened in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ForumTopicReopened {

    /**
     * Creates a new {@code ForumTopicReopened} instance.
     */
    public ForumTopicReopened() {
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ForumTopicReopened;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "ForumTopicReopened[]";
    }
}
