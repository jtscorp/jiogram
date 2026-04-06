package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.PollOption;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record Poll(
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
) {}
