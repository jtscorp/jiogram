package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
