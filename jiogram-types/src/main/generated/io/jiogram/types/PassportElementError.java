package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object represents an error in the Telegram Passport element which was submitted that should
 * be resolved by the user. It should be one of:
 * <br>- PassportElementErrorDataField
 * <br>- PassportElementErrorFrontSide
 * <br>- PassportElementErrorReverseSide
 * <br>- PassportElementErrorSelfie
 * <br>- PassportElementErrorFile
 * <br>- PassportElementErrorFiles
 * <br>- PassportElementErrorTranslationFile
 * <br>- PassportElementErrorTranslationFiles
 * <br>- PassportElementErrorUnspecified
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerror">PassportElementError in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "source", visible = true, defaultImpl = PassportElementErrorUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = PassportElementErrorDataField.class, name = "data"),
    @JsonSubTypes.Type(value = PassportElementErrorFile.class, name = "file"),
    @JsonSubTypes.Type(value = PassportElementErrorFiles.class, name = "files"),
    @JsonSubTypes.Type(value = PassportElementErrorFrontSide.class, name = "front_side"),
    @JsonSubTypes.Type(value = PassportElementErrorReverseSide.class, name = "reverse_side"),
    @JsonSubTypes.Type(value = PassportElementErrorSelfie.class, name = "selfie"),
    @JsonSubTypes.Type(value = PassportElementErrorTranslationFile.class, name = "translation_file"),
    @JsonSubTypes.Type(value = PassportElementErrorTranslationFiles.class, name = "translation_files"),
    @JsonSubTypes.Type(value = PassportElementErrorUnspecified.class, name = "unspecified")
})
public sealed interface PassportElementError permits PassportElementErrorDataField, PassportElementErrorFile, PassportElementErrorFiles, PassportElementErrorFrontSide, PassportElementErrorReverseSide, PassportElementErrorSelfie, PassportElementErrorTranslationFile, PassportElementErrorTranslationFiles, PassportElementErrorUnspecified, PassportElementErrorUnknown {}
