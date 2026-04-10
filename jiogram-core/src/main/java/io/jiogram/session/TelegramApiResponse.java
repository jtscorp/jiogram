package io.jiogram.session;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Represents the standard JSON response envelope from the Telegram Bot API.
 *
 * @param <T> the type of the result field
 */
public final class TelegramApiResponse<T> {

    @JsonProperty("ok")
    private final boolean ok;

    @JsonProperty("result")
    private final @Nullable T result;

    @JsonProperty("error_code")
    private final @Nullable Integer errorCode;

    @JsonProperty("description")
    private final @Nullable String description;

    @JsonCreator
    public TelegramApiResponse(
        @JsonProperty("ok") boolean ok,
        @JsonProperty("result") @Nullable T result,
        @JsonProperty("error_code") @Nullable Integer errorCode,
        @JsonProperty("description") @Nullable String description
    ) {
        this.ok = ok;
        this.result = result;
        this.errorCode = errorCode;
        this.description = description;
    }

    public boolean ok() {
        return ok;
    }

    public @Nullable T result() {
        return result;
    }

    public @Nullable Integer errorCode() {
        return errorCode;
    }

    public @Nullable String description() {
        return description;
    }
}
