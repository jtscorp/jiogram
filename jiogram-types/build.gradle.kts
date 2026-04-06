plugins {
    `java-library`
    id("io.jiogram.codegen")
}

val jacksonVersion: String by project

dependencies {
    api("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("org.jspecify:jspecify:1.0.0")
}

jiogramCodegen {
    schemaFile.set(file("../schema/schema.json"))
    outputDir.set(file("src/main/generated"))
    basePackage.set("io.jiogram.types")
    generate.set(setOf("types", "enums"))
}

sourceSets {
    main {
        java {
            srcDir("src/main/generated")
        }
    }
}

tasks.named("compileJava") {
    dependsOn("generateTelegramApi")
}
