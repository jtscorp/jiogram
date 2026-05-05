package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputStoryContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.Story;
import io.jiogram.types.StoryArea;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record PostStory(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("content") InputStoryContent content,
    @JsonProperty("active_period") long activePeriod,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("areas") @Nullable List<StoryArea> areas,
    @JsonProperty("post_to_chat_page") @Nullable Boolean postToChatPage,
    @JsonProperty("protect_content") @Nullable Boolean protectContent
) implements TelegramMethod<Story> {

    @Override
    public String apiMethod() {
        return "postStory";
    }

    @Override
    public String apiReturnType() {
        return "Story";
    }

    public static PostStory of(String businessConnectionId, InputStoryContent content, long activePeriod) {
        return new PostStory(businessConnectionId, content, activePeriod, null, null, null, null, null, null);
    }
}
