FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
COPY target/humanoo-book-backend-1.0-SNAPSHOT.jar  humanoo-book-backend-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD [ "java","-jar","humanoo-book-backend-1.0-SNAPSHOT.jar"]