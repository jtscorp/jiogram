package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record DeleteStory(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("story_id") long storyId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteStory";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
