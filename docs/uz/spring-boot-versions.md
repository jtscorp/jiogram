[O'zbekcha](spring-boot-versions.md) · [English](../spring-boot-versions.md)

# Turli Spring Boot versiyalarida Jiogram

Jiogram bitta repository'dan uchta Spring Boot avlodi uchun publish qilinadi: har bir Spring Boot
major versiyasi uchun bitta branch. Barcha branch'larda API va ishlash tartibi bir xil: handler'lar,
filter'lar, FSM, middleware, request builder'lar va sozlamalar. Ular faqat build konfiguratsiyasida,
kod qaysi Java versiyasi uchun yozilganida va Spring chaqiriladigan bir nechta joyda farq qiladi.

## Qisqacha

| | sb2.x | sb3.x | main (sb4) |
|---|---|---|---|
| Spring Boot | 2.7.18 | 3.5.x | 4.0.x |
| Java baseline | 11 | 17 | 25 |
| Reactor | 3.4.x | 3.7.x | 3.8.x |
| Jackson | 2.13 | 2.19 | 2.21 (Jackson 2, Boot 4'ning default Jackson 3'i emas) |
| Generate qilingan type va method'lar | record uslubidagi accessor'lar, `equals`, `hashCode`, `toString` bilan final class'lar | record'lar | record'lar |
| Union'lar | interface'lar | sealed interface'lar | sealed interface'lar |
| Blocking handler'lar (`telegram.handlers.virtual-threads`) | Java 21+ da virtual thread'lar, aks holda bounded elastic pool | sb2.x bilan bir xil | virtual thread'lar |
| Har bir update turi bo'yicha `switch` | test'lar tekshiradi | compiler tekshiradi | compiler tekshiradi |
| Auto-configuration'ni ro'yxatdan o'tkazish | `spring.factories` | `AutoConfiguration.imports` | `AutoConfiguration.imports` |

## Kerakli starter'ni tanlash

Ko'pchilikka faqat starter kerak bo'ladi; qolganlari transitive dependency sifatida keladi.

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

Modul artifact'larini (`jiogram-types-sbN`, `jiogram-methods-sbN`, `jiogram-core-sbN`,
`jiogram-fsm-sbN`, `jiogram-fsm-processor-sbN` va starter) alohida-alohida ham ishlatish mumkin.

Spring Boot 2.7 Gradle plugin'i Gradle 9'da ishlamaydi. Gradle 9 bilan Spring Boot BOM'ni uning
o'rniga `io.spring.dependency-management` orqali import qiling, sb2.x misollarida qilinganidek.

## Nega uchta branch?

Uchta Spring Boot avlodini bitta build'da yig'ib bo'lmaydi:

- Spring Boot 2.7 Java 11'da ishlaydi, Spring Boot 4'ga Java 17 kerak, bu branch esa Java 25 ishlatadi.
- Spring Boot 2.7 auto-configuration'larni `spring.factories` orqali ro'yxatdan o'tkazadi.
- Spring Framework 5.3, 6 va 7 hamda Spring Data Redis 2.x, 3.x va 4.x bir nechta API'da farq qiladi
  (masalan, HTTP status'ni o'qish, Redis command'lari).

## Lockstep release modeli

Uchala branch bir xil versiyani bir vaqtda release qiladi. O'zgarishlar avval `main`'ga tushadi,
keyin `sb3.x` va `sb2.x`'ga ularning Java va Spring versiyalariga moslashtirilgan holda port qilinadi.

## Har bir branch'dagi imkoniyatlar

Har bir imkoniyat uchala branch'da ham mavjud:

| Imkoniyat | sb2.x | sb3.x | main (sb4) |
|---|---|---|---|
| Polling runner, parallel chat'lar, graceful shutdown | ✓ | ✓ | ✓ |
| Secret token bilan webhook controller | ✓ | ✓ | ✓ |
| Annotation va programmatic handler'lar, filter'lar, router'lar | ✓ | ✓ | ✓ |
| File upload (`InputFile`) | ✓ | ✓ | ✓ |
| `answer()` / `reply()`, `of()`, `withX()` | ✓ | ✓ | ✓ |
| Nested object'lardagi bot default'lari | ✓ | ✓ | ✓ |
| Memory yoki Redis storage bilan FSM (prefix, TTL) | ✓ | ✓ | ✓ |
| `@FSMStates` annotation processor | ✓ | ✓ | ✓ |
