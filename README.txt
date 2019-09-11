При запуске файла TestSendProfileOffline/TestSendProfileOnline начинается проверка бека анкеты 3.0, а именно:
-Заполнение данных (всех возможных вариантов которые есть в анкете: статусы, образование, тип бизнеса и тп).
-Проверка того, что записалось в БД.
-Ответ сервера на неверные, битые и правильные запросы.

Перед запуском тестов в Оффлайне проверить логин и пароль (mv_test_new_1)

При возникновении ошибки "java.lang.NoClassDefFoundError: java/sql/SQLException" - вероятная причина в shorten command line. Для исправления перейти в Run-> Edit Configuration.. -> Shorten command line
и проверить выбор JAR manifest (обычно сбрасывается до "user-local default: none").

Для вызова отчёта allure использовать комманды:

Удаление и установка необходимых зависимостей
mvn clean install

Запуск тестов через команду
mvn clean test

