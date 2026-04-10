package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class CreateNewStickerSet implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("name") private final String name;
    @JsonProperty("title") private final String title;
    @JsonProperty("stickers") private final List<InputSticker> stickers;
    @JsonProperty("sticker_type") @Nullable private final String stickerType;
    @JsonProperty("needs_repainting") @Nullable private final Boolean needsRepainting;

    @JsonCreator
    public CreateNewStickerSet(
            @JsonProperty("user_id") long userId,
            @JsonProperty("name") String name,
            @JsonProperty("title") String title,
            @JsonProperty("stickers") List<InputSticker> stickers,
            @JsonProperty("sticker_type") @Nullable String stickerType,
            @JsonProperty("needs_repainting") @Nullable Boolean needsRepainting
    ) {
        this.userId = userId;
        this.name = name;
        this.title = title;
        this.stickers = stickers;
        this.stickerType = stickerType;
        this.needsRepainting = needsRepainting;
    }

    public long userId() {
        return this.userId;
    }

    public String name() {
        return this.name;
    }

    public String title() {
        return this.title;
    }

    public List<InputSticker> stickers() {
        return this.stickers;
    }

    public String stickerType() {
        return this.stickerType;
    }

    public Boolean needsRepainting() {
        return this.needsRepainting;
    }

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
