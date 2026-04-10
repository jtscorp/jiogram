package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetMyDefaultAdministratorRights implements TelegramMethod<Boolean> {
    @JsonProperty("rights") @Nullable private final ChatAdministratorRights rights;
    @JsonProperty("for_channels") @Nullable private final Boolean forChannels;

    @JsonCreator
    public SetMyDefaultAdministratorRights(
            @JsonProperty("rights") @Nullable ChatAdministratorRights rights,
            @JsonProperty("for_channels") @Nullable Boolean forChannels
    ) {
        this.rights = rights;
        this.forChannels = forChannels;
    }

    public ChatAdministratorRights rights() {
        return this.rights;
    }

    public Boolean forChannels() {
        return this.forChannels;
    }

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
