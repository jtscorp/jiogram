package io.jiogram.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Represents the standard JSON response envelope from the Telegram Bot API.
 *
 * @param ok          whether the request was successful
 * @param result      the deserialized result (present when ok is true)
 * @param errorCode   the error code (present when ok is false)
 * @param description a human-readable error description (present when ok is false)
 * @param <T>         the type of the result field
 */
public record TelegramApiResponse<T>(
    @JsonProperty("ok") boolean ok,
    @JsonProperty("result") @Nullable T result,
    @JsonProperty("error_code") @Nullable Integer errorCode,
    @JsonProperty("description") @Nullable String description
) {}
