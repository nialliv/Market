FROM openjdk:17
LABEL org.opencontainers.image.authors="artemjevnikita@ya.ru"

ADD ./target/backend.jar /app/
CMD ["java", "-jar", "/app/backend.jar"]

EXPOSE 8080