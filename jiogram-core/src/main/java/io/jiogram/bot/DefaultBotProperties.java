package io.jiogram.bot;

import io.jiogram.types.ParseMode;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

/**
 * Default properties applied to outgoing bot requests.
 */
public final class DefaultBotProperties {

    private final @Nullable ParseMode parseMode;
    private final boolean protectContent;
    private final boolean linkPreview;

    /**
     * Creates default bot properties.
     *
     * @param parseMode      the default parse mode, or null for none
     * @param protectContent whether to protect content from forwarding by default
     * @param linkPreview    whether to enable link previews by default
     */
    public DefaultBotProperties(@Nullable ParseMode parseMode, boolean protectContent, boolean linkPreview) {
        this.parseMode = parseMode;
        this.protectContent = protectContent;
        this.linkPreview = linkPreview;
    }

    /**
     * Returns the default parse mode, or null for none.
     */
    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    /**
     * Returns whether to protect content from forwarding by default.
     */
    public boolean protectContent() {
        return protectContent;
    }

    /**
     * Returns whether to enable link previews by default.
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DefaultBotProperties)) {
            return false;
        }
        DefaultBotProperties that = (DefaultBotProperties) o;
        return protectContent == that.protectContent
            && linkPreview == that.linkPreview
            && parseMode == that.parseMode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parseMode, protectContent, linkPreview);
    }

    @Override
    public String toString() {
        return "DefaultBotProperties[parseMode=" + parseMode
            + ", protectContent=" + protectContent
            + ", linkPreview=" + linkPreview + "]";
    }
}
