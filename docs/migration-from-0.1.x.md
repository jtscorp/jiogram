# Migrating from jiogram 0.1.0 to 0.2.0

`jiogram` 0.2.0 is a hard break from 0.1.0. The single artifact `uz.jtscorp.jiogram:jiogram-spring-boot-starter` is **frozen**: it will not receive 0.2.0 or any later updates. To upgrade, switch your dependency to the new branch-specific starter that matches your Spring Boot version.

## What changed

| Concern | 0.1.0 (frozen) | 0.2.0 |
|---|---|---|
| GroupId | `uz.jtscorp.jiogram` | `uz.jtscorp.jiogram` (unchanged) |
| Single starter artifact | `jiogram-spring-boot-starter` | three starters: `jiogram-spring-boot-{2,3,4}-starter` |
| Module artifacts | `jiogram-core`, `jiogram-fsm`, etc. | `jiogram-core-sb{2,3,4}`, `jiogram-fsm-sb{2,3,4}`, etc. |
| Spring Boot supported | 3.5 only | 2.7, 3.5, and 4.0 |
| Java baseline | 25 (preview features required) | 17 |

There are **no** runtime API changes. Handlers, filters, FSM, and middleware code carry over unchanged. Only the Maven coordinate changes.

## Step-by-step upgrade

### 1. Identify your Spring Boot version

```bash
./gradlew dependencyInsight --dependency org.springframework.boot:spring-boot --configuration runtimeClasspath
```

The output shows the Spring Boot version your project resolves.

### 2. Pick the matching starter

| Spring Boot | New starter coordinate |
|---|---|
| 2.7.x | `uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.0` |
| 3.5.x | `uz.jtscorp.jiogram:jiogram-spring-boot-3-starter:0.2.0` |
| 4.0.x | `uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0` |

### 3. Update your `build.gradle`

Replace:

```groovy
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-starter:0.1.0'
```

With (e.g. for Spring Boot 3.5):

```groovy
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-3-starter:0.2.0'
```

### 4. Set the Java toolchain for your target branch

The Spring Boot 4 starter on `main` targets Java 25:

```groovy
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}
```

The Spring Boot 2.7 and 3.5 branches keep their lower Java baseline; use the version documented on the branch you consume.

### 5. Build and test

```bash
./gradlew clean build
```

No application code changes are required. If you see compile errors, please open an issue — they would indicate an API drift we did not document.

## Why the hard break

`jiogram` 0.1.0 was a single-artifact preview that required Spring Boot 3.5 and Java 25 with preview features. Supporting older Spring Boot versions required either runtime detection (fragile) or republishing under a new naming scheme (clean). We chose the latter and froze the old artifact rather than evolve it in place.

The 0.2.0 release line will receive bug fixes and Telegram Bot API updates simultaneously across all three branches via a lockstep release.
