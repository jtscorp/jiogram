package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an inline button that switches the current user to inline mode in a chosen
 * chat, with an optional default inline query.
 *
 * @see <a href="https://core.telegram.org/bots/api#switchinlinequerychosenchat">SwitchInlineQueryChosenChat in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SwitchInlineQueryChosenChat {

    @JsonProperty("query")
    private final @Nullable String query;

    @JsonProperty("allow_user_chats")
    private final @Nullable Boolean allowUserChats;

    @JsonProperty("allow_bot_chats")
    private final @Nullable Boolean allowBotChats;

    @JsonProperty("allow_group_chats")
    private final @Nullable Boolean allowGroupChats;

    @JsonProperty("allow_channel_chats")
    private final @Nullable Boolean allowChannelChats;

    /**
     * Creates a new {@code SwitchInlineQueryChosenChat} instance.
     *
     * @param query The default inline query to be inserted in the input field. If left empty, only
     *     the bot's username will be inserted
     * @param allowUserChats True, if private chats with users can be chosen
     * @param allowBotChats True, if private chats with bots can be chosen
     * @param allowGroupChats True, if group and supergroup chats can be chosen
     * @param allowChannelChats True, if channel chats can be chosen
     */
    @JsonCreator
    public SwitchInlineQueryChosenChat(
            @JsonProperty("query") @Nullable String query,
            @JsonProperty("allow_user_chats") @Nullable Boolean allowUserChats,
            @JsonProperty("allow_bot_chats") @Nullable Boolean allowBotChats,
            @JsonProperty("allow_group_chats") @Nullable Boolean allowGroupChats,
            @JsonProperty("allow_channel_chats") @Nullable Boolean allowChannelChats) {
        this.query = query;
        this.allowUserChats = allowUserChats;
        this.allowBotChats = allowBotChats;
        this.allowGroupChats = allowGroupChats;
        this.allowChannelChats = allowChannelChats;
    }

    public static SwitchInlineQueryChosenChat of() {
        return new SwitchInlineQueryChosenChat(null, null, null, null, null);
    }

    /**
     * The default inline query to be inserted in the input field. If left empty, only the bot's
     * username will be inserted
     */
    public @Nullable String query() {
        return query;
    }

    /**
     * True, if private chats with users can be chosen
     */
    public @Nullable Boolean allowUserChats() {
        return allowUserChats;
    }

    /**
     * True, if private chats with bots can be chosen
     */
    public @Nullable Boolean allowBotChats() {
        return allowBotChats;
    }

    /**
     * True, if group and supergroup chats can be chosen
     */
    public @Nullable Boolean allowGroupChats() {
        return allowGroupChats;
    }

    /**
     * True, if channel chats can be chosen
     */
    public @Nullable Boolean allowChannelChats() {
        return allowChannelChats;
    }

    public SwitchInlineQueryChosenChat withQuery(@Nullable String query) {
        return new SwitchInlineQueryChosenChat(query, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SwitchInlineQueryChosenChat withAllowUserChats(@Nullable Boolean allowUserChats) {
        return new SwitchInlineQueryChosenChat(query, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SwitchInlineQueryChosenChat withAllowBotChats(@Nullable Boolean allowBotChats) {
        return new SwitchInlineQueryChosenChat(query, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SwitchInlineQueryChosenChat withAllowGroupChats(@Nullable Boolean allowGroupChats) {
        return new SwitchInlineQueryChosenChat(query, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    public SwitchInlineQueryChosenChat withAllowChannelChats(@Nullable Boolean allowChannelChats) {
        return new SwitchInlineQueryChosenChat(query, allowUserChats, allowBotChats, allowGroupChats, allowChannelChats);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SwitchInlineQueryChosenChat)) {
            return false;
        }
        SwitchInlineQueryChosenChat that = (SwitchInlineQueryChosenChat) o;
        return Objects.equals(this.query, that.query)
                && Objects.equals(this.allowUserChats, that.allowUserChats)
                && Objects.equals(this.allowBotChats, that.allowBotChats)
                && Objects.equals(this.allowGroupChats, that.allowGroupChats)
                && Objects.equals(this.allowChannelChats, that.allowChannelChats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.query, this.allowUserChats, this.allowBotChats, this.allowGroupChats, this.allowChannelChats);
    }

    @Override
    public String toString() {
        return "SwitchInlineQueryChosenChat[query=" + this.query
                + ", allowUserChats=" + this.allowUserChats
                + ", allowBotChats=" + this.allowBotChats
                + ", allowGroupChats=" + this.allowGroupChats
                + ", allowChannelChats=" + this.allowChannelChats
                + "]";
    }
}
