FROM openjdk:17
LABEL org.opencontainers.image.authors="artemjevnikita@ya.ru"

ADD ./target/basket-app.jar /app/
CMD ["java", "-jar", "/app/basket-app.jar"]

EXPOSE 8080