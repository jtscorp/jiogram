package io.jiogram.codegen;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * Gradle plugin that registers the {@code jiogramCodegen} extension
 * and the {@code generateTelegramApi} task.
 */
public class JiogramCodegenPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        JiogramCodegenExtension extension = project.getExtensions()
                .create("jiogramCodegen", JiogramCodegenExtension.class);

        project.getTasks().register("generateTelegramApi", GenerateApiTask.class, task -> {
            task.setGroup("codegen");
            task.setDescription("Generates Java source files from the Telegram Bot API schema");
            task.getSchemaFile().set(extension.getSchemaFile());
            task.getOutputDir().set(extension.getOutputDir());
            task.getBasePackage().set(extension.getBasePackage());
            task.getGenerate().set(extension.getGenerate());
        });
    }
}
