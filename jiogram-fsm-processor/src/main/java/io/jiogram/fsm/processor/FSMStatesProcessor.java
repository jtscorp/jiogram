package io.jiogram.fsm.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Generated;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;

/**
 * Generates {@code <EnumName>States} constants for enums annotated with
 * {@code io.jiogram.fsm.FSMStates}.
 * <p>
 * Shipped as its own artifact without dependencies, so adding it to the
 * {@code annotationProcessor} path pulls nothing else in. It refers to the annotation only by
 * name; the annotation itself lives in jiogram-fsm.
 */
@SupportedAnnotationTypes("io.jiogram.fsm.FSMStates")
public final class FSMStatesProcessor extends AbstractProcessor {

    /**
     * Supports whatever release the compiler runs on (it only reads enum constants), so newer
     * JDKs do not warn about an unsupported source version.
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // Only io.jiogram.fsm.FSMStates is supported, so `annotations` holds at most that one.
        for (TypeElement annotation : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
                if (!(element instanceof TypeElement typeElement)) {
                    continue;
                }

                if (typeElement.getKind() != ElementKind.ENUM) {
                    error(typeElement, "@FSMStates can only be used on enum types");
                    continue;
                }

                generate(typeElement);
            }
        }
        return false;
    }

    private void generate(TypeElement enumType) {
        Elements elements = processingEnv.getElementUtils();
        PackageElement packageElement = elements.getPackageOf(enumType);
        String packageName = packageElement.isUnnamed() ? "" : packageElement.getQualifiedName().toString();
        // Same rule as NamedState.qualifiedName: the type name relative to its package, so a nested
        // OrderFlow.State yields "OrderFlow.State.CONFIRM" and the class OrderFlowStateStates.
        String qualifiedType = enumType.getQualifiedName().toString();
        String enumName = packageName.isEmpty() ? qualifiedType : qualifiedType.substring(packageName.length() + 1);
        String generatedName = enumName.replace(".", "") + "States";
        String qualifiedName = packageName.isEmpty() ? generatedName : packageName + "." + generatedName;
        List<? extends Element> constants = enumType.getEnclosedElements().stream()
                .filter(element -> element.getKind() == ElementKind.ENUM_CONSTANT)
                .toList();

        try {
            Filer filer = processingEnv.getFiler();
            JavaFileObject source = filer.createSourceFile(qualifiedName, enumType);
            try (Writer writer = source.openWriter()) {
                writeSource(writer, packageName, enumName, generatedName, constants);
            }
        } catch (IOException e) {
            error(enumType, "Could not generate FSM state constants: " + e.getMessage());
        }
    }

    private void writeSource(
            Writer writer,
            String packageName,
            String enumName,
            String generatedName,
            List<? extends Element> constants) throws IOException {

        if (!packageName.isEmpty()) {
            writer.write("package " + packageName + ";\n\n");
        }
        writer.write("import " + Generated.class.getCanonicalName() + ";\n\n");
        writer.write("@Generated(\"" + FSMStatesProcessor.class.getCanonicalName() + "\")\n");
        writer.write("public final class " + generatedName + " {\n");
        writer.write("    private " + generatedName + "() {\n");
        writer.write("    }\n\n");

        for (Element constant : constants) {
            String name = constant.getSimpleName().toString();
            writer.write("    public static final String " + name + " = \"" + enumName + "." + name + "\";\n");
        }

        writer.write("}\n");
    }

    private void error(Element element, String message) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, message, element);
    }
}
