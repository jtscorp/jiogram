package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Animation;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.PhotoSize;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a game. Use BotFather to create and edit games, their short names will act
 * as unique identifiers.
 *
 * @param title Title of the game
 * @param description Description of the game
 * @param photo Photo that will be displayed in the game message in chats.
 * @param text Brief description of the game or high scores included in the game message. Can be
 *     automatically edited to include current high scores for the game when the bot calls
 *     setGameScore, or manually edited using editMessageText. 0-4096 characters.
 * @param textEntities Special entities that appear in text, such as usernames, URLs, bot commands,
 *     etc.
 * @param animation Animation that will be displayed in the game message in chats. Upload via
 *     BotFather
 * @see <a href="https://core.telegram.org/bots/api#game">Game in the Bot API</a>
 */
public record Game(
    @JsonProperty("title") String title,
    @JsonProperty("description") String description,
    @JsonProperty("photo") List<PhotoSize> photo,
    @JsonProperty("text") @Nullable String text,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
    @JsonProperty("animation") @Nullable Animation animation
) {

    public static Game of(String title, String description, List<PhotoSize> photo) {
        return new Game(title, description, photo, null, null, null);
    }

    public Game withTitle(String title) {
        return new Game(title, description, photo, text, textEntities, animation);
    }

    public Game withDescription(String description) {
        return new Game(title, description, photo, text, textEntities, animation);
    }

    public Game withPhoto(List<PhotoSize> photo) {
        return new Game(title, description, photo, text, textEntities, animation);
    }

    public Game withText(@Nullable String text) {
        return new Game(title, description, photo, text, textEntities, animation);
    }

    public Game withTextEntities(@Nullable List<MessageEntity> textEntities) {
        return new Game(title, description, photo, text, textEntities, animation);
    }

    public Game withAnimation(@Nullable Animation animation) {
        return new Game(title, description, photo, text, textEntities, animation);
    }
}
