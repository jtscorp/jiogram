package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Changes the bio of a managed business account. Requires the can_change_bio business bot right.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setbusinessaccountbio">setBusinessAccountBio in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetBusinessAccountBio implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("bio")
    private final @Nullable String bio;

    /**
     * Creates a new {@code SetBusinessAccountBio} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param bio The new value of the bio for the business account; 0-140 characters
     */
    @JsonCreator
    public SetBusinessAccountBio(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("bio") @Nullable String bio) {
        this.businessConnectionId = businessConnectionId;
        this.bio = bio;
    }

    @Override
    public String apiMethod() {
        return "setBusinessAccountBio";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetBusinessAccountBio of(String businessConnectionId) {
        return new SetBusinessAccountBio(businessConnectionId, null);
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * The new value of the bio for the business account; 0-140 characters
     */
    public @Nullable String bio() {
        return bio;
    }

    public SetBusinessAccountBio withBusinessConnectionId(String businessConnectionId) {
        return new SetBusinessAccountBio(businessConnectionId, bio);
    }

    public SetBusinessAccountBio withBio(@Nullable String bio) {
        return new SetBusinessAccountBio(businessConnectionId, bio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetBusinessAccountBio)) {
            return false;
        }
        SetBusinessAccountBio that = (SetBusinessAccountBio) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.bio, that.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.bio);
    }

    @Override
    public String toString() {
        return "SetBusinessAccountBio[businessConnectionId=" + this.businessConnectionId
                + ", bio=" + this.bio
                + "]";
    }
}
