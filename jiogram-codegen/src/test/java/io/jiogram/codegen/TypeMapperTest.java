package io.jiogram.codegen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypeMapperTest {

    private static final String TYPES_PKG = "io.jiogram.types";
    private final TypeMapper mapper = new TypeMapper(TYPES_PKG);

    // ---- Integer ----

    @Test
    void integer_required_mapsToLong() {
        TypeName result = mapper.resolve("Integer", true);
        assertEquals(TypeName.LONG, result);
    }

    @Test
    void integer_optional_mapsToBoxedLong() {
        TypeName result = mapper.resolve("Integer", false);
        assertEquals(TypeName.LONG.box(), result);
    }

    // ---- String ----

    @Test
    void string_required_mapsToString() {
        TypeName result = mapper.resolve("String", true);
        assertEquals(ClassName.get(String.class), result);
    }

    @Test
    void string_optional_mapsToString() {
        TypeName result = mapper.resolve("String", false);
        assertEquals(ClassName.get(String.class), result);
    }

    // ---- Boolean ----

    @Test
    void boolean_required_mapsToPrimitiveBoolean() {
        TypeName result = mapper.resolve("Boolean", true);
        assertEquals(TypeName.BOOLEAN, result);
    }

    @Test
    void boolean_optional_mapsToBoxedBoolean() {
        TypeName result = mapper.resolve("Boolean", false);
        assertEquals(TypeName.BOOLEAN.box(), result);
    }

    // ---- Float / Float number ----

    @Test
    void float_required_mapsToPrimitiveDouble() {
        TypeName result = mapper.resolve("Float", true);
        assertEquals(TypeName.DOUBLE, result);
    }

    @Test
    void float_optional_mapsToBoxedDouble() {
        TypeName result = mapper.resolve("Float", false);
        assertEquals(TypeName.DOUBLE.box(), result);
    }

    @Test
    void floatNumber_required_mapsToPrimitiveDouble() {
        TypeName result = mapper.resolve("Float number", true);
        assertEquals(TypeName.DOUBLE, result);
    }

    @Test
    void floatNumber_optional_mapsToBoxedDouble() {
        TypeName result = mapper.resolve("Float number", false);
        assertEquals(TypeName.DOUBLE.box(), result);
    }

    // ---- True ----

    @Test
    void true_required_mapsToPrimitiveBoolean() {
        TypeName result = mapper.resolve("True", true);
        assertEquals(TypeName.BOOLEAN, result);
    }

    @Test
    void true_optional_mapsToBoxedBoolean() {
        TypeName result = mapper.resolve("True", false);
        assertEquals(TypeName.BOOLEAN.box(), result);
    }

    // ---- Array types ----

    @Test
    void arrayOfString_mapsToListOfString() {
        TypeName result = mapper.resolve("Array of String", true);
        ParameterizedTypeName expected = ParameterizedTypeName.get(
                ClassName.get(List.class), ClassName.get(String.class));
        assertEquals(expected, result);
    }

    @Test
    void arrayOfInteger_mapsToListOfLong() {
        TypeName result = mapper.resolve("Array of Integer", true);
        ParameterizedTypeName expected = ParameterizedTypeName.get(
                ClassName.get(List.class), TypeName.LONG.box());
        assertEquals(expected, result);
    }

    @Test
    void arrayOfEntity_mapsToListOfEntity() {
        TypeName result = mapper.resolve("Array of Update", true);
        ClassName updateClass = ClassName.get(TYPES_PKG, "Update");
        ParameterizedTypeName expected = ParameterizedTypeName.get(
                ClassName.get(List.class), updateClass);
        assertEquals(expected, result);
    }

    @Test
    void arrayOfArrayOfPhotoSize_mapsToNestedList() {
        TypeName result = mapper.resolve("Array of Array of PhotoSize", false);
        ClassName photoSizeClass = ClassName.get(TYPES_PKG, "PhotoSize");
        ParameterizedTypeName innerList = ParameterizedTypeName.get(
                ClassName.get(List.class), photoSizeClass);
        ParameterizedTypeName expected = ParameterizedTypeName.get(
                ClassName.get(List.class), innerList);
        assertEquals(expected, result);
    }

    // ---- Union types ----

    @Test
    void integerOrString_mapsToChatId() {
        TypeName result = mapper.resolve("Integer or String", true);
        assertEquals(ClassName.get(TYPES_PKG, "ChatId"), result);
    }

    @Test
    void inputFileOrString_mapsToInputFileOrString() {
        TypeName result = mapper.resolve("InputFile or String", false);
        assertEquals(ClassName.get(TYPES_PKG, "InputFileOrString"), result);
    }

    @Test
    void fourPartUnion_mapsToReplyMarkup() {
        String unionType = "InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply";
        TypeName result = mapper.resolve(unionType, true);
        assertEquals(ClassName.get(TYPES_PKG, "ReplyMarkup"), result);
    }

    // ---- Entity types ----

    @Test
    void entityType_mapsToClassName() {
        TypeName result = mapper.resolve("Message", true);
        assertEquals(ClassName.get(TYPES_PKG, "Message"), result);
    }

    @Test
    void entityType_optional_mapsToClassName() {
        TypeName result = mapper.resolve("User", false);
        assertEquals(ClassName.get(TYPES_PKG, "User"), result);
    }

    // ---- resolveReturnType ----

    @Test
    void resolveReturnType_delegatesToResolveWithRequiredFalse() {
        // Boolean return type should be boxed (required=false)
        TypeName result = mapper.resolveReturnType("Boolean");
        assertEquals(TypeName.BOOLEAN.box(), result);
    }

    @Test
    void resolveReturnType_arrayOfUpdate() {
        TypeName result = mapper.resolveReturnType("Array of Update");
        ClassName updateClass = ClassName.get(TYPES_PKG, "Update");
        ParameterizedTypeName expected = ParameterizedTypeName.get(
                ClassName.get(List.class), updateClass);
        assertEquals(expected, result);
    }

    @Test
    void resolveReturnType_entityType() {
        TypeName result = mapper.resolveReturnType("Message");
        assertEquals(ClassName.get(TYPES_PKG, "Message"), result);
    }

    // ---- Null safety ----

    @Test
    void constructor_nullPackage_throws() {
        assertThrows(NullPointerException.class, () -> new TypeMapper(null));
    }

    @Test
    void resolve_nullType_throws() {
        assertThrows(NullPointerException.class, () -> mapper.resolve(null, true));
    }
}
