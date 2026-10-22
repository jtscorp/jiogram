package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatBoostSource;
import java.util.Objects;

/**
 * This object represents a boost removed from a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatboostremoved">ChatBoostRemoved in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatBoostRemoved {

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("boost_id")
    private final String boostId;

    @JsonProperty("remove_date")
    private final long removeDate;

    @JsonProperty("source")
    private final ChatBoostSource source;

    /**
     * Creates a new {@code ChatBoostRemoved} instance.
     *
     * @param chat Chat which was boosted
     * @param boostId Unique identifier of the boost
     * @param removeDate Point in time (Unix timestamp) when the boost was removed
     * @param source Source of the removed boost
     */
    @JsonCreator
    public ChatBoostRemoved(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("boost_id") String boostId,
            @JsonProperty("remove_date") long removeDate,
            @JsonProperty("source") ChatBoostSource source) {
        this.chat = chat;
        this.boostId = boostId;
        this.removeDate = removeDate;
        this.source = source;
    }

    /**
     * Chat which was boosted
     */
    public Chat chat() {
        return chat;
    }

    /**
     * Unique identifier of the boost
     */
    public String boostId() {
        return boostId;
    }

    /**
     * Point in time (Unix timestamp) when the boost was removed
     */
    public long removeDate() {
        return removeDate;
    }

    /**
     * Source of the removed boost
     */
    public ChatBoostSource source() {
        return source;
    }

    public ChatBoostRemoved withChat(Chat chat) {
        return new ChatBoostRemoved(chat, boostId, removeDate, source);
    }

    public ChatBoostRemoved withBoostId(String boostId) {
        return new ChatBoostRemoved(chat, boostId, removeDate, source);
    }

    public ChatBoostRemoved withRemoveDate(long removeDate) {
        return new ChatBoostRemoved(chat, boostId, removeDate, source);
    }

    public ChatBoostRemoved withSource(ChatBoostSource source) {
        return new ChatBoostRemoved(chat, boostId, removeDate, source);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatBoostRemoved)) {
            return false;
        }
        ChatBoostRemoved that = (ChatBoostRemoved) o;
        return Objects.equals(this.chat, that.chat)
                && Objects.equals(this.boostId, that.boostId)
                && this.removeDate == that.removeDate
                && Objects.equals(this.source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chat, this.boostId, this.removeDate, this.source);
    }

    @Override
    public String toString() {
        return "ChatBoostRemoved[chat=" + this.chat
                + ", boostId=" + this.boostId
                + ", removeDate=" + this.removeDate
                + ", source=" + this.source
                + "]";
    }
}
