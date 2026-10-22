package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents the bot's description.
 *
 * @see <a href="https://core.telegram.org/bots/api#botdescription">BotDescription in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotDescription {

    @JsonProperty("description")
    private final String description;

    /**
     * Creates a new {@code BotDescription} instance.
     *
     * @param description The bot's description
     */
    @JsonCreator
    public BotDescription(
            @JsonProperty("description") String description) {
        this.description = description;
    }

    /**
     * The bot's description
     */
    public String description() {
        return description;
    }

    public BotDescription withDescription(String description) {
        return new BotDescription(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotDescription)) {
            return false;
        }
        BotDescription that = (BotDescription) o;
        return Objects.equals(this.description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.description);
    }

    @Override
    public String toString() {
        return "BotDescription[description=" + this.description
                + "]";
    }
}
