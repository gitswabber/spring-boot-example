# spring-boot-example
This project is a sample Spring boot project using Gradle.

## Environment
* JDK 13
* Spring boot 2.2.2.RELEASE
* Gradle 6.0.1
#### Database
* H2
#### Other dependencies
* Lombok
* MapStruct
* Guava
* Junit5

## How to run
~~~~
./gradlew bootRun
~~~~

## URL
~~~~
curl -X GET http://localhost:8080/hello
~~~~
~~~~
curl -X GET http://localhost:8080/users

curl -X GET http://localhost:8080/users/{id}

curl -X POST http://localhost:8080/users -d 'firstName={firstName}&lastName={lastName}&age={age}'

curl -X PUT http://localhost:8080/users/{id} -d 'firstName={firstName}&lastName={lastName}&age={age}'

curl -X PATCH http://localhost:8080/users/{id} -d 'age={age}'

curl -X DELETE http://localhost:8080/users/{id}
~~~~