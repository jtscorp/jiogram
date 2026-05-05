package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.Update;
import io.jiogram.types.UpdateType;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record GetUpdates(
    @JsonProperty("offset") @Nullable Long offset,
    @JsonProperty("limit") @Nullable Long limit,
    @JsonProperty("timeout") @Nullable Long timeout,
    @JsonProperty("allowed_updates") @Nullable List<UpdateType> allowedUpdates
) implements TelegramMethod<List<Update>> {

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
