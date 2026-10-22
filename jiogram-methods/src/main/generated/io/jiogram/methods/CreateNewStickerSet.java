package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.StickerType;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to create a new sticker set owned by a user. The bot will be able to edit the
 * sticker set thus created. Returns True on success.
 *
 * @param userId User identifier of created sticker set owner
 * @param name Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can
 *     contain only English letters, digits and underscores. Must begin with a letter, can't contain
 *     consecutive underscores and must end in "_by_&lt;bot_username&gt;". &lt;bot_username&gt; is
 *     case insensitive. 1-64 characters.
 * @param title Sticker set title, 1-64 characters
 * @param stickers A JSON-serialized list of 1-50 initial stickers to be added to the sticker set
 * @param stickerType Type of stickers in the set, pass 'regular', 'mask', or 'custom_emoji'. By
 *     default, a regular sticker set is created.
 * @param needsRepainting Pass True if stickers in the sticker set must be repainted to the color of
 *     text when used in messages, the accent color if used as emoji status, white on chat photos,
 *     or another appropriate color based on context; for custom emoji sticker sets only
 * @see <a href="https://core.telegram.org/bots/api#createnewstickerset">createNewStickerSet in the Bot API</a>
 */
public record CreateNewStickerSet(
    @JsonProperty("user_id") long userId,
    @JsonProperty("name") String name,
    @JsonProperty("title") String title,
    @JsonProperty("stickers") List<InputSticker> stickers,
    @JsonProperty("sticker_type") @Nullable StickerType stickerType,
    @JsonProperty("needs_repainting") @Nullable Boolean needsRepainting
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "createNewStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static CreateNewStickerSet of(long userId, String name, String title, List<InputSticker> stickers) {
        return new CreateNewStickerSet(userId, name, title, stickers, null, null);
    }

    public CreateNewStickerSet withUserId(long userId) {
        return new CreateNewStickerSet(userId, name, title, stickers, stickerType, needsRepainting);
    }

    public CreateNewStickerSet withName(String name) {
        return new CreateNewStickerSet(userId, name, title, stickers, stickerType, needsRepainting);
    }

    public CreateNewStickerSet withTitle(String title) {
        return new CreateNewStickerSet(userId, name, title, stickers, stickerType, needsRepainting);
    }

    public CreateNewStickerSet withStickers(List<InputSticker> stickers) {
        return new CreateNewStickerSet(userId, name, title, stickers, stickerType, needsRepainting);
    }

    public CreateNewStickerSet withStickerType(@Nullable StickerType stickerType) {
        return new CreateNewStickerSet(userId, name, title, stickers, stickerType, needsRepainting);
    }

    public CreateNewStickerSet withNeedsRepainting(@Nullable Boolean needsRepainting) {
        return new CreateNewStickerSet(userId, name, title, stickers, stickerType, needsRepainting);
    }
}
