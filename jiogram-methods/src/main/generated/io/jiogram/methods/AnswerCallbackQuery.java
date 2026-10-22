package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send answers to callback queries sent from inline keyboards. The answer will
 * be displayed to the user as a notification at the top of the chat screen or as an alert. On
 * success, True is returned.
 * <br>Alternatively, the user can be redirected to the specified Game URL. For this option to work,
 * you must first create a game for your bot via &#64;BotFather and accept the terms. Otherwise, you
 * may use links like t.me/your_bot?start=XXXX that open your bot with a parameter.
 *
 * @see <a href="https://core.telegram.org/bots/api#answercallbackquery">answerCallbackQuery in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class AnswerCallbackQuery implements TelegramMethod<Boolean> {

    @JsonProperty("callback_query_id")
    private final String callbackQueryId;

    @JsonProperty("text")
    private final @Nullable String text;

    @JsonProperty("show_alert")
    private final @Nullable Boolean showAlert;

    @JsonProperty("url")
    private final @Nullable String url;

    @JsonProperty("cache_time")
    private final @Nullable Long cacheTime;

    /**
     * Creates a new {@code AnswerCallbackQuery} instance.
     *
     * @param callbackQueryId Unique identifier for the query to be answered
     * @param text Text of the notification. If not specified, nothing will be shown to the user,
     *     0-200 characters
     * @param showAlert If True, an alert will be shown by the client instead of a notification at
     *     the top of the chat screen. Defaults to false.
     * @param url URL that will be opened by the user's client. If you have created a Game and
     *     accepted the conditions via &#64;BotFather, specify the URL that opens your game - note
     *     that this will only work if the query comes from a callback_game button. Otherwise, you
     *     may use links like t.me/your_bot?start=XXXX that open your bot with a parameter.
     * @param cacheTime The maximum amount of time in seconds that the result of the callback query
     *     may be cached client-side. Telegram apps will support caching starting in version 3.14.
     *     Defaults to 0.
     */
    @JsonCreator
    public AnswerCallbackQuery(
            @JsonProperty("callback_query_id") String callbackQueryId,
            @JsonProperty("text") @Nullable String text,
            @JsonProperty("show_alert") @Nullable Boolean showAlert,
            @JsonProperty("url") @Nullable String url,
            @JsonProperty("cache_time") @Nullable Long cacheTime) {
        this.callbackQueryId = callbackQueryId;
        this.text = text;
        this.showAlert = showAlert;
        this.url = url;
        this.cacheTime = cacheTime;
    }

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

    /**
     * Unique identifier for the query to be answered
     */
    public String callbackQueryId() {
        return callbackQueryId;
    }

    /**
     * Text of the notification. If not specified, nothing will be shown to the user, 0-200
     * characters
     */
    public @Nullable String text() {
        return text;
    }

    /**
     * If True, an alert will be shown by the client instead of a notification at the top of the
     * chat screen. Defaults to false.
     */
    public @Nullable Boolean showAlert() {
        return showAlert;
    }

    /**
     * URL that will be opened by the user's client. If you have created a Game and accepted the
     * conditions via &#64;BotFather, specify the URL that opens your game - note that this will
     * only work if the query comes from a callback_game button. Otherwise, you may use links like
     * t.me/your_bot?start=XXXX that open your bot with a parameter.
     */
    public @Nullable String url() {
        return url;
    }

    /**
     * The maximum amount of time in seconds that the result of the callback query may be cached
     * client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
     */
    public @Nullable Long cacheTime() {
        return cacheTime;
    }

    public AnswerCallbackQuery withCallbackQueryId(String callbackQueryId) {
        return new AnswerCallbackQuery(callbackQueryId, text, showAlert, url, cacheTime);
    }

    public AnswerCallbackQuery withText(@Nullable String text) {
        return new AnswerCallbackQuery(callbackQueryId, text, showAlert, url, cacheTime);
    }

    public AnswerCallbackQuery withShowAlert(@Nullable Boolean showAlert) {
        return new AnswerCallbackQuery(callbackQueryId, text, showAlert, url, cacheTime);
    }

    public AnswerCallbackQuery withUrl(@Nullable String url) {
        return new AnswerCallbackQuery(callbackQueryId, text, showAlert, url, cacheTime);
    }

    public AnswerCallbackQuery withCacheTime(@Nullable Long cacheTime) {
        return new AnswerCallbackQuery(callbackQueryId, text, showAlert, url, cacheTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnswerCallbackQuery)) {
            return false;
        }
        AnswerCallbackQuery that = (AnswerCallbackQuery) o;
        return Objects.equals(this.callbackQueryId, that.callbackQueryId)
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.showAlert, that.showAlert)
                && Objects.equals(this.url, that.url)
                && Objects.equals(this.cacheTime, that.cacheTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.callbackQueryId, this.text, this.showAlert, this.url, this.cacheTime);
    }

    @Override
    public String toString() {
        return "AnswerCallbackQuery[callbackQueryId=" + this.callbackQueryId
                + ", text=" + this.text
                + ", showAlert=" + this.showAlert
                + ", url=" + this.url
                + ", cacheTime=" + this.cacheTime
                + "]";
    }
}
