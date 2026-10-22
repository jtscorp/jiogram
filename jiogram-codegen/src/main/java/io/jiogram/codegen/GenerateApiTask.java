package io.jiogram.codegen;

import com.squareup.javapoet.TypeName;
import io.jiogram.codegen.model.ApiSchema;
import io.jiogram.codegen.model.EnumDefinition;

import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.provider.SetProperty;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Gradle task that generates Java source files from the Telegram Bot API schema.
 */
public abstract class GenerateApiTask extends DefaultTask {

    static {
        // JavaPoet's TypeName and its subclass ClassName initialize each other. When two of these
        // tasks (jiogram-types and jiogram-methods) start in parallel, one thread can begin with
        // TypeName and the other with ClassName and deadlock on the class initialization locks.
        // Initializing TypeName here, once, on the thread that loads this class avoids that.
        Objects.requireNonNull(TypeName.OBJECT);
    }

    /**
     * Schema types implemented by hand in jiogram-types (the schema has no usable shape for them).
     */
    private static final Set<String> HAND_WRITTEN_TYPES = Set.of("InputFile");

    @InputFile
    public abstract RegularFileProperty getSchemaFile();

    @OutputDirectory
    public abstract RegularFileProperty getOutputDir();

    @Input
    public abstract Property<String> getBasePackage();

    @Input
    public abstract SetProperty<String> getGenerate();

    @TaskAction
    public void generate() throws IOException {
        File schemaFile = getSchemaFile().getAsFile().get();
        File outputDir = getOutputDir().getAsFile().get();
        String basePackage = getBasePackage().get();
        Set<String> targets = getGenerate().get();

        getLogger().lifecycle("Jiogram codegen: schema={}, output={}, package={}, targets={}",
                schemaFile, outputDir, basePackage, targets);

        ApiSchema schema = SchemaParser.parse(schemaFile);
        getLogger().lifecycle("Parsed schema: {} types, {} methods", schema.types().size(), schema.methods().size());

        if (targets.contains("types")) {
            List<String> unionDifferences = UnionRegistry.differencesFrom(schema);
            if (!unionDifferences.isEmpty()) {
                throw new GradleException("UnionRegistry does not match the schema; update it:\n  - "
                        + String.join("\n  - ", unionDifferences));
            }
        }

        // Everything in the package is regenerated; files of types or methods the schema no
        // longer has would otherwise linger and keep compiling.
        int deleted = deleteGeneratedSources(outputDir.toPath().resolve(basePackage.replace('.', '/')));
        getLogger().lifecycle("Deleted {} previously generated files", deleted);

        TypeMapper typeMapper = new TypeMapper("io.jiogram.types");

        int typeCount = 0;
        int methodCount = 0;
        int enumCount = 0;

        if (targets.contains("types")) {
            TypeGenerator typeGenerator = new TypeGenerator(typeMapper, basePackage);
            for (var type : schema.types()) {
                if (HAND_WRITTEN_TYPES.contains(type.name())) {
                    continue;
                }
                typeGenerator.generate(type, outputDir);
                typeCount++;
            }
            getLogger().lifecycle("Generated {} type files", typeCount);
        }

        if (targets.contains("methods")) {
            MethodGenerator methodGenerator = new MethodGenerator(typeMapper, basePackage, "io.jiogram.types");
            for (var method : schema.methods()) {
                methodGenerator.generate(method, outputDir);
                methodCount++;
            }
            getLogger().lifecycle("Generated {} method files", methodCount);
        }

        if (targets.contains("enums")) {
            List<EnumDefinition> enums = EnumExtractor.extract(schema);
            EnumGenerator enumGenerator = new EnumGenerator(basePackage);
            for (var enumDef : enums) {
                enumGenerator.generate(enumDef, outputDir);
                enumCount++;
            }
            getLogger().lifecycle("Generated {} enum files", enumCount);
        }

        getLogger().lifecycle("Jiogram codegen complete: {} types, {} methods, {} enums",
                typeCount, methodCount, enumCount);
    }

    private static int deleteGeneratedSources(Path packageDir) throws IOException {
        if (!Files.isDirectory(packageDir)) {
            return 0;
        }
        List<Path> sources;
        try (Stream<Path> files = Files.list(packageDir)) {
            sources = files.filter(file -> file.getFileName().toString().endsWith(".java")).toList();
        }
        for (Path source : sources) {
            Files.delete(source);
        }
        return sources.size();
    }
}
