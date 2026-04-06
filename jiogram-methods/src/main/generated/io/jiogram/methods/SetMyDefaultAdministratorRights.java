package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetMyDefaultAdministratorRights(
    @JsonProperty("rights") @Nullable ChatAdministratorRights rights,
    @JsonProperty("for_channels") @Nullable Boolean forChannels
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMyDefaultAdministratorRights";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyDefaultAdministratorRights of() {
        return new SetMyDefaultAdministratorRights(null, null);
    }
}
