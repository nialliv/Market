# FROM maven:latest AS build
# RUN mkdir /project
# COPY . /project
# WORKDIR /project
# RUN mvn clean package -DskipTests


FROM openjdk:17
LABEL org.opencontainers.image.authors="artemjevnikita@ya.ru"

# COPY --from=build /project/target/market.jar /app/market.jar
COPY target/market.jar /app/market.jar
CMD ["java", "-jar", "/app/market.jar"]

EXPOSE 8080