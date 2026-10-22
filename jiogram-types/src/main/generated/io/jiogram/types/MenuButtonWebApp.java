package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButtonType;
import io.jiogram.types.WebAppInfo;
import java.util.Objects;

/**
 * Represents a menu button, which launches a Web App.
 *
 * @see <a href="https://core.telegram.org/bots/api#menubuttonwebapp">MenuButtonWebApp in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MenuButtonWebApp implements MenuButton {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final MenuButtonType type;

    @JsonProperty("text")
    private final String text;

    @JsonProperty("web_app")
    private final WebAppInfo webApp;

    /**
     * Creates a new {@code MenuButtonWebApp} instance.
     *
     * @param type Type of the button, must be web_app
     * @param text Text on the button
     * @param webApp Description of the Web App that will be launched when the user presses the
     *     button. The Web App will be able to send an arbitrary message on behalf of the user using
     *     the method answerWebAppQuery. Alternatively, a t.me link to a Web App of the bot can be
     *     specified in the object instead of the Web App's URL, in which case the Web App will be
     *     opened as if the user pressed the link.
     */
    @JsonCreator
    public MenuButtonWebApp(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MenuButtonType type,
            @JsonProperty("text") String text,
            @JsonProperty("web_app") WebAppInfo webApp) {
        this.type = type;
        this.text = text;
        this.webApp = webApp;
    }

    public static MenuButtonWebApp of(String text, WebAppInfo webApp) {
        return new MenuButtonWebApp(MenuButtonType.WEB_APP, text, webApp);
    }

    /**
     * Type of the button, must be web_app
     */
    public MenuButtonType type() {
        return type;
    }

    /**
     * Text on the button
     */
    public String text() {
        return text;
    }

    /**
     * Description of the Web App that will be launched when the user presses the button. The Web
     * App will be able to send an arbitrary message on behalf of the user using the method
     * answerWebAppQuery. Alternatively, a t.me link to a Web App of the bot can be specified in the
     * object instead of the Web App's URL, in which case the Web App will be opened as if the user
     * pressed the link.
     */
    public WebAppInfo webApp() {
        return webApp;
    }

    public MenuButtonWebApp withText(String text) {
        return new MenuButtonWebApp(type, text, webApp);
    }

    public MenuButtonWebApp withWebApp(WebAppInfo webApp) {
        return new MenuButtonWebApp(type, text, webApp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MenuButtonWebApp)) {
            return false;
        }
        MenuButtonWebApp that = (MenuButtonWebApp) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.webApp, that.webApp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.text, this.webApp);
    }

    @Override
    public String toString() {
        return "MenuButtonWebApp[type=" + this.type
                + ", text=" + this.text
                + ", webApp=" + this.webApp
                + "]";
    }
}
