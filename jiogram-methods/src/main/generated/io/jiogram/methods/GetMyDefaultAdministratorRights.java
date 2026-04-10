package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class GetMyDefaultAdministratorRights implements TelegramMethod<ChatAdministratorRights> {
    @JsonProperty("for_channels") @Nullable private final Boolean forChannels;

    @JsonCreator
    public GetMyDefaultAdministratorRights(
            @JsonProperty("for_channels") @Nullable Boolean forChannels
    ) {
        this.forChannels = forChannels;
    }

    public Boolean forChannels() {
        return this.forChannels;
    }

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
