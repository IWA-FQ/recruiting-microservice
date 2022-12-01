FROM gradle:7-jdk17 as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17-jdk-alpine
COPY --from=build /home/gradle/src/build/libs/recruiting-microservice-0.0.1-SNAPSHOT.jar /app/recruiting.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/recruiting.jar"]