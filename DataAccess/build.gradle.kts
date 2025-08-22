plugins {
    id("java")
}

group = "ru.TheEmperorZurg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JPA/Hibernate
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.0")
    
    // Lombok
    implementation("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}