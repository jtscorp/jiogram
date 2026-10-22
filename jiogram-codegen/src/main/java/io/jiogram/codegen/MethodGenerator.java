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
 * Generates Java record source files from {@link MethodDefinition} objects.
 * <p>
 * Each generated record implements {@code TelegramMethod<T>} where T is the return type,
 * and includes:
 * <ul>
 *   <li>Record components for all method parameters</li>
 *   <li>{@code apiMethod()} returning the original API method name</li>
 *   <li>{@code apiReturnType()} returning the return type string</li>
 *   <li>A static {@code of()} factory with only required parameters</li>
 *   <li>For sending methods, static {@code answer(Message, ...)} and {@code reply(Message, ...)}
 *       factories that target the chat (and topic) of a received message</li>
 *   <li>A {@code withX(...)} method per parameter returning a copy with that value replaced</li>
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

        // Resolve return type
        TypeName returnType = typeMapper.resolveReturnType(method.returnType());
        TypeName boxedReturnType = returnType.box();
        String returnTypeStr = resolveTypeString(boxedReturnType, imports);

        // Build TelegramMethod<ReturnType> import
        imports.add(typesPackage + ".TelegramMethod");

        // Build record components
        List<String> components = new ArrayList<>();
        List<Withers.Component> witherComponents = new ArrayList<>();
        boolean hasOptionalRefField = false;

        for (FieldDefinition param : method.parameters()) {
            TypeName javaType = typeMapper.resolveMethodParameter(method.name(), param);
            String typeString = resolveTypeString(javaType, imports);

            StringBuilder comp = new StringBuilder();
            comp.append("    @JsonProperty(\"").append(param.name()).append("\")");

            boolean nullable = !param.required() && !javaType.isPrimitive();
            if (nullable) {
                comp.append(" @Nullable");
                hasOptionalRefField = true;
            }

            comp.append(" ").append(typeString).append(" ").append(param.javaName());
            components.add(comp.toString());
            witherComponents.add(new Withers.Component(param.javaName(), typeString, nullable, true));
        }

        if (hasOptionalRefField) {
            imports.add(NULLABLE_PACKAGE + ".Nullable");
        }

        // Built before the imports are written: it may add some.
        String answerFactories = answerFactories(method, imports);

        // Build the source
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(methodsPackage).append(";\n\n");
        for (String imp : imports) {
            sb.append("import ").append(imp).append(";\n");
        }
        sb.append("\n");

        // Record declaration
        sb.append(Javadoc.render(method.description(), method.parameters(), method.name()));
        sb.append("public record ").append(method.className()).append("(\n");
        sb.append(String.join(",\n", components));
        sb.append("\n) implements TelegramMethod<").append(returnTypeStr).append("> {\n\n");

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
        sb.append(answerFactories);
        sb.append(Withers.render(method.className(), witherComponents));

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

    /**
     * For methods that send something into a chat, factories that answer a received message the
     * way aiogram's {@code Message.answer()} / {@code reply()} do: {@code answer(Message, ...)}
     * fills in the chat, forum topic, business connection and direct messages topic from the
     * message (see the hand-written {@code ReplyTarget}); {@code reply(Message, ...)} also replies
     * to it. The other required parameters follow the message.
     */
    private String answerFactories(MethodDefinition method, Set<String> imports) {
        if (!isAnswering(method)) {
            return "";
        }
        imports.add(typesPackage + ".Message");
        String messageParam = method.parameters().stream().anyMatch(p -> p.javaName().equals("message"))
                ? "target" : "message";
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        appendAnswerFactory(sb, method, messageParam, false, imports);
        if (method.parameters().stream().anyMatch(p -> p.name().equals("reply_parameters"))) {
            sb.append("\n");
            appendAnswerFactory(sb, method, messageParam, true, imports);
        }
        return sb.toString();
    }

    private static boolean isAnswering(MethodDefinition method) {
        boolean sends = method.name().startsWith("send") || method.name().equals("copyMessage");
        boolean hasChat = method.parameters().stream().anyMatch(p -> p.name().equals("chat_id") && p.required());
        boolean hasOptionalThread = method.parameters().stream()
                .anyMatch(p -> p.name().equals("message_thread_id") && !p.required());
        return sends && hasChat && hasOptionalThread;
    }

    private void appendAnswerFactory(StringBuilder sb, MethodDefinition method, String messageParam, boolean reply,
                                     Set<String> imports) {
        List<String> factoryParams = new ArrayList<>();
        factoryParams.add("Message " + messageParam);
        List<String> constructorArgs = new ArrayList<>();
        for (FieldDefinition param : method.parameters()) {
            TypeName javaType = typeMapper.resolveMethodParameter(method.name(), param);
            String fromMessage = switch (param.name()) {
                // Most methods take a ChatId; a few (sendGame, sendMessageDraft) only a numeric id.
                case "chat_id" -> javaType.isPrimitive()
                        ? messageParam + ".chat().id()"
                        : "ReplyTarget.chatId(" + messageParam + ")";
                case "message_thread_id" -> "ReplyTarget.messageThreadId(" + messageParam + ")";
                case "business_connection_id" -> "ReplyTarget.businessConnectionId(" + messageParam + ")";
                case "direct_messages_topic_id" -> "ReplyTarget.directMessagesTopicId(" + messageParam + ")";
                case "reply_parameters" -> reply ? "ReplyTarget.replyTo(" + messageParam + ")" : null;
                default -> null;
            };
            if (fromMessage != null) {
                constructorArgs.add(fromMessage);
            } else if (param.required()) {
                factoryParams.add(resolveTypeString(javaType, imports) + " " + param.javaName());
                constructorArgs.add(param.javaName());
            } else {
                constructorArgs.add(javaType.isPrimitive() ? defaultPrimitiveValue(javaType) : "null");
            }
        }

        sb.append("    /**\n");
        if (reply) {
            sb.append("     * Like {@code answer}, as a reply to {@code ").append(messageParam).append("}.\n");
        } else {
            sb.append("     * Sends to the chat of {@code ").append(messageParam)
                    .append("}, and to its forum topic, business connection or direct\n")
                    .append("     * messages topic when it came from one.\n");
        }
        sb.append("     */\n");
        sb.append("    public static ").append(method.className()).append(reply ? " reply(" : " answer(")
                .append(String.join(", ", factoryParams)).append(") {\n");
        sb.append("        return new ").append(method.className()).append("(")
                .append(String.join(", ", constructorArgs)).append(");\n");
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
        return typeName.box().toString();
    }
}
