[O'zbekcha](spring-boot-versions.md) · [English](../spring-boot-versions.md)

# Turli Spring Boot versiyalarida Jiogram

Jiogram bitta repositorydan uchta Spring Boot avlodi uchun publish qilinadi: har bir Spring Boot
major versiyasi uchun bitta branch. Barcha branchlarda API va ishlash tartibi bir xil: handlerlar,
filterlar, FSM, middleware, request builderlar va sozlamalar. Ular faqat build konfiguratsiyasida,
kod qaysi Java versiyasi uchun yozilganida va Spring chaqiriladigan bir nechta joyda farq qiladi.

## Qisqacha

| | sb2.x | sb3.x | main (sb4) |
|---|---|---|---|
| Spring Boot | 2.7.18 | 3.5.x | 4.0.x |
| Java baseline | 11 | 17 | 25 |
| Reactor | 3.4.x | 3.7.x | 3.8.x |
| Jackson | 2.13 | 2.19 | 2.21 (Jackson 2, Boot 4ning default Jackson 3i emas) |
| Generate qilingan type va methodlar | record uslubidagi accessorlar, `equals`, `hashCode`, `toString` bilan final classlar | recordlar | recordlar |
| Unionlar | interfacelar | sealed interfacelar | sealed interfacelar |
| Blocking handlerlar (`telegram.handlers.virtual-threads`) | Java 21+ da virtual threadlar, aks holda bounded elastic pool | sb2.x bilan bir xil | virtual threadlar |
| Har bir update turi bo'yicha `switch` | testlar tekshiradi | compiler tekshiradi | compiler tekshiradi |
| Auto-configurationni ro'yxatdan o'tkazish | `spring.factories` | `AutoConfiguration.imports` | `AutoConfiguration.imports` |

## Kerakli starterni tanlash

Ko'pchilikka faqat starter kerak bo'ladi; qolganlari transitive dependency sifatida keladi.

```groovy
// Spring Boot 2.7.x
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.1'
annotationProcessor 'uz.jtscorp.jiogram:jiogram-fsm-processor-sb2:0.2.1' // for @FSMStates

// Spring Boot 3.5.x
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-3-starter:0.2.1'
annotationProcessor 'uz.jtscorp.jiogram:jiogram-fsm-processor-sb3:0.2.1'

// Spring Boot 4.0.x
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.1'
annotationProcessor 'uz.jtscorp.jiogram:jiogram-fsm-processor-sb4:0.2.1'
```

Modul artifactlarini (`jiogram-types-sbN`, `jiogram-methods-sbN`, `jiogram-core-sbN`,
`jiogram-fsm-sbN`, `jiogram-fsm-processor-sbN` va starter) alohida-alohida ham ishlatish mumkin.

Spring Boot 2.7 Gradle plugini Gradle 9da ishlamaydi. Gradle 9 bilan Spring Boot BOMni uning
o'rniga `io.spring.dependency-management` orqali import qiling, sb2.x misollarida qilinganidek.

## Nega uchta branch?

Uchta Spring Boot avlodini bitta buildda yig'ib bo'lmaydi:

- Spring Boot 2.7 Java 11da ishlaydi, Spring Boot 4ga Java 17 kerak, bu branch esa Java 25 ishlatadi.
- Spring Boot 2.7 auto-configurationlarni `spring.factories` orqali ro'yxatdan o'tkazadi.
- Spring Framework 5.3, 6 va 7 hamda Spring Data Redis 2.x, 3.x va 4.x bir nechta APIda farq qiladi
  (masalan, HTTP statusni o'qish, Redis commandlari).

## Lockstep release modeli

Uchala branch bir xil versiyani bir vaqtda release qiladi. O'zgarishlar avval `main`ga tushadi,
keyin `sb3.x` va `sb2.x`ga ularning Java va Spring versiyalariga moslashtirilgan holda port qilinadi.

## Har bir branchdagi imkoniyatlar

Har bir imkoniyat uchala branchda ham mavjud:

| Imkoniyat | sb2.x | sb3.x | main (sb4) |
|---|---|---|---|
| Polling runner, parallel chatlar, graceful shutdown | ✓ | ✓ | ✓ |
| Secret token bilan webhook controller | ✓ | ✓ | ✓ |
| Annotation va programmatic handlerlar, filterlar, routerlar | ✓ | ✓ | ✓ |
| File upload (`InputFile`) | ✓ | ✓ | ✓ |
| `answer()` / `reply()`, `of()`, `withX()` | ✓ | ✓ | ✓ |
| Nested objectlardagi bot defaultlari | ✓ | ✓ | ✓ |
| Memory yoki Redis storage bilan FSM (prefix, TTL) | ✓ | ✓ | ✓ |
| `@FSMStates` annotation processor | ✓ | ✓ | ✓ |
