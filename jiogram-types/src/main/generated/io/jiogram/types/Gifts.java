package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import java.util.List;

public class Gifts {
    @JsonProperty("gifts") private final List<Gift> gifts;

    @JsonCreator
    public Gifts(
            @JsonProperty("gifts") List<Gift> gifts
    ) {
        this.gifts = gifts;
    }

    public List<Gift> gifts() {
        return this.gifts;
    }
}
