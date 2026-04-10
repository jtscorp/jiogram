package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class ChatInviteLink {
    @JsonProperty("invite_link") private final String inviteLink;
    @JsonProperty("creator") private final User creator;
    @JsonProperty("creates_join_request") private final boolean createsJoinRequest;
    @JsonProperty("is_primary") private final boolean isPrimary;
    @JsonProperty("is_revoked") private final boolean isRevoked;
    @JsonProperty("name") @Nullable private final String name;
    @JsonProperty("expire_date") @Nullable private final Long expireDate;
    @JsonProperty("member_limit") @Nullable private final Long memberLimit;
    @JsonProperty("pending_join_request_count") @Nullable private final Long pendingJoinRequestCount;
    @JsonProperty("subscription_period") @Nullable private final Long subscriptionPeriod;
    @JsonProperty("subscription_price") @Nullable private final Long subscriptionPrice;

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
            @JsonProperty("subscription_price") @Nullable Long subscriptionPrice
    ) {
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

    public String inviteLink() {
        return this.inviteLink;
    }

    public User creator() {
        return this.creator;
    }

    public boolean createsJoinRequest() {
        return this.createsJoinRequest;
    }

    public boolean isPrimary() {
        return this.isPrimary;
    }

    public boolean isRevoked() {
        return this.isRevoked;
    }

    public String name() {
        return this.name;
    }

    public Long expireDate() {
        return this.expireDate;
    }

    public Long memberLimit() {
        return this.memberLimit;
    }

    public Long pendingJoinRequestCount() {
        return this.pendingJoinRequestCount;
    }

    public Long subscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public Long subscriptionPrice() {
        return this.subscriptionPrice;
    }
}
