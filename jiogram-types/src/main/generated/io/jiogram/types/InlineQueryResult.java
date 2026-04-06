package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = InlineQueryResultArticle.class, name = "article"),
    @JsonSubTypes.Type(value = InlineQueryResultPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = InlineQueryResultGif.class, name = "gif"),
    @JsonSubTypes.Type(value = InlineQueryResultMpeg4Gif.class, name = "mpeg4_gif"),
    @JsonSubTypes.Type(value = InlineQueryResultVideo.class, name = "video"),
    @JsonSubTypes.Type(value = InlineQueryResultAudio.class, name = "audio"),
    @JsonSubTypes.Type(value = InlineQueryResultVoice.class, name = "voice"),
    @JsonSubTypes.Type(value = InlineQueryResultDocument.class, name = "document"),
    @JsonSubTypes.Type(value = InlineQueryResultLocation.class, name = "location"),
    @JsonSubTypes.Type(value = InlineQueryResultVenue.class, name = "venue"),
    @JsonSubTypes.Type(value = InlineQueryResultContact.class, name = "contact"),
    @JsonSubTypes.Type(value = InlineQueryResultGame.class, name = "game"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedSticker.class, name = "sticker"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedPhoto.class, name = "cached_photo"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedGif.class, name = "cached_gif"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedMpeg4Gif.class, name = "cached_mpeg4_gif"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedVideo.class, name = "cached_video"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedAudio.class, name = "cached_audio"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedVoice.class, name = "cached_voice"),
    @JsonSubTypes.Type(value = InlineQueryResultCachedDocument.class, name = "cached_document")
})
public sealed interface InlineQueryResult permits InlineQueryResultArticle, InlineQueryResultPhoto, InlineQueryResultGif, InlineQueryResultMpeg4Gif, InlineQueryResultVideo, InlineQueryResultAudio, InlineQueryResultVoice, InlineQueryResultDocument, InlineQueryResultLocation, InlineQueryResultVenue, InlineQueryResultContact, InlineQueryResultGame, InlineQueryResultCachedSticker, InlineQueryResultCachedPhoto, InlineQueryResultCachedGif, InlineQueryResultCachedMpeg4Gif, InlineQueryResultCachedVideo, InlineQueryResultCachedAudio, InlineQueryResultCachedVoice, InlineQueryResultCachedDocument {}
