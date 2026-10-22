package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents an invite link for a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatinvitelink">ChatInviteLink in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatInviteLink {

    @JsonProperty("invite_link")
    private final String inviteLink;

    @JsonProperty("creator")
    private final User creator;

    @JsonProperty("creates_join_request")
    private final boolean createsJoinRequest;

    @JsonProperty("is_primary")
    private final boolean isPrimary;

    @JsonProperty("is_revoked")
    private final boolean isRevoked;

    @JsonProperty("name")
    private final @Nullable String name;

    @JsonProperty("expire_date")
    private final @Nullable Long expireDate;

    @JsonProperty("member_limit")
    private final @Nullable Long memberLimit;

    @JsonProperty("pending_join_request_count")
    private final @Nullable Long pendingJoinRequestCount;

    @JsonProperty("subscription_period")
    private final @Nullable Long subscriptionPeriod;

    @JsonProperty("subscription_price")
    private final @Nullable Long subscriptionPrice;

    /**
     * Creates a new {@code ChatInviteLink} instance.
     *
     * @param inviteLink The invite link. If the link was created by another chat administrator,
     *     then the second part of the link will be replaced with '…'.
     * @param creator Creator of the link
     * @param createsJoinRequest True, if users joining the chat via the link need to be approved by
     *     chat administrators
     * @param isPrimary True, if the link is primary
     * @param isRevoked True, if the link is revoked
     * @param name Invite link name
     * @param expireDate Point in time (Unix timestamp) when the link will expire or has been
     *     expired
     * @param memberLimit The maximum number of users that can be members of the chat simultaneously
     *     after joining the chat via this invite link; 1-99999
     * @param pendingJoinRequestCount Number of pending join requests created using this link
     * @param subscriptionPeriod The number of seconds the subscription will be active for before
     *     the next payment
     * @param subscriptionPrice The amount of Telegram Stars a user must pay initially and after
     *     each subsequent subscription period to be a member of the chat using the link
     */
    @JsonCreator
    public ChatInviteLink(
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
            @JsonProperty("subscription_price") @Nullable Long subscriptionPrice) {
        this.inviteLink = inviteLink;
        this.creator = creator;
        this.createsJoinRequest = createsJoinRequest;
        this.isPrimary = isPrimary;
        this.isRevoked = isRevoked;
        this.name = name;
        this.expireDate = expireDate;
        this.memberLimit = memberLimit;
        this.pendingJoinRequestCount = pendingJoinRequestCount;
        this.subscriptionPeriod = subscriptionPeriod;
        this.subscriptionPrice = subscriptionPrice;
    }

    public static ChatInviteLink of(String inviteLink, User creator, boolean createsJoinRequest, boolean isPrimary, boolean isRevoked) {
        return new ChatInviteLink(inviteLink, creator, createsJoinRequest, isPrimary, isRevoked, null, null, null, null, null, null);
    }

    /**
     * The invite link. If the link was created by another chat administrator, then the second part
     * of the link will be replaced with '…'.
     */
    public String inviteLink() {
        return inviteLink;
    }

    /**
     * Creator of the link
     */
    public User creator() {
        return creator;
    }

    /**
     * True, if users joining the chat via the link need to be approved by chat administrators
     */
    public boolean createsJoinRequest() {
        return createsJoinRequest;
    }

    /**
     * True, if the link is primary
     */
    public boolean isPrimary() {
        return isPrimary;
    }

    /**
     * True, if the link is revoked
     */
    public boolean isRevoked() {
        return isRevoked;
    }

    /**
     * Invite link name
     */
    public @Nullable String name() {
        return name;
    }

    /**
     * Point in time (Unix timestamp) when the link will expire or has been expired
     */
    public @Nullable Long expireDate() {
        return expireDate;
    }

    /**
     * The maximum number of users that can be members of the chat simultaneously after joining the
     * chat via this invite link; 1-99999
     */
    public @Nullable Long memberLimit() {
        return memberLimit;
    }

    /**
     * Number of pending join requests created using this link
     */
    public @Nullable Long pendingJoinRequestCount() {
        return pendingJoinRequestCount;
    }

    /**
     * The number of seconds the subscription will be active for before the next payment
     */
    public @Nullable Long subscriptionPeriod() {
        return subscriptionPeriod;
    }

    /**
     * The amount of Telegram Stars a user must pay initially and after each subsequent subscription
     * period to be a member of the chat using the link
     */
    public @Nullable Long subscriptionPrice() {
        return subscriptionPrice;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatInviteLink)) {
            return false;
        }
        ChatInviteLink that = (ChatInviteLink) o;
        return Objects.equals(this.inviteLink, that.inviteLink)
                && Objects.equals(this.creator, that.creator)
                && this.createsJoinRequest == that.createsJoinRequest
                && this.isPrimary == that.isPrimary
                && this.isRevoked == that.isRevoked
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.expireDate, that.expireDate)
                && Objects.equals(this.memberLimit, that.memberLimit)
                && Objects.equals(this.pendingJoinRequestCount, that.pendingJoinRequestCount)
                && Objects.equals(this.subscriptionPeriod, that.subscriptionPeriod)
                && Objects.equals(this.subscriptionPrice, that.subscriptionPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.inviteLink, this.creator, this.createsJoinRequest, this.isPrimary, this.isRevoked, this.name, this.expireDate, this.memberLimit, this.pendingJoinRequestCount, this.subscriptionPeriod, this.subscriptionPrice);
    }

    @Override
    public String toString() {
        return "ChatInviteLink[inviteLink=" + this.inviteLink
                + ", creator=" + this.creator
                + ", createsJoinRequest=" + this.createsJoinRequest
                + ", isPrimary=" + this.isPrimary
                + ", isRevoked=" + this.isRevoked
                + ", name=" + this.name
                + ", expireDate=" + this.expireDate
                + ", memberLimit=" + this.memberLimit
                + ", pendingJoinRequestCount=" + this.pendingJoinRequestCount
                + ", subscriptionPeriod=" + this.subscriptionPeriod
                + ", subscriptionPrice=" + this.subscriptionPrice
                + "]";
    }
}
