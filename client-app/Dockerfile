FROM openjdk:17
LABEL org.opencontainers.image.authors="artemjevnikita@ya.ru"

ADD ./target/client-app.jar /app/
CMD ["java", "-jar", "/app/client-app.jar"]

EXPOSE 8080