package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to set the title of a created sticker set. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setstickersettitle">setStickerSetTitle in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetStickerSetTitle implements TelegramMethod<Boolean> {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("title")
    private final String title;

    /**
     * Creates a new {@code SetStickerSetTitle} instance.
     *
     * @param name Sticker set name
     * @param title Sticker set title, 1-64 characters
     */
    @JsonCreator
    public SetStickerSetTitle(
            @JsonProperty("name") String name,
            @JsonProperty("title") String title) {
        this.name = name;
        this.title = title;
    }

    @Override
    public String apiMethod() {
        return "setStickerSetTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Sticker set name
     */
    public String name() {
        return name;
    }

    /**
     * Sticker set title, 1-64 characters
     */
    public String title() {
        return title;
    }

    public SetStickerSetTitle withName(String name) {
        return new SetStickerSetTitle(name, title);
    }

    public SetStickerSetTitle withTitle(String title) {
        return new SetStickerSetTitle(name, title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetStickerSetTitle)) {
            return false;
        }
        SetStickerSetTitle that = (SetStickerSetTitle) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.title);
    }

    @Override
    public String toString() {
        return "SetStickerSetTitle[name=" + this.name
                + ", title=" + this.title
                + "]";
    }
}
