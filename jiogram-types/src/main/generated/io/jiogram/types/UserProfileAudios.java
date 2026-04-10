package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Audio;
import java.util.List;

public class UserProfileAudios {
    @JsonProperty("total_count") private final long totalCount;
    @JsonProperty("audios") private final List<Audio> audios;

    @JsonCreator
    public UserProfileAudios(
            @JsonProperty("total_count") long totalCount,
            @JsonProperty("audios") List<Audio> audios
    ) {
        this.totalCount = totalCount;
        this.audios = audios;
    }

    public long totalCount() {
        return this.totalCount;
    }

    public List<Audio> audios() {
        return this.audios;
    }
}
