package io.jiogram.fsm.processor;

import io.jiogram.fsm.FSMStates;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
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
 * Generates string state constants for enums annotated with {@link FSMStates}.
 */
@SupportedAnnotationTypes("io.jiogram.fsm.FSMStates")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class FSMStatesProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(FSMStates.class)) {
            if (element.getKind() != ElementKind.ENUM) {
                processingEnv.getMessager().printMessage(
                    Diagnostic.Kind.ERROR,
                    "@FSMStates can only be applied to enums",
                    element
                );
                continue;
            }

            try {
                generateStatesClass((TypeElement) element);
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(
                    Diagnostic.Kind.ERROR,
                    "Failed to generate FSM state constants: " + e.getMessage(),
                    element
                );
            }
        }
        return true;
    }

    private void generateStatesClass(TypeElement enumElement) throws IOException {
        String enumName = enumElement.getSimpleName().toString();
        String generatedName = enumName + "States";
        PackageElement packageElement = processingEnv.getElementUtils().getPackageOf(enumElement);
        String packageName = packageElement.isUnnamed() ? "" : packageElement.getQualifiedName().toString();
        String qualifiedName = packageName.isEmpty() ? generatedName : packageName + "." + generatedName;

        Filer filer = processingEnv.getFiler();
        JavaFileObject file = filer.createSourceFile(qualifiedName, enumElement);

        try (Writer writer = file.openWriter()) {
            if (!packageName.isEmpty()) {
                writer.write("package " + packageName + ";\n\n");
            }
            writer.write("public final class " + generatedName + " {\n");
            writer.write("    private " + generatedName + "() {\n");
            writer.write("    }\n\n");

            for (Element enclosed : enumElement.getEnclosedElements()) {
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
