package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputPollOption;
import io.jiogram.types.Message;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.PollType;
import io.jiogram.types.ReplyMarkup;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record SendPoll(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("question") String question,
    @JsonProperty("question_parse_mode") @Nullable ParseMode questionParseMode,
    @JsonProperty("question_entities") @Nullable List<MessageEntity> questionEntities,
    @JsonProperty("options") List<InputPollOption> options,
    @JsonProperty("is_anonymous") @Nullable Boolean isAnonymous,
    @JsonProperty("type") @Nullable PollType type,
    @JsonProperty("allows_multiple_answers") @Nullable Boolean allowsMultipleAnswers,
    @JsonProperty("allows_revoting") @Nullable Boolean allowsRevoting,
    @JsonProperty("shuffle_options") @Nullable Boolean shuffleOptions,
    @JsonProperty("allow_adding_options") @Nullable Boolean allowAddingOptions,
    @JsonProperty("hide_results_until_closes") @Nullable Boolean hideResultsUntilCloses,
    @JsonProperty("correct_option_ids") @Nullable List<Long> correctOptionIds,
    @JsonProperty("explanation") @Nullable String explanation,
    @JsonProperty("explanation_parse_mode") @Nullable ParseMode explanationParseMode,
    @JsonProperty("explanation_entities") @Nullable List<MessageEntity> explanationEntities,
    @JsonProperty("open_period") @Nullable Long openPeriod,
    @JsonProperty("close_date") @Nullable Long closeDate,
    @JsonProperty("is_closed") @Nullable Boolean isClosed,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("description_parse_mode") @Nullable ParseMode descriptionParseMode,
    @JsonProperty("description_entities") @Nullable List<MessageEntity> descriptionEntities,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent,
    @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
    @JsonProperty("message_effect_id") @Nullable String messageEffectId,
    @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
    @JsonProperty("reply_markup") @Nullable ReplyMarkup replyMarkup
) implements TelegramMethod<Message> {

    @Override
    public String apiMethod() {
        return "sendPoll";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendPoll of(ChatId chatId, String question, List<InputPollOption> options) {
        return new SendPoll(null, chatId, null, question, null, null, options, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
