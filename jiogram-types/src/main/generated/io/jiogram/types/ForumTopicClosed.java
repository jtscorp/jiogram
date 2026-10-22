package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a service message about a forum topic closed in the chat. Currently holds
 * no information.
 *
 * @see <a href="https://core.telegram.org/bots/api#forumtopicclosed">ForumTopicClosed in the Bot API</a>
 */
public record ForumTopicClosed(

) {}
