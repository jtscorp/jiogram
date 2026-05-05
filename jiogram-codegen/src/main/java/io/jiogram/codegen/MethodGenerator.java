package io.jiogram.codegen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import io.jiogram.codegen.model.FieldDefinition;
import io.jiogram.codegen.model.MethodDefinition;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Generates Java class source files from {@link MethodDefinition} objects.
 * <p>
 * Each generated class implements {@code TelegramMethod<T>} where T is the return type,
 * and includes:
 * <ul>
 *   <li>Final fields with {@code @JsonProperty} annotations</li>
 *   <li>A {@code @JsonCreator} constructor</li>
 *   <li>Record-style accessors (no {@code get} prefix)</li>
 *   <li>{@code apiMethod()} returning the original API method name</li>
 *   <li>{@code apiReturnType()} returning the return type string</li>
 *   <li>A static {@code of()} factory with only required parameters</li>
 * </ul>
 */
public final class MethodGenerator {

    private static final String NULLABLE_PACKAGE = "org.jspecify.annotations";
    private static final String JACKSON_ANNOTATION_PACKAGE = "com.fasterxml.jackson.annotation";

    private final TypeMapper typeMapper;
    private final String methodsPackage;
    private final String typesPackage;

    /**
     * Creates a new MethodGenerator.
     *
     * @param typeMapper     resolves Telegram types to JavaPoet types
     * @param methodsPackage the Java package for generated method records
     * @param typesPackage   the Java package where generated types live (for TelegramMethod reference)
     */
    public MethodGenerator(TypeMapper typeMapper, String methodsPackage, String typesPackage) {
        this.typeMapper = Objects.requireNonNull(typeMapper, "typeMapper must not be null");
        this.methodsPackage = Objects.requireNonNull(methodsPackage, "methodsPackage must not be null");
        this.typesPackage = Objects.requireNonNull(typesPackage, "typesPackage must not be null");
    }

    /**
     * Generates a Java source file for the given method definition and writes it to the output directory.
     *
     * @param method    the method definition to generate
     * @param outputDir the root output directory for generated sources
     * @throws IOException if writing the file fails
     */
    public void generate(MethodDefinition method, File outputDir) throws IOException {
        Objects.requireNonNull(method, "method must not be null");
        Objects.requireNonNull(outputDir, "outputDir must not be null");

        String source = generateToString(method);

        Path packageDir = outputDir.toPath().resolve(methodsPackage.replace('.', '/'));
        Files.createDirectories(packageDir);
        Files.writeString(packageDir.resolve(method.className() + ".java"), source);
    }

    /**
     * Generates a Java source string for the given method definition.
     *
     * @param method the method definition to generate
     * @return the generated Java source code
     */
    public String generateToString(MethodDefinition method) {
        Objects.requireNonNull(method, "method must not be null");

        Set<String> imports = new TreeSet<>();
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonProperty");
        imports.add(JACKSON_ANNOTATION_PACKAGE + ".JsonCreator");

        // Resolve return type
        TypeName returnType = typeMapper.resolveReturnType(method.returnType());
        TypeName boxedReturnType = returnType.box();
        String returnTypeStr = resolveTypeString(boxedReturnType, imports);

        // Build TelegramMethod<ReturnType> import
        imports.add(typesPackage + ".TelegramMethod");

        // Collect field metadata
        record FieldInfo(String annotation, String typeString, String javaName, boolean nullable) {}
        List<FieldInfo> fields = new ArrayList<>();
        boolean hasOptionalRefField = false;

        for (FieldDefinition param : method.parameters()) {
            TypeName javaType = typeMapper.resolveMethodParameter(method.name(), param);
            String typeString = resolveTypeString(javaType, imports);
            String annotation = "@JsonProperty(\"" + param.name() + "\")";
            boolean nullable = !param.required() && !javaType.isPrimitive();
            if (nullable) {
                hasOptionalRefField = true;
            }
            fields.add(new FieldInfo(annotation, typeString, param.javaName(), nullable));
        }

        if (hasOptionalRefField) {
            imports.add(NULLABLE_PACKAGE + ".Nullable");
        }

        // Build the source
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(methodsPackage).append(";\n\n");
        for (String imp : imports) {
            sb.append("import ").append(imp).append(";\n");
        }
        sb.append("\n");

        // Class declaration
        sb.append("public class ").append(method.className())
                .append(" implements TelegramMethod<").append(returnTypeStr).append("> {\n");

        // Fields
        for (FieldInfo f : fields) {
            sb.append("    ").append(f.annotation());
            if (f.nullable()) {
                sb.append(" @Nullable");
            }
            sb.append(" private final ").append(f.typeString()).append(" ").append(f.javaName()).append(";\n");
        }

        if (!fields.isEmpty()) {
            sb.append("\n");
        }

        // @JsonCreator constructor
        sb.append("    @JsonCreator\n");
        sb.append("    public ").append(method.className()).append("(");
        if (!fields.isEmpty()) {
            sb.append("\n");
            List<String> ctorParams = new ArrayList<>();
            for (FieldInfo f : fields) {
                StringBuilder param = new StringBuilder("            ");
                param.append(f.annotation());
                if (f.nullable()) {
                    param.append(" @Nullable");
                }
                param.append(" ").append(f.typeString()).append(" ").append(f.javaName());
                ctorParams.add(param.toString());
            }
            sb.append(String.join(",\n", ctorParams));
            sb.append("\n    ");
        }
        sb.append(") {\n");
        for (FieldInfo f : fields) {
            sb.append("        this.").append(f.javaName()).append(" = ").append(f.javaName()).append(";\n");
        }
        sb.append("    }\n");

        // Accessors
        for (FieldInfo f : fields) {
            sb.append("\n");
            sb.append("    public ").append(f.typeString()).append(" ").append(f.javaName()).append("() {\n");
            sb.append("        return this.").append(f.javaName()).append(";\n");
            sb.append("    }\n");
        }

        sb.append("\n");

        // apiMethod()
        sb.append("    @Override\n");
        sb.append("    public String apiMethod() {\n");
        sb.append("        return \"").append(method.name()).append("\";\n");
        sb.append("    }\n\n");

        // apiReturnType()
        sb.append("    @Override\n");
        sb.append("    public String apiReturnType() {\n");
        sb.append("        return \"").append(method.returnType()).append("\";\n");
        sb.append("    }\n");

        // Static factory with only required params
        List<FieldDefinition> requiredParams = method.parameters().stream()
                .filter(FieldDefinition::required)
                .toList();

        // Only generate of() if there are optional params (otherwise canonical constructor suffices)
        boolean hasOptionalParams = method.parameters().stream().anyMatch(p -> !p.required());
        if (hasOptionalParams && !method.parameters().isEmpty()) {
            sb.append("\n");
            generateStaticFactory(sb, method, requiredParams, imports);
        }

        sb.append("}\n");

        return sb.toString();
    }

