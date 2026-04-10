package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.Sticker;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class StickerSet {
    @JsonProperty("name") private final String name;
    @JsonProperty("title") private final String title;
    @JsonProperty("sticker_type") private final String stickerType;
    @JsonProperty("stickers") private final List<Sticker> stickers;
    @JsonProperty("thumbnail") @Nullable private final PhotoSize thumbnail;

    @JsonCreator
    public StickerSet(
            @JsonProperty("name") String name,
            @JsonProperty("title") String title,
            @JsonProperty("sticker_type") String stickerType,
            @JsonProperty("stickers") List<Sticker> stickers,
            @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail
    ) {
        this.name = name;
        this.title = title;
        this.stickerType = stickerType;
        this.stickers = stickers;
        this.thumbnail = thumbnail;
    }

    public String name() {
        return this.name;
    }

    public String title() {
        return this.title;
    }

    public String stickerType() {
        return this.stickerType;
    }

    public List<Sticker> stickers() {
        return this.stickers;
    }

    public PhotoSize thumbnail() {
        return this.thumbnail;
    }
}
