FROM openjdk:17-alpine

VOLUME /tmp

ADD ./target/api-movie-0.0.1-SNAPSHOT.jar movie-service.jar

RUN apk add --update --no-cache curl

ENTRYPOINT ["java", "-jar", "/movie-service.jar"]