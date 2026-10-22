package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButtonType;
import io.jiogram.types.WebAppInfo;

/**
 * Represents a menu button, which launches a Web App.
 *
 * @param type Type of the button, must be web_app
 * @param text Text on the button
 * @param webApp Description of the Web App that will be launched when the user presses the button.
 *     The Web App will be able to send an arbitrary message on behalf of the user using the method
 *     answerWebAppQuery. Alternatively, a t.me link to a Web App of the bot can be specified in the
 *     object instead of the Web App's URL, in which case the Web App will be opened as if the user
 *     pressed the link.
 * @see <a href="https://core.telegram.org/bots/api#menubuttonwebapp">MenuButtonWebApp in the Bot API</a>
 */
public record MenuButtonWebApp(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MenuButtonType type,
    @JsonProperty("text") String text,
    @JsonProperty("web_app") WebAppInfo webApp
) implements MenuButton {

    public MenuButtonWebApp withText(String text) {
        return new MenuButtonWebApp(type, text, webApp);
    }

    public MenuButtonWebApp withWebApp(WebAppInfo webApp) {
        return new MenuButtonWebApp(type, text, webApp);
    }
}
