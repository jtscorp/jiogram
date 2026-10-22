package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntityType;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents one special entity in a text message. For example, hashtags, usernames,
 * URLs, etc.
 *
 * @see <a href="https://core.telegram.org/bots/api#messageentity">MessageEntity in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MessageEntity {

    @JsonProperty("type")
    private final MessageEntityType type;

    @JsonProperty("offset")
    private final long offset;

    @JsonProperty("length")
    private final long length;

    @JsonProperty("url")
    private final @Nullable String url;

    @JsonProperty("user")
    private final @Nullable User user;

    @JsonProperty("language")
    private final @Nullable String language;

    @JsonProperty("custom_emoji_id")
    private final @Nullable String customEmojiId;

    @JsonProperty("unix_time")
    private final @Nullable Long unixTime;

    @JsonProperty("date_time_format")
    private final @Nullable String dateTimeFormat;

    /**
     * Creates a new {@code MessageEntity} instance.
     *
     * @param type Type of the entity. Currently, can be 'mention' (&#64;username), 'hashtag'
     *     (#hashtag or #hashtag&#64;chatusername), 'cashtag' ($USD or $USD&#64;chatusername),
     *     'bot_command' (/start&#64;jobs_bot), 'url' (https://telegram.org), 'email'
     *     (do-not-reply&#64;telegram.org), 'phone_number' (+1-212-555-0123), 'bold' (bold text),
     *     'italic' (italic text), 'underline' (underlined text), 'strikethrough' (strikethrough
     *     text), 'spoiler' (spoiler message), 'blockquote' (block quotation),
     *     'expandable_blockquote' (collapsed-by-default block quotation), 'code' (monowidth
     *     string), 'pre' (monowidth block), 'text_link' (for clickable text URLs), 'text_mention'
     *     (for users without usernames), 'custom_emoji' (for inline custom emoji stickers), or
     *     'date_time' (for formatted date and time)
     * @param offset Offset in UTF-16 code units to the start of the entity
     * @param length Length of the entity in UTF-16 code units
     * @param url For 'text_link' only, URL that will be opened after user taps on the text
     * @param user For 'text_mention' only, the mentioned user
     * @param language For 'pre' only, the programming language of the entity text
     * @param customEmojiId For 'custom_emoji' only, unique identifier of the custom emoji. Use
     *     getCustomEmojiStickers to get full information about the sticker
     * @param unixTime For 'date_time' only, the Unix time associated with the entity
     * @param dateTimeFormat For 'date_time' only, the string that defines the formatting of the
     *     date and time. See date-time entity formatting for more details.
     */
    @JsonCreator
    public MessageEntity(
            @JsonProperty("type") MessageEntityType type,
            @JsonProperty("offset") long offset,
            @JsonProperty("length") long length,
            @JsonProperty("url") @Nullable String url,
            @JsonProperty("user") @Nullable User user,
            @JsonProperty("language") @Nullable String language,
            @JsonProperty("custom_emoji_id") @Nullable String customEmojiId,
            @JsonProperty("unix_time") @Nullable Long unixTime,
            @JsonProperty("date_time_format") @Nullable String dateTimeFormat) {
        this.type = type;
        this.offset = offset;
        this.length = length;
        this.url = url;
        this.user = user;
        this.language = language;
        this.customEmojiId = customEmojiId;
        this.unixTime = unixTime;
        this.dateTimeFormat = dateTimeFormat;
    }

    public static MessageEntity of(MessageEntityType type, long offset, long length) {
        return new MessageEntity(type, offset, length, null, null, null, null, null, null);
    }

    /**
     * Type of the entity. Currently, can be 'mention' (&#64;username), 'hashtag' (#hashtag or
     * #hashtag&#64;chatusername), 'cashtag' ($USD or $USD&#64;chatusername), 'bot_command'
     * (/start&#64;jobs_bot), 'url' (https://telegram.org), 'email' (do-not-reply&#64;telegram.org),
     * 'phone_number' (+1-212-555-0123), 'bold' (bold text), 'italic' (italic text), 'underline'
     * (underlined text), 'strikethrough' (strikethrough text), 'spoiler' (spoiler message),
     * 'blockquote' (block quotation), 'expandable_blockquote' (collapsed-by-default block
     * quotation), 'code' (monowidth string), 'pre' (monowidth block), 'text_link' (for clickable
     * text URLs), 'text_mention' (for users without usernames), 'custom_emoji' (for inline custom
     * emoji stickers), or 'date_time' (for formatted date and time)
     */
    public MessageEntityType type() {
        return type;
    }

    /**
     * Offset in UTF-16 code units to the start of the entity
     */
    public long offset() {
        return offset;
    }

    /**
     * Length of the entity in UTF-16 code units
     */
    public long length() {
        return length;
    }

    /**
     * For 'text_link' only, URL that will be opened after user taps on the text
     */
    public @Nullable String url() {
        return url;
    }

    /**
     * For 'text_mention' only, the mentioned user
     */
    public @Nullable User user() {
        return user;
    }

    /**
     * For 'pre' only, the programming language of the entity text
     */
    public @Nullable String language() {
        return language;
    }

    /**
     * For 'custom_emoji' only, unique identifier of the custom emoji. Use getCustomEmojiStickers to
     * get full information about the sticker
     */
    public @Nullable String customEmojiId() {
        return customEmojiId;
    }

    /**
     * For 'date_time' only, the Unix time associated with the entity
     */
    public @Nullable Long unixTime() {
        return unixTime;
    }

    /**
     * For 'date_time' only, the string that defines the formatting of the date and time. See
     * date-time entity formatting for more details.
     */
    public @Nullable String dateTimeFormat() {
        return dateTimeFormat;
    }

    public MessageEntity withType(MessageEntityType type) {
        return new MessageEntity(type, offset, length, url, user, language, customEmojiId, unixTime, dateTimeFormat);
    }

    public MessageEntity withOffset(long offset) {
        return new MessageEntity(type, offset, length, url, user, language, customEmojiId, unixTime, dateTimeFormat);
    }

    public MessageEntity withLength(long length) {
        return new MessageEntity(type, offset, length, url, user, language, customEmojiId, unixTime, dateTimeFormat);
    }

    public MessageEntity withUrl(@Nullable String url) {
        return new MessageEntity(type, offset, length, url, user, language, customEmojiId, unixTime, dateTimeFormat);
    }

    public MessageEntity withUser(@Nullable User user) {
        return new MessageEntity(type, offset, length, url, user, language, customEmojiId, unixTime, dateTimeFormat);
    }

    public MessageEntity withLanguage(@Nullable String language) {
        return new MessageEntity(type, offset, length, url, user, language, customEmojiId, unixTime, dateTimeFormat);
    }

    public MessageEntity withCustomEmojiId(@Nullable String customEmojiId) {
        return new MessageEntity(type, offset, length, url, user, language, customEmojiId, unixTime, dateTimeFormat);
    }

    public MessageEntity withUnixTime(@Nullable Long unixTime) {
        return new MessageEntity(type, offset, length, url, user, language, customEmojiId, unixTime, dateTimeFormat);
    }

    public MessageEntity withDateTimeFormat(@Nullable String dateTimeFormat) {
        return new MessageEntity(type, offset, length, url, user, language, customEmojiId, unixTime, dateTimeFormat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageEntity)) {
            return false;
        }
        MessageEntity that = (MessageEntity) o;
        return Objects.equals(this.type, that.type)
                && this.offset == that.offset
                && this.length == that.length
                && Objects.equals(this.url, that.url)
                && Objects.equals(this.user, that.user)
                && Objects.equals(this.language, that.language)
                && Objects.equals(this.customEmojiId, that.customEmojiId)
                && Objects.equals(this.unixTime, that.unixTime)
                && Objects.equals(this.dateTimeFormat, that.dateTimeFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.offset, this.length, this.url, this.user, this.language, this.customEmojiId, this.unixTime, this.dateTimeFormat);
    }

    @Override
    public String toString() {
        return "MessageEntity[type=" + this.type
                + ", offset=" + this.offset
                + ", length=" + this.length
                + ", url=" + this.url
                + ", user=" + this.user
                + ", language=" + this.language
                + ", customEmojiId=" + this.customEmojiId
                + ", unixTime=" + this.unixTime
                + ", dateTimeFormat=" + this.dateTimeFormat
                + "]";
    }
}
