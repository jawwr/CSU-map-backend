FROM gradle:8.2.1-alpine AS build
COPY . /src
WORKDIR /src
RUN gradle clean build --no-daemon -x test

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /src/build/libs/*.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "app.jar"]