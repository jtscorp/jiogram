package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes the source of a transaction, or its recipient for outgoing transactions.
 * Currently, it can be one of
 * <br>- TransactionPartnerUser
 * <br>- TransactionPartnerChat
 * <br>- TransactionPartnerAffiliateProgram
 * <br>- TransactionPartnerFragment
 * <br>- TransactionPartnerTelegramAds
 * <br>- TransactionPartnerTelegramApi
 * <br>- TransactionPartnerOther
 *
 * @see <a href="https://core.telegram.org/bots/api#transactionpartner">TransactionPartner in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = TransactionPartnerUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = TransactionPartnerAffiliateProgram.class, name = "affiliate_program"),
    @JsonSubTypes.Type(value = TransactionPartnerChat.class, name = "chat"),
    @JsonSubTypes.Type(value = TransactionPartnerFragment.class, name = "fragment"),
    @JsonSubTypes.Type(value = TransactionPartnerOther.class, name = "other"),
    @JsonSubTypes.Type(value = TransactionPartnerTelegramAds.class, name = "telegram_ads"),
    @JsonSubTypes.Type(value = TransactionPartnerTelegramApi.class, name = "telegram_api"),
    @JsonSubTypes.Type(value = TransactionPartnerUser.class, name = "user")
})
public sealed interface TransactionPartner permits TransactionPartnerAffiliateProgram, TransactionPartnerChat, TransactionPartnerFragment, TransactionPartnerOther, TransactionPartnerTelegramAds, TransactionPartnerTelegramApi, TransactionPartnerUser, TransactionPartnerUnknown {}
