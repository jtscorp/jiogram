package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public class GameHighScore {
    @JsonProperty("position") private final long position;
    @JsonProperty("user") private final User user;
    @JsonProperty("score") private final long score;

    @JsonCreator
    public GameHighScore(
            @JsonProperty("position") long position,
            @JsonProperty("user") User user,
            @JsonProperty("score") long score
    ) {
        this.position = position;
        this.user = user;
        this.score = score;
    }

    public long position() {
        return this.position;
    }

    public User user() {
        return this.user;
    }

    public long score() {
        return this.score;
    }
}
