FROM ubuntu:lastest AS build

RUN apt-get update
RUN apt-get install openjdk-17 -y
COPY . .

RUN pt-get install maven -y
RUN mvn clean install

FROM openjdk-17-slim

EXPOSE 8080

COPY --from=build /target/helpdesk-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]