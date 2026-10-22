package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;
import java.util.Objects;

/**
 * This object represent a user's profile pictures.
 *
 * @see <a href="https://core.telegram.org/bots/api#userprofilephotos">UserProfilePhotos in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UserProfilePhotos {

    @JsonProperty("total_count")
    private final long totalCount;

    @JsonProperty("photos")
    private final List<List<PhotoSize>> photos;

    /**
     * Creates a new {@code UserProfilePhotos} instance.
     *
     * @param totalCount Total number of profile pictures the target user has
     * @param photos Requested profile pictures (in up to 4 sizes each)
     */
    @JsonCreator
    public UserProfilePhotos(
            @JsonProperty("total_count") long totalCount,
            @JsonProperty("photos") List<List<PhotoSize>> photos) {
        this.totalCount = totalCount;
        this.photos = photos;
    }

    /**
     * Total number of profile pictures the target user has
     */
    public long totalCount() {
        return totalCount;
    }

    /**
     * Requested profile pictures (in up to 4 sizes each)
     */
    public List<List<PhotoSize>> photos() {
        return photos;
    }

    public UserProfilePhotos withTotalCount(long totalCount) {
        return new UserProfilePhotos(totalCount, photos);
    }

    public UserProfilePhotos withPhotos(List<List<PhotoSize>> photos) {
        return new UserProfilePhotos(totalCount, photos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserProfilePhotos)) {
            return false;
        }
        UserProfilePhotos that = (UserProfilePhotos) o;
        return this.totalCount == that.totalCount
                && Objects.equals(this.photos, that.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.totalCount, this.photos);
    }

    @Override
    public String toString() {
        return "UserProfilePhotos[totalCount=" + this.totalCount
                + ", photos=" + this.photos
                + "]";
    }
}
