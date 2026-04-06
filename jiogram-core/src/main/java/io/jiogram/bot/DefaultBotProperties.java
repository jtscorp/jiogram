package io.jiogram.bot;

import org.jspecify.annotations.Nullable;

/**
 * Default properties applied to outgoing bot requests.
 *
 * @param parseMode      the default parse mode (e.g. "HTML", "MarkdownV2"), or null for none
 * @param protectContent whether to protect content from forwarding by default
 * @param linkPreview    whether to enable link previews by default
 */
public record DefaultBotProperties(
    @Nullable String parseMode,
    boolean protectContent,
    boolean linkPreview
) {

    /**
     * Returns a DefaultBotProperties with sensible defaults:
     * no parse mode, content not protected, link previews enabled.
     */
    public static DefaultBotProperties defaults() {
        return new DefaultBotProperties(null, false, true);
    }
}
