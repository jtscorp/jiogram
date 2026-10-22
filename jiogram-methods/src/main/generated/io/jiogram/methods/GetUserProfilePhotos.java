package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserProfilePhotos;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getuserprofilephotos">getUserProfilePhotos in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetUserProfilePhotos implements TelegramMethod<UserProfilePhotos> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("offset")
    private final @Nullable Long offset;

    @JsonProperty("limit")
    private final @Nullable Long limit;

    /**
     * Creates a new {@code GetUserProfilePhotos} instance.
     *
     * @param userId Unique identifier of the target user
     * @param offset Sequential number of the first photo to be returned. By default, all photos are
     *     returned.
     * @param limit Limits the number of photos to be retrieved. Values between 1-100 are accepted.
     *     Defaults to 100.
     */
    @JsonCreator
    public GetUserProfilePhotos(
            @JsonProperty("user_id") long userId,
            @JsonProperty("offset") @Nullable Long offset,
            @JsonProperty("limit") @Nullable Long limit) {
        this.userId = userId;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    public String apiMethod() {
        return "getUserProfilePhotos";
    }

    @Override
    public String apiReturnType() {
        return "UserProfilePhotos";
    }

    public static GetUserProfilePhotos of(long userId) {
        return new GetUserProfilePhotos(userId, null, null);
    }

    /**
     * Unique identifier of the target user
     */
    public long userId() {
        return userId;
    }

    /**
     * Sequential number of the first photo to be returned. By default, all photos are returned.
     */
    public @Nullable Long offset() {
        return offset;
    }

    /**
     * Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to
     * 100.
     */
    public @Nullable Long limit() {
        return limit;
    }

    public GetUserProfilePhotos withUserId(long userId) {
        return new GetUserProfilePhotos(userId, offset, limit);
    }

    public GetUserProfilePhotos withOffset(@Nullable Long offset) {
        return new GetUserProfilePhotos(userId, offset, limit);
    }

    public GetUserProfilePhotos withLimit(@Nullable Long limit) {
        return new GetUserProfilePhotos(userId, offset, limit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetUserProfilePhotos)) {
            return false;
        }
        GetUserProfilePhotos that = (GetUserProfilePhotos) o;
        return this.userId == that.userId
                && Objects.equals(this.offset, that.offset)
                && Objects.equals(this.limit, that.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.offset, this.limit);
    }

    @Override
    public String toString() {
        return "GetUserProfilePhotos[userId=" + this.userId
                + ", offset=" + this.offset
                + ", limit=" + this.limit
                + "]";
    }
}
