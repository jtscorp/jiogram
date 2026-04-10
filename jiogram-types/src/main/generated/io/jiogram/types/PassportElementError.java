package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "source")
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
public interface PassportElementError {}
