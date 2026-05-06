package io.jiogram.fsm.processor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FSMStatesProcessorTest {

    @TempDir
    Path tempDir;

    @Test
    void generatesConstantsForAnnotatedEnum() throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        assertNotNull(compiler);

        Path outputDir = tempDir.resolve("classes");
        Path generatedSourcesDir = tempDir.resolve("generated");
        Files.createDirectories(outputDir);
        Files.createDirectories(generatedSourcesDir);
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

        JavaFileObject source = new SourceFile(
            "com.example.Form",
            String.join("\n",
                "package com.example;",
                "",
                "import io.jiogram.fsm.FSMStates;",
                "",
                "@FSMStates",
                "public enum Form {",
                "    WAITING_FOR_NAME,",
                "    WAITING_FOR_AGE,",
                "    CONFIRM",
                "}"
            )
        );

        try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(
            diagnostics,
            null,
            StandardCharsets.UTF_8
        )) {
            Boolean result = compiler.getTask(
                null,
                fileManager,
                diagnostics,
                List.of(
                    "-classpath", System.getProperty("java.class.path"),
                    "-d", outputDir.toString(),
                    "-s", generatedSourcesDir.toString(),
                    "-processor", FSMStatesProcessor.class.getName()
                ),
                null,
                List.of(source)
            ).call();

            assertEquals(Boolean.TRUE, result, diagnostics.getDiagnostics().toString());
        }

        String generated = Files.readString(
            generatedSourcesDir.resolve("com/example/FormStates.java"),
            StandardCharsets.UTF_8
        );
        assertTrue(generated.contains("public final class FormStates"));
        assertTrue(generated.contains("public static final String WAITING_FOR_NAME = \"Form.WAITING_FOR_NAME\";"));
        assertTrue(generated.contains("public static final String WAITING_FOR_AGE = \"Form.WAITING_FOR_AGE\";"));
        assertTrue(generated.contains("public static final String CONFIRM = \"Form.CONFIRM\";"));
    }

    private static final class SourceFile extends SimpleJavaFileObject {
        private final String code;

        private SourceFile(String className, String code) {
            super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }
}
