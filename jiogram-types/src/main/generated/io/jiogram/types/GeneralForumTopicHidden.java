package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * This object represents a service message about General forum topic hidden in the chat. Currently
 * holds no information.
 *
 * @see <a href="https://core.telegram.org/bots/api#generalforumtopichidden">GeneralForumTopicHidden in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GeneralForumTopicHidden {

    /**
     * Creates a new {@code GeneralForumTopicHidden} instance.
     */
    public GeneralForumTopicHidden() {
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof GeneralForumTopicHidden;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "GeneralForumTopicHidden[]";
    }
}
