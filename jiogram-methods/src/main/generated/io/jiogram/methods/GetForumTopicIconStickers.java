package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import io.jiogram.types.TelegramMethod;
import java.util.List;

public class GetForumTopicIconStickers implements TelegramMethod<List<Sticker>> {
    @JsonCreator
    public GetForumTopicIconStickers() {
    }

    @Override
    public String apiMethod() {
        return "getForumTopicIconStickers";
    }

    @Override
    public String apiReturnType() {
        return "Array of Sticker";
    }
}
