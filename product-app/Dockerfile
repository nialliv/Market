FROM openjdk:17
LABEL org.opencontainers.image.authors="artemjevnikita@ya.ru"

ADD ./target/product-app.jar /app/
CMD ["java", "-jar", "/app/product-app.jar"]

EXPOSE 8080