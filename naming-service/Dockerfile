FROM openjdk:17
ADD target/naming-service-0.0.1-SNAPSHOT.jar spring-naming-service.jar
EXPOSE 8080
ENTRYPOINT  ["java" , "-jar" , "spring-naming-service.jar"]