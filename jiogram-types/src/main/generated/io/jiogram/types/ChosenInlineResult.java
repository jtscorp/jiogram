package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class ChosenInlineResult {
    @JsonProperty("result_id") private final String resultId;
    @JsonProperty("from") private final User from;
    @JsonProperty("location") @Nullable private final Location location;
    @JsonProperty("inline_message_id") @Nullable private final String inlineMessageId;
    @JsonProperty("query") private final String query;

    @JsonCreator
    public ChosenInlineResult(
            @JsonProperty("result_id") String resultId,
            @JsonProperty("from") User from,
            @JsonProperty("location") @Nullable Location location,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("query") String query
    ) {
        this.resultId = resultId;
        this.from = from;
        this.location = location;
        this.inlineMessageId = inlineMessageId;
        this.query = query;
    }

    public String resultId() {
        return this.resultId;
    }

    public User from() {
        return this.from;
    }

    public Location location() {
        return this.location;
    }

    public String inlineMessageId() {
        return this.inlineMessageId;
    }

    public String query() {
        return this.query;
    }
}
