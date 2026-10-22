package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes an inline message sent by a Web App on behalf of a user.
 *
 * @see <a href="https://core.telegram.org/bots/api#sentwebappmessage">SentWebAppMessage in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SentWebAppMessage {

    @JsonProperty("inline_message_id")
    private final @Nullable String inlineMessageId;

    /**
     * Creates a new {@code SentWebAppMessage} instance.
     *
     * @param inlineMessageId Identifier of the sent inline message. Available only if there is an
     *     inline keyboard attached to the message.
     */
    @JsonCreator
    public SentWebAppMessage(
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
    }

    public static SentWebAppMessage of() {
        return new SentWebAppMessage(null);
    }

    /**
     * Identifier of the sent inline message. Available only if there is an inline keyboard attached
     * to the message.
     */
    public @Nullable String inlineMessageId() {
        return inlineMessageId;
    }

    public SentWebAppMessage withInlineMessageId(@Nullable String inlineMessageId) {
        return new SentWebAppMessage(inlineMessageId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SentWebAppMessage)) {
            return false;
        }
        SentWebAppMessage that = (SentWebAppMessage) o;
        return Objects.equals(this.inlineMessageId, that.inlineMessageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.inlineMessageId);
    }

    @Override
    public String toString() {
        return "SentWebAppMessage[inlineMessageId=" + this.inlineMessageId
                + "]";
    }
}
