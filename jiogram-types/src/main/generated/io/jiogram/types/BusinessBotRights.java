package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Represents the rights of a business bot.
 *
 * @param canReply True, if the bot can send and edit messages in the private chats that had
 *     incoming messages in the last 24 hours
 * @param canReadMessages True, if the bot can mark incoming private messages as read
 * @param canDeleteSentMessages True, if the bot can delete messages sent by the bot
 * @param canDeleteAllMessages True, if the bot can delete all private messages in managed chats
 * @param canEditName True, if the bot can edit the first and last name of the business account
 * @param canEditBio True, if the bot can edit the bio of the business account
 * @param canEditProfilePhoto True, if the bot can edit the profile photo of the business account
 * @param canEditUsername True, if the bot can edit the username of the business account
 * @param canChangeGiftSettings True, if the bot can change the privacy settings pertaining to gifts
 *     for the business account
 * @param canViewGiftsAndStars True, if the bot can view gifts and the amount of Telegram Stars
 *     owned by the business account
 * @param canConvertGiftsToStars True, if the bot can convert regular gifts owned by the business
 *     account to Telegram Stars
 * @param canTransferAndUpgradeGifts True, if the bot can transfer and upgrade gifts owned by the
 *     business account
 * @param canTransferStars True, if the bot can transfer Telegram Stars received by the business
 *     account to its own account, or use them to upgrade and transfer gifts
 * @param canManageStories True, if the bot can post, edit and delete stories on behalf of the
 *     business account
 * @see <a href="https://core.telegram.org/bots/api#businessbotrights">BusinessBotRights in the Bot API</a>
 */
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
) {

    public static BusinessBotRights of() {
        return new BusinessBotRights(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public BusinessBotRights withCanReply(@Nullable Boolean canReply) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanReadMessages(@Nullable Boolean canReadMessages) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanDeleteSentMessages(@Nullable Boolean canDeleteSentMessages) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanDeleteAllMessages(@Nullable Boolean canDeleteAllMessages) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanEditName(@Nullable Boolean canEditName) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanEditBio(@Nullable Boolean canEditBio) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanEditProfilePhoto(@Nullable Boolean canEditProfilePhoto) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanEditUsername(@Nullable Boolean canEditUsername) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanChangeGiftSettings(@Nullable Boolean canChangeGiftSettings) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanViewGiftsAndStars(@Nullable Boolean canViewGiftsAndStars) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanConvertGiftsToStars(@Nullable Boolean canConvertGiftsToStars) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanTransferAndUpgradeGifts(@Nullable Boolean canTransferAndUpgradeGifts) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanTransferStars(@Nullable Boolean canTransferStars) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public BusinessBotRights withCanManageStories(@Nullable Boolean canManageStories) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }
}
