package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Contains information about the start page settings of a Telegram Business account.
 *
 * @see <a href="https://core.telegram.org/bots/api#businessintro">BusinessIntro in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BusinessIntro {

    @JsonProperty("title")
    private final @Nullable String title;

    @JsonProperty("message")
    private final @Nullable String message;

    @JsonProperty("sticker")
    private final @Nullable Sticker sticker;

    /**
     * Creates a new {@code BusinessIntro} instance.
     *
     * @param title Title text of the business intro
     * @param message Message text of the business intro
     * @param sticker Sticker of the business intro
     */
    @JsonCreator
    public BusinessIntro(
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("message") @Nullable String message,
            @JsonProperty("sticker") @Nullable Sticker sticker) {
        this.title = title;
        this.message = message;
        this.sticker = sticker;
    }

    public static BusinessIntro of() {
        return new BusinessIntro(null, null, null);
    }

    /**
     * Title text of the business intro
     */
    public @Nullable String title() {
        return title;
    }

    /**
     * Message text of the business intro
     */
    public @Nullable String message() {
        return message;
    }

    /**
     * Sticker of the business intro
     */
    public @Nullable Sticker sticker() {
        return sticker;
    }

    public BusinessIntro withTitle(@Nullable String title) {
        return new BusinessIntro(title, message, sticker);
    }

    public BusinessIntro withMessage(@Nullable String message) {
        return new BusinessIntro(title, message, sticker);
    }

    public BusinessIntro withSticker(@Nullable Sticker sticker) {
        return new BusinessIntro(title, message, sticker);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BusinessIntro)) {
            return false;
        }
        BusinessIntro that = (BusinessIntro) o;
        return Objects.equals(this.title, that.title)
                && Objects.equals(this.message, that.message)
                && Objects.equals(this.sticker, that.sticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.message, this.sticker);
    }

    @Override
    public String toString() {
        return "BusinessIntro[title=" + this.title
                + ", message=" + this.message
                + ", sticker=" + this.sticker
                + "]";
    }
}
