# [_Дипломный проект профессии «Тестировщик»_][Task]
[<img align="right" src="/workpapers/GradleBuildScan.png"/>][GradleBuildScan]

---
## Процедура запуска автотестов

### Необходимое окружение
- [x] [**Docker Desktop 3.1.0 (51484)**](https://www.docker.com/products/docker-desktop)
- [x] [**AdoptOpenJDK 11.0.10+9**](https://adoptopenjdk.net/index.html)

### Запуск
1. Получить код [репозитория](https://github.com/Cliffart44/FQA-9_Thesis.git) удобным способом.
2. Выполнить (в каталоге [_Docker_](/Docker)) <br> `docker-compose up -d`.
3. Включить `SUT` командой <br> `java -jar aqa-shop.jar`.
4. Запустить автотесты командой <br> `./gradlew clean test`.

### Отчёты
> В результате прогона тестов доступны `Gradle` [_Test Summary_][Vercel] и [_Build Scan_][GradleBuildScan]. 

---
### Переключение баз данных
По умолчанию `SUT` работает с [_PostgreSQL_](https://www.postgresql.org/about/), однако, можно задействовать [_MySQL_](https://www.mysql.com/about/) при необходимости.
<br> Для этого нужно:
* включить `SUT` [командой](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config-files) <br> `java -jar aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app`;
* запустить автотесты [командой](https://issues.gradle.org/browse/GRADLE-2122) <br> `./gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app`.

> Для этой конфигурации также доступно `Gradle` [_Test MySQL-Summary_][Netlify].

---
[<img align="left" src="https://api.netlify.com/api/v1/badges/2caf1462-6356-4028-a247-ae639e794908/deploy-status"/>][Netlify]
[<img align="left" src="https://ci.appveyor.com/api/projects/status/xoa9fkg0cndn2rrt?svg=true"/>][AppVeyor]
[<img align="left" src="https://badges.gitter.im/Cliffart44/community.svg"/>][Gitter]

[Task]: https://github.com/netology-code/qa-diploma/tree/2ccafd34b6f9eb3a66dd7a11a0b8b1ba3f266e50#%D0%B4%D0%B8%D0%BF%D0%BB%D0%BE%D0%BC%D0%BD%D1%8B%D0%B9-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82-%D0%BF%D1%80%D0%BE%D1%84%D0%B5%D1%81%D1%81%D0%B8%D0%B8-%D1%82%D0%B5%D1%81%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D1%89%D0%B8%D0%BA
[GradleBuildScan]: https://gradle.com/s/wjserrg5afumm
[Vercel]: https://fqa-9-thesis-gradle-report.vercel.app/
[Netlify]: https://fqa-9-thesis-gradle-mysql-report.netlify.app/
[AppVeyor]: https://ci.appveyor.com/project/Cliffart44/fqa-9-thesis
[Gitter]: https://gitter.im/Cliffart44/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge
