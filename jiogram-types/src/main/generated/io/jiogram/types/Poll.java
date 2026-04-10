package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.PollOption;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class Poll {
    @JsonProperty("id") private final String id;
    @JsonProperty("question") private final String question;
    @JsonProperty("question_entities") @Nullable private final List<MessageEntity> questionEntities;
    @JsonProperty("options") private final List<PollOption> options;
    @JsonProperty("total_voter_count") private final long totalVoterCount;
    @JsonProperty("is_closed") private final boolean isClosed;
    @JsonProperty("is_anonymous") private final boolean isAnonymous;
    @JsonProperty("type") private final String type;
    @JsonProperty("allows_multiple_answers") private final boolean allowsMultipleAnswers;
    @JsonProperty("allows_revoting") private final boolean allowsRevoting;
    @JsonProperty("correct_option_ids") @Nullable private final List<Long> correctOptionIds;
    @JsonProperty("explanation") @Nullable private final String explanation;
    @JsonProperty("explanation_entities") @Nullable private final List<MessageEntity> explanationEntities;
    @JsonProperty("open_period") @Nullable private final Long openPeriod;
    @JsonProperty("close_date") @Nullable private final Long closeDate;
    @JsonProperty("description") @Nullable private final String description;
    @JsonProperty("description_entities") @Nullable private final List<MessageEntity> descriptionEntities;

    @JsonCreator
    public Poll(
            @JsonProperty("id") String id,
            @JsonProperty("question") String question,
            @JsonProperty("question_entities") @Nullable List<MessageEntity> questionEntities,
            @JsonProperty("options") List<PollOption> options,
            @JsonProperty("total_voter_count") long totalVoterCount,
            @JsonProperty("is_closed") boolean isClosed,
            @JsonProperty("is_anonymous") boolean isAnonymous,
            @JsonProperty("type") String type,
            @JsonProperty("allows_multiple_answers") boolean allowsMultipleAnswers,
            @JsonProperty("allows_revoting") boolean allowsRevoting,
            @JsonProperty("correct_option_ids") @Nullable List<Long> correctOptionIds,
            @JsonProperty("explanation") @Nullable String explanation,
            @JsonProperty("explanation_entities") @Nullable List<MessageEntity> explanationEntities,
            @JsonProperty("open_period") @Nullable Long openPeriod,
            @JsonProperty("close_date") @Nullable Long closeDate,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("description_entities") @Nullable List<MessageEntity> descriptionEntities
    ) {
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

    public String id() {
        return this.id;
    }

    public String question() {
        return this.question;
    }

    public List<MessageEntity> questionEntities() {
        return this.questionEntities;
    }

    public List<PollOption> options() {
        return this.options;
    }

    public long totalVoterCount() {
        return this.totalVoterCount;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public String type() {
        return this.type;
    }

    public boolean allowsMultipleAnswers() {
        return this.allowsMultipleAnswers;
    }

    public boolean allowsRevoting() {
        return this.allowsRevoting;
    }

    public List<Long> correctOptionIds() {
        return this.correctOptionIds;
    }

    public String explanation() {
        return this.explanation;
    }

    public List<MessageEntity> explanationEntities() {
        return this.explanationEntities;
    }

    public Long openPeriod() {
        return this.openPeriod;
    }

    public Long closeDate() {
        return this.closeDate;
    }

    public String description() {
        return this.description;
    }

    public List<MessageEntity> descriptionEntities() {
        return this.descriptionEntities;
    }
}
