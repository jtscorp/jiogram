package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import io.jiogram.types.TelegramMethod;
import java.util.List;

/**
 * Use this method to get custom emoji stickers, which can be used as a forum topic icon by any
 * user. Requires no parameters. Returns an Array of Sticker objects.
 *
 * @see <a href="https://core.telegram.org/bots/api#getforumtopiciconstickers">getForumTopicIconStickers in the Bot API</a>
 */
public record GetForumTopicIconStickers(

) implements TelegramMethod<List<Sticker>> {

    @Override
    public String apiMethod() {
        return "getForumTopicIconStickers";
    }

    @Override
    public String apiReturnType() {
        return "Array of Sticker";
    }
}
