package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import java.util.List;

public record Gifts(
    @JsonProperty("gifts") List<Gift> gifts
) {}
