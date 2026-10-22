package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Describes a topic of a direct messages chat.
 *
 * @param topicId Unique identifier of the topic. This number may have more than 32 significant bits
 *     and some programming languages may have difficulty/silent defects in interpreting it. But it
 *     has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe
 *     for storing this identifier.
 * @param user Information about the user that created the topic. Currently, it is always present
 * @see <a href="https://core.telegram.org/bots/api#directmessagestopic">DirectMessagesTopic in the Bot API</a>
 */
public record DirectMessagesTopic(
    @JsonProperty("topic_id") long topicId,
    @JsonProperty("user") @Nullable User user
) {

    public static DirectMessagesTopic of(long topicId) {
        return new DirectMessagesTopic(topicId, null);
    }

    public DirectMessagesTopic withTopicId(long topicId) {
        return new DirectMessagesTopic(topicId, user);
    }

    public DirectMessagesTopic withUser(@Nullable User user) {
        return new DirectMessagesTopic(topicId, user);
    }
}
