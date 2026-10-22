package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.PollOption;
import io.jiogram.types.PollType;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about a poll.
 *
 * @see <a href="https://core.telegram.org/bots/api#poll">Poll in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Poll {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("question")
    private final String question;

    @JsonProperty("question_entities")
    private final @Nullable List<MessageEntity> questionEntities;

    @JsonProperty("options")
    private final List<PollOption> options;

    @JsonProperty("total_voter_count")
    private final long totalVoterCount;

    @JsonProperty("is_closed")
    private final boolean isClosed;

    @JsonProperty("is_anonymous")
    private final boolean isAnonymous;

    @JsonProperty("type")
    private final PollType type;

    @JsonProperty("allows_multiple_answers")
    private final boolean allowsMultipleAnswers;

    @JsonProperty("allows_revoting")
    private final boolean allowsRevoting;

    @JsonProperty("correct_option_ids")
    private final @Nullable List<Long> correctOptionIds;

    @JsonProperty("explanation")
    private final @Nullable String explanation;

    @JsonProperty("explanation_entities")
    private final @Nullable List<MessageEntity> explanationEntities;

    @JsonProperty("open_period")
    private final @Nullable Long openPeriod;

    @JsonProperty("close_date")
    private final @Nullable Long closeDate;

    @JsonProperty("description")
    private final @Nullable String description;

    @JsonProperty("description_entities")
    private final @Nullable List<MessageEntity> descriptionEntities;

    /**
     * Creates a new {@code Poll} instance.
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
     *     only for polls in quiz mode which are closed or were sent (not forwarded) by the bot or
     *     to the private chat with the bot.
     * @param explanation Text that is shown when a user chooses an incorrect answer or taps on the
     *     lamp icon in a quiz-style poll, 0-200 characters
     * @param explanationEntities Special entities like usernames, URLs, bot commands, etc. that
     *     appear in the explanation
     * @param openPeriod Amount of time in seconds the poll will be active after creation
     * @param closeDate Point in time (Unix timestamp) when the poll will be automatically closed
     * @param description Description of the poll; for polls inside the Message object only
     * @param descriptionEntities Special entities like usernames, URLs, bot commands, etc. that
     *     appear in the description
     */
    @JsonCreator
    public Poll(
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
            @JsonProperty("description_entities") @Nullable List<MessageEntity> descriptionEntities) {
        this.id = id;
        this.question = question;
        this.questionEntities = questionEntities;
        this.options = options;
        this.totalVoterCount = totalVoterCount;
        this.isClosed = isClosed;
        this.isAnonymous = isAnonymous;
        this.type = type;
        this.allowsMultipleAnswers = allowsMultipleAnswers;
        this.allowsRevoting = allowsRevoting;
        this.correctOptionIds = correctOptionIds;
        this.explanation = explanation;
        this.explanationEntities = explanationEntities;
        this.openPeriod = openPeriod;
        this.closeDate = closeDate;
        this.description = description;
        this.descriptionEntities = descriptionEntities;
    }

    public static Poll of(String id, String question, List<PollOption> options, long totalVoterCount, boolean isClosed, boolean isAnonymous, PollType type, boolean allowsMultipleAnswers, boolean allowsRevoting) {
        return new Poll(id, question, null, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, null, null, null, null, null, null, null);
    }

    /**
     * Unique poll identifier
     */
    public String id() {
        return id;
    }

    /**
     * Poll question, 1-300 characters
     */
    public String question() {
        return question;
    }

    /**
     * Special entities that appear in the question. Currently, only custom emoji entities are
     * allowed in poll questions
     */
    public @Nullable List<MessageEntity> questionEntities() {
        return questionEntities;
    }

    /**
     * List of poll options
     */
    public List<PollOption> options() {
        return options;
    }

    /**
     * Total number of users that voted in the poll
     */
    public long totalVoterCount() {
        return totalVoterCount;
    }

    /**
     * True, if the poll is closed
     */
    public boolean isClosed() {
        return isClosed;
    }

    /**
     * True, if the poll is anonymous
     */
    public boolean isAnonymous() {
        return isAnonymous;
    }

    /**
     * Poll type, currently can be 'regular' or 'quiz'
     */
    public PollType type() {
        return type;
    }

    /**
     * True, if the poll allows multiple answers
     */
    public boolean allowsMultipleAnswers() {
        return allowsMultipleAnswers;
    }

    /**
     * True, if the poll allows to change the chosen answer options
     */
    public boolean allowsRevoting() {
        return allowsRevoting;
    }

    /**
     * Array of 0-based identifiers of the correct answer options. Available only for polls in quiz
     * mode which are closed or were sent (not forwarded) by the bot or to the private chat with the
     * bot.
     */
    public @Nullable List<Long> correctOptionIds() {
        return correctOptionIds;
    }

    /**
     * Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a
     * quiz-style poll, 0-200 characters
     */
    public @Nullable String explanation() {
        return explanation;
    }

    /**
     * Special entities like usernames, URLs, bot commands, etc. that appear in the explanation
     */
    public @Nullable List<MessageEntity> explanationEntities() {
        return explanationEntities;
    }

    /**
     * Amount of time in seconds the poll will be active after creation
     */
    public @Nullable Long openPeriod() {
        return openPeriod;
    }

    /**
     * Point in time (Unix timestamp) when the poll will be automatically closed
     */
    public @Nullable Long closeDate() {
        return closeDate;
    }

    /**
     * Description of the poll; for polls inside the Message object only
     */
    public @Nullable String description() {
        return description;
    }

    /**
     * Special entities like usernames, URLs, bot commands, etc. that appear in the description
     */
    public @Nullable List<MessageEntity> descriptionEntities() {
        return descriptionEntities;
    }

    public Poll withId(String id) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withQuestion(String question) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withQuestionEntities(@Nullable List<MessageEntity> questionEntities) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withOptions(List<PollOption> options) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withTotalVoterCount(long totalVoterCount) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withIsClosed(boolean isClosed) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withIsAnonymous(boolean isAnonymous) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withType(PollType type) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withAllowsMultipleAnswers(boolean allowsMultipleAnswers) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withAllowsRevoting(boolean allowsRevoting) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withCorrectOptionIds(@Nullable List<Long> correctOptionIds) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withExplanation(@Nullable String explanation) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withExplanationEntities(@Nullable List<MessageEntity> explanationEntities) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withOpenPeriod(@Nullable Long openPeriod) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withCloseDate(@Nullable Long closeDate) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withDescription(@Nullable String description) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    public Poll withDescriptionEntities(@Nullable List<MessageEntity> descriptionEntities) {
        return new Poll(id, question, questionEntities, options, totalVoterCount, isClosed, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, correctOptionIds, explanation, explanationEntities, openPeriod, closeDate, description, descriptionEntities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Poll)) {
            return false;
        }
        Poll that = (Poll) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.question, that.question)
                && Objects.equals(this.questionEntities, that.questionEntities)
                && Objects.equals(this.options, that.options)
                && this.totalVoterCount == that.totalVoterCount
                && this.isClosed == that.isClosed
                && this.isAnonymous == that.isAnonymous
                && Objects.equals(this.type, that.type)
                && this.allowsMultipleAnswers == that.allowsMultipleAnswers
                && this.allowsRevoting == that.allowsRevoting
                && Objects.equals(this.correctOptionIds, that.correctOptionIds)
                && Objects.equals(this.explanation, that.explanation)
                && Objects.equals(this.explanationEntities, that.explanationEntities)
                && Objects.equals(this.openPeriod, that.openPeriod)
                && Objects.equals(this.closeDate, that.closeDate)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.descriptionEntities, that.descriptionEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.question, this.questionEntities, this.options, this.totalVoterCount, this.isClosed, this.isAnonymous, this.type, this.allowsMultipleAnswers, this.allowsRevoting, this.correctOptionIds, this.explanation, this.explanationEntities, this.openPeriod, this.closeDate, this.description, this.descriptionEntities);
    }

    @Override
    public String toString() {
        return "Poll[id=" + this.id
                + ", question=" + this.question
                + ", questionEntities=" + this.questionEntities
                + ", options=" + this.options
                + ", totalVoterCount=" + this.totalVoterCount
                + ", isClosed=" + this.isClosed
                + ", isAnonymous=" + this.isAnonymous
                + ", type=" + this.type
                + ", allowsMultipleAnswers=" + this.allowsMultipleAnswers
                + ", allowsRevoting=" + this.allowsRevoting
                + ", correctOptionIds=" + this.correctOptionIds
                + ", explanation=" + this.explanation
                + ", explanationEntities=" + this.explanationEntities
                + ", openPeriod=" + this.openPeriod
                + ", closeDate=" + this.closeDate
                + ", description=" + this.description
                + ", descriptionEntities=" + this.descriptionEntities
                + "]";
    }
}
