package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class BusinessBotRights {
    @JsonProperty("can_reply") @Nullable private final Boolean canReply;
    @JsonProperty("can_read_messages") @Nullable private final Boolean canReadMessages;
    @JsonProperty("can_delete_sent_messages") @Nullable private final Boolean canDeleteSentMessages;
    @JsonProperty("can_delete_all_messages") @Nullable private final Boolean canDeleteAllMessages;
    @JsonProperty("can_edit_name") @Nullable private final Boolean canEditName;
    @JsonProperty("can_edit_bio") @Nullable private final Boolean canEditBio;
    @JsonProperty("can_edit_profile_photo") @Nullable private final Boolean canEditProfilePhoto;
    @JsonProperty("can_edit_username") @Nullable private final Boolean canEditUsername;
    @JsonProperty("can_change_gift_settings") @Nullable private final Boolean canChangeGiftSettings;
    @JsonProperty("can_view_gifts_and_stars") @Nullable private final Boolean canViewGiftsAndStars;
    @JsonProperty("can_convert_gifts_to_stars") @Nullable private final Boolean canConvertGiftsToStars;
    @JsonProperty("can_transfer_and_upgrade_gifts") @Nullable private final Boolean canTransferAndUpgradeGifts;
    @JsonProperty("can_transfer_stars") @Nullable private final Boolean canTransferStars;
    @JsonProperty("can_manage_stories") @Nullable private final Boolean canManageStories;

    @JsonCreator
    public BusinessBotRights(
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
    ) {
        this.canReply = canReply;
        this.canReadMessages = canReadMessages;
        this.canDeleteSentMessages = canDeleteSentMessages;
        this.canDeleteAllMessages = canDeleteAllMessages;
        this.canEditName = canEditName;
        this.canEditBio = canEditBio;
        this.canEditProfilePhoto = canEditProfilePhoto;
        this.canEditUsername = canEditUsername;
        this.canChangeGiftSettings = canChangeGiftSettings;
        this.canViewGiftsAndStars = canViewGiftsAndStars;
        this.canConvertGiftsToStars = canConvertGiftsToStars;
        this.canTransferAndUpgradeGifts = canTransferAndUpgradeGifts;
        this.canTransferStars = canTransferStars;
        this.canManageStories = canManageStories;
    }

    public Boolean canReply() {
        return this.canReply;
    }

    public Boolean canReadMessages() {
        return this.canReadMessages;
    }

    public Boolean canDeleteSentMessages() {
        return this.canDeleteSentMessages;
    }

    public Boolean canDeleteAllMessages() {
        return this.canDeleteAllMessages;
    }

    public Boolean canEditName() {
        return this.canEditName;
    }

    public Boolean canEditBio() {
        return this.canEditBio;
    }

    public Boolean canEditProfilePhoto() {
        return this.canEditProfilePhoto;
    }

    public Boolean canEditUsername() {
        return this.canEditUsername;
    }

    public Boolean canChangeGiftSettings() {
        return this.canChangeGiftSettings;
    }

    public Boolean canViewGiftsAndStars() {
        return this.canViewGiftsAndStars;
    }

    public Boolean canConvertGiftsToStars() {
        return this.canConvertGiftsToStars;
    }

    public Boolean canTransferAndUpgradeGifts() {
        return this.canTransferAndUpgradeGifts;
    }

    public Boolean canTransferStars() {
        return this.canTransferStars;
    }

    public Boolean canManageStories() {
        return this.canManageStories;
    }
}
