package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementError;
import io.jiogram.types.TelegramMethod;
import java.util.List;

public class SetPassportDataErrors implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("errors") private final List<PassportElementError> errors;

    @JsonCreator
    public SetPassportDataErrors(
            @JsonProperty("user_id") long userId,
            @JsonProperty("errors") List<PassportElementError> errors
    ) {
        this.userId = userId;
        this.errors = errors;
    }

    public long userId() {
        return this.userId;
    }

    public List<PassportElementError> errors() {
        return this.errors;
    }

    @Override
    public String apiMethod() {
        return "setPassportDataErrors";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
