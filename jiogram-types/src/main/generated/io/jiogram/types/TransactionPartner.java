package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TransactionPartnerTelegramApi.class, name = "telegram_api"),
    @JsonSubTypes.Type(value = TransactionPartnerFragment.class, name = "fragment"),
    @JsonSubTypes.Type(value = TransactionPartnerChat.class, name = "chat"),
    @JsonSubTypes.Type(value = TransactionPartnerOther.class, name = "other"),
    @JsonSubTypes.Type(value = TransactionPartnerAffiliateProgram.class, name = "affiliate_program"),
    @JsonSubTypes.Type(value = TransactionPartnerUser.class, name = "user"),
    @JsonSubTypes.Type(value = TransactionPartnerTelegramAds.class, name = "telegram_ads")
})
public sealed interface TransactionPartner permits TransactionPartnerTelegramApi, TransactionPartnerFragment, TransactionPartnerChat, TransactionPartnerOther, TransactionPartnerAffiliateProgram, TransactionPartnerUser, TransactionPartnerTelegramAds {}
