package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the bot's description, which is shown in the chat with the bot if the
 * chat is empty. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmydescription">setMyDescription in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetMyDescription implements TelegramMethod<Boolean> {

    @JsonProperty("description")
    private final @Nullable String description;

    @JsonProperty("language_code")
    private final @Nullable String languageCode;

    /**
     * Creates a new {@code SetMyDescription} instance.
     *
     * @param description New bot description; 0-512 characters. Pass an empty string to remove the
     *     dedicated description for the given language.
     * @param languageCode A two-letter ISO 639-1 language code. If empty, the description will be
     *     applied to all users for whose language there is no dedicated description.
     */
    @JsonCreator
    public SetMyDescription(
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("language_code") @Nullable String languageCode) {
        this.description = description;
        this.languageCode = languageCode;
    }

    @Override
    public String apiMethod() {
        return "setMyDescription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyDescription of() {
        return new SetMyDescription(null, null);
    }

    /**
     * New bot description; 0-512 characters. Pass an empty string to remove the dedicated
     * description for the given language.
     */
    public @Nullable String description() {
        return description;
    }

    /**
     * A two-letter ISO 639-1 language code. If empty, the description will be applied to all users
     * for whose language there is no dedicated description.
     */
    public @Nullable String languageCode() {
        return languageCode;
    }

    public SetMyDescription withDescription(@Nullable String description) {
        return new SetMyDescription(description, languageCode);
    }

    public SetMyDescription withLanguageCode(@Nullable String languageCode) {
        return new SetMyDescription(description, languageCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetMyDescription)) {
            return false;
        }
        SetMyDescription that = (SetMyDescription) o;
        return Objects.equals(this.description, that.description)
                && Objects.equals(this.languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.description, this.languageCode);
    }

    @Override
    public String toString() {
        return "SetMyDescription[description=" + this.description
                + ", languageCode=" + this.languageCode
                + "]";
    }
}
