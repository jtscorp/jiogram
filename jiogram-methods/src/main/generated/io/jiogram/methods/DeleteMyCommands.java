package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to delete the list of the bot's commands for the given scope and user language.
 * After deletion, higher level commands will be shown to affected users. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletemycommands">deleteMyCommands in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeleteMyCommands implements TelegramMethod<Boolean> {

    @JsonProperty("scope")
    private final @Nullable BotCommandScope scope;

    @JsonProperty("language_code")
    private final @Nullable String languageCode;

    /**
     * Creates a new {@code DeleteMyCommands} instance.
     *
     * @param scope A JSON-serialized object, describing scope of users for which the commands are
     *     relevant. Defaults to BotCommandScopeDefault.
     * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied
     *     to all users from the given scope, for whose language there are no dedicated commands
     */
    @JsonCreator
    public DeleteMyCommands(
            @JsonProperty("scope") @Nullable BotCommandScope scope,
            @JsonProperty("language_code") @Nullable String languageCode) {
        this.scope = scope;
        this.languageCode = languageCode;
    }

    @Override
    public String apiMethod() {
        return "deleteMyCommands";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static DeleteMyCommands of() {
        return new DeleteMyCommands(null, null);
    }

    /**
     * A JSON-serialized object, describing scope of users for which the commands are relevant.
     * Defaults to BotCommandScopeDefault.
     */
    public @Nullable BotCommandScope scope() {
        return scope;
    }

    /**
     * A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from
     * the given scope, for whose language there are no dedicated commands
     */
    public @Nullable String languageCode() {
        return languageCode;
    }

    public DeleteMyCommands withScope(@Nullable BotCommandScope scope) {
        return new DeleteMyCommands(scope, languageCode);
    }

    public DeleteMyCommands withLanguageCode(@Nullable String languageCode) {
        return new DeleteMyCommands(scope, languageCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeleteMyCommands)) {
            return false;
        }
        DeleteMyCommands that = (DeleteMyCommands) o;
        return Objects.equals(this.scope, that.scope)
                && Objects.equals(this.languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.scope, this.languageCode);
    }

    @Override
    public String toString() {
        return "DeleteMyCommands[scope=" + this.scope
                + ", languageCode=" + this.languageCode
                + "]";
    }
}
