package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about the quoted part of a message that is replied to by the
 * given message.
 *
 * @param text Text of the quoted part of a message that is replied to by the given message
 * @param entities Special entities that appear in the quote. Currently, only bold, italic,
 *     underline, strikethrough, spoiler, custom_emoji, and date_time entities are kept in quotes.
 * @param position Approximate quote position in the original message in UTF-16 code units as
 *     specified by the sender
 * @param isManual True, if the quote was chosen manually by the message sender. Otherwise, the
 *     quote was added automatically by the server.
 * @see <a href="https://core.telegram.org/bots/api#textquote">TextQuote in the Bot API</a>
 */
public record TextQuote(
    @JsonProperty("text") String text,
    @JsonProperty("entities") @Nullable List<MessageEntity> entities,
    @JsonProperty("position") long position,
    @JsonProperty("is_manual") @Nullable Boolean isManual
) {}
