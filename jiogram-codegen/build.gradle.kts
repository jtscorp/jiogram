plugins {
    `java-library`
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.addAll(listOf("--enable-preview"))
}

dependencies {
    implementation("com.squareup:javapoet:1.13.0")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.4")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.18.4")
    implementation("com.fasterxml.jackson.core:jackson-core:2.18.4")

    implementation("org.jspecify:jspecify:1.0.0")
}

gradlePlugin {
    plugins {
        create("jiogramCodegen") {
            id = "io.jiogram.codegen"
            implementationClass = "io.jiogram.codegen.JiogramCodegenPlugin"
        }
    }
}
