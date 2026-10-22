package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Changes the first and last name of a managed business account. Requires the can_change_name
 * business bot right. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setbusinessaccountname">setBusinessAccountName in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetBusinessAccountName implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("first_name")
    private final String firstName;

    @JsonProperty("last_name")
    private final @Nullable String lastName;

    /**
     * Creates a new {@code SetBusinessAccountName} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param firstName The new value of the first name for the business account; 1-64 characters
     * @param lastName The new value of the last name for the business account; 0-64 characters
     */
    @JsonCreator
    public SetBusinessAccountName(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") @Nullable String lastName) {
        this.businessConnectionId = businessConnectionId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String apiMethod() {
        return "setBusinessAccountName";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetBusinessAccountName of(String businessConnectionId, String firstName) {
        return new SetBusinessAccountName(businessConnectionId, firstName, null);
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * The new value of the first name for the business account; 1-64 characters
     */
    public String firstName() {
        return firstName;
    }

    /**
     * The new value of the last name for the business account; 0-64 characters
     */
    public @Nullable String lastName() {
        return lastName;
    }

    public SetBusinessAccountName withBusinessConnectionId(String businessConnectionId) {
        return new SetBusinessAccountName(businessConnectionId, firstName, lastName);
    }

    public SetBusinessAccountName withFirstName(String firstName) {
        return new SetBusinessAccountName(businessConnectionId, firstName, lastName);
    }

    public SetBusinessAccountName withLastName(@Nullable String lastName) {
        return new SetBusinessAccountName(businessConnectionId, firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetBusinessAccountName)) {
            return false;
        }
        SetBusinessAccountName that = (SetBusinessAccountName) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.firstName, that.firstName)
                && Objects.equals(this.lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.firstName, this.lastName);
    }

    @Override
    public String toString() {
        return "SetBusinessAccountName[businessConnectionId=" + this.businessConnectionId
                + ", firstName=" + this.firstName
                + ", lastName=" + this.lastName
                + "]";
    }
}
