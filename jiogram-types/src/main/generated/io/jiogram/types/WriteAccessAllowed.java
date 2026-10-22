package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a service message about a user allowing a bot to write messages after
 * adding it to the attachment menu, launching a Web App from a link, or accepting an explicit
 * request from a Web App sent by the method requestWriteAccess.
 *
 * @param fromRequest True, if the access was granted after the user accepted an explicit request
 *     from a Web App sent by the method requestWriteAccess
 * @param webAppName Name of the Web App, if the access was granted when the Web App was launched
 *     from a link
 * @param fromAttachmentMenu True, if the access was granted when the bot was added to the
 *     attachment or side menu
 * @see <a href="https://core.telegram.org/bots/api#writeaccessallowed">WriteAccessAllowed in the Bot API</a>
 */
public record WriteAccessAllowed(
    @JsonProperty("from_request") @Nullable Boolean fromRequest,
    @JsonProperty("web_app_name") @Nullable String webAppName,
    @JsonProperty("from_attachment_menu") @Nullable Boolean fromAttachmentMenu
) {}
