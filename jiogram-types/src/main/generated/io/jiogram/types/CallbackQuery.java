package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaybeInaccessibleMessage;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class CallbackQuery {
    @JsonProperty("id") private final String id;
    @JsonProperty("from") private final User from;
    @JsonProperty("message") @Nullable private final MaybeInaccessibleMessage message;
    @JsonProperty("inline_message_id") @Nullable private final String inlineMessageId;
    @JsonProperty("chat_instance") private final String chatInstance;
    @JsonProperty("data") @Nullable private final String data;
    @JsonProperty("game_short_name") @Nullable private final String gameShortName;

    @JsonCreator
    public CallbackQuery(
            @JsonProperty("id") String id,
            @JsonProperty("from") User from,
            @JsonProperty("message") @Nullable MaybeInaccessibleMessage message,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("chat_instance") String chatInstance,
            @JsonProperty("data") @Nullable String data,
            @JsonProperty("game_short_name") @Nullable String gameShortName
    ) {
        this.id = id;
        this.from = from;
        this.message = message;
        this.inlineMessageId = inlineMessageId;
        this.chatInstance = chatInstance;
        this.data = data;
        this.gameShortName = gameShortName;
    }

    public String id() {
        return this.id;
    }

    public User from() {
        return this.from;
    }

    public MaybeInaccessibleMessage message() {
        return this.message;
    }

    public String inlineMessageId() {
        return this.inlineMessageId;
    }

    public String chatInstance() {
        return this.chatInstance;
    }

    public String data() {
        return this.data;
    }

    public String gameShortName() {
        return this.gameShortName;
    }
}
