package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.WebAppInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a button to be shown above inline query results. You must use exactly one
 * of the optional fields.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultsbutton">InlineQueryResultsButton in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultsButton {

    @JsonProperty("text")
    private final String text;

    @JsonProperty("web_app")
    private final @Nullable WebAppInfo webApp;

    @JsonProperty("start_parameter")
    private final @Nullable String startParameter;

    /**
     * Creates a new {@code InlineQueryResultsButton} instance.
     *
     * @param text Label text on the button
     * @param webApp Description of the Web App that will be launched when the user presses the
     *     button. The Web App will be able to switch back to the inline mode using the method
     *     switchInlineQuery inside the Web App.
     * @param startParameter Deep-linking parameter for the /start message sent to the bot when a
     *     user presses the button. 1-64 characters, only A-Z, a-z, 0-9, _ and - are allowed.
     *     Example: An inline bot that sends YouTube videos can ask the user to connect the bot to
     *     their YouTube account to adapt search results accordingly. To do this, it displays a
     *     'Connect your YouTube account' button above the results, or even before showing any. The
     *     user presses the button, switches to a private chat with the bot and, in doing so, passes
     *     a start parameter that instructs the bot to return an OAuth link. Once done, the bot can
     *     offer a switch_inline button so that the user can easily return to the chat where they
     *     wanted to use the bot's inline capabilities.
     */
    @JsonCreator
    public InlineQueryResultsButton(
            @JsonProperty("text") String text,
            @JsonProperty("web_app") @Nullable WebAppInfo webApp,
            @JsonProperty("start_parameter") @Nullable String startParameter) {
        this.text = text;
        this.webApp = webApp;
        this.startParameter = startParameter;
    }

    public static InlineQueryResultsButton of(String text) {
        return new InlineQueryResultsButton(text, null, null);
    }

    /**
     * Label text on the button
     */
    public String text() {
        return text;
    }

    /**
     * Description of the Web App that will be launched when the user presses the button. The Web
     * App will be able to switch back to the inline mode using the method switchInlineQuery inside
     * the Web App.
     */
    public @Nullable WebAppInfo webApp() {
        return webApp;
    }

    /**
     * Deep-linking parameter for the /start message sent to the bot when a user presses the button.
     * 1-64 characters, only A-Z, a-z, 0-9, _ and - are allowed. Example: An inline bot that sends
     * YouTube videos can ask the user to connect the bot to their YouTube account to adapt search
     * results accordingly. To do this, it displays a 'Connect your YouTube account' button above
     * the results, or even before showing any. The user presses the button, switches to a private
     * chat with the bot and, in doing so, passes a start parameter that instructs the bot to return
     * an OAuth link. Once done, the bot can offer a switch_inline button so that the user can
     * easily return to the chat where they wanted to use the bot's inline capabilities.
     */
    public @Nullable String startParameter() {
        return startParameter;
    }

    public InlineQueryResultsButton withText(String text) {
        return new InlineQueryResultsButton(text, webApp, startParameter);
    }

    public InlineQueryResultsButton withWebApp(@Nullable WebAppInfo webApp) {
        return new InlineQueryResultsButton(text, webApp, startParameter);
    }

    public InlineQueryResultsButton withStartParameter(@Nullable String startParameter) {
        return new InlineQueryResultsButton(text, webApp, startParameter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultsButton)) {
            return false;
        }
        InlineQueryResultsButton that = (InlineQueryResultsButton) o;
        return Objects.equals(this.text, that.text)
                && Objects.equals(this.webApp, that.webApp)
                && Objects.equals(this.startParameter, that.startParameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.webApp, this.startParameter);
    }

    @Override
    public String toString() {
        return "InlineQueryResultsButton[text=" + this.text
                + ", webApp=" + this.webApp
                + ", startParameter=" + this.startParameter
                + "]";
    }
}
