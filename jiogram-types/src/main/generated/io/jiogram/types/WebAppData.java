package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Describes data sent from a Web App to the bot.
 *
 * @see <a href="https://core.telegram.org/bots/api#webappdata">WebAppData in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class WebAppData {

    @JsonProperty("data")
    private final String data;

    @JsonProperty("button_text")
    private final String buttonText;

    /**
     * Creates a new {@code WebAppData} instance.
     *
     * @param data The data. Be aware that a bad client can send arbitrary data in this field.
     * @param buttonText Text of the web_app keyboard button from which the Web App was opened. Be
     *     aware that a bad client can send arbitrary data in this field.
     */
    @JsonCreator
    public WebAppData(
            @JsonProperty("data") String data,
            @JsonProperty("button_text") String buttonText) {
        this.data = data;
        this.buttonText = buttonText;
    }

    /**
     * The data. Be aware that a bad client can send arbitrary data in this field.
     */
    public String data() {
        return data;
    }

    /**
     * Text of the web_app keyboard button from which the Web App was opened. Be aware that a bad
     * client can send arbitrary data in this field.
     */
    public String buttonText() {
        return buttonText;
    }

    public WebAppData withData(String data) {
        return new WebAppData(data, buttonText);
    }

    public WebAppData withButtonText(String buttonText) {
        return new WebAppData(data, buttonText);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WebAppData)) {
            return false;
        }
        WebAppData that = (WebAppData) o;
        return Objects.equals(this.data, that.data)
                && Objects.equals(this.buttonText, that.buttonText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.buttonText);
    }

    @Override
    public String toString() {
        return "WebAppData[data=" + this.data
                + ", buttonText=" + this.buttonText
                + "]";
    }
}
