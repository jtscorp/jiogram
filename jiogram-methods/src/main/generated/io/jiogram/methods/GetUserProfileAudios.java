package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserProfileAudios;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get a list of profile audios for a user. Returns a UserProfileAudios object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getuserprofileaudios">getUserProfileAudios in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetUserProfileAudios implements TelegramMethod<UserProfileAudios> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("offset")
    private final @Nullable Long offset;

    @JsonProperty("limit")
    private final @Nullable Long limit;

    /**
     * Creates a new {@code GetUserProfileAudios} instance.
     *
     * @param userId Unique identifier of the target user
     * @param offset Sequential number of the first audio to be returned. By default, all audios are
     *     returned.
     * @param limit Limits the number of audios to be retrieved. Values between 1-100 are accepted.
     *     Defaults to 100.
     */
    @JsonCreator
    public GetUserProfileAudios(
            @JsonProperty("user_id") long userId,
            @JsonProperty("offset") @Nullable Long offset,
            @JsonProperty("limit") @Nullable Long limit) {
        this.userId = userId;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    public String apiMethod() {
        return "getUserProfileAudios";
    }

    @Override
    public String apiReturnType() {
        return "UserProfileAudios";
    }

    public static GetUserProfileAudios of(long userId) {
        return new GetUserProfileAudios(userId, null, null);
    }

    /**
     * Unique identifier of the target user
     */
    public long userId() {
        return userId;
    }

    /**
     * Sequential number of the first audio to be returned. By default, all audios are returned.
     */
    public @Nullable Long offset() {
        return offset;
    }

    /**
     * Limits the number of audios to be retrieved. Values between 1-100 are accepted. Defaults to
     * 100.
     */
    public @Nullable Long limit() {
        return limit;
    }

    public GetUserProfileAudios withUserId(long userId) {
        return new GetUserProfileAudios(userId, offset, limit);
    }

    public GetUserProfileAudios withOffset(@Nullable Long offset) {
        return new GetUserProfileAudios(userId, offset, limit);
    }

    public GetUserProfileAudios withLimit(@Nullable Long limit) {
        return new GetUserProfileAudios(userId, offset, limit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetUserProfileAudios)) {
            return false;
        }
        GetUserProfileAudios that = (GetUserProfileAudios) o;
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
        return "GetUserProfileAudios[userId=" + this.userId
                + ", offset=" + this.offset
                + ", limit=" + this.limit
                + "]";
    }
}
