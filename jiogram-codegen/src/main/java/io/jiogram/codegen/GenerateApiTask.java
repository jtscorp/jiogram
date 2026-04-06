package io.jiogram.codegen;

import io.jiogram.codegen.model.ApiSchema;
import io.jiogram.codegen.model.EnumDefinition;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.provider.SetProperty;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Gradle task that generates Java source files from the Telegram Bot API schema.
 */
public abstract class GenerateApiTask extends DefaultTask {

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

        TypeMapper typeMapper = new TypeMapper("io.jiogram.types");

        int typeCount = 0;
        int methodCount = 0;
        int enumCount = 0;

        if (targets.contains("types")) {
            TypeGenerator typeGenerator = new TypeGenerator(typeMapper, basePackage);
            for (var type : schema.types()) {
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
}
