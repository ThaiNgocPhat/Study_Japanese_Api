# ===== Build stage =====
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /build
COPY . .
RUN mvn clean install -pl vocabulary-lesson -am -DskipTests

# ===== Runtime stage =====
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /build/vocabulary-lesson/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
