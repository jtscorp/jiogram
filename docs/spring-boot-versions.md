[O'zbekcha](uz/spring-boot-versions.md) · [English](spring-boot-versions.md)

# Jiogram across Spring Boot versions

Jiogram is published for three Spring Boot generations from one repository, one branch per Spring
Boot major. All branches have the same API and behaviour: handlers, filters, FSM, middleware,
request builders and settings. They differ in build configuration, in the Java version the code
is written for, and in a few Spring call sites.

## At a glance

| | sb2.x | sb3.x | main (sb4) |
|---|---|---|---|
| Spring Boot | 2.7.18 | 3.5.x | 4.0.x |
| Java baseline | 11 | 17 | 25 |
| Reactor | 3.4.x | 3.7.x | 3.8.x |
| Jackson | 2.13 | 2.19 | 2.21 (Jackson 2, not Boot 4's default Jackson 3) |
| Generated types and methods | final classes with record-style accessors, `equals`, `hashCode`, `toString` | records | records |
| Unions | interfaces | sealed interfaces | sealed interfaces |
| Blocking handlers (`telegram.handlers.virtual-threads`) | virtual threads on Java 21+, a bounded elastic pool otherwise | same as sb2.x | virtual threads |
| `switch` over every update type | checked by tests | checked by the compiler | checked by the compiler |
| Auto-configuration registration | `spring.factories` | `AutoConfiguration.imports` | `AutoConfiguration.imports` |

## Picking the right starter

Most users only need a starter; the rest comes in transitively.

```groovy
// Spring Boot 2.7.x
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.0'
annotationProcessor 'uz.jtscorp.jiogram:jiogram-fsm-processor-sb2:0.2.0' // for @FSMStates

// Spring Boot 3.5.x
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-3-starter:0.2.0'
annotationProcessor 'uz.jtscorp.jiogram:jiogram-fsm-processor-sb3:0.2.0'

// Spring Boot 4.0.x
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0'
annotationProcessor 'uz.jtscorp.jiogram:jiogram-fsm-processor-sb4:0.2.0'
```

The module artifacts (`jiogram-types-sbN`, `jiogram-methods-sbN`, `jiogram-core-sbN`,
`jiogram-fsm-sbN`, `jiogram-fsm-processor-sbN` and the starter) can also be used one by one.

The Spring Boot 2.7 Gradle plugin does not run on Gradle 9; with Gradle 9 import the Spring Boot
BOM through `io.spring.dependency-management` instead, as the sb2.x examples do.

## Why three branches?

The three Spring Boot generations cannot share one build:

- Spring Boot 2.7 runs on Java 11, Spring Boot 4 needs Java 17 and this branch uses Java 25.
- Spring Boot 2.7 registers auto-configurations through `spring.factories`.
- Spring Framework 5.3, 6 and 7 and Spring Data Redis 2.x, 3.x and 4.x differ in a few APIs
  (e.g. reading an HTTP status, Redis commands).

## Lockstep release model

All three branches release the same version at the same time. Changes land on `main` first and
are then ported to `sb3.x` and `sb2.x`, adapted to their Java and Spring versions.

## Supported features per branch

Every feature is available on all three branches:

| Feature | sb2.x | sb3.x | main (sb4) |
|---|---|---|---|
| Polling runner, parallel chats, graceful shutdown | ✓ | ✓ | ✓ |
| Webhook controller with secret token | ✓ | ✓ | ✓ |
| Annotation and programmatic handlers, filters, routers | ✓ | ✓ | ✓ |
| File uploads (`InputFile`) | ✓ | ✓ | ✓ |
| `answer()` / `reply()`, `of()`, `withX()` | ✓ | ✓ | ✓ |
| Bot defaults in nested objects | ✓ | ✓ | ✓ |
| FSM with memory or Redis storage (prefix, TTL) | ✓ | ✓ | ✓ |
| `@FSMStates` annotation processor | ✓ | ✓ | ✓ |
