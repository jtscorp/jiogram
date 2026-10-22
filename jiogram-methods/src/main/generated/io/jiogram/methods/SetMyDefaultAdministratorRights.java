package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAdministratorRights;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the default administrator rights requested by the bot when it's added
 * as an administrator to groups or channels. These rights will be suggested to users, but they are
 * free to modify the list before adding the bot. Returns True on success.
 *
 * @param rights A JSON-serialized object describing new default administrator rights. If not
 *     specified, the default administrator rights will be cleared.
 * @param forChannels Pass True to change the default administrator rights of the bot in channels.
 *     Otherwise, the default administrator rights of the bot for groups and supergroups will be
 *     changed.
 * @see <a href="https://core.telegram.org/bots/api#setmydefaultadministratorrights">setMyDefaultAdministratorRights in the Bot API</a>
 */
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

    public SetMyDefaultAdministratorRights withRights(@Nullable ChatAdministratorRights rights) {
        return new SetMyDefaultAdministratorRights(rights, forChannels);
    }

    public SetMyDefaultAdministratorRights withForChannels(@Nullable Boolean forChannels) {
        return new SetMyDefaultAdministratorRights(rights, forChannels);
    }
}
