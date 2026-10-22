package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Animation;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.PhotoSize;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a game. Use BotFather to create and edit games, their short names will act
 * as unique identifiers.
 *
 * @see <a href="https://core.telegram.org/bots/api#game">Game in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Game {

    @JsonProperty("title")
    private final String title;

    @JsonProperty("description")
    private final String description;

    @JsonProperty("photo")
    private final List<PhotoSize> photo;

    @JsonProperty("text")
    private final @Nullable String text;

    @JsonProperty("text_entities")
    private final @Nullable List<MessageEntity> textEntities;

    @JsonProperty("animation")
    private final @Nullable Animation animation;

    /**
     * Creates a new {@code Game} instance.
     *
     * @param title Title of the game
     * @param description Description of the game
     * @param photo Photo that will be displayed in the game message in chats.
     * @param text Brief description of the game or high scores included in the game message. Can be
     *     automatically edited to include current high scores for the game when the bot calls
     *     setGameScore, or manually edited using editMessageText. 0-4096 characters.
     * @param textEntities Special entities that appear in text, such as usernames, URLs, bot
     *     commands, etc.
     * @param animation Animation that will be displayed in the game message in chats. Upload via
     *     BotFather
     */
    @JsonCreator
    public Game(
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("photo") List<PhotoSize> photo,
            @JsonProperty("text") @Nullable String text,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
            @JsonProperty("animation") @Nullable Animation animation) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.text = text;
        this.textEntities = textEntities;
        this.animation = animation;
    }

    public static Game of(String title, String description, List<PhotoSize> photo) {
        return new Game(title, description, photo, null, null, null);
    }

    /**
     * Title of the game
     */
    public String title() {
        return title;
    }

    /**
     * Description of the game
     */
    public String description() {
        return description;
    }

    /**
     * Photo that will be displayed in the game message in chats.
     */
    public List<PhotoSize> photo() {
        return photo;
    }

    /**
     * Brief description of the game or high scores included in the game message. Can be
     * automatically edited to include current high scores for the game when the bot calls
     * setGameScore, or manually edited using editMessageText. 0-4096 characters.
     */
    public @Nullable String text() {
        return text;
    }

    /**
     * Special entities that appear in text, such as usernames, URLs, bot commands, etc.
     */
    public @Nullable List<MessageEntity> textEntities() {
        return textEntities;
    }

    /**
     * Animation that will be displayed in the game message in chats. Upload via BotFather
     */
    public @Nullable Animation animation() {
        return animation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Game)) {
            return false;
        }
        Game that = (Game) o;
        return Objects.equals(this.title, that.title)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.photo, that.photo)
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.textEntities, that.textEntities)
                && Objects.equals(this.animation, that.animation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.description, this.photo, this.text, this.textEntities, this.animation);
    }

    @Override
    public String toString() {
        return "Game[title=" + this.title
                + ", description=" + this.description
                + ", photo=" + this.photo
                + ", text=" + this.text
                + ", textEntities=" + this.textEntities
                + ", animation=" + this.animation
                + "]";
    }
}
