package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalStateType;
import java.util.Objects;

/**
 * The withdrawal succeeded.
 *
 * @see <a href="https://core.telegram.org/bots/api#revenuewithdrawalstatesucceeded">RevenueWithdrawalStateSucceeded in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RevenueWithdrawalStateSucceeded implements RevenueWithdrawalState {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final RevenueWithdrawalStateType type;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("url")
    private final String url;

    /**
     * Creates a new {@code RevenueWithdrawalStateSucceeded} instance.
     *
     * @param type Type of the state, always 'succeeded'
     * @param date Date the withdrawal was completed in Unix time
     * @param url An HTTPS URL that can be used to see transaction details
     */
    @JsonCreator
    public RevenueWithdrawalStateSucceeded(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) RevenueWithdrawalStateType type,
            @JsonProperty("date") long date,
            @JsonProperty("url") String url) {
        this.type = type;
        this.date = date;
        this.url = url;
    }

    public static RevenueWithdrawalStateSucceeded of(long date, String url) {
        return new RevenueWithdrawalStateSucceeded(RevenueWithdrawalStateType.SUCCEEDED, date, url);
    }

    /**
     * Type of the state, always 'succeeded'
     */
    public RevenueWithdrawalStateType type() {
        return type;
    }

    /**
     * Date the withdrawal was completed in Unix time
     */
    public long date() {
        return date;
    }

    /**
     * An HTTPS URL that can be used to see transaction details
     */
    public String url() {
        return url;
    }

    public RevenueWithdrawalStateSucceeded withDate(long date) {
        return new RevenueWithdrawalStateSucceeded(type, date, url);
    }

    public RevenueWithdrawalStateSucceeded withUrl(String url) {
        return new RevenueWithdrawalStateSucceeded(type, date, url);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RevenueWithdrawalStateSucceeded)) {
            return false;
        }
        RevenueWithdrawalStateSucceeded that = (RevenueWithdrawalStateSucceeded) o;
        return Objects.equals(this.type, that.type)
                && this.date == that.date
                && Objects.equals(this.url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.date, this.url);
    }

    @Override
    public String toString() {
        return "RevenueWithdrawalStateSucceeded[type=" + this.type
                + ", date=" + this.date
                + ", url=" + this.url
                + "]";
    }
}
