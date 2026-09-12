# FizzBuzz API

A small Spring Boot service that generates configurable FizzBuzz sequences and tracks the most frequently requested parameter set.

Requires Java 21. Start it locally with:

```powershell
.\mvnw.cmd spring-boot:run
```

Generate a sequence:

```text
GET /api/v1/fizzbuzz?int1=3&int2=5&limit=15&str1=fizz&str2=buzz
```

Example response:

```json
["1","2","fizz","4","buzz",...,"fizzbuzz"]
```

View the most frequently requested successful sequence:

```text
GET /actuator/statistics
```

Run the test suite with `./mvnw.cmd verify`, or start the container with `docker compose up --build`.
