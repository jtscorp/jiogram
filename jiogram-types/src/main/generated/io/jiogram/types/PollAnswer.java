package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an answer of a user in a non-anonymous poll.
 *
 * @param pollId Unique poll identifier
 * @param voterChat The chat that changed the answer to the poll, if the voter is anonymous
 * @param user The user that changed the answer to the poll, if the voter isn't anonymous
 * @param optionIds 0-based identifiers of chosen answer options. May be empty if the vote was
 *     retracted.
 * @param optionPersistentIds Persistent identifiers of the chosen answer options. May be empty if
 *     the vote was retracted.
 * @see <a href="https://core.telegram.org/bots/api#pollanswer">PollAnswer in the Bot API</a>
 */
public record PollAnswer(
    @JsonProperty("poll_id") String pollId,
    @JsonProperty("voter_chat") @Nullable Chat voterChat,
    @JsonProperty("user") @Nullable User user,
    @JsonProperty("option_ids") List<Long> optionIds,
    @JsonProperty("option_persistent_ids") List<String> optionPersistentIds
) {

    public static PollAnswer of(String pollId, List<Long> optionIds, List<String> optionPersistentIds) {
        return new PollAnswer(pollId, null, null, optionIds, optionPersistentIds);
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
}
