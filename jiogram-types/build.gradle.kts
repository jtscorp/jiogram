plugins {
    `java-library`
}

val jacksonVersion: String by project

dependencies {
    api("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
}
