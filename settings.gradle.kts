rootProject.name = "jiogram"

pluginManagement {
    includeBuild("jiogram-codegen")
}

include(
    "jiogram-types",
    "jiogram-methods",
    "jiogram-core",
    "jiogram-fsm",
    "jiogram-spring-boot-starter"
)
