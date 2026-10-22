package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementType;
import io.jiogram.types.PassportFile;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes documents or other Telegram Passport elements shared with the bot by the user.
 *
 * @see <a href="https://core.telegram.org/bots/api#encryptedpassportelement">EncryptedPassportElement in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EncryptedPassportElement {

    @JsonProperty("type")
    private final PassportElementType type;

    @JsonProperty("data")
    private final @Nullable String data;

    @JsonProperty("phone_number")
    private final @Nullable String phoneNumber;

    @JsonProperty("email")
    private final @Nullable String email;

    @JsonProperty("files")
    private final @Nullable List<PassportFile> files;

    @JsonProperty("front_side")
    private final @Nullable PassportFile frontSide;

    @JsonProperty("reverse_side")
    private final @Nullable PassportFile reverseSide;

    @JsonProperty("selfie")
    private final @Nullable PassportFile selfie;

    @JsonProperty("translation")
    private final @Nullable List<PassportFile> translation;

    @JsonProperty("hash")
    private final String hash;

    /**
     * Creates a new {@code EncryptedPassportElement} instance.
     *
     * @param type Element type. One of 'personal_details', 'passport', 'driver_license',
     *     'identity_card', 'internal_passport', 'address', 'utility_bill', 'bank_statement',
     *     'rental_agreement', 'passport_registration', 'temporary_registration', 'phone_number',
     *     'email'.
     * @param data Base64-encoded encrypted Telegram Passport element data provided by the user;
     *     available only for 'personal_details', 'passport', 'driver_license', 'identity_card',
     *     'internal_passport' and 'address' types. Can be decrypted and verified using the
     *     accompanying EncryptedCredentials.
     * @param phoneNumber User's verified phone number; available only for 'phone_number' type
     * @param email User's verified email address; available only for 'email' type
     * @param files Array of encrypted files with documents provided by the user; available only for
     *     'utility_bill', 'bank_statement', 'rental_agreement', 'passport_registration' and
     *     'temporary_registration' types. Files can be decrypted and verified using the
     *     accompanying EncryptedCredentials.
     * @param frontSide Encrypted file with the front side of the document, provided by the user;
     *     available only for 'passport', 'driver_license', 'identity_card' and 'internal_passport'.
     *     The file can be decrypted and verified using the accompanying EncryptedCredentials.
     * @param reverseSide Encrypted file with the reverse side of the document, provided by the
     *     user; available only for 'driver_license' and 'identity_card'. The file can be decrypted
     *     and verified using the accompanying EncryptedCredentials.
     * @param selfie Encrypted file with the selfie of the user holding a document, provided by the
     *     user; available if requested for 'passport', 'driver_license', 'identity_card' and
     *     'internal_passport'. The file can be decrypted and verified using the accompanying
     *     EncryptedCredentials.
     * @param translation Array of encrypted files with translated versions of documents provided by
     *     the user; available if requested for 'passport', 'driver_license', 'identity_card',
     *     'internal_passport', 'utility_bill', 'bank_statement', 'rental_agreement',
     *     'passport_registration' and 'temporary_registration' types. Files can be decrypted and
     *     verified using the accompanying EncryptedCredentials.
     * @param hash Base64-encoded element hash for using in PassportElementErrorUnspecified
     */
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
            @JsonProperty("hash") String hash) {
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

    public static EncryptedPassportElement of(PassportElementType type, String hash) {
        return new EncryptedPassportElement(type, null, null, null, null, null, null, null, null, hash);
    }

    /**
     * Element type. One of 'personal_details', 'passport', 'driver_license', 'identity_card',
     * 'internal_passport', 'address', 'utility_bill', 'bank_statement', 'rental_agreement',
     * 'passport_registration', 'temporary_registration', 'phone_number', 'email'.
     */
    public PassportElementType type() {
        return type;
    }

    /**
     * Base64-encoded encrypted Telegram Passport element data provided by the user; available only
     * for 'personal_details', 'passport', 'driver_license', 'identity_card', 'internal_passport'
     * and 'address' types. Can be decrypted and verified using the accompanying
     * EncryptedCredentials.
     */
    public @Nullable String data() {
        return data;
    }

    /**
     * User's verified phone number; available only for 'phone_number' type
     */
    public @Nullable String phoneNumber() {
        return phoneNumber;
    }

    /**
     * User's verified email address; available only for 'email' type
     */
    public @Nullable String email() {
        return email;
    }

    /**
     * Array of encrypted files with documents provided by the user; available only for
     * 'utility_bill', 'bank_statement', 'rental_agreement', 'passport_registration' and
     * 'temporary_registration' types. Files can be decrypted and verified using the accompanying
     * EncryptedCredentials.
     */
    public @Nullable List<PassportFile> files() {
        return files;
    }

    /**
     * Encrypted file with the front side of the document, provided by the user; available only for
     * 'passport', 'driver_license', 'identity_card' and 'internal_passport'. The file can be
     * decrypted and verified using the accompanying EncryptedCredentials.
     */
    public @Nullable PassportFile frontSide() {
        return frontSide;
    }

    /**
     * Encrypted file with the reverse side of the document, provided by the user; available only
     * for 'driver_license' and 'identity_card'. The file can be decrypted and verified using the
     * accompanying EncryptedCredentials.
     */
    public @Nullable PassportFile reverseSide() {
        return reverseSide;
    }

    /**
     * Encrypted file with the selfie of the user holding a document, provided by the user;
     * available if requested for 'passport', 'driver_license', 'identity_card' and
     * 'internal_passport'. The file can be decrypted and verified using the accompanying
     * EncryptedCredentials.
     */
    public @Nullable PassportFile selfie() {
        return selfie;
    }

    /**
     * Array of encrypted files with translated versions of documents provided by the user;
     * available if requested for 'passport', 'driver_license', 'identity_card',
     * 'internal_passport', 'utility_bill', 'bank_statement', 'rental_agreement',
     * 'passport_registration' and 'temporary_registration' types. Files can be decrypted and
     * verified using the accompanying EncryptedCredentials.
     */
    public @Nullable List<PassportFile> translation() {
        return translation;
    }

    /**
     * Base64-encoded element hash for using in PassportElementErrorUnspecified
     */
    public String hash() {
        return hash;
    }

    public EncryptedPassportElement withType(PassportElementType type) {
        return new EncryptedPassportElement(type, data, phoneNumber, email, files, frontSide, reverseSide, selfie, translation, hash);
    }

    public EncryptedPassportElement withData(@Nullable String data) {
        return new EncryptedPassportElement(type, data, phoneNumber, email, files, frontSide, reverseSide, selfie, translation, hash);
    }

    public EncryptedPassportElement withPhoneNumber(@Nullable String phoneNumber) {
        return new EncryptedPassportElement(type, data, phoneNumber, email, files, frontSide, reverseSide, selfie, translation, hash);
    }

    public EncryptedPassportElement withEmail(@Nullable String email) {
        return new EncryptedPassportElement(type, data, phoneNumber, email, files, frontSide, reverseSide, selfie, translation, hash);
    }

    public EncryptedPassportElement withFiles(@Nullable List<PassportFile> files) {
        return new EncryptedPassportElement(type, data, phoneNumber, email, files, frontSide, reverseSide, selfie, translation, hash);
    }

    public EncryptedPassportElement withFrontSide(@Nullable PassportFile frontSide) {
        return new EncryptedPassportElement(type, data, phoneNumber, email, files, frontSide, reverseSide, selfie, translation, hash);
    }

    public EncryptedPassportElement withReverseSide(@Nullable PassportFile reverseSide) {
        return new EncryptedPassportElement(type, data, phoneNumber, email, files, frontSide, reverseSide, selfie, translation, hash);
    }

    public EncryptedPassportElement withSelfie(@Nullable PassportFile selfie) {
        return new EncryptedPassportElement(type, data, phoneNumber, email, files, frontSide, reverseSide, selfie, translation, hash);
    }

    public EncryptedPassportElement withTranslation(@Nullable List<PassportFile> translation) {
        return new EncryptedPassportElement(type, data, phoneNumber, email, files, frontSide, reverseSide, selfie, translation, hash);
    }

    public EncryptedPassportElement withHash(String hash) {
        return new EncryptedPassportElement(type, data, phoneNumber, email, files, frontSide, reverseSide, selfie, translation, hash);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EncryptedPassportElement)) {
            return false;
        }
        EncryptedPassportElement that = (EncryptedPassportElement) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.data, that.data)
                && Objects.equals(this.phoneNumber, that.phoneNumber)
                && Objects.equals(this.email, that.email)
                && Objects.equals(this.files, that.files)
                && Objects.equals(this.frontSide, that.frontSide)
                && Objects.equals(this.reverseSide, that.reverseSide)
                && Objects.equals(this.selfie, that.selfie)
                && Objects.equals(this.translation, that.translation)
                && Objects.equals(this.hash, that.hash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.data, this.phoneNumber, this.email, this.files, this.frontSide, this.reverseSide, this.selfie, this.translation, this.hash);
    }

    @Override
    public String toString() {
        return "EncryptedPassportElement[type=" + this.type
                + ", data=" + this.data
                + ", phoneNumber=" + this.phoneNumber
                + ", email=" + this.email
                + ", files=" + this.files
                + ", frontSide=" + this.frontSide
                + ", reverseSide=" + this.reverseSide
                + ", selfie=" + this.selfie
                + ", translation=" + this.translation
                + ", hash=" + this.hash
                + "]";
    }
}
