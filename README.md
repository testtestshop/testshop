# README

Тестовое задание "интернет-магазин".

# Сборка

Для сборки использовать [maven](https://maven.apache.org/) команду: ```mvn package```  
Итоговый ```.war``` перенести в каталог ```/webapps``` на сервере.

В файле ```src/main/resources/import.sql``` находятся данные по умолчанию.  
Пользователи по умолчанию:  
	* Имя: **admin** (с ролью ROLE_ADMIN), пароль: **testpass**  
	* Имя: **user** (с ролью ROLE_USER), пароль: **testpass**
	
# TODO list

* Side Menu с фильтром товаров по категориям и заказы по пользователям
* Локализацию (l18n) [MessageSource](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/MessageSource.html)
* Создание и назначение категории товару через связь @ManyToMany
* Авто очистка старых записей в базе
* Validation всех форм
* Включить хеширование пароля bcrypt (отключено для теста)
* Создать тесты JUnit
* Настроить connection pool [HikariCP](https://brettwooldridge.github.io/HikariCP/)
* Вынести часть логики из @Controller в @Service
* Расставить ограничения на значения базы данных
* Перехват ошибок транзакций через @ControllerAdvice и @ExceptionHandler
* Создать страницу с описанием ошибок /error
* Сделать загрузку картинок
* Отобразить количество заказов в nav bar
* Страница с отображением заказов пользователей в реальном времени (через WebSocket)
* Изменить таблицу категорий товаров ItemList. Создание и назначение категории товару через связь @ManyToMany

# Frameworks and libraries

* [Spring Boot](http://projects.spring.io/spring-boot/)
* Spring Data JPA
* [Thymeleaf](www.thymeleaf.org)
* Hibernate ORM
* Hibernate Validator
* Bootstrap