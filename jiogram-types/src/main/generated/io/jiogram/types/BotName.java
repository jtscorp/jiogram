package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents the bot's name.
 *
 * @see <a href="https://core.telegram.org/bots/api#botname">BotName in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotName {

    @JsonProperty("name")
    private final String name;

    /**
     * Creates a new {@code BotName} instance.
     *
     * @param name The bot's name
     */
    @JsonCreator
    public BotName(
            @JsonProperty("name") String name) {
        this.name = name;
    }

    /**
     * The bot's name
     */
    public String name() {
        return name;
    }

    public BotName withName(String name) {
        return new BotName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotName)) {
            return false;
        }
        BotName that = (BotName) o;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return "BotName[name=" + this.name
                + "]";
    }
}
