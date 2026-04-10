package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputPollOption;
import io.jiogram.types.Message;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ReplyMarkup;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class SendPoll implements TelegramMethod<Message> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_thread_id") @Nullable private final Long messageThreadId;
    @JsonProperty("question") private final String question;
    @JsonProperty("question_parse_mode") @Nullable private final String questionParseMode;
    @JsonProperty("question_entities") @Nullable private final List<MessageEntity> questionEntities;
    @JsonProperty("options") private final List<InputPollOption> options;
    @JsonProperty("is_anonymous") @Nullable private final Boolean isAnonymous;
    @JsonProperty("type") @Nullable private final String type;
    @JsonProperty("allows_multiple_answers") @Nullable private final Boolean allowsMultipleAnswers;
    @JsonProperty("allows_revoting") @Nullable private final Boolean allowsRevoting;
    @JsonProperty("shuffle_options") @Nullable private final Boolean shuffleOptions;
    @JsonProperty("allow_adding_options") @Nullable private final Boolean allowAddingOptions;
    @JsonProperty("hide_results_until_closes") @Nullable private final Boolean hideResultsUntilCloses;
    @JsonProperty("correct_option_ids") @Nullable private final List<Long> correctOptionIds;
    @JsonProperty("explanation") @Nullable private final String explanation;
    @JsonProperty("explanation_parse_mode") @Nullable private final String explanationParseMode;
    @JsonProperty("explanation_entities") @Nullable private final List<MessageEntity> explanationEntities;
    @JsonProperty("open_period") @Nullable private final Long openPeriod;
    @JsonProperty("close_date") @Nullable private final Long closeDate;
    @JsonProperty("is_closed") @Nullable private final Boolean isClosed;
    @JsonProperty("description") @Nullable private final String description;
    @JsonProperty("description_parse_mode") @Nullable private final String descriptionParseMode;
    @JsonProperty("description_entities") @Nullable private final List<MessageEntity> descriptionEntities;
    @JsonProperty("disable_notification") @Nullable private final Boolean disableNotification;
    @JsonProperty("protect_content") @Nullable private final Boolean protectContent;
    @JsonProperty("allow_paid_broadcast") @Nullable private final Boolean allowPaidBroadcast;
    @JsonProperty("message_effect_id") @Nullable private final String messageEffectId;
    @JsonProperty("reply_parameters") @Nullable private final ReplyParameters replyParameters;
    @JsonProperty("reply_markup") @Nullable private final ReplyMarkup replyMarkup;

    @JsonCreator
    public SendPoll(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("question") String question,
            @JsonProperty("question_parse_mode") @Nullable String questionParseMode,
            @JsonProperty("question_entities") @Nullable List<MessageEntity> questionEntities,
            @JsonProperty("options") List<InputPollOption> options,
            @JsonProperty("is_anonymous") @Nullable Boolean isAnonymous,
            @JsonProperty("type") @Nullable String type,
            @JsonProperty("allows_multiple_answers") @Nullable Boolean allowsMultipleAnswers,
            @JsonProperty("allows_revoting") @Nullable Boolean allowsRevoting,
            @JsonProperty("shuffle_options") @Nullable Boolean shuffleOptions,
            @JsonProperty("allow_adding_options") @Nullable Boolean allowAddingOptions,
            @JsonProperty("hide_results_until_closes") @Nullable Boolean hideResultsUntilCloses,
            @JsonProperty("correct_option_ids") @Nullable List<Long> correctOptionIds,
            @JsonProperty("explanation") @Nullable String explanation,
            @JsonProperty("explanation_parse_mode") @Nullable String explanationParseMode,
            @JsonProperty("explanation_entities") @Nullable List<MessageEntity> explanationEntities,
            @JsonProperty("open_period") @Nullable Long openPeriod,
            @JsonProperty("close_date") @Nullable Long closeDate,
            @JsonProperty("is_closed") @Nullable Boolean isClosed,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("description_parse_mode") @Nullable String descriptionParseMode,
            @JsonProperty("description_entities") @Nullable List<MessageEntity> descriptionEntities,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
            @JsonProperty("reply_markup") @Nullable ReplyMarkup replyMarkup
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.question = question;
        this.questionParseMode = questionParseMode;
        this.questionEntities = questionEntities;
        this.options = options;
        this.isAnonymous = isAnonymous;
        this.type = type;
        this.allowsMultipleAnswers = allowsMultipleAnswers;
        this.allowsRevoting = allowsRevoting;
        this.shuffleOptions = shuffleOptions;
        this.allowAddingOptions = allowAddingOptions;
        this.hideResultsUntilCloses = hideResultsUntilCloses;
        this.correctOptionIds = correctOptionIds;
        this.explanation = explanation;
        this.explanationParseMode = explanationParseMode;
        this.explanationEntities = explanationEntities;
        this.openPeriod = openPeriod;
        this.closeDate = closeDate;
        this.isClosed = isClosed;
        this.description = description;
        this.descriptionParseMode = descriptionParseMode;
        this.descriptionEntities = descriptionEntities;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.allowPaidBroadcast = allowPaidBroadcast;
        this.messageEffectId = messageEffectId;
        this.replyParameters = replyParameters;
        this.replyMarkup = replyMarkup;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Long messageThreadId() {
        return this.messageThreadId;
    }

    public String question() {
        return this.question;
    }

    public String questionParseMode() {
        return this.questionParseMode;
    }

    public List<MessageEntity> questionEntities() {
        return this.questionEntities;
    }

    public List<InputPollOption> options() {
        return this.options;
    }

    public Boolean isAnonymous() {
        return this.isAnonymous;
    }

    public String type() {
        return this.type;
    }

    public Boolean allowsMultipleAnswers() {
        return this.allowsMultipleAnswers;
    }

    public Boolean allowsRevoting() {
        return this.allowsRevoting;
    }

    public Boolean shuffleOptions() {
        return this.shuffleOptions;
    }

    public Boolean allowAddingOptions() {
        return this.allowAddingOptions;
    }

    public Boolean hideResultsUntilCloses() {
        return this.hideResultsUntilCloses;
    }

    public List<Long> correctOptionIds() {
        return this.correctOptionIds;
    }

    public String explanation() {
        return this.explanation;
    }

    public String explanationParseMode() {
        return this.explanationParseMode;
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

    public Boolean isClosed() {
        return this.isClosed;
    }

    public String description() {
        return this.description;
    }

    public String descriptionParseMode() {
        return this.descriptionParseMode;
    }

    public List<MessageEntity> descriptionEntities() {
        return this.descriptionEntities;
    }

    public Boolean disableNotification() {
        return this.disableNotification;
    }

    public Boolean protectContent() {
        return this.protectContent;
    }

    public Boolean allowPaidBroadcast() {
        return this.allowPaidBroadcast;
    }

    public String messageEffectId() {
        return this.messageEffectId;
    }

    public ReplyParameters replyParameters() {
        return this.replyParameters;
    }

    public ReplyMarkup replyMarkup() {
        return this.replyMarkup;
    }

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
