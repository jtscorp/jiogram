package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatBoostSource;

public record ChatBoostRemoved(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("boost_id") String boostId,
    @JsonProperty("remove_date") long removeDate,
    @JsonProperty("source") ChatBoostSource source
) {}
