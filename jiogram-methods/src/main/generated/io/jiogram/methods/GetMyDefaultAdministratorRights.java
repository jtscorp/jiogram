package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get the current default administrator rights of the bot. Returns
 * ChatAdministratorRights on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getmydefaultadministratorrights">getMyDefaultAdministratorRights in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetMyDefaultAdministratorRights implements TelegramMethod<ChatAdministratorRights> {

    @JsonProperty("for_channels")
    private final @Nullable Boolean forChannels;

    /**
     * Creates a new {@code GetMyDefaultAdministratorRights} instance.
     *
     * @param forChannels Pass True to get default administrator rights of the bot in channels.
     *     Otherwise, default administrator rights of the bot for groups and supergroups will be
     *     returned.
     */
    @JsonCreator
    public GetMyDefaultAdministratorRights(
            @JsonProperty("for_channels") @Nullable Boolean forChannels) {
        this.forChannels = forChannels;
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

    /**
     * Pass True to get default administrator rights of the bot in channels. Otherwise, default
     * administrator rights of the bot for groups and supergroups will be returned.
     */
    public @Nullable Boolean forChannels() {
        return forChannels;
    }

    public GetMyDefaultAdministratorRights withForChannels(@Nullable Boolean forChannels) {
        return new GetMyDefaultAdministratorRights(forChannels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetMyDefaultAdministratorRights)) {
            return false;
        }
        GetMyDefaultAdministratorRights that = (GetMyDefaultAdministratorRights) o;
        return Objects.equals(this.forChannels, that.forChannels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.forChannels);
    }

    @Override
    public String toString() {
        return "GetMyDefaultAdministratorRights[forChannels=" + this.forChannels
                + "]";
    }
}
