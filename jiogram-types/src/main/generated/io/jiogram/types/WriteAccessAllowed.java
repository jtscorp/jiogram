package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a service message about a user allowing a bot to write messages after
 * adding it to the attachment menu, launching a Web App from a link, or accepting an explicit
 * request from a Web App sent by the method requestWriteAccess.
 *
 * @see <a href="https://core.telegram.org/bots/api#writeaccessallowed">WriteAccessAllowed in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class WriteAccessAllowed {

    @JsonProperty("from_request")
    private final @Nullable Boolean fromRequest;

    @JsonProperty("web_app_name")
    private final @Nullable String webAppName;

    @JsonProperty("from_attachment_menu")
    private final @Nullable Boolean fromAttachmentMenu;

    /**
     * Creates a new {@code WriteAccessAllowed} instance.
     *
     * @param fromRequest True, if the access was granted after the user accepted an explicit
     *     request from a Web App sent by the method requestWriteAccess
     * @param webAppName Name of the Web App, if the access was granted when the Web App was
     *     launched from a link
     * @param fromAttachmentMenu True, if the access was granted when the bot was added to the
     *     attachment or side menu
     */
    @JsonCreator
    public WriteAccessAllowed(
            @JsonProperty("from_request") @Nullable Boolean fromRequest,
            @JsonProperty("web_app_name") @Nullable String webAppName,
            @JsonProperty("from_attachment_menu") @Nullable Boolean fromAttachmentMenu) {
        this.fromRequest = fromRequest;
        this.webAppName = webAppName;
        this.fromAttachmentMenu = fromAttachmentMenu;
    }

    public static WriteAccessAllowed of() {
        return new WriteAccessAllowed(null, null, null);
    }

    /**
     * True, if the access was granted after the user accepted an explicit request from a Web App
     * sent by the method requestWriteAccess
     */
    public @Nullable Boolean fromRequest() {
        return fromRequest;
    }

    /**
     * Name of the Web App, if the access was granted when the Web App was launched from a link
     */
    public @Nullable String webAppName() {
        return webAppName;
    }

    /**
     * True, if the access was granted when the bot was added to the attachment or side menu
     */
    public @Nullable Boolean fromAttachmentMenu() {
        return fromAttachmentMenu;
    }

    public WriteAccessAllowed withFromRequest(@Nullable Boolean fromRequest) {
        return new WriteAccessAllowed(fromRequest, webAppName, fromAttachmentMenu);
    }

    public WriteAccessAllowed withWebAppName(@Nullable String webAppName) {
        return new WriteAccessAllowed(fromRequest, webAppName, fromAttachmentMenu);
    }

    public WriteAccessAllowed withFromAttachmentMenu(@Nullable Boolean fromAttachmentMenu) {
        return new WriteAccessAllowed(fromRequest, webAppName, fromAttachmentMenu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WriteAccessAllowed)) {
            return false;
        }
        WriteAccessAllowed that = (WriteAccessAllowed) o;
        return Objects.equals(this.fromRequest, that.fromRequest)
                && Objects.equals(this.webAppName, that.webAppName)
                && Objects.equals(this.fromAttachmentMenu, that.fromAttachmentMenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fromRequest, this.webAppName, this.fromAttachmentMenu);
    }

    @Override
    public String toString() {
        return "WriteAccessAllowed[fromRequest=" + this.fromRequest
                + ", webAppName=" + this.webAppName
                + ", fromAttachmentMenu=" + this.fromAttachmentMenu
                + "]";
    }
}
