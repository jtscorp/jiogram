package io.jiogram.fsm.processor;

import org.junit.jupiter.api.Test;

import javax.tools.ToolProvider;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FSMStatesProcessorTest {

    @Test
    void generatesConstantsForAnnotatedEnum() throws Exception {
        Path tempDir = Files.createTempDirectory("fsm-states-processor-test");
        Path sourcesDir = Files.createDirectories(tempDir.resolve("sources"));
        Path classesDir = Files.createDirectories(tempDir.resolve("classes"));
        Path generatedDir = Files.createDirectories(tempDir.resolve("generated"));
        Path source = sourcesDir.resolve("Form.java");

        Files.writeString(source, """
            package com.example;

            import io.jiogram.fsm.FSMStates;

            @FSMStates
            public enum Form {
                WAITING_FOR_NAME,
                WAITING_FOR_AGE,
                CONFIRM
            }
            """, StandardCharsets.UTF_8);

        var compiler = ToolProvider.getSystemJavaCompiler();
        assertTrue(compiler != null, "A JDK compiler is required to run this test");

        int result = compiler.run(
            null,
            null,
            null,
            "-classpath", System.getProperty("java.class.path"),
            "-processor", FSMStatesProcessor.class.getName(),
            "-d", classesDir.toString(),
            "-s", generatedDir.toString(),
            source.toString()
        );

        assertEquals(0, result);

        Path generated = generatedDir.resolve("com/example/FormStates.java");
        assertTrue(Files.exists(generated));

        List<String> lines = Files.readAllLines(generated, StandardCharsets.UTF_8);
        assertTrue(lines.contains("    public static final String WAITING_FOR_NAME = \"Form.WAITING_FOR_NAME\";"));
        assertTrue(lines.contains("    public static final String WAITING_FOR_AGE = \"Form.WAITING_FOR_AGE\";"));
        assertTrue(lines.contains("    public static final String CONFIRM = \"Form.CONFIRM\";"));
    }
}
