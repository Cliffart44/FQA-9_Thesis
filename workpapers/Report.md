# [Отчёт по итогам тестирования][Task]

| `Gradle` [_Test Summary_][Vercel] | `Gradle` [_Build Scan_][GradleBuildScan] | `Gradle` [_Test MySQL-Summary_][Netlify] |
| :---: | :---: | :---: |

Тестовые сценарии отрабатывались в контексте непосредственной оплаты, а также для кредитной линии (`Happy path`&`Unhappy path`). При этом проверялась корректность внесения информации в две базы данных: [_PostgreSQL_][PostgreSQL] (`default database`) и [_MySQL_][MySQL].

> #### ⚠️ Проведённая работа выявила ряд проблем, требующих внимания ⚠️
Всего было исполнено **36** тестов, [успешных][Vercel] из них всего **41%**. При этом обе заявленные базы данных поддерживаются одинаково хорошо, производительность [_PostgreSQL_][PostgreSQL] оказалась несколько выше. В целом можно рекомендовать более тщательную проработку кредитной части сервиса, поскольку успешных тестов здесь [всего треть](https://scans.gradle.com/s/g52x4prha2zfg/tests#:-test-test-creditpageuitest) - против [половины](https://scans.gradle.com/s/g52x4prha2zfg/tests#:-test-test-paymentpageuitest) в аналогичной части прямой оплаты.

---
[<img align="left" src="https://img.shields.io/github/issues-raw/Cliffart44/FQA-9_Thesis?style=for-the-badge"/>][Issues]
[<img align="right" src="https://img.shields.io/appveyor/build/Cliffart44/fqa-9-thesis?style=for-the-badge"/>][AppVeyor]

[Task]: https://github.com/netology-code/qa-diploma/tree/2ccafd34b6f9eb3a66dd7a11a0b8b1ba3f266e50#%D0%BE%D1%82%D1%87%D1%91%D1%82%D0%BD%D1%8B%D0%B5-%D0%B4%D0%BE%D0%BA%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D1%8B-%D0%BF%D0%BE-%D0%B8%D1%82%D0%BE%D0%B3%D0%B0%D0%BC-%D1%82%D0%B5%D1%81%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F
[GradleBuildScan]: https://gradle.com/s/g52x4prha2zfg
[Vercel]: https://fqa-9-thesis-gradle-report.vercel.app/
[Netlify]: https://fqa-9-thesis-gradle-mysql-report.netlify.app/
[AppVeyor]: https://ci.appveyor.com/project/Cliffart44/fqa-9-thesis/history
[Issues]: https://github.com/Cliffart44/FQA-9_Thesis/issues
[PostgreSQL]: https://www.postgresql.org/about/
[MySQL]: https://www.mysql.com/about/