FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/spring-boot.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]