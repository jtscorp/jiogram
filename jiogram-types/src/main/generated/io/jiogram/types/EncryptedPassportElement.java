package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportFile;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record EncryptedPassportElement(
    @JsonProperty("type") String type,
    @JsonProperty("data") @Nullable String data,
    @JsonProperty("phone_number") @Nullable String phoneNumber,
    @JsonProperty("email") @Nullable String email,
    @JsonProperty("files") @Nullable List<PassportFile> files,
    @JsonProperty("front_side") @Nullable PassportFile frontSide,
    @JsonProperty("reverse_side") @Nullable PassportFile reverseSide,
    @JsonProperty("selfie") @Nullable PassportFile selfie,
    @JsonProperty("translation") @Nullable List<PassportFile> translation,
    @JsonProperty("hash") String hash
) {}
