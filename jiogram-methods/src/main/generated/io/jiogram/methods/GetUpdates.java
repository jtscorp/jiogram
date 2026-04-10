package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.Update;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class GetUpdates implements TelegramMethod<List<Update>> {
    @JsonProperty("offset") @Nullable private final Long offset;
    @JsonProperty("limit") @Nullable private final Long limit;
    @JsonProperty("timeout") @Nullable private final Long timeout;
    @JsonProperty("allowed_updates") @Nullable private final List<String> allowedUpdates;

    @JsonCreator
    public GetUpdates(
            @JsonProperty("offset") @Nullable Long offset,
            @JsonProperty("limit") @Nullable Long limit,
            @JsonProperty("timeout") @Nullable Long timeout,
            @JsonProperty("allowed_updates") @Nullable List<String> allowedUpdates
    ) {
        this.offset = offset;
        this.limit = limit;
        this.timeout = timeout;
        this.allowedUpdates = allowedUpdates;
    }

    public Long offset() {
        return this.offset;
    }

    public Long limit() {
        return this.limit;
    }

    public Long timeout() {
        return this.timeout;
    }

    public List<String> allowedUpdates() {
        return this.allowedUpdates;
    }

    @Override
    public String apiMethod() {
        return "getUpdates";
    }

    @Override
    public String apiReturnType() {
        return "Array of Update";
    }

    public static GetUpdates of() {
        return new GetUpdates(null, null, null, null);
    }
}
