plugins {
    `java-library`
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
}

val springBootVersion: String by project

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
    }
}

dependencies {
    api(project(":jiogram-core"))

    implementation("org.springframework:spring-context")

    // Optional Redis support for distributed state storage
    compileOnly("org.springframework.data:spring-data-redis")
    compileOnly("io.lettuce:lettuce-core")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
