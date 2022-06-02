FROM openjdk:17
ADD target/naming-service-0.0.1-SNAPSHOT.jar spring-naming-service.jar
EXPOSE 8761
ENTRYPOINT  ["java" , "-jar" , "spring-naming-service.jar"]