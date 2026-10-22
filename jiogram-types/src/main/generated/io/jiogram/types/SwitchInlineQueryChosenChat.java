package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an inline button that switches the current user to inline mode in a chosen
 * chat, with an optional default inline query.
 *
 * @param query The default inline query to be inserted in the input field. If left empty, only the
 *     bot's username will be inserted
 * @param allowUserChats True, if private chats with users can be chosen
 * @param allowBotChats True, if private chats with bots can be chosen
 * @param allowGroupChats True, if group and supergroup chats can be chosen
 * @param allowChannelChats True, if channel chats can be chosen
 * @see <a href="https://core.telegram.org/bots/api#switchinlinequerychosenchat">SwitchInlineQueryChosenChat in the Bot API</a>
 */
public record SwitchInlineQueryChosenChat(
    @JsonProperty("query") @Nullable String query,
    @JsonProperty("allow_user_chats") @Nullable Boolean allowUserChats,
    @JsonProperty("allow_bot_chats") @Nullable Boolean allowBotChats,
    @JsonProperty("allow_group_chats") @Nullable Boolean allowGroupChats,
    @JsonProperty("allow_channel_chats") @Nullable Boolean allowChannelChats
) {

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
}
