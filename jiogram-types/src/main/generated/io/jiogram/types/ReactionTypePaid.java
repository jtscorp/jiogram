package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;
import java.util.Objects;

/**
 * The reaction is paid.
 *
 * @see <a href="https://core.telegram.org/bots/api#reactiontypepaid">ReactionTypePaid in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReactionTypePaid implements ReactionType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final ReactionTypeType type;

    /**
     * Creates a new {@code ReactionTypePaid} instance.
     *
     * @param type Type of the reaction, always 'paid'
     */
    @JsonCreator
    public ReactionTypePaid(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) ReactionTypeType type) {
        this.type = type;
    }

    public static ReactionTypePaid of() {
        return new ReactionTypePaid(ReactionTypeType.PAID);
    }

    /**
     * Type of the reaction, always 'paid'
     */
    public ReactionTypeType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReactionTypePaid)) {
            return false;
        }
        ReactionTypePaid that = (ReactionTypePaid) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "ReactionTypePaid[type=" + this.type
                + "]";
    }
}
