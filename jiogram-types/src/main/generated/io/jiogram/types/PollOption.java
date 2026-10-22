package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about one answer option in a poll.
 *
 * @param persistentId Unique identifier of the option, persistent on option addition and deletion
 * @param text Option text, 1-100 characters
 * @param textEntities Special entities that appear in the option text. Currently, only custom emoji
 *     entities are allowed in poll option texts
 * @param voterCount Number of users who voted for this option; may be 0 if unknown
 * @param addedByUser User who added the option; omitted if the option wasn't added by a user after
 *     poll creation
 * @param addedByChat Chat that added the option; omitted if the option wasn't added by a chat after
 *     poll creation
 * @param additionDate Point in time (Unix timestamp) when the option was added; omitted if the
 *     option existed in the original poll
 * @see <a href="https://core.telegram.org/bots/api#polloption">PollOption in the Bot API</a>
 */
public record PollOption(
    @JsonProperty("persistent_id") String persistentId,
    @JsonProperty("text") String text,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
    @JsonProperty("voter_count") long voterCount,
    @JsonProperty("added_by_user") @Nullable User addedByUser,
    @JsonProperty("added_by_chat") @Nullable Chat addedByChat,
    @JsonProperty("addition_date") @Nullable Long additionDate
) {

    public static PollOption of(String persistentId, String text, long voterCount) {
        return new PollOption(persistentId, text, null, voterCount, null, null, null);
    }

    public PollOption withPersistentId(String persistentId) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withText(String text) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withTextEntities(@Nullable List<MessageEntity> textEntities) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withVoterCount(long voterCount) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withAddedByUser(@Nullable User addedByUser) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withAddedByChat(@Nullable Chat addedByChat) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }

    public PollOption withAdditionDate(@Nullable Long additionDate) {
        return new PollOption(persistentId, text, textEntities, voterCount, addedByUser, addedByChat, additionDate);
    }
}
