package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record GetMyDefaultAdministratorRights(
    @JsonProperty("for_channels") @Nullable Boolean forChannels
) implements TelegramMethod<ChatAdministratorRights> {

    @Override
    public String apiMethod() {
        return "getMyDefaultAdministratorRights";
    }

    @Override
    public String apiReturnType() {
        return "ChatAdministratorRights";
    }

    public static GetMyDefaultAdministratorRights of() {
        return new GetMyDefaultAdministratorRights(null);
    }
}
