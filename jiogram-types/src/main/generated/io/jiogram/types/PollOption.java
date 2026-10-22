package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.User;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about one answer option in a poll.
 *
 * @see <a href="https://core.telegram.org/bots/api#polloption">PollOption in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PollOption {

    @JsonProperty("persistent_id")
    private final String persistentId;

    @JsonProperty("text")
    private final String text;

    @JsonProperty("text_entities")
    private final @Nullable List<MessageEntity> textEntities;

    @JsonProperty("voter_count")
    private final long voterCount;

    @JsonProperty("added_by_user")
    private final @Nullable User addedByUser;

    @JsonProperty("added_by_chat")
    private final @Nullable Chat addedByChat;

    @JsonProperty("addition_date")
    private final @Nullable Long additionDate;

    /**
     * Creates a new {@code PollOption} instance.
     *
     * @param persistentId Unique identifier of the option, persistent on option addition and
     *     deletion
     * @param text Option text, 1-100 characters
     * @param textEntities Special entities that appear in the option text. Currently, only custom
     *     emoji entities are allowed in poll option texts
     * @param voterCount Number of users who voted for this option; may be 0 if unknown
     * @param addedByUser User who added the option; omitted if the option wasn't added by a user
     *     after poll creation
     * @param addedByChat Chat that added the option; omitted if the option wasn't added by a chat
     *     after poll creation
     * @param additionDate Point in time (Unix timestamp) when the option was added; omitted if the
     *     option existed in the original poll
     */
    @JsonCreator
    public PollOption(
            @JsonProperty("persistent_id") String persistentId,
            @JsonProperty("text") String text,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
            @JsonProperty("voter_count") long voterCount,
            @JsonProperty("added_by_user") @Nullable User addedByUser,
            @JsonProperty("added_by_chat") @Nullable Chat addedByChat,
            @JsonProperty("addition_date") @Nullable Long additionDate) {
        this.persistentId = persistentId;
        this.text = text;
        this.textEntities = textEntities;
        this.voterCount = voterCount;
        this.addedByUser = addedByUser;
        this.addedByChat = addedByChat;
        this.additionDate = additionDate;
    }

    public static PollOption of(String persistentId, String text, long voterCount) {
        return new PollOption(persistentId, text, null, voterCount, null, null, null);
    }

    /**
     * Unique identifier of the option, persistent on option addition and deletion
     */
    public String persistentId() {
        return persistentId;
    }

    /**
     * Option text, 1-100 characters
     */
    public String text() {
        return text;
    }

    /**
     * Special entities that appear in the option text. Currently, only custom emoji entities are
     * allowed in poll option texts
     */
    public @Nullable List<MessageEntity> textEntities() {
        return textEntities;
    }

    /**
     * Number of users who voted for this option; may be 0 if unknown
     */
    public long voterCount() {
        return voterCount;
    }

    /**
     * User who added the option; omitted if the option wasn't added by a user after poll creation
     */
    public @Nullable User addedByUser() {
        return addedByUser;
    }

    /**
     * Chat that added the option; omitted if the option wasn't added by a chat after poll creation
     */
    public @Nullable Chat addedByChat() {
        return addedByChat;
    }

    /**
     * Point in time (Unix timestamp) when the option was added; omitted if the option existed in
     * the original poll
     */
    public @Nullable Long additionDate() {
        return additionDate;
    }

    public PollOption withPersistentId(String persistentId) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withText(String text) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withTextEntities(@Nullable List<MessageEntity> textEntities) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withVoterCount(long voterCount) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withAddedByUser(@Nullable User addedByUser) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withAddedByChat(@Nullable Chat addedByChat) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withAdditionDate(@Nullable Long additionDate) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PollOption)) {
            return false;
        }
        PollOption that = (PollOption) o;
        return Objects.equals(this.persistentId, that.persistentId)
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.textEntities, that.textEntities)
                && this.voterCount == that.voterCount
                && Objects.equals(this.addedByUser, that.addedByUser)
                && Objects.equals(this.addedByChat, that.addedByChat)
                && Objects.equals(this.additionDate, that.additionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.persistentId, this.text, this.textEntities, this.voterCount, this.addedByUser, this.addedByChat, this.additionDate);
    }

    @Override
    public String toString() {
        return "PollOption[persistentId=" + this.persistentId
                + ", text=" + this.text
                + ", textEntities=" + this.textEntities
                + ", voterCount=" + this.voterCount
                + ", addedByUser=" + this.addedByUser
                + ", addedByChat=" + this.addedByChat
                + ", additionDate=" + this.additionDate
                + "]";
    }
}
