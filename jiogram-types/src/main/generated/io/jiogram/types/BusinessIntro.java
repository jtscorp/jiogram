package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import org.jspecify.annotations.Nullable;

/**
 * Contains information about the start page settings of a Telegram Business account.
 *
 * @param title Title text of the business intro
 * @param message Message text of the business intro
 * @param sticker Sticker of the business intro
 * @see <a href="https://core.telegram.org/bots/api#businessintro">BusinessIntro in the Bot API</a>
 */
public record BusinessIntro(
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("message") @Nullable String message,
    @JsonProperty("sticker") @Nullable Sticker sticker
) {

    public BusinessIntro withTitle(@Nullable String title) {
        return new BusinessIntro(title, message, sticker);
    }

    public BusinessIntro withMessage(@Nullable String message) {
        return new BusinessIntro(title, message, sticker);
    }

    public BusinessIntro withSticker(@Nullable Sticker sticker) {
        return new BusinessIntro(title, message, sticker);
    }
}
