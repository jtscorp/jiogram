plugins {
    `java-library`
}

val jacksonVersion: String by project
val javapoetVersion: String by project

dependencies {
    implementation("com.squareup:javapoet:$javapoetVersion")

    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
}
