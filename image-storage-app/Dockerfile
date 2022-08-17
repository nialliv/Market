FROM openjdk:17
LABEL org.opencontainers.image.authors="artemjevnikita@ya.ru"

ADD ./target/image-storage-app.jar /app/
CMD ["java", "-jar", "/app/image-storage-app.jar"]

EXPOSE 8080