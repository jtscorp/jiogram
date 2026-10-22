package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaybeInaccessibleMessage;
import io.jiogram.types.MessageEntity;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about an option added to a poll.
 *
 * @see <a href="https://core.telegram.org/bots/api#polloptionadded">PollOptionAdded in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PollOptionAdded {

    @JsonProperty("poll_message")
    private final @Nullable MaybeInaccessibleMessage pollMessage;

    @JsonProperty("option_persistent_id")
    private final String optionPersistentId;

    @JsonProperty("option_text")
    private final String optionText;

    @JsonProperty("option_text_entities")
    private final @Nullable List<MessageEntity> optionTextEntities;

    /**
     * Creates a new {@code PollOptionAdded} instance.
     *
     * @param pollMessage Message containing the poll to which the option was added, if known. Note
     *     that the Message object in this field will not contain the reply_to_message field even if
     *     it itself is a reply.
     * @param optionPersistentId Unique identifier of the added option
     * @param optionText Option text
     * @param optionTextEntities Special entities that appear in the option_text
     */
    @JsonCreator
    public PollOptionAdded(
            @JsonProperty("poll_message") @Nullable MaybeInaccessibleMessage pollMessage,
            @JsonProperty("option_persistent_id") String optionPersistentId,
            @JsonProperty("option_text") String optionText,
            @JsonProperty("option_text_entities") @Nullable List<MessageEntity> optionTextEntities) {
        this.pollMessage = pollMessage;
        this.optionPersistentId = optionPersistentId;
        this.optionText = optionText;
        this.optionTextEntities = optionTextEntities;
    }

    public static PollOptionAdded of(String optionPersistentId, String optionText) {
        return new PollOptionAdded(null, optionPersistentId, optionText, null);
    }

    /**
     * Message containing the poll to which the option was added, if known. Note that the Message
     * object in this field will not contain the reply_to_message field even if it itself is a
     * reply.
     */
    public @Nullable MaybeInaccessibleMessage pollMessage() {
        return pollMessage;
    }

    /**
     * Unique identifier of the added option
     */
    public String optionPersistentId() {
        return optionPersistentId;
    }

    /**
     * Option text
     */
    public String optionText() {
        return optionText;
    }

    /**
     * Special entities that appear in the option_text
     */
    public @Nullable List<MessageEntity> optionTextEntities() {
        return optionTextEntities;
    }

    public PollOptionAdded withPollMessage(@Nullable MaybeInaccessibleMessage pollMessage) {
        return new PollOptionAdded(pollMessage, optionPersistentId, optionText, optionTextEntities);
    }

    public PollOptionAdded withOptionPersistentId(String optionPersistentId) {
        return new PollOptionAdded(pollMessage, optionPersistentId, optionText, optionTextEntities);
    }

    public PollOptionAdded withOptionText(String optionText) {
        return new PollOptionAdded(pollMessage, optionPersistentId, optionText, optionTextEntities);
    }

    public PollOptionAdded withOptionTextEntities(@Nullable List<MessageEntity> optionTextEntities) {
        return new PollOptionAdded(pollMessage, optionPersistentId, optionText, optionTextEntities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PollOptionAdded)) {
            return false;
        }
        PollOptionAdded that = (PollOptionAdded) o;
        return Objects.equals(this.pollMessage, that.pollMessage)
                && Objects.equals(this.optionPersistentId, that.optionPersistentId)
                && Objects.equals(this.optionText, that.optionText)
                && Objects.equals(this.optionTextEntities, that.optionTextEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pollMessage, this.optionPersistentId, this.optionText, this.optionTextEntities);
    }

    @Override
    public String toString() {
        return "PollOptionAdded[pollMessage=" + this.pollMessage
                + ", optionPersistentId=" + this.optionPersistentId
                + ", optionText=" + this.optionText
                + ", optionTextEntities=" + this.optionTextEntities
                + "]";
    }
}
