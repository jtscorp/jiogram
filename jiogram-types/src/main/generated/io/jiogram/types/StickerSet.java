package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.Sticker;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record StickerSet(
    @JsonProperty("name") String name,
    @JsonProperty("title") String title,
    @JsonProperty("sticker_type") String stickerType,
    @JsonProperty("stickers") List<Sticker> stickers,
    @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail
) {}
