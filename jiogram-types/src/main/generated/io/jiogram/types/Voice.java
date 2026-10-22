package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a voice note.
 *
 * @see <a href="https://core.telegram.org/bots/api#voice">Voice in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Voice {

    @JsonProperty("file_id")
    private final String fileId;

    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    @JsonProperty("duration")
    private final long duration;

    @JsonProperty("mime_type")
    private final @Nullable String mimeType;

    @JsonProperty("file_size")
    private final @Nullable Long fileSize;

    /**
     * Creates a new {@code Voice} instance.
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over
     *     time and for different bots. Can't be used to download or reuse the file.
     * @param duration Duration of the audio in seconds as defined by the sender
     * @param mimeType MIME type of the file as defined by the sender
     * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages
     *     may have difficulty/silent defects in interpreting it. But it has at most 52 significant
     *     bits, so a signed 64-bit integer or double-precision float type are safe for storing this
     *     value.
     */
    @JsonCreator
    public Voice(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("duration") long duration,
            @JsonProperty("mime_type") @Nullable String mimeType,
            @JsonProperty("file_size") @Nullable Long fileSize) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.duration = duration;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
    }

    public static Voice of(String fileId, String fileUniqueId, long duration) {
        return new Voice(fileId, fileUniqueId, duration, null, null);
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

    public Voice withFileId(String fileId) {
        return new Voice(fileId, fileUniqueId, duration, mimeType, fileSize);
    }

    public Voice withFileUniqueId(String fileUniqueId) {
        return new Voice(fileId, fileUniqueId, duration, mimeType, fileSize);
    }

    public Voice withDuration(long duration) {
        return new Voice(fileId, fileUniqueId, duration, mimeType, fileSize);
    }

    public Voice withMimeType(@Nullable String mimeType) {
        return new Voice(fileId, fileUniqueId, duration, mimeType, fileSize);
    }

    public Voice withFileSize(@Nullable Long fileSize) {
        return new Voice(fileId, fileUniqueId, duration, mimeType, fileSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Voice)) {
            return false;
        }
        Voice that = (Voice) o;
        return Objects.equals(this.fileId, that.fileId)
                && Objects.equals(this.fileUniqueId, that.fileUniqueId)
                && this.duration == that.duration
                && Objects.equals(this.mimeType, that.mimeType)
                && Objects.equals(this.fileSize, that.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId, this.fileUniqueId, this.duration, this.mimeType, this.fileSize);
    }

    @Override
    public String toString() {
        return "Voice[fileId=" + this.fileId
                + ", fileUniqueId=" + this.fileUniqueId
                + ", duration=" + this.duration
                + ", mimeType=" + this.mimeType
                + ", fileSize=" + this.fileSize
                + "]";
    }
}
