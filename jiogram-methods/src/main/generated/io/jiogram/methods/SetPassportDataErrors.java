package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementError;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;

/**
 * Informs a user that some of the Telegram Passport elements they provided contains errors. The
 * user will not be able to re-submit their Passport to you until the errors are fixed (the contents
 * of the field for which you returned the error must change). Returns True on success.
 * <br>Use this if the data submitted by the user doesn't satisfy the standards your service
 * requires for any reason. For example, if a birthday date seems invalid, a submitted document is
 * blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make
 * sure the user knows how to correct the issues.
 *
 * @see <a href="https://core.telegram.org/bots/api#setpassportdataerrors">setPassportDataErrors in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetPassportDataErrors implements TelegramMethod<Boolean> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("errors")
    private final List<PassportElementError> errors;

    /**
     * Creates a new {@code SetPassportDataErrors} instance.
     *
     * @param userId User identifier
     * @param errors A JSON-serialized array describing the errors
     */
    @JsonCreator
    public SetPassportDataErrors(
            @JsonProperty("user_id") long userId,
            @JsonProperty("errors") List<PassportElementError> errors) {
        this.userId = userId;
        this.errors = errors;
    }

    @Override
    public String apiMethod() {
        return "setPassportDataErrors";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * User identifier
     */
    public long userId() {
        return userId;
    }

    /**
     * A JSON-serialized array describing the errors
     */
    public List<PassportElementError> errors() {
        return errors;
    }

    public SetPassportDataErrors withUserId(long userId) {
        return new SetPassportDataErrors(userId, errors);
    }

    public SetPassportDataErrors withErrors(List<PassportElementError> errors) {
        return new SetPassportDataErrors(userId, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetPassportDataErrors)) {
            return false;
        }
        SetPassportDataErrors that = (SetPassportDataErrors) o;
        return this.userId == that.userId
                && Objects.equals(this.errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.errors);
    }

    @Override
    public String toString() {
        return "SetPassportDataErrors[userId=" + this.userId
                + ", errors=" + this.errors
                + "]";
    }
}
