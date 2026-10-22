package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents the bot's short description.
 *
 * @see <a href="https://core.telegram.org/bots/api#botshortdescription">BotShortDescription in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotShortDescription {

    @JsonProperty("short_description")
    private final String shortDescription;

    /**
     * Creates a new {@code BotShortDescription} instance.
     *
     * @param shortDescription The bot's short description
     */
    @JsonCreator
    public BotShortDescription(
            @JsonProperty("short_description") String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * The bot's short description
     */
    public String shortDescription() {
        return shortDescription;
    }

    public BotShortDescription withShortDescription(String shortDescription) {
        return new BotShortDescription(shortDescription);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotShortDescription)) {
            return false;
        }
        BotShortDescription that = (BotShortDescription) o;
        return Objects.equals(this.shortDescription, that.shortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.shortDescription);
    }

    @Override
    public String toString() {
        return "BotShortDescription[shortDescription=" + this.shortDescription
                + "]";
    }
}