    private void generateStaticFactory(StringBuilder sb, MethodDefinition method,
                                        List<FieldDefinition> requiredParams, Set<String> imports) {
        // Build parameter list for factory method
        List<String> factoryParams = new ArrayList<>();
        for (FieldDefinition param : requiredParams) {
            TypeName javaType = typeMapper.resolveMethodParameter(method.name(), param);
            String typeString = resolveTypeString(javaType, imports);
            factoryParams.add(typeString + " " + param.javaName());
        }

        // Build constructor call arguments
        List<String> constructorArgs = new ArrayList<>();
        for (FieldDefinition param : method.parameters()) {
            if (param.required()) {
                constructorArgs.add(param.javaName());
            } else {
                TypeName javaType = typeMapper.resolveMethodParameter(method.name(), param);
                if (javaType.isPrimitive()) {
                    // Primitive defaults
                    constructorArgs.add(defaultPrimitiveValue(javaType));
                } else {
                    constructorArgs.add("null");
                }
            }
        }

        sb.append("    public static ").append(method.className()).append(" of(");
        sb.append(String.join(", ", factoryParams));
        sb.append(") {\n");
        sb.append("        return new ").append(method.className()).append("(");
        sb.append(String.join(", ", constructorArgs));
        sb.append(");\n");
        sb.append("    }\n");
    }

    private String defaultPrimitiveValue(TypeName typeName) {
        if (typeName.equals(TypeName.BOOLEAN)) return "false";
        if (typeName.equals(TypeName.LONG)) return "0L";
        if (typeName.equals(TypeName.INT)) return "0";
        if (typeName.equals(TypeName.DOUBLE)) return "0.0";
        if (typeName.equals(TypeName.FLOAT)) return "0.0f";
        return "0";
    }

    /**
     * Converts a JavaPoet TypeName to a simple string for source code, collecting imports.
     */
    private String resolveTypeString(TypeName typeName, Set<String> imports) {
        if (typeName.isPrimitive()) {
            return typeName.toString();
        }

        if (typeName instanceof ParameterizedTypeName paramType) {
            String rawString = resolveTypeString(paramType.rawType, imports);
            String args = paramType.typeArguments.stream()
                    .map(arg -> resolveTypeString(arg, imports))
                    .collect(Collectors.joining(", "));
            return rawString + "<" + args + ">";
        }

        if (typeName instanceof ClassName className) {
            String fullName = className.packageName() + "." + className.simpleName();
            if (!"java.lang".equals(className.packageName())) {
                imports.add(fullName);
            }
            return className.simpleName();
        }

        // Boxed primitives
        return typeName.box().toString();
    }
}
