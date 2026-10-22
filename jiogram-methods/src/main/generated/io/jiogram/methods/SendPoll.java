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

/**
 * Use this method to send a native poll. On success, the sent Message is returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be sent
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername). Polls can't be sent to channel direct messages chats.
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param question Poll question, 1-300 characters
 * @param questionParseMode Mode for parsing entities in the question. See formatting options for
 *     more details. Currently, only custom emoji entities are allowed
 * @param questionEntities A JSON-serialized list of special entities that appear in the poll
 *     question. It can be specified instead of question_parse_mode
 * @param options A JSON-serialized list of 2-12 answer options
 * @param isAnonymous True, if the poll needs to be anonymous, defaults to True
 * @param type Poll type, 'quiz' or 'regular', defaults to 'regular'
 * @param allowsMultipleAnswers Pass True, if the poll allows multiple answers, defaults to False
 * @param allowsRevoting Pass True, if the poll allows to change chosen answer options, defaults to
 *     False for quizzes and to True for regular polls
 * @param shuffleOptions Pass True, if the poll options must be shown in random order
 * @param allowAddingOptions Pass True, if answer options can be added to the poll after creation;
 *     not supported for anonymous polls and quizzes
 * @param hideResultsUntilCloses Pass True, if poll results must be shown only after the poll closes
 * @param correctOptionIds A JSON-serialized list of monotonically increasing 0-based identifiers of
 *     the correct answer options, required for polls in quiz mode
 * @param explanation Text that is shown when a user chooses an incorrect answer or taps on the lamp
 *     icon in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing
 * @param explanationParseMode Mode for parsing entities in the explanation. See formatting options
 *     for more details.
 * @param explanationEntities A JSON-serialized list of special entities that appear in the poll
 *     explanation. It can be specified instead of explanation_parse_mode
 * @param openPeriod Amount of time in seconds the poll will be active after creation, 5-2628000.
 *     Can't be used together with close_date.
 * @param closeDate Point in time (Unix timestamp) when the poll will be automatically closed. Must
 *     be at least 5 and no more than 2628000 seconds in the future. Can't be used together with
 *     open_period.
 * @param isClosed Pass True if the poll needs to be immediately closed. This can be useful for poll
 *     preview.
 * @param description Description of the poll to be sent, 0-1024 characters after entities parsing
 * @param descriptionParseMode Mode for parsing entities in the poll description. See formatting
 *     options for more details.
 * @param descriptionEntities A JSON-serialized list of special entities that appear in the poll
 *     description, which can be specified instead of description_parse_mode
 * @param disableNotification Sends the message silently. Users will receive a notification with no
 *     sound.
 * @param protectContent Protects the contents of the sent message from forwarding and saving
 * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
 *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will be
 *     withdrawn from the bot's balance
 * @param messageEffectId Unique identifier of the message effect to be added to the message; for
 *     private chats only
 * @param replyParameters Description of the message to reply to
 * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard,
 *     custom reply keyboard, instructions to remove a reply keyboard or to force a reply from the
 *     user
 * @see <a href="https://core.telegram.org/bots/api#sendpoll">sendPoll in the Bot API</a>
 */
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

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendPoll answer(Message message, String question, List<InputPollOption> options) {
        return new SendPoll(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), question, null, null, options, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendPoll reply(Message message, String question, List<InputPollOption> options) {
        return new SendPoll(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), question, null, null, options, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
    }

    public SendPoll withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withChatId(ChatId chatId) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withQuestion(String question) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withQuestionParseMode(@Nullable ParseMode questionParseMode) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withQuestionEntities(@Nullable List<MessageEntity> questionEntities) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withOptions(List<InputPollOption> options) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withIsAnonymous(@Nullable Boolean isAnonymous) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withType(@Nullable PollType type) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withAllowsMultipleAnswers(@Nullable Boolean allowsMultipleAnswers) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withAllowsRevoting(@Nullable Boolean allowsRevoting) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withShuffleOptions(@Nullable Boolean shuffleOptions) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withAllowAddingOptions(@Nullable Boolean allowAddingOptions) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withHideResultsUntilCloses(@Nullable Boolean hideResultsUntilCloses) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withCorrectOptionIds(@Nullable List<Long> correctOptionIds) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withExplanation(@Nullable String explanation) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withExplanationParseMode(@Nullable ParseMode explanationParseMode) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withExplanationEntities(@Nullable List<MessageEntity> explanationEntities) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withOpenPeriod(@Nullable Long openPeriod) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withCloseDate(@Nullable Long closeDate) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withIsClosed(@Nullable Boolean isClosed) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withDescription(@Nullable String description) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withDescriptionParseMode(@Nullable ParseMode descriptionParseMode) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withDescriptionEntities(@Nullable List<MessageEntity> descriptionEntities) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withProtectContent(@Nullable Boolean protectContent) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withMessageEffectId(@Nullable String messageEffectId) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }

    public SendPoll withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendPoll(businessConnectionId, chatId, messageThreadId, question, questionParseMode, questionEntities, options, isAnonymous, type, allowsMultipleAnswers, allowsRevoting, shuffleOptions, allowAddingOptions, hideResultsUntilCloses, correctOptionIds, explanation, explanationParseMode, explanationEntities, openPeriod, closeDate, isClosed, description, descriptionParseMode, descriptionEntities, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters, replyMarkup);
    }
}
