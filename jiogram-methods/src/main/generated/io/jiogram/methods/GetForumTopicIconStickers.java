package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import io.jiogram.types.Sticker;
import io.jiogram.types.TelegramMethod;
import java.util.List;

/**
 * Use this method to get custom emoji stickers, which can be used as a forum topic icon by any
 * user. Requires no parameters. Returns an Array of Sticker objects.
 *
 * @see <a href="https://core.telegram.org/bots/api#getforumtopiciconstickers">getForumTopicIconStickers in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetForumTopicIconStickers implements TelegramMethod<List<Sticker>> {

    /**
     * Creates a new {@code GetForumTopicIconStickers} instance.
     */
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

    @Override
    public boolean equals(Object o) {
        return o instanceof GetForumTopicIconStickers;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "GetForumTopicIconStickers[]";
    }
}
