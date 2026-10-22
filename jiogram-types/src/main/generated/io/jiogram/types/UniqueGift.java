package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.UniqueGiftBackdrop;
import io.jiogram.types.UniqueGiftColors;
import io.jiogram.types.UniqueGiftModel;
import io.jiogram.types.UniqueGiftSymbol;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object describes a unique gift that was upgraded from a regular gift.
 *
 * @see <a href="https://core.telegram.org/bots/api#uniquegift">UniqueGift in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UniqueGift {

    @JsonProperty("gift_id")
    private final String giftId;

    @JsonProperty("base_name")
    private final String baseName;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("number")
    private final long number;

    @JsonProperty("model")
    private final UniqueGiftModel model;

    @JsonProperty("symbol")
    private final UniqueGiftSymbol symbol;

    @JsonProperty("backdrop")
    private final UniqueGiftBackdrop backdrop;

    @JsonProperty("is_premium")
    private final @Nullable Boolean isPremium;

    @JsonProperty("is_burned")
    private final @Nullable Boolean isBurned;

    @JsonProperty("is_from_blockchain")
    private final @Nullable Boolean isFromBlockchain;

    @JsonProperty("colors")
    private final @Nullable UniqueGiftColors colors;

    @JsonProperty("publisher_chat")
    private final @Nullable Chat publisherChat;

    /**
     * Creates a new {@code UniqueGift} instance.
     *
     * @param giftId Identifier of the regular gift from which the gift was upgraded
     * @param baseName Human-readable name of the regular gift from which this unique gift was
     *     upgraded
     * @param name Unique name of the gift. This name can be used in https://t.me/nft/... links and
     *     story areas
     * @param number Unique number of the upgraded gift among gifts upgraded from the same regular
     *     gift
     * @param model Model of the gift
     * @param symbol Symbol of the gift
     * @param backdrop Backdrop of the gift
     * @param isPremium True, if the original regular gift was exclusively purchaseable by Telegram
     *     Premium subscribers
     * @param isBurned True, if the gift was used to craft another gift and isn't available anymore
     * @param isFromBlockchain True, if the gift is assigned from the TON blockchain and can't be
     *     resold or transferred in Telegram
     * @param colors The color scheme that can be used by the gift's owner for the chat's name,
     *     replies to messages and link previews; for business account gifts and gifts that are
     *     currently on sale only
     * @param publisherChat Information about the chat that published the gift
     */
    @JsonCreator
    public UniqueGift(
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
            @JsonProperty("publisher_chat") @Nullable Chat publisherChat) {
        this.giftId = giftId;
        this.baseName = baseName;
        this.name = name;
        this.number = number;
        this.model = model;
        this.symbol = symbol;
        this.backdrop = backdrop;
        this.isPremium = isPremium;
        this.isBurned = isBurned;
        this.isFromBlockchain = isFromBlockchain;
        this.colors = colors;
        this.publisherChat = publisherChat;
    }

    public static UniqueGift of(String giftId, String baseName, String name, long number, UniqueGiftModel model, UniqueGiftSymbol symbol, UniqueGiftBackdrop backdrop) {
        return new UniqueGift(giftId, baseName, name, number, model, symbol, backdrop, null, null, null, null, null);
    }

    /**
     * Identifier of the regular gift from which the gift was upgraded
     */
    public String giftId() {
        return giftId;
    }

    /**
     * Human-readable name of the regular gift from which this unique gift was upgraded
     */
    public String baseName() {
        return baseName;
    }

    /**
     * Unique name of the gift. This name can be used in https://t.me/nft/... links and story areas
     */
    public String name() {
        return name;
    }

    /**
     * Unique number of the upgraded gift among gifts upgraded from the same regular gift
     */
    public long number() {
        return number;
    }

    /**
     * Model of the gift
     */
    public UniqueGiftModel model() {
        return model;
    }

    /**
     * Symbol of the gift
     */
    public UniqueGiftSymbol symbol() {
        return symbol;
    }

    /**
     * Backdrop of the gift
     */
    public UniqueGiftBackdrop backdrop() {
        return backdrop;
    }

    /**
     * True, if the original regular gift was exclusively purchaseable by Telegram Premium
     * subscribers
     */
    public @Nullable Boolean isPremium() {
        return isPremium;
    }

    /**
     * True, if the gift was used to craft another gift and isn't available anymore
     */
    public @Nullable Boolean isBurned() {
        return isBurned;
    }

    /**
     * True, if the gift is assigned from the TON blockchain and can't be resold or transferred in
     * Telegram
     */
    public @Nullable Boolean isFromBlockchain() {
        return isFromBlockchain;
    }

    /**
     * The color scheme that can be used by the gift's owner for the chat's name, replies to
     * messages and link previews; for business account gifts and gifts that are currently on sale
     * only
     */
    public @Nullable UniqueGiftColors colors() {
        return colors;
    }

    /**
     * Information about the chat that published the gift
     */
    public @Nullable Chat publisherChat() {
        return publisherChat;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UniqueGift)) {
            return false;
        }
        UniqueGift that = (UniqueGift) o;
        return Objects.equals(this.giftId, that.giftId)
                && Objects.equals(this.baseName, that.baseName)
                && Objects.equals(this.name, that.name)
                && this.number == that.number
                && Objects.equals(this.model, that.model)
                && Objects.equals(this.symbol, that.symbol)
                && Objects.equals(this.backdrop, that.backdrop)
                && Objects.equals(this.isPremium, that.isPremium)
                && Objects.equals(this.isBurned, that.isBurned)
                && Objects.equals(this.isFromBlockchain, that.isFromBlockchain)
                && Objects.equals(this.colors, that.colors)
                && Objects.equals(this.publisherChat, that.publisherChat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.giftId, this.baseName, this.name, this.number, this.model, this.symbol, this.backdrop, this.isPremium, this.isBurned, this.isFromBlockchain, this.colors, this.publisherChat);
    }

    @Override
    public String toString() {
        return "UniqueGift[giftId=" + this.giftId
                + ", baseName=" + this.baseName
                + ", name=" + this.name
                + ", number=" + this.number
                + ", model=" + this.model
                + ", symbol=" + this.symbol
                + ", backdrop=" + this.backdrop
                + ", isPremium=" + this.isPremium
                + ", isBurned=" + this.isBurned
                + ", isFromBlockchain=" + this.isFromBlockchain
                + ", colors=" + this.colors
                + ", publisherChat=" + this.publisherChat
                + "]";
    }
}
