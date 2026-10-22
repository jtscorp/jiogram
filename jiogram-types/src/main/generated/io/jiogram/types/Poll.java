package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.PollOption;
import io.jiogram.types.PollType;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about a poll.
 *
 * @param id Unique poll identifier
 * @param question Poll question, 1-300 characters
 * @param questionEntities Special entities that appear in the question. Currently, only custom
 *     emoji entities are allowed in poll questions
 * @param options List of poll options
 * @param totalVoterCount Total number of users that voted in the poll
 * @param isClosed True, if the poll is closed
 * @param isAnonymous True, if the poll is anonymous
 * @param type Poll type, currently can be 'regular' or 'quiz'
 * @param allowsMultipleAnswers True, if the poll allows multiple answers
 * @param allowsRevoting True, if the poll allows to change the chosen answer options
 * @param correctOptionIds Array of 0-based identifiers of the correct answer options. Available
 *     only for polls in quiz mode which are closed or were sent (not forwarded) by the bot or to
 *     the private chat with the bot.
 * @param explanation Text that is shown when a user chooses an incorrect answer or taps on the lamp
 *     icon in a quiz-style poll, 0-200 characters
 * @param explanationEntities Special entities like usernames, URLs, bot commands, etc. that appear
 *     in the explanation
 * @param openPeriod Amount of time in seconds the poll will be active after creation
 * @param closeDate Point in time (Unix timestamp) when the poll will be automatically closed
 * @param description Description of the poll; for polls inside the Message object only
 * @param descriptionEntities Special entities like usernames, URLs, bot commands, etc. that appear
 *     in the description
 * @see <a href="https://core.telegram.org/bots/api#poll">Poll in the Bot API</a>
 */
public record Poll(
    @JsonProperty("id") String id,
    @JsonProperty("question") String question,
    @JsonProperty("question_entities") @Nullable List<MessageEntity> questionEntities,
    @JsonProperty("options") List<PollOption> options,
    @JsonProperty("total_voter_count") long totalVoterCount,
    @JsonProperty("is_closed") boolean isClosed,
    @JsonProperty("is_anonymous") boolean isAnonymous,
    @JsonProperty("type") PollType type,
    @JsonProperty("allows_multiple_answers") boolean allowsMultipleAnswers,
    @JsonProperty("allows_revoting") boolean allowsRevoting,
    @JsonProperty("correct_option_ids") @Nullable List<Long> correctOptionIds,
    @JsonProperty("explanation") @Nullable String explanation,
    @JsonProperty("explanation_entities") @Nullable List<MessageEntity> explanationEntities,
    @JsonProperty("open_period") @Nullable Long openPeriod,
    @JsonProperty("close_date") @Nullable Long closeDate,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("description_entities") @Nullable List<MessageEntity> descriptionEntities
) {}
