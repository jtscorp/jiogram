package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementError;
import io.jiogram.types.TelegramMethod;
import java.util.List;

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
}
