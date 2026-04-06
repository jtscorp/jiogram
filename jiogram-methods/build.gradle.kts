plugins {
    `java-library`
}

val jacksonVersion: String by project

dependencies {
    api(project(":jiogram-types"))

    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
}
