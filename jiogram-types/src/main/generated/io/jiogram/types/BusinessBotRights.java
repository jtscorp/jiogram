package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record BusinessBotRights(
    @JsonProperty("can_reply") @Nullable Boolean canReply,
    @JsonProperty("can_read_messages") @Nullable Boolean canReadMessages,
    @JsonProperty("can_delete_sent_messages") @Nullable Boolean canDeleteSentMessages,
    @JsonProperty("can_delete_all_messages") @Nullable Boolean canDeleteAllMessages,
    @JsonProperty("can_edit_name") @Nullable Boolean canEditName,
    @JsonProperty("can_edit_bio") @Nullable Boolean canEditBio,
    @JsonProperty("can_edit_profile_photo") @Nullable Boolean canEditProfilePhoto,
    @JsonProperty("can_edit_username") @Nullable Boolean canEditUsername,
    @JsonProperty("can_change_gift_settings") @Nullable Boolean canChangeGiftSettings,
    @JsonProperty("can_view_gifts_and_stars") @Nullable Boolean canViewGiftsAndStars,
    @JsonProperty("can_convert_gifts_to_stars") @Nullable Boolean canConvertGiftsToStars,
    @JsonProperty("can_transfer_and_upgrade_gifts") @Nullable Boolean canTransferAndUpgradeGifts,
    @JsonProperty("can_transfer_stars") @Nullable Boolean canTransferStars,
    @JsonProperty("can_manage_stories") @Nullable Boolean canManageStories
) {}
