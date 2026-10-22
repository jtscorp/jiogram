package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a Web App.
 *
 * @param url An HTTPS URL of a Web App to be opened with additional data as specified in
 *     Initializing Web Apps
 * @see <a href="https://core.telegram.org/bots/api#webappinfo">WebAppInfo in the Bot API</a>
 */
public record WebAppInfo(
    @JsonProperty("url") String url
) {}
