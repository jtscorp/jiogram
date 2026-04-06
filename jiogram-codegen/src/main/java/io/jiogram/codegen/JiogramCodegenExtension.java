package io.jiogram.codegen;

import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Property;
import org.gradle.api.provider.SetProperty;

import javax.inject.Inject;

/**
 * Gradle extension for configuring the Jiogram code generation plugin.
 * <p>
 * Registered as {@code jiogramCodegen} in the project's DSL.
 */
public abstract class JiogramCodegenExtension {

    /**
     * Path to the Telegram Bot API schema JSON file.
     */
    public abstract RegularFileProperty getSchemaFile();

    /**
     * Root output directory for generated sources.
     */
    public abstract RegularFileProperty getOutputDir();

    /**
     * Base Java package for generated classes.
     */
    public abstract Property<String> getBasePackage();

    /**
     * Set of generation targets: "types", "methods", "enums".
     */
    public abstract SetProperty<String> getGenerate();

    @Inject
    public JiogramCodegenExtension(ObjectFactory objects) {
        getBasePackage().convention("io.jiogram.types");
        getGenerate().convention(java.util.Set.of("types", "methods", "enums"));
    }
}
