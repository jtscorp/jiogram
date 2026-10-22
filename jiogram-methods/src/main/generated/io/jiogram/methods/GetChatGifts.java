package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.OwnedGifts;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Returns the gifts owned by a chat. Returns OwnedGifts on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param excludeUnsaved Pass True to exclude gifts that aren't saved to the chat's profile page.
 *     Always True, unless the bot has the can_post_messages administrator right in the channel.
 * @param excludeSaved Pass True to exclude gifts that are saved to the chat's profile page. Always
 *     False, unless the bot has the can_post_messages administrator right in the channel.
 * @param excludeUnlimited Pass True to exclude gifts that can be purchased an unlimited number of
 *     times
 * @param excludeLimitedUpgradable Pass True to exclude gifts that can be purchased a limited number
 *     of times and can be upgraded to unique
 * @param excludeLimitedNonUpgradable Pass True to exclude gifts that can be purchased a limited
 *     number of times and can't be upgraded to unique
 * @param excludeFromBlockchain Pass True to exclude gifts that were assigned from the TON
 *     blockchain and can't be resold or transferred in Telegram
 * @param excludeUnique Pass True to exclude unique gifts
 * @param sortByPrice Pass True to sort results by gift price instead of send date. Sorting is
 *     applied before pagination.
 * @param offset Offset of the first entry to return as received from the previous request; use an
 *     empty string to get the first chunk of results
 * @param limit The maximum number of gifts to be returned; 1-100. Defaults to 100
 * @see <a href="https://core.telegram.org/bots/api#getchatgifts">getChatGifts in the Bot API</a>
 */
public record GetChatGifts(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("exclude_unsaved") @Nullable Boolean excludeUnsaved,
    @JsonProperty("exclude_saved") @Nullable Boolean excludeSaved,
    @JsonProperty("exclude_unlimited") @Nullable Boolean excludeUnlimited,
    @JsonProperty("exclude_limited_upgradable") @Nullable Boolean excludeLimitedUpgradable,
    @JsonProperty("exclude_limited_non_upgradable") @Nullable Boolean excludeLimitedNonUpgradable,
    @JsonProperty("exclude_from_blockchain") @Nullable Boolean excludeFromBlockchain,
    @JsonProperty("exclude_unique") @Nullable Boolean excludeUnique,
    @JsonProperty("sort_by_price") @Nullable Boolean sortByPrice,
    @JsonProperty("offset") @Nullable String offset,
    @JsonProperty("limit") @Nullable Long limit
) implements TelegramMethod<OwnedGifts> {

    @Override
    public String apiMethod() {
        return "getChatGifts";
    }

    @Override
    public String apiReturnType() {
        return "OwnedGifts";
    }

    public static GetChatGifts of(ChatId chatId) {
        return new GetChatGifts(chatId, null, null, null, null, null, null, null, null, null, null);
    }
}
