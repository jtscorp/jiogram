package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class SharedUser {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("first_name") @Nullable private final String firstName;
    @JsonProperty("last_name") @Nullable private final String lastName;
    @JsonProperty("username") @Nullable private final String username;
    @JsonProperty("photo") @Nullable private final List<PhotoSize> photo;

    @JsonCreator
    public SharedUser(
            @JsonProperty("user_id") long userId,
            @JsonProperty("first_name") @Nullable String firstName,
            @JsonProperty("last_name") @Nullable String lastName,
            @JsonProperty("username") @Nullable String username,
            @JsonProperty("photo") @Nullable List<PhotoSize> photo
    ) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.photo = photo;
    }

    public long userId() {
        return this.userId;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public String username() {
        return this.username;
    }

    public List<PhotoSize> photo() {
        return this.photo;
    }
}
