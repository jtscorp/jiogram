package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.StickerType;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

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
}
