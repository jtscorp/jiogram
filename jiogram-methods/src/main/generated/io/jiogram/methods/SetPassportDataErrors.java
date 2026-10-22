package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementError;
import io.jiogram.types.TelegramMethod;
import java.util.List;

/**
 * Informs a user that some of the Telegram Passport elements they provided contains errors. The
 * user will not be able to re-submit their Passport to you until the errors are fixed (the contents
 * of the field for which you returned the error must change). Returns True on success.
 * <br>Use this if the data submitted by the user doesn't satisfy the standards your service
 * requires for any reason. For example, if a birthday date seems invalid, a submitted document is
 * blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make
 * sure the user knows how to correct the issues.
 *
 * @param userId User identifier
 * @param errors A JSON-serialized array describing the errors
 * @see <a href="https://core.telegram.org/bots/api#setpassportdataerrors">setPassportDataErrors in the Bot API</a>
 */
public record SetPassportDataErrors(
    @JsonProperty("user_id") long userId,
    @JsonProperty("errors") List<PassportElementError> errors
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setPassportDataErrors";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public SetPassportDataErrors withUserId(long userId) {
        return new SetPassportDataErrors(userId, errors);
    }

    public SetPassportDataErrors withErrors(List<PassportElementError> errors) {
        return new SetPassportDataErrors(userId, errors);
    }
}
