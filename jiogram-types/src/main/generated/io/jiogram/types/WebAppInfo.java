package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Describes a Web App.
 *
 * @see <a href="https://core.telegram.org/bots/api#webappinfo">WebAppInfo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class WebAppInfo {

    @JsonProperty("url")
    private final String url;

    /**
     * Creates a new {@code WebAppInfo} instance.
     *
     * @param url An HTTPS URL of a Web App to be opened with additional data as specified in
     *     Initializing Web Apps
     */
    @JsonCreator
    public WebAppInfo(
            @JsonProperty("url") String url) {
        this.url = url;
    }

    /**
     * An HTTPS URL of a Web App to be opened with additional data as specified in Initializing Web
     * Apps
     */
    public String url() {
        return url;
    }

    public WebAppInfo withUrl(String url) {
        return new WebAppInfo(url);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WebAppInfo)) {
            return false;
        }
        WebAppInfo that = (WebAppInfo) o;
        return Objects.equals(this.url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url);
    }

    @Override
    public String toString() {
        return "WebAppInfo[url=" + this.url
                + "]";
    }
}
