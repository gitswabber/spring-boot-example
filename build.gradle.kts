plugins {
    java
    idea
    id("org.springframework.boot") version "2.2.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    id("net.ltgt.apt") version "0.20"
}

apply(from = "versions.gradle.kts")

group = "com.swabber"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.h2database:h2:${rootProject.extra["h2.version"]}")

    compileOnly("org.projectlombok:lombok:${rootProject.extra["lombok.version"]}")
    annotationProcessor("org.projectlombok:lombok:${rootProject.extra["lombok.version"]}")

    implementation("org.mapstruct:mapstruct:${rootProject.extra["mapstruct.version"]}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${rootProject.extra["mapstruct.version"]}")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_13
    targetCompatibility = JavaVersion.VERSION_13
}