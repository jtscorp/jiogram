package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object represents one result of an inline query. Telegram clients currently support results
 * of the following 20 types:
 * <br>- InlineQueryResultCachedAudio
 * <br>- InlineQueryResultCachedDocument
 * <br>- InlineQueryResultCachedGif
 * <br>- InlineQueryResultCachedMpeg4Gif
 * <br>- InlineQueryResultCachedPhoto
 * <br>- InlineQueryResultCachedSticker
 * <br>- InlineQueryResultCachedVideo
 * <br>- InlineQueryResultCachedVoice
 * <br>- InlineQueryResultArticle
 * <br>- InlineQueryResultAudio
 * <br>- InlineQueryResultContact
 * <br>- InlineQueryResultGame
 * <br>- InlineQueryResultDocument
 * <br>- InlineQueryResultGif
 * <br>- InlineQueryResultLocation
 * <br>- InlineQueryResultMpeg4Gif
 * <br>- InlineQueryResultPhoto
 * <br>- InlineQueryResultVenue
 * <br>- InlineQueryResultVideo
 * <br>- InlineQueryResultVoice
 * <br>Note: All URLs passed in inline query results will be available to end users and therefore
 * must be assumed to be public.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresult">InlineQueryResult in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = InlineQueryResultUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = InlineQueryResultArticle.class, name = "article"),
    @JsonSubTypes.Type(value = InlineQueryResultAudio.class, name = "audio"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedAudio.class, name = "audio"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedDocument.class, name = "document"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedGif.class, name = "gif"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedMpeg4Gif.class, name = "mpeg4_gif"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedVideo.class, name = "video"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedVoice.class, name = "voice"),
    @JsonSubTypes.Type(value = InlineQueryResultContact.class, name = "contact"),
    @JsonSubTypes.Type(value = InlineQueryResultDocument.class, name = "document"),
    @JsonSubTypes.Type(value = InlineQueryResultGame.class, name = "game"),
    @JsonSubTypes.Type(value = InlineQueryResultGif.class, name = "gif"),
    @JsonSubTypes.Type(value = InlineQueryResultLocation.class, name = "location"),
    @JsonSubTypes.Type(value = InlineQueryResultMpeg4Gif.class, name = "mpeg4_gif"),
    @JsonSubTypes.Type(value = InlineQueryResultPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedSticker.class, name = "sticker"),
    @JsonSubTypes.Type(value = InlineQueryResultVenue.class, name = "venue"),
    @JsonSubTypes.Type(value = InlineQueryResultVideo.class, name = "video"),
    @JsonSubTypes.Type(value = InlineQueryResultVoice.class, name = "voice")
})
public interface InlineQueryResult {}
