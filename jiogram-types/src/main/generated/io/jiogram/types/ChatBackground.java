package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundType;
import java.util.Objects;

/**
 * This object represents a chat background.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatbackground">ChatBackground in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatBackground {

    @JsonProperty("type")
    private final BackgroundType type;

    /**
     * Creates a new {@code ChatBackground} instance.
     *
     * @param type Type of the background
     */
    @JsonCreator
    public ChatBackground(
            @JsonProperty("type") BackgroundType type) {
        this.type = type;
    }

    /**
     * Type of the background
     */
    public BackgroundType type() {
        return type;
    }

    public ChatBackground withType(BackgroundType type) {
        return new ChatBackground(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatBackground)) {
            return false;
        }
        ChatBackground that = (ChatBackground) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "ChatBackground[type=" + this.type
                + "]";
    }
}
