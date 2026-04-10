package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class DeleteStory implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("story_id") private final long storyId;

    @JsonCreator
    public DeleteStory(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("story_id") long storyId
    ) {
        this.businessConnectionId = businessConnectionId;
        this.storyId = storyId;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public long storyId() {
        return this.storyId;
    }

    @Override
    public String apiMethod() {
        return "deleteStory";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
