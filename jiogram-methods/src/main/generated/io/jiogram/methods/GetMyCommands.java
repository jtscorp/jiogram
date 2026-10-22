package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommand;
import io.jiogram.types.BotCommandScope;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get the current list of the bot's commands for the given scope and user
 * language. Returns an Array of BotCommand objects. If commands aren't set, an empty list is
 * returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#getmycommands">getMyCommands in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetMyCommands implements TelegramMethod<List<BotCommand>> {

    @JsonProperty("scope")
    private final @Nullable BotCommandScope scope;

    @JsonProperty("language_code")
    private final @Nullable String languageCode;

    /**
     * Creates a new {@code GetMyCommands} instance.
     *
     * @param scope A JSON-serialized object, describing scope of users. Defaults to
     *     BotCommandScopeDefault.
     * @param languageCode A two-letter ISO 639-1 language code or an empty string
     */
    @JsonCreator
    public GetMyCommands(
            @JsonProperty("scope") @Nullable BotCommandScope scope,
            @JsonProperty("language_code") @Nullable String languageCode) {
        this.scope = scope;
        this.languageCode = languageCode;
    }

    @Override
    public String apiMethod() {
        return "getMyCommands";
    }

    @Override
    public String apiReturnType() {
        return "Array of BotCommand";
    }

    public static GetMyCommands of() {
        return new GetMyCommands(null, null);
    }

    /**
     * A JSON-serialized object, describing scope of users. Defaults to BotCommandScopeDefault.
     */
    public @Nullable BotCommandScope scope() {
        return scope;
    }

    /**
     * A two-letter ISO 639-1 language code or an empty string
     */
    public @Nullable String languageCode() {
        return languageCode;
    }

    public GetMyCommands withScope(@Nullable BotCommandScope scope) {
        return new GetMyCommands(scope, languageCode);
    }

    public GetMyCommands withLanguageCode(@Nullable String languageCode) {
        return new GetMyCommands(scope, languageCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetMyCommands)) {
            return false;
        }
        GetMyCommands that = (GetMyCommands) o;
        return Objects.equals(this.scope, that.scope)
                && Objects.equals(this.languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.scope, this.languageCode);
    }

    @Override
    public String toString() {
        return "GetMyCommands[scope=" + this.scope
                + ", languageCode=" + this.languageCode
                + "]";
    }
}
