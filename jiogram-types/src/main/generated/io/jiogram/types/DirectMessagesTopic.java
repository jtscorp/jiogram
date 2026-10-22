package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a topic of a direct messages chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#directmessagestopic">DirectMessagesTopic in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DirectMessagesTopic {

    @JsonProperty("topic_id")
    private final long topicId;

    @JsonProperty("user")
    private final @Nullable User user;

    /**
     * Creates a new {@code DirectMessagesTopic} instance.
     *
     * @param topicId Unique identifier of the topic. This number may have more than 32 significant
     *     bits and some programming languages may have difficulty/silent defects in interpreting
     *     it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float
     *     type are safe for storing this identifier.
     * @param user Information about the user that created the topic. Currently, it is always
     *     present
     */
    @JsonCreator
    public DirectMessagesTopic(
            @JsonProperty("topic_id") long topicId,
            @JsonProperty("user") @Nullable User user) {
        this.topicId = topicId;
        this.user = user;
    }

    public static DirectMessagesTopic of(long topicId) {
        return new DirectMessagesTopic(topicId, null);
    }

    /**
     * Unique identifier of the topic. This number may have more than 32 significant bits and some
     * programming languages may have difficulty/silent defects in interpreting it. But it has at
     * most 52 significant bits, so a 64-bit integer or double-precision float type are safe for
     * storing this identifier.
     */
    public long topicId() {
        return topicId;
    }

    /**
     * Information about the user that created the topic. Currently, it is always present
     */
    public @Nullable User user() {
        return user;
    }

    public DirectMessagesTopic withTopicId(long topicId) {
        return new DirectMessagesTopic(topicId, user);
    }

    public DirectMessagesTopic withUser(@Nullable User user) {
        return new DirectMessagesTopic(topicId, user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DirectMessagesTopic)) {
            return false;
        }
        DirectMessagesTopic that = (DirectMessagesTopic) o;
        return this.topicId == that.topicId
                && Objects.equals(this.user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.topicId, this.user);
    }

    @Override
    public String toString() {
        return "DirectMessagesTopic[topicId=" + this.topicId
                + ", user=" + this.user
                + "]";
    }
}
