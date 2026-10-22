package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the bot's name. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmyname">setMyName in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetMyName implements TelegramMethod<Boolean> {

    @JsonProperty("name")
    private final @Nullable String name;

    @JsonProperty("language_code")
    private final @Nullable String languageCode;

    /**
     * Creates a new {@code SetMyName} instance.
     *
     * @param name New bot name; 0-64 characters. Pass an empty string to remove the dedicated name
     *     for the given language.
     * @param languageCode A two-letter ISO 639-1 language code. If empty, the name will be shown to
     *     all users for whose language there is no dedicated name.
     */
    @JsonCreator
    public SetMyName(
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("language_code") @Nullable String languageCode) {
        this.name = name;
        this.languageCode = languageCode;
    }

    @Override
    public String apiMethod() {
        return "setMyName";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyName of() {
        return new SetMyName(null, null);
    }

    /**
     * New bot name; 0-64 characters. Pass an empty string to remove the dedicated name for the
     * given language.
     */
    public @Nullable String name() {
        return name;
    }

    /**
     * A two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose
     * language there is no dedicated name.
     */
    public @Nullable String languageCode() {
        return languageCode;
    }

    public SetMyName withName(@Nullable String name) {
        return new SetMyName(name, languageCode);
    }

    public SetMyName withLanguageCode(@Nullable String languageCode) {
        return new SetMyName(name, languageCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetMyName)) {
            return false;
        }
        SetMyName that = (SetMyName) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.languageCode);
    }

    @Override
    public String toString() {
        return "SetMyName[name=" + this.name
                + ", languageCode=" + this.languageCode
                + "]";
    }
}
