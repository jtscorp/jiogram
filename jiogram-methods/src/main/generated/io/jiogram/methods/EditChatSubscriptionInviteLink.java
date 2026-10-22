package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit a subscription invite link created by the bot. The bot must have the
 * can_invite_users administrator rights. Returns the edited invite link as a ChatInviteLink object.
 *
 * @see <a href="https://core.telegram.org/bots/api#editchatsubscriptioninvitelink">editChatSubscriptionInviteLink in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditChatSubscriptionInviteLink implements TelegramMethod<ChatInviteLink> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("invite_link")
    private final String inviteLink;

    @JsonProperty("name")
    private final @Nullable String name;

    /**
     * Creates a new {@code EditChatSubscriptionInviteLink} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param inviteLink The invite link to edit
     * @param name Invite link name; 0-32 characters
     */
    @JsonCreator
    public EditChatSubscriptionInviteLink(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("invite_link") String inviteLink,
            @JsonProperty("name") @Nullable String name) {
        this.chatId = chatId;
        this.inviteLink = inviteLink;
        this.name = name;
    }

    @Override
    public String apiMethod() {
        return "editChatSubscriptionInviteLink";
    }

    @Override
    public String apiReturnType() {
        return "ChatInviteLink";
    }

    public static EditChatSubscriptionInviteLink of(ChatId chatId, String inviteLink) {
        return new EditChatSubscriptionInviteLink(chatId, inviteLink, null);
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * The invite link to edit
     */
    public String inviteLink() {
        return inviteLink;
    }

    /**
     * Invite link name; 0-32 characters
     */
    public @Nullable String name() {
        return name;
    }

    public EditChatSubscriptionInviteLink withChatId(ChatId chatId) {
        return new EditChatSubscriptionInviteLink(chatId, inviteLink, name);
    }

    public EditChatSubscriptionInviteLink withInviteLink(String inviteLink) {
        return new EditChatSubscriptionInviteLink(chatId, inviteLink, name);
    }

    public EditChatSubscriptionInviteLink withName(@Nullable String name) {
        return new EditChatSubscriptionInviteLink(chatId, inviteLink, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditChatSubscriptionInviteLink)) {
            return false;
        }
        EditChatSubscriptionInviteLink that = (EditChatSubscriptionInviteLink) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.inviteLink, that.inviteLink)
                && Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.inviteLink, this.name);
    }

    @Override
    public String toString() {
        return "EditChatSubscriptionInviteLink[chatId=" + this.chatId
                + ", inviteLink=" + this.inviteLink
                + ", name=" + this.name
                + "]";
    }
}
