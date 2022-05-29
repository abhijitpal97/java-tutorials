FROM openjdk:17
ADD target/spring-cloud-gateway-0.0.1-SNAPSHOT.jar spring-cloud-gateway.jar
EXPOSE 8080
ENTRYPOINT  ["java" , "-jar" , "spring-cloud-gateway.jar"]