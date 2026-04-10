package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoost;
import java.util.List;

public class UserChatBoosts {
    @JsonProperty("boosts") private final List<ChatBoost> boosts;

    @JsonCreator
    public UserChatBoosts(
            @JsonProperty("boosts") List<ChatBoost> boosts
    ) {
        this.boosts = boosts;
    }

    public List<ChatBoost> boosts() {
        return this.boosts;
    }
}
