# FROM maven:3.8.4-openjdk-17 AS build


# # Set the working directory
# WORKDIR /app

# # Copy the pom.xml and source code
# COPY pom.xml .
# RUN mvn dependency:go-offline

# COPY src ./src
# RUN mvn clean package -DskipTests

# FROM openjdk:17-jdk-slim
# # Set the working directory
# WORKDIR /app
# # Copy the jar file from the build stage
# COPY --from=build /app/target/system-0.0.1-SNAPSHOT.jar .
# # Expose the application port
# EXPOSE 8080
# ENTRYPOINT [ "java","-jar","system-0.0.1-SNAPSHOT.jar" ]

FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
