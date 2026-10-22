package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get the current default administrator rights of the bot. Returns
 * ChatAdministratorRights on success.
 *
 * @param forChannels Pass True to get default administrator rights of the bot in channels.
 *     Otherwise, default administrator rights of the bot for groups and supergroups will be
 *     returned.
 * @see <a href="https://core.telegram.org/bots/api#getmydefaultadministratorrights">getMyDefaultAdministratorRights in the Bot API</a>
 */
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
