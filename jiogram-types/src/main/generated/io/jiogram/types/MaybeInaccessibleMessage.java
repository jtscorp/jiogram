package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

/**
 * This object describes a message that can be inaccessible to the bot. It can be one of
 * <br>- Message
 * <br>- InaccessibleMessage
 *
 * @see <a href="https://core.telegram.org/bots/api#maybeinaccessiblemessage">MaybeInaccessibleMessage in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, property = "date", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonTypeIdResolver(MaybeInaccessibleMessageTypeIdResolver.class)
public sealed interface MaybeInaccessibleMessage permits InaccessibleMessage, Message {}
