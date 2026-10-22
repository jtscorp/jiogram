package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.UniqueGiftBackdrop;
import io.jiogram.types.UniqueGiftColors;
import io.jiogram.types.UniqueGiftModel;
import io.jiogram.types.UniqueGiftSymbol;
import org.jspecify.annotations.Nullable;

/**
 * This object describes a unique gift that was upgraded from a regular gift.
 *
 * @param giftId Identifier of the regular gift from which the gift was upgraded
 * @param baseName Human-readable name of the regular gift from which this unique gift was upgraded
 * @param name Unique name of the gift. This name can be used in https://t.me/nft/... links and
 *     story areas
 * @param number Unique number of the upgraded gift among gifts upgraded from the same regular gift
 * @param model Model of the gift
 * @param symbol Symbol of the gift
 * @param backdrop Backdrop of the gift
 * @param isPremium True, if the original regular gift was exclusively purchaseable by Telegram
 *     Premium subscribers
 * @param isBurned True, if the gift was used to craft another gift and isn't available anymore
 * @param isFromBlockchain True, if the gift is assigned from the TON blockchain and can't be resold
 *     or transferred in Telegram
 * @param colors The color scheme that can be used by the gift's owner for the chat's name, replies
 *     to messages and link previews; for business account gifts and gifts that are currently on
 *     sale only
 * @param publisherChat Information about the chat that published the gift
 * @see <a href="https://core.telegram.org/bots/api#uniquegift">UniqueGift in the Bot API</a>
 */
public record UniqueGift(
    @JsonProperty("gift_id") String giftId,
    @JsonProperty("base_name") String baseName,
    @JsonProperty("name") String name,
    @JsonProperty("number") long number,
    @JsonProperty("model") UniqueGiftModel model,
    @JsonProperty("symbol") UniqueGiftSymbol symbol,
    @JsonProperty("backdrop") UniqueGiftBackdrop backdrop,
    @JsonProperty("is_premium") @Nullable Boolean isPremium,
    @JsonProperty("is_burned") @Nullable Boolean isBurned,
    @JsonProperty("is_from_blockchain") @Nullable Boolean isFromBlockchain,
    @JsonProperty("colors") @Nullable UniqueGiftColors colors,
    @JsonProperty("publisher_chat") @Nullable Chat publisherChat
) {

    public UniqueGift withGiftId(String giftId) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withBaseName(String baseName) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withName(String name) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withNumber(long number) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withModel(UniqueGiftModel model) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withSymbol(UniqueGiftSymbol symbol) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withBackdrop(UniqueGiftBackdrop backdrop) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withIsPremium(@Nullable Boolean isPremium) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withIsBurned(@Nullable Boolean isBurned) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withIsFromBlockchain(@Nullable Boolean isFromBlockchain) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withColors(@Nullable UniqueGiftColors colors) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }

    public UniqueGift withPublisherChat(@Nullable Chat publisherChat) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, isPremium, isBurned, isFromBlockchain, colors, publisherChat);
    }
}
