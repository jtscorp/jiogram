package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the bot's short description, which is shown on the bot's profile page
 * and is sent together with the link when users share the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmyshortdescription">setMyShortDescription in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetMyShortDescription implements TelegramMethod<Boolean> {

    @JsonProperty("short_description")
    private final @Nullable String shortDescription;

    @JsonProperty("language_code")
    private final @Nullable String languageCode;

    /**
     * Creates a new {@code SetMyShortDescription} instance.
     *
     * @param shortDescription New short description for the bot; 0-120 characters. Pass an empty
     *     string to remove the dedicated short description for the given language.
     * @param languageCode A two-letter ISO 639-1 language code. If empty, the short description
     *     will be applied to all users for whose language there is no dedicated short description.
     */
    @JsonCreator
    public SetMyShortDescription(
            @JsonProperty("short_description") @Nullable String shortDescription,
            @JsonProperty("language_code") @Nullable String languageCode) {
        this.shortDescription = shortDescription;
        this.languageCode = languageCode;
    }

    @Override
    public String apiMethod() {
        return "setMyShortDescription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetMyShortDescription of() {
        return new SetMyShortDescription(null, null);
    }

    /**
     * New short description for the bot; 0-120 characters. Pass an empty string to remove the
     * dedicated short description for the given language.
     */
    public @Nullable String shortDescription() {
        return shortDescription;
    }

    /**
     * A two-letter ISO 639-1 language code. If empty, the short description will be applied to all
     * users for whose language there is no dedicated short description.
     */
    public @Nullable String languageCode() {
        return languageCode;
    }

    public SetMyShortDescription withShortDescription(@Nullable String shortDescription) {
        return new SetMyShortDescription(shortDescription, languageCode);
    }

    public SetMyShortDescription withLanguageCode(@Nullable String languageCode) {
        return new SetMyShortDescription(shortDescription, languageCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetMyShortDescription)) {
            return false;
        }
        SetMyShortDescription that = (SetMyShortDescription) o;
        return Objects.equals(this.shortDescription, that.shortDescription)
                && Objects.equals(this.languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.shortDescription, this.languageCode);
    }

    @Override
    public String toString() {
        return "SetMyShortDescription[shortDescription=" + this.shortDescription
                + ", languageCode=" + this.languageCode
                + "]";
    }
}
