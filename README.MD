# JSO REGISTRATION AGENT
This application serves as an automation tool to register to JSO badminton club training sessions.

#### Used Technologies
* Java 23
* Spring Boot
* PostgreSQL
* Docker and Docker Compose
* Liquibase (was picked over Flyway doe to support for rollbacks)
* TestContainers
___

### RUNNING THE APPLICATION ON YOUR MACHINE
1. Clone the repository.
2. Start `./docker-compose.yaml`. This will start a PostgreSQL database on port `5432` and execute local database 
    initialization script `./init-db.sql`.
3. You can connect to the local database with:
    * URL: `jdbc:postgresql://localhost:5432/jso_reg_agent`
    * Username: `dml`
    * Password: `dml`

#### About the database
There are two users automatically created in `./init-db.sql`: ddl and dml. ddl user is used for schema creation and
manipulation, using Liquibase and dml user is used for data manipulation by application.

Master username and password for local environment are `local-master` and `local-master` respectively, as 
described in the `./docker-compose.yaml`.

#### Testcontainers reuse
In order for testcontainers' reuse property work properly, local machine's user folder must contain 
.testcontainers.properties file with the following property:
```
...your other peroperties...
testcontainers.reuse.enable=true
```