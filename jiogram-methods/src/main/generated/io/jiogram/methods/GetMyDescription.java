package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotDescription;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get the current bot description for the given user language. Returns
 * BotDescription on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getmydescription">getMyDescription in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetMyDescription implements TelegramMethod<BotDescription> {

    @JsonProperty("language_code")
    private final @Nullable String languageCode;

    /**
     * Creates a new {@code GetMyDescription} instance.
     *
     * @param languageCode A two-letter ISO 639-1 language code or an empty string
     */
    @JsonCreator
    public GetMyDescription(
            @JsonProperty("language_code") @Nullable String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public String apiMethod() {
        return "getMyDescription";
    }

    @Override
    public String apiReturnType() {
        return "BotDescription";
    }

    public static GetMyDescription of() {
        return new GetMyDescription(null);
    }

    /**
     * A two-letter ISO 639-1 language code or an empty string
     */
    public @Nullable String languageCode() {
        return languageCode;
    }

    public GetMyDescription withLanguageCode(@Nullable String languageCode) {
        return new GetMyDescription(languageCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetMyDescription)) {
            return false;
        }
        GetMyDescription that = (GetMyDescription) o;
        return Objects.equals(this.languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.languageCode);
    }

    @Override
    public String toString() {
        return "GetMyDescription[languageCode=" + this.languageCode
                + "]";
    }
}
