package io.jiogram.fsm.processor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Runs the processor through javac on small sources and checks the generated constants.
 */
class FSMStatesProcessorTest {

    @TempDir
    Path dir;

    @Test
    void topLevelEnum_keepsItsNameAndClassName() throws IOException {
        compile("p/Form.java", "package p;\n"
            + "@io.jiogram.fsm.FSMStates\n"
            + "public enum Form { WAITING_FOR_NAME }\n");

        String generated = Files.readString(dir.resolve("generated/p/FormStates.java"));
        assertTrue(generated.contains("WAITING_FOR_NAME = \"Form.WAITING_FOR_NAME\""), generated);
    }

    @Test
    void nestedEnumsWithTheSameName_getDistinctClassesAndNames() throws IOException {
        compile("p/OrderFlow.java", "package p;\n"
            + "public class OrderFlow {\n"
            + "    @io.jiogram.fsm.FSMStates\n"
            + "    public enum State { CONFIRM }\n"
            + "}\n", "p/PaymentFlow.java", "package p;\n"
            + "public class PaymentFlow {\n"
            + "    @io.jiogram.fsm.FSMStates\n"
            + "    public enum State { CONFIRM }\n"
            + "}\n");

        assertTrue(Files.readString(dir.resolve("generated/p/OrderFlowStateStates.java"))
            .contains("CONFIRM = \"OrderFlow.State.CONFIRM\""));
        assertTrue(Files.readString(dir.resolve("generated/p/PaymentFlowStateStates.java"))
            .contains("CONFIRM = \"PaymentFlow.State.CONFIRM\""));
    }

    @Test
    void nonEnum_isReportedAsError() throws IOException {
        List<Diagnostic<? extends JavaFileObject>> errors = compileExpectingErrors("p/NotAnEnum.java", "package p;\n"
            + "@io.jiogram.fsm.FSMStates\n"
            + "public class NotAnEnum {}\n");

        assertEquals(1, errors.size());
        assertTrue(errors.get(0).getMessage(null).contains("can only be used on enum types"));
    }

    private void compile(String... pathsAndSources) throws IOException {
        List<Diagnostic<? extends JavaFileObject>> errors = run(pathsAndSources);
        assertTrue(errors.isEmpty(), () -> "compilation failed: " + errors);
    }

    private List<Diagnostic<? extends JavaFileObject>> compileExpectingErrors(String... pathsAndSources)
            throws IOException {
        return run(pathsAndSources);
    }

    private List<Diagnostic<? extends JavaFileObject>> run(String... pathsAndSources) throws IOException {
        Path sources = Files.createDirectories(dir.resolve("src"));
        Path generated = Files.createDirectories(dir.resolve("generated"));
        Path classes = Files.createDirectories(dir.resolve("classes"));
        List<Path> files = new ArrayList<>();
        for (int i = 0; i < pathsAndSources.length; i += 2) {
            Path file = sources.resolve(pathsAndSources[i]);
            Files.createDirectories(file.getParent());
            files.add(Files.writeString(file, pathsAndSources[i + 1]));
        }

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null)) {
            List<String> options = List.of(
                // Compile as a Java 11 consumer would, so the generated source must be Java 11.
                "--release", "11",
                "-classpath", System.getProperty("java.class.path"),
                "-processor", FSMStatesProcessor.class.getName(),
                "-s", generated.toString(),
                "-d", classes.toString());
            compiler.getTask(null, fileManager, diagnostics, options, null,
                fileManager.getJavaFileObjectsFromPaths(files)).call();
        }
        return diagnostics.getDiagnostics().stream()
            .filter(d -> d.getKind() == Diagnostic.Kind.ERROR)
            .collect(Collectors.toList());
    }
}
