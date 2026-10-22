package io.jiogram.session;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

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

    /**
     * Creates a response envelope.
     *
     * @param ok          whether the request was successful
     * @param result      the deserialized result (present when ok is true)
     * @param errorCode   the error code (present when ok is false)
     * @param description a human-readable error description (present when ok is false)
     */
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

    /**
     * Returns whether the request was successful.
     */
    public boolean ok() {
        return ok;
    }

    /**
     * Returns the deserialized result (present when ok is true).
     */
    public @Nullable T result() {
        return result;
    }

    /**
     * Returns the error code (present when ok is false).
     */
    public @Nullable Integer errorCode() {
        return errorCode;
    }

    /**
     * Returns a human-readable error description (present when ok is false).
     */
    public @Nullable String description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TelegramApiResponse)) {
            return false;
        }
        TelegramApiResponse<?> that = (TelegramApiResponse<?>) o;
        return ok == that.ok
            && Objects.equals(result, that.result)
            && Objects.equals(errorCode, that.errorCode)
            && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ok, result, errorCode, description);
    }

    @Override
    public String toString() {
        return "TelegramApiResponse[ok=" + ok
            + ", result=" + result
            + ", errorCode=" + errorCode
            + ", description=" + description + "]";
    }
}
