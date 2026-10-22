package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Audio;
import java.util.List;
import java.util.Objects;

/**
 * This object represents the audios displayed on a user's profile.
 *
 * @see <a href="https://core.telegram.org/bots/api#userprofileaudios">UserProfileAudios in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UserProfileAudios {

    @JsonProperty("total_count")
    private final long totalCount;

    @JsonProperty("audios")
    private final List<Audio> audios;

    /**
     * Creates a new {@code UserProfileAudios} instance.
     *
     * @param totalCount Total number of profile audios for the target user
     * @param audios Requested profile audios
     */
    @JsonCreator
    public UserProfileAudios(
            @JsonProperty("total_count") long totalCount,
            @JsonProperty("audios") List<Audio> audios) {
        this.totalCount = totalCount;
        this.audios = audios;
    }

    /**
     * Total number of profile audios for the target user
     */
    public long totalCount() {
        return totalCount;
    }

    /**
     * Requested profile audios
     */
    public List<Audio> audios() {
        return audios;
    }

    public UserProfileAudios withTotalCount(long totalCount) {
        return new UserProfileAudios(totalCount, audios);
    }

    public UserProfileAudios withAudios(List<Audio> audios) {
        return new UserProfileAudios(totalCount, audios);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserProfileAudios)) {
            return false;
        }
        UserProfileAudios that = (UserProfileAudios) o;
        return this.totalCount == that.totalCount
                && Objects.equals(this.audios, that.audios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.totalCount, this.audios);
    }

    @Override
    public String toString() {
        return "UserProfileAudios[totalCount=" + this.totalCount
                + ", audios=" + this.audios
                + "]";
    }
}
