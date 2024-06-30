# Currency Service
This microservice provides API for fetching data from NBRB API and save it to the service's database. You can then retrieve info about rate of fetched currencies for the specified date.

## Used technologies:
- Java 17
- Spring Framework (Boot, Data)
- Hibernate ORM
- H2 Database
- Liquibase
- Mapstruct
- Swagger

## Swagger:
You can find a comprehensive API description, as well as test endpoints, on the following OpenAPI docs link:
http://localhost:8080/swagger-ui.html

## How to run it:
```sh
mvn spring-boot:run
```
The server runs on 8080 port.