package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotName;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get the current bot name for the given user language. Returns BotName on
 * success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getmyname">getMyName in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetMyName implements TelegramMethod<BotName> {

    @JsonProperty("language_code")
    private final @Nullable String languageCode;

    /**
     * Creates a new {@code GetMyName} instance.
     *
     * @param languageCode A two-letter ISO 639-1 language code or an empty string
     */
    @JsonCreator
    public GetMyName(
            @JsonProperty("language_code") @Nullable String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public String apiMethod() {
        return "getMyName";
    }

    @Override
    public String apiReturnType() {
        return "BotName";
    }

    public static GetMyName of() {
        return new GetMyName(null);
    }

    /**
     * A two-letter ISO 639-1 language code or an empty string
     */
    public @Nullable String languageCode() {
        return languageCode;
    }

    public GetMyName withLanguageCode(@Nullable String languageCode) {
        return new GetMyName(languageCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetMyName)) {
            return false;
        }
        GetMyName that = (GetMyName) o;
        return Objects.equals(this.languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.languageCode);
    }

    @Override
    public String toString() {
        return "GetMyName[languageCode=" + this.languageCode
                + "]";
    }
}
