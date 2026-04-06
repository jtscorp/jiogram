package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoost;
import java.util.List;

public record UserChatBoosts(
    @JsonProperty("boosts") List<ChatBoost> boosts
) {}
