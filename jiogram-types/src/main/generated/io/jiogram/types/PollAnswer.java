package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an answer of a user in a non-anonymous poll.
 *
 * @see <a href="https://core.telegram.org/bots/api#pollanswer">PollAnswer in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PollAnswer {

    @JsonProperty("poll_id")
    private final String pollId;

    @JsonProperty("voter_chat")
    private final @Nullable Chat voterChat;

    @JsonProperty("user")
    private final @Nullable User user;

    @JsonProperty("option_ids")
    private final List<Long> optionIds;

    @JsonProperty("option_persistent_ids")
    private final List<String> optionPersistentIds;

    /**
     * Creates a new {@code PollAnswer} instance.
     *
     * @param pollId Unique poll identifier
     * @param voterChat The chat that changed the answer to the poll, if the voter is anonymous
     * @param user The user that changed the answer to the poll, if the voter isn't anonymous
     * @param optionIds 0-based identifiers of chosen answer options. May be empty if the vote was
     *     retracted.
     * @param optionPersistentIds Persistent identifiers of the chosen answer options. May be empty
     *     if the vote was retracted.
     */
    @JsonCreator
    public PollAnswer(
            @JsonProperty("poll_id") String pollId,
            @JsonProperty("voter_chat") @Nullable Chat voterChat,
            @JsonProperty("user") @Nullable User user,
            @JsonProperty("option_ids") List<Long> optionIds,
            @JsonProperty("option_persistent_ids") List<String> optionPersistentIds) {
        this.pollId = pollId;
        this.voterChat = voterChat;
        this.user = user;
        this.optionIds = optionIds;
        this.optionPersistentIds = optionPersistentIds;
    }

    public static PollAnswer of(String pollId, List<Long> optionIds, List<String> optionPersistentIds) {
        return new PollAnswer(pollId, null, null, optionIds, optionPersistentIds);
    }

    /**
     * Unique poll identifier
     */
    public String pollId() {
        return pollId;
    }

    /**
     * The chat that changed the answer to the poll, if the voter is anonymous
     */
    public @Nullable Chat voterChat() {
        return voterChat;
    }

    /**
     * The user that changed the answer to the poll, if the voter isn't anonymous
     */
    public @Nullable User user() {
        return user;
    }

    /**
     * 0-based identifiers of chosen answer options. May be empty if the vote was retracted.
     */
    public List<Long> optionIds() {
        return optionIds;
    }

    /**
     * Persistent identifiers of the chosen answer options. May be empty if the vote was retracted.
     */
    public List<String> optionPersistentIds() {
        return optionPersistentIds;
    }

    public PollAnswer withPollId(String pollId) {
        return new PollAnswer(pollId, voterChat, user, optionIds, optionPersistentIds);
    }

    public PollAnswer withVoterChat(@Nullable Chat voterChat) {
        return new PollAnswer(pollId, voterChat, user, optionIds, optionPersistentIds);
    }

    public PollAnswer withUser(@Nullable User user) {
        return new PollAnswer(pollId, voterChat, user, optionIds, optionPersistentIds);
    }

    public PollAnswer withOptionIds(List<Long> optionIds) {
        return new PollAnswer(pollId, voterChat, user, optionIds, optionPersistentIds);
    }

    public PollAnswer withOptionPersistentIds(List<String> optionPersistentIds) {
        return new PollAnswer(pollId, voterChat, user, optionIds, optionPersistentIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PollAnswer)) {
            return false;
        }
        PollAnswer that = (PollAnswer) o;
        return Objects.equals(this.pollId, that.pollId)
                && Objects.equals(this.voterChat, that.voterChat)
                && Objects.equals(this.user, that.user)
                && Objects.equals(this.optionIds, that.optionIds)
                && Objects.equals(this.optionPersistentIds, that.optionPersistentIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pollId, this.voterChat, this.user, this.optionIds, this.optionPersistentIds);
    }

    @Override
    public String toString() {
        return "PollAnswer[pollId=" + this.pollId
                + ", voterChat=" + this.voterChat
                + ", user=" + this.user
                + ", optionIds=" + this.optionIds
                + ", optionPersistentIds=" + this.optionPersistentIds
                + "]";
    }
}
