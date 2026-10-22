package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * This object represents a service message about General forum topic unhidden in the chat.
 * Currently holds no information.
 *
 * @see <a href="https://core.telegram.org/bots/api#generalforumtopicunhidden">GeneralForumTopicUnhidden in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GeneralForumTopicUnhidden {

    /**
     * Creates a new {@code GeneralForumTopicUnhidden} instance.
     */
    public GeneralForumTopicUnhidden() {
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof GeneralForumTopicUnhidden;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "GeneralForumTopicUnhidden[]";
    }
}
