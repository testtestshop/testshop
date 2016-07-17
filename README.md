# README

Тестовое задание "интернет-магазин".

# Сборка

Для сборки использовать [maven](https://maven.apache.org/) команду: ```mvn package```  
Итоговый ```.war``` перенести в каталог ```/webapps``` на сервере.

В каталоге ```src/main/resources/import.sql``` находятся данные по умолчанию.

# TODO list

* Сделать Side Menu с фильтром товаров по категориям и заказы по пользователям
* Сделать локализацию (l18n) [MessageSource](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/MessageSource.html)
* Создание и назначение категории товару через связь @ManyToMany
* Авто очистка старых записей в базе
* Validation всех форм
* Включить хеширование пароля bcrypt (отключено для теста)
* Создать тесты JUnit
* Настроить connection pool [HikariCP](https://brettwooldridge.github.io/HikariCP/)
* Вынести часть логики из @Controller в @Service
* Расставить ограничения на значения базы данных
* Перехват ошибок транзакций через @ControllerAdvice и @ExceptionHandler(MyExeption.class)
* Создать страницу с описанием ошибок /error
* Сделать загрузку картинок
* Отобразить количество заказов в nav bar
* Страница с отображением заказов пользователей в реальном времени (через WebSocket)
* Изменить таблицу категорий товаров ItemList. Создание и назначение категории товару через связь @ManyToMany

# Frameworks and libraries

* Spring Boot
* Spring Data JPA
* Thymeleaf
* Hibernate ORM
* Hibernate Validator
* Bootstrap