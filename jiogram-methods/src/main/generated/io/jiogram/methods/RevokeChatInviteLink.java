package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to revoke an invite link created by the bot. If the primary link is revoked, a
 * new link is automatically generated. The bot must be an administrator in the chat for this to
 * work and must have the appropriate administrator rights. Returns the revoked invite link as
 * ChatInviteLink object.
 *
 * @see <a href="https://core.telegram.org/bots/api#revokechatinvitelink">revokeChatInviteLink in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RevokeChatInviteLink implements TelegramMethod<ChatInviteLink> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("invite_link")
    private final String inviteLink;

    /**
     * Creates a new {@code RevokeChatInviteLink} instance.
     *
     * @param chatId Unique identifier of the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param inviteLink The invite link to revoke
     */
    @JsonCreator
    public RevokeChatInviteLink(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("invite_link") String inviteLink) {
        this.chatId = chatId;
        this.inviteLink = inviteLink;
    }

    @Override
    public String apiMethod() {
        return "revokeChatInviteLink";
    }

    @Override
    public String apiReturnType() {
        return "ChatInviteLink";
    }

    /**
     * Unique identifier of the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * The invite link to revoke
     */
    public String inviteLink() {
        return inviteLink;
    }

    public RevokeChatInviteLink withChatId(ChatId chatId) {
        return new RevokeChatInviteLink(chatId, inviteLink);
    }

    public RevokeChatInviteLink withInviteLink(String inviteLink) {
        return new RevokeChatInviteLink(chatId, inviteLink);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RevokeChatInviteLink)) {
            return false;
        }
        RevokeChatInviteLink that = (RevokeChatInviteLink) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.inviteLink, that.inviteLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.inviteLink);
    }

    @Override
    public String toString() {
        return "RevokeChatInviteLink[chatId=" + this.chatId
                + ", inviteLink=" + this.inviteLink
                + "]";
    }
}
