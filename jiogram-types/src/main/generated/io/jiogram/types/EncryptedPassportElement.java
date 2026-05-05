package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementType;
import io.jiogram.types.PassportFile;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class EncryptedPassportElement {
    @JsonProperty("type") private final PassportElementType type;
    @JsonProperty("data") @Nullable private final String data;
    @JsonProperty("phone_number") @Nullable private final String phoneNumber;
    @JsonProperty("email") @Nullable private final String email;
    @JsonProperty("files") @Nullable private final List<PassportFile> files;
    @JsonProperty("front_side") @Nullable private final PassportFile frontSide;
    @JsonProperty("reverse_side") @Nullable private final PassportFile reverseSide;
    @JsonProperty("selfie") @Nullable private final PassportFile selfie;
    @JsonProperty("translation") @Nullable private final List<PassportFile> translation;
    @JsonProperty("hash") private final String hash;

    @JsonCreator
    public EncryptedPassportElement(
            @JsonProperty("type") PassportElementType type,
            @JsonProperty("data") @Nullable String data,
            @JsonProperty("phone_number") @Nullable String phoneNumber,
            @JsonProperty("email") @Nullable String email,
            @JsonProperty("files") @Nullable List<PassportFile> files,
            @JsonProperty("front_side") @Nullable PassportFile frontSide,
            @JsonProperty("reverse_side") @Nullable PassportFile reverseSide,
            @JsonProperty("selfie") @Nullable PassportFile selfie,
            @JsonProperty("translation") @Nullable List<PassportFile> translation,
            @JsonProperty("hash") String hash
    ) {
        this.type = type;
        this.data = data;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.files = files;
        this.frontSide = frontSide;
        this.reverseSide = reverseSide;
        this.selfie = selfie;
        this.translation = translation;
        this.hash = hash;
    }

    public PassportElementType type() {
        return this.type;
    }

    public String data() {
        return this.data;
    }

    public String phoneNumber() {
        return this.phoneNumber;
    }

    public String email() {
        return this.email;
    }

    public List<PassportFile> files() {
        return this.files;
    }

    public PassportFile frontSide() {
        return this.frontSide;
    }

    public PassportFile reverseSide() {
        return this.reverseSide;
    }

    public PassportFile selfie() {
        return this.selfie;
    }

    public List<PassportFile> translation() {
        return this.translation;
    }

    public String hash() {
        return this.hash;
    }
}
