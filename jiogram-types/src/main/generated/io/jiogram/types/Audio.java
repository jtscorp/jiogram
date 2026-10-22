package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 *
 * @see <a href="https://core.telegram.org/bots/api#audio">Audio in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Audio {

    @JsonProperty("file_id")
    private final String fileId;

    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    @JsonProperty("duration")
    private final long duration;

    @JsonProperty("performer")
    private final @Nullable String performer;

    @JsonProperty("title")
    private final @Nullable String title;

    @JsonProperty("file_name")
    private final @Nullable String fileName;

    @JsonProperty("mime_type")
    private final @Nullable String mimeType;

    @JsonProperty("file_size")
    private final @Nullable Long fileSize;

    @JsonProperty("thumbnail")
    private final @Nullable PhotoSize thumbnail;

    /**
     * Creates a new {@code Audio} instance.
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over
     *     time and for different bots. Can't be used to download or reuse the file.
     * @param duration Duration of the audio in seconds as defined by the sender
     * @param performer Performer of the audio as defined by the sender or by audio tags
     * @param title Title of the audio as defined by the sender or by audio tags
     * @param fileName Original filename as defined by the sender
     * @param mimeType MIME type of the file as defined by the sender
     * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages
     *     may have difficulty/silent defects in interpreting it. But it has at most 52 significant
     *     bits, so a signed 64-bit integer or double-precision float type are safe for storing this
     *     value.
     * @param thumbnail Thumbnail of the album cover to which the music file belongs
     */
    @JsonCreator
    public Audio(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("duration") long duration,
            @JsonProperty("performer") @Nullable String performer,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("file_name") @Nullable String fileName,
            @JsonProperty("mime_type") @Nullable String mimeType,
            @JsonProperty("file_size") @Nullable Long fileSize,
            @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.duration = duration;
        this.performer = performer;
        this.title = title;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
        this.thumbnail = thumbnail;
    }

    public static Audio of(String fileId, String fileUniqueId, long duration) {
        return new Audio(fileId, fileUniqueId, duration, null, null, null, null, null, null);
    }

    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    public String fileId() {
        return fileId;
    }

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different
     * bots. Can't be used to download or reuse the file.
     */
    public String fileUniqueId() {
        return fileUniqueId;
    }

    /**
     * Duration of the audio in seconds as defined by the sender
     */
    public long duration() {
        return duration;
    }

    /**
     * Performer of the audio as defined by the sender or by audio tags
     */
    public @Nullable String performer() {
        return performer;
    }

    /**
     * Title of the audio as defined by the sender or by audio tags
     */
    public @Nullable String title() {
        return title;
    }

    /**
     * Original filename as defined by the sender
     */
    public @Nullable String fileName() {
        return fileName;
    }

    /**
     * MIME type of the file as defined by the sender
     */
    public @Nullable String mimeType() {
        return mimeType;
    }

    /**
     * File size in bytes. It can be bigger than 2^31 and some programming languages may have
     * difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a
     * signed 64-bit integer or double-precision float type are safe for storing this value.
     */
    public @Nullable Long fileSize() {
        return fileSize;
    }

    /**
     * Thumbnail of the album cover to which the music file belongs
     */
    public @Nullable PhotoSize thumbnail() {
        return thumbnail;
    }

    public Audio withFileId(String fileId) {
        return new Audio(fileId, fileUniqueId, duration, performer, title, fileName, mimeType, fileSize, thumbnail);
    }

    public Audio withFileUniqueId(String fileUniqueId) {
        return new Audio(fileId, fileUniqueId, duration, performer, title, fileName, mimeType, fileSize, thumbnail);
    }

    public Audio withDuration(long duration) {
        return new Audio(fileId, fileUniqueId, duration, performer, title, fileName, mimeType, fileSize, thumbnail);
    }

    public Audio withPerformer(@Nullable String performer) {
        return new Audio(fileId, fileUniqueId, duration, performer, title, fileName, mimeType, fileSize, thumbnail);
    }

    public Audio withTitle(@Nullable String title) {
        return new Audio(fileId, fileUniqueId, duration, performer, title, fileName, mimeType, fileSize, thumbnail);
    }

    public Audio withFileName(@Nullable String fileName) {
        return new Audio(fileId, fileUniqueId, duration, performer, title, fileName, mimeType, fileSize, thumbnail);
    }

    public Audio withMimeType(@Nullable String mimeType) {
        return new Audio(fileId, fileUniqueId, duration, performer, title, fileName, mimeType, fileSize, thumbnail);
    }

    public Audio withFileSize(@Nullable Long fileSize) {
        return new Audio(fileId, fileUniqueId, duration, performer, title, fileName, mimeType, fileSize, thumbnail);
    }

    public Audio withThumbnail(@Nullable PhotoSize thumbnail) {
        return new Audio(fileId, fileUniqueId, duration, performer, title, fileName, mimeType, fileSize, thumbnail);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Audio)) {
            return false;
        }
        Audio that = (Audio) o;
        return Objects.equals(this.fileId, that.fileId)
                && Objects.equals(this.fileUniqueId, that.fileUniqueId)
                && this.duration == that.duration
                && Objects.equals(this.performer, that.performer)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.fileName, that.fileName)
                && Objects.equals(this.mimeType, that.mimeType)
                && Objects.equals(this.fileSize, that.fileSize)
                && Objects.equals(this.thumbnail, that.thumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId, this.fileUniqueId, this.duration, this.performer, this.title, this.fileName, this.mimeType, this.fileSize, this.thumbnail);
    }

    @Override
    public String toString() {
        return "Audio[fileId=" + this.fileId
                + ", fileUniqueId=" + this.fileUniqueId
                + ", duration=" + this.duration
                + ", performer=" + this.performer
                + ", title=" + this.title
                + ", fileName=" + this.fileName
                + ", mimeType=" + this.mimeType
                + ", fileSize=" + this.fileSize
                + ", thumbnail=" + this.thumbnail
                + "]";
    }
}
