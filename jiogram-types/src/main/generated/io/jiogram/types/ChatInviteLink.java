package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Represents an invite link for a chat.
 *
 * @param inviteLink The invite link. If the link was created by another chat administrator, then
 *     the second part of the link will be replaced with '…'.
 * @param creator Creator of the link
 * @param createsJoinRequest True, if users joining the chat via the link need to be approved by
 *     chat administrators
 * @param isPrimary True, if the link is primary
 * @param isRevoked True, if the link is revoked
 * @param name Invite link name
 * @param expireDate Point in time (Unix timestamp) when the link will expire or has been expired
 * @param memberLimit The maximum number of users that can be members of the chat simultaneously
 *     after joining the chat via this invite link; 1-99999
 * @param pendingJoinRequestCount Number of pending join requests created using this link
 * @param subscriptionPeriod The number of seconds the subscription will be active for before the
 *     next payment
 * @param subscriptionPrice The amount of Telegram Stars a user must pay initially and after each
 *     subsequent subscription period to be a member of the chat using the link
 * @see <a href="https://core.telegram.org/bots/api#chatinvitelink">ChatInviteLink in the Bot API</a>
 */
public record ChatInviteLink(
    @JsonProperty("invite_link") String inviteLink,
    @JsonProperty("creator") User creator,
    @JsonProperty("creates_join_request") boolean createsJoinRequest,
    @JsonProperty("is_primary") boolean isPrimary,
    @JsonProperty("is_revoked") boolean isRevoked,
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("expire_date") @Nullable Long expireDate,
    @JsonProperty("member_limit") @Nullable Long memberLimit,
    @JsonProperty("pending_join_request_count") @Nullable Long pendingJoinRequestCount,
    @JsonProperty("subscription_period") @Nullable Long subscriptionPeriod,
    @JsonProperty("subscription_price") @Nullable Long subscriptionPrice
) {

    public static ChatInviteLink of(String inviteLink, User creator, boolean createsJoinRequest, boolean isPrimary, boolean isRevoked) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, null, null, null, null, null, null);
    }

    public ChatInviteLink withInviteLink(String inviteLink) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }

    public ChatInviteLink withCreator(User creator) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }

    public ChatInviteLink withCreatesJoinRequest(boolean createsJoinRequest) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }

    public ChatInviteLink withIsPrimary(boolean isPrimary) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }

    public ChatInviteLink withIsRevoked(boolean isRevoked) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }

    public ChatInviteLink withName(@Nullable String name) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }

    public ChatInviteLink withExpireDate(@Nullable Long expireDate) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }

    public ChatInviteLink withMemberLimit(@Nullable Long memberLimit) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }

    public ChatInviteLink withPendingJoinRequestCount(@Nullable Long pendingJoinRequestCount) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }

    public ChatInviteLink withSubscriptionPeriod(@Nullable Long subscriptionPeriod) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }

    public ChatInviteLink withSubscriptionPrice(@Nullable Long subscriptionPrice) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, name, expireDate, memberLimit, pendingJoinRequestCount, subscriptionPeriod, subscriptionPrice);
    }
}
