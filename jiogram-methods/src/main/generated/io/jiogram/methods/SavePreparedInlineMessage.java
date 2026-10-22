package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.PreparedInlineMessage;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Stores a message that can be sent by a user of a Mini App. Returns a PreparedInlineMessage
 * object.
 *
 * @see <a href="https://core.telegram.org/bots/api#savepreparedinlinemessage">savePreparedInlineMessage in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SavePreparedInlineMessage implements TelegramMethod<PreparedInlineMessage> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("result")
    private final InlineQueryResult result;

    @JsonProperty("allow_user_chats")
    private final @Nullable Boolean allowUserChats;

    @JsonProperty("allow_bot_chats")
    private final @Nullable Boolean allowBotChats;

    @JsonProperty("allow_group_chats")
    private final @Nullable Boolean allowGroupChats;

    @JsonProperty("allow_channel_chats")
    private final @Nullable Boolean allowChannelChats;

    /**
     * Creates a new {@code SavePreparedInlineMessage} instance.
     *
     * @param userId Unique identifier of the target user that can use the prepared message
     * @param result A JSON-serialized object describing the message to be sent
     * @param allowUserChats Pass True if the message can be sent to private chats with users
     * @param allowBotChats Pass True if the message can be sent to private chats with bots
     * @param allowGroupChats Pass True if the message can be sent to group and supergroup chats
     * @param allowChannelChats Pass True if the message can be sent to channel chats
     */
    @JsonCreator
    public SavePreparedInlineMessage(
            @JsonProperty("user_id") long userId,
            @JsonProperty("result") InlineQueryResult result,
            @JsonProperty("allow_user_chats") @Nullable Boolean allowUserChats,
            @JsonProperty("allow_bot_chats") @Nullable Boolean allowBotChats,
            @JsonProperty("allow_group_chats") @Nullable Boolean allowGroupChats,
            @JsonProperty("allow_channel_chats") @Nullable Boolean allowChannelChats) {
        this.userId = userId;
        this.result = result;
        this.allowUserChats = allowUserChats;
        this.allowBotChats = allowBotChats;
        this.allowGroupChats = allowGroupChats;
        this.allowChannelChats = allowChannelChats;
    }

    @Override
    public String apiMethod() {
        return "savePreparedInlineMessage";
    }

    @Override
    public String apiReturnType() {
        return "PreparedInlineMessage";
    }

    public static SavePreparedInlineMessage of(long userId, InlineQueryResult result) {
        return new SavePreparedInlineMessage(userId, result, null, null, null, null);
    }

    /**
     * Unique identifier of the target user that can use the prepared message
     */
    public long userId() {
        return userId;
    }

    /**
     * A JSON-serialized object describing the message to be sent
     */
    public InlineQueryResult result() {
        return result;
    }

    /**
     * Pass True if the message can be sent to private chats with users
     */
    public @Nullable Boolean allowUserChats() {
        return allowUserChats;
    }

    /**
     * Pass True if the message can be sent to private chats with bots
     */
    public @Nullable Boolean allowBotChats() {
        return allowBotChats;
    }

    /**
     * Pass True if the message can be sent to group and supergroup chats
     */
    public @Nullable Boolean allowGroupChats() {
        return allowGroupChats;
    }

    /**
     * Pass True if the message can be sent to channel chats
     */
    public @Nullable Boolean allowChannelChats() {
        return allowChannelChats;
    }

    public SavePreparedInlineMessage withUserId(long userId) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SavePreparedInlineMessage withResult(InlineQueryResult result) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SavePreparedInlineMessage withAllowUserChats(@Nullable Boolean allowUserChats) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SavePreparedInlineMessage withAllowBotChats(@Nullable Boolean allowBotChats) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SavePreparedInlineMessage withAllowGroupChats(@Nullable Boolean allowGroupChats) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SavePreparedInlineMessage withAllowChannelChats(@Nullable Boolean allowChannelChats) {
        return new SavePreparedInlineMessage(userId, result, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SavePreparedInlineMessage)) {
            return false;
        }
        SavePreparedInlineMessage that = (SavePreparedInlineMessage) o;
        return this.userId == that.userId
                && Objects.equals(this.result, that.result)
                && Objects.equals(this.allowUserChats, that.allowUserChats)
                && Objects.equals(this.allowBotChats, that.allowBotChats)
                && Objects.equals(this.allowGroupChats, that.allowGroupChats)
                && Objects.equals(this.allowChannelChats, that.allowChannelChats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.result, this.allowUserChats, this.allowBotChats, this.allowGroupChats, this.allowChannelChats);
    }

    @Override
    public String toString() {
        return "SavePreparedInlineMessage[userId=" + this.userId
                + ", result=" + this.result
                + ", allowUserChats=" + this.allowUserChats
                + ", allowBotChats=" + this.allowBotChats
                + ", allowGroupChats=" + this.allowGroupChats
                + ", allowChannelChats=" + this.allowChannelChats
                + "]";
    }
}
