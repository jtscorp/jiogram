package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send answers to callback queries sent from inline keyboards. The answer will
 * be displayed to the user as a notification at the top of the chat screen or as an alert. On
 * success, True is returned.
 * <br>Alternatively, the user can be redirected to the specified Game URL. For this option to work,
 * you must first create a game for your bot via &#64;BotFather and accept the terms. Otherwise, you
 * may use links like t.me/your_bot?start=XXXX that open your bot with a parameter.
 *
 * @param callbackQueryId Unique identifier for the query to be answered
 * @param text Text of the notification. If not specified, nothing will be shown to the user, 0-200
 *     characters
 * @param showAlert If True, an alert will be shown by the client instead of a notification at the
 *     top of the chat screen. Defaults to false.
 * @param url URL that will be opened by the user's client. If you have created a Game and accepted
 *     the conditions via &#64;BotFather, specify the URL that opens your game - note that this will
 *     only work if the query comes from a callback_game button. Otherwise, you may use links like
 *     t.me/your_bot?start=XXXX that open your bot with a parameter.
 * @param cacheTime The maximum amount of time in seconds that the result of the callback query may
 *     be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults
 *     to 0.
 * @see <a href="https://core.telegram.org/bots/api#answercallbackquery">answerCallbackQuery in the Bot API</a>
 */
public record AnswerCallbackQuery(
    @JsonProperty("callback_query_id") String callbackQueryId,
    @JsonProperty("text") @Nullable String text,
    @JsonProperty("show_alert") @Nullable Boolean showAlert,
    @JsonProperty("url") @Nullable String url,
    @JsonProperty("cache_time") @Nullable Long cacheTime
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "answerCallbackQuery";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static AnswerCallbackQuery of(String callbackQueryId) {
        return new AnswerCallbackQuery(callbackQueryId, null, null, null, null);
    }
}
