package io.jiogram.bot;

import io.jiogram.types.ParseMode;
import org.jspecify.annotations.Nullable;

/**
 * Default properties applied to outgoing bot requests.
 */
public final class DefaultBotProperties {

    private final @Nullable ParseMode parseMode;
    private final boolean protectContent;
    private final boolean linkPreview;

    public DefaultBotProperties(@Nullable ParseMode parseMode, boolean protectContent, boolean linkPreview) {
        this.parseMode = parseMode;
        this.protectContent = protectContent;
        this.linkPreview = linkPreview;
    }

    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    public boolean protectContent() {
        return protectContent;
    }

    public boolean linkPreview() {
        return linkPreview;
    }

    /**
     * Returns a DefaultBotProperties with sensible defaults:
     * no parse mode, content not protected, link previews enabled.
     */
    public static DefaultBotProperties defaults() {
        return new DefaultBotProperties(null, false, true);
    }
}
