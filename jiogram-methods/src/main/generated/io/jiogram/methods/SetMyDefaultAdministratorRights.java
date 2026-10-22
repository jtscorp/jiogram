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
 * Use this method to change the default administrator rights requested by the bot when it's added
 * as an administrator to groups or channels. These rights will be suggested to users, but they are
 * free to modify the list before adding the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmydefaultadministratorrights">setMyDefaultAdministratorRights in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetMyDefaultAdministratorRights implements TelegramMethod<Boolean> {

    @JsonProperty("rights")
    private final @Nullable ChatAdministratorRights rights;

    @JsonProperty("for_channels")
    private final @Nullable Boolean forChannels;

    /**
     * Creates a new {@code SetMyDefaultAdministratorRights} instance.
     *
     * @param rights A JSON-serialized object describing new default administrator rights. If not
     *     specified, the default administrator rights will be cleared.
     * @param forChannels Pass True to change the default administrator rights of the bot in
     *     channels. Otherwise, the default administrator rights of the bot for groups and
     *     supergroups will be changed.
     */
    @JsonCreator
    public SetMyDefaultAdministratorRights(
            @JsonProperty("rights") @Nullable ChatAdministratorRights rights,
            @JsonProperty("for_channels") @Nullable Boolean forChannels) {
        this.rights = rights;
        this.forChannels = forChannels;
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

    /**
     * A JSON-serialized object describing new default administrator rights. If not specified, the
     * default administrator rights will be cleared.
     */
    public @Nullable ChatAdministratorRights rights() {
        return rights;
    }

    /**
     * Pass True to change the default administrator rights of the bot in channels. Otherwise, the
     * default administrator rights of the bot for groups and supergroups will be changed.
     */
    public @Nullable Boolean forChannels() {
        return forChannels;
    }

    public SetMyDefaultAdministratorRights withRights(@Nullable ChatAdministratorRights rights) {
        return new SetMyDefaultAdministratorRights(rights, forChannels);
    }

    public SetMyDefaultAdministratorRights withForChannels(@Nullable Boolean forChannels) {
        return new SetMyDefaultAdministratorRights(rights, forChannels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetMyDefaultAdministratorRights)) {
            return false;
        }
        SetMyDefaultAdministratorRights that = (SetMyDefaultAdministratorRights) o;
        return Objects.equals(this.rights, that.rights)
                && Objects.equals(this.forChannels, that.forChannels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rights, this.forChannels);
    }

    @Override
    public String toString() {
        return "SetMyDefaultAdministratorRights[rights=" + this.rights
                + ", forChannels=" + this.forChannels
                + "]";
    }
}
