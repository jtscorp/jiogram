package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Audio;
import java.util.List;

public record UserProfileAudios(
    @JsonProperty("total_count") long totalCount,
    @JsonProperty("audios") List<Audio> audios
) {}
