package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a bot command.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommand">BotCommand in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BotCommand {

    @JsonProperty("command")
    private final String command;

    @JsonProperty("description")
    private final String description;

    /**
     * Creates a new {@code BotCommand} instance.
     *
     * @param command Text of the command; 1-32 characters. Can contain only lowercase English
     *     letters, digits and underscores.
     * @param description Description of the command; 1-256 characters.
     */
    @JsonCreator
    public BotCommand(
            @JsonProperty("command") String command,
            @JsonProperty("description") String description) {
        this.command = command;
        this.description = description;
    }

    /**
     * Text of the command; 1-32 characters. Can contain only lowercase English letters, digits and
     * underscores.
     */
    public String command() {
        return command;
    }

    /**
     * Description of the command; 1-256 characters.
     */
    public String description() {
        return description;
    }

    public BotCommand withCommand(String command) {
        return new BotCommand(command, description);
    }

    public BotCommand withDescription(String description) {
        return new BotCommand(command, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BotCommand)) {
            return false;
        }
        BotCommand that = (BotCommand) o;
        return Objects.equals(this.command, that.command)
                && Objects.equals(this.description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.command, this.description);
    }

    @Override
    public String toString() {
        return "BotCommand[command=" + this.command
                + ", description=" + this.description
                + "]";
    }
}
