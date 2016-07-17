# README

Тестовое задание "интернет-магазин".

# Сборка

Для сборки использовать [maven](https://maven.apache.org/) команду: ```mvn package```  
Итоговый ```.war``` перенести в каталог ```/webapps``` на сервере.

Найти и изменить конфигурацию базы данных можно в файле src/main/java/com/testshop/config/DBConfig.java
База данных по умолчанию:  
```properties
	db.name=jdbc:mysql://localhost:3306/testshop
	db.username = root
	#db.password = пароль пустой
```

В файле ```src/main/resources/import.sql``` находятся данные по умолчанию.  
Пользователи по умолчанию:  
	* Имя: **admin** (с ролью ROLE_ADMIN), пароль: **testpass**  
	* Имя: **user** (с ролью ROLE_USER), пароль: **testpass**
	
# TODO list

* Side Menu с фильтром товаров по категориям и заказы по пользователям
* Локализацию (l18n) [MessageSource](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/MessageSource.html)
* Авто очистка старых записей в базе
* Validation всех форм
* Включить хеширование пароля bcrypt (отключено для теста)
* Создать тесты JUnit
* Настроить connection pool [HikariCP](https://brettwooldridge.github.io/HikariCP/)
* Вынести часть логики из @Controller в @Service
* Расставить ограничения на значения базы данных
* Перехват ошибок транзакций через ```@ControllerAdvice``` и ```@ExceptionHandler```
* Создать страницу с описанием ошибок /error и /403
* Сделать загрузку картинок
* Отобразить количество заказов в nav bar
* Страница с отображением заказов пользователей в реальном времени (через WebSocket)
* Изменить таблицу категорий товаров ItemList. Создание и назначение категории товару через связь ```@ManyToMany```
* Вынести данные из ```.java``` файлов в ```.properties``` файлы
* Привести в порядок настрйки ограничения доступа Spring Security

# Frameworks and libraries

* [Spring Boot](http://projects.spring.io/spring-boot/)
* Spring Data JPA
* [Thymeleaf](www.thymeleaf.org)
* Hibernate ORM
* Hibernate Validator
* Bootstrap