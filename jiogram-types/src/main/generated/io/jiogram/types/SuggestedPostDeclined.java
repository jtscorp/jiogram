package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about the rejection of a suggested post.
 *
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostdeclined">SuggestedPostDeclined in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SuggestedPostDeclined {

    @JsonProperty("suggested_post_message")
    private final @Nullable Message suggestedPostMessage;

    @JsonProperty("comment")
    private final @Nullable String comment;

    /**
     * Creates a new {@code SuggestedPostDeclined} instance.
     *
     * @param suggestedPostMessage Message containing the suggested post. Note that the Message
     *     object in this field will not contain the reply_to_message field even if it itself is a
     *     reply.
     * @param comment Comment with which the post was declined
     */
    @JsonCreator
    public SuggestedPostDeclined(
            @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
            @JsonProperty("comment") @Nullable String comment) {
        this.suggestedPostMessage = suggestedPostMessage;
        this.comment = comment;
    }

    public static SuggestedPostDeclined of() {
        return new SuggestedPostDeclined(null, null);
    }

    /**
     * Message containing the suggested post. Note that the Message object in this field will not
     * contain the reply_to_message field even if it itself is a reply.
     */
    public @Nullable Message suggestedPostMessage() {
        return suggestedPostMessage;
    }

    /**
     * Comment with which the post was declined
     */
    public @Nullable String comment() {
        return comment;
    }

    public SuggestedPostDeclined withSuggestedPostMessage(@Nullable Message suggestedPostMessage) {
        return new SuggestedPostDeclined(suggestedPostMessage, comment);
    }

    public SuggestedPostDeclined withComment(@Nullable String comment) {
        return new SuggestedPostDeclined(suggestedPostMessage, comment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestedPostDeclined)) {
            return false;
        }
        SuggestedPostDeclined that = (SuggestedPostDeclined) o;
        return Objects.equals(this.suggestedPostMessage, that.suggestedPostMessage)
                && Objects.equals(this.comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.suggestedPostMessage, this.comment);
    }

    @Override
    public String toString() {
        return "SuggestedPostDeclined[suggestedPostMessage=" + this.suggestedPostMessage
                + ", comment=" + this.comment
                + "]";
    }
}
