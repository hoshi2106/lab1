
# Maven with Java 17
FROM maven:3.9.9-eclipse-temurin-17

# Set Maven project directory
WORKDIR /app

# Copy Maven configuration
COPY pom.xml .

# Download Maven dependencies
RUN mvn dependency:go-offline

# Copy Java source and test files
COPY src ./src

# Run Maven tests and package
RUN mvn clean package

# Execute Bank main class
CMD ["java", "-cp", "target/classes", "maven.maven.Bank"]
