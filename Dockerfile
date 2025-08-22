FROM openjdk:17-jdk-slim

WORKDIR /app

# Install Gradle
RUN apt-get update && apt-get install -y wget unzip && \
    wget https://services.gradle.org/distributions/gradle-8.4-bin.zip && \
    unzip gradle-8.4-bin.zip && \
    mv gradle-8.4 /opt/gradle && \
    rm gradle-8.4-bin.zip && \
    rm -rf /var/lib/apt/lists/*

ENV PATH="/opt/gradle/bin:${PATH}"

# Copy gradle files and download dependencies
COPY build.gradle settings.gradle ./
RUN gradle build --no-daemon || return 0

# Copy source code
COPY src ./src

# Build application
RUN gradle clean build -x test --no-daemon

# Run application
CMD ["java", "-jar", "build/libs/banking-system-1.0-SNAPSHOT.jar"]