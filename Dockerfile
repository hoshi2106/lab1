
FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

# Run tests and package
RUN mvn clean package

# Execute Bank application
CMD ["java", "-cp", "target/classes", "maven.maven.Bank"]
