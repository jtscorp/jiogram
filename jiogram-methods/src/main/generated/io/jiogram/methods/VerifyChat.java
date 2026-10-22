package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Verifies a chat on behalf of the organization which is represented by the bot. Returns True on
 * success.
 *
 * @see <a href="https://core.telegram.org/bots/api#verifychat">verifyChat in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class VerifyChat implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("custom_description")
    private final @Nullable String customDescription;

    /**
     * Creates a new {@code VerifyChat} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername). Channel direct messages chats can't be verified.
     * @param customDescription Custom description for the verification; 0-70 characters. Must be
     *     empty if the organization isn't allowed to provide a custom verification description.
     */
    @JsonCreator
    public VerifyChat(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("custom_description") @Nullable String customDescription) {
        this.chatId = chatId;
        this.customDescription = customDescription;
    }

    @Override
    public String apiMethod() {
        return "verifyChat";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static VerifyChat of(ChatId chatId) {
        return new VerifyChat(chatId, null);
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername). Channel direct messages chats can't be verified.
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Custom description for the verification; 0-70 characters. Must be empty if the organization
     * isn't allowed to provide a custom verification description.
     */
    public @Nullable String customDescription() {
        return customDescription;
    }

    public VerifyChat withChatId(ChatId chatId) {
        return new VerifyChat(chatId, customDescription);
    }

    public VerifyChat withCustomDescription(@Nullable String customDescription) {
        return new VerifyChat(chatId, customDescription);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VerifyChat)) {
            return false;
        }
        VerifyChat that = (VerifyChat) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.customDescription, that.customDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.customDescription);
    }

    @Override
    public String toString() {
        return "VerifyChat[chatId=" + this.chatId
                + ", customDescription=" + this.customDescription
                + "]";
    }
}
