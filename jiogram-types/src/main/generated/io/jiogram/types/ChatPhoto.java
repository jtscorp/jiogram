package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a chat photo.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatphoto">ChatPhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatPhoto {

    @JsonProperty("small_file_id")
    private final String smallFileId;

    @JsonProperty("small_file_unique_id")
    private final String smallFileUniqueId;

    @JsonProperty("big_file_id")
    private final String bigFileId;

    @JsonProperty("big_file_unique_id")
    private final String bigFileUniqueId;

    /**
     * Creates a new {@code ChatPhoto} instance.
     *
     * @param smallFileId File identifier of small (160x160) chat photo. This file_id can be used
     *     only for photo download and only for as long as the photo is not changed.
     * @param smallFileUniqueId Unique file identifier of small (160x160) chat photo, which is
     *     supposed to be the same over time and for different bots. Can't be used to download or
     *     reuse the file.
     * @param bigFileId File identifier of big (640x640) chat photo. This file_id can be used only
     *     for photo download and only for as long as the photo is not changed.
     * @param bigFileUniqueId Unique file identifier of big (640x640) chat photo, which is supposed
     *     to be the same over time and for different bots. Can't be used to download or reuse the
     *     file.
     */
    @JsonCreator
    public ChatPhoto(
            @JsonProperty("small_file_id") String smallFileId,
            @JsonProperty("small_file_unique_id") String smallFileUniqueId,
            @JsonProperty("big_file_id") String bigFileId,
            @JsonProperty("big_file_unique_id") String bigFileUniqueId) {
        this.smallFileId = smallFileId;
        this.smallFileUniqueId = smallFileUniqueId;
        this.bigFileId = bigFileId;
        this.bigFileUniqueId = bigFileUniqueId;
    }

    /**
     * File identifier of small (160x160) chat photo. This file_id can be used only for photo
     * download and only for as long as the photo is not changed.
     */
    public String smallFileId() {
        return smallFileId;
    }

    /**
     * Unique file identifier of small (160x160) chat photo, which is supposed to be the same over
     * time and for different bots. Can't be used to download or reuse the file.
     */
    public String smallFileUniqueId() {
        return smallFileUniqueId;
    }

    /**
     * File identifier of big (640x640) chat photo. This file_id can be used only for photo download
     * and only for as long as the photo is not changed.
     */
    public String bigFileId() {
        return bigFileId;
    }

    /**
     * Unique file identifier of big (640x640) chat photo, which is supposed to be the same over
     * time and for different bots. Can't be used to download or reuse the file.
     */
    public String bigFileUniqueId() {
        return bigFileUniqueId;
    }

    public ChatPhoto withSmallFileId(String smallFileId) {
        return new ChatPhoto(smallFileId, smallFileUniqueId, bigFileId, bigFileUniqueId);
    }

    public ChatPhoto withSmallFileUniqueId(String smallFileUniqueId) {
        return new ChatPhoto(smallFileId, smallFileUniqueId, bigFileId, bigFileUniqueId);
    }

    public ChatPhoto withBigFileId(String bigFileId) {
        return new ChatPhoto(smallFileId, smallFileUniqueId, bigFileId, bigFileUniqueId);
    }

    public ChatPhoto withBigFileUniqueId(String bigFileUniqueId) {
        return new ChatPhoto(smallFileId, smallFileUniqueId, bigFileId, bigFileUniqueId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatPhoto)) {
            return false;
        }
        ChatPhoto that = (ChatPhoto) o;
        return Objects.equals(this.smallFileId, that.smallFileId)
                && Objects.equals(this.smallFileUniqueId, that.smallFileUniqueId)
                && Objects.equals(this.bigFileId, that.bigFileId)
                && Objects.equals(this.bigFileUniqueId, that.bigFileUniqueId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.smallFileId, this.smallFileUniqueId, this.bigFileId, this.bigFileUniqueId);
    }

    @Override
    public String toString() {
        return "ChatPhoto[smallFileId=" + this.smallFileId
                + ", smallFileUniqueId=" + this.smallFileUniqueId
                + ", bigFileId=" + this.bigFileId
                + ", bigFileUniqueId=" + this.bigFileUniqueId
                + "]";
    }
}
