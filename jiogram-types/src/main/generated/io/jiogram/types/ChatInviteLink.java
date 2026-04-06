package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

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
) {}
