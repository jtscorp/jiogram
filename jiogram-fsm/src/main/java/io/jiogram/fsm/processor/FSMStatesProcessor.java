package io.jiogram.fsm.processor;

import io.jiogram.fsm.FSMStates;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

/**
 * Generates string constants for enums annotated with {@link FSMStates}.
 */
@SupportedAnnotationTypes("io.jiogram.fsm.FSMStates")
public class FSMStatesProcessor extends AbstractProcessor {

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(FSMStates.class)) {
            if (element.getKind() != ElementKind.ENUM) {
                processingEnv.getMessager().printMessage(
                    Diagnostic.Kind.ERROR,
                    "@FSMStates can only be used on enum types",
                    element
                );
                continue;
            }

            try {
                generateStatesClass((TypeElement) element);
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(
                    Diagnostic.Kind.ERROR,
                    "Failed to generate FSM states class: " + e.getMessage(),
                    element
                );
            }
        }
        return true;
    }

    private void generateStatesClass(TypeElement enumType) throws IOException {
        PackageElement packageElement = processingEnv.getElementUtils().getPackageOf(enumType);
        String packageName = packageElement.isUnnamed() ? "" : packageElement.getQualifiedName().toString();
        String enumName = enumType.getSimpleName().toString();
        String generatedClassName = enumName + "States";
        String qualifiedName = packageName.isEmpty()
            ? generatedClassName
            : packageName + "." + generatedClassName;

        Filer filer = processingEnv.getFiler();
        JavaFileObject sourceFile = filer.createSourceFile(qualifiedName, enumType);
        try (Writer writer = sourceFile.openWriter()) {
            if (!packageName.isEmpty()) {
                writer.write("package " + packageName + ";\n\n");
            }
            writer.write("/**\n");
            writer.write(" * Generated FSM state constants for {@link " + enumName + "}.\n");
            writer.write(" */\n");
            writer.write("public final class " + generatedClassName + " {\n");
            writer.write("    private " + generatedClassName + "() {\n");
            writer.write("    }\n\n");

            for (Element enclosed : enumType.getEnclosedElements()) {
                if (enclosed.getKind() == ElementKind.ENUM_CONSTANT) {
                    String constantName = enclosed.getSimpleName().toString();
                    writer.write("    public static final String " + constantName
                        + " = \"" + enumName + "." + constantName + "\";\n");
                }
            }

            writer.write("}\n");
        }
    }
}
