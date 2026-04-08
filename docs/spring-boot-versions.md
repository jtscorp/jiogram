# Jiogram across Spring Boot versions

Jiogram is published for three Spring Boot generations from a single repository, using a branch-per-Spring-major model. All branches share the same handlers, filters, FSM, and middleware code; only build configuration and a small number of Spring API call sites differ.

## At a glance

| Feature | sb2.x | sb3.x | main (sb4) |
|---|---|---|---|
| Spring Boot BOM | 2.7.18 | 3.5.x | 4.0.x |
| Java baseline | 17 | 17 | 17 |
| Reactor (transitive) | 3.4.x | 3.6.x | 3.7.x |
| WebFlux | yes | yes | yes |
| Redis FSM | yes | yes | yes |
| Jackson | 2.x | 2.x | 2.x (pinned explicitly; Spring Boot 4 default is 3.x) |
| JSpecify | no | optional | planned |
| Status | Legacy | Stable | Latest |
| `META-INF` registration | `spring.factories` | `AutoConfiguration.imports` | `AutoConfiguration.imports` |

## Picking the right starter

Most users only need a starter; the rest comes in transitively.

```groovy
// Spring Boot 2.7.x
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.0'

// Spring Boot 3.5.x
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-3-starter:0.2.0'

// Spring Boot 4.0.x
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0'
```

The five module artifacts (`jiogram-types-sbN`, `jiogram-methods-sbN`, `jiogram-core-sbN`, `jiogram-fsm-sbN`, and the starter) are all available individually if you need a more granular dependency declaration.

## Why three branches?

Spring Boot 2.7 and Spring Boot 4.0 cannot coexist in a single classpath:

- SB2.7 ships META-INF registration via the legacy `spring.factories` file.
- SB3 and SB4 use the newer `AutoConfiguration.imports` file.
- spring-data-redis 2.x, 3.x, and 4.x have minor API differences in `ReactiveRedisTemplate`.

Maintaining three branches (with shared release machinery) lets us publish targeted builds without runtime detection or reflection hacks.

## Lockstep release model

All three branches release the same version simultaneously. Bug fixes land on `main` first, then propagate via `git cherry-pick` to `sb3.x` and `sb2.x`. See `CONTRIBUTING.md` (added in Plan 4) for the cherry-pick workflow.

## Supported features per branch

| Feature | sb2.x | sb3.x | main (sb4) |
|---|---|---|---|
| Polling runner | ✓ | ✓ | ✓ |
| Webhook controller | ✓ | ✓ | ✓ |
| `@OnMessage`/`@OnCallbackQuery` annotations | ✓ | ✓ | ✓ |
| Filters and Routers | ✓ | ✓ | ✓ |
| FSM (Memory storage) | ✓ | ✓ | ✓ |
| FSM (Redis storage) | ✓ | ✓ | ✓ |
| FSMMiddleware | ✓ | ✓ | ✓ |

If a feature lands only on `main`, it is documented in `CHANGELOG.md` under an `### SB4-only` heading.
