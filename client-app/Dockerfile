FROM maven:latest AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests


FROM openjdk:17
LABEL org.opencontainers.image.authors="artemjevnikita@ya.ru"

COPY --from=build /project/target/client-app.jar /app/client-app.jar
CMD ["java", "-jar", "/app/client-app.jar"]

EXPOSE 8080