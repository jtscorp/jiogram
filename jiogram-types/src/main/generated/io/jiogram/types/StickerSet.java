package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.Sticker;
import io.jiogram.types.StickerType;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record StickerSet(
    @JsonProperty("name") String name,
    @JsonProperty("title") String title,
    @JsonProperty("sticker_type") StickerType stickerType,
    @JsonProperty("stickers") List<Sticker> stickers,
    @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail
) {}
